package com.bearfamily.CustomClassComparable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class CustomComparison{

public static void main(String[]args){

        Person p1 = new Person(30,"lim");
        Person p2 = new Person(39,"fancy");
        //
        List<Person> people = new ArrayList<Person>();
        people.add(p1);
        people.add(p2);


        //foreach method
        /*
        for(Person p:people){
            System.out.println(p);
        }
        */

        //iterator
        Iterator<Person> ip = people.iterator();
        while(ip.hasNext())
        {
            Object o = ip.next();
            if(o instanceof Person)
            {
                System.out.println("yes,it's a type of Person");
            }

        }





        //System.out.println(p1.toString());
        //System.out.println(p2.toString());
        int compareResult = p2.compareTo(p1);
        System.out.println(compareResult);




        }
}

public class Person implements Comparable<Person>{

    Integer age;

    public Person(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name;


    @Override
    public int compareTo(Person o) {

        if (this.age == o.age) {
            return this.name.compareTo(o.name);
        }else if (this.age > o.age) {
            return 1;
        }
          return -1;

    }

    @Override
    public String toString() {
        return this.name+",how old are you:"+this.age;
    }
}
