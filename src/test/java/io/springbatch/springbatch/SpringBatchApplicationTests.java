package io.springbatch.springbatch;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.test.context.SpringBatchTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBatchTest
class SpringBatchApplicationTests {

    public TestBatchConfig testBatchConfig = new TestBatchConfig();

    @Test
    void batchTest() throws Exception {

        testBatchConfig.simeJobTest();

    }

}
