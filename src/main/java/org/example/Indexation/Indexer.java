package org.example.Indexation;

import java.util.AbstractMap;
import java.util.List;
import java.util.SortedMap;

public interface Indexer {
    void addToIndex(String token, String location, int count);

    SortedMap<String, SortedMap<String, Integer>> getIndex();
}
