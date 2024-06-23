package br.pucrs.bruno.laitano.subscriptionmanagement.presentation;

import br.pucrs.bruno.laitano.subscriptionmanagement.dataAccess.Application;
import br.pucrs.bruno.laitano.subscriptionmanagement.dataAccess.Client;
import br.pucrs.bruno.laitano.subscriptionmanagement.dataAccess.Payment;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public boolean userValidation(@RequestBody Map<String, Long> request) {
        Long code = request.get("code");
        if (users.getUserId(code) != null) {
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

    @GetMapping("/servcad/listaassinaturas")
    public List<Subscription> getSubscriptions() {
        return subs.getSubscriptions();
    }

    @GetMapping("/servcad/pagamentos")
    public List<Payment> getPayments() {
        return payments.getPayments();
    }

    @PostMapping("/servcad/assinaturas")
    public Subscription createSubscription(@RequestBody Map<String, Long> request) {
        long clientCode = request.get("clientCode");
        long appCode = request.get("appCode");
        Client client = clients.getClientId(clientCode);
        Application app = apps.getAppId(appCode);
        Date startDate = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
        Calendar calendar = Calendar.getInstance();
        calendar.set(2025, Calendar.DECEMBER, 31, 12, 0, 0);
        Date endDate = calendar.getTime();
        Random random = new Random();
        ArrayList<Long> usedCodes = new ArrayList<>();
        long code = 6 + random.nextInt(95);
        usedCodes.add(code);
        Subscription newSub = subs.createSubscription(code, app, client, startDate, endDate);
        return newSub;
    }

    @PostMapping("/servcad/aplicativos/atualizacusto/{idAplicativo}")
    public Application updateMonthlyCost(@PathVariable("idAplicativo") Long appId,
            @RequestBody Map<String, Long> request) {
        float monthlyCost = request.get("monthlyCost");
        Application app = apps.getAppId(appId);
        if (monthlyCost > 0) {
            apps.updateMonthlyCost(app, monthlyCost);
            return app;
        }
        return null;
    }

    @GetMapping("/servcad/assinaturas/{tipo}")
    public List<Subscription> getSubscriptionsByType(@PathVariable("tipo") String type) {
        List<Subscription> subsType = new ArrayList<>();
        for (Subscription sub : subs.getSubscriptions()) {
            if (sub.getType().equalsIgnoreCase(type)) {
                subsType.add(sub);
            }
        }
        return subsType;
    }

    @GetMapping("/servcad/assincli/{codcli}")
    public List<Subscription> getSubscriptionsByClient(@PathVariable("codcli") Long code) {
        List<Subscription> subsClient = new ArrayList<>();
        for (Subscription sub : subs.getSubscriptions()) {
            if (sub.getClient().getCode() == code) {
                subsClient.add(sub);
            }
        }
        return subsClient;
    }

    @GetMapping("/servcad/assinapp/{codapp}")
    public List<Subscription> getSubscriptionsByApp(@PathVariable("codapp") Long code) {
        List<Subscription> subsApp = new ArrayList<>();
        for (Subscription sub : subs.getSubscriptions()) {
            if (sub.getApp().getCode() == code) {
                subsApp.add(sub);
            }
        }
        return subsApp;
    }

    @PostMapping("/registrarpagamento")
    public ResponseEntity<Payment> createPayment(@RequestBody Map<String, Long> request) {
        Long day = request.get("day");
        Long month = request.get("month");
        Long year = request.get("year");
        Long codSub = request.get("codSub");
        double valuePaid = request.get("valuePaid");
        Subscription sub = subs.getSubscriptionId(codSub);
        LocalDate localDate = LocalDate.of(year.intValue(), month.intValue(), day.intValue());
        Date paymentDate = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Random random = new Random();
        ArrayList<Long> usedCodes = new ArrayList<>();
        long code = 6 + random.nextInt(95);
        usedCodes.add(code);
        Payment newPayment = payments.createPayment(code, sub, valuePaid, paymentDate, null);
        if (newPayment == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        else
            return ResponseEntity.status(HttpStatus.OK).body(newPayment);
    }

    /**
     * Verify if a determined Subscription remains valid.
     * 
     * @return true if subscription status is valid
     */
    @GetMapping(" /assinvalida/{codassin}")
    public boolean checkSubscriptionValidStatus(@PathVariable("codassin") Long subscriptionCode) {
        try {
            Subscription sub = subs.getSubscriptionId(subscriptionCode);
            String status = sub.getType();
            if (status.equals("ACTIVE")) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

}