//package io.springbatch.stepBuilderFactory;
//
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.launch.support.RunIdIncrementer;
//import org.springframework.batch.item.*;
//import org.springframework.batch.item.support.ListItemReader;
//import org.springframework.batch.repeat.RepeatStatus;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.Arrays;
//import java.util.List;
//
///**
// * description    :
// * ===========================================================
// * DATE              AUTHOR             NOTE
// * -----------------------------------------------------------
// * 2025-01-01        koiw1       최초 생성
// */
//@Configuration
//public class JobConfiguration2 {
//
//    private final JobBuilderFactory jobBuilderFactory;
//    private final StepBuilderFactory stepBuilderFactory ;
//
//    public JobConfiguration2(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory) {
//        this.jobBuilderFactory = jobBuilderFactory;
//        this.stepBuilderFactory = stepBuilderFactory;
//    }
//
//    @Bean
//    public Job job() {
//        return jobBuilderFactory.get("batch01")
//            .incrementer(new RunIdIncrementer())
//            .start(step1())
//            .next(chunkStep())
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
//    public Step chunkStep() {
//        return stepBuilderFactory.get("step2")
//                .<String, String>chunk(10)
//                .reader(new ListItemReader<>(Arrays.asList("item1","item2","item3","item4","item5")))
//                .processor(new ItemProcessor<String, String>() {
//                    @Override
//                    public String process(String item) throws Exception {
//                        return item.toUpperCase();
//                    }
//                })
//                .writer(new ItemWriter<String>() {
//                    @Override
//                    public void write(List<? extends String> items) throws Exception {
//
//                    }
//                })
//                .build();
//    }
//}
