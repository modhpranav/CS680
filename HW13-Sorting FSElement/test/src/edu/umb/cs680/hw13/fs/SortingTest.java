package edu.umb.cs680.hw13.fs;

import edu.umb.cs680.hw13.fs.util.CountingVisitor;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import  org.junit.jupiter.api.BeforeAll;

import java.util.Arrays;
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
        List<FSElement> children = rootDir.getChildren(new AlphabeticalSort());
        List<String> actual = getSortedNames(children);
        assertEquals(expected, actual);
    }


    @Test
    public void verifyReverseAlphabeticalOrderBasedSorting() {
        List<String> expected = new LinkedList<>(Arrays.asList("link to pictures dir", "link to file x", "home", "bin", "apps"));
        Directory rootDir = fs.getRootDirs().get(0);
        List<FSElement> children = rootDir.getChildren(new ReverseAlphabeticalSort());
        List<String> actual = getSortedNames(children);
        assertEquals(expected, actual);
    }

    @Test
    public void verifySizeBasedSorting() {
        List<String> expected = new LinkedList<>(Arrays.asList("link to pictures dir", "link to file x", "apps", "bin", "home"));
        Directory rootDir = fs.getRootDirs().get(0);
        List<FSElement> children = rootDir.getChildren(new SizeSort());
        List<String> actual = getSortedNames(children);
        assertEquals(expected, actual);
    }

    @Test
    public void verifyTimestampBasedSorting() {
        List<String> expected = new LinkedList<>(Arrays.asList("apps", "bin", "home", "link to pictures dir", "link to file x"));
        Directory rootDir = fs.getRootDirs().get(0);
        List<FSElement> children = rootDir.getChildren(new CreationTimeSort());
        List<String> actual = getSortedNames(children);
        assertEquals(expected, actual);
    }

    @Test
    public void verifyElementKindBasedSorting() {
        List<String> expected = new LinkedList<>(Arrays.asList("apps", "bin", "home", "link to pictures dir", "link to file x"));
        Directory rootDir = fs.getRootDirs().get(0);
        List<FSElement> children = rootDir.getChildren(new ElementKindSort());
        List<String> actual = getSortedNames(children);
        assertEquals(expected, actual);
    }

}