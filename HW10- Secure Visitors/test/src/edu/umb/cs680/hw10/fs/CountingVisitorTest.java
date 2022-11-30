package edu.umb.cs680.hw10.fs;

import edu.umb.cs680.hw10.fs.SecurityJob.SecurityContext;
import edu.umb.cs680.hw10.fs.SecurityJob.User;
import edu.umb.cs680.hw10.fs.util.CountingVisitor;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import  org.junit.jupiter.api.BeforeAll;

public class CountingVisitorTest {

    public static FileSystem fs;

    @BeforeAll
    public static void setUpFS(){
        fs = new TestFixtureInitializer().createFS();
    }


    @Test
    public void verifyDirectoryCount() throws Exception {
        int expected = 5;
        User user = new User("pranav", "abc");
        SecurityContext ctx = new SecurityContext(user);
        ctx.login("abc");
        CountingVisitor visitor = new CountingVisitor(0,0,0);
        Directory rootDir = fs.getRootDirs().get(0);
        rootDir.accept( visitor, ctx );
        assertEquals(expected,visitor.getDirNum());
        System.out.println(visitor.getDirNum());
    }

    @Test
    public void verifyFileCount() throws Exception {
        int expected = 5;
        User user = new User("pranav", "abc");
        SecurityContext ctx = new SecurityContext(user);
        ctx.login("abc");
        CountingVisitor visitor = new CountingVisitor(0,0,0);
        System.out.println(visitor.getFileNum());
        Directory rootDir = fs.getRootDirs().get(0);
        rootDir.accept( visitor, ctx );
        assertEquals(expected,visitor.getFileNum());
    }

    @Test
    public void verifyLinkCount() throws Exception {
        int expected = 2;
        User user = new User("pranav", "abc");
        SecurityContext ctx = new SecurityContext(user);
        ctx.login("abc");
        CountingVisitor visitor = new CountingVisitor(0,0,0);
        Directory rootDir = fs.getRootDirs().get(0);
        rootDir.accept( visitor, ctx );
        assertEquals(expected,visitor.getLinkNum());
    }

    @Test
    public void verifyDirectoryCountWithoutAuthentication() throws Exception {
        int expected = 5;
        User user = new User("pranav", "abc");
        SecurityContext ctx = new SecurityContext(user);
        CountingVisitor visitor = new CountingVisitor(0,0,0);
        Directory rootDir = fs.getRootDirs().get(0);
        Exception thrown = assertThrows(
                Exception.class,
                () -> rootDir.accept(visitor, ctx),
                "Expected to throw Authentication Error."
        );
        assertTrue(thrown.getMessage().contains("Please login to visit."), "Login Failed.");
    }

    @Test
    public void verifyFileCountWithoutAuthentication() throws Exception {
        int expected = 5;
        User user = new User("pranav", "abc");
        SecurityContext ctx = new SecurityContext(user);
        CountingVisitor visitor = new CountingVisitor(0,0,0);
        System.out.println(visitor.getFileNum());
        Directory rootDir = fs.getRootDirs().get(0);
        Exception thrown = assertThrows(
                Exception.class,
                () -> rootDir.accept(visitor, ctx),
                "Expected to throw Authentication Error."
        );
        assertTrue(thrown.getMessage().contains("Please login to visit."), "Login Failed.");
    }

    @Test
    public void verifyLinkCountWithoutAuthentication() throws Exception {
        int expected = 2;
        User user = new User("pranav", "abc");
        SecurityContext ctx = new SecurityContext(user);
        CountingVisitor visitor = new CountingVisitor(0,0,0);
        Directory rootDir = fs.getRootDirs().get(0);
        Exception thrown = assertThrows(
                Exception.class,
                () -> rootDir.accept(visitor, ctx),
                "Expected to throw Authentication Error."
        );
        assertTrue(thrown.getMessage().contains("Please login to visit."), "Login Failed.");
    }

}