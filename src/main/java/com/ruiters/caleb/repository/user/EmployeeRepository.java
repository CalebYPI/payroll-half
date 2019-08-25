package com.ruiters.caleb.repository.user;

import com.ruiters.caleb.domain.user.Employee;
import com.ruiters.caleb.repository.IRepository;

import java.util.Set;

public interface EmployeeRepository extends IRepository<Employee, String> {
    Set<Employee> getAll();
}
