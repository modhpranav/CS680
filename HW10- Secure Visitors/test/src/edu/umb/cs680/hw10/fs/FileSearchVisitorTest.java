package edu.umb.cs680.hw10.fs;

import edu.umb.cs680.hw10.fs.SecurityJob.SecurityContext;
import edu.umb.cs680.hw10.fs.SecurityJob.User;
import edu.umb.cs680.hw10.fs.util.CountingVisitor;
import edu.umb.cs680.hw10.fs.util.FileSearchVisitor;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import  org.junit.jupiter.api.BeforeAll;

public class FileSearchVisitorTest {

    public static FileSystem fs;

    @BeforeAll
    public static void setUpFS(){
        fs = new TestFixtureInitializer().createFS();
    }


    @Test
    public void verifyFileNotExistCount() throws Exception {
        int expected = 5;
        User user = new User("pranav", "abc");
        SecurityContext ctx = new SecurityContext(user);
        ctx.login("abc");
        FileSearchVisitor visitor = new FileSearchVisitor("example.txt");
        Directory rootDir = fs.getRootDirs().get(0);
        rootDir.accept( visitor, ctx );
        visitor.getFoundFiles().size();
        assertNotEquals(expected,visitor.getFoundFiles());
    }

    @Test
    public void verifyFileExistCount() throws Exception {
        int expected = 1;
        User user = new User("pranav", "abc");
        SecurityContext ctx = new SecurityContext(user);
        ctx.login("abc");
        FileSearchVisitor visitor = new FileSearchVisitor("x");
        Directory rootDir = fs.getRootDirs().get(0);
        rootDir.accept( visitor, ctx );
        assertEquals(expected,visitor.getFoundFiles().size());
    }

    @Test
    public void verifyFileNotExistCountWithoutAuthentication() throws Exception {
        int expected = 5;
        User user = new User("pranav", "abc");
        SecurityContext ctx = new SecurityContext(user);
        FileSearchVisitor visitor = new FileSearchVisitor("example.txt");
        Directory rootDir = fs.getRootDirs().get(0);
        Exception thrown = assertThrows(
                Exception.class,
                () -> rootDir.accept(visitor, ctx),
                "Expected to throw Authentication Error."
        );
        assertTrue(thrown.getMessage().contains("Please login to visit."), "Login Failed.");
    }

    @Test
    public void verifyFileExistCountWithoutAuthentication() throws Exception {
        int expected = 1;
        User user = new User("pranav", "abc");
        SecurityContext ctx = new SecurityContext(user);
        FileSearchVisitor visitor = new FileSearchVisitor("x");
        Directory rootDir = fs.getRootDirs().get(0);
        Exception thrown = assertThrows(
                Exception.class,
                () -> rootDir.accept(visitor, ctx),
                "Expected to throw Authentication Error."
        );
        assertTrue(thrown.getMessage().contains("Please login to visit."), "Login Failed.");
    }

}
