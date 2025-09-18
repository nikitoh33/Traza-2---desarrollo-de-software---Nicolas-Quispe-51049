import java.util.ArrayList;
import java.util.List;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Pais {
    private Long id;  // 👈 agregado para repositorio
    private String Nombre;
    private List<Provincia> provincias = new ArrayList<>();

    public Pais(String nombre) {
        this.Nombre = nombre;
        this.provincias = new ArrayList<>();
    }

    public void AgregarProvincia(Provincia provincia){
        this.provincias.add(provincia);
    }

    public String MostrarPais() {
        return "\n✦Se creo el pais: " + Nombre + "\nLas provincias del pais "+Nombre+" son: "+provincias ;
    }
}