package br.pucrs.bruno.laitano.subscriptionmanagement.dataAccess;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SubscriptionTest {

    private Subscription sub;

    @BeforeEach
    public void setup() {
        Application app = new Application(1, "apptest", 20);
        Client client = new Client(1, "client", "test@test.com");
        Calendar startDate = Calendar.getInstance();
        Calendar endDate = startDate;
        endDate.add(Calendar.DAY_OF_MONTH, 30);
        sub = new Subscription(1, app, client, null, null);
        sub = new Subscription();
    }

    /**
     * Tests if the type return of a valid subscription is valid
     */

    @Test
    public void validSubscription() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 30);
        Date date = calendar.getTime();
        sub.setEndDate(date);
        sub.calculateTypeAndPaymentDate();
        assertEquals("ACTIVE", sub.getType());
    }

    /**
     * Tests if the type return of a inactive subscription is inactive
     */

    @Test
    public void inactiveSubscription() {
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        sub.setEndDate(date);
        sub.calculateTypeAndPaymentDate();
        assertEquals("INACTIVE", sub.getType());
        assertEquals(date, sub.getEndDate());
    }

    /**
     * Tests if the startDate is changed correctly
     */
    @Test
    public void startDateTest() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2020, 10, 03);
        Date date = calendar.getTime();
        sub.setStartDate(date);
        assertEquals(date, sub.getStartDate());
    }

    /**
     * Tests the functionality of the methods setCode and getCode
     */
    @Test
    public void setcodeto2() {
        sub.setCode(2);
        assertEquals(2, sub.getCode());
    }

    /**
     * Tests the functionality of the methods setApp and getApp
     */
    @Test
    public void setnewApp() {
        Application app2 = new Application(2, "apptest", 20);
        sub.setApp(app2);
        assertEquals(app2, sub.getApp());
    }

    /**
     * Tests the functionality of the methods setClient and getClient
     */
    @Test
    public void setnewClient() {
        Client client = new Client(2, "client", "test@test.com");
        sub.setClient(client);
        assertEquals(client, sub.getClient());
    }

    /**
     * Tests the functionality of the methods setType and getType
     */
    @Test
    public void setnewType() {
        sub.setType("INACTIVE");
        assertEquals("INACTIVE", sub.getType());
        sub.setType("ACTIVE");
        assertEquals("ACTIVE", sub.getType());
    }

    /**
     * Test toString meyhod
     */
    @Test
    public void toStringTest() {
        assertEquals("Subscription [code=" + sub.getCode() + ", app=" + sub.getApp() + ", client=" + sub.getClient() +
                ", startDate=" + sub.getStartDate() + ", endDate=" + sub.getEndDate() + ", type=" + sub.getType() + "]",
                sub.toString());
    }

}
