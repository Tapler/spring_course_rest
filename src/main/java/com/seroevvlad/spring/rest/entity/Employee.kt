package com.seroevvlad.spring.rest.entity

import javax.persistence.*

@Entity
@Table(name = "employees")
data class Employee(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        val id: Int,
        @Column(name = "name")
        val name: String,
        @Column(name = "surname")
        val surname: String,
        @Column(name = "department")
        val department: String,
        @Column(name = "salary")
        val salary: String
) {
        constructor() : this(0, "", "", "", "") {

        }
}




