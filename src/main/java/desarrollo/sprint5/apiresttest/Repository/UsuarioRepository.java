package desarrollo.sprint5.apiresttest.Repository;

import desarrollo.sprint5.apiresttest.Entity.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends BaseRepository<Usuario,Long>{

    Optional<Usuario> findByUsername(String username);

    @Query(
            value = "SELECT * FROM Usuario WHERE username = %:username%",
            nativeQuery = true
    )
    Usuario findUserByUsername(
            @Param("username") String username
    );

}
