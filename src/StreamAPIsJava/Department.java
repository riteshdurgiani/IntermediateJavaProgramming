package StreamAPIsJava;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private List<Employee1> employee1s = new ArrayList<>();

    public Department(String name){
        this.name = name;
    }
    public void addEmployee(Employee1 employee){
        employee1s.add(employee);
    }
    public List<Employee1> getEmployees(){
        return employee1s;
    }
}
