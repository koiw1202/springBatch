//package io.springbatch.batchInit;
//
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.StepContribution;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.launch.support.RunIdIncrementer;
//import org.springframework.batch.core.scope.context.ChunkContext;
//import org.springframework.batch.core.step.tasklet.Tasklet;
//import org.springframework.batch.repeat.RepeatStatus;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * description    :
// * ===========================================================
// * DATE              AUTHOR             NOTE
// * -----------------------------------------------------------
// * 2024-12-09        koiw1       최초 생성
// */
//@Configuration
//public class HelloJobConfiguration {
//
//    private final JobBuilderFactory jobBuilderFactory;
//    private final StepBuilderFactory stepBuilderFactory ;
//
//    public HelloJobConfiguration(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory) {
//        this.jobBuilderFactory = jobBuilderFactory;
//        this.stepBuilderFactory = stepBuilderFactory;
//    }
//
//    @Bean
//    public Job helloJob() {
//        return jobBuilderFactory.get("job1")
//                .incrementer(new RunIdIncrementer())
//                .start(helloStep1())
//                .next(helloStep2())
//                .build();
//    }
//
//    @Bean
//    public Step helloStep1() {
//        return stepBuilderFactory.get("helloStep1")
//                .tasklet(new Tasklet() {
//                    @Override
//                    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
//                        System.out.println("========================");
//                        System.out.println(" Step1 실행");
//                        System.out.println("========================");
//
//                        return RepeatStatus.FINISHED;
//                    }
//                })
//                .build();
//    }
//
//    @Bean
//    public Step helloStep2() {
//        return stepBuilderFactory.get("helloStep2")
//            .tasklet(new Tasklet() {
//                 @Override
//                 public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
//                     System.out.println("========================");
//                     System.out.println(" Step2 실행");
//                     System.out.println("========================");
//
//                     return RepeatStatus.FINISHED;
//                 }
//            })
//            .build();
//    }
//
//}
