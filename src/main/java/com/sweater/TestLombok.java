package com.sweater;

import lombok.*;


 public class TestLombok {
    @Getter
    @Setter
    private String Name;

    @Getter
    @Setter
    private int Id;
    public static void Testing(){
       TestLombok Test1=new TestLombok();
       Test1.setId(1);
       System.out.println(Test1.getId());
       Test1.setName("User1");
       System.out.println(Test1.getName());
    }

    }
