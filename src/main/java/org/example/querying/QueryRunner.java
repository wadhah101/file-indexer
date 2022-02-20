package org.example.querying;

import org.example.Tokenization.Tokenizer;

import java.util.List;

public interface QueryRunner {
    void setIndex();

    void setTokenizer(Tokenizer tokenizer);

    Object searchWord(String word);

    Object searchWords(List<String> words);

    Object tokenizeQuery(String query);

    Object runQuery(String query);
}
