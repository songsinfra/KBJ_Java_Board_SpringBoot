-- DB 초기화 Root 계정으로 실행
drop user kbj_springboot_board;
drop schema kbj_springboot_board_database;

create user kbj_springboot_board identified by 'kbj_springboot_board';
create schema kbj_springboot_board_database;
grant all privileges on kbj_springboot_board_database.* to kbj_springboot_board;


-- 여기부터는 kbj_springboot_board 계정으로 실행
CREATE TABLE Products (
	productId INT NOT NULL AUTO_INCREMENT,
	productName VARCHAR(255) ,
	productPrice float(10,2),
	productGuide text,
	productQuantity INT,
    productImageSrc VARCHAR(255),
	PRIMARY KEY (productId)
);