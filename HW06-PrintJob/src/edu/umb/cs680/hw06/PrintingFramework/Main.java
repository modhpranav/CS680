package edu.umb.cs680.hw06.PrintingFramework;

import edu.umb.cs680.hw06.SecurityJob.SecurityContext;
import edu.umb.cs680.hw06.SecurityJob.User;

public class Main {
    public static void main(String[] args) {
        try {
            PrintJob job = new PrintJob("Hello World");
            User user1 = new User("ABC", "ABC");
            SecurityContext ctx = new SecurityContext(user1);

            // Printing with ModelABC
            System.out.println("Test for ModelABC");
            PrintJobExecutor exModelABC = new edu.umb.cs680.hw06.ModelABC.PrintJobExecutor();
            exModelABC.execute(job, "pass", ctx);

            // Printing with ModelXYZ
            System.out.println("Test For ModelXYZ with user logged in");
            PrintJobExecutor exModelXYZ = new edu.umb.cs680.hw06.ModelXYZ.PrintJobExecutor();
            exModelXYZ.execute(job, "ABC", ctx);

        } catch (Exception error) {
//            System.out.println(error.getMessage());
        }
    }
}
