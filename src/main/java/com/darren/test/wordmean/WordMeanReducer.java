package com.darren.test.wordmean;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class WordMeanReducer extends Reducer<Text, LongWritable, Text, LongWritable> {
    private LongWritable sum = new LongWritable();
    @Override
    protected void reduce(Text key, Iterable<LongWritable> values,
            Context context) throws IOException, InterruptedException {

        int theSum = 0;
        for (LongWritable val : values) {
            theSum = (int) (theSum + val.get());
        }
        this.sum.set(theSum);
        context.write(key, this.sum);
    }

    
}
