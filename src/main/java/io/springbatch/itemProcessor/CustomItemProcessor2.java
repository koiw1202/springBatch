package io.springbatch.itemProcessor;


import org.springframework.batch.item.ItemProcessor;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-04-02        koiw1       최초 생성
 */
public class CustomItemProcessor2 implements ItemProcessor<String, String> {

    int cnt=0;

    @Override
    public String process(String item) throws Exception {
        cnt++;

        return (item + cnt).toLowerCase();
    }
}
