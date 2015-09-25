USE das;

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
            vp.YEAR = YEAR(FROM_UNIXTIME(UNIX_TIMESTAMP())) AND
            vp.MONTH = MONTH(FROM_UNIXTIME(UNIX_TIMESTAMP())) AND
            vp.DAY >= DAY(FROM_UNIXTIME(UNIX_TIMESTAMP())) - 1
        GROUP BY PRODUCT_CATEGORY, PRODUCT_SUB_CATEGORY, PRODUCT_NAME
    ) a
) b
WHERE b.rank < 2;
