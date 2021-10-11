package ex45;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 John Slauter
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

    private static final String INPUT_FILE = "src/main/java/ex45/exercise45_input.txt";

    private static final String OUTPUT_PATH = "src/main/java/ex45/";

    private static final String TO_REPLACE = "utilize";

    private static final String REPLACEMENT = "use";

    public static void main(String[] args){

        try {

            //read contents of input file and store in String

            String text = read_Input(INPUT_FILE), output_file;

            /*
            replace all instances of the word to
            be replaced with the replacement word
            */

            text = replace_All(text, TO_REPLACE, REPLACEMENT);

            //get name of output file from user

            Scanner s = new Scanner(System.in);

            System.out.print("Name of output file: ");

            //store address of output file

            output_file = OUTPUT_PATH + s.nextLine() + ".txt";

            //create output file and put the modified text in it

            write_Output(output_file, text);

            s.close();

        }

        catch(Exception e){

            System.out.print(e.getMessage());

        }


    }

    protected static String read_Input(String input_file) throws FileNotFoundException {

        String text = "";

        File f = new File(input_file);

        //check that the file exists

        if(!f.exists()){

            throw new FileNotFoundException("File " + input_file + " not found.");

        }

        Scanner s = new Scanner(f);

        //read in contents of file and store in the string

        while(s.hasNextLine()){

            text = text.concat(s.nextLine() + "\n");

        }

        //leaving out last character to avoid having an unnecessary new line character

        return text.substring(0, text.length()-1);

    }

    protected static String replace_All(String text, String to_replace, String replacement){

        ArrayList<Integer> index_list = new ArrayList<Integer>();

        int temp = text.length();

        /*
        note all instances of the word to be
        replaced in the text and store the
        associated index
         */

        while(text.substring(0, temp).contains(to_replace)){

            temp = text.substring(0, temp).lastIndexOf(to_replace);

            index_list.add(temp);

        }

        /*
        replace all instances of the
        word to be replaced with the replacement

        note that the way I chose to do this in
        necessitates that the word to be replaced
        is replaced in order from last instance to
        first so that the stored indexes remain
        accurate in the case that the word to be
        replaced and the replacement word are not
        the same length
        */

        for(int i : index_list){

            text = text.substring(0, i) + replacement + text.substring(i+to_replace.length());

        }

        return text;

    }

    protected static void write_Output(String destination, String text) throws IOException{

        BufferedWriter writer = new BufferedWriter(new FileWriter(destination));

        //check that the file was created successfully

        if(!new File(destination).exists()){

            throw new IOException("Failed to create file \"" + destination + "\".");

        }

        //write the text to the output file

        writer.write(text);

        writer.close();

    }

}
