package com.pdf.invoice.config;

import java.util.HashMap;

import javax.sql.DataSource;

import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.hibernate.SpringImplicitNamingStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.pdf.invoice.repo",
        entityManagerFactoryRef = "EBillingEntityManager",
        transactionManagerRef = "EBillingTransactionManager")
public class EBillingDatasourceConfig {

    @Value("${datasource.db-pdf.hibernate.hbm2ddl.auto}")
    private String hbm2ddl;

    @Value("${datasource.db-pdf.hibernate.dialect}")
    private String dialect;

    @Bean(name = "eBillingDatasource")
    @ConfigurationProperties(prefix="datasource.db-pdf")
    public DataSource eBillingDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "EBillingEntityManager")
    public LocalContainerEntityManagerFactoryBean eBillingEntityManager() {
        final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(eBillingDataSource());
        em.setPackagesToScan("com.pdf.invoice.entity");

        final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        final HashMap<String, Object> properties = new HashMap<String, Object>();
        properties.put("hibernate.hbm2ddl.auto", hbm2ddl);
        properties.put("hibernate.dialect", dialect);
        properties.put("hibernate.physical_naming_strategy", CamelCaseToUnderscoresNamingStrategy.class.getName());
        properties.put("hibernate.implicit_naming_strategy", SpringImplicitNamingStrategy.class.getName());
        em.setJpaPropertyMap(properties);

        return em;
    }

    @Primary
    @Bean(name = "EBillingTransactionManager")
    public PlatformTransactionManager goMetacreteTransactionManager() {
        final JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(eBillingEntityManager().getObject());
        return transactionManager;
    }

}
