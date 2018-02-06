INSERT INTO users (email, password, name)
	VALUES ('apple@koitt.com', '1111', '김사과');
	
SELECT * FROM users ORDER BY no DESC;

INSERT INTO board(title, content, user_no, regdate) 
	VALUES ('사과-1', '사과내용-1', 7, CURDATE());

	SELECT * FROM board;
	
	SELECT