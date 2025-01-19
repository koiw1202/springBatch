//package io.springbatch.jobParametersValidator;
//
//import org.springframework.batch.core.JobParameters;
//import org.springframework.batch.core.JobParametersInvalidException;
//import org.springframework.batch.core.JobParametersValidator;
//
///**
// * description    :
// * ===========================================================
// * DATE              AUTHOR             NOTE
// * -----------------------------------------------------------
// * 2025-01-19        koiw1       최초 생성
// */
//public class CustomJobParametersValidator implements JobParametersValidator {
//
//
//    @Override
//    public void validate(JobParameters parameters) throws JobParametersInvalidException {
//
//        if(parameters.getString("name") == null) {
//            throw new JobParametersInvalidException("name parameter is not found.");
//        }
//
//    }
//}
