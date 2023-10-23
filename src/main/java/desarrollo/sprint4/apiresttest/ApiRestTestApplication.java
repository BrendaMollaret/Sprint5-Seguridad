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


    @Bean
    CommandLineRunner init(ClienteRepository clienteRepository) {
        return args -> {

        };
    }
}
