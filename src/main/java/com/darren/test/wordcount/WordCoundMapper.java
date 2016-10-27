package com.darren.test.wordcount;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.log4j.Logger;


public class WordCoundMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
    private static final Logger LOG = Logger.getLogger(WordCoundMapper.class);

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        Text word = new Text();
        IntWritable one = new IntWritable(1);
        String line = value.toString();
        StringTokenizer token = new StringTokenizer(line);
        while (token.hasMoreTokens()) {
            LOG.info("token.nextToken() = " + token.nextToken());
            word.set(token.nextToken());
            context.write(word, one);
        }

    }

}
