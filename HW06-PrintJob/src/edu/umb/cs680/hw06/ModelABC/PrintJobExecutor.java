package edu.umb.cs680.hw06.ModelABC;

import edu.umb.cs680.hw06.PrintingFramework.PrintJob;
import edu.umb.cs680.hw06.SecurityJob.SecurityContext;

public class PrintJobExecutor extends edu.umb.cs680.hw06.PrintingFramework.PrintJobExecutor {

    @Override
    protected void doAuthentication(String pwd, SecurityContext ctx){}

    @Override
    protected void doAccessControl(){}

    @Override
    protected void doErrorHandling(Exception error){System.out.println(error.getMessage());}

    @Override
    protected void doPrint(PrintJob job, String pwd, SecurityContext ctx){
       String startprint = job.startprint();
       System.out.println(startprint);
    }

    public static void main(String[] args){}

}
