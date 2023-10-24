package desarrollo.sprint4.apiresttest.Service;

import desarrollo.sprint4.apiresttest.Entity.Rubro;

import java.util.List;

public interface RubroService extends BaseService<Rubro, Long>{

    List<Rubro> search(String filtro) throws Exception;
}
