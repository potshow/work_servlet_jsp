
CREATE DATABASE bookmgr;

DROP DATABASE database;

show dataBASES;

USE bookmgr;

CREATE TABLE Book (
	isbn		INT			NOT NULL	AUTO_INCREMENT,
	title		VARCHAR(30)	NOT NULL,
	author		VARCHAR(30) NOT NULL,
	publisher	VARCHAR(30) NOT NULL,
	price		INT			NOT NULL,
	description	VARCHAR(30),
	PRIMARY KEY	(isbn)
);

show tables;

INSERT INTO book (title, author, publisher, price)
	VALUES ('제목 테스트 1', '작가 테스트 1', '출판사 테스트 1', 1234);
	
INSERT INTO book (title, author, publisher, price, description)
	VALUES ('제목 테스트 2', '작가 테스트 2', '출판사 테스트 2', 5678, '주석 테스트 1');
	
	SELECT * FROM book;