package ex45;

import org.junit.*;

import java.io.File;

public class AppTest {

    private static final String test_address = "src/test/java/ex45/test.txt";

    private static final String output_address = "src/test/java/ex45/output.txt";

    @Test
    public void read_input_test(){

        String comp = "This\nis\na\ntest\n!", test;

        try{

            test = ex45.App.read_Input(test_address);

            Assert.assertEquals(test, comp);

        }

        catch(Exception e){

            System.out.print(e.getMessage());

            Assert.assertTrue(false);

        }

    }

    @Test
    public void replace_all_test(){

        String text = "This is a test!", comp = "This is not a test!", to_replace = "a", replacement = "not a";

        Assert.assertEquals(ex45.App.replace_All(text, to_replace, replacement), comp);

    }

    @Test
    public void write_output_test(){

        String text = "This might be a test!";
        try {

            ex45.App.write_Output(output_address, text);

            Assert.assertTrue(new File(output_address).exists());

        }

        catch(Exception e){

            System.out.print(e.getMessage());

            Assert.assertTrue(false);

        }

    }

}
