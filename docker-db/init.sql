drop DATABASE if exists recruitdb;
CREATE DATABASE recruitdb CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci;
use recruitdb;
DROP TABLE IF EXISTS TBL_BOARD, TBL_COMPANY, TBL_APPLICANT, TBL_APPLY;

CREATE TABLE TBL_BOARD
(bno INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
cid INT NOT NULL,
position TEXT NOT NULL,
content TEXT NULL,
regDate DATETIME NOT NULL DEFAULT NOW(),
updateDate DATETIME NULL);

CREATE TABLE TBL_COMPANY
(cid INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
cName CHAR(50) NOT NULL);

CREATE TABLE TBL_APPLICANT
(uid INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
uName CHAR(50) NOT NULL);

CREATE TABLE TBL_APPLY
(uid INT NOT NULL,
bno INT NOT NULL,
applyDate DATETIME NOT NULL DEFAULT NOW());

ALTER TABLE TBL_BOARD
	ADD CONSTRAINT FK_TBLCOMPANY_TBLBOARD
	FOREIGN KEY(cid)
	REFERENCES TBL_COMPANY(cid);

ALTER TABLE TBL_APPLY
	ADD CONSTRAINT FK_TBLAPPLICANT_TBLAPPLY
	FOREIGN KEY(uid)
	REFERENCES TBL_APPLICANT(uid);

ALTER TABLE TBL_APPLY
	ADD CONSTRAINT FK_TBLBOARD_TBLAPPLY
	FOREIGN KEY(bno)
	REFERENCES TBL_BOARD(bno);

ALTER TABLE TBL_APPLY
	ADD CONSTRAINT PK_TBLAPPLY_uid_bno
	PRIMARY KEY(uid, bno);