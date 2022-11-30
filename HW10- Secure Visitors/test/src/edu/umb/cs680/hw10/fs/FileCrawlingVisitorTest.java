package edu.umb.cs680.hw10.fs;

import edu.umb.cs680.hw10.fs.FileSystem;
import edu.umb.cs680.hw10.fs.SecurityJob.SecurityContext;
import edu.umb.cs680.hw10.fs.SecurityJob.User;
import edu.umb.cs680.hw10.fs.util.FileCrawlingVisitor;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import  org.junit.jupiter.api.BeforeAll;

public class FileCrawlingVisitorTest {

    public static FileSystem fs;

    @BeforeAll
    public static void setUpFS(){
        fs = new TestFixtureInitializer().createFS();
    }

    @Test
    public void verifyFileCountWithAuthentication() throws Exception {
        int expected = 5;
        User user = new User("pranav", "abc");
        SecurityContext ctx = new SecurityContext(user);
        ctx.login("abc");
        FileCrawlingVisitor visitor = new FileCrawlingVisitor();
        Directory rootDir = fs.getRootDirs().get(0);
        rootDir.accept(visitor, ctx);
        assertEquals(expected,visitor.getFiles().size());
    }

    @Test
    public void verifyFileCountWithOutAuthentication() throws Exception {
        int expected = 5;
        User user = new User("pranav", "abc");
        SecurityContext ctx = new SecurityContext(user);
        FileCrawlingVisitor visitor = new FileCrawlingVisitor();
        Directory rootDir = fs.getRootDirs().get(0);
        Exception thrown = assertThrows(
                Exception.class,
                () -> rootDir.accept(visitor, ctx),
                "Expected to throw Authentication Error."
        );
        assertTrue(thrown.getMessage().contains("Please login to visit."), "Login Failed.");
    }

}
