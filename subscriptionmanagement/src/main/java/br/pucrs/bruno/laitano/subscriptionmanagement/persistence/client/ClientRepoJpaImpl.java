package br.pucrs.bruno.laitano.subscriptionmanagement.persistence.client;

import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import br.pucrs.bruno.laitano.subscriptionmanagement.dataAccess.Client;

@Repository
@Primary
public class ClientRepoJpaImpl implements ClientRepository {
    private ClientJpaItfRep repository;

    @Autowired
    public ClientRepoJpaImpl(ClientJpaItfRep repository) {
        this.repository = repository;
    }

    @Override
    public List<Client> getClients() {
        List<Client> clients = repository.findAll();
        if (clients.size() == 0) {
            return new LinkedList<Client>();
        }
        else {
            return clients.stream().toList();
        }
    }

    @Override
    public Client getClientId(long code) {
        Client client = repository.findById(code);
        return client;
    }
}