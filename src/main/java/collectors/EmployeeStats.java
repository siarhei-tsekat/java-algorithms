package collectors;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeStats {
    public static void main(String[] args) {

        Employee john = new Employee("E123", "John Nhoj", 200.99, "IT");
        Employee south = new Employee("E223", "South Htuos", 299.99, "Sales");
        Employee reet = new Employee("E133", "Reet Teer", 300.99, "IT");
        Employee prateema = new Employee("E143", "Prateema Rai", 300.99, "Benefits");
        Employee yogen = new Employee("E323", "Yogen Rai", 200.99, "Sales");

        List<Employee> employees = Arrays.asList(john, south, reet, prateema, yogen);

        // 1. Finding Average Salary
        Double avSalary = employees.stream().collect(Collectors.averagingDouble(em -> em.getSalary()));
        System.out.println("av salary " + avSalary);

        // 2. Finding Total Salary

        double totalSum1 = employees.stream().collect(Collectors.summarizingDouble(em -> em.getSalary())).getSum();
        double totalSum2 = employees.stream().collect(Collectors.summingDouble(em -> em.getSalary()));
        System.out.println("total sum " + totalSum1);
        System.out.println("total sum " + totalSum2);

        // 3. Finding Max Salary
        double max1 = employees.stream().collect(Collectors.summarizingDouble(em -> em.getSalary())).getMax();
        System.out.println("max salary " + max1);

        // 4. Calculating Average Salary per Department With Sorted Department Name
        Map<String, Double> collect = employees.stream()
                .collect(Collectors.groupingBy(em -> em.getDepartment(), TreeMap::new, Collectors.averagingDouble(em -> em.getSalary())));
        System.out.println(collect);

        // 5. Finding employees with a salary greater than the average salary is
        Map<Boolean, List<Employee>> listMap = employees.stream().collect(Collectors.partitioningBy(em -> em.getSalary() > avSalary));
        System.out.println(listMap);

    }
}


