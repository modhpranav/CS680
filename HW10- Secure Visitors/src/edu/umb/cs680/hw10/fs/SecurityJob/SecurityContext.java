package edu.umb.cs680.hw10.fs.SecurityJob;

public class SecurityContext {

    private User user;

    private static State state;

    private Boolean isActive;

    public SecurityContext(User user){
        this.user = user;
        this.isActive = false;
        this.state = LoggedOut.getInstance();
    }

    public void changeState(State new_state){
        this.state = new_state;
    }

    public void login(String pwd) {
        try {
            state.login(this, pwd);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public void logout(){
        state.logout(this);
    }

    public Boolean getIsActive(){
        if (state instanceof LoggedIn) {
            return true;
        }else{
            return false;
        }
    }

    public static State getState() {
        return state;
    }

    public User getUser(){
        return user;
    }

    public static void main(String[] args){}

}
