package org.example.Tokenization;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.junit.Test;

public class EnglishSimpleTokenizerTest {
    @Test
    public void testIsValidWord() throws IOException {
        Tokenizer tokenizer = new EnglishSimpleTokenizer();
        assertTrue(tokenizer.isValidWord("hello"));
        assertFalse(tokenizer.isValidWord("the"));
    }

    @Test
    public void testLemma() {

    }

    @Test
    public void testNormalize() {
        Tokenizer tokenizer = new EnglishSimpleTokenizer();
        assertEquals(tokenizer.normalize("HelloWorld"), "helloworld");
    }

    @Test
    public void testPipeline() {
        String text = "Hello this is the tExt to tokenize";
        Tokenizer tokenizer = new EnglishSimpleTokenizer();
        String result = (tokenizer.pipeline(text).collect(Collectors.joining(" ")));
        assertEquals(result, "hello text tokenize");
    }

    @Test
    public void testTokenize() {

    }
}
