package edu.umb.cs680.hw06.PrintingFramework;

import edu.umb.cs680.hw06.SecurityJob.SecurityContext;

abstract public class PrintJobExecutor {
    protected PrintJobExecutor(){}
    public boolean execute(PrintJob job, String pwd, SecurityContext ctx){
        try{
            doAuthentication(pwd, ctx);
            doAccessControl();
            doPrint(job, pwd, ctx);
            return true;
        }catch (Exception error) {
            doErrorHandling(error);
            return false;
        }
    }

    protected abstract void doAuthentication(String pwd, SecurityContext ctx) throws Exception;
    protected abstract void doAccessControl();
    protected abstract void doPrint(PrintJob job, String pwd, SecurityContext ctx) throws Exception;
    protected abstract void doErrorHandling(Exception error);

    public static void main(String[] args){}
}
