package desarrollo.sprint5.apiresttest.Service;

import desarrollo.sprint5.apiresttest.Entity.Rubro;

import java.util.List;

public interface RubroService extends BaseService<Rubro, Long>{

    List<Rubro> search(String filtro) throws Exception;
}
