package io.springbatch.springbatch;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Date;

@Configuration
@EnableAutoConfiguration
@EnableBatchProcessing
public class TestBatchConfig {

    @Autowired
    private JobLauncherTestUtils jobLauncherTestUtils;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void simeJobTest() throws Exception {

        // given
        JobParameters jobParameters = new JobParametersBuilder()
                .addString("name", "user1")
                .addLong("date", new Date().getTime())
                .toJobParameters();

        // when
        JobExecution jobExecetion = jobLauncherTestUtils.launchJob(jobParameters);

        // then
        Assert.assertEquals(jobExecetion.getExitStatus(), BatchStatus.COMPLETED);
        Assert.assertEquals(jobExecetion.getStatus(), BatchStatus.COMPLETED);

    }
}
