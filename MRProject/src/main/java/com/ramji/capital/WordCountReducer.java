/**
 * 
 */
package com.ramji.capital;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

/**
 * @author HP
 *
 */
public class WordCountReducer extends MapReduceBase implements Reducer<Text, IntWritable, Text, IntWritable>{
	int sum = 0;
	/*protected void reduce(Text key, Iterable<IntWritable> values,
			Reducer<Text, IntWritable, Text, IntWritable>.Context arg2) throws IOException, InterruptedException {
		for(IntWritable wr : values) {
			sum = sum + wr.get();
		}
		arg2.write(key, new IntWritable(sum));
	}*/

	@Override
	public void reduce(Text key, Iterator<IntWritable> values, OutputCollector<Text, IntWritable> output, Reporter arg3)
			throws IOException {
		int sum = 0;
        while (values.hasNext()) {
                       sum += values.next().get();
        }
        output.collect(key, new IntWritable(sum));
		
	}
}
