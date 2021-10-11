package ex46;

import org.junit.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AppTest {

    private static final String test_address = "src/test/java/ex46/test.txt";

    private static HashMap<String, Integer> tester;

    @Before
    public void setup(){

        try{

            tester = ex46.App.count_Words(test_address);

        }

        catch(Exception e){

            System.out.print(e.getMessage());

        }

    }

    @Test
    public void count_Words_test(){

        HashMap<String, Integer> comp = new HashMap<String, Integer>();

        comp.put("test", 4);

        comp.put("testing", 2);

        comp.put("tester", 1);

        Assert.assertEquals(tester, comp);

    }

    @Test
    public void sort_arraylist_test(){

        ArrayList<String> comp = new ArrayList<String>(), test = new ArrayList<String>();

        comp.add("test");

        comp.add("testing");

        comp.add("tester");

        ArrayList<Map.Entry<String, Integer>> list = ex46.App.map_To_ArrayList(tester);

        list = ex46.App.sort_ArrayList(list);

        for(Map.Entry<String, Integer> e : list){

            test.add(e.getKey());

        }

        Assert.assertEquals(test, comp);

    }

}
