import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Domicilio {
    private Long id;  // 👈 agregado para repositorio
    private String Calle;
    private Integer Numero;
    private Integer CodPostal;
    private Localidad localidad;

    public Domicilio(String calle, Integer numero, Integer codPostal) {
        this.Calle = calle;
        this.Numero = numero;
        this.CodPostal = codPostal;
    }

    @Override
    public String toString(){
        return "Datos Domicilio: "+Numero+"; "+Calle+ "; "+CodPostal+ "---";
    }
}