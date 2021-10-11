package ex43;

import org.junit.*;

import java.io.File;

public class AppTest {

    public static final String folder_address = "src/test/java/ex43/Tester";

    @Test
    public void create_index_test(){

        clear_test();

        String index_address = create_folder_test() + "/index.html";

        try {

            ex43.App.create_Index_File(index_address, "Test", "Tester");

        }

        catch(Exception e){

            System.out.print(e.getMessage());

            Assert.assertTrue(false);

        }

    }


    public String create_folder_test(){

        try {

            ex43.App.create_Folder(folder_address);

        }

        catch(Exception e){

            System.out.print(e.getMessage());

        }

        Assert.assertTrue(new File(folder_address).isDirectory());

        return folder_address;

    }

    public void clear_test(){

        ex43.App.clear(folder_address);

        Assert.assertFalse(new File(folder_address).exists());

    }

}
