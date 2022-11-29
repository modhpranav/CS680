package edu.umb.cs680.hw09.fs;

import edu.umb.cs680.hw09.fs.util.CountingVisitor;
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
    public void verifyDirectoryCount() {
        int expected = 5;
        CountingVisitor visitor = new CountingVisitor(0,0,0);
        Directory rootDir = fs.getRootDirs().get(0);
        rootDir.accept( visitor );
        assertEquals(expected,visitor.getDirNum());
        System.out.println(visitor.getDirNum());
    }

    @Test
    public void verifyFileCount() {
        int expected = 5;
        CountingVisitor visitor = new CountingVisitor(0,0,0);
        System.out.println(visitor.getFileNum());
        Directory rootDir = fs.getRootDirs().get(0);
        rootDir.accept( visitor );
        assertEquals(expected,visitor.getFileNum());
    }

    @Test
    public void verifyLinkCount() {
        int expected = 2;
        CountingVisitor visitor = new CountingVisitor(0,0,0);
        System.out.println(visitor.getDirNum());
        Directory rootDir = fs.getRootDirs().get(0);
        rootDir.accept( visitor );
        assertEquals(expected,visitor.getLinkNum());
        visitor = null;
    }


}