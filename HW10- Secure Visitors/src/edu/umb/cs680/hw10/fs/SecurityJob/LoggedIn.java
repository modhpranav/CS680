package edu.umb.cs680.hw10.fs.SecurityJob;

public class LoggedIn implements State {

    private static LoggedIn instance = null;
    private LoggedIn() { }

    public static LoggedIn getInstance() {
        if(instance == null) {
            instance = new LoggedIn();
        }
        return instance;
    }

    @Override
    public void login(SecurityContext ctx, String pwd) throws Exception {
        boolean isActive = ctx.getIsActive();
        if (!isActive){
            ctx.logout();
            ctx.login(pwd);
        }
    }

    @Override
    public void logout(SecurityContext ctx){
        ctx.changeState(LoggedOut.getInstance());
    }

    public static void main(String[] args){}
}
