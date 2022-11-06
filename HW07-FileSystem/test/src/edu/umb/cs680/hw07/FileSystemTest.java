package edu.umb.cs680.hw07;

import org.junit.jupiter.api.Test;
import  org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

public class FileSystemTest {

    public static FileSystem fs;

    @BeforeAll
    public static void setUpFS(){
        fs = new TestFixtureInitializer().createFS();
    }

    @Test
    public void getFileSystemNonNull() {
        assertNotNull(fs);
    }

    @Test
    public void getFileSystemSingletonTest() {
        FileSystem filesys1 = FileSystem.getFileSystem();
        FileSystem filesys2 = FileSystem.getFileSystem();
        assertSame(filesys1, filesys2);
    }

}
