//package io.springbatch.itemStream;
//
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.job.builder.FlowBuilder;
//import org.springframework.batch.core.job.flow.Flow;
//import org.springframework.batch.item.ItemReader;
//import org.springframework.batch.repeat.RepeatStatus;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.ArrayList;
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
//        return jobBuilderFactory.get("itemStream")
//                .start(step1())
//                .next(step2())
//                .build();
//    }
//
//    @Bean
//    public Step step1() {
//        return stepBuilderFactory.get("step1")
//                .chunk(5)
//                .reader(itemReader())
//                .writer(itemWrite())
//                .build();
//    }
//
//    public CustomItemStreamReader itemReader() {
//
//        List<String> items = new ArrayList<>(10);
//
//        for(int i=0; i < 10 ; i++) {
//            items.add("" + i);
//        }
//
//         return new CustomItemStreamReader(items);
//    }
//
//     public CustomItemWriter itemWrite() {
//        return new CustomItemWriter();
//     }
//
//    @Bean
//    public Step step2() {
//
//       return stepBuilderFactory.get("step2")
//           .tasklet((contribution, chunkContext) -> {
//                System.out.println("step2 executed");
//                return RepeatStatus.FINISHED;
//           }).build();
//   }
//}