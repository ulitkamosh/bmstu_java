import org.apache.spark.sql.SparkSession
import org.apache.spark.{SparkConf, SparkContext}

val conf = new SparkConf().setAppName("LR10")
val sc = new SparkContext(conf);
val spark = SparkSession.builder.appName("LR10").getOrCreate()
val datafile = spark.read.format("com.databricks.spark.csv").option("header", true).load("russian_air_service_CARGO_AND_PARCELS.csv")

datafile.createOrReplaceTempView("air_service")



// Все данные
spark.sql("select * from air_service").show()

spark.sql("select * from air_service where Year = '2019'").show

spark.sql("select * from air_service where Year = '2015'").show

spark.sql("select * from air_service where Year = '2010'").show

spark.sql("select * from air_service where Airport_name = 'Belgorod'").show

spark.sql("select Airport_name, Year, January from air_service order by January desc").show

spark.sql("select Airport_name, Year, January from air_service order by February desc").show

spark.sql("select Airport_name, Year, January from air_service order by May desc").show

spark.sql("select Airport_name, Year, January from air_service where Year = '2014' order by May desc").show

spark.sql("select Airport_name, Year, January from air_service where Year = '2016' order by September desc").show
