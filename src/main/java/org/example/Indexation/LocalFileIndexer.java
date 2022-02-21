package org.example.Indexation;

import org.apache.commons.io.FileUtils;
import org.example.Tokenization.Tokenizer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Stream;

public class LocalFileIndexer implements FileIndexer {

    private TreeMap<String, SortedMap<String, Integer>> inverseIndex;
    private final Tokenizer tokenizer;

    public void loadFile(String path) throws IOException {
        BufferedReader reader;
        reader = new BufferedReader(new FileReader(path));
        String line = reader.readLine();
        while (line != null) {
            Stream<String> a = this.tokenizer.pipeline(line);
            a.forEach(word -> this.addToIndex(word, path, 1));
            line = reader.readLine();
        }
        reader.close();
    }

    public void loadFolder(String path) {
        Stream<String> a = FileUtils.listFiles(new File(path), new String[] { "txt" }, true)
                .stream().map(File::getAbsolutePath);
        a.forEach(e -> {
            try {
                this.loadFile(e);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }

    public LocalFileIndexer(Tokenizer tokenizer) {
        this.tokenizer = tokenizer;
        this.inverseIndex = new TreeMap<>();
    }

    @Override
    public void addToIndex(String token, String location, int count) {
        if (this.inverseIndex.containsKey(token)) {
            SortedMap<String, Integer> item = this.inverseIndex.get(token);

            if (item.containsKey(location)) {
                int oldCount = item.get(location);
                item.put(location, oldCount + count);
            } else {
                item.put(location, count);
            }

        } else {
            TreeMap<String, Integer> item = new TreeMap<>();
            item.put(location, count);
            this.inverseIndex.put(token, item);
        }
    }

    @Override
    public SortedMap<String, SortedMap<String, Integer>> getIndex() {
        return this.inverseIndex;
    }

    @Override
    public void resetIndex() {
        this.inverseIndex = new TreeMap<>();
    }
}
