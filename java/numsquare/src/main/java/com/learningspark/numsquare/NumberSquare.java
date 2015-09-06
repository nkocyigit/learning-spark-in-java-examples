package com.learningspark.numsquare;

import java.util.Arrays;

import org.apache.commons.lang.StringUtils;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;

/**
 * square given numbers
 *
 */
public class NumberSquare 
{
    public static void main( String[] args )
    {
    	SparkConf conf = new SparkConf().setAppName("NumberSquare");
		JavaSparkContext sc = new JavaSparkContext(conf);
		
		JavaRDD<Integer> nums = sc.parallelize(Arrays.asList(1,2,3,4,5));
		JavaRDD<Integer> squares = nums.map(new Function<Integer, Integer>() 
		{
			private static final long serialVersionUID = -2433958790742937700L;

			public Integer call(Integer x) throws Exception 
			{
				return x * x;
			}
		});
		
		System.out.println(StringUtils.join(squares.collect(), ","));
		
		sc.close();
    }
}
