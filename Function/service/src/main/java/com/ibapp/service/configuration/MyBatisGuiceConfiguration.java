package com.ibapp.service.configuration;

import com.google.inject.Injector;
import com.ibapp.persistence.PersonMapper;
import com.ibapp.persistence.RegisterMapper;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.guice.MyBatisModule;
import org.mybatis.guice.datasource.dbcp.BasicDataSourceProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static com.google.inject.Guice.createInjector;
import static com.google.inject.name.Names.bindProperties;

/**
 * Created by imranbordiwala on 21/05/2015.
 */
public class MyBatisGuiceConfiguration {

    private static final Logger LOG = LoggerFactory.getLogger(MyBatisGuiceConfiguration.class);

    private Injector injector;

    public MyBatisGuiceConfiguration() {

        try {
            setupMybatisGuice();
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error("Error configuring MyBatis Guice " + e.getMessage());
        }
    }

    protected void setupMybatisGuice() throws Exception{

        this.injector = createInjector(new MyBatisModule() {

            @Override
            public void  initialize() {

                bindDataSourceProviderType(BasicDataSourceProvider.class);
                bindTransactionFactoryType(JdbcTransactionFactory.class);
                addMapperClass(PersonMapper.class);
                addMapperClass(RegisterMapper.class);
                try {
                    bindProperties(binder(), createProperties());
                } catch (Exception e) {
                    e.printStackTrace();
                    LOG.error("Unable to load properties from jdbc.properties " + e.getMessage());
                }
            }
        }
        );
    }

    protected Properties createProperties() throws IOException {

        Properties myBatisProperties = new Properties();
        InputStream in = MyBatisGuiceConfiguration.class.getClassLoader().getResourceAsStream("jdbc.properties");
        myBatisProperties.load(in);

        return myBatisProperties;

    }

}
