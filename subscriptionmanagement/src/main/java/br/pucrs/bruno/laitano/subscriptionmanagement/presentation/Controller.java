package br.pucrs.bruno.laitano.subscriptionmanagement.presentation;

import br.pucrs.bruno.laitano.subscriptionmanagement.dataAccess.Application;
import br.pucrs.bruno.laitano.subscriptionmanagement.dataAccess.Client;
import br.pucrs.bruno.laitano.subscriptionmanagement.dataAccess.Subscription;
import br.pucrs.bruno.laitano.subscriptionmanagement.dataAccess.User;
import br.pucrs.bruno.laitano.subscriptionmanagement.persistence.application.ApplicationRepository;
import br.pucrs.bruno.laitano.subscriptionmanagement.persistence.client.ClientRepository;
import br.pucrs.bruno.laitano.subscriptionmanagement.persistence.user.UserRepository;
import java.util.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/subscriptionmanagement")
public class Controller {
    private UserRepository users;
    private ClientRepository clients;
    private ApplicationRepository apps;

    @Autowired
    public Controller(UserRepository users, ClientRepository clients, ApplicationRepository apps) {
        this.users = users;
        this.clients = clients;
        this.apps = apps;
    }

    @GetMapping("")
    public String getFirstMessage() {
        return "Funcionando!";
    }

    @PostMapping("/usuvalido")
    public boolean userValidation(@RequestBody long code) {
        if (users.getUserId(code)!=null) {
            return true;
        }
        return false;
    }

    @GetMapping("/servcad/users")
    public List<User> getUsers() {
        return users.getUsers();
    }

    @GetMapping("/servcad/clientes")
    public List<Client> getClients() {
        return clients.getClients();
    }

    @GetMapping("/servcad/aplicativos")
    public List<Application> getApplications() {
        return apps.getApps();
    }

    @PostMapping("/servcad/assinaturas")
    public Subscription createSubscription(@RequestBody final long clientCode, @RequestBody final long appCode) {
        return null;
    }

    @PostMapping("/servcad/aplicativos/atualizacusto/{idAplicativo}")
    public Application updateMonthlyCost(@RequestBody final float monthlyCost) {
        return null;
    }
}