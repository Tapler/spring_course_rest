package com.seroevvlad.spring.rest.dao

import com.seroevvlad.spring.rest.entity.Employee

interface EmployeeDAO {
    fun getAllEmployees(): List<Employee?>?

    fun saveEmployee(employee: Employee?)

    fun getEmployee(id: Int): Employee?

    fun deleteEmployee(id: Int)
}