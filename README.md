## How to run
* Package a JAR containing your application
mvn package

* Use spark-submit to run your application
park-submit --class "org.intel.dcg.leslie.SimpleApp" --master local[4] target/simple-project-1.0.jar

--class 指定jar包入口的class类
--master local[4] 运行在本地的4线程
