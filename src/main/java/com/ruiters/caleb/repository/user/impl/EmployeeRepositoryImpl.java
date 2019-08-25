package com.ruiters.caleb.repository.user.impl;

import com.ruiters.caleb.domain.user.Employee;
import com.ruiters.caleb.repository.user.EmployeeRepository;

import java.util.*;

public class EmployeeRepositoryImpl implements EmployeeRepository {

    private static EmployeeRepositoryImpl repository = null;
    private Map<String, Employee> employeeMap;

    private EmployeeRepositoryImpl() { this.employeeMap = new HashMap<>(); }

    private static EmployeeRepositoryImpl employeeRepositoryImpl = null;

    public static EmployeeRepositoryImpl getRepository() {
        if (employeeRepositoryImpl == null)
            employeeRepositoryImpl = new EmployeeRepositoryImpl();
        return employeeRepositoryImpl;
    }

    public Set<Employee> getAll() {
        Collection<Employee> employees = this.employeeMap.values();
        Set<Employee> set = new HashSet<>();
        set.addAll(employees);
        return set;
    }

    public Employee create(Employee employee) {
        this.employeeMap.put(employee.getId(), employee);
        return employee;
    }

    public Employee update(Employee employee) {
        this.employeeMap.replace(employee.getId(),employee);
        return this.employeeMap.get(employee.getId());
    }

    public void delete(String s) {
        this.employeeMap.remove(s);
    }

    public Employee read(String s) {
        return this.employeeMap.get(s);
    }
}
