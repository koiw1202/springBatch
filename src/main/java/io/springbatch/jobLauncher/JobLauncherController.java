package io.springbatch.jobLauncher;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BasicBatchConfigurer;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-01-12        koiw1       최초 생성
 */

@RestController
public class JobLauncherController {

    @Autowired
    private final Job job;

    @Autowired
    private final JobLauncher jobLauncher;

    @Autowired
    private final BasicBatchConfigurer basicBatchConfigurer;

    public JobLauncherController(Job job, JobLauncher jobLauncher, BasicBatchConfigurer basicBatchConfigurer) {
        this.job = job;
        this.jobLauncher = jobLauncher;
        this.basicBatchConfigurer = basicBatchConfigurer;
    }


    @PostMapping("/batch")
    public String launch(@RequestBody Member2 member) throws JobInstanceAlreadyCompleteException, JobExecutionAlreadyRunningException, JobParametersInvalidException, JobRestartException {

        JobParameters jobParameters = new JobParametersBuilder()
                .addString("id", member.getId())
                .addDate("date", new Date())
                .toJobParameters();

        SimpleJobLauncher jobLauncher1 = (SimpleJobLauncher) basicBatchConfigurer.getJobLauncher();
        jobLauncher1.setTaskExecutor(new SimpleAsyncTaskExecutor());
        jobLauncher1.run(job, jobParameters);
//        jobLauncher.run(job, jobParameters);

        return "batch completed";

    }



}
