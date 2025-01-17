//package io.springbatch.jobExecutionTest;
//
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.JobParameters;
//import org.springframework.batch.core.JobParametersBuilder;
//import org.springframework.batch.core.launch.JobLauncher;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.stereotype.Component;
//
///**
// * description    :
// * ===========================================================
// * DATE              AUTHOR             NOTE
// * -----------------------------------------------------------
// * 2025-01-01        koiw1       최초 생성
// */
//@Component
//public class JobRunner3 implements ApplicationRunner {
//
//    @Autowired
//    JobLauncher jobLauncher;
//
//    @Autowired
//    Job job;
//
//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//
//        JobParameters jobParameters = new JobParametersBuilder().addString("name", "user4").toJobParameters();
//
//        jobLauncher.run(job, jobParameters);
//
//    }
//}
