package com.github.rossetero.app;



public class Main {

    public static void main(String[] args) {
        DBRunner r = new DBRunner();
       // r.insertMessage(11L,22L,"ZHOPA");
        //r.insertMessage(1L,2L,"Salam");
        r.editMessage(8L,"Salam Aleikum");
        r.run();

    }
}