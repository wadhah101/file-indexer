package org.example.querying;

import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.Map.Entry;
import java.util.stream.Stream;

public interface QueryRunner {

    SortedMap<String, Integer> searchWord(String word);

    Stream<Entry<String, Integer>> searchWords(List<String> words);

    Stream<String> tokenizeQuery(String query);

    Map<String, Integer> runQuery(String query);
}
