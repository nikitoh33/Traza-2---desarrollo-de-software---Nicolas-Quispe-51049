import java.util.ArrayList;
import java.util.List;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Provincia {
    private Long id;  // 👈 agregado para repositorio
    private String Nombre;
    private Pais pais;
    private List<Localidad> localidades = new ArrayList<>();

    public Provincia(String nombre) {
        this.Nombre = nombre;
        this.localidades = new ArrayList<>();
    }

    public void AgregarLocalidad(Localidad localidad){
        this.localidades.add(localidad);
    }

    public String MostrarProvincia() {
        return "\n✦Se creo la provincia: " + Nombre + "\nLas localidades de la provincia "+Nombre+" son: "+localidades ;
    }
}