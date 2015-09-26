DROP DATABASE IF EXISTS das CASCADE;
CREATE DATABASE das;

USE das;

CREATE EXTERNAL TABLE visited_products(
    TIME string,
    USER_ID bigint,
    USER_FIRST_NAME string,
    USER_LAST_NAME string,
    PRODUCT_CATEGORY string,
    PRODUCT_SUB_CATEGORY string,
    PRODUCT_NAME string,
    PRODUCT_PRICE float,
    AD_CLICK string
)
PARTITIONED BY (
    date string
)
ROW FORMAT DELIMITED FIELDS TERMINATED BY '\t'
STORED AS TEXTFILE
LOCATION "/data/visited_products/";

CREATE EXTERNAL TABLE bought_products(
    TIME string,
    USER_ID bigint,
    USER_FIRST_NAME string,
    USER_LAST_NAME string,
    PRODUCT_CATEGORY string,
    PRODUCT_SUB_CATEGORY string,
    PRODUCT_NAME string,
    PRODUCT_PRICE float,
    PAYMENT_TYPE string,
    DELIVERY_TYPE string
)
PARTITIONED BY (
    date string
)
ROW FORMAT DELIMITED FIELDS TERMINATED BY '\t'
STORED AS TEXTFILE
LOCATION "/data/bought_products/";
