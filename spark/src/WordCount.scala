
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

class WordCount {
  
  def main(args : Array[String]) { 
    
    // Parameters 
    // WordCount file
    
    if(args.length != 1) { 
      System.err.println("Usage: WordCount <InputFile>")
      System.exit(1)
    }
    
    val sparkConf = new SparkConf().setAppName("WordCount")
    val sc = new SparkContext(sparkConf)
    
    // Load the data from HDFS 
    val data = sc.textFile("/user/cloudera/work/wordcount.txt")
    
    // Flatten the data set
    val dataFlatMap = data.flatMap { x => x.split(" ") }
    
    
    val dataMap = dataFlatMap.map { x => (x,1) }
    
    // Aggregate the data (values) 
    val dataReduce = dataMap.reduceByKey((x,y) => x+y)
    
    // Print the word count 
    dataReduce.collect().foreach(println)
    
    
  }
  
}