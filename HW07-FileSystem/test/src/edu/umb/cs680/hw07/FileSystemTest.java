package edu.umb.cs680.hw07;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

public class FileSystemTest {

    @Test
    public void getFileSystemNonNull() {
        assertNotNull(FileSystem.getFileSystem());
    }

    @Test
    public void getFileSystemSingletonTest() {
        FileSystem filesys1 = FileSystem.getFileSystem();
        FileSystem filesys2 = FileSystem.getFileSystem();
        assertSame(filesys1, filesys2);
    }

}
