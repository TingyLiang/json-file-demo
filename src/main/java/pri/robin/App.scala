import org.apache.spark.sql.SparkSession

object App {

  def main(args: Array[String]): Unit = {

    val spark = SparkSession
      .builder()
      .appName("Spark SQL basic example")
      .master("local")
//      .config("spark.some.config.option", "some-value")
      .getOrCreate()
    val users = spark.read.parquet("users.parquet")
    users.createOrReplaceTempView("temp")
    spark.sql("select name,favorite_color from temp").show(false)
  }
}