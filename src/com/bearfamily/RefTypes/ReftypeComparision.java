package com.bearfamily.RefTypes;

public class ReftypeComparision {

    public static void main(String[] args) {

        Student s1 = new Student();
        Student s2 =s1;

        int n1 = 8;
        int n2 =n1;
        n1=10;


      System.out.println(n1);
      System.out.println(n2);

/*
        s2.setId(1000);
        System.out.println(s2.getId());
        System.out.println(s1.getId());
*/

    }


}

class Student {

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;


}
