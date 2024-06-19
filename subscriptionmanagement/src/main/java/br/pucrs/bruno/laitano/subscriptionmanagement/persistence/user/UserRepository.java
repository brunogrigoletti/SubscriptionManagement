package br.pucrs.bruno.laitano.subscriptionmanagement.persistence.user;

import java.util.List;
import br.pucrs.bruno.laitano.subscriptionmanagement.dataAccess.User;

public interface UserRepository {
    List<User> getUsers();
    User getUserId(long code);
}