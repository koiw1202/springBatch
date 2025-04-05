package io.springbatch.flatFilesConfiguration;

import lombok.AllArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.Range;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

@Configuration
public class FlatFileConfiguration {


    private final StepBuilderFactory stepBuilderFactory;
    private final JobBuilderFactory jobBuilderFactory;

    public FlatFileConfiguration(StepBuilderFactory stepBuilderFactory, JobBuilderFactory jobBuilderFactory) {
        this.stepBuilderFactory = stepBuilderFactory;
        this.jobBuilderFactory = jobBuilderFactory;
    }

    @Bean
    public Job job() {
        return jobBuilderFactory.get("batchJob11")
                .start(step1())
                .next(step2())
                .build();
    }

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1")
                .chunk(5)
                .reader(itemReader())
                .writer(list1 -> {
                    list1.forEach(v -> {
                        System.out.println(v);
                    });
                })
                .build();
    }

    @Bean
    public ItemReader itemReader() {

        System.out.println("1");

        return new FlatFileItemReaderBuilder<Customer>()
                /**
                 * 아래 주석은 delimited 예시 샘플 코드
                 **/
//                .name("flatFile")
//                .resource(new ClassPathResource("/customer.csv"))
//                .fieldSetMapper(new CustomerFieldSetMapper())
//                .linesToSkip(1)
//                .delimited().delimiter(",").names("name", "age", "year")
//                .build();

                /**
                 * 아래 예시는 fixedLengthTokenizer 샘플 코드(문자열의 길이 단위로 파싱)
                 **/
                .name("flatFile")
                .resource(new ClassPathResource("/customer.txt"))
                .fieldSetMapper(new BeanWrapperFieldSetMapper<>())
                .targetType(Customer.class)
                .linesToSkip(1)
                .fixedLength()
                .addColumns(new Range(1, 5))
                .addColumns(new Range(6, 9))
                .addColumns(new Range(10, 11))
                .names("name", "year", "age")
                .build();
    }

    @Bean
    public Step step2() {
        return stepBuilderFactory.get("step2")
                .tasklet(new Tasklet() {
                    @Override
                    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
                        System.out.println("step2 executed");
                        return RepeatStatus.FINISHED;
                    }
                })
                .build();
    }
}