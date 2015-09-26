USE das;

CREATE TABLE ${hiveconf:RESULT_TABLE} AS
SELECT category, sub_category, name
FROM (
    SELECT
        category,
        sub_category,
        name,
        RANK() OVER (
            PARTITION BY category, sub_category ORDER BY views DESC
        ) as rank
    FROM (
        SELECT
            PRODUCT_CATEGORY as category,
            PRODUCT_SUB_CATEGORY as sub_category,
            PRODUCT_NAME as name,
            SUM(1) as views
        FROM
            visited_products vp
        WHERE
            vp.date >= ${hiveconf:START_DATE}
        GROUP BY PRODUCT_CATEGORY, PRODUCT_SUB_CATEGORY, PRODUCT_NAME
    ) a
) b
WHERE b.rank < 2;
