package edu.umb.cs680.hw05;

public class LoggedIn implements State {

    private static LoggedIn instance = null;
    private LoggedIn() { }

    public static LoggedIn getInstance() {
        if(instance == null) {
            instance = new LoggedIn();
        }
        return instance;
    }

    public void login(SecurityContext ctx, String pwd) {
        boolean isActive = ctx.getIsActive();
        if (!isActive){
            ctx.changeState((State) LoggedOut.getInstance());
            ctx.login(pwd);
        }
    }

    public void logout(SecurityContext ctx) {
        ctx.changeState((State) LoggedOut.getInstance());
    }
}
