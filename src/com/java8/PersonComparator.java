package com.java8;

import java.util.function.Function;

public interface PersonComparator extends java.util.Comparator<Person>
{

    public static PersonComparator comparing(Function<Person,? extends Comparable> keyExtract)
    {
        return  (p1,p2) -> keyExtract.apply(p1).compareTo(keyExtract.apply(p2));
    }

    default PersonComparator thenCompare(Function<? super Person, ? extends Comparable> keyExtract)
    {
        return (p1,p2) -> compare(p1,p2) == 0 ? keyExtract.apply(p1).compareTo(keyExtract.apply(p2)) : compare(p1,p2);
    }

}
