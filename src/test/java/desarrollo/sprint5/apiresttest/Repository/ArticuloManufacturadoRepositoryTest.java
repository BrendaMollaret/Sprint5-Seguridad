package desarrollo.sprint5.apiresttest.Repository;

import desarrollo.sprint5.apiresttest.Entity.ArticuloManufacturado;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class ArticuloManufacturadoRepositoryTest {

    @Autowired
    private EntityManager entityManager;

    @Test
    @Transactional
    void testGuardarYRecuperarArticuloManufacturado() {
        // Crear un nuevo objeto ArticuloManufacturado
        ArticuloManufacturado articuloManufacturado = new ArticuloManufacturado();
        articuloManufacturado.setNombreArticuloManufacturado("Hamburguesa");

        // Guardar el objeto en la base de datos usando EntityManager
        entityManager.persist(articuloManufacturado);

        // Limpiar el contexto de persistencia para asegurarse de que se ejecuten las operaciones en la base de datos
        entityManager.flush();
        entityManager.clear();

        // Recuperar el objeto de la base de datos por ID usando EntityManager
        ArticuloManufacturado articuloRecuperado = entityManager.find(ArticuloManufacturado.class, articuloManufacturado.getId());

        // Verificar si el objeto fue guardado y recuperado correctamente
        assertNotNull(articuloRecuperado);
        assertEquals("Hamburguesa", articuloRecuperado.getNombreArticuloManufacturado());
    }
}
