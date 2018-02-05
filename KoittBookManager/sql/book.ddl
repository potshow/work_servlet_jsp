CREATE TABLE book(
		isbn                          		INT(10)		 NOT NULL		 PRIMARY KEY AUTO_INCREMENT,
		title                         		VARCHAR(30)		 NOT NULL,
		author                        		VARCHAR(30)		 NOT NULL,
		publisher                     		VARCHAR(30)		 NOT NULL,
		price                         		INT(10)		 NOT NULL,
		description                   		VARCHAR(30)		 NULL 
);

