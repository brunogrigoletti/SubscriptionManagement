package br.pucrs.bruno.laitano.subscriptionmanagement.business;

import java.util.ArrayList;
import br.pucrs.bruno.laitano.subscriptionmanagement.dataAccess.Client;

public class ClientManagement {
    private Client client;
    private ArrayList<Client> list;

    public ClientManagement() {
        this.list = new ArrayList<>();
    }
    
    public boolean register(Client c) {
        if (this.list.contains(c)) {
            return false;
        }
        this.list.add(c);
        return true;
    }

    public boolean delete(Client c) {
        if (!this.list.contains(c)) {
            return false;
        }
        this.list.remove(c);
        return true;
    }
}