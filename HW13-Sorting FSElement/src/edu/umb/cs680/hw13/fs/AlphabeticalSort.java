package edu.umb.cs680.hw13.fs;

import java.util.Comparator;

public class AlphabeticalSort implements Comparator<FSElement> {

    public int compare(FSElement fselement1, FSElement fselement2) {
//        System.out.println(fselement1.name);
//        System.out.println(fselement2.name);
        return fselement1.name.compareTo(fselement2.name);
    }

}
