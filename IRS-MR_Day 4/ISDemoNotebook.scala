// Databricks notebook source
//code is in scala %scala
dbutils.fs.put("/tmp/test.json", """
{"SepalLengthCm": 5.1, "SepalWidthCm": 3.5, "PetalLengthCm": 1.4, "PetalWidthCm": 0.2, "Species": "setosa"},
{"SepalLengthCm": 4.9, "SepalWidthCm": 3.0, "PetalLengthCm": 1.4, "PetalWidthCm": 0.2, "Species": "setosa"},
{"SepalLengthCm": 4.7, "SepalWidthCm": 3.2, "PetalLengthCm": 1.3, "PetalWidthCm": 0.2, "Species": "setosa"},
{"SepalLengthCm": 4.6, "SepalWidthCm": 3.1, "PetalLengthCm": 1.5, "PetalWidthCm": 0.2, "Species": "setosa"},
{"SepalLengthCm": 5.0, "SepalWidthCm": 3.6, "PetalLengthCm": 1.4, "PetalWidthCm": 0.2, "Species": "setosa"},
{"SepalLengthCm": 5.4, "SepalWidthCm": 3.9, "PetalLengthCm": 1.7, "PetalWidthCm": 0.4, "Species": "setosa"},
{"SepalLengthCm": 4.6, "SepalWidthCm": 3.4, "PetalLengthCm": 1.4, "PetalWidthCm": 0.3, "Species": "setosa"},
{"SepalLengthCm": 5.0, "SepalWidthCm": 3.4, "PetalLengthCm": 1.5, "PetalWidthCm": 0.2, "Species": "setosa"},
{"SepalLengthCm": 4.4, "SepalWidthCm": 2.9, "PetalLengthCm": 1.4, "PetalWidthCm": 0.2, "Species": "setosa"},
{"SepalLengthCm": 4.9, "SepalWidthCm": 3.1, "PetalLengthCm": 1.5, "PetalWidthCm": 0.1, "Species": "setosa"},
{"SepalLengthCm": 5.4, "SepalWidthCm": 3.7, "PetalLengthCm": 1.5, "PetalWidthCm": 0.2, "Species": "setosa"},
{"SepalLengthCm": 4.8, "SepalWidthCm": 3.4, "PetalLengthCm": 1.6, "PetalWidthCm": 0.2, "Species": "setosa"},
{"SepalLengthCm": 4.8, "SepalWidthCm": 3.0, "PetalLengthCm": 1.4, "PetalWidthCm": 0.1, "Species": "setosa"},
{"SepalLengthCm": 4.3, "SepalWidthCm": 3.0, "PetalLengthCm": 1.1, "PetalWidthCm": 0.1, "Species": "setosa"},
{"SepalLengthCm": 5.8, "SepalWidthCm": 4.0, "PetalLengthCm": 1.2, "PetalWidthCm": 0.2, "Species": "setosa"},
{"SepalLengthCm": 5.7, "SepalWidthCm": 4.4, "PetalLengthCm": 1.5, "PetalWidthCm": 0.4, "Species": "setosa"},
{"SepalLengthCm": 5.4, "SepalWidthCm": 3.9, "PetalLengthCm": 1.3, "PetalWidthCm": 0.4, "Species": "setosa"},
{"SepalLengthCm": 5.1, "SepalWidthCm": 3.5, "PetalLengthCm": 1.4, "PetalWidthCm": 0.3, "Species": "setosa"},
{"SepalLengthCm": 6.4, "SepalWidthCm": 2.8, "PetalLengthCm": 5.6, "PetalWidthCm": 2.2, "Species": "virginica"},
{"SepalLengthCm": 6.3, "SepalWidthCm": 2.8, "PetalLengthCm": 5.1, "PetalWidthCm": 1.5, "Species": "virginica"},
{"SepalLengthCm": 6.1, "SepalWidthCm": 2.6, "PetalLengthCm": 5.6, "PetalWidthCm": 1.4, "Species": "virginica"},
{"SepalLengthCm": 7.7, "SepalWidthCm": 3.0, "PetalLengthCm": 6.1, "PetalWidthCm": 2.3, "Species": "virginica"},
{"SepalLengthCm": 6.3, "SepalWidthCm": 3.4, "PetalLengthCm": 5.6, "PetalWidthCm": 2.4, "Species": "virginica"},
{"SepalLengthCm": 6.4, "SepalWidthCm": 3.1, "PetalLengthCm": 5.5, "PetalWidthCm": 1.8, "Species": "virginica"},
{"SepalLengthCm": 6.0, "SepalWidthCm": 3.0, "PetalLengthCm": 4.8, "PetalWidthCm": 1.8, "Species": "virginica"},
{"SepalLengthCm": 6.9, "SepalWidthCm": 3.1, "PetalLengthCm": 5.4, "PetalWidthCm": 2.1, "Species": "virginica"},
{"SepalLengthCm": 6.7, "SepalWidthCm": 3.1, "PetalLengthCm": 5.6, "PetalWidthCm": 2.4, "Species": "virginica"},
{"SepalLengthCm": 6.9, "SepalWidthCm": 3.1, "PetalLengthCm": 5.1, "PetalWidthCm": 2.3, "Species": "virginica"},
{"SepalLengthCm": 5.8, "SepalWidthCm": 2.7, "PetalLengthCm": 5.1, "PetalWidthCm": 1.9, "Species": "virginica"}
""", true)
// COMMAND ----------
val testJsonData = spark.read.json("/tmp/test.json")
display(testJsonData)

