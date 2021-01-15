package com.example.problemset2a;

import java.util.Comparator;

//Modify the class header to implement the appropriate interface
public class OctagonComparator implements Comparator<Octagon> {
    @Override
    //then implement the method(s) in the interface
    public int compare(Octagon a, Octagon b) {
        if (a.getSide() > b.getSide()) return 1;
        else if (a.getSide() == b.getSide()) return 0;
        else return -1;
    }
}
