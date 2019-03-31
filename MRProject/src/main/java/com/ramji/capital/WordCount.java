package com.ramji.capital;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.TextInputFormat;
import org.apache.hadoop.mapred.TextOutputFormat;

/**
 * Hello world!
 *
 */
public class WordCount 
{
    public static void main( String[] args ) throws Exception
    {
    	try{
    	JobConf conf = new JobConf(WordCount.class);
		conf.setJobName("WordCount");

		conf.setOutputKeyClass(Text.class);
		conf.setOutputValueClass(IntWritable.class);

		conf.setMapperClass(WordCountMapper.class);
		//conf.setCombinerClass(Reduce.class);
		conf.setReducerClass(WordCountReducer.class);

		conf.setInputFormat(TextInputFormat.class);
		conf.setOutputFormat(TextOutputFormat.class);

		FileInputFormat.setInputPaths(conf, new Path("/ramji/normal.txt"));
		FileOutputFormat.setOutputPath(conf, new Path("/output/"));

		JobClient.runJob(conf);
    	}catch(Exception ex){
    		ex.printStackTrace();
    	}
    }

	
}
