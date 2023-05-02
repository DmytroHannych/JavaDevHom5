package org.example;

import java.math.BigDecimal;

public class MaxSalaryWorker {
    private String name;
    private BigDecimal salary;

    public MaxSalaryWorker(String name, BigDecimal salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "MaxSalaryWorker" +
                "name='" + name + '\'' +
                ", salary=" + salary;
    }
}
