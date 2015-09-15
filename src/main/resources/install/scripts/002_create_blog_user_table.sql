use Bloglr;

CREATE TABLE blog_user (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(32),
    password VARCHAR(8), -- we shouldn't be using raw password (should be encrypted!)
    email VARCHAR(32) 
);