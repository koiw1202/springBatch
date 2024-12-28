package config;

import com.zaxxer.hikari.HikariDataSource;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionManager;

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
public class DbJobConfiguration {

//    private final JobRepository jobRepository;
    private final DataSource dataSource;

    @Value("spring.datasource.hikari.url")
    private String url;

    @Value("spring.datasource.hikari.driver-class-name")
    private String driverClassName;

    @Value("spring.datasource.hikari.username")
    private String username;

    @Value("spring.datasource.hikari.password")
    private String password;

    private final PlatformTransactionManager transactionManager;

    @Bean
    public DataSource getDataSource() {

        return DataSourceBuilder.create()
            .driverClassName(driverClassName)
            .url(url)
            .username(username)
            .password(password)
            .type(HikariDataSource.class)
            .build();
    }

    @Bean
    public PlatformTransactionManager getPlatformTransactionManager() {
        return PlatformTransactionManager
    }

    @Bean
    public JobRepository jobRepository() throws Exception {
        JobRepositoryFactoryBean factory = new JobRepositoryFactoryBean();
        factory.setDataSource(dataSource);
        factory.setDatabaseType("db2");
        factory.setTransactionManager(transactionManager);
        return factory.getObject();
    }

    @Bean
    Job job(JobRepository jobRepository) {
        return new JobBuilder("myJob", jobRepository)
//            .start(step1())
//            .next(step2())
            .build();
    }
//
//    @Bean
//    Step step1(JobRepository jobRepository) {
//        return new StepBuilder("myStep", jobRepository).
//
//    };

}
