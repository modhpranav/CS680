package edu.umb.cs680.hw13.fs;

import java.util.Comparator;

public class ReverseAlphabeticalSort implements Comparator<FSElement> {

    public int compare(FSElement fselement1, FSElement fselement2) {
        return fselement2.getName().compareTo(fselement1.getName());
    }
}
