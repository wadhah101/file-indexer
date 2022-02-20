package org.example.Indexation;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface FileIndexer extends Indexer {
    void loadFile(String path) throws IOException;

    void loadFolder(String path) throws IOException;
}
