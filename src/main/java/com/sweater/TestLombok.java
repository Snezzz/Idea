package com.sweater;

import lombok.*;

//тестовый класс
//при  запуске из main выводит данные
public class TestLombok {
    @Getter
    @Setter
    private String Name;

    @Getter
    @Setter
    private int Id;
    public static void Testing(){
        TestLombok Test1=new TestLombok();
        Test1.Id = 1;
        System.out.println(Test1.Id);
        Test1.Name = "User1";
        System.out.println(Test1.Name);
    }

}
