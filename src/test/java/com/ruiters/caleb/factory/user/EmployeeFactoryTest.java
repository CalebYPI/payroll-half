package com.ruiters.caleb.factory.user;

import com.ruiters.caleb.domain.user.Employee;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeFactoryTest {

    private String name;

    @Before
    public void setUp() throws Exception {
        this.name = "jef";
    }

    @Test
    public void buildEmployee() {
        Employee employee = EmployeeFactory.buildEmployee(this.name);
        Assert.assertNotNull(employee.getId());
        Assert.assertNotNull(employee);
    }
}