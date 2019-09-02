package com.zcc.contactapp.server.db.dbcp2;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;


/**
 * Created by cc on 2019/9/2.
 */
@Component
public class DataSourceShow implements ApplicationContextAware {

    ApplicationContext applicationContext = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        DataSource dataSource = applicationContext.getBean(DataSource.class);
        System.out.println("------------------ - 一一---- - 一 -");
        System.out.println(dataSource.getClass().getName());
        System.out.println("--------------------------------");
    }
}
