//package io.springbatch.jobRepository;
//
//import org.springframework.batch.core.*;
//import org.springframework.batch.core.repository.JobRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//@Component
//public class JobRepositoryListner implements JobExecutionListener {
//
//    @Autowired
//    private JobRepository jobRepository;
//
//    @Override
//    public void beforeJob(JobExecution jobExecution) {
//
//    }
//
//    @Override
//    public void afterJob(JobExecution jobExecution) {
//        String jobName=jobExecution.getJobInstance().getJobName();
//
//        JobParameters jobParameters = new JobParametersBuilder()
//                .addString("requestDate", "20240101").toJobParameters();
//
//        JobExecution lastJobExecution = jobRepository.getLastJobExecution(jobName, jobParameters);
//
//        if(lastJobExecution != null) {
//            for(StepExecution stepExecution : lastJobExecution.getStepExecutions()) {
//
//                BatchStatus batchStatus = stepExecution.getStatus();
//                System.out.println("Status : " + batchStatus);
//
//                ExitStatus exitStatus = stepExecution.getExitStatus();
//                System.out.println("exisStatus : " + exitStatus);
//
//                String stepName = stepExecution.getStepName();
//                System.out.println("stempName : " + stepName);
//            }
//        }
//    }
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
