package edu.umb.cs680.hw05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SecurityContextTest {

    @Test
    public void isinstanceoflogintest(){
        String user = "abc";
        String pwd = "asasd";
        User userObj = new User(user, pwd);
        SecurityContext ctx = new SecurityContext(userObj);
        ctx.login("asasd");
        assertEquals(true, ctx.getState() instanceof LoggedIn);
    }

    @Test
    public void isnotinstanceoflogintest(){
        String user = "abc";
        String pwd = "asasd";
        User userObj = new User(user, pwd);
        SecurityContext ctx = new SecurityContext(userObj);
        assertEquals(false, ctx.getState() instanceof LoggedIn);
    }

    @Test
    public void isinstanceofloggedouttest(){
        String user = "abc";
        String pwd = "asasd";
        User userObj = new User(user, pwd);
        SecurityContext ctx = new SecurityContext(userObj);
        ctx.login("asasd");
        ctx.logout();
        assertEquals(true, ctx.getState() instanceof LoggedOut);
    }

    @Test
    public void isnotinstanceofloggedouttest(){
        String user = "abc";
        String pwd = "asasd";
        User userObj = new User(user, pwd);
        SecurityContext ctx = new SecurityContext(userObj);
        ctx.login("asasd");
        assertEquals(false, ctx.getState() instanceof LoggedOut);
    }



}
