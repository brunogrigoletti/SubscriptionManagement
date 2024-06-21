package br.pucrs.bruno.laitano.subscriptionmanagement.presentation;

import br.pucrs.bruno.laitano.subscriptionmanagement.dataAccess.Application;
import br.pucrs.bruno.laitano.subscriptionmanagement.dataAccess.Client;
import br.pucrs.bruno.laitano.subscriptionmanagement.dataAccess.Subscription;
import br.pucrs.bruno.laitano.subscriptionmanagement.dataAccess.User;
import br.pucrs.bruno.laitano.subscriptionmanagement.persistence.application.ApplicationRepoJpaImpl;
import br.pucrs.bruno.laitano.subscriptionmanagement.persistence.client.ClientRepoJpaImpl;
import br.pucrs.bruno.laitano.subscriptionmanagement.persistence.payment.PaymentRepoJpaImpl;
import br.pucrs.bruno.laitano.subscriptionmanagement.persistence.subscription.SubscriptionRepoJpaImpl;
import br.pucrs.bruno.laitano.subscriptionmanagement.persistence.user.UserRepoJpaImpl;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/subscriptionmanagement")
public class Controller {
    private UserRepoJpaImpl users;
    private ClientRepoJpaImpl clients;
    private ApplicationRepoJpaImpl apps;
    private SubscriptionRepoJpaImpl subs;
    private PaymentRepoJpaImpl payments;

    @Autowired
    public Controller(UserRepoJpaImpl users, ClientRepoJpaImpl clients, ApplicationRepoJpaImpl apps,
            SubscriptionRepoJpaImpl subs, PaymentRepoJpaImpl payments) {
        this.users = users;
        this.clients = clients;
        this.apps = apps;
        this.subs = subs;
        this.payments = payments;
    }

    @GetMapping("")
    public String getFirstMessage() {
        return "Funcionando!";
    }

    @PostMapping("/usuvalido")
    public boolean userValidation(@RequestBody final Long code) {
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
    public Subscription createSubscription(@RequestBody Map<String, Long> request) {
        long clientCode = request.get("clientCode");
        long appCode = request.get("appCode");
        Client client = clients.getClientId(clientCode);
        Application app = apps.getAppId(appCode);
        Date date = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
        Random random = new Random();
        ArrayList<Long> usedCodes = new ArrayList<>();
        long code = 6 + random.nextInt(95);
        if (!usedCodes.contains(code)){
            usedCodes.add(code);
            Subscription newSub = subs.createSubscription(code, app, client, date, null);
            return newSub;
        }
        else
            return null;
    }

    @PostMapping("/servcad/aplicativos/atualizacusto/{idAplicativo}")
    public Application updateMonthlyCost(@PathVariable("idAplicativo") Long appId, @RequestBody final float monthlyCost) {
        Application app = apps.getAppId(appId);
        if (monthlyCost<0){
            app.setMonthlyCost(monthlyCost);
            return app;
        }
        return null;
    }
}