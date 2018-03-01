package org.intel.dcg.leslie;
/* SimpleApp.java */
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.Dataset;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.SparkConf;
import java.util.*;
public class SimpleApp {
  public static void main(String[] args) {
    //String logFile = "/home/automation/spark/spark-2.2.1-bin-hadoop2.7/README.md"; // Should be some file on your system
    //SparkSession spark = SparkSession.builder().appName("Simple Application").getOrCreate();
    //Dataset<String> logData = spark.read().textFile(logFile).cache();
    //long numAs = logData.filter(s -> s.contains("a")).count();
    //long numBs = logData.filter(s -> s.contains("b")).count();
   // System.out.println("Lines with a: " + numAs + ", lines with b: " + numBs);
   //
   // spark.stop();
   String master = "spark://headnode:7077";
   String appName = "SimpleApp";
   //SparkConf conf = new SparkConf().setAppName(appName).setMaster(master);
   
   SparkConf conf = new SparkConf().setAppName(appName);
   JavaSparkContext sc = new JavaSparkContext(conf);
   
   List<Integer> data = Arrays.asList(1, 2, 3, 4, 5);
   JavaRDD<Integer> distData = sc.parallelize(data);
   System.out.println(distData.map(a -> a+1).reduce((a, b) -> a + b));
   JavaRDD<String> distFile = sc.textFile("/home/lf/spark/spark-2.2.1-bin-hadoop2.7/README.md");
   System.out.println(distFile.count());
   
 }
}
