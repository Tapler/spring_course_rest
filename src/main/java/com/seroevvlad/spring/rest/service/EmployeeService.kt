package com.seroevvlad.spring.rest.service

import com.seroevvlad.spring.rest.entity.Employee

interface EmployeeService {
    fun getAllEmployees(): List<Employee?>?

    fun saveEmployee(employee: Employee?)

    fun getEmployee(id: Int): Employee?

    fun deleteEmployee(id: Int)
}