package org.ibm.oops;

public class CPU {
    private static final int MAX_CORES = 64; // Maximum number of cores allowed
    private String model;
    public CPU(String model) {
        this.model = model;
    }
    public static class Cache {
        private int size; // Size of the cache in MB
        public Cache(int size) {
            this.size = size;
        }
        public int getSize() {
            return size;
        }
        public void printCacheInfo() {
            System.out.println("Cache size: " + size + " MB");
        }
    }

}
