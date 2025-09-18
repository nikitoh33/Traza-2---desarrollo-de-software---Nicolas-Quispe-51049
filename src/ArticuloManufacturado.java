import lombok.*;
import lombok.experimental.SuperBuilder;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
@SuperBuilder
public class ArticuloManufacturado extends Articulo {
    private String descripcion;
    private Integer tiempoEstimadoMinutos;
    private String preparacion;

    @Builder.Default
    private Set<ArticuloManufacturadoDetalle> articuloManufacturadoDetalles = new HashSet<>();
}
