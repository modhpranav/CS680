package edu.umb.cs680.hw13.fs;

import java.util.Comparator;
import java.lang.Integer;

public class SizeSort  implements Comparator<FSElement> {

    public int compare(FSElement fselement1, FSElement fselement2) {
        Integer size1 = fselement1.getSize();
        Integer size2 = fselement2.getSize();
        return size1.compareTo(size2);
    }
}

