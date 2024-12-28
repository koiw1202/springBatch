package config;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class DbJobConfiguration {

//    private final JobRepository jobRepository;


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
