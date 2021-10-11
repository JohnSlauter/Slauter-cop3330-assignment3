package ex43;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 John Slauter
 */

import java.io.*;
import java.util.Scanner;

public class App {

    private static final String LOCATION = "src/main/java/ex43/website";

    public static void main(String[] args){

        Scanner s = new Scanner(System.in);

        String site_name, author_name, temp;

        boolean JS_folder = false, CSS_folder = false;

        //clear out old files from last usage of the program

        clear(LOCATION);

        //get user input

        System.out.print("Site name: ");

        site_name = s.nextLine();

        System.out.print("Author: ");

        author_name = s.nextLine();

        System.out.print("Do you want a folder for JavaScript? ");

        temp = s.nextLine().toLowerCase();

        if(temp.equals("y")){

            JS_folder = true;

        }

        System.out.print("Do you want a folder for CSS? ");

        temp = s.nextLine().toLowerCase();

        if(temp.equals("y")){

            CSS_folder = true;

        }

        s.close();

        try{

            //create files and get output

            temp = create_Files(LOCATION, site_name, author_name, JS_folder, CSS_folder);

            //print output

            System.out.print(temp);

        }

        catch(Exception e){

            System.out.print(e.getMessage());

        }

    }

    private static String create_Files(String location, String site_name, String author_name, boolean JS_folder, boolean CSS_folder) throws Exception{

        String path, txt = "";

        //create website folder

        create_Folder(location);

        path = location.concat("/" + site_name);

        //create user named folder within website folder

        create_Folder(path);

        txt = concat_Creation_Message(txt, path);

        //create index file and place inside user named website

        create_Index_File(path.concat("/index.html"), site_name, author_name);

        txt = concat_Creation_Message(txt + "\n", path.concat("/index.html"));

        //create JS folder in user named folder if they requested it

        if(JS_folder){

            create_Folder(path.concat("/jss/"));

            txt = concat_Creation_Message(txt + "\n", path.concat("/jss/"));

        }

        //create CSS folder in user named folder if they requested it

        if(CSS_folder){

            create_Folder(path.concat("/css/"));

            txt = concat_Creation_Message(txt + "\n", path.concat("/css/"));

        }

        //return output string

        return txt;

    }

    private static String concat_Creation_Message(String s, String path){

        return s.concat("Created " + path);

    }

    protected static void create_Folder(String folder_address) throws FileNotFoundException{

        File folder = new File(folder_address);

        /*
        ".mkdir" makes the file into a folder and
        returns true if creation was successful
        */

        if(!folder.mkdir()){

            throw new FileNotFoundException(String.format("Failed to create folder \"%s\".", folder_address));

        }

    }

    protected static void create_Index_File(String index_address, String site_name, String author_name) throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter(index_address));

        //check that the file was successfully created

        if(!new File(index_address).exists()){

            throw new IOException(String.format("Failed to create file \"%s\".", index_address));

        }

        /*
        write Javascript, put website name in
        title area and author name in meta area
         */

        writer.write(String.format("<!DOCTYPE html>\n<html>\n<head>\n<title>%s</title>\n" +
                "<meta name=\"author\" content=\"%s\">\n</head>\n<body>\n\n</body>\n</html>", site_name, author_name));

        writer.close();

    }

    protected static void clear(String location){

        File f = new File(location);

        if(f.exists()){

            //if folder, delete all files within

            if(f.isDirectory()) {

                for (File sf : f.listFiles()) {

                    clear(sf.getAbsolutePath());

                }

            }

            f.delete();

        }

    }

}
