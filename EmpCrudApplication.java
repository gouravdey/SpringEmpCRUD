package com.codemos.empcrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class EmpCrudApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(EmpCrudApplication.class, args);
		EmployeeService empSL = applicationContext.getBean(EmployeeService.class);

		int f=1, z;
		empSL.launchDemo();

		while (f==1) {
			System.out.println("Select the action...");
			System.out.println("1.Show all employees");
			System.out.println("2.Add new employee");
			System.out.println("3.Update an employee");
			System.out.println("4.Delete an employee");
			System.out.println("5.Exit");

			Scanner sc = new Scanner(System.in);
			z = sc.nextInt();

			switch (z) {
				case 1:
					empSL.showEmp();
					break;
				case 2:
					System.out.print("Enter ID: ");
					int newId = sc.nextInt();
					sc.nextLine();
					System.out.print("Enter Name: ");
					String newName = sc.nextLine();
					System.out.print("Enter Designation: ");
					String newDesignation = sc.nextLine();

					Employee newEmp = new Employee(newId, newName, newDesignation);
					empSL.addEmp(newEmp);
					break;
				case 3:
					System.out.print("Enter ID: ");
					int updateId = sc.nextInt();
					System.out.println("1. Update Name");
					System.out.println("2. Update Designation");
					int updateOption = sc.nextInt();
					sc.nextLine();
					String updateString;
					if (updateOption == 1) {
						System.out.print("Enter Name: ");
						updateString = sc.nextLine();
						empSL.upEmp(updateId, updateOption, updateString);
					} else if (updateOption == 2) {
						System.out.print("Enter Designation: ");
						updateString = sc.nextLine();
						empSL.upEmp(updateId, updateOption, updateString);
					} else {
						System.out.println("Enter correct value.");
					}
					break;
				case 4:
					System.out.print("Enter the ID: ");
					int delId = sc.nextInt();
					empSL.delEmp(delId);
					break;
				case 5:
					f = 0;
					break;
				default:
					System.out.println("Invalid Option");
			}
		}
	}

}
