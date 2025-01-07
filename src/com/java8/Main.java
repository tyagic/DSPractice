package com.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Main {

    public  static void main(String args[] )
    {
        /*PersonComparator ageComparator = (p1, p2) -> {
            return p1.getAge() - p2.getAge();
        };*/

       /* PersonComparator firstNameComparator = (p1, p2) -> {
            return p1.getFirstName().compareTo(p2.getFirstName());
        };*/

        PersonComparator  lastNameComparator = (p1, p2) -> {
            return p1.getLastName().compareTo(p2.getLastName());
        };

        Function<Person,Integer>  ageExtract = p -> p.getAge();
        Function<Person,String>  firstNameExtract = p -> p.getFirstName();
        Function<Person,String>  lastNameExtract = p -> p.getLastName();

        PersonComparator ageComparator = PersonComparator.comparing(ageExtract);

        PersonComparator lastNameComparartor = PersonComparator.comparing(lastNameExtract);

        PersonComparator chainedComparator = lastNameComparartor.thenCompare(ageExtract).thenCompare(firstNameExtract);

        Person p1 = new Person(43,"chanchal","tyagi");
        Person p2 = new Person(39,"parul","tyagi");
        Person p3 = new Person(12,"sparsh","tyagi");
        Person p4 = new Person(14,"pranjal","tyagi");
        Person p5 = new Person(38,"sonal","tandon");
        Person p6 = new Person(44,"rochak","mehrotra");

        List<Person> persons = new ArrayList<>();
        persons.add(p1);
        persons.add(p2);
        persons.add(p3);
        persons.add(p4);
        persons.add(p5);
        persons.add(p6);

        persons.sort(ageComparator);
        System.out.println("-----AGE SORT----");
        persons.forEach(System.out::println);
        persons.sort(chainedComparator);
        System.out.println("-----LASTNAME-->AGE-->FIRSTNAME SORT----");
        persons.forEach(System.out::println);

    }
}
