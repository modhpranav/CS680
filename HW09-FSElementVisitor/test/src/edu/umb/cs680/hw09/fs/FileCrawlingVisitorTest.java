package edu.umb.cs680.hw09.fs;

import edu.umb.cs680.hw09.fs.util.CountingVisitor;
import edu.umb.cs680.hw09.fs.util.FileCrawlingVisitor;
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
    public void verifyFileCount() {
        int expected = 5;
        FileCrawlingVisitor visitor = new FileCrawlingVisitor();
        Directory rootDir = fs.getRootDirs().get(0);
        rootDir.accept( visitor );
        assertEquals(expected,visitor.getFiles().size());
    }

}
