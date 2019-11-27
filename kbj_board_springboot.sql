-- DB 초기화 Root 계정으로 실행
drop user kbj_springboot_board;
drop schema kbj_springboot_board_database;

create user kbj_springboot_board identified by 'kbj_springboot_board';
create schema kbj_springboot_board_database;
grant all privileges on kbj_springboot_board_database.* to kbj_springboot_board;


-- 여기부터는 kbj_springboot_board 계정으로 실행
CREATE TABLE Boards (
	boardId INT NOT NULL AUTO_INCREMENT,
	boardTitle VARCHAR(255) ,
	boardContent text,
    boardWriteTime datetime,
    boardWriter VARCHAR(255),
	PRIMARY KEY (boardId)
);
drop table Boards;
select * from baords;


CREATE TABLE Files (
	fileId INT NOT NULL AUTO_INCREMENT,
	originalFileName text,
	savedFileName text,
	boardId int,
	PRIMARY KEY (fileId)
);

select * from files;