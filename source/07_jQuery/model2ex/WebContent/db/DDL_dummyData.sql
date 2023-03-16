------------------------------------------------
------------------- MVC_MEMBER -----------------
------------------------------------------------
DROP TABLE MVC_MEMBER CASCADE CONSTRAINTS;
CREATE TABLE MVC_MEMBER(
    mID VARCHAR2(30) PRIMARY KEY,
    mPW VARCHAR2(30) NOT NULL,
    mNAME VARCHAR2(30) NOT NULL,
    mEMAIL VARCHAR2(30) UNIQUE,
    mPHOTO VARCHAR2(30) NOT NULL, -- 회원가입시 사진업로드를 안 할시 기본 이미지로(NOIMG.JPG)
    mBIRTH DATE,
    mADDRESS VARCHAR2(300),
    mRDATE DATE DEFAULT SYSDATE NOT NULL    
);
-- DUMMY DATA
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('gayun','1','김가연','gayun@naver.com','gayun.jpg','1972/09/09','광주광역시');
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('gico','1','지코','gico@naver.com','gico.jpg','1992/09/14','서울시');
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('go','1','고소영','go@naver.com','go.jpg','1972/10/06','서울시');
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('ham','1','함소원','ham@naver.com','ham.jpg','1976/06/16','서울시');
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('han','1','한지민','han@naver.com','han.jpg','1982/11/05','서울시');
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('jang','1','장동건',null,'jang.jpg',null,null);
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('jo','1','조현우',null,'jo.jpg',null,null);
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('kang','1','강동원',null,'kang.jpg',null,null);
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('kim','1','김태희',null,'kim.jpg',null,null);
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('lee','1','이선빈',null,'lee.jpg',null,null);
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('lim','1','임요한',null,'lim.jpg',null,null);
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('park','1','박보검',null,'park.jpg',null,null);
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('rain','1','비',null,'rain.jpg',null,null);
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('sgy','1','송가연',null,'sgy.jpg',null,null);
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('son','1','손흥민',null,'son.jpg',null,null);
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('song','1','송중기',null,'song.jpg',null,null);
COMMIT;

SELECT * FROM MVC_MEMBER;

------------------------------------------------
------------------- FILEBOARD -----------------
------------------------------------------------

DROP TABLE FILEBOARD;
DROP SEQUENCE FILEBOARD_SEQ;

CREATE TABLE FILEBOARD(
    fID NUMBER(6) PRIMARY KEY, -- 글번호
    mID VARCHAR2(30),          -- 글쓴이 ID
    fTITLE VARCHAR2(100) NOT NULL, -- 글제목
    fCONTENT VARCHAR2(4000),       -- 글본문
    fFILENAME VARCHAR2(100), -- 첨부파일 이름
    fRDATE DATE DEFAULT SYSDATE NOT NULL, -- 작성일
    fHIT NUMBER(6) DEFAULT 0 NOT NULL, -- 조회수
    fGROUP NUMBER(6),   -- 글그룹
    fSTEP NUMBER(6),    -- 그룹 내 출력순서
    fINDENT NUMBER(6),  -- 들여쓰기 정도
    fIP VARCHAR2(30),   -- 글쓴이 IP
    FOREIGN KEY (mID) REFERENCES MVC_MEMBER (mID)
);

CREATE SEQUENCE FILEBOARD_SEQ MAXVALUE 999999 NOCACHE NOCYCLE;


-- DUMMY DATA (원글과 답변)
INSERT INTO FILEBOARD (FID, MID, FTITLE, FCONTENT, FFILENAME, FGROUP, FSTEP, FINDENT, FIP)
    VALUES (FILEBOARD_SEQ.NEXTVAL, 'aaa', '1번 글', '본문1', 'NOIMG.JPG', FILEBOARD_SEQ.CURRVAL, 0, 0, '192.1.1.1');
INSERT INTO FILEBOARD (FID, MID, FTITLE, FCONTENT, FFILENAME, FGROUP, FSTEP, FINDENT, FIP)
    VALUES (FILEBOARD_SEQ.NEXTVAL, 'bbb', '2번 글', '본문2', 'NOIMG.JPG', FILEBOARD_SEQ.CURRVAL, 0, 0, '192.2.2.2'); 
-- 2번글의 답글
INSERT INTO FILEBOARD (FID, MID, FTITLE, FCONTENT, FFILENAME, FGROUP, FSTEP, FINDENT, FIP)
    VALUES (FILEBOARD_SEQ.NEXTVAL, 'aaa', '답글', '답본문임', 'NOIMG.JPG', 2, 1, 1, '210.2.2');

SELECT * FROM FILEBOARD;

------------------------------------------------
------------------- ADMIN -----------------
------------------------------------------------
DROP TABLE ADMIN;
CREATE TABLE ADMIN(
    aID VARCHAR2(30) PRIMARY KEY,
    aPW VARCHAR2(30) NOT NULL,
    aNAME VARCHAR2(30) NOT NULL
);

INSERT INTO ADMIN VALUES ('admin', '1', '김관리');

SELECT * FROM ADMIN;
COMMIT;


















