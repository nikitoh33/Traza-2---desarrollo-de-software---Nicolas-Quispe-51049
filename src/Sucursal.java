import java.time.LocalTime;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Sucursal {
    private Long id;  // 👈 agregado para repositorio
    private String Nombre;
    private LocalTime HorarioApertura;
    private LocalTime HorarioCierre;
    private Boolean es_Casa_Matriz;

    private Empresa empresa;    // relación 1:1
    private Domicilio domicilio; // relación 1:1

    public Sucursal(String nombre, LocalTime horarioApertura, LocalTime horarioCierre, Boolean es_Casa_Matriz) {
        this.Nombre = nombre;
        this.HorarioApertura = horarioApertura;
        this.HorarioCierre = horarioCierre;
        this.es_Casa_Matriz = es_Casa_Matriz;
    }

    public String MostrarSucursal() {
        return "Datos de la sucursal: " + Nombre + " ; Apertura: " + HorarioApertura + " ; Cierre: " + HorarioCierre + " ; ¿Es casa matriz?: " + es_Casa_Matriz + " ----";
    }

    public void AsignarDomicilioConSucursal(Domicilio domicilio){
        this.domicilio = domicilio;
    }

    public void MostrarDomicilioAsignado(){
        System.out.println("Esta sucursal pertenece a:\n " + domicilio);
    }
}