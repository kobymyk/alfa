package functional.stream;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class EmployeeCollect {
    public static List<String> getList(List<Employee> employees) {
        return employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());
    }

    public static String getString(List<Employee> employees) {
        return employees.stream()
                .map(Employee::toString)
                .collect(Collectors.joining(", "));
    }

    public static int salarySum(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.summingInt(Employee::getSalary));
    }

    public static Map<Department, List<Employee>> byDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }

    public static Map<Department, Set<String>> byDepartmentSet(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.mapping(Employee::getName, Collectors.toSet())));
    }

    public static Map<Department, Integer> byDepartmentSalary(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.summingInt(Employee::getSalary)));
    }

    public static Map<Boolean, List<Employee>> partitionSalary(List<Employee> employees, int threshold) {
        return employees.stream()
                .collect(Collectors.partitioningBy(s -> s.getSalary() >= threshold));
    }
}
