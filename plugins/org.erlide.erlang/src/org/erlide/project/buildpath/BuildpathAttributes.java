package org.erlide.project.buildpath;

import java.util.Map;
import java.util.Set;

import org.eclipse.xtext.util.Pair;

import com.google.common.collect.Maps;

public class BuildpathAttributes {

    private final Map<String, String> map;

    public BuildpathAttributes() {
        map = Maps.newHashMap();
    }

    public BuildpathAttributes(final String... strings) {
        this();
        for (int i = 0; i < strings.length; i += 2) {
            map.put(strings[i], strings[i + 1]);
        }
    }

    public BuildpathAttributes(final Pair<String, String>... pairs) {
        this();
        for (final Pair<String, String> p : pairs) {
            map.put(p.getFirst(), p.getSecond());
        }
    }

    public int size() {
        return map.size();
    }

    public boolean isEmpty() {
        return map.isEmpty();
    }

    public boolean containsKey(final String key) {
        return map.containsKey(key);
    }

    public String get(final String key) {
        return map.get(key);
    }

    public String put(final String key, final String value) {
        if (key == null || value == null) {
            throw new IllegalArgumentException(
                    "Buildpath attributes can't have null values");
        }
        return map.put(key, value);
    }

    public String remove(final String key) {
        return map.remove(key);
    }

    public void clear() {
        map.clear();
    }

    public Set<String> allKeys() {
        return map.keySet();
    }

    public Set<Map.Entry<String, String>> allEntries() {
        return map.entrySet();
    }

}
