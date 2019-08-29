package com.codemos.empcrud;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeDAO {
    List<Employee> empList = new ArrayList<>();

    void populateData() {
        Employee e1 = new Employee(1, "A", "Manager");
        Employee e2 = new Employee(2, "B", "Developer");
        Employee e3 = new Employee(3, "C", "Tester");

        empList.add(e1);
        empList.add(e2);
        empList.add(e3);
    }
}
