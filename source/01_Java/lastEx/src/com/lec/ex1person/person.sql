-- 테이블 및 시퀀스 삭제
DROP TABLE Person;
DROP TABLE JOB;
DROP SEQUENCE PERSON_NO_SQ;

-- 테이블 및 시퀀스 생성
CREATE TABLE JOB (
    jNO NUMBER(2),
    jNAME VARCHAR2(50),
    PRIMARY KEY (jNO)
);
CREATE TABLE Person (
    pNO NUMBER(5),
    pNAME VARCHAR2(50) NOT NULL,
    jNO NUMBER(2),
    KOR NUMBER(3),
    ENG NUMBER(3),
    MAT NUMBER(3),
    CHECK (KOR>0), CHECK (ENG>0),CHECK (MAT>0),
    PRIMARY KEY (pNO),
    FOREIGN KEY (jNO) REFERENCES JOB (jNO)
);
CREATE SEQUENCE PERSON_NO_SQ
    START WITH 1
    MAXVALUE 999999
    NOCACHE
    NOCYCLE;

-- 더미데이터 insert
INSERT INTO JOB VALUES (10, '배우');
INSERT INTO JOB VALUES (20, '가수');
INSERT INTO JOB VALUES (30, '엠씨');
SELECT * FROM JOB;

INSERT INTO Person VALUES (PERSON_NO_SQ.NEXTVAL, '정우성', 10, 90, 80, 81);
INSERT INTO Person VALUES (PERSON_NO_SQ.NEXTVAL, '박세영', 10, 80, 90, 80);
INSERT INTO Person VALUES (PERSON_NO_SQ.NEXTVAL, '배수지', 20, 20, 90, 90);
INSERT INTO Person VALUES (PERSON_NO_SQ.NEXTVAL, '설현', 20, 95, 95, 95);
INSERT INTO Person VALUES (PERSON_NO_SQ.NEXTVAL, '송혜교', 10, 100, 100, 100);

SELECT * FROM Person;


-- 기능별 query 작성 (1, 2, 3)
-- 1번 : 이름, 직업명, 국어,영어,수학점수를 입력 받아 데이터베이스에 번호를 포함하여 입력
INSERT INTO Person VALUES (PERSON_NO_SQ.NEXTVAL, '홍길동',
    (SELECT JNO FROM JOB WHERE JNAME ='가수'), 81,83,85);

-- 2번 : 직업명을 입력 받아, 직업별 조회 후 총점을 추가, 총점이 높은 순으로 이름(번호)로 출력
SELECT PNAME || '('||PNO||'번)' PNAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM
    FROM Person P, JOB J
    WHERE P.JNO=J.JNO AND JNAME = '가수'
    ORDER BY SUM DESC;

-- 3번 : 모든 행의 등수, 이름(pNO),직업명,국어(kor),영어(eng),수학(mat),총점을 출력(총점기준으로 내림차순 정렬)

SELECT ROWNUM RANK, A.*
    FROM (SELECT PNAME || '('||PNO||'번)' PNAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM
        FROM Person P, JOB J WHERE P.JNO=J.JNO ORDER BY SUM DESC)A;




