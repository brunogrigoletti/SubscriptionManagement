package br.pucrs.bruno.laitano.subscriptionmanagement.persistence.client;

import java.util.List;
import br.pucrs.bruno.laitano.subscriptionmanagement.dataAccess.Client;

public interface ClientRepository {
    List<Client> getClients();
    Client getClientId(long code);
}