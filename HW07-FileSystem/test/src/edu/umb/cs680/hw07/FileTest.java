package edu.umb.cs680.hw07;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class FileTest {
    static LocalDateTime localTime = LocalDateTime.now();

    Directory root = new Directory(null, "root", 0, localTime);  // directory has size 0
    Directory apps = new Directory(root, "apps", 0, localTime);  // directory has size 0
    Directory lib = new Directory(root, "lib", 0, localTime);  // directory has size 0
    Directory home = new Directory(root, "home", 0, localTime);  // directory has size 0

    File x = new File(apps, "x", 50, localTime);
    File y = new File(apps, "y", 50, localTime);

    File z = new File(lib, "z", 50, localTime);
    File d = new File(home, "d", 50, localTime);
    Directory code = new Directory(home, "code", 0, localTime);
    File a = new File(code, "a", 50, localTime);
    File b = new File(code, "b", 50, localTime);
    File c = new File(code, "c", 25, localTime);

    private String[] fileToStringArray(File file) {
        return new String[]{ String.valueOf(file.isDirectory()), file.getName(), String.valueOf(file.getSize()),
                String.valueOf(file.getCreationTime()), file.getParent().getName() };
    }

    @Test
    public void verifyFileEqualityx() {
        String[] expected = { "false", "x", "50", String.valueOf(x.getCreationTime()), "apps" };
        File actual = x;
        assertArrayEquals(expected, fileToStringArray(actual));
    }

    @Test
    public void verifyFileEqualityz() {
        String[] expected = { "false", "z", "50", String.valueOf(x.getCreationTime()), "lib" };
        File actual = z;
        assertArrayEquals(expected, fileToStringArray(actual));
    }

    @Test
    public void verifyFileEqualitya() {
        String[] expected = { "false", "a", "50", String.valueOf(x.getCreationTime()), "code" };
        File actual = a;
        assertArrayEquals(expected, fileToStringArray(actual));
    }

    @Test
    public void isFileTest() {
        assertFalse(c.isDirectory());
    }

}