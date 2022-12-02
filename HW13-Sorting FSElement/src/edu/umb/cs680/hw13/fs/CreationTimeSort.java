package edu.umb.cs680.hw13.fs;

import java.util.Comparator;

public class CreationTimeSort implements Comparator<FSElement> {

    public int compare(FSElement fselement1, FSElement fselement2) {
        return fselement1.getCreationTime().compareTo(fselement2.getCreationTime());
    }
}
