package ex44;

import org.junit.*;

import java.util.ArrayList;
import java.util.List;

public class AppTest {

    private String test_file = "src/test/java/ex44/test.json";

    @Test
    public void read_input_test(){

        ArrayList<Product> product_list = new ArrayList<Product>(), tester;

        product_list.add(new Product("A1", 1.00, 26));

        product_list.add(new Product("B2", 2.00, 25));

        product_list.add(new Product("C3", 3.00, 24));

        try {

            tester = ex44.App.read_Input(test_file);

            for(int i = 0; i < product_list.size(); i++){

                if(!(compare_products(tester.get(i), product_list.get(i)))){

                    Assert.assertTrue(false);

                }

            }

            Assert.assertTrue(true);

        }

        catch(Exception e){

            System.out.print(e.getMessage());

            Assert.assertTrue(false);

        }

    }

    public boolean compare_products(Product p1, Product p2){

        if(!p1.get_Name().equals(p2.get_Name())){

            return false;

        }

        if(p1.get_Price() != p2.get_Price()){

            return false;

        }

        if(p1.get_Quantity() != p2.get_Quantity()){

            return false;

        }

        return true;

    }

}
