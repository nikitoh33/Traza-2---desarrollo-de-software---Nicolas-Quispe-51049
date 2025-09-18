import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@Builder

public class Categoria {
    private Long id;
    private String denominacion;
    private boolean esInsumo;

    @Builder.Default
    private Set<Articulo> articulos = new HashSet<>();

    @Builder.Default
    private Set<Categoria> subCategorias = new HashSet<>();

    private Categoria categoriaPadre;
}
