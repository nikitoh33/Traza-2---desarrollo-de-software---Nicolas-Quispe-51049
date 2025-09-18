

import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class InMemoryRepository<T> {

    private final Map<Long, T> registros = new HashMap<>();
    private final AtomicLong generadorId = new AtomicLong();

    public T save(T entidad) {
        long id = generadorId.incrementAndGet();
        try {
            Method setId = entidad.getClass().getMethod("setId", Long.class);
            setId.invoke(entidad, id);
            System.out.println(entidad.getClass().getName() + " guardada con ID: " + id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        registros.put(id, entidad);
        return entidad;
    }

    public Optional<T> findById(Long id) {
        return Optional.ofNullable(registros.get(id));
    }

    public List<T> findAll() {
        return new ArrayList<>(registros.values());
    }

    public Optional<T> update(Long id, T entidadActualizada) {
        if (!registros.containsKey(id)) {
            return Optional.empty();
        }
        try {
            Method setId = entidadActualizada.getClass().getMethod("setId", Long.class);
            setId.invoke(entidadActualizada, id);
            registros.put(id, entidadActualizada);
            return Optional.of(entidadActualizada);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    public Optional<T> delete(Long id) {
        if (!registros.containsKey(id)) {
            return Optional.empty();
        }
        return Optional.ofNullable(registros.remove(id));
    }

    public List<T> findByField(String nombreCampo, Object valor) {
        List<T> encontrados = new ArrayList<>();
        try {
            for (T entidad : registros.values()) {
                Method getCampo = entidad.getClass().getMethod("get" + capitalize(nombreCampo));
                Object valorCampo = getCampo.invoke(entidad);
                if (valorCampo != null && valorCampo.equals(valor)) {
                    encontrados.add(entidad);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encontrados;
    }

    private String capitalize(String texto) {
        if (texto == null || texto.isEmpty()) return texto;
        return texto.substring(0, 1).toUpperCase() + texto.substring(1);
    }
}
