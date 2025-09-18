import lombok.*;
import lombok.experimental.SuperBuilder;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@SuperBuilder
public class Articulo {
    protected Long id;
    protected String denominacion;
    protected Double precioVenta;
    protected UnidadMedida unidadMedida;
    private Categoria categoria;

    @Builder.Default
    protected Set<ImagenArticulo> imagenes = new HashSet<>();
}
