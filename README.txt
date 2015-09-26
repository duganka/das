Prerequisites:
- CDH 5.4.7
- Maven 3
- JDK 1.7

To build entire distribution:
- cd Code
- mvn package
- tar.gz will be in Code/distribution/target/distribution-1.0-SNAPSHOT-assembly.tar.gz

HDFS setup:
- execute Deployment/create-output-dir.sh

Kafka topics setup:
- add Kafka service in Cloudera Manager
- execute Deployment/create-kafka-topics.sh

Hive tables setup:
- execute Deployment/create-hive-tables.sh

MySQL tables setup:
- execute Deployment/create-mysql-tables.sh

Start flume agents:
- execute Deployment/flume/start-bought-products-agent.sh
- execute Deployment/flume/start-visited-products-agent.sh
I'd recommend to run these scripts in separate windows of terminal multiplexer like screen or tmux.

Start sample events generator:
- execute java -jar Deployment/events-generator-1.0-SNAPSHOT.jar kafka-broker-host:9092

Run reports:
- execute Deployment/reports/bin/run-reports-for-last-day.sh
- execute Deployment/reports/bin/run-reports-for-last-week.sh

Check reports in MySQL:
- select * from last_day_top_views;
- select * from last_day_top_sales;
- select * from last_week_top_views;
- select * from last_week_top_sales;
