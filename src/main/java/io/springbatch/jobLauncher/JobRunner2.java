//package io.springbatch.jobLauncher;
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
//import java.util.Date;
//
///**
// * description    :
// * ===========================================================
// * DATE              AUTHOR             NOTE
// * -----------------------------------------------------------
// * 2025-01-01        koiw1       최초 생성
// */
//@Component
//public class JobRunner2 implements ApplicationRunner {
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
//        JobParameters jobParameters = new JobParametersBuilder()
//                .addString("name", "user2")
//                .addLong("seq", 2L)
//                .addDate("date", new Date())
//                .addDouble("age", 16.5)
//                .toJobParameters();
//
//        jobLauncher.run(job, jobParameters);
//
//    }
//}
