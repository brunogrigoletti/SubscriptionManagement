package br.pucrs.bruno.laitano.subscriptionmanagement.dataAccess;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserTest {

    private User user;

    @BeforeEach
    public void Setup() {
        user = new User(1, "username", "password");
    }

    @Test
    public void verifygetCode() {
        assertEquals(1, user.getCode());
    }

    @Test
    public void verifygetUsername() {
        assertEquals("username", user.getUsername());
    }

    @Test
    public void verifygetPassword() {
        assertEquals("password", user.getPassword());
    }

    @Test
    public void verifysetCode() {
        user.setCode(4);
        assertEquals(4, user.getCode());
    }

    @Test
    public void verifysetUsename() {
        user.setUsername("newname");
        assertEquals("newname", user.getUsername());
    }

    @Test
    public void verifysetPassword() {
        user.setPassword("newpassword");
        assertEquals("newpassword", user.getPassword());
    }

    @Test
    public void verifyToString() {
        assertEquals("User [code=" + "1" + ", username=" + "username" + ", password=" + "password" + "]",
                user.toString());
    }

    @Test
    public void addNewAppgetListApps() {
        Application app1 = new Application(2, "app1", 30);
        user.addNewApp(app1);
        List<Application> apps = user.getApplicationsfromUser();
        assertNotNull(apps);
        assertEquals(1, apps.size());
        assertEquals(app1, apps.get(0));
    }

    @Test
    void addtwoNewAppremoveoneApp() {
        Application app1 = new Application(2, "app1", 30);
        user.addNewApp(app1);
        Application app2 = new Application(2, "app2", 40);
        user.addNewApp(app2);
        user.removeApp(app1);
        List<Application> apps = user.getApplicationsfromUser();
        assertNotNull(apps);
        assertEquals(1, apps.size());
        assertEquals(app2, apps.get(0));
    }

    @Test
    void addtwoNewAppremoveoneAppbyId() {
        Application app1 = new Application(1, "app1", 30);
        user.addNewApp(app1);
        Application app2 = new Application(2, "app2", 40);
        user.addNewApp(app2);
        user.removeAppByID(2);
        List<Application> apps = user.getApplicationsfromUser();
        assertNotNull(apps);
        assertEquals(1, apps.size());
        assertEquals(app1, apps.get(0));
    }

}
