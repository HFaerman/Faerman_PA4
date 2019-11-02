package Faerman_p1;
import java.io.*;
import java.util.*;


public class DuplicateRemover {
    private Set<String> uniqueWords;

    public void remove(String dataFile) throws IOException {
        String nextWord;
        uniqueWords = new HashSet<>();
        Scanner scnr = new Scanner(new File(dataFile));
        while (scnr.hasNext()) {
            nextWord = scnr.next();
            uniqueWords.add(nextWord);
        }
    }

    public void write(String outputFile) throws IOException {
        File fileOut;
        FileWriter writeToFile;

        fileOut = new File(outputFile);
        if (fileOut.exists()) {
            writeToFile = new FileWriter(fileOut, false);

            for (String uniqueWord : uniqueWords) {
                writeToFile.write(uniqueWord + "\n");

            }


            writeToFile.close();
            System.out.println("All data successfully has been moved to the output file.");
        }
        }

    public static class Application {
        public static void main(String[] args) throws IOException {

            DuplicateRemover duplicateRemover = new DuplicateRemover();

            duplicateRemover.remove("problem1.txt");
            duplicateRemover.write("unique_words.txt");
        }
    }
}
