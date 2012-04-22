package org.erlide.erlang.util;

import java.io.PrintStream;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class Histogram {

    private final Map<Long, Integer> map;

    public Histogram() {
        map = Maps.newTreeMap();
    }

    public void add(final Long key) {
        Integer val = map.get(key);
        if (val == null) {
            val = 0;
        }
        map.put(key, val + 1);
    }

    public void print(final PrintStream out) {
        out.println("-------------------------------");
        final Set<Long> keys = map.keySet();
        final List<Long> keyslist = Lists.newArrayList(keys);
        Collections.sort(keyslist);
        final long min = keyslist.get(0);
        final long max = keyslist.get(keyslist.size() - 1);
        for (long i = min; i <= max; i++) {
            final Integer val = map.get(i);
            if (val != null) {
                out.println(String.format(" %3d: %4d", i, val));
            }
        }
        out.println("-------------------------------");
    }

}
