//package io.springbatch.incremeter;
//
//import org.springframework.batch.core.JobParameters;
//import org.springframework.batch.core.JobParametersBuilder;
//import org.springframework.batch.core.JobParametersIncrementer;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
///**
// * description    :
// * ===========================================================
// * DATE              AUTHOR             NOTE
// * -----------------------------------------------------------
// * 2025-01-19        koiw1       최초 생성
// */
//public class CustomJobParametersIncrementer implements JobParametersIncrementer {
//
//    static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyyMMdd-hhmmss");
//
//    @Override
//    public JobParameters getNext(JobParameters parameters) {
//
//        String id = SIMPLE_DATE_FORMAT.format(new Date());
//
//        return new JobParametersBuilder().addString("run.id", id).toJobParameters();
//    }
//}
