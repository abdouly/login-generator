package geco;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by rahamamane on 23/11/16.
 */
public class LoginServiceTest {
    LoginService loginService;
    @Before
    public void setUp() throws Exception {
        String loginExistants []= {};
        loginService = new LoginService(loginExistants);
        System.out.println(loginExistants);
    }

    @Test
    public void loginExists() throws Exception {
        loginService.addLogin("kotoly");
        Assert.assertEquals(true, loginService.loginExists("kotoly"));
        loginService.addLogin("zouzou");
        Assert.assertEquals(false,loginService.loginExists("geco"));
    }

    @Test
    public void addLogin() throws Exception {
        loginService.addLogin("geco");
        assertTrue(loginService.loginExists("geco"));
        assertFalse(loginService.loginExists("deco"));
    }

    @Test
    public void findAllLoginsStartingWith() throws Exception {
        loginService.addLogin("kollet");
        loginService.addLogin("koto");
        loginService.addLogin("poto");
        List<String> listLogin = loginService.findAllLoginsStartingWith("ko");
        assertTrue(!listLogin.isEmpty());
        assertFalse(listLogin.contains("auto"));
        assertTrue(listLogin.contains("koto"));
    }

    @Test
    public void findAllLogins() throws Exception {
        loginService.addLogin("kollet");
        loginService.addLogin("koto");
        loginService.addLogin("poto");
        List<String> listLogin = loginService.findAllLoginsStartingWith("ko");
        assertTrue(!listLogin.isEmpty());
        assertFalse(listLogin.contains("auto"));
        assertTrue(listLogin.contains("koto"));
    }

}