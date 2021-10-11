package ex42;

import org.junit.*;

import java.util.ArrayList;

public class AppTest {

    private static final String test_address = "src/test/java/ex42/test.txt";

    private static ArrayList<Employee> tester;

    @Before
    public void setup() {

        try {

            tester = ex42.App.read_File(test_address);

        } catch (Exception e) {

            System.out.print(e.getMessage());

        }

    }

    @Test
    public void read_File_test() {

        ArrayList<Employee> comp = new ArrayList<Employee>();

        comp.add(new Employee("Tester", "Tess", "1010"));

        comp.add(new Employee("Ro", "Knight", "0"));

        comp.add(new Employee("Cat", "Garfield", "999999"));

        comp.add(new Employee("Ten", "Say", "666666"));

        Assert.assertTrue(compare_Employee_ArrayList(tester, comp));

    }

    @Test
    public void find_longest_length_test(){

        int[] test = ex42.App.find_Longest_Length(tester);

        Assert.assertArrayEquals(test, new int[]{6,8,6});

    }

    public boolean compare_Employee_ArrayList(ArrayList<Employee> L1, ArrayList<Employee> L2) {

        if (L1.size() != L2.size()) {

            return false;

        }

        for (int i = 0; i < L1.size(); i++) {

            if (!compare_Employee(L1.get(i), L2.get(i))) {

                return false;

            }

        }

        return true;

    }

    public boolean compare_Employee(Employee e1, Employee e2) {

        if (!e1.get_L_Name().equals(e2.get_L_Name())) {

            return false;

        }

        if (!e1.get_F_Name().equals(e2.get_F_Name())) {

            return false;

        }

        if (!e1.get_Salary().equals(e2.get_Salary())) {

            return false;

        }

        return true;

    }

}
