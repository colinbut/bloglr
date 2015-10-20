create table blog_post (id integer not null auto_increment, content TEXT, title varchar(100), created_date datetime, author integer, primary key (id)) ENGINE=InnoDB
create table blog_post_comment (id integer not null auto_increment, comment TEXT not null, comment_created_date datetime, blog_post_id integer not null, primary key (id)) ENGINE=InnoDB
create table blog_user (user_id integer not null auto_increment, email varchar(32), name varchar(32), password varchar(8), primary key (user_id)) ENGINE=InnoDB
alter table blog_post add constraint FK_j2ja9fay2s64j3ksoyks990os foreign key (author) references blog_user (user_id)
alter table blog_post_comment add constraint FK_jb0hteqmwc2urd1alsmldmnrj foreign key (blog_post_id) references blog_post (id)
