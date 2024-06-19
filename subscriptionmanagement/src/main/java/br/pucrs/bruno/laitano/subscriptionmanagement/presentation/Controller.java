package br.pucrs.bruno.laitano.subscriptionmanagement.presentation;

import br.pucrs.bruno.laitano.subscriptionmanagement.dataAccess.Application;
import br.pucrs.bruno.laitano.subscriptionmanagement.dataAccess.Client;
import br.pucrs.bruno.laitano.subscriptionmanagement.dataAccess.Subscription;
import br.pucrs.bruno.laitano.subscriptionmanagement.persistence.user.UserRepository;
import java.util.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/subscriptionmanagement")
public class Controller {
    private UserRepository users;

    @Autowired
    public Controller(UserRepository users) {
        this.users = users;
    }

    @GetMapping("")
    public String getFirstMessage() {
        return "Funcionando!";
    }

    @PostMapping("/usuvalido")
    public boolean postMethodName(@RequestBody long code) {
        if (users.getUserId(code)!=null) {
            return true;
        }
        return false;
    }

    @GetMapping("/servcad/clientes")
    public List<Client> getClients() {
        return null;
    }

    @GetMapping("/servcad/aplicativos")
    public Application getApplications() {
        return null;
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