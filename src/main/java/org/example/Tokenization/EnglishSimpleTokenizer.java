package org.example.Tokenization;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EnglishSimpleTokenizer implements Tokenizer {

    List<String> standardStopWord;

    public EnglishSimpleTokenizer() {
        List<String> allLines = new ArrayList<>();
        try {
            allLines = Files.readAllLines(Paths.get("src/assets/stopWords.txt"))
                    .stream().map(String::trim).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        standardStopWord = allLines;
    }

    @Override
    public Stream<String> tokenize(String paragraph) {
        StringTokenizer tokenizer = new StringTokenizer(paragraph, ", .-!?+()[]\"'#*");
        return Collections.list(tokenizer).stream().map(e -> (String) e);
    }

    @Override
    public boolean isStopWord(String word) {
        HashSet<String> skipsSets = new HashSet<>(this.standardStopWord);
        return !skipsSets.contains(word);
    }

    @Override
    public String normalize(String word) {
        return word.toLowerCase();
    }

    @Override
    public String lemma(String word) {
        return word;
    }

    @Override
    public Stream<String> pipeline(String paragraph) {
        return this.tokenize(paragraph).map(this::normalize).filter(this::isStopWord).map(this::lemma);
    }
}
