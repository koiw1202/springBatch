//package io.springbatch.jobStep;
//
//import org.springframework.batch.core.*;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.job.builder.FlowBuilder;
//import org.springframework.batch.core.job.flow.Flow;
//import org.springframework.batch.core.launch.JobLauncher;
//import org.springframework.batch.core.step.job.DefaultJobParametersExtractor;
//import org.springframework.batch.core.step.job.JobParametersExtractor;
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
//    public Job parentJob() {
//        return jobBuilderFactory.get("parentJob")
//            .start(jobStep(null))
//            .next(step2())
//            .build();
//    }
//
//    @Bean
//    public Step jobStep(JobLauncher jobLauncher) {
//        return stepBuilderFactory.get("jobStep")
//            .job(childJob())
//            .launcher(jobLauncher)
//            .parametersExtractor(jobParametersExtractor())
//            .listener(new StepExecutionListener() {
//                @Override
//                public void beforeStep(StepExecution stepExecution) {
//                    stepExecution.getExecutionContext().putString("name","user1");
//                }
//
//                @Override
//                public ExitStatus afterStep(StepExecution stepExecution) {
//                    return null;
//                }
//            })
//            .build();
//    }
//
//    @Bean
//    public Job childJob() {
//        return jobBuilderFactory.get("childJob")
//                .start(step1())
//                .build();
//    }
//
//    private DefaultJobParametersExtractor jobParametersExtractor(){
//        DefaultJobParametersExtractor defaultJobParametersExtractor = new DefaultJobParametersExtractor();
//        defaultJobParametersExtractor.setKeys(new String[]{"name"});
//
//        return defaultJobParametersExtractor;
//    }
//
//
//    @Bean
//    public Step step1() {
//        return stepBuilderFactory.get("step1")
//                .tasklet((contribution, chunkContext) -> RepeatStatus.FINISHED).build();
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
//
//            }).build();
//    }
//}