//package io.springbatch.s7.transition;
//
//import org.springframework.batch.core.ExitStatus;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
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
//public class JobConfiguration7_3 {
//
//    private final JobBuilderFactory jobBuilderFactory;
//    private final StepBuilderFactory stepBuilderFactory ;
//
//    public JobConfiguration7_3(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory) {
//        this.jobBuilderFactory = jobBuilderFactory;
//        this.stepBuilderFactory = stepBuilderFactory;
//    }
//
////    @Bean
////    public Job job() {
////        return jobBuilderFactory.get("batchs7_3")
////            .incrementer(new RunIdIncrementer())
////            .start(step1())
////            .next(step2())
////            .next(step3())
////            .build();
////    }
//
//    @Bean
//    public Job job() {
//        return jobBuilderFactory.get("batchs7_3")
//                .incrementer(new RunIdIncrementer())
//                .start(step1())
//                .on("FAILED")
//                .to(step2())
//                .end()
//                .build();
//    }
//
//    @Bean
//    public Step step1() {
//        return stepBuilderFactory.get("step1")
//            .tasklet((contribution, chunkContext) -> {
//
//                System.out.println("==================== step1 executed");
//                contribution.setExitStatus(ExitStatus.FAILED);
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
//                System.out.println("==================== step2 executed");
//
////                contribution.setExitStatus(ExitStatus.FAILED);
//
//                return RepeatStatus.FINISHED;
//            }).build();
//    }
//
//    @Bean
//    public Step step3() {
//        return stepBuilderFactory.get("step3")
//                .tasklet((contribution, chunkContext) -> {
//
//                    System.out.println("==================== step3 executed");
//
//                    return RepeatStatus.FINISHED;
//                }).build();
//    }
//
//}
