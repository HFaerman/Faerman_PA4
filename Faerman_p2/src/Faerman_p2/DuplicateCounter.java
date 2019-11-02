package Faerman_p2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class DuplicateCounter {
    private Map<String, Integer> wordCounter;

    public void count(String dataFile) throws IOException {
        String nextWord;
        Integer a;

        wordCounter = new HashMap<>();
        Scanner scnr = new Scanner(new File(dataFile));
        while (scnr.hasNext()) {
            nextWord = scnr.next();
            a = wordCounter.get(nextWord);
            if (a == null) {
                wordCounter.put(nextWord, 1);
            } else {
                wordCounter.put(nextWord, a + 1);
            }

        }


    }

    public void write(String outputFile) throws IOException {
        File fileOut;
        FileWriter writeToFile;

        fileOut = new File(outputFile);
        if (fileOut.exists() == false)
            fileOut.createNewFile();

        writeToFile = new FileWriter(fileOut, false);
        for (Map.Entry<String, Integer> nextWord : wordCounter.entrySet())
            writeToFile.write(nextWord.getKey() + " : " + nextWord.getValue() + "\n");

        writeToFile.close();
        System.out.println("All data successfully has been moved to the output file.");


    }
    public static class Application{
        public static void main(String[] args) throws IOException{
            DuplicateCounter duplicateCounter = new DuplicateCounter();
            try{
                duplicateCounter.count("problem2.txt");
            }
            catch (IOException a){
                System.out.println("We have encountered an IOExeption, ABORT!!!");
            }
            try{
                duplicateCounter.write("unique_word_counts.txt");
            }
            catch (IOException a){
                System.out.println("We have encountered an IOExeption, ABORT!!!");
            }


        }

    }

}

