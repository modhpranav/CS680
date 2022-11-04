package edu.umb.cs680.hw06;

import edu.umb.cs680.hw06.PrintingFramework.PrintJob;
import edu.umb.cs680.hw06.PrintingFramework.PrintJobExecutor;
import org.junit.jupiter.api.Test;
import edu.umb.cs680.hw06.SecurityJob.SecurityContext;
import edu.umb.cs680.hw06.SecurityJob.User;
import static org.junit.jupiter.api.Assertions.*;

public class PrintingJobTest {

    @Test
    public void ModelABCprintjobtest(){
        PrintJob job = new PrintJob("Hello World");
        User user = new User("ABC", "ABC");
        SecurityContext ctx = new SecurityContext(user);
        PrintJobExecutor exModelABC = new edu.umb.cs680.hw06.ModelABC.PrintJobExecutor();
        boolean printstatus = exModelABC.execute(job, "pass", ctx);
        assertTrue(printstatus);
    }

    @Test
    public void ModelXYZValidPassPrintJobTest(){
        PrintJob job = new PrintJob("Hello World");
        User user = new User("ABC", "ABC");
        SecurityContext ctx = new SecurityContext(user);
        PrintJobExecutor exModelXYZ = new edu.umb.cs680.hw06.ModelXYZ.PrintJobExecutor();
        boolean printstatus = exModelXYZ.execute(job, "ABC", ctx);
        assertTrue(printstatus);
    }

    @Test
    public void ModelXYZInvalidPassPrintJobTest(){
        PrintJob job = new PrintJob("Hello World");
        User user = new User("ABC", "ABC");
        SecurityContext ctx = new SecurityContext(user);
        PrintJobExecutor exModelXYZ = new edu.umb.cs680.hw06.ModelXYZ.PrintJobExecutor();
        Error thrown = assertThrows(
                Error.class,
                () -> exModelXYZ.execute(job, "pass", ctx),
                "Wrong Password"
        );
        assertTrue(thrown.getMessage().contains("Wrong Password"), "Invalid password.");
    }
}
