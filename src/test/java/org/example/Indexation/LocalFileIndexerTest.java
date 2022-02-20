package org.example.Indexation;

import junit.framework.TestCase;
import org.example.Tokenization.EnglishSimpleTokenizer;
import org.junit.Test;

import java.io.IOException;
import java.util.SortedMap;

public class LocalFileIndexerTest extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
    }

    @Test
    public void testLoadFile() throws IOException {
        LocalFileIndexer indexer = new LocalFileIndexer(new EnglishSimpleTokenizer());
        indexer.loadFile("indexFiles/anarchism.txt");
        SortedMap<String, SortedMap<String, Integer>> index = indexer.getIndex();
        SortedMap<String, Integer> example = index.get("early");
        assertFalse(example.isEmpty());
    }

    @Test
    public void testLoadFolder() {
        LocalFileIndexer indexer = new LocalFileIndexer(new EnglishSimpleTokenizer());
        indexer.loadFolder("indexFiles");
        SortedMap<String, SortedMap<String, Integer>> index = indexer.getIndex();
        SortedMap<String, Integer> example = index.get("early");
        assertFalse(example.isEmpty());
    }

    @Test
    public void testAddToIndex() {
        LocalFileIndexer indexer = new LocalFileIndexer(new EnglishSimpleTokenizer());
        SortedMap<String, SortedMap<String, Integer>> index = indexer.getIndex();
        indexer.addToIndex("test", "test/location.txt", 25);
        SortedMap<String, Integer> item = index.get("test");
        assertEquals(item.get("test/location.txt"), Integer.valueOf(25));

    }

}