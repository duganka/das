Prerequisites:
- CDH 5.4.7
- Maven 3
- JDK 1.7

To build entire distribution:
- cd Code
- mvn package
- tar.gz will be in Code/distribution/target/distribution-1.0-SNAPSHOT-assembly.tar.gz

HDFS setup:
- sudo to hdfs user
- execute Deployment/deployment/create-output-dir.sh

Kafka topics setup:
- add Kafka service in Cloudera Manager
- execute Deployment/deployment/create-kafka-topics.sh

Hive tables setup:
- execute Deployment/deployment/create-hive-tables.sh

MySQL tables setup:
- execute Deployment/deployment/create-mysql-tables.sh

Start flume agents:
- execute Deployment/deployment/flume/start-bought-products-agent.sh
- execute Deployment/deployment/flume/start-visited-products-agent.sh
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

Please note that my Wink project exceeded max size, so I'm attaching generated .exe file.
