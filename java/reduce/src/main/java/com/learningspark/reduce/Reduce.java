package com.learningspark.reduce;

import java.util.Arrays;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function2;

/**
 * reduce operation on given data set
 */
public class Reduce 
{
    public static void main( String[] args )
    {
    	SparkConf conf = new SparkConf().setAppName("Distinct");
		JavaSparkContext sc = new JavaSparkContext(conf);
		
		JavaRDD<Integer> nums = sc.parallelize(Arrays.asList(1,2,3,4,5,1,3,2,2,1,3,4,5,5,4,3,1,2,3,2,6,8));
		long res = nums.reduce(new Function2<Integer, Integer, Integer>() 
		{	
			public Integer call(Integer x, Integer y) throws Exception 
			{
				return x + y;
			}
		});
		
		System.out.println("Reduce by sum result : " + res);
		
		sc.close();
    }
}
