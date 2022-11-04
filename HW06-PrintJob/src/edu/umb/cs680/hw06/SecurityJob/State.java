package edu.umb.cs680.hw06.SecurityJob;

public interface State {
    public void login(SecurityContext ctx, String pwd) throws Exception;
    public void logout(SecurityContext ctx);

    public static void main(String[] args){}

}
