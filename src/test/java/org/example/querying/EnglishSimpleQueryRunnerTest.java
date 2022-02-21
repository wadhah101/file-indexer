package org.example.querying;

import java.util.Map;

import org.example.Indexation.LocalFileIndexer;
import org.example.Tokenization.EnglishSimpleTokenizer;
import org.example.Tokenization.Tokenizer;
import org.junit.Test;

import junit.framework.TestCase;

public class EnglishSimpleQueryRunnerTest extends TestCase {
    public void setUp() throws Exception {
        super.setUp();
        this.indexer.loadFolder("indexFiles");
    }

    private final Tokenizer tokenizer = new EnglishSimpleTokenizer();
    private final LocalFileIndexer indexer = new LocalFileIndexer(tokenizer);
    private final EnglishSimpleQueryRunner queryRunner = new EnglishSimpleQueryRunner(indexer.getIndex(), tokenizer);

    @Test
    public void testRunQuery() {
        String query = "anarchist anarchism Industrial establishing 1910";
        Map<String, Integer> res = queryRunner.runQuery(query);
        assertFalse(res.isEmpty());
    }

}
