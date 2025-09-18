import java.util.ArrayList;
import java.util.List;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Empresa {

    private Long id;   // 👈 agregado para el repositorio
    private String Nombre;
    private String RazonSocial;
    private Integer Cuit;
    private String Logo;

    private List<Sucursal> sucursales = new ArrayList<>(); //relacion 1:N

    public Empresa(String nombre, String razonSocial, Integer cuit, String logo) {
        Nombre = nombre;
        RazonSocial = razonSocial;
        Cuit = cuit;
        Logo = logo;
    }

    public String MostrarEmpresa(){
        return "Datos de la empresa: "+Nombre+" ;"+RazonSocial+ " ;"+Cuit+ " ;"+Logo+ "----";
    }

    public String MostrarSucursales(){
        return "Se creo la empresa "+Nombre+" las sucursales de "+Nombre+" son: "+sucursales;
    }

    public void AgregarSucursal(Sucursal sucursales){
        this.sucursales.add(sucursales);
    }
}