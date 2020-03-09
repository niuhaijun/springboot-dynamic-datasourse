DROP DATABASE IF EXISTS springboot_dynamic_datasourse_master;
CREATE DATABASE springboot_dynamic_datasourse_master;
CREATE TABLE springboot_dynamic_datasourse_master.product(
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(50) NOT NULL,
  price DOUBLE(10,2) NOT NULL DEFAULT 0
);
INSERT INTO springboot_dynamic_datasourse_master.product (name, price) VALUES('master', '1');


DROP DATABASE IF EXISTS springboot_dynamic_datasourse_slave_alpha;
CREATE DATABASE springboot_dynamic_datasourse_slave_alpha;
CREATE TABLE springboot_dynamic_datasourse_slave_alpha.product(
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(50) NOT NULL,
  price DOUBLE(10,2) NOT NULL DEFAULT 0
);
INSERT INTO springboot_dynamic_datasourse_slave_alpha.product (name, price) VALUES('slaveAlpha', '1');


DROP DATABASE IF EXISTS springboot_dynamic_datasourse_slave_beta;
CREATE DATABASE springboot_dynamic_datasourse_slave_beta;
CREATE TABLE springboot_dynamic_datasourse_slave_beta.product(
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(50) NOT NULL,
  price DOUBLE(10,2) NOT NULL DEFAULT 0
);
INSERT INTO springboot_dynamic_datasourse_slave_beta.product (name, price) VALUES('slaveBeta', '1');


DROP DATABASE IF EXISTS springboot_dynamic_datasourse_slave_gamma;
CREATE DATABASE springboot_dynamic_datasourse_slave_gamma;
CREATE TABLE springboot_dynamic_datasourse_slave_gamma.product(
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(50) NOT NULL,
  price DOUBLE(10,2) NOT NULL DEFAULT 0
);
INSERT INTO springboot_dynamic_datasourse_slave_gamma.product (name, price) VALUES('slaveGamma', '1');