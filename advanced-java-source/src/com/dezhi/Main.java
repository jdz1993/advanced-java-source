package com.dezhi;


import java.util.HashSet;
import java.util.Set;

public class Main {

    private static void testMemoryLeak() {
        HeapMemoryLeakExample m = new HeapMemoryLeakExample();
        m.outOfHeapMemoryExample();
    }

    private static void testFinalObject() {
        final int a;
        a = 9;
        final Set<String> f = new HashSet<>();
        f.add("aaa");
        f.add("aaba");
        f.add("aasaa");
        f.add("aeraa");
        System.out.println(f);

        FinalObjectChangeExample fe = new FinalObjectChangeExample();
        //fe.changeStorage("fff");
        System.out.println(fe.getStorage());
    }

    public static void main(String[] args) {
        testFinalObject();
        //testMemoryLeak();
    }
}
