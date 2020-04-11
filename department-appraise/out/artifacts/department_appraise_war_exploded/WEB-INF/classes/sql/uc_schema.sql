drop database if exists uchung_test;
drop user if exists 'uchung'@'%';
-- 支持emoji：需要mysql数据库参数： character_set_server=utf8mb4
create database uchung_test default character set utf8mb4 collate utf8mb4_unicode_ci;
use uchung_test;
create user 'uchung'@'%' identified by 'test1234';
grant all privileges on uchung_test.* to 'uchung'@'%';
flush privileges;
