package edu.umb.cs680.hw07;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.LinkedList;

public class DirectoryTest {

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


    private String[] dirToStringArray(Directory dir) {
        return new String[]{ String.valueOf(dir.isDirectory()), dir.getName(), String.valueOf(dir.getTotalSize()),
                String.valueOf(dir.getCreationTime()), String.valueOf(dir.countChildren()) };
    }

    @Test
    public void rootDirectoryTest() {
        String[] expected = { "true", "root", "325", String.valueOf(root.getCreationTime()), "3" };
        Directory actual = root;
        assertArrayEquals(expected, dirToStringArray(actual));
    }

    @Test
    public void homeDirectoryTest() {
        String[] expected = { "true", "home", "175", String.valueOf(home.getCreationTime()), "2" };
        Directory actual = home;
        assertArrayEquals(expected, dirToStringArray(actual));
    }

    @Test
    public void libDirectoryTest() {
        String[] expected = { "true", "lib", "50", String.valueOf(lib.getCreationTime()), "1" };
        Directory actual = lib;
        assertArrayEquals(expected, dirToStringArray(actual));
    }

    @Test
    public void appsDirectoryTest() {
        String[] expected = { "true", "apps", "100", String.valueOf(apps.getCreationTime()), "2" };
        Directory actual = apps;
        assertArrayEquals(expected, dirToStringArray(actual));
    }

    @Test
    public void rootIsDirectoryTest() {
        assertTrue(root.isDirectory());
    }

    @Test
    public void homeIsDirectoryTest() {
        assertTrue(home.isDirectory());
    }

    @Test
    public void libIsDirectoryTest() {
        assertTrue(lib.isDirectory());
    }


    @Test
    public void appendChildrenTest() {
        assertSame(root, lib.getParent());
    }

    @Test
    public void rootcountChildrenTest() {
        System.out.println(Arrays.toString(root.getChildren().toArray()));
        assertEquals(3, root.countChildren());;
    }

    @Test
    public void homecountChildrenTest() {
        assertSame(2, home.countChildren());
    }

    @Test
    public void getTotalSizeTest() {
        assertEquals(325, root.getTotalSize());
    }

    @Test
    public void homegetTotalSizeTest() {
        assertEquals(175, home.getTotalSize());
    }

}