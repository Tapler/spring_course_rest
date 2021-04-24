package com.seroevvlad.spring.rest.service

import com.seroevvlad.spring.rest.dao.EmployeeDAO
import com.seroevvlad.spring.rest.entity.Employee
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
open class EmployeeServiceImpl : EmployeeService {

    @Autowired
    private val employeeDAO: EmployeeDAO? = null

    @Transactional
    override fun getAllEmployees(): List<Employee?>? {
        return employeeDAO!!.getAllEmployees()
    }

    @Transactional
    override fun saveEmployee(employee: Employee?) {
        employeeDAO!!.saveEmployee(employee)
    }

    @Transactional
    override fun getEmployee(id: Int): Employee? {
        return employeeDAO!!.getEmployee(id)
    }

    @Transactional
    override fun deleteEmployee(id: Int) {
        employeeDAO!!.deleteEmployee(id)
    }
}