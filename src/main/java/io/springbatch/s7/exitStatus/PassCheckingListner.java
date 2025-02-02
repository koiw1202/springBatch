package io.springbatch.s7.exitStatus;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-02-02        koiw1       최초 생성
 */
public class PassCheckingListner implements StepExecutionListener {

    @Override
    public void beforeStep(StepExecution stepExecution) {

    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {

        String exitCode = stepExecution.getExitStatus().getExitCode();

        if( ! ExitStatus.FAILED.getExitCode().equals(exitCode)) {
            return new ExitStatus("PASS");
        }

        return null;
    }
}
