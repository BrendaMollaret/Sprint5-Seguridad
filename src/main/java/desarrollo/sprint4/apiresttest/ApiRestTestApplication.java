package desarrollo.sprint4.apiresttest;


import desarrollo.sprint4.apiresttest.Entity.*;
import desarrollo.sprint4.apiresttest.Enumeration.EstadoPedido;
import desarrollo.sprint4.apiresttest.Enumeration.TipoEnvio;
import desarrollo.sprint4.apiresttest.Enumeration.FormaPago;
import desarrollo.sprint4.apiresttest.Enumeration.TipoFactura;
import desarrollo.sprint4.apiresttest.Repository.*;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootApplication
public class ApiRestTestApplication {

    @Autowired
    FacturaRepository facturaRepository;

    @Autowired
    UsuarioRepository usuarioRepository;


    public static void main(String[] args) {
        SpringApplication.run(ApiRestTestApplication.class, args);
        System.out.println("\n\n---------ESTOY FUNCIONANDO---------");
    }

    @Transactional
    @Bean
    CommandLineRunner init() {
        return args -> {


            //----------- CREACIÓN DE LOCALIDAD -----------
            Localidad localidadGodoyCruz = Localidad.builder()
                    .nombreLocalidad("Godoy cruz")
                    .codigoPostal(5501)
                    .build();


            //----------- CREACIÓN DE DOMICILIO -----------
            Domicilio domicilio1 = Domicilio.builder()
                    .calle("CalleVerdadera")
                    .nroCalle(550)
                    .pisoDpto(0)
                    .nroDpto(2)
                    .fechaHoraAltaDomicilio(LocalDate.now())
                    .build();

            Domicilio domicilio2 = Domicilio.builder()
                    .calle("CalleFalsa")
                    .nroCalle(110)
                    .pisoDpto(1)
                    .nroDpto(3)
                    .fechaHoraAltaDomicilio(LocalDate.now())
                    .build();

            domicilio1.setLocalidad(localidadGodoyCruz);
            domicilio2.setLocalidad(localidadGodoyCruz);


            //----------- CREACIÓN DE CLIENTE -----------
            Cliente cliente1 = Cliente.builder()
                    .nombre("Juan")
                    .apellido("ApellidoJuan")
                    .fechaHoraAltaCliente(LocalDate.now())
                    .mail("juanjuanapellido@mail.com")
                    .telefono("555-555")
                    .build();

            cliente1.agregarDomicilio(domicilio1);
            cliente1.agregarDomicilio(domicilio2);

            //----------- CREACIÓN DE USUARIO -----------
            Usuario usuario1 = Usuario.builder()
                    .username("Usuario123")
                    .auth0Id("0987")
                    .fechaAltaUsuario(LocalDate.now())
                    .build();

            usuario1.setCliente(cliente1);
            usuarioRepository.save(usuario1);


            //----------- CREACIÓN DE UNIDAD DE MEDIDA -----------

            UnidadMedida unidadMedidaGr = UnidadMedida.builder()
                    .nombreUnidadMedida("Gramos")
                    .abrevitaturaUnidadMedida("gr")
                    .fechaAltaUnidadMedida(LocalDate.now())
                    .build();

            UnidadMedida unidadMedidaMl = UnidadMedida.builder()
                    .nombreUnidadMedida("Mililitros")
                    .abrevitaturaUnidadMedida("ml")
                    .fechaAltaUnidadMedida(LocalDate.now())
                    .build();

            //----------- CREACIÓN DE RUBROS -----------

            Rubro rubroVerduleria = Rubro.builder()
                    .nombreRubro("Verduleria")
                    .fechaAltaProducto(LocalDate.now())
                    .build();

            Rubro rubroVerdura = Rubro.builder()
                    .nombreRubro("Verdura")
                    .fechaAltaProducto(LocalDate.now())
                    .build();

            rubroVerdura.setRubroPadre(rubroVerduleria);
            rubroVerduleria.agregarRubroHijo(rubroVerdura);


            Rubro rubroFiambreria = Rubro.builder()
                    .nombreRubro("Fiambreria")
                    .fechaAltaProducto(LocalDate.now())
                    .build();

            Rubro rubroQueso = Rubro.builder()
                    .nombreRubro("Queso")
                    .fechaAltaProducto(LocalDate.now())
                    .build();


            rubroQueso.setRubroPadre(rubroFiambreria);
            rubroFiambreria.agregarRubroHijo(rubroQueso);

            Rubro rubroCarne = Rubro.builder()
                    .nombreRubro("Carne")
                    .fechaAltaProducto(LocalDate.now())
                    .build();

            Rubro rubroVacuna = Rubro.builder()
                    .nombreRubro("Vacuna")
                    .fechaAltaProducto(LocalDate.now())
                    .build();

            rubroVacuna.setRubroPadre(rubroCarne);
            rubroCarne.agregarRubroHijo(rubroVacuna);



            Rubro rubroBebida = Rubro.builder()
                    .nombreRubro("Bebida")
                    .fechaAltaProducto(LocalDate.now())
                    .build();

            Rubro rubroConGas = Rubro.builder()
                    .nombreRubro("Con gas")
                    .fechaAltaProducto(LocalDate.now())
                    .build();

            Rubro rubroSinGas = Rubro.builder()
                    .nombreRubro("Sin gas")
                    .fechaAltaProducto(LocalDate.now())
                    .build();

            rubroBebida.agregarRubroHijo(rubroConGas);
            rubroBebida.agregarRubroHijo(rubroSinGas);

            rubroConGas.setRubroPadre(rubroBebida);
            rubroSinGas.setRubroPadre(rubroBebida);



            //----------- CREACIÓN ARTICULOINSUMO -----------

            ArticuloInsumo articuloInsumoLechuga = ArticuloInsumo.builder()
                    .nombreArticuloInsumo("Lechuga")
                    .precioCompra(BigDecimal.valueOf(45))
                    .stockMinimo(500)
                    .stockActual(800)
                    .urlImagen("imagenLechuga")
                    .fechaHoraAltaArticuloInsumo(LocalDate.now())
                    .build();

            articuloInsumoLechuga.setUnidadMedida(unidadMedidaGr);
            articuloInsumoLechuga.setRubro(rubroVerdura);


            ArticuloInsumo articuloInsumoCheddar = ArticuloInsumo.builder()
                    .nombreArticuloInsumo("Cheddar")
                    .precioCompra(BigDecimal.valueOf(70))
                    .stockMinimo(500)
                    .stockActual(1000)
                    .urlImagen("imagenCheddar")
                    .fechaHoraAltaArticuloInsumo(LocalDate.now())
                    .build();

            articuloInsumoCheddar.setUnidadMedida(unidadMedidaGr);
            articuloInsumoCheddar.setRubro(rubroQueso);



            ArticuloInsumo articuloInsumoMedallon = ArticuloInsumo.builder()
                    .nombreArticuloInsumo("Medallon")
                    .precioCompra(BigDecimal.valueOf(100))
                    .stockMinimo(4000)
                    .stockActual(10000)
                    .urlImagen("imagenCheddar")
                    .fechaHoraAltaArticuloInsumo(LocalDate.now())
                    .build();

            articuloInsumoMedallon.setUnidadMedida(unidadMedidaGr);
            articuloInsumoMedallon.setRubro(rubroVacuna);


            ArticuloInsumo articuloInsumoCocaCola = ArticuloInsumo.builder()
                    .nombreArticuloInsumo("CocaCola")
                    .precioCompra(BigDecimal.valueOf(70))
                    .stockMinimo(100)
                    .stockActual(600)
                    .urlImagen("imagenCoca")
                    .fechaHoraAltaArticuloInsumo(LocalDate.now())
                    .build();
            articuloInsumoCocaCola.setUnidadMedida(unidadMedidaMl);

            ArticuloInsumo articuloInsumoFanta = ArticuloInsumo.builder()
                    .nombreArticuloInsumo("Fanta")
                    .precioCompra(BigDecimal.valueOf(50))
                    .stockMinimo(100)
                    .stockActual(700)
                    .urlImagen("imagenFanta")
                    .fechaHoraAltaArticuloInsumo(LocalDate.now())
                    .build();

            ArticuloInsumo articuloInsumoAgua = ArticuloInsumo.builder()
                    .nombreArticuloInsumo("Agua")
                    .precioCompra(BigDecimal.valueOf(10))
                    .stockMinimo(100)
                    .stockActual(500)
                    .urlImagen("imagenAgua")
                    .fechaHoraAltaArticuloInsumo(LocalDate.now())
                    .build();


            articuloInsumoFanta.setUnidadMedida(unidadMedidaMl);
            articuloInsumoAgua.setUnidadMedida(unidadMedidaMl);

            articuloInsumoCocaCola.setRubro(rubroConGas);
            articuloInsumoFanta.setRubro(rubroConGas);
            articuloInsumoAgua.setRubro(rubroSinGas);







            //----------- CREACIÓN DE UN DETALLEARTICULOMANUFACTURADO -----------

            DetalleArticuloManufacturado detalleArticuloManufacturado1 = DetalleArticuloManufacturado.builder()
                    .cantidad(5)
                    .build();

            DetalleArticuloManufacturado detalleArticuloManufacturado2 = DetalleArticuloManufacturado.builder()
                    .cantidad(10)
                    .build();

            detalleArticuloManufacturado1.setArticuloInsumo(articuloInsumoLechuga);
            detalleArticuloManufacturado2.setArticuloInsumo(articuloInsumoCheddar);

            //                     ---------------------

            DetalleArticuloManufacturado detalleArticuloManufacturado3 = DetalleArticuloManufacturado.builder()
                    .cantidad(500)
                    .build();

            DetalleArticuloManufacturado  detalleArticuloManufacturado4 = DetalleArticuloManufacturado.builder()
                    .cantidad(1000)
                    .build();

            DetalleArticuloManufacturado  detalleArticuloManufacturado5 = DetalleArticuloManufacturado.builder()
                    .cantidad(500)
                    .build();

            detalleArticuloManufacturado3.setArticuloInsumo(articuloInsumoCocaCola);
            detalleArticuloManufacturado4.setArticuloInsumo(articuloInsumoFanta);
            detalleArticuloManufacturado5.setArticuloInsumo(articuloInsumoAgua);

            //                   ------------------------------


            DetalleArticuloManufacturado  detalleArticuloManufacturado6 = DetalleArticuloManufacturado.builder()
                    .cantidad(100)
                    .build();

            detalleArticuloManufacturado6.setArticuloInsumo(articuloInsumoMedallon);

            //                   ------------------------------

            DetalleArticuloManufacturado  detalleArticuloManufacturado7 = DetalleArticuloManufacturado.builder()
                    .cantidad(10)
                    .build();

            DetalleArticuloManufacturado  detalleArticuloManufacturado8 = DetalleArticuloManufacturado.builder()
                    .cantidad(10)
                    .build();

            detalleArticuloManufacturado7.setArticuloInsumo(articuloInsumoCheddar);
            detalleArticuloManufacturado8.setArticuloInsumo(articuloInsumoLechuga);


            //----------- CREACIÓN CATEGORIA ARTICULO MANUFACTURADO -----------

            CategoriaArticuloManufacturado categoriaArticuloManufacturadoHamburguesas = CategoriaArticuloManufacturado.builder()
                    .codCategoriaArticuloManufacturado(1)
                    .nombreCategoriaArticuloManufacturado("Hamburguesas")
                    .fechaHoraAltaCategoriaArticuloManufacturado(LocalDate.now())
                    .build();

            CategoriaArticuloManufacturado categoriaArticuloManufacturadoBebidas = CategoriaArticuloManufacturado.builder()
                    .codCategoriaArticuloManufacturado(2)
                    .nombreCategoriaArticuloManufacturado("Bebidas")
                    .fechaHoraAltaCategoriaArticuloManufacturado(LocalDate.now())
                    .build();

            CategoriaArticuloManufacturado categoriaArticuloManufacturadoExtras = CategoriaArticuloManufacturado.builder()
                    .codCategoriaArticuloManufacturado(3)
                    .nombreCategoriaArticuloManufacturado("Extras")
                    .fechaHoraAltaCategoriaArticuloManufacturado(LocalDate.now())
                    .build();




            //----------- CREACIÓN ARTICULO MANUFACTURADO -----------

            ArticuloManufacturado articuloManufacturadoHamburguesa = ArticuloManufacturado.builder()
                    .nombreArticuloManufacturado("Hamburguesa")
                    .descripcionArticuloManufacturado("Con cheddar y tomate")
                    .costo(BigDecimal.valueOf(60))
                    .precioVenta(BigDecimal.valueOf(800))
                    .tiempoEstimadoCocina(5)
                    .urlImagen_AM("ImagenHamburguesa")
                    .fechaAltaArticuloManufacturado(LocalDate.now())
                    .build();

            articuloManufacturadoHamburguesa.agregarDetalleArticuloManufacturado(detalleArticuloManufacturado1);
            articuloManufacturadoHamburguesa.agregarDetalleArticuloManufacturado(detalleArticuloManufacturado2);

            articuloManufacturadoHamburguesa.setCategoriaArticuloManufacturado(categoriaArticuloManufacturadoHamburguesas);


            // ---------------------------------------------------------------

            ArticuloManufacturado articuloManufacturadoCocaCola = ArticuloManufacturado.builder()
                    .nombreArticuloManufacturado("CocaCola")
                    .descripcionArticuloManufacturado("lacoca")
                    .costo(BigDecimal.valueOf(70))
                    .precioVenta(BigDecimal.valueOf(150))
                    .tiempoEstimadoCocina(1)
                    .urlImagen_AM("ImagenCoca")
                    .fechaAltaArticuloManufacturado(LocalDate.now())
                    .build();

            ArticuloManufacturado articuloManufacturadoFanta = ArticuloManufacturado.builder()
                    .nombreArticuloManufacturado("Fanta")
                    .descripcionArticuloManufacturado("lafanta")
                    .costo(BigDecimal.valueOf(50))
                    .precioVenta(BigDecimal.valueOf(150))
                    .tiempoEstimadoCocina(1)
                    .urlImagen_AM("ImagenCoca")
                    .fechaAltaArticuloManufacturado(LocalDate.now())
                    .build();

            ArticuloManufacturado articuloManufacturadoAgua = ArticuloManufacturado.builder()
                    .nombreArticuloManufacturado("Agua")
                    .descripcionArticuloManufacturado("lagua")
                    .costo(BigDecimal.valueOf(10))
                    .precioVenta(BigDecimal.valueOf(100))
                    .tiempoEstimadoCocina(1)
                    .urlImagen_AM("ImagenAgua")
                    .fechaAltaArticuloManufacturado(LocalDate.now())
                    .build();


            //                     ----------------------------

            ArticuloManufacturado articuloManufacturadoCheddar = ArticuloManufacturado.builder()
                    .nombreArticuloManufacturado("Cheddar")
                    .descripcionArticuloManufacturado("ElCheddar")
                    .costo(BigDecimal.valueOf(45))
                    .precioVenta(BigDecimal.valueOf(100))
                    .tiempoEstimadoCocina(1)
                    .urlImagen_AM("ImagenCheddar")
                    .fechaAltaArticuloManufacturado(LocalDate.now())
                    .build();

            ArticuloManufacturado articuloManufacturadoLechuga = ArticuloManufacturado.builder()
                    .nombreArticuloManufacturado("Lechuga")
                    .descripcionArticuloManufacturado("LaLechuga")
                    .costo(BigDecimal.valueOf(70))
                    .precioVenta(BigDecimal.valueOf(100))
                    .tiempoEstimadoCocina(1)
                    .urlImagen_AM("ImagenLechuga")
                    .fechaAltaArticuloManufacturado(LocalDate.now())
                    .build();

            ArticuloManufacturado articuloManufacturadoMedallon = ArticuloManufacturado.builder()
                    .nombreArticuloManufacturado("Medallon")
                    .descripcionArticuloManufacturado("medallonn")
                    .costo(BigDecimal.valueOf(20))
                    .precioVenta(BigDecimal.valueOf(100))
                    .tiempoEstimadoCocina(5)
                    .urlImagen_AM("ImagenMedallon")
                    .fechaAltaArticuloManufacturado(LocalDate.now())
                    .build();

            articuloManufacturadoCocaCola.agregarDetalleArticuloManufacturado(detalleArticuloManufacturado3);
            articuloManufacturadoFanta.agregarDetalleArticuloManufacturado(detalleArticuloManufacturado4);
            articuloManufacturadoAgua.agregarDetalleArticuloManufacturado(detalleArticuloManufacturado5);

            articuloManufacturadoMedallon.agregarDetalleArticuloManufacturado(detalleArticuloManufacturado6);
            articuloManufacturadoCheddar.agregarDetalleArticuloManufacturado(detalleArticuloManufacturado7);
            articuloManufacturadoLechuga.agregarDetalleArticuloManufacturado(detalleArticuloManufacturado8);



           articuloManufacturadoCocaCola.setCategoriaArticuloManufacturado(categoriaArticuloManufacturadoBebidas);
           articuloManufacturadoFanta.setCategoriaArticuloManufacturado(categoriaArticuloManufacturadoBebidas);
           articuloManufacturadoAgua.setCategoriaArticuloManufacturado(categoriaArticuloManufacturadoBebidas);

           articuloManufacturadoMedallon.setCategoriaArticuloManufacturado(categoriaArticuloManufacturadoExtras);
           articuloManufacturadoCheddar.setCategoriaArticuloManufacturado(categoriaArticuloManufacturadoExtras);
           articuloManufacturadoLechuga.setCategoriaArticuloManufacturado(categoriaArticuloManufacturadoExtras);

            //----------- CREACIÓN DE DETALLEPEDIDO -----------

            DetallePedido detallePedido1 = DetallePedido.builder()
                    .cantidad(1)
                    .subtotal(BigDecimal.valueOf(800))
                    .subTotalCosto(BigDecimal.valueOf(60))
                    .build();

            DetallePedido detallePedido2 = DetallePedido.builder()
                    .cantidad(1)
                    .subtotal(BigDecimal.valueOf(100))
                    .subTotalCosto(BigDecimal.valueOf(20))
                    .build();

            DetallePedido detallePedido3 = DetallePedido.builder()
                    .cantidad(1)
                    .subtotal(BigDecimal.valueOf(150))
                    .subTotalCosto(BigDecimal.valueOf(45))
                    .build();

            DetallePedido detallePedido4 = DetallePedido.builder()
                    .cantidad(1)
                    .subtotal(BigDecimal.valueOf(150))
                    .subTotalCosto(BigDecimal.valueOf(45))
                    .build();

            detallePedido1.setArticuloManufacturado(articuloManufacturadoHamburguesa);
            detallePedido2.setArticuloManufacturado(articuloManufacturadoMedallon);
            detallePedido3.setArticuloManufacturado(articuloManufacturadoCheddar);
            detallePedido4.setArticuloManufacturado(articuloManufacturadoCocaCola);


            //----------- CREACIÓN DE PEDIDO -----------

            Pedido pedido1 = Pedido.builder()
                    .totalPrecio(1050)
                    .fechaHoraPedido(LocalDate.now())
                    .estadoPedido(EstadoPedido.PAGADO)
                    .formaPago(FormaPago.MERCADO_PAGO)
                    .tipoEnvio(TipoEnvio.DELIVERY)
                    .totalCosto(125)
                    //fechas
                    .build();

            pedido1.setCliente(cliente1);
            pedido1.setDomicilioEntrega(cliente1.getDomicilioList().get(1));

            pedido1.agregarDetallePedido(detallePedido1);
            pedido1.agregarDetallePedido(detallePedido2);
            pedido1.agregarDetallePedido(detallePedido3);
            pedido1.agregarDetallePedido(detallePedido4);



            //----------- CREACIÓN DE DETALLEFACTURA -----------

            DetalleFactura detalleFactura1 = DetalleFactura.builder()
                    .cantidad(1)
                    .subTotal(BigDecimal.valueOf(800))
                    .build();

            DetalleFactura detalleFactura2 = DetalleFactura.builder()
                    .cantidad(1)
                    .subTotal(BigDecimal.valueOf(100))
                    .build();

            DetalleFactura detalleFactura3 = DetalleFactura.builder()
                    .cantidad(1)
                    .subTotal(BigDecimal.valueOf(150))
                    .build();

            DetalleFactura detalleFactura4 = DetalleFactura.builder()
                    .cantidad(1)
                    .subTotal(BigDecimal.valueOf(150))
                    .build();


            detalleFactura1.setArticuloManufacturado(articuloManufacturadoHamburguesa);
            detalleFactura2.setArticuloManufacturado(articuloManufacturadoMedallon);
            detalleFactura3.setArticuloManufacturado(articuloManufacturadoCheddar);
            detalleFactura4.setArticuloManufacturado(articuloManufacturadoCocaCola);

            //----------- CREACIÓN DE FACTURA -----------

            Factura factura1 = Factura.builder()
                    .fechaHoraFacturacion(LocalDate.now())
                    .descuento(BigDecimal.valueOf(0))
                    .totalPrecioFactura(BigDecimal.valueOf(1050))
                    .formaPago(FormaPago.MERCADO_PAGO)
                    .tipoFactura(TipoFactura.B)
                    .mpMerchantOrderId("A1")
                    .mpPaymentId("B2")
                    .mpPaymentType("C3")
                    .mpPreferenceId("D4")
                    .build();

            factura1.setPedido(pedido1);
            factura1.agregarDetalleFactura(detalleFactura1);
            factura1.agregarDetalleFactura(detalleFactura2);
            factura1.agregarDetalleFactura(detalleFactura3);
            factura1.agregarDetalleFactura(detalleFactura4);


            facturaRepository.save(factura1);

        };
    }
}
