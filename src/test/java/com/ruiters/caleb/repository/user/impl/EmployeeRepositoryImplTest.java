package com.ruiters.caleb.repository.user.impl;

import com.ruiters.caleb.domain.user.Employee;
import com.ruiters.caleb.factory.user.EmployeeFactory;
import com.ruiters.caleb.repository.user.EmployeeRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeRepositoryImplTest {

    private EmployeeRepository repository;
    private Employee employee;

    private Employee getSavedEmployees() {
        Set<Employee> savedEmployees = this.repository.getAll();
        return savedEmployees.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = EmployeeRepositoryImpl.getRepository();
        this.employee = EmployeeFactory.buildEmployee("Jef");
    }

    @Test
    public void a_create() {
        Employee created = this.repository.create(this.employee);
        System.out.println("Created: " + created);
        d_getAll();
        Assert.assertSame(created, this.employee);
    }

    @Test
    public void b_read() {
        Employee savedEmployee = getSavedEmployees();
        System.out.println("EmployeeID: " + savedEmployee.getId());
        Employee read = this.repository.read(savedEmployee.getId());
        System.out.println("Read: " + read);
        d_getAll();
        Assert.assertSame(savedEmployee, read);
    }

    @Test
    public void c_update() {
        Employee savedEmployee = getSavedEmployees();
        System.out.println("About to be updated: " + savedEmployee.getId());
        Employee update = this.repository.update(savedEmployee);
        System.out.println("Updated to: " + update);
        d_getAll();
        Assert.assertSame(savedEmployee, update);
    }

    @Test
    public void d_getAll() {
        Set<Employee> all = this.repository.getAll();
        System.out.println("All: " + all);
    }

    @Test
    public void e_delete() {
        Employee savedEmployee = getSavedEmployees();
        this.repository.delete(savedEmployee.getId());
        d_getAll();
    }
}