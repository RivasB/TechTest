package cloud.ttest.wastemanagement.shared.infrastructure.config;

import cloud.ttest.wastemanagement.wastemanager.infrastructure.adapter.command.WasteManagerCommandRepositoryImpl;
import cloud.ttest.wastemanagement.wastemanager.infrastructure.repository.hibernate.WasteManagerEntity;
import cloud.ttest.wastemanagement.wastemanageraddress.infrastructure.adapter.command.WasteManagerAddressCommandRepositoryImpl;
import cloud.ttest.wastemanagement.wastemanageraddress.infrastructure.repository.hibernate.WasteManagerAddressEntity;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@SuppressWarnings("all")
@EnableJpaRepositories(entityManagerFactoryRef = "writeEntityManagerFactory", transactionManagerRef =
        "writeTransactionManager", basePackageClasses = {WasteManagerCommandRepositoryImpl.class,
        WasteManagerAddressCommandRepositoryImpl.class})
public class DatabaseWriteConfiguration {

    @Primary
    @Bean(name = "writeDataSourceProperties")
    @ConfigurationProperties("spring.datasource")
    public DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
    }

    @Primary
    @Bean(name = "writeDataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource datasource(@Qualifier("writeDataSourceProperties") DataSourceProperties properties) {
        return properties.initializeDataSourceBuilder().build();
    }

    @Primary
    @Bean(name = "writeEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(EntityManagerFactoryBuilder builder,
            @Qualifier("writeDataSource") DataSource dataSource) {
        return builder.dataSource(dataSource)
                .packages(WasteManagerEntity.class, WasteManagerAddressEntity.class)
                .persistenceUnit("WriteDB").build();
    }

    @Primary
    @Bean(name = "writeTransactionManager")
    @ConfigurationProperties("spring.jpa")
    public PlatformTransactionManager transactionManager(
            @Qualifier("writeEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
