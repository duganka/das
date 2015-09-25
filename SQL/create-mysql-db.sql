CREATE DATABASE IF NOT EXISTS das;

USE das;

DROP TABLE IF EXISTS last_day_top_views;
CREATE TABLE last_day_top_views (
    category VARCHAR(32) NOT NULL,
    sub_category VARCHAR(32) NOT NULL,
    name VARCHAR(32) NOT NULL,
    PRIMARY KEY(category, sub_category)
);

DROP TABLE IF EXISTS last_week_top_views;
CREATE TABLE last_week_top_views (
    category VARCHAR(32) NOT NULL,
    sub_category VARCHAR(32) NOT NULL,
    name VARCHAR(32) NOT NULL,
    PRIMARY KEY(category, sub_category)
);

DROP TABLE IF EXISTS last_day_top_sales;
CREATE TABLE last_day_top_sales (
    category VARCHAR(32) NOT NULL,
    sub_category VARCHAR(32) NOT NULL,
    name VARCHAR(32) NOT NULL,
    PRIMARY KEY(category, sub_category)
);

DROP TABLE IF EXISTS last_week_top_sales;
CREATE TABLE last_week_top_sales (
    category VARCHAR(32) NOT NULL,
    sub_category VARCHAR(32) NOT NULL,
    name VARCHAR(32) NOT NULL,
    PRIMARY KEY(category, sub_category)
);
