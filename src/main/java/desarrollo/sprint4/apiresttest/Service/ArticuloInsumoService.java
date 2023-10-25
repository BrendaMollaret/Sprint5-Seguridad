package desarrollo.sprint4.apiresttest.Service;

import desarrollo.sprint4.apiresttest.Entity.ArticuloInsumo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ArticuloInsumoService extends BaseService<ArticuloInsumo, Long>{

    Page<ArticuloInsumo> searchByNombre(String nombre, Pageable pageable) throws Exception;

    Page<ArticuloInsumo> searchByRubroNombre(String nombre, Pageable pageable) throws Exception;
}
