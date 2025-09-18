import lombok.*;
import lombok.Builder;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class UnidadMedida {
    private Long id;
    private String denominacion;
}
