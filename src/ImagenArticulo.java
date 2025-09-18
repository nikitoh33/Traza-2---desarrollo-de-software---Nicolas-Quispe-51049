import lombok.*;
import lombok.Builder;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ImagenArticulo {
    private Long id;
    private String name;
    private String url;
}
