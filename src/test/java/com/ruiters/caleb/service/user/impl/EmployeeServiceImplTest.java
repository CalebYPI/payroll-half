package com.ruiters.caleb.service.user.impl;

import com.ruiters.caleb.domain.demography.Race;
import com.ruiters.caleb.domain.user.Employee;
import com.ruiters.caleb.factory.user.EmployeeFactory;
import com.ruiters.caleb.repository.demography.RaceRepository;
import com.ruiters.caleb.repository.demography.impl.RaceRepositoryImpl;
import com.ruiters.caleb.repository.user.impl.EmployeeRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeServiceImplTest {

    private EmployeeRepositoryImpl repository;
    private Employee employee;

    private Employee getSavedEmployee() { return this.repository.getAll().iterator().next(); }

    @Before
    public void setUp() throws Exception {
        this.repository = EmployeeRepositoryImpl.getRepository();
        this.employee = EmployeeFactory.buildEmployee("Jef");
    }

    @Test
    public void a_create() {
        Employee created = this.repository.create(this.employee);
        System.out.println("Created: " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.employee);
    }

    @Test
    public void b_read() {
        Employee savedEmployee = getSavedEmployee();
        Employee read = this.repository.read(savedEmployee.getId());
        System.out.println("Read: " + read);
        Assert.assertSame(read, savedEmployee);
    }

    @Test
    public void c_update() {
        String newName = "My name's Jef";
        Employee update = new Employee.Builder().copy(getSavedEmployee()).employeeName(newName).build();
        System.out.println("Updated to: " + update);
        this.repository.update(update);
        Assert.assertSame(newName, update.getName());
    }

    @Test
    public void d_getAll() {
        Set<Employee> all = this.repository.getAll();
        System.out.println("All: " + all);
    }

    @Test
    public void e_delete() {
        Employee savedEmployee = getSavedEmployee();
        this.repository.delete(savedEmployee.getId());
        d_getAll();
    }
}