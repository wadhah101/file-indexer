package org.example.querying;

import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.example.Tokenization.Tokenizer;

public class EnglishSimpleQueryRunner implements QueryRunner {
    private final SortedMap<String, SortedMap<String, Integer>> index;
    private final Tokenizer tokenizer;

    public EnglishSimpleQueryRunner(SortedMap<String, SortedMap<String, Integer>> index, Tokenizer tokenizer) {
        this.index = index;
        this.tokenizer = tokenizer;
    }

    @Override
    public SortedMap<String, Integer> searchWord(String word) {
        if (this.index.containsKey(word))
            return this.index.get(word);
        return new TreeMap<>();
    }

    @Override
    public Stream<Entry<String, Integer>> searchWords(List<String> words) {

        return words.stream().map(this::searchWord).map(e -> e.entrySet())
                .flatMap(e -> e.stream());

    }

    @Override
    public Stream<String> tokenizeQuery(String query) {
        return this.tokenizer.pipeline(query);
    }

    @Override
    public Map<String, Integer> runQuery(String query) {
        List<String> t = this.tokenizeQuery(query).collect(Collectors.toList());
        Map<String, Integer> result = this.searchWords(t)
                .collect(Collectors.groupingBy(e -> e.getKey(), Collectors.summingInt(e -> e.getValue())));
        return result;
    }
}
