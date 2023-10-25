package desarrollo.sprint4.apiresttest.Controller;

import desarrollo.sprint4.apiresttest.Entity.ArticuloManufacturado;
import desarrollo.sprint4.apiresttest.Service.ArticuloManufacturadoServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ArticuloManufacturadoController.class) // xq se la llama desde arriba, desde la web
public class ArticuloManufacturadoControllerTest {

        @MockBean
        private ArticuloManufacturadoServiceImpl articuloManufacturadoService;

        @Autowired
        private MockMvc mockMvc;

        @Test
        void testSearchString() throws Exception {
            ArticuloManufacturado articuloManufacturado = new ArticuloManufacturado();
            articuloManufacturado.setNombreArticuloManufacturado("Hamburguesa");

            List<ArticuloManufacturado> listaEnviada = new ArrayList();
            listaEnviada.add(articuloManufacturado);

            when(articuloManufacturadoService.search("Hamburguesa")).thenReturn(listaEnviada);

            // simula una  request por postman, el formato es el mismo
            mockMvc.perform(get("/api/v1/articuloManufacturado/search")
                            .param("filtro", "Hamburguesa")
                            .contentType(MediaType.APPLICATION_JSON))
                            .andExpect(status().isOk()) //status 200
                            .andExpect(jsonPath("$[0].nombreArticuloManufacturado", is("Hamburguesa")));
        }
}
