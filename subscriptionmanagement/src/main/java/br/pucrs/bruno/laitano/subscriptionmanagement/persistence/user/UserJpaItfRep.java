package br.pucrs.bruno.laitano.subscriptionmanagement.persistence.user;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import br.pucrs.bruno.laitano.subscriptionmanagement.dataAccess.User;

public interface UserJpaItfRep extends CrudRepository<User,String> {
    List<User> findAll();
    User findById(String id);
    void delete(User user);
    void deleteById(String id);
    boolean existsById(String id);
}