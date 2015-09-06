package com.learningspark.distinct;

import java.util.Arrays;

import org.apache.commons.lang.StringUtils;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

/**
 * distinct operation on the given value set
 */

public class Distinct 
{
    public static void main( String[] args )
    {
    	SparkConf conf = new SparkConf().setAppName("Distinct");
		JavaSparkContext sc = new JavaSparkContext(conf);
		
		JavaRDD<Integer> nums = sc.parallelize(Arrays.asList(1,2,3,4,5,1,3,2,2,1,3,4,5,5,4,3,1,2,3,2,6,8,0));
		JavaRDD<Integer> distinct = nums.distinct();
		
		System.out.println(StringUtils.join(distinct.collect(), ","));
		
		sc.close();
    }
}
