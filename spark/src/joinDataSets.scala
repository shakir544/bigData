
/**
 * Join Data sets 
 * 1. Employee Name (ID, NAME)
 * 2. Employee Salary (NAME,SALARY)
 * 3. Employee Manager(ID,SALARY)
 * Using spark API and generate a joined output (shown below) , save its as text file comma sperated
 * ID, NAME, SALARY, MANAGER_NAME
 */

import org.apache.spark._

object joinDataSets { 
  
  def main(args : Array[String]){ 
    
    if(args.length !=4) { 
      System.err.println("Usage: joinDataSets <file1> <file2> <file3> <outputPath>")
      System.exit(1)
    }
    
     val sparkConf = new SparkConf().setAppName("JoinDataSets")
     
     val sc = new SparkContext(sparkConf)
    
    // Load Employee Name file 
    val employee = sc.textFile(args(0))

    // Load Employee Salary File 
    val salary = sc.textFile(args(1))
    
    // Load Employe Manager File 
    val manager = sc.textFile(args(2))
    
    // Split the files with delimiter comman 
    val employeeRDD = employee.map(x => (x.split(",")(0), x.split(",")(1)))
    
    // Split the files with delimiter comman 
    val salaryRDD = salary.map(x => (x.split(",")(0), x.split(",")(1)))
    
    // Split the files with delimiter comman 
    val managerRDD = manager.map(x => (x.split(",")(0), x.split(",")(1)))
    
    // Join the above three data sets 
    val mergeDataSet = employeeRDD.join(salaryRDD).join(managerRDD)
    
    // Sort by Key 
    val sortedDataSet = mergeDataSet.sortByKey()
    
    // Generate Comma sperated data set 
   
    val commaSperatedDataSet = sortedDataSet.map(v => (v._1, v._2._1._1, v._2._1._2, v._2._2))
    
    // Save the output in HDFS 
    
    commaSperatedDataSet.saveAsTextFile(args(4))

   
  }
}