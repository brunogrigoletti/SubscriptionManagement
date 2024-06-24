package br.pucrs.bruno.laitano.subscriptionmanagement.dataAccess;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.BeforeAll;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SubscriptionTest {

    private static Subscription sub;

    @BeforeAll
    public static void setup() {
        Application app = new Application(1, "apptest", 20);
        Client client = new Client(1, "clientTest", "test@test.com");
        Calendar calendar = Calendar.getInstance();
        calendar.set(2024, 06, 23);
        Date startDate = calendar.getTime();
        calendar.set(2024, 07, 23);
        Date endDate = calendar.getTime();
        sub = new Subscription(1, app, client, startDate, endDate);
    }

}
