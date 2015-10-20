use Bloglr;

CREATE TABLE blog_post_comment
(
	id INT PRIMARY KEY AUTO_INCREMENT,
	comment TEXT,
	comment_created_date TIMESTAMP,
	blog_post_id INT,
	FOREIGN KEY (blog_post_id) REFERENCES blog_post (id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;