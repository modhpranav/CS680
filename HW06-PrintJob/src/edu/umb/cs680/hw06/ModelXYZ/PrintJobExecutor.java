package edu.umb.cs680.hw06.ModelXYZ;
import edu.umb.cs680.hw06.PrintingFramework.PrintJob;
import edu.umb.cs680.hw06.SecurityJob.SecurityContext;

public class PrintJobExecutor extends edu.umb.cs680.hw06.PrintingFramework.PrintJobExecutor {

    @Override
    protected void doAuthentication(String pwd, SecurityContext ctx){
        ctx.login(pwd);
        System.out.println("User LoggedIn");
    }

    @Override
    protected void doAccessControl(){}

    @Override
    protected void doErrorHandling(Exception error){}

    @Override
    protected void doPrint(PrintJob job, String pwd, SecurityContext ctx){
        System.out.println("Starting to Print.");
        String startprint = job.startprint();
        System.out.println(startprint);
    }

    public static void main(String[] args){}
}