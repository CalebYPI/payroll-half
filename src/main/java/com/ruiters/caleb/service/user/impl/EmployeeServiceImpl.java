package com.ruiters.caleb.service.user.impl;

import com.ruiters.caleb.domain.user.Employee;
import com.ruiters.caleb.repository.user.EmployeeRepository;
import com.ruiters.caleb.repository.user.impl.EmployeeRepositoryImpl;
import com.ruiters.caleb.service.user.EmployeeService;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import java.util.Set;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository repository;

    @Override
    public Set<Employee> getAll() { return repository.getAll(); }

    @Override
    public Employee create(Employee employee) { return repository.create(employee); }

    @Override
    public Employee update(Employee employee) { return repository.update(employee); }

    @Override
    public void delete(String s) { repository.delete(s); }

    @Override
    public Employee read(String s) { return repository.read(s); }
}
