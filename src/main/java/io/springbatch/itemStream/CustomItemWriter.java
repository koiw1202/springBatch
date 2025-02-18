package io.springbatch.itemStream;

import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.ItemStreamWriter;

import java.util.List;

public class CustomItemWriter implements ItemStreamWriter {

    @Override
    public void write(List items) throws Exception {
        items.forEach(System.out::println);
    }

    @Override
    public void open(ExecutionContext executionContext) throws ItemStreamException {
        System.out.println("oepn");
    }

    @Override
    public void update(ExecutionContext executionContext) throws ItemStreamException {
        System.out.println("update");
    }

    @Override
    public void close() throws ItemStreamException {
        System.out.println("close");
    }


}
