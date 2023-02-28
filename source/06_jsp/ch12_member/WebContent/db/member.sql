-- TABLE DROP & CREATE;
DROP TABLE MEMBER CASCADE CONSTRAINTS; -- 강제 삭제해버리기

CREATE TABLE MEMBER (
    ID VARCHAR2(30) PRIMARY KEY,
    PW VARCHAR2(30) NOT NULL,
    NAME VARCHAR2(30) NOT NULL,
    PHONE1 VARCHAR2(5),
    PHONE2 VARCHAR2(5),
    PHONE3 VARCHAR2(5),
    GENDER VARCHAR2(1),
    EMAIL VARCHAR2(30),
    BIRTH DATE,
    ADDRESS VARCHAR2(200),
    RDATE DATE NOT NULL -- 가입일
);
SELECT * FROM MEMBER;

-- 1. 회원가입시 ID 중복체크 : public int confirmId (String id)
SELECT * FROM MEMBER WHERE ID='aaa';

-- 2. 회원가입 : public int joinMember (MemberDto dto)
INSERT INTO MEMBER (ID, PW, NAME, PHONE1, PHONE2, PHONE3, GENDER, EMAIL, BIRTH, ADDRESS, RDATE)
    VALUES 
    ('zzz', '111', '강길동', '02', '777', '9999', 'm', 'hong@hong.com', '1995-12-12', '서울', SYSDATE);
    
-- 3. 로그인 : public int loginCheck (String id, String pw)
SELECT ID,PW FROM MEMBER WHERE ID = 'zzz';

-- 4. ID로 dto 가져오기 : 로그인 성공시 session에 setAttribute / 회원정보 수정시 회원정보 가져오기
--  : public MemberDto getMember (String id)
SELECT * FROM MEMBER WHERE ID = 'zzz';

-- 5. 회원정보 수정 : public int modifyMember (MemberDto dto)
UPDATE MEMBER SET 
        PW = '111', NAME = '강길순', PHONE1 = '031', PHONE2 = '777', PHONE3 = '1234', 
        GENDER = 'f', EMAIL = 'kang@kang.com', BIRTH = '1995-12-12', ADDRESS = '서울시 강서'
    WHERE ID = 'zzz';

SELECT * FROM MEMBER;
COMMIT;

delete from member 
where id = 'bbb';









