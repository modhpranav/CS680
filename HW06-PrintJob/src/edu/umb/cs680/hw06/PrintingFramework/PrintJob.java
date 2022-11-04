package edu.umb.cs680.hw06.PrintingFramework;

public class PrintJob {
    private String job;

    public PrintJob(String job) {
        this.job = job;
    }

    public String startprint(){
        return this.job;
    }

    public static void main(String[] args){}
}
