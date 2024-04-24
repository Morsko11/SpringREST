package com.restful.restproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestProjectApplication.class, args);
    }

    void hello(int x,int[] y){
        System.out.println("Hello World");
        for (int s: y) {
            System.out.printf(s+" интовое значение ");
        }
    }
}
