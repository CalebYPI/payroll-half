package com.ruiters.caleb.domain.user;

public class Employee {
    private String id, name;

    private Employee() { }

    private Employee(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
    }

    public String getId() { return id; }

    public String getName() { return name; }

    public static class Builder{
        private String id, name;

        public Builder employeeId(String id) {
            this.id = id;
            return this;
        }

        public Builder employeeName(String name) {
            this.name = name;
            return this;
        }

        public Builder copy(Employee employee) {
            this.id = employee.id;
            this.name = employee.name;
            return this;
        }

        public Employee build() {return new Employee(this);}
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
