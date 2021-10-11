package ex41;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 John Slauter
 */

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class App {

    private static final String INPUT_FILE = "src/main/java/ex41/exercise41_input.txt";

    private static final String OUTPUT_FILE = "src/main/java/ex41/exercise41_output.txt";

    public static void main(String[] args) {

        ArrayList<String> names;

        try {

            //read names from file and store in the ArrayList

            names = read_File(INPUT_FILE);

            //alphabetize the arraylist

            names = alphabetize_ArrayList(names);

            //write contents of the ArrayList to output file

            write_To_File(names, OUTPUT_FILE);

        }

        catch(IOException e){

            System.out.print(e.getMessage());

        }

    }

    protected static ArrayList<String> read_File(String input_file) throws FileNotFoundException {

        //check to make sure the file exists

        File f = new File(input_file);

        //if it doesn't, throw exception

        if(!f.exists()){

            throw new FileNotFoundException("File " + input_file + " not found.");

        }

        ArrayList<String> names = new ArrayList<String>();

        //open Scanner to read the contents of the file

        Scanner reader = new Scanner(f);

        reader.useDelimiter("\\n");

        //reading names one at a time and storing in the ArrayList

        while(reader.hasNext()){

            names.add(reader.next());

        }

        reader.close();

        return names;

    }

    protected static ArrayList<String> alphabetize_ArrayList(ArrayList<String> names){

        String temp;

        int swap_index;

        /*
        selection sort; on the 'i'th iteration, the word with the least
        lexicographic value (it comes first in the dictionary) between
        indexes i and size-1 will swap indexes with the word at index i
        */

        for(int i = 0; i < names.size(); i++){

            swap_index = i;

            for(int j = i+1; j < names.size(); j++){

                /*
                finding the word with the lowest
                lexicographic value between indexes
                i and size-1
                */

                if(names.get(swap_index).compareTo(names.get(j)) > 0){

                    swap_index = j;

                }

            }

            /*
            swapping the word at i with
            the lexicographic least word
            between i and size-1
             */

            temp = names.get(i);

            names.set(i, names.get(swap_index));

            names.set(swap_index, temp);

        }

        return names;

    }

    private static void write_To_File(ArrayList<String> names, String output_file) throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter(output_file));

        String temp = "Total of " + names.size() + " names\n";

        writer.write(temp);

        writer.write("-".repeat(temp.length()) + "\n");

        //writing the names in the input file to the output file in alphabetical order

        for(int i = 0; i < names.size(); i++){

            writer.write(names.get(i) + "\n");

        }

        writer.close();

    }

}
