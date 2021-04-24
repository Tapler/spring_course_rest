package com.seroevvlad.spring.rest.configuration

import com.mchange.v2.c3p0.ComboPooledDataSource
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.orm.hibernate5.HibernateTransactionManager
import org.springframework.orm.hibernate5.LocalSessionFactoryBean
import org.springframework.transaction.annotation.EnableTransactionManagement
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import java.beans.PropertyVetoException
import java.util.*
import javax.sql.DataSource

@Configuration
@ComponentScan(basePackages = ["com.seroevvlad.spring.rest"])
@EnableWebMvc
@EnableTransactionManagement
open class MyConfig {
    @Bean
    open fun dataSource(): DataSource? {
        val dataSource = ComboPooledDataSource()
        try {
            dataSource.driverClass = "com.mysql.cj.jdbc.Driver"
            dataSource.jdbcUrl = "jdbc:mysql://localhost:3306/my_db?useSSL=false&serverTimezone=UTC"
            dataSource.user = "bestuser"
            dataSource.password = "bestuser"
        } catch (e: PropertyVetoException) {
            e.printStackTrace()
        }
        return dataSource
    }

    @Bean
    open fun sessionFactory(): LocalSessionFactoryBean {
        val sessionFactory = LocalSessionFactoryBean()
        sessionFactory.setDataSource(dataSource())
        sessionFactory.setPackagesToScan("com.seroevvlad.spring.rest.entity")
        val hibernateProperties = Properties()
        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect")
        hibernateProperties.setProperty("hibernate.show_sql", "true")
        sessionFactory.hibernateProperties = hibernateProperties
        return sessionFactory
    }

    @Bean
    open fun transactionManager(): HibernateTransactionManager? {
        val transactionManager = HibernateTransactionManager()
        transactionManager.sessionFactory = sessionFactory().getObject()
        return transactionManager
    }
}