package com.seroevvlad.spring.rest.configuration

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer


open class MyWebInitializerK : AbstractAnnotationConfigDispatcherServletInitializer() {
    override fun getRootConfigClasses(): Array<Class<*>?>? {
        return null
    }

    override fun getServletConfigClasses(): Array<Class<*>?>? {
        return arrayOf(MyConfig::class.java)
    }

    override fun getServletMappings(): Array<String>? {
        return arrayOf("/")
    }
}