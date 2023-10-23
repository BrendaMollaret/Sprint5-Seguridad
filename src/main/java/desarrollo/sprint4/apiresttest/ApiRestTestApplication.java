package desarrollo.sprint4.apiresttest;


import desarrollo.sprint4.apiresttest.Entity.*;
import desarrollo.sprint4.apiresttest.Enumeration.EstadoPedido;
import desarrollo.sprint4.apiresttest.Enumeration.TipoEnvio;
import desarrollo.sprint4.apiresttest.Enumeration.FormaPago;
import desarrollo.sprint4.apiresttest.Enumeration.TipoFactura;
import desarrollo.sprint4.apiresttest.Repository.*;

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
    RubroRepository rubroRepository;

    @Autowired
    ArticuloManufacturadoRepository articuloManufacturadoRepository;

    @Autowired
    ArticuloInsumoRepository articuloInsumoRepository;

    @Autowired
    UnidadMedidaRepository unidadMedidaRepository;

    @Autowired
    LocalidadRepository localidadRepository;

    public static void main(String[] args) {
        SpringApplication.run(ApiRestTestApplication.class, args);
        System.out.println("\n---------ESTOY FUNCIONANDO---------");
    }


    @Bean
    CommandLineRunner init(ClienteRepository clienteRepository) {
        return args -> {

            //----------- CREACIÓN DE RUBROS -----------
            Rubro rubroVerduleria = Rubro.builder()
                    .nombreRubro("Verduleria")
                    .fechaAltaProducto(LocalDate.now())
                    .build();

            Rubro rubroVerdura = Rubro.builder()
                    .nombreRubro("Verdura")
                    .fechaAltaProducto(LocalDate.now())
                    .build();

            rubroVerduleria.agregarRubro(rubroVerdura);


            Rubro rubroFiambreria = Rubro.builder()
                    .nombreRubro("Fiambreria")
                    .fechaAltaProducto(LocalDate.now())
                    .build();

            Rubro rubroQueso = Rubro.builder()
                    .nombreRubro("Queso")
                    .fechaAltaProducto(LocalDate.now())
                    .build();

            rubroFiambreria.agregarRubro(rubroQueso);

            //----------- CREACIÓN DE UNIDAD DE MEDIDA -----------

            UnidadMedida unidadMedidaGr = UnidadMedida.builder()
                    .nombreUnidadMedida("Gramos")
                    .abrevitaturaUnidadMedida("gr")
                    .fechaAltaUnidadMedida(LocalDate.now())
                    .build();


            //----------- CREACIÓN ARTICULOINSUMO -----------

            ArticuloInsumo articuloInsumoLechuga = ArticuloInsumo.builder()
                    .nombreArticuloInsumo("Lechuga")
                    .precioCompra(BigDecimal.valueOf(45))
                    .stockMinimo(500)
                    .stockActual(800)
                    .urlImagen("https://i.pinimg.com/564x/50/0a/49/500a4983d3d45d39d9ecf5aa41aae8cf.jpg")
                    .fechaHoraAltaArticuloInsumo(LocalDate.now())
                    .build();

            ArticuloInsumo articuloInsumoCheddar = ArticuloInsumo.builder()
                    .nombreArticuloInsumo("Cheddar")
                    .precioCompra(BigDecimal.valueOf(70))
                    .stockMinimo(500)
                    .stockActual(1000)
                    .urlImagen("imagenCheddar")
                    .fechaHoraAltaArticuloInsumo(LocalDate.now())
                    .build();

            articuloInsumoLechuga.setRubro(rubroVerdura);
            articuloInsumoCheddar.setRubro(rubroQueso);

            articuloInsumoLechuga.setUnidadMedida(unidadMedidaGr);
            articuloInsumoCheddar.setUnidadMedida(unidadMedidaGr);

            //----------- CREACIÓN DE UN DETALLEARTICULOMANUFACTURADO -----------

            DetalleArticuloManufacturado detalleArticuloManufacturado1 = DetalleArticuloManufacturado.builder()
                    .cantidad(5)
                    .build();

            DetalleArticuloManufacturado detalleArticuloManufacturado2 = DetalleArticuloManufacturado.builder()
                    .cantidad(10)
                    .build();

            detalleArticuloManufacturado1.setArticuloInsumo(articuloInsumoLechuga);
            detalleArticuloManufacturado2.setArticuloInsumo(articuloInsumoCheddar);


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


            //----------- CREACIÓN DE LOCALIDAD -----------
            Localidad localidadGodoyCruz = Localidad.builder()
                    .nombreLocalidad("Godoy cruz")
                    .codigoPostal(5501)
                    .build();

            Localidad localidadLasHeras = Localidad.builder()
                    .nombreLocalidad("Las Heras")
                    .codigoPostal(5502)
                    .build();

            //CREACIÓN DE DOMICILIO
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
            domicilio2.setLocalidad(localidadLasHeras);


            //CREACIÓN DE USUARIO

            Usuario usuario1 = Usuario.builder()
                    .auth0Id("numeración")
                    .fechaAltaUsuario(LocalDate.now())
                    .username("Juan25")
                    .build();


            //CREACIÓN DE CLIENTE

            Cliente cliente1 = Cliente.builder()
                    .nombre("Juan")
                    .apellido("ApellidoJuan")
                    .fechaHoraAltaCliente(LocalDate.now())
                    .mail("juanjuanapellido@mail.com")
                    .telefono("555-555")
                    .build();

            cliente1.setUsuario(usuario1);
            cliente1.agregarDomicilio(domicilio1);
            cliente1.agregarDomicilio(domicilio2);

            //CREACIÓN DE DETALLEPEDIDO

            DetallePedido detallePedido1 = DetallePedido.builder()
                    .cantidad(1)
                    .subtotal(BigDecimal.valueOf(800))
                    .subTotalCosto(BigDecimal.valueOf(60))
                    .build();


            //CREACIÓN DE PEDIDO

            Pedido pedido1 = Pedido.builder()
                    .totalPrecio(800)
                    .fechaHoraPedido(LocalDate.now())
                    .estadoPedido(EstadoPedido.PAGADO)
                    .formaPago(FormaPago.MERCADO_PAGO)
                    .tipoEnvio(TipoEnvio.DELIVERY)
                    //fechas
                    .build();

            pedido1.setCliente(cliente1);
            pedido1.setDomicilioEntrega(cliente1.getDomicilios().get(1));

            pedido1.agregarDetallePedido(detallePedido1);


            //CREACIÓN DE DETALLEFACTURA

            DetalleFactura detalleFactura1 = DetalleFactura.builder()
                    .cantidad(1)
                    .subTotal(BigDecimal.valueOf(800))
                    .build();


            //CREACIÓN DE FACTURA

            Factura factura1 = Factura.builder()
                    .fechaHoraFacturacion(LocalDate.now())
                    .descuento(BigDecimal.valueOf(0))
                    .totalPrecioFactura(BigDecimal.valueOf(800))
                    .formaPago(FormaPago.MERCADO_PAGO)
                    .tipoFactura(TipoFactura.B)
                    .mpMerchantOrderId("A1")
                    .mpPaymentId("B2")
                    .mpPaymentType("C3")
                    .mpPreferenceId("D4")
                    .build();

            factura1.setPedido(pedido1);
            factura1.agregarDetalleFactura(detalleFactura1);




        };
    }
}
