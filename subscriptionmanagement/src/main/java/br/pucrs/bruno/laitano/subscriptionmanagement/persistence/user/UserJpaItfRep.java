package br.pucrs.bruno.laitano.subscriptionmanagement.persistence.user;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import br.pucrs.bruno.laitano.subscriptionmanagement.dataAccess.User;

public interface UserJpaItfRep extends CrudRepository<User,Long> {
    List<User> findAll();
    User findById(long code);
    void delete(User user);
    void deleteById(long code);
    boolean existsById(long code);
}