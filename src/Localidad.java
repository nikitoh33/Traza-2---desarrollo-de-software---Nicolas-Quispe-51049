import java.util.ArrayList;
import java.util.List;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Localidad {
    private Long id;  // 👈 agregado para repositorio
    private String Nombre;
    private Provincia provincia;
    private List<Domicilio> domicilios = new ArrayList<>();

    public Localidad(String nombre) {
        this.Nombre = nombre;
        this.domicilios = new ArrayList<>();
    }

    public void AgregarDomicilio(Domicilio domicilio){
        this.domicilios.add(domicilio);
    }

    public String MostrarDomicilios(){
        return "Se creo la Localidad "+Nombre+" los domicilios de "+Nombre+" son: "+domicilios;
    }

    public String MostrarLocalidad() {
        return "\n✦Se creo la Localidad: " + Nombre + "\nLos domicilios de la localidad "+Nombre+" son: "+domicilios;
    }
}