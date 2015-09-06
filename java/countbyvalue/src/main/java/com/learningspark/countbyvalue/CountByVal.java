package com.learningspark.countbyvalue;

import java.util.Arrays;
import java.util.Map;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

/**
 * count by value on rdd
 */

public class CountByVal 
{
    public static void main( String[] args )
    {
    	SparkConf conf = new SparkConf().setAppName("NumberSquare");
		JavaSparkContext sc = new JavaSparkContext(conf);
		
		JavaRDD<Integer> nums = sc.parallelize(Arrays.asList(1,2,3,4,5,2,3,4,3,4,5,4,5,5,5,1,2,3,4,5));
		
		Map<Integer, Long> counts = nums.countByValue();
		for (Map.Entry<Integer, Long> keyVal : counts.entrySet()) 
		{
			System.out.println(keyVal.getKey() + " ---> " + keyVal.getValue());
		}
		
		sc.close();
    }
}