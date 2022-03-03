# Go Land Assignment

## Task Text

Please write a Java application that provides a service for indexing text files.
The console interface should allow for (i) specifying the indexed files and directories and (ii) querying files containing a given word.
The library should be extensible by the tokenization algorithm (simple splitting by words/support lexers/etc.).
State persistence between running sessions is not needed. Providing some tests and a program with usage examples is advised.

## Project overview

A text file indexing library based on simple tokenization algorithm that includes clean up and filtering and lexing with a high support for extensibility using java interfaces.

This library supports indexing for files,folders, runing simple queries and composed ones and will provide files ordered by a total score as result.

The indexFiles folder have examples paragraphs to work on.

## Example

indexing "indexFiles" folder and running "early innocence" will give you as a result:

         File : /home/wat101/IdeaProjects/assignment/indexFiles/anarchism.txt, Score 3
         
         File : /home/wat101/IdeaProjects/assignment/indexFiles/stories/to-kill-a-mocking-bird.txt, Score 1


## Testing 
