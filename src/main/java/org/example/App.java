package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import org.example.Indexation.Indexer;
import org.example.Indexation.LocalFileIndexer;
import org.example.Tokenization.EnglishSimpleTokenizer;

public class App {
    public static final LocalFileIndexer indexer = new LocalFileIndexer(new EnglishSimpleTokenizer());

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = new String();

        String[] options = { "1- Add a file to index", "2- Add a folder to index", "3- run query", "4- exit" };

        while (!input.equals("4")) {
            System.out.println("Please choose :");
            for (String i : options)
                System.out.println("\t " + i);

            input = sc.nextLine().trim();

            switch (input) {
                case "1":
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    break;
                default:
                    System.out.println("Invalid Input! \n");
            }

        }
        sc.close();
    }

    public void addFileCli() throws IOException {
        System.out.println("\t Enter file path");
        Scanner sc = new Scanner(System.in);
        String result = sc.nextLine().trim();
        if (Files.isRegularFile(Paths.get(result))) {
            indexer.loadFile(result);
        } else {
            System.out.println("Invalid file path");
        }
        sc.close();
    }

    public void voidAddFolderCli() throws IOException {
        System.out.println("\t Enter directory path");
        Scanner sc = new Scanner(System.in);
        String result = sc.nextLine().trim();
        if (Files.isDirectory(Paths.get(result))) {
            indexer.loadFile(result);
        } else {
            System.out.println("Invalid directory path");
        }
        sc.close();
    }

    public void runQueryCli() {

    }

}
