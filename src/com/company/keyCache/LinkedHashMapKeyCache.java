package com.company.keyCache;

import java.util.LinkedHashMap;

public class LinkedHashMapKeyCache implements IKeyCache {

    private final LinkedHashMap<String, Integer> _cache;
    private final Integer _cacheSize;

    public LinkedHashMapKeyCache(int cacheSize) {
        _cache = new LinkedHashMap<>();
        _cacheSize = cacheSize;
    }

    @Override
    public void AddKey(String key) {
        Integer value;

        if (_cache.containsKey(key)) {
            value = _cache.get(key);
            value += 1;
        } else {
            if (_cache.size() >= _cacheSize) {
                var minKey = GetKeyMinCount();
                RemoveKey(minKey);
            }
            value = 1;
        }

        _cache.put(key, value);
    }

    protected void RemoveKey(String key) {
        _cache.remove(key);
    }

    protected String GetKeyMinCount() {
        int minValue = Integer.MAX_VALUE;
        String minKey = null;

        for (var entry : _cache.entrySet()) {
            var val = entry.getValue();
            var key = entry.getKey();
            if (val < minValue) {
                minKey = key;
                minValue = val;
            }
        }

        return minKey;
    }

    @Override
    public String toString() {
        var builder = new StringBuilder();

        _cache.forEach((k, v) -> builder.append("Key = " + k + "; Value = " + v + System.lineSeparator()));

        return builder.toString();
    }
}
