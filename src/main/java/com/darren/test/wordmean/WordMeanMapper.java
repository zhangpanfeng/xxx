package com.darren.test.wordmean;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.log4j.Logger;

public class WordMeanMapper extends Mapper<Object, Text, Text, LongWritable> {
    private static final Logger LOG = Logger.getLogger(WordMeanMapper.class);
    private LongWritable wordLen = new LongWritable();
    private static final Text COUNT = new Text("count");
    private static final Text LENGTH = new Text("length");
    private static final LongWritable ONE = new LongWritable(1L);

    @Override
    protected void map(Object key, Text value, Context context) throws IOException, InterruptedException {
        StringTokenizer itr = new StringTokenizer(value.toString());
        while (itr.hasMoreTokens()) {
            String string = itr.nextToken();
            this.wordLen.set(string.length());
            context.write(WordMeanMapper.LENGTH, this.wordLen);
            context.write(WordMeanMapper.COUNT, WordMeanMapper.ONE);
        }
    }

}
