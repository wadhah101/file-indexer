package org.example.Tokenization;

import java.io.IOException;
import java.util.stream.Stream;

public interface Tokenizer {


    Stream<String> tokenize(String paragraph);

    boolean isValidWord(String word) throws IOException;

    String normalize(String word);

    String lemma(String word);

    Stream<String> pipeline(String paragraph);
}
