package ex42;

public class Employee {

    private String f_name, l_name, salary;

    public Employee(String l_name, String f_name, String salary){

        this.l_name = l_name;

        this.f_name = f_name;

        this.salary = salary;

    }

    public String get_F_Name(){

        return f_name;

    }

    public String get_L_Name(){

        return l_name;

    }

    public String get_Salary(){

        return salary;

    }

    protected void set_Salary(String salary){

        this.salary = salary;

    }

}
