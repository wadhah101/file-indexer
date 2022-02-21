package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;
import java.util.stream.Stream;

import org.example.Indexation.LocalFileIndexer;
import org.example.Tokenization.EnglishSimpleTokenizer;
import org.example.Tokenization.Tokenizer;
import org.example.querying.EnglishSimpleQueryRunner;
import org.example.querying.QueryRunner;

public class App {

    private static final Tokenizer tokenizer = new EnglishSimpleTokenizer();
    private static final LocalFileIndexer indexer = new LocalFileIndexer(tokenizer);
    private static final QueryRunner queryRunner = new EnglishSimpleQueryRunner(indexer.getIndex(),
            tokenizer);

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String input = new String();

        String[] options = { "1- Add a file to index", "2- Add a folder to index", "3- run query", "4- exit" };

        while (!input.equals("4")) {
            System.out.println("Please choose :");
            for (String i : options)
                System.out.println("\t " + i);
            System.out.print("choice: ");
            input = sc.nextLine().trim();

            switch (input) {
                case "1":
                    addFileCli();
                    break;
                case "2":
                    AddFolderCli();
                    break;
                case "3":
                    runQueryCli();
                    break;
                case "4":
                    break;
                default:
                    System.out.println("Invalid Input! \n");
            }

        }
    }

    public static void addFileCli() throws IOException {
        System.out.print("\t Enter file path: ");
        String result = sc.nextLine().trim();
        if (Files.isRegularFile(Paths.get(result))) {
            indexer.loadFile(result);
            System.out.println("\nFile index succefully !");
            System.out.println("#######################\n");

        } else {
            System.out.println("Invalid file path");
            System.out.println("#######################\n");

        }
    }

    public static void AddFolderCli() throws IOException {
        System.out.print("\t Enter directory path: ");
        String result = sc.nextLine().trim();
        if (Files.isDirectory(Paths.get(result))) {
            indexer.loadFolder(result);
            System.out.println("\nFolder index succefully !");
            System.out.println("#######################\n");

        } else {
            System.err.println("Invalid directory path");
            System.err.println("#######################\n");

        }
    }

    public static void runQueryCli() {
        System.out.print("\t Enter query: ");
        String query = sc.nextLine().trim();

        Map<String, Integer> result = queryRunner.runQuery(query);

        if (result.isEmpty()) {
            System.out.println("\n##################");
            System.out.println("\t search has turned 0 results !");
            System.out.println("##################\n");
            return;
        }

        Stream<Entry<String, Integer>> formatterResult = result.entrySet().stream()
                .sorted((x, y) -> y.getValue() - x.getValue());

        System.out.println("\n##################");
        System.out.println("\tResult:");

        formatterResult
                .forEach(e -> System.out.println(String.format("\t File : %s, Score %s", e.getKey(), e.getValue())));

        System.out.println("##################\n");

    }
}
