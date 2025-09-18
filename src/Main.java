import java.time.LocalTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        // TRAZA 1

        System.out.println("========== TRAZA 1 (Empresas, Paises, etc.) ==========");

        Pais argentina = new Pais("Argentina");
        Provincia buenosAires = new Provincia("Buenos Aires");
        Provincia cordoba = new Provincia("Cordoba");

        argentina.AgregarProvincia(buenosAires);
        argentina.AgregarProvincia(cordoba);

        Localidad caba = new Localidad("CABA");
        Localidad laPlata = new Localidad("La Plata");
        Localidad cordobaCapital = new Localidad("Córdoba Capital");
        Localidad villaCarlosPaz = new Localidad("Villa Carlos Paz");

        buenosAires.AgregarLocalidad(caba);
        buenosAires.AgregarLocalidad(laPlata);
        cordoba.AgregarLocalidad(cordobaCapital);
        cordoba.AgregarLocalidad(villaCarlosPaz);

        Domicilio domicilio1 = new Domicilio("Calle Huamhuaca", 9597, 5525);
        caba.AgregarDomicilio(domicilio1);

        Domicilio domicilio2 = new Domicilio("Calle Falsa", 4953, 5550);
        caba.AgregarDomicilio(domicilio2);

        Domicilio domicilio3 = new Domicilio("Calle Verdadera", 4543, 2550);
        cordobaCapital.AgregarDomicilio(domicilio3);

        Domicilio domicilio4 = new Domicilio("Calle Tiraso", 4354, 5555);
        villaCarlosPaz.AgregarDomicilio(domicilio4);

        System.out.println(argentina.MostrarPais());
        System.out.println(buenosAires.MostrarProvincia());
        System.out.println(cordoba.MostrarProvincia());
        System.out.println(caba.MostrarLocalidad());
        System.out.println(laPlata.MostrarLocalidad());
        System.out.println(cordobaCapital.MostrarLocalidad());
        System.out.println(villaCarlosPaz.MostrarLocalidad());

        Sucursal sucursal1 = new Sucursal("Sucursal Nikitoh33", LocalTime.of(9,0), LocalTime.of(18,0), true);
        sucursal1.AsignarDomicilioConSucursal(domicilio2);
        System.out.println(sucursal1.MostrarSucursal());
        sucursal1.MostrarDomicilioAsignado();

        InMemoryRepository<Empresa> repoEmpresa = new InMemoryRepository<>();
        Empresa empresa1 = new Empresa("MiEmpresa", "SRL", 123456789, "logo.png");
        repoEmpresa.save(empresa1);

        System.out.println("\nEmpresas guardadas en repositorio:");
        System.out.println(repoEmpresa.findAll());

        repoEmpresa.findById(1L).ifPresent(e ->
                System.out.println("Empresa encontrada: " + e.MostrarEmpresa())
        );



        // TRAZA 2

        System.out.println("\n========== TRAZA 2 (Artículos, Categorías, etc.) ==========");

        InMemoryRepository<Categoria> categoriaRepo = new InMemoryRepository<>();
        InMemoryRepository<UnidadMedida> unidadRepo = new InMemoryRepository<>();
        InMemoryRepository<ArticuloInsumo> insumoRepo = new InMemoryRepository<>();
        InMemoryRepository<ArticuloManufacturado> manufacturadoRepo = new InMemoryRepository<>();

        // Categorías
        Categoria pizzas = Categoria.builder().denominacion("Pizzas").esInsumo(false).build();
        Categoria lomos = Categoria.builder().denominacion("Lomos").esInsumo(false).build();
        Categoria sandwiches = Categoria.builder().denominacion("Sandwiches").esInsumo(false).build();
        Categoria insumos = Categoria.builder().denominacion("Insumos").esInsumo(true).build();

        categoriaRepo.save(pizzas);
        categoriaRepo.save(lomos);
        categoriaRepo.save(sandwiches);
        categoriaRepo.save(insumos);

        // Unidades de medida
        UnidadMedida kg = UnidadMedida.builder().denominacion("Kilogramo").build();
        UnidadMedida litro = UnidadMedida.builder().denominacion("Litro").build();
        UnidadMedida gramos = UnidadMedida.builder().denominacion("Gramos").build();

        unidadRepo.save(kg);
        unidadRepo.save(litro);
        unidadRepo.save(gramos);

        // Artículos insumos
        ArticuloInsumo sal = ArticuloInsumo.builder()
                .denominacion("Sal")
                .precioCompra(1.0)
                .stockActual(100).stockMinimo(10).stockMaximo(200)
                .esParaElaborar(true).unidadMedida(gramos).categoria(insumos).build();

        ArticuloInsumo harina = ArticuloInsumo.builder()
                .denominacion("Harina")
                .precioCompra(0.5)
                .stockActual(50).stockMinimo(5).stockMaximo(100)
                .esParaElaborar(true).unidadMedida(kg).categoria(insumos).build();

        ArticuloInsumo aceite = ArticuloInsumo.builder()
                .denominacion("Aceite")
                .precioCompra(3.0)
                .stockActual(30).stockMinimo(3).stockMaximo(60)
                .esParaElaborar(true).unidadMedida(litro).categoria(insumos).build();

        ArticuloInsumo carne = ArticuloInsumo.builder()
                .denominacion("Carne")
                .precioCompra(5.0)
                .stockActual(20).stockMinimo(2).stockMaximo(40)
                .esParaElaborar(true).unidadMedida(kg).categoria(insumos).build();

        insumoRepo.save(sal);
        insumoRepo.save(harina);
        insumoRepo.save(aceite);
        insumoRepo.save(carne);

        // Imágenes
        ImagenArticulo img1 = ImagenArticulo.builder().name("imagen1").url("hawaina1.jpg").build();
        ImagenArticulo img2 = ImagenArticulo.builder().name("imagen2").url("hawaina2.jpg").build();
        ImagenArticulo img3 = ImagenArticulo.builder().name("imagen3").url("hawaina3.jpg").build();
        ImagenArticulo img4 = ImagenArticulo.builder().name("imagen4").url("lomo1.jpg").build();
        ImagenArticulo img5 = ImagenArticulo.builder().name("imagen5").url("lomo2.jpg").build();
        ImagenArticulo img6 = ImagenArticulo.builder().name("imagen6").url("lomo3.jpg").build();

        // Detalles
        ArticuloManufacturadoDetalle detallePizza1 = ArticuloManufacturadoDetalle.builder().cantidad(1).articuloInsumo(sal).build();
        ArticuloManufacturadoDetalle detallePizza2 = ArticuloManufacturadoDetalle.builder().cantidad(2).articuloInsumo(harina).build();
        ArticuloManufacturadoDetalle detallePizza3 = ArticuloManufacturadoDetalle.builder().cantidad(1).articuloInsumo(aceite).build();

        ArticuloManufacturadoDetalle detalleLomo1 = ArticuloManufacturadoDetalle.builder().cantidad(1).articuloInsumo(sal).build();
        ArticuloManufacturadoDetalle detalleLomo2 = ArticuloManufacturadoDetalle.builder().cantidad(1).articuloInsumo(aceite).build();
        ArticuloManufacturadoDetalle detalleLomo3 = ArticuloManufacturadoDetalle.builder().cantidad(1).articuloInsumo(carne).build();

        // Manufacturados
        ArticuloManufacturado pizzaHawaina = ArticuloManufacturado.builder()
                .denominacion("Pizza Hawaina")
                .descripcion("Pizza con piña")
                .tiempoEstimadoMinutos(20)
                .preparacion("Hornear 20 minutos")
                .categoria(pizzas)
                .build();
        pizzaHawaina.getImagenes().add(img1);
        pizzaHawaina.getImagenes().add(img2);
        pizzaHawaina.getImagenes().add(img3);
        pizzaHawaina.getArticuloManufacturadoDetalles().add(detallePizza1);
        pizzaHawaina.getArticuloManufacturadoDetalles().add(detallePizza2);
        pizzaHawaina.getArticuloManufacturadoDetalles().add(detallePizza3);

        ArticuloManufacturado lomoCompleto = ArticuloManufacturado.builder()
                .denominacion("Lomo Completo")
                .descripcion("Lomo con todo")
                .tiempoEstimadoMinutos(15)
                .preparacion("Plancha y armado")
                .categoria(lomos)
                .build();
        lomoCompleto.getImagenes().add(img4);
        lomoCompleto.getImagenes().add(img5);
        lomoCompleto.getImagenes().add(img6);
        lomoCompleto.getArticuloManufacturadoDetalles().add(detalleLomo1);
        lomoCompleto.getArticuloManufacturadoDetalles().add(detalleLomo2);
        lomoCompleto.getArticuloManufacturadoDetalles().add(detalleLomo3);

        manufacturadoRepo.save(pizzaHawaina);
        manufacturadoRepo.save(lomoCompleto);

        
        // Resultados pedidos

        System.out.println("\nTodas las categorías:");
        categoriaRepo.findAll().forEach(System.out::println);

        System.out.println("\nTodos los insumos:");
        insumoRepo.findAll().forEach(System.out::println);

        System.out.println("\nTodos los manufacturados:");
        manufacturadoRepo.findAll().forEach(System.out::println);

        System.out.println("\nBuscar manufacturado por ID:");
        manufacturadoRepo.findById(1L).ifPresent(System.out::println);

        System.out.println("\nActualizar manufacturado por ID:");
        ArticuloManufacturado actualizado = ArticuloManufacturado.builder()
                .denominacion("Pizza Hawaina Actualizada")
                .descripcion("Pizza con piña y extra queso")
                .tiempoEstimadoMinutos(25)
                .preparacion("Hornear 25 minutos")
                .categoria(pizzas)
                .build();
        manufacturadoRepo.update(1L, actualizado);
        manufacturadoRepo.findById(1L).ifPresent(System.out::println);

        System.out.println("\nEliminar manufacturado por ID:");
        manufacturadoRepo.delete(2L);
        manufacturadoRepo.findAll().forEach(System.out::println);
    }
}
