package cloud.ttest.wastemanagement.shared.infrastructure.config;

import cloud.ttest.wastemanagement.wastemanager.infrastructure.adapter.query.WasteManagerQueryRepositoryImpl;
import cloud.ttest.wastemanagement.wastemanager.infrastructure.repository.hibernate.WasteManagerEntity;
import cloud.ttest.wastemanagement.wastemanageraddress.infrastructure.adapter.query.WasteManagerAddressQueryRepositoryImpl;
import cloud.ttest.wastemanagement.wastemanageraddress.infrastructure.repository.hibernate.WasteManagerAddressEntity;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@SuppressWarnings("all")
@EnableJpaRepositories(entityManagerFactoryRef = "readEntityManagerFactory", transactionManagerRef =
        "readTransactionManager", basePackageClasses = {WasteManagerQueryRepositoryImpl.class,
        WasteManagerAddressQueryRepositoryImpl.class})
public class DatabaseReadConfiguration {

    @Bean(name = "readDataSourceProperties")
    @ConfigurationProperties(value = "spring.read-datasource")
    public DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = "readDataSource")
    @ConfigurationProperties(prefix = "spring.read-datasource")
    public DataSource datasource(@Qualifier("readDataSourceProperties") DataSourceProperties properties) {
        return properties.initializeDataSourceBuilder().build();
    }

    @Bean(name = "readEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(EntityManagerFactoryBuilder builder,
            @Qualifier("readDataSource") DataSource dataSource) {
        return builder.dataSource(dataSource)
                .packages(WasteManagerEntity.class, WasteManagerAddressEntity.class)
                .persistenceUnit("ReadDB").build();
    }

    @Bean(name = "readTransactionManager")
    @ConfigurationProperties("spring.jpa")
    public PlatformTransactionManager transactionManager(
            @Qualifier("readEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
