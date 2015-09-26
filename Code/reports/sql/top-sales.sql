USE das;

CREATE TABLE ${hiveconf:RESULT_TABLE}
    ROW FORMAT DELIMITED FIELDS TERMINATED BY '\t'
    STORED AS TEXTFILE
    AS
SELECT category, sub_category, name, sales
FROM (
    SELECT
        category,
        sub_category,
        name,
        sales,
        RANK() OVER (
            PARTITION BY category, sub_category ORDER BY sales DESC
        ) as rank
    FROM (
        SELECT
            PRODUCT_CATEGORY as category,
            PRODUCT_SUB_CATEGORY as sub_category,
            PRODUCT_NAME as name,
            SUM(1) as sales
        FROM
            bought_products vp
        WHERE
            vp.date >= '${hiveconf:START_DATE}'
        GROUP BY PRODUCT_CATEGORY, PRODUCT_SUB_CATEGORY, PRODUCT_NAME
    ) a
) b
WHERE b.rank < 2;
