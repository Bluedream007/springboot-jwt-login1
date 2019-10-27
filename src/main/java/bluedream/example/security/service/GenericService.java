package bluedream.example.security.service;


import bluedream.example.security.domain.User;

import java.util.List;

/**
 *
 */
public interface GenericService {
    User findByUsername(String username);

    List<User> findAllUsers();


}
