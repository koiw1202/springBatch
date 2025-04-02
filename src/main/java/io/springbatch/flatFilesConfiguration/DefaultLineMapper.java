package io.springbatch.flatFilesConfiguration;

import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.LineTokenizer;

public class DefaultLineMapper<T> implements LineMapper {

    private LineTokenizer tokenizer;
    private FieldSetMapper<T> fieldSetMapper;

    @Override
    public T mapLine(String s, int i) throws Exception {
        return fieldSetMapper.mapFieldSet(tokenizer.tokenize(s));
    }

    public void setLineTokenizer(LineTokenizer lineTokenizer) {
        this.tokenizer = lineTokenizer;
    }

    public void setFieldSetMapper(FieldSetMapper<T> fieldSetMapper) {
        this.fieldSetMapper = fieldSetMapper;
    }

}