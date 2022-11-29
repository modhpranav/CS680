package edu.umb.cs680.hw09.fs;

import edu.umb.cs680.hw09.fs.util.CountingVisitor;
import edu.umb.cs680.hw09.fs.util.FileSearchVisitor;
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
    public void verifyFileNotExistCount() {
        int expected = 5;
        FileSearchVisitor visitor = new FileSearchVisitor("example.txt");
        Directory rootDir = fs.getRootDirs().get(0);
        rootDir.accept( visitor );
        visitor.getFoundFiles().size();
        assertNotEquals(expected,visitor.getFoundFiles());
    }

    @Test
    public void verifyFileExistCount() {
        int expected = 1;
        FileSearchVisitor visitor = new FileSearchVisitor("x");
        Directory rootDir = fs.getRootDirs().get(0);
        rootDir.accept( visitor );
        assertEquals(expected,visitor.getFoundFiles().size());
    }

}
