package bluedream.example.security.repository;

import bluedream.example.security.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 *
 */
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
