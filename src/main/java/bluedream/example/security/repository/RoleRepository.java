package bluedream.example.security.repository;

import bluedream.example.security.domain.Role;
import org.springframework.data.repository.CrudRepository;

/**
 *
 */
public interface RoleRepository extends CrudRepository<Role, Long> {
}
