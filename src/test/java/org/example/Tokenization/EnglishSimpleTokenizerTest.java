package org.example.Tokenization;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

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

    }

    @Test
    public void testPipeline() {

    }

    @Test
    public void testTokenize() {

    }
}
