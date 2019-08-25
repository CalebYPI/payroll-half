package com.ruiters.caleb.factory.user;

import com.ruiters.caleb.domain.user.Employee;
import com.ruiters.caleb.util.Misc;

public class EmployeeFactory {
    public static Employee buildEmployee(String name) {
        return new Employee.Builder().employeeId(Misc.generateId()).employeeName(name).build();
    }
}
