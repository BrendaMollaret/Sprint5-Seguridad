package desarrollo.sprint4.apiresttest.Service;


import desarrollo.sprint4.apiresttest.Entity.ArticuloManufacturado;
import desarrollo.sprint4.apiresttest.Repository.ArticuloManufacturadoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ArticuloManufacturadoServiceImplTest {

    @MockBean
    private ArticuloManufacturadoRepository articuloManufacturadoRepository;

    @Autowired
    private ArticuloManufacturadoServiceImpl articuloInsumoService;

    @Test
    void testSearchString() throws Exception {
        ArticuloManufacturado articuloManufacturado = new ArticuloManufacturado();
        articuloManufacturado.setNombreArticuloManufacturado("Hamburguesa");


        List<ArticuloManufacturado> listaEnviada = new ArrayList<ArticuloManufacturado>();
        listaEnviada.add(articuloManufacturado);

        when(articuloManufacturadoRepository.searchNative("Hamburguesa")).thenReturn(listaEnviada);


        assertEquals(listaEnviada, articuloInsumoService.search("Hamburguesa"));

    }
}
