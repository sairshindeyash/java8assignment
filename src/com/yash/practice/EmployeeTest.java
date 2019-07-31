package com.yash.practice;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;


public class EmployeeTest {

	public static void main(String[] args) {
        Employee employee1 = new Employee(
                "Yash",
                20,
                new Address("1234"),
                Arrays.asList(new MobileNumber("1233"), new MobileNumber("1234")));
     
            Employee employee2 = new Employee(
                "Ram",
                20,
                new Address("1235"),
                Arrays.asList(new MobileNumber("1111"), new MobileNumber("3333"), new MobileNumber("1233")));
     
            Employee employee3 = new Employee(
                "Sita",
                20,
                new Address("1236"),
                Arrays.asList(new MobileNumber("3333"), new MobileNumber("4444")));
            
            List<Employee> employees = Arrays.asList(employee1, employee2, employee3);

            // Get employee with exact match name "Yash", if not found print "Not found".
              Optional<Employee> yashEmp = employees.stream().filter(emp->emp.getName().equals("Yash")).findAny();           
              String res = yashEmp.isPresent()?yashEmp.get().toString():"Not found";
             System.out.println("Q1 :->"+res);
              
           System.out.println();
            
            // Get employee with matching address "1235"
              Employee empAddress = employees.stream().filter(emp->emp.getAddress().getZipcode().equals("1235")).findAny().get();
             System.out.println("Q2 :->"+empAddress);
           
             // Get all employee having mobile numbers 3333.
             
             
             List<Employee> empMb3333 = employees.stream()
             .filter(emp -> emp.getMobileNumbers().stream().anyMatch(x -> Objects.equals(x.getNumber(), "3333")))
             .collect(Collectors.toList());
             System.out.println(empMb3333);
                
             // Convert List<Employee> to List<String> of employee name
             List<String> empNames = employees
             .stream()
             .map(emp->emp.getName())
             .collect(Collectors.toList());
             System.out.println();
             System.out.println(empNames);
             
            // Collect all the names of employees in a string separated by ||
             String empNameHatke = employees
             .stream()
             .map(emp->emp.getName())
             .collect(Collectors.joining("||"));
             System.out.println();
             System.out.println(empNameHatke);
             
            // Change the case of List<String>
             List<String> empNameupper = employees.stream()
             .map(emp->emp.getName().toUpperCase())
             .collect(Collectors.toList());
             System.out.println();
             System.out.println(empNameupper);
             System.out.println();
             
            // Sort List<String>
             employees
             .stream()
             .map(emp->emp.getName())
             .sorted((name1,name2)->name1.compareTo(name2))
             .forEach(System.out::println);
             
             System.out.println();
             
            // sort List<Employee> based on name
             employees.sort((Employee e1, Employee e2)->e1.getName().compareTo(e2.getName()));
             employees.forEach(System.out::println);
            
            
	}
}
