package edu.umb.cs680.hw07;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import  org.junit.jupiter.api.BeforeAll;

public class DirectoryTest {

    public static FileSystem fs;

    @BeforeAll
    public static void setUpFS(){
        fs = new TestFixtureInitializer().createFS();
    }

    private String[] dirToStringArray(Directory dir) {
        return new String[]{ String.valueOf(dir.isDirectory()), dir.getName(), String.valueOf(dir.getTotalSize()),
                String.valueOf(dir.getCreationTime()), String.valueOf(dir.countChildren()) };
    }

    @Test
    public void rootDirectoryTest() {
        String[] expected = { "true", "root", "325", String.valueOf(fs.getRootDirs().get(0).getCreationTime()), "3" };
        Directory actual = fs.getRootDirs().get(0);
        assertArrayEquals(expected, dirToStringArray(actual));
    }

    @Test
    public void homeDirectoryTest() {
        FSElement home = fs.getRootDirs().get(0).getChildren().get(2);
        String[] expected = { "true", "home", "175", String.valueOf(home.getCreationTime()), "2" };
        FSElement actual = home;
        assertArrayEquals(expected, dirToStringArray((Directory) actual));
    }

    @Test
    public void libDirectoryTest() {
        FSElement lib = fs.getRootDirs().get(0).getChildren().get(1);
        String[] expected = { "true", "lib", "50", String.valueOf(lib.getCreationTime()), "1" };
        FSElement actual = lib;
        assertArrayEquals(expected, dirToStringArray((Directory) actual));
    }

    @Test
    public void appsDirectoryTest() {
        FSElement apps = fs.getRootDirs().get(0).getChildren().get(0);
        String[] expected = { "true", "apps", "100", String.valueOf(apps.getCreationTime()), "2" };
        FSElement actual = apps;
        assertArrayEquals(expected, dirToStringArray((Directory) actual));
    }

    @Test
    public void rootIsDirectoryTest() {
        assertTrue(fs.getRootDirs().get(0).isDirectory());
    }

    @Test
    public void homeIsDirectoryTest() {
        assertTrue(fs.getRootDirs().get(0).getChildren().get(2).isDirectory());
    }

    @Test
    public void libIsDirectoryTest() {
        assertTrue(fs.getRootDirs().get(0).getChildren().get(1).isDirectory());
    }


    @Test
    public void appendChildrenTest() {
        assertSame(fs.getRootDirs().get(0), fs.getRootDirs().get(0).getChildren().get(2).getParent());
    }

    @Test
    public void getTotalSizeTest() {
        assertEquals(325, fs.getRootDirs().get(0).getTotalSize());
    }

}