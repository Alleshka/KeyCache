package com.company;

public class Main {

    public static final Integer CACHE_SIZE = 5;
    public static final String FILE_PATH = "input.txt";

    public static void main(String[] args) {
        try {
            var reader = new FileReader();
            var cache = reader.getFileCache(FILE_PATH, CACHE_SIZE);
            System.out.println(cache);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
