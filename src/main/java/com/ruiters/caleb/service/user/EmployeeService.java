package com.ruiters.caleb.service.user;

import com.ruiters.caleb.domain.user.Employee;
import com.ruiters.caleb.service.IService;

import java.util.Set;

public interface EmployeeService extends IService<Employee, String> {
    Set<Employee> getAll();
}
