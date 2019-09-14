package com.dezhi;

import java.util.HashSet;
import java.util.Set;

final class FinalObjectChangeExample {
    private final Set<String> storage;

    FinalObjectChangeExample() {
        storage = new HashSet<>();
        storage.add("java");
    }

//    void changeStorage(String value) {
////        storage.add(value);
////    }

    final Set<String> getStorage() {
        return storage;
    }
}
