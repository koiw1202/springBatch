//package io.springbatch.executionContext;
//
//import org.springframework.batch.core.StepContribution;
//import org.springframework.batch.core.scope.context.ChunkContext;
//import org.springframework.batch.core.step.tasklet.Tasklet;
//import org.springframework.batch.item.ExecutionContext;
//import org.springframework.batch.repeat.RepeatStatus;
//
///**
// * description    :
// * ===========================================================
// * DATE              AUTHOR             NOTE
// * -----------------------------------------------------------
// * 2025-01-05        koiw1       최초 생성
// */
//public class CustomTasklet implements Tasklet {
//
//    @Override
//    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
//
//        System.out.println("step1 executed");
//
//        ExecutionContext jobExecutionContext = contribution.getStepExecution().getJobExecution().getExecutionContext();
//        ExecutionContext stepExecutionContext = contribution.getStepExecution().getExecutionContext();
//
//        String jobName = chunkContext.getStepContext().getStepExecution().getJobExecution().getJobInstance().getJobName();
//        String stepName = chunkContext.getStepContext().getStepExecution().getStepName();
//
//        if(jobExecutionContext.get("jobName") == null) {
//            jobExecutionContext.put("jobName", jobName);
//        }
//
//        if(stepExecutionContext.get("stepName") == null) {
//            stepExecutionContext.put("stepName", stepName);
//        }
//
//        System.out.println("jobName : " + jobExecutionContext.get("jobName"));
//        System.out.println("stepName : " + stepExecutionContext.get("stepName"));
//
//
//        return RepeatStatus.FINISHED;
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
//
//
//
//
//
