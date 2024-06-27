package br.pucrs.bruno.laitano.subscriptionmanagement.dataAccess;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PaymentTest {

    private Payment payment;

    @BeforeEach
    public void setup() {

        Application app = new Application(1, "app", 30);
        Client client = new Client(3, "name", "email");
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        long code = 3;
        Double value = 300.00;
        Subscription sub = new Subscription(200, app, client, date, date);
        payment = new Payment(code, sub, value, date, "30");
    }

    /** Tests if the application of a 15% discount promotion is aplied */
    @Test
    public void promotion15Off() {
        payment.setPaymentValue(100.00);
        payment.setPromotion("15");
        payment.calculatePromotion();
        assertEquals(85.00, payment.getPaymentValue());
        assertEquals("15", payment.getPromotion());
    }

    /** Tests if the application of a 15% discount promotion is aplied */
    @Test
    public void promotion25Off() {
        payment.setPaymentValue(100.00);
        payment.setPromotion("25");
        payment.calculatePromotion();
        assertEquals(75.00, payment.getPaymentValue());
        assertEquals("25", payment.getPromotion());
    }

    /** Tests if the application of a 15% discount promotion is aplied */
    @Test
    public void promotion50Off() {
        payment.setPaymentValue(100.00);
        payment.setPromotion("50");
        payment.calculatePromotion();
        assertEquals(50.00, payment.getPaymentValue());
        assertEquals("50", payment.getPromotion());
    }

    /** Tests if the application recognizes a invalid promotion */
    @Test
    public void invalidPromotion() {
        payment.setPaymentValue(100.00);
        payment.setPromotion("200");
        payment.calculatePromotion();
        assertEquals(100.00, payment.getPaymentValue());
        assertEquals("200", payment.getPromotion());
    }

    @Test
    public void setCodeto3() {
        long num = 3;
        payment.setCode(num);
        assertEquals(3, payment.getCode());
    }

    @Test
    public void setnewSubscription() {
        Subscription sub = new Subscription();
        payment.setSubscription(sub);
        assertEquals(sub, payment.getSubscription());
    }

    @Test
    public void setPaymentDatetoToday() {
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        payment.setPaymentDate(date);
        assertEquals(date, payment.getPaymentDate());
    }

    @Test
    public void toStringTest() {
        assertEquals("Payment [code=" + 3 + ", subscription=" + payment.getSubscription() + ", paymentValue="
                + 300.00 + ", paymentDate=" + payment.getPaymentDate() + ", promotion=" + payment.getPromotion() + "]",
                payment.toString());
    }

}
