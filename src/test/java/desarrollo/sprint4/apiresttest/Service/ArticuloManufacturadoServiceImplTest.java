package desarrollo.sprint4.apiresttest.Service;


import desarrollo.sprint4.apiresttest.Entity.ArticuloManufacturado;
import desarrollo.sprint4.apiresttest.Repository.ArticuloManufacturadoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ArticuloManufacturadoServiceImplTest {

    @MockBean
    private ArticuloManufacturadoRepository articuloManufacturadoRepository;

    @Autowired
    private ArticuloManufacturadoServiceImpl articuloManufacturadoService;

    @Test
    void testSearchString() throws Exception {
        ArticuloManufacturado articuloManufacturado = new ArticuloManufacturado();
        articuloManufacturado.setNombreArticuloManufacturado("Hamburguesa");


        List<ArticuloManufacturado> listaEnviada = new ArrayList<ArticuloManufacturado>();
        listaEnviada.add(articuloManufacturado);

        // Configura el comportamiento del repositorio mock
        when(articuloManufacturadoRepository.searchByNombre("Hamburguesa", PageRequest.of(0,1))).thenReturn(new PageImpl<>(listaEnviada));

        // Llama al método de servicio y verifica el resultado
        Page<ArticuloManufacturado> result = articuloManufacturadoService.searchByNombre("Hamburguesa", PageRequest.of(0,1));

        // Verifica si el resultado coincide con lo esperado
        assertEquals(listaEnviada, result.getContent());

    }
}
