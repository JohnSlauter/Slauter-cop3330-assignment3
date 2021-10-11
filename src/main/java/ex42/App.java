package ex42;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 John Slauter
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

    private static final String INPUT_FILE = "src/main/java/ex42/exercise42_input.txt";

    public static void main(String[] args){

        ArrayList<Employee> employees;

        int[] longest_length;

        try{

            //read in contents of input file and store in ArrayList

            employees = read_File(INPUT_FILE);

            /*
            find the longest sequences in the
            categories of first name, last name,
            and salary for formatting
             */

            longest_length = find_Longest_Length(employees);

            //format output and print

            System.out.print(get_Output(employees, longest_length));

        }

        catch(FileNotFoundException e){

            System.out.print(e.getMessage());

        }

    }

    protected static ArrayList<Employee> read_File(String input_file) throws FileNotFoundException {

        //check that the input file exists

        File f = new File(input_file);

        //if not, throw exception

        if(!f.exists()){

            throw new FileNotFoundException("File \"" + input_file + "\" not found.");

        }

        int counter = 0;

        String[] temp = new String[3];

        ArrayList<Employee> employees = new ArrayList<Employee>();

        //open scanner to read from the input file

        Scanner reader = new Scanner(f);

        //set scanner to stop when a comma or new line character is found

        reader.useDelimiter(",|\\n");

        while(reader.hasNext()){

            temp[counter%3] = reader.next();

            counter++;

            if(counter % 3 == 0) {

                employees.add(new Employee(temp[0], temp[1], temp[2]));

            }

        }

        //remove new line character from salary attributes

        for(int i = 0; i < employees.size()-1; i++){

            employees.get(i).set_Salary(employees.get(i).get_Salary().substring(0, employees.get(i).get_Salary().length()-1));

        }

        reader.close();

        return employees;

    }

    protected static int[] find_Longest_Length(ArrayList<Employee> employees){

        int[] longest_length = {0, 0, 0};

        /*
        go through the employees in the ArrayList
        and find the length of the longest string
        for each attribute
         */

        for(Employee e : employees){

            if(longest_length[0] < e.get_L_Name().length()){

                longest_length[0] = e.get_L_Name().length();

            }

            if(longest_length[1] < e.get_F_Name().length()){

                longest_length[1] = e.get_F_Name().length();

            }

            if(longest_length[2] < e.get_Salary().length()){

                longest_length[2] = e.get_Salary().length();

            }

        }

        return longest_length;

    }

    private static String get_Output(ArrayList<Employee> employees, int[] longest_length){

        //format output

        String output = String.format("Last%sFirst%sSalary", get_Spaces(longest_length[0], 4),
                get_Spaces(longest_length[1], 5));

        output = output.concat(String.format("\n%s", "-".repeat(output.length())));

        for(Employee e : employees){

            output = output.concat(String.format("\n%s%s%s%s%s", e.get_L_Name(), get_Spaces(longest_length[0],
                    e.get_L_Name().length()), e.get_F_Name(), get_Spaces(longest_length[1], e.get_F_Name().length()),
                    e.get_Salary()));

        }

        return output;

    }

    private static String get_Spaces(int longest_length, int current_length){

       return " ".repeat(1+longest_length-current_length);

    }

}