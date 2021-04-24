package com.seroevvlad.spring.rest.controller

import com.seroevvlad.spring.rest.entity.Employee
import com.seroevvlad.spring.rest.exception_handling.NoSuchEmployeeException
import com.seroevvlad.spring.rest.service.EmployeeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class MyRESTController {

    @Autowired
    private val employeeService: EmployeeService? = null

    @GetMapping("/employees")
    fun showAllEmployees(): List<Employee?>? {
        return employeeService!!.getAllEmployees()
    }

    @GetMapping("/employees/{id}")
    fun getEmployee(@PathVariable id: Int): Employee? {
        return employeeService!!.getEmployee(id)
                ?: throw NoSuchEmployeeException("There is no employee with ID = $id in Database")
    }

    @PostMapping("/employees")
    fun addNewEmployee(@RequestBody employee: Employee?): Employee? {
        employeeService!!.saveEmployee(employee)
        return employee
    }

    @PutMapping("/employees")
    fun updateEmployee(@RequestBody employee: Employee?): Employee? {
        employeeService!!.saveEmployee(employee)
        return employee
    }

    @DeleteMapping("/employees/{id}")
    fun deleteEmployee(@PathVariable id: Int): String? {
        val (id1, name, surname, department, salary) = employeeService!!.getEmployee(id)
                ?: throw NoSuchEmployeeException("There is no employee with ID = $id in Database")
        employeeService.deleteEmployee(id)
        return "Employee with ID = $id was deleted"
    }
}