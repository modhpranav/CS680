package edu.umb.cs680.hw07;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class FileTest {
    public static FileSystem fs;

    @BeforeAll
    public static void setUpFS(){
        fs = new TestFixtureInitializer().createFS();
    }

    private String[] fileToStringArray(File file) {
        return new String[]{ String.valueOf(file.isDirectory()), file.getName(), String.valueOf(file.getSize()),
                String.valueOf(file.getCreationTime()), file.getParent().getName() };
    }

    @Test
    public void verifyFileEqualityx() {
        FSElement x = fs.getRootDirs().get(0).getChildren().get(0).getChildren().get(0);
        String[] expected = { "false", "x", "50", String.valueOf(x.getCreationTime()), "apps" };
        FSElement actual = x;
        assertArrayEquals(expected, fileToStringArray((File) actual));
    }

    @Test
    public void verifyFileEqualityz() {
        FSElement z = fs.getRootDirs().get(0).getChildren().get(1).getChildren().get(0);
        String[] expected = { "false", "z", "50", String.valueOf(z.getCreationTime()), "lib" };
        FSElement actual = z;
        assertArrayEquals(expected, fileToStringArray((File) actual));
    }

    @Test
    public void verifyFileEqualitya() {
        FSElement a = fs.getRootDirs().get(0).getChildren().get(2).getChildren().get(1).getChildren().get(0);
        String[] expected = { "false", "a", "50", String.valueOf(a.getCreationTime()), "code" };
        FSElement actual = a;
        assertArrayEquals(expected, fileToStringArray((File) actual));
    }

    @Test
    public void isFileTest() {
        FSElement c = fs.getRootDirs().get(0).getChildren().get(2).getChildren().get(1).getChildren().get(2);
        assertFalse(c.isDirectory());
    }

}