package com.learningspark.wordsplit;

/**
 * split words given file
 */

import java.util.Arrays;
import java.util.List;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;

public class WordSplit 
{
	public static void main(String []args)
	{
		SparkConf conf = new SparkConf().setAppName("WordSplit");
		JavaSparkContext sc = new JavaSparkContext(conf);
    
		JavaRDD<String> input = sc.textFile(args[0]);
		JavaRDD<String> words = input.flatMap
		(new FlatMapFunction<String, String>() 
			{
				private static final long serialVersionUID = -8448174767887630134L;

				public Iterable<String> call (String line)
				{
					return Arrays.asList(line.split(" "));
				}
			}
		);
		
		words.saveAsTextFile(args[1]);
		
		List<String> top5words = words.take(5);
		top5words.forEach((String s) -> System.out.print(s));
		
		sc.close();
	}
}
