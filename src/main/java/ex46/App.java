package ex46;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 John Slauter
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class App {

    private static final String INPUT_FILE = "src/main/java/ex46/exercise46_input.txt";

    public static void main(String[] args){

        HashMap<String, Integer> map;

        try {

            /*
            find the frequency of each word in
            the output file and store the information
            in a map
            */

            map = count_Words(INPUT_FILE);

            //put the entries of the map in an ArrayList for sorting

            ArrayList<Map.Entry<String, Integer>> list = map_To_ArrayList(map);

            //sort the arraylist

            list = sort_ArrayList(list);

            //print output

            print_Frequencies(list);

        }

        catch(Exception e){

            System.out.print(e.getMessage());

        }

    }

    protected static HashMap<String, Integer> count_Words(String input_file) throws FileNotFoundException {

        File f = new File(input_file);

        //check that the input file exists

        if(!f.exists()){

            throw new FileNotFoundException("File \"" + input_file + "\" not found.");

        }

        HashMap<String, Integer> map = new HashMap<String, Integer>();

        Scanner s = new Scanner(f);

        /*
        set Scanner delimiter to be white
        space and new line character
        */

        s.useDelimiter("\\s|\\n");

        String temp;

        while(s.hasNext()){

            temp = s.next();

            //avoid putting white space in the map

            if(temp.isEmpty()){

                continue;

            }

            /*
            if a word has been seen more than
            once, update its existing entry
            */

            if(map.containsKey(temp)){

                map.put(temp, map.get(temp)+1);

            }

            /*
            if a word hasn't been seen before,
            create a new entry
            */

            else{

                map.put(temp, 1);

            }

        }

        return map;

    }

    protected static ArrayList<Map.Entry<String, Integer>> map_To_ArrayList(HashMap<String, Integer> map){

        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>();

        //put all entries of the map into the ArrayList

        for(Map.Entry<String, Integer> e : map.entrySet()){

            list.add(e);

        }

        return list;

    }

    protected static ArrayList<Map.Entry<String, Integer>> sort_ArrayList(ArrayList<Map.Entry<String, Integer>> list){

        int index;

        Map.Entry<String, Integer> temp;

        /*
        selection sort; on the 'i'th iteration,
        the word with the lowest frequency between
        indexes i and size-1 will swap indexes with
        the word at index i
        */

        for(int i = 0; i < list.size(); i++){

            index = i;

            for(int j = i+1; j < list.size(); j++){

                /*
                finding the word with the lowest
                frequency between indexes i and size-1
                */

                if(list.get(index).getValue() < list.get(j).getValue()){

                    index = j;

                }

            }

            /*
            swapping the word at i with
            the word with the lowest
            frequency between i and size-1
             */

            temp = list.get(i);

            list.set(i, list.get(index));

            list.set(index, temp);

        }

        return list;

    }

    private static void print_Frequencies(ArrayList<Map.Entry<String, Integer>> list){

        int longest_length = length_Of_Longest_Word(list);

        for(Map.Entry<String, Integer> e : list){

            System.out.print(String.format("%s:%s%s\n", e.getKey(), " ".repeat(1+longest_length-e.getKey().length()), "*".repeat(e.getValue())));

        }


    }

    protected static int length_Of_Longest_Word(ArrayList<Map.Entry<String, Integer>> list){

        int length = 0;

        //finding the longest word in the ArrayList

        for(Map.Entry<String, Integer> e : list){

            if(length < e.getKey().length()){

                length = e.getKey().length();

            }

        }

        return length;

    }

}
