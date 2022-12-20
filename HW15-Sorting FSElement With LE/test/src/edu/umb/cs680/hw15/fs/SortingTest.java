package edu.umb.cs680.hw15.fs;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import  org.junit.jupiter.api.BeforeAll;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class SortingTest {

    public static FileSystem fs;

    @BeforeAll
    public static void setUpFS(){
        fs = new TestFixtureInitializer().createFS();
    }

    public  static  List<String> getSortedNames(List<FSElement> data){
        List<String> actual = new LinkedList<>();
        for(int i = 0; i < data.size(); i++) {
            String name = data.get(i).getName();
            actual.add(name);
        }
        return actual;
    }


    @Test
    public void verifyAlphabeticalBasedSorting() {
        List<String> expected = new LinkedList<>(Arrays.asList("apps", "bin", "home", "link to file x", "link to pictures dir"));
        Directory rootDir = fs.getRootDirs().get(0);
        List<FSElement> children = rootDir.getChildren(Comparator.comparing(FSElement :: getName, Comparator.naturalOrder()));
        List<String> actual = getSortedNames(children);
        assertEquals(expected, actual);
    }


    @Test
    public void verifyReverseAlphabeticalOrderBasedSorting() {
        List<String> expected = new LinkedList<>(Arrays.asList("link to pictures dir", "link to file x", "home", "bin", "apps"));
        Directory rootDir = fs.getRootDirs().get(0);
        List<FSElement> children = rootDir.getChildren(Comparator.comparing(FSElement :: getName, Comparator.reverseOrder()));
        List<String> actual = getSortedNames(children);
        assertEquals(expected, actual);
    }

    @Test
    public void verifySizeBasedSorting() {
        List<String> expected = new LinkedList<>(Arrays.asList("link to file x", "link to pictures dir", "apps", "bin", "home"));
        Directory rootDir = fs.getRootDirs().get(0);
        List<FSElement> children = rootDir.getChildren(Comparator.comparing(FSElement :: getSize));
        List<String> actual = getSortedNames(children);
        assertEquals(expected, actual);
    }

    @Test
    public void verifyTimestampBasedSorting() {
        List<String> expected = new LinkedList<>(Arrays.asList("apps", "bin", "home", "link to file x", "link to pictures dir"));
        Directory rootDir = fs.getRootDirs().get(0);
        List<FSElement> children = rootDir.getChildren(Comparator.comparing(FSElement :: getCreationTime, Comparator.naturalOrder()));
        List<String> actual = getSortedNames(children);
        assertEquals(expected, actual);
    }

    @Test
    public void verifyElementKindBasedSorting() {
        List<String> expected = new LinkedList<>(Arrays.asList("apps", "bin", "home", "link to file x", "link to pictures dir"));
        Directory rootDir = fs.getRootDirs().get(0);
        List<FSElement> children = rootDir.getChildren(Comparator.comparing(FSElement :: getType, Comparator.naturalOrder()));
        List<String> actual = getSortedNames(children);
        assertEquals(expected, actual);
    }

}