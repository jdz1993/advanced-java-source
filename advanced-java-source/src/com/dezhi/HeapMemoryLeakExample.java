package com.dezhi;

import java.util.ArrayList;
import java.util.List;

public class HeapMemoryLeakExample {
    private static List<OutOfMemoryClass> outOfMemoryClassList = new ArrayList<>();

    // out of heap memory Exception，设置jvm在触发outofmemoryException时dump出一个快照，用任意一种检查工具查看
    // 一般是强引用不会被回收, 所以看GC的object引用时候，用exclude weak reference
    // 虽然官方推荐，但是实际上不推荐ThreadLocal
    // 内部类一般是静态，因为多个类可以引用同一个内部类信息
    private static class OutOfMemoryClass {
        //private final ThreadLocal<int[]> LEAK_KEY = ThreadLocal.withInitial(() -> new int[2000000]);
        private final int[] array = new int[500];
    }

    public void outOfHeapMemoryExample() {
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                try {
                    OutOfMemoryClass outOfMemoryClass = new OutOfMemoryClass();
                    outOfMemoryClassList.add(outOfMemoryClass);
                    System.out.println(Thread.currentThread().getName() + " success.");
                } catch (Exception e) {
                    System.out.println(Thread.currentThread().getName() + " failed." + e.getStackTrace());
                } finally {
                    // do something to cleanup
                }
            }).start();
        }
    }
}
