package br.pucrs.bruno.laitano.subscriptionmanagement.persistence.user;

import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import br.pucrs.bruno.laitano.subscriptionmanagement.dataAccess.User;

@Repository
@Primary
public class UserRepoJpaImpl implements UserRepository {
    private UserJpaItfRep repository;

    @Autowired
    public UserRepoJpaImpl(UserJpaItfRep repository) {
        this.repository = repository;
    }

    @Override
    public List<User> getUsers() {
        List<User> users = repository.findAll();
        if (users.size() == 0) {
            return new LinkedList<User>();
        } else {
            return users.stream()
                         .toList();
        }
    }

    @Override
    public User getUserId(long code) {
        User user = repository.findById(code);
        return user;
    }   
}