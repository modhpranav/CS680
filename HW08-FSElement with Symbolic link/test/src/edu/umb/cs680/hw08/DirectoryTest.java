package edu.umb.cs680.hw08;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import  org.junit.jupiter.api.BeforeAll;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class DirectoryTest {

    public static FileSystem fs;
    public static Link d;
    public static Link e;
    static LocalDateTime localTime = LocalDateTime.now();

    @BeforeAll
    public static void setUpFS(){
        fs = new TestFixtureInitializer().createFS();
        d = new Link(fs.getRootDirs().get(0), "Link to pictures dir", 0, localTime, FileSystem.getFileSystem().getRootDirs().get(0).getChildren().get(2).getChildren().get(1));
        e = new Link(fs.getRootDirs().get(0), "Link to file x", 0, localTime, FileSystem.getFileSystem().getRootDirs().get(0).getChildren().get(0).getChildren().get(0));
    }

    public static String[] dirToStringArray(Link L){

        String LinkInfo[] = {
                Boolean.toString(L.isLink()), L.getName(), Integer.toString(L.getSize()), String.valueOf(L.getCreationTime()), L.getTarget().getName()};
        int i;

        for(i=0;i<LinkInfo.length;i++)
        {
            System.out.println(LinkInfo[i]);
        }
        return LinkInfo;
    }


    @Test
    public void verifyDirectoryEqualityLinkd() {
        String[] expected={"true","Link to pictures dir","0", String.valueOf(localTime),"pictures"};
        assertArrayEquals(expected,dirToStringArray(d));
    }

    @Test
    public void verifyDirectoryEqualityLinke() {
        String[] expected={"true","Link to file x","0", String.valueOf(localTime),"x"};
        assertArrayEquals(expected,dirToStringArray(e));
    }

}