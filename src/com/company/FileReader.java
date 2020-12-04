package com.company;

import com.company.keyCache.IKeyCache;
import com.company.keyCache.LinkedHashMapKeyCache;

import java.io.BufferedReader;

public class FileReader {
    IKeyCache getFileCache(String filePath, int cacheSize) throws Exception {
        var result = new LinkedHashMapKeyCache(cacheSize);
        FillByFile(filePath, result);
        return result;
    }

    void FillByFile(String filePath, IKeyCache keyCache) throws Exception {
        try (var reader = new BufferedReader(new java.io.FileReader(filePath))) {
            String str;
            while ((str = reader.readLine()) != null) {
                keyCache.AddKey(str);
            }
        }
    }
}
