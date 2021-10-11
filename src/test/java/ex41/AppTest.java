package ex41;

import org.junit.*;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class AppTest {

    @RepeatedTest(5)
    public void read_file_test(){

        ArrayList<String> tester, comp = new ArrayList<String>();

        String file = "src/test/java/ex41/tester.txt";

        int num = (int)(1+25*Math.random());

        char c;

        for(int i = 0; i < num; i++){

            c = (char)('a'+Math.random()*('a'-'z'));

            comp.add(c + "");

        }

        try {

            BufferedWriter write = new BufferedWriter(new FileWriter(new File(file)));

            for(String s : comp){

                write.write(s + "\n");

            }

            write.close();

            tester = ex41.App.read_File(file);

            Assert.assertEquals(tester, comp);

        }

        catch(Exception e){

            System.out.print(e.getMessage());

            Assert.assertTrue(false);

        }

    }

    @Test
    public void alphabetize_test(){

        ArrayList<String> test, stor = new ArrayList<String>(), comp = new ArrayList<String>();

        comp.add("CDE");

        comp.add("ABC");

        comp.add("BCD");

        comp.add("DEF");

        test = ex41.App.alphabetize_ArrayList(comp);

        stor.add("ABC");

        stor.add("BCD");

        stor.add("CDE");

        stor.add("DEF");

        Assert.assertEquals(test, stor);

    }

}
