package desarrollo.sprint4.apiresttest;


import desarrollo.sprint4.apiresttest.Entity.*;
import desarrollo.sprint4.apiresttest.Enumeration.TipoEnvio;
import desarrollo.sprint4.apiresttest.Enumeration.FormaPago;
import desarrollo.sprint4.apiresttest.Repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

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
        System.out.println("---------ESTOY FUNCIONANDO---------");
    }

    /*
    @Bean
    CommandLineRunner init(ClienteRepository clienteRepository) {
        return args -> {


            //Crear rubro
            Rubro rubro1 = Rubro.builder()
                    .nombreRubro("Almacen")
                    .build();

            //Crear rubro2
            Rubro rubro2 = Rubro.builder()
                    .nombreRubro("Fiambreria")
                    .build();

            //Crear unidad de medida

            UnidadMedida unidadMedidaCC = UnidadMedida.builder()
                    .nombreUnidadMedida("Centímetros cúbicos")
                    .abrevitaturaUnidadMedida("CC")
                    .fechaHoraAltaUnidadMedida(LocalDateTime.now())
                    .build();

            //Crear articuloInsumo1
            ArticuloInsumo articuloInsumo1 = ArticuloInsumo.builder()
                    .nombreArticuloInsumo("Queso")
                    .fechaHoraAltaArticuloInsumo(LocalTime.now())
                    .precioCompra(BigDecimal.valueOf(300))
                    .stockMinimo(100)
                    .stockActual(200)
                    .build();
            //faltan fechas
            articuloInsumo1.setRubro(rubro2);
            articuloInsumo1.setUnidadMedida(unidadMedidaCC);


            //Crear articuloInsumo2
            ArticuloInsumo articuloInsumo2 = ArticuloInsumo.builder()
                    .nombreArticuloInsumo("Salame")
                    .fechaHoraAltaArticuloInsumo(LocalTime.now())
                    .precioCompra(BigDecimal.valueOf(500))
                    .stockMinimo(100)
                    .stockActual(150)
                    .build();

            articuloInsumo2.setRubro(rubro2);
            articuloInsumo2.setUnidadMedida(unidadMedidaCC);


            //Crear articulo manufacturado 1
            ArticuloManufacturado articuloManufacturado1 = ArticuloManufacturado.builder()

                    .nombreArticuloManufacturado("Pizza")
                    .descripcionArticuloManufacturado("Contiene queso y salame")
                    .costo(BigDecimal.valueOf(100))
                    .urlImagen_AM("https://i.pinimg.com/564x/50/0a/49/500a4983d3d45d39d9ecf5aa41aae8cf.jpg")
                    .tiempoEstimadoCocina(10)
                    .build();
            //faltafecha



            //Crear articulo manufacturado 2
            ArticuloManufacturado articuloManufacturado2 = ArticuloManufacturado.builder()
                    .nombreArticuloManufacturado("Hamburguesa")
                    .descripcionArticuloManufacturado("Contiene carne vacuna, lechuga y tomate")
                    .costo(BigDecimal.valueOf(200))
                    .urlImagen_AM("https://i.pinimg.com/564x/c5/6a/db/c56adb76ae668809809aa926dd5ebfee.jpg")
                    .tiempoEstimadoCocina(10)
                    .build();


            //Guardar articulo insumo y manufacturado
            articuloInsumoRepository.save(articuloInsumo1);
            articuloInsumoRepository.save(articuloInsumo2);
            articuloManufacturadoRepository.save(articuloManufacturado1);
            articuloManufacturadoRepository.save(articuloManufacturado2);



            //Crear cliente
            Cliente cliente1 = Cliente.builder()
                    .nombre("Seymour")
                    .apellido("Skinner")
                    .telefono("111-111")
                    .mail("directorskinner@email.com")
                    .fechaHoraBajaCliente(null)
                    .build();

            Cliente cliente2 = Cliente.builder()
                    .nombre("Gary")
                    .apellido("Chalmers")
                    .telefono("222-222")
                    .mail("superintendentechalmers@email.com")
                    .fechaHoraBajaCliente(null)
                    .build();

            //Crear Localidad
            Localidad localidad1 = Localidad.builder()
                    .nombreLocalidad("Springfield")
                    .codigoPostal(555)
                    .build();

            Localidad localidad2 = Localidad.builder()
                    .nombreLocalidad("Capital City")
                    .codigoPostal(555)
                    .build();

            //save localidades
            localidadRepository.save(localidad1);
            localidadRepository.save(localidad2);

            //Crear domicilio
            Domicilio domicilio1 = Domicilio.builder()
                    .calle("calle actual")
                    .nroCalle(111)
                    .pisoDpto(0)
                    .nroDpto(0)
                    .localidad(localidad1)
                    .build();

            Domicilio domicilio2 = Domicilio.builder()
                    .calle("calle falsa")
                    .nroCalle(222)
                    .pisoDpto(0)
                    .nroDpto(0)
                    .localidad(localidad2)
                    .build();

            Domicilio domicilio3 = Domicilio.builder()
                    .calle("calle verdadera")
                    .nroCalle(333)
                    .pisoDpto(0)
                    .nroDpto(0)
                    .localidad(localidad2)
                    .build();

            //Agregar domicilio a cliente
            cliente1.agregarDomicilio(domicilio1);
            cliente1.agregarDomicilio(domicilio2);

            cliente2.agregarDomicilio(domicilio3);

            //Crear detalle pedido
            DetallePedido detallePedido1 = DetallePedido.builder()
                    .cantidad(1)
                    .subtotal(BigDecimal.valueOf(7300))
                    .build();

            DetallePedido detallePedido2 = DetallePedido.builder()
                    .cantidad(0)
                    .subtotal(BigDecimal.valueOf(0))
                    .build();

            DetallePedido detallePedido3 = DetallePedido.builder()
                    .cantidad(4)
                    .subtotal(BigDecimal.valueOf(2920))
                    .build();

            //Formato de fecha
            SimpleDateFormat formatoFecha0 = new SimpleDateFormat("yyyy-MM-dd");
            String fechaToString = "1996-03-14"; //cambiar fecha
            Date fecha = formatoFecha0.parse(fechaToString);

            //Crear EstadoPedido


            //Crear pedido
            Pedido pedido1 = Pedido.builder()

                    .fechaHoraPedido(fecha)
                    .fechaHoraEstimadaFinalizacion(fecha)
                    .totalPrecio(7300)
                    .tipoEnvio(TipoEnvio.RETIRO_LOCAL)
                    .formaPago(FormaPago.EFECTIVO)
                    .build();

            Pedido pedido2 = Pedido.builder()

                    .fechaHoraPedido(fecha)
                    .fechaHoraEstimadaFinalizacion(fecha)
                    .totalPrecio(2920)
                    .tipoEnvio(TipoEnvio.RETIRO_LOCAL)
                    .formaPago(FormaPago.EFECTIVO)
                    .build();

            //Crear factura
            Factura factura1 = Factura.builder()
                    .nroFactura(1)
                    .fechaHoraFacturacion(fecha)
                    .descuento(BigDecimal.valueOf(10))
                    .formaPago(FormaPago.EFECTIVO)
                    .totalPrecioFactura(BigDecimal.valueOf(7300))
                    .build();

            Factura factura2 = Factura.builder()
                    .nroFactura(2)
                    .fechaHoraFacturacion(fecha)
                    .descuento(BigDecimal.valueOf(0))
                    .formaPago(FormaPago.EFECTIVO)
                    .totalPrecioFactura(BigDecimal.valueOf(2920))
                    .build();

            //Agregar detalle al pedido
            pedido1.agregarDetallePedido(detallePedido1);
            pedido1.agregarDetallePedido(detallePedido2);
            pedido2.agregarDetallePedido(detallePedido3);

            //Agregar pedido al cliente
            pedido1.setCliente(cliente1);
            pedido2.setCliente(cliente1);

            //Relacionar detalle con articulo insumo y manufacturado
            detallePedido1.setArticuloInsumo(articuloInsumo1);
            detallePedido2.setArticuloManufacturado(articuloManufacturado1);

            detallePedido2.setArticuloInsumo(articuloInsumo2);
            detallePedido1.setArticuloManufacturado(articuloManufacturado2);

            //Relacionar factura con pedido
            factura1.setPedido(pedido1);
            factura2.setPedido(pedido2);

            //Guardar cliente
            clienteRepository.save(cliente1);
            clienteRepository.save(cliente2);

        };
    } */
}
