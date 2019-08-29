package com.codemos.empcrud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeService {

    @Autowired
    private EmployeeDAO empData;

    void launchDemo() {
        empData.populateData();
    }

    void showEmp() {
        System.out.println("Showing all employees...");
        empData.empList.stream()
                .forEach(System.out::println);
        System.out.println();
    }

    void addEmp(Employee newEmp) {
        System.out.println("Adding new employee...");
        empData.empList.add(newEmp);
        System.out.println("Employee added.");
    }

    void upEmp(int upId, int upOpt, String upStr) {
        System.out.println("Updating an employee...");
        for(Employee e : empData.empList) {
            if(upId == e.getId()) {
                if (upOpt == 1) {
                    e.setName(upStr);
                } else {
                    e.setDesignation(upStr);
                }
            }
        }
        System.out.println("Employee updated.");
    }

    void delEmp(int delId) {
        System.out.println("Deleting an employee...");
        for (int i=0; i<empData.empList.size(); i++) {
            if (empData.empList.get(i).getId() == delId) {
                empData.empList.remove(i);
                break;
            }
        }
        System.out.println("Employee deleted.");
    }
}
