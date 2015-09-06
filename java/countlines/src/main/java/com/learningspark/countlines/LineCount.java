package com.learningspark.countlines;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

/**
 * count the lines of a given file
 */

public class LineCount 
{
    public static void main( String[] args )
    {
    	SparkConf conf = new SparkConf().setAppName("WordSplit");
		JavaSparkContext sc = new JavaSparkContext(conf);
    
		JavaRDD<String> input = sc.textFile(args[0]);

		System.out.println("line count of file : " + input.count());
		
		sc.close();
    }
}
