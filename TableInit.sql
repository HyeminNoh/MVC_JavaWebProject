
CREATE TABLE dogclient(
	username VARCHAR(20) NOT NULL,
    id VARCHAR(20) NOT NULL,
    password VARCHAR(20) NOT NULL,
    dogname VARCHAR(20) NOT NULL,
    dogage INT NOT NULL,
    dogsex CHAR(5) NOT NULL,
    dogtype VARCHAR(20) NOT NULL
);

CREATE TABLE chatcont(
    id VARCHAR(20) NOT NULL,
    date VARCHAR(20) NOT NULL,
    content VARCHAR(80) NOT NULL
);

create table boardcont(
index_no INT auto_increment,
id VARCHAR(20) NOT NULL,
title varchar(30) not null,
content varchar(100) not null,
imagefile varchar(200) not null,
primary key(index_no)
);

create table noticecont(
index_no INT auto_increment,
id VARCHAR(20) NOT NULL,
title varchar(30) not null,
content varchar(200) not null,
date varchar(20) not null,
primary key(index_no)
);

insert dogclient values('노혜민', 'hyemin', 'n0103', '두부', 6, '남', '말티즈' );
insert dogclient values('김경섭', 'kyungsub', 'n1012', '김치', 1, '여', '말티즈' );
insert dogclient values('주혜원', 'hyewon', 'j1130', '고구마', 1, '남', '요크셔테리어');
select*from dogclient;

insert into noticecont(id,title,content,date)values('admin','필독바랍니다.','게시글쓰기, 방명록쓰기 기능은 회원가입 후에만 이용이 가능하오니 유의 바랍니다.','2018-11-26');
select*from noticecont; 

insert into boardcont(id,title,content,imagefile)values('nohmin97', '우리두부♡', '두부너무귀여워눈물날거같다~', 'FileUpload/tufu.jpg');
select*from boardcont;

insert into chatcont values('hyemin', '2018/11/28', '두부짱');
select*from chatcont;

