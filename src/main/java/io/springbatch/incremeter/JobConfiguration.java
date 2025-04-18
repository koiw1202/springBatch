//package io.springbatch.incremeter;
//
//import org.springframework.batch.core.*;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.job.DefaultJobParametersValidator;
//import org.springframework.batch.core.launch.support.RunIdIncrementer;
//import org.springframework.batch.repeat.RepeatStatus;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * description    :
// * ===========================================================
// * DATE              AUTHOR             NOTE
// * -----------------------------------------------------------
// * 2025-01-01        koiw1       최초 생성
// */
//@Configuration
//public class JobConfiguration {
//
//    private final JobBuilderFactory jobBuilderFactory;
//    private final StepBuilderFactory stepBuilderFactory ;
//
//    public JobConfiguration(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory) {
//        this.jobBuilderFactory = jobBuilderFactory;
//        this.stepBuilderFactory = stepBuilderFactory;
//    }
//
//    @Bean
//    public Job job() {
//        return jobBuilderFactory.get("batch01")
//            .start(step1())
//            .next(step2())
//            .next(step3())
////            .incrementer(new CustomJobParametersIncrementer())
//                .incrementer(new RunIdIncrementer())
//            .build();
//    }
//
//    @Bean
//    public Step step1() {
//        return stepBuilderFactory.get("step1")
//            .tasklet((contribution, chunkContext) -> {
//
//                System.out.println("step1 executed");
//
//                return RepeatStatus.FINISHED;
//            }).build();
//    }
//
//    @Bean
//    public Step step2() {
//        return stepBuilderFactory.get("step2")
//            .tasklet((contribution, chunkContext) -> {
//
//                System.out.println("step2 executed");
//
//                return RepeatStatus.FINISHED;
//            }).build();
//    }
//
//    @Bean
//    public Step step3() {
//        return stepBuilderFactory.get("step3")
//            .tasklet((contribution, chunkContext) -> {
//
//                System.out.println("step3 executed");
//
//                return RepeatStatus.FINISHED;
//            }).build();
//    }
//}
