package com.springcolud.demo.controller;

public class OuterClass {
    public void display(){
        System.out.println("OuterClass...");
    }
    public void display1(){
        System.out.println("OuterClass1...");
    }
    public class InnerClass{
        public OuterClass getOuterClass(){
            return OuterClass.this;
        }
    }

    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        OuterClass.InnerClass innerClass = outerClass.new InnerClass();
        innerClass.getOuterClass().display1();
    }
}
