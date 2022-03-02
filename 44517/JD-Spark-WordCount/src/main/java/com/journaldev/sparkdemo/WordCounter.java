package com.journaldev.sparkdemo;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

import java.util.Arrays;
/**
 * Hello world!
 *
 */
public class WordCounter 
{

    private static void wordCount(String fileName) {
        SparkConf sparkConf = new SparkConf().setMaster("local").setAppName("JD Word Counter");
        JavaSparkContext sc = new JavaSparkContext(sparkConf);

        JavaRDD<String> inputFile = sc.textFile(fileName);

        JavaRDD<String> wordsFromFile = inputFile.flatMap(content -> Arrays.asList(content.split(" ")));

        JavaPairRDD countData = wordsFromFile.mapToPair(t -> new Tuple2(t, 1)).reduceByKey((x, y) -> (int) x + (int) y);

        countData.saveAsTextFile("01Output");
    }
    public static void main( String[] args )
    {
        if (args.length == 0) {
        System.out.println("No files provided.");
        System.exit(0);
        }
        wordCount(args[0]);
    }
}
