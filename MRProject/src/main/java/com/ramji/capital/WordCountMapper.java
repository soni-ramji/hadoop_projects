/**
 * 
 */
package com.ramji.capital;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

/**
 * @author HP
 *
 */
public class WordCountMapper extends MapReduceBase
		implements org.apache.hadoop.mapred.Mapper<Object, Text, Text, IntWritable> {

	private final IntWritable ONE = new IntWritable(1);
	private Text word = new Text();

	@Override
	public void map(Object key, Text value, OutputCollector<Text, IntWritable> output, Reporter arg3)
			throws IOException {
		String line = value.toString();
		StringTokenizer tokenizer = new StringTokenizer(line);
		while (tokenizer.hasMoreTokens()) {
			word.set(tokenizer.nextToken());
			output.collect(word, ONE);

		}

		/*
		 * @Override protected void map(Object key, Text value, Mapper<Object, Text,
		 * Text, IntWritable>.Context context) throws IOException, InterruptedException
		 * { // TODO Auto-generated method stub //super.map(key, value, context);
		 * 
		 * String[] splitVal = value.toString().split(",");
		 * 
		 * for(String str : splitVal) { word.set(str); context.write(word, ONE); } }
		 */

	}
}
