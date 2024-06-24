package br.pucrs.bruno.laitano.subscriptionmanagement.dataAccess;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ApplicationTests {

    private Application app;

    @BeforeEach
    public void initiateTests() {
        app = new Application(1, "apptest", 20);
    }

    @Test
    public void verifygetCode() {
        assertEquals(1, app.getCode());
    }

    @Test
    public void verifygetName() {
        assertEquals("apptest", app.getName());
    }

    @Test
    public void verifygetMonthlyCost() {
        assertEquals(20, app.getMonthlyCost());
    }

    @Test
    public void verifysetCode() {
        app.setCode(3);
        assertEquals(3, app.getCode());
    }

    @Test
    public void verifysetName() {
        app.setName("nameChanged");
        assertEquals("nameChanged", app.getName());
    }

    @Test
    public void verifysetMonthlyCost() {
        app.setMonthlyCost(40);
        assertEquals(40, app.getMonthlyCost());
    }

    @Test
    public void verifyToString() {
        assertEquals("Application [code=" + "1" + ", name=" + "apptest" + ", monthlyCost=" + "20.0" + "]",
                app.toString());
    }

}
