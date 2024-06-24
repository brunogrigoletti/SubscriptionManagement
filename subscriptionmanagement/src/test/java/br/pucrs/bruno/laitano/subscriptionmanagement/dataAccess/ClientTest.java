package br.pucrs.bruno.laitano.subscriptionmanagement.dataAccess;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ClientTest {

    private Client client;

    @BeforeEach
    public void setup() {
        client = new Client(1, "clientTest", "test@test.com");
    }

    @Test
    public void verifygetCode() {
        assertEquals(1, client.getCode());
    }

    @Test
    public void verifygetName() {
        assertEquals("clientTest", client.getName());
    }

    @Test
    public void verifygetEmail() {
        assertEquals("test@test.com", client.getEmail());
    }

    @Test
    public void verifysetCode() {
        client.setCode(2);
        assertEquals(2, client.getCode());
    }

    @Test
    public void verifysetName() {
        client.setName("nameChanged");
        assertEquals("nameChanged", client.getName());
    }

    @Test
    public void verifysetEmail() {
        client.setEmail("newemail@test.com");
        assertEquals("newemail@test.com", client.getEmail());
    }

    @Test
    public void verifyToString() {
        assertEquals("Client [code=" + "1" + ", name=" + "clientTest" + ", email=" + "test@test.com" + "]",
                client.toString());
    }
}
