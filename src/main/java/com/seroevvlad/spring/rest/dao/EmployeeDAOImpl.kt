package com.seroevvlad.spring.rest.dao

import com.seroevvlad.spring.rest.entity.Employee
import org.hibernate.SessionFactory
import org.hibernate.query.Query
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class EmployeeDAOImpl : EmployeeDAO{

    @Autowired
    private val sessionFactory: SessionFactory? = null

    override fun getAllEmployees(): List<Employee>? {
        val session = sessionFactory!!.currentSession
        return session.createQuery("from Employee", Employee::class.java).resultList
    }

    override fun saveEmployee(employee: Employee?) {
        val session = sessionFactory!!.currentSession
        session.saveOrUpdate(employee)
    }

    override fun getEmployee(id: Int): Employee? {
        val session = sessionFactory!!.currentSession
        return session[Employee::class.java, id]
    }

    override fun deleteEmployee(id: Int) {
        val session = sessionFactory!!.currentSession
        val query: Query<Employee> = session.createQuery("delete from Employee where id =:employeeId") as Query<Employee>
        query.setParameter("employeeId", id)
        query.executeUpdate()
    }
}