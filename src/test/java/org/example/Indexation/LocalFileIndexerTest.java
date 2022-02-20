package org.example.Indexation;

import junit.framework.TestCase;
import org.example.Tokenization.EnglishSimpleTokenizer;

import java.io.IOException;
import java.util.SortedMap;

public class LocalFileIndexerTest extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
    }

    public void testLoadFile() throws IOException {
        LocalFileIndexer a = new LocalFileIndexer(new EnglishSimpleTokenizer());
        a.loadFile("indexFiles/anarchism.txt");
        SortedMap<String, SortedMap<String, Integer>> q = a.getIndex();
        System.out.println(q.toString());
    }

    public void testLoadFolder() {
        LocalFileIndexer a = new LocalFileIndexer(new EnglishSimpleTokenizer());
        a.loadFolder("indexFiles");
        SortedMap<String, SortedMap<String, Integer>> q = a.getIndex();
        System.out.println(q.toString());
    }

    public void testAddToIndex() {
    }

    public void testGetIndex() {
    }
}