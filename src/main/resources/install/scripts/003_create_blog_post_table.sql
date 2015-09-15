use Bloglr;

CREATE TABLE blog_post
(
	id INT PRIMARY KEY AUTO_INCREMENT,
	created_date TIMESTAMP,
	title VARCHAR(100),
	content TEXT,
	author INT,
	FOREIGN KEY (author) REFERENCES blog_user (user_id)
);