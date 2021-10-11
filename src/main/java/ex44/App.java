package ex44;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 John Slauter
 */

import com.google.gson.Gson;
import java.io.*;
import java.util.*;

public class App {

    private static final String INPUT_FILE = "src/main/java/ex44/exercise44_input.json";

    public static void main(String[] args){
        
        ArrayList<Product> product_list = null;
        
        try{

            //put the contents of the json file into the ArrayList

            product_list = read_Input(INPUT_FILE);
            
        }
        
        catch (Exception e) {
            
            System.out.print(e.getMessage());
            
        }

        //create a HashMap for searching

        HashMap<String, Product> product_map = create_Product_Map(product_list);

        //ask the user for search criteria and search the HashMap

        search_Map(product_map);

    }

    protected static ArrayList<Product> read_Input(String input_file) throws IOException {

        File f = new File(input_file);

        //check that file exists

        if(!f.exists()){

            throw new IOException(String.format("File \"%s\" not found.", input_file));

        }

        BufferedReader read = new BufferedReader(new FileReader(f));

        //create Gson object that will allow conversion from json file

        Gson converter = new Gson();

        ProductList product_list;

        //use Gson object to convert

        product_list = converter.fromJson(read, ProductList.class);

        read.close();

        return product_list.get_Products();

    }
    
    private static HashMap<String, Product> create_Product_Map(ArrayList<Product> product_list){
        
        HashMap<String, Product> product_map = new HashMap<String, Product>();

        //put all the products from the ArrayList in the HashMap
        
        for(Product p : product_list){
            
            product_map.put(p.get_Name().toLowerCase(), p);
            
        }
        
        return product_map;
        
    }

    private static void search_Map(HashMap<String, Product> product_map){

        Scanner s = new Scanner(System.in);

        //get user's search criteria

        System.out.print("What is the product name? ");

        String temp = s.nextLine();

        Product search_result;

        //keep asking for search criteria if user input invalid

        while(!product_map.containsKey(temp.toLowerCase())){

            System.out.print("Sorry, that product was not found in our inventory.");

            System.out.print("\nWhat is the product name? ");

            temp = s.nextLine();

        }

        //search HashMap for the product

        search_result = product_map.get(temp.toLowerCase());

        //print out information about the product

        System.out.print(String.format("Name: %s\nPrice: %.2f\nQuantity: %d", search_result.get_Name(), search_result.get_Price(), search_result.get_Quantity()));

        s.close();

    }

}
