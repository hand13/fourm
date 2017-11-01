create table t_board
(
  board_id int auto_increment
    primary key,
  board_name varchar(150) not null,
  board_desc varchar(250) null,
  topic_num int not null
)
;

create table t_log
(
  login_log_id int auto_increment
    primary key,
  user_id int not null,
  ip varchar(30) null,
  message varchar(100) null,
  time datetime null
)
;

create table t_manage
(
  manage_id int auto_increment
    primary key,
  board_id int not null,
  user_name varchar(30) default '' not null
)
;

create table t_post
(
  post_id int auto_increment
    primary key,
  user_id int not null,
  board_id int not null,
  topic_id int not null,
  post_type tinyint not null,
  post_title varchar(100) not null,
  post_context text not null,
  create_time datetime null
)
;

create table t_resource
(
  resource_id int auto_increment
    primary key
)
;

create table t_role
(
  role_id int auto_increment
    primary key,
  role varchar(30) not null,
  des varchar(100) not null,
  available tinyint(1) not null,
  resource_ids varchar(100) null
)
;

create table t_topic
(
  topic_id int auto_increment
    primary key,
  board_id int not null,
  topic_title varchar(100) not null,
  user_id int not null,
  create_time datetime not null,
  last_post datetime not null,
  topic_views int not null,
  topic_replics int not null,
  digest varchar(100) not null
)
;

create table t_user
(
  user_id int auto_increment
    primary key,
  user_name varchar(30) not null,
  password varchar(100) not null,
  salt varchar(100) not null,
  role_ids varchar(50) default '' not null,
  locked tinyint default '0' not null,
  credits int default '0' null,
  topics int default '0' null
)
;

