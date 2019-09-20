package org;

import org.annotation.Test;

public class Main {
    static public void main(String[] args){
        Main m=new Main();
        System.out.println(
                m.getClass().getResource("/1.xml")
        );
    }

    @Test()
    public static void test(){
        System.out.println("test");
    }
}
