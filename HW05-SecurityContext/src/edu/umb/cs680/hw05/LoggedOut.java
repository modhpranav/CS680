package edu.umb.cs680.hw05;

public class LoggedOut implements State {

    private static LoggedOut instance = null;

    private static SecurityContext ctx;

    private LoggedOut() { }

    public static LoggedOut getInstance() {
        if(instance == null) {
            instance = new LoggedOut();
        }
        return instance;
    }

    public void login(SecurityContext ctx, String pwd) {
        if (Authenticator.authenticate(ctx, pwd)){
            ctx.changeState(LoggedIn.getInstance());
        }else{
            throw new Error("False pwd");
        }
    }

    public void logout(SecurityContext ctx) {

    }
}
