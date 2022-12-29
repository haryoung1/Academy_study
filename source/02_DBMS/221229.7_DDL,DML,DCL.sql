-- [ VII ] DDL, DCL, DML
-- SQL = DDL(테이블생성,테이블삭제, 테이블 구조변경,테이블 모든 데이터 제거) + 
--       DML(SELECT, INSERT, UPDATE, DELETE) + 
--       DCL(사용자계정 생성, 사용자에게 권한부여, 권한박탈, 사용자계정 삭제, 트랜젝션 명령어)

-- ★ ★ ★ DDL ★ ★ ★
-- 1. 테이블 생성 (CREATE TABLE 테이블명 ...) : 테이블 구조를 정의하기 
CREATE TABLE BOOK (
    BOOKID NUMBER(4), -- BOOKKID 필드의 타입은 숫자 4자리
    BOOKNAME VARCHAR2(20), -- BOOKNAME 필드의 타입은 문자 20BYTE
    PUBLISHER VARCHAR2(20), -- PUBLICSHER 필드의 타입은 문자 20BYTE
    RDATE   DATE,           -- RDATE 필드의 타입은 DATE형
    PRICE   NUMBER(8, 2),   -- PRICE 필드의 타입은 숫자 전체 8자리, 소수점2
                            -- 소수점 앞 6. 소수점은 자리수에 포함되지 않음.
    PRIMARY KEY (BOOKID) -- 제약조건 : BOOKID 필드가 주키(PRIMARY KEY : NOT NULL, UNIQUE)
);
SELECT * FROM BOOK;
DESC BOOK;

DROP TABLE BOOK; -- 테이블 삭제

CREATE TABLE BOOK(
    BID       NUMBER(4) PRIMARY KEY,
    BNAME     VARCHAR2(20),
    PUBLISHER VARCHAR2(20),
    RDATE     DATE,
    PRICE     NUMBER(8));
    
SELECT *
    FROM BOOK;
    DESC BOOK;
    
   -- ex. EMP와 유사한 EMP01 테이블 : EMPNO(숫자4), ENAME(문자10), SAL(숫자7,2)
CREATE TABLE EMP01 (
    EMPNO NUMBER(4),
    ENAME VARCHAR2(10),
    SAL   NUMBER(7,2)
);
    
    -- ex. DEPT01 테이블 : DEPTNO(숫자 2: PK), DNAME(문자14), LOC (문자13)
CREATE TABLE DEPT01 (
    DEPTNO NUMBER(2) PRIMARY KEY,
    DNAME  VARCHAR2(14),
    LOC    VARCHAR2(13)
);

-- 서브쿼리를 이용한 테이블 생성
CREATE TABLE EMP02
    AS
    SELECT * FROM EMP; -- 서브쿼리 결과만 EMP02 테이블 생성 후 데이터도 들어감
SELECT * FROM DEPT01;    
DESC EMP02;    
    
    -- EMP03 : EMP 테이블에서 EMPNO, ENAME, DEPTNO만 추출한 데이터
    
CREATE TABLE EMP03
    AS SELECT EMPNO,ENAME,DEPTNO 
        FROM EMP;
SELECT * FROM EMP03;   

    -- EMP04 : EMP 테이블에서 10번 부서만 추출한 데이터   
CREATE TABLE EMP04
    AS SELECT * 
       FROM EMP
       WHERE DEPTNO = 10;
SELECT * FROM EMP04;    
    
    -- EMP05 : EMP 테이블 구조만 추출 (데이터를 추출하지 않음)
CREATE TABLE EMP05
    AS SELECT *
        FROM EMP
        WHERE DEPTNO = 40;
SELECT * FROM EMP05;
    
SELECT * FROM EMP;   
SELECT ROWNUM, EMPNO, ENAME, JOB -- 테이블에서 행의 논리적 순서 (읽어들인 순서)
    FROM EMP;
   
-- 2. 테이블 구조 변경 (ALTER TABLE 테이블명 ADD || MODIFY || DROP ~)
-- (1) 필드 추가 (ADD)
SELECT *
    FROM EMP03; -- EMPNO(수4), ENAME(문10), DEPTNO(수2)
ALTER TABLE EMP03 ADD (JOB VARCHAR2(20), SAL NUMBER(7,2) );
ALTER TABLE EMP03 ADD (COMM NUMBER(7,2));   
SELECT *
    FROM EMP03; -- 필드 추가시 데이터는 NULL
   
-- (2) 필드 수정 (MODIFY)
SELECT *
    FROM EMP03; -- EMPNO(수4), ENAME(문10), DEPTNO(수2), JOB, SAL, COMM은 NULL   
ALTER TABLE EMP03 
    MODIFY (EMPNO VARCHAR2 (5)); -- 숫자데이터가 들어 있어서 숫자로만 변경  
    
ALTER TABLE EMP03
    MODIFY (EMPNO NUMBER(5));
    
ALTER TABLE EMP03
    MODIFY (EMPNO NUMBER(4));    -- 숫자 데이터 줄이는건 불가능
    
ALTER TABLE EMP03
    MODIFY (SAL VARCHAR2(10));   -- NULL 필드는 마음대로 수정 가능
    
ALTER TABLE EMP03
    MODIFY (ENAME VARCHAR2(20)); -- 문자 데이터 늘리거나 줄이거나 가능
 
SELECT MAX (LENGTH(ENAME)) 
    FROM EMP03;
    
ALTER TABLE EMP03 
    MODIFY (ENAME VARCHAR2 (6)); -- 가능
    
ALTER TABLE EMP03 
    MODIFY (ENAME VARCHAR2 (5)); -- 불가능
   
-- (3) 필드 삭제 (DROP)
ALTER TABLE EMP03 
    DROP COLUMN JOB; -- NULL인 필드 삭제 (NULL이 아닌 필드는 데이터까지 삭제)
    
SELECT * FROM EMP03;

ALTER TABLE EMP03
    DROP COLUMN DEPTNO;
    
-- 논리적으로 특정 필드를 접근 못하도록 (낮) , 필드를 숨김
ALTER TABLE EMP03 
    SET UNUSED (COMM);

-- 논리적으로 접근 불가했던 필드 물리적으로 삭제 (새벽)
ALTER TABLE EMP03
    DROP UNUSED COLUMNS;

-- 3. 테이블 삭제 (DROP TABLE 테이블명)
DROP TABLE EMP01;

SELECT * FROM EMP01;

DROP TABLE DEPT; -- EMP 테이블에서 DEPT 테이블을 참조하는 경우 삭제불가 EMP 삭제후 삭제가능


-- 4. 테이블의 모든 행을 제거(TRUNCATE TABLE 테이블명)
TRUNCATE TABLE EMP03; -- ROLLBACK 안됨
SELECT *
    FROM EMP03;

-- 5. 테이블명 변경 (RENAME 테이블명 TO 바꿀 테이블 명)
SELECT *
    FROM EMP02;

RENAME EMP02 TO EMP2;

SELECT *
    FROM EMP2;

-- 6. 데이터 딕셔너리 (접근불가) VS 데이터딕셔너리 뷰 (접근용)
-- 종류
    -- (1) USER_XXX : 현 계정이 소유하고 있는 객체 (테이블, 제약조건, 뷰, 인덱스)
    -- USER_TABLES, USER_CONSTRAINTS, USER_INDEXES, USER_VIEWS
SELECT *
    FROM USER_TABLES;
    
SELECT *
    FROM USER_CONSTRAINTS;

SELECT *
    FROM USER_INDEXES;

    -- (2) ALL_XXX : 현 계정에서 접근 가능한 객체 (테이블,제약조건,뷰 인덱스)
        -- ALL_TABLES, ALL_CONSTRAINTS, ALL_INDEXES, ALL_VIEWS
SELECT *
    FROM ALL_TABLES;
    
SELECT *
    FROM ALL_VIEWS;
    
-- (3) DBA_XXX ; DBA권한에서만 접근 가능한 DBMS의 모든 객체
    -- DBA_TABLES, DBA_CONSTRAINTS, DBA_INDEXES, DBA_VIEWS
SELECT *
    FROM DBA_TABLES;

-- ★ ★ ★ DML ★ ★ ★     
-- 1. INSERT INTO 테이블명 VALUES (값1, 값2, ..);
--    INSERT INTO 테이블명 (필드명1, 필드명2, ..) VALUES (값1, 값2, ..);
SELECT *
    FROM DEPT01;
INSERT INTO DEPT01 VALUES (50, 'ACCOUNTING', 'NEW YORK');
INSERT INTO DEPT01 VALUES (60, 'SALES', NULL); -- 명시적으로 NULL 추가
INSERT INTO DEPT01 (DEPTNO, DNAME, LOC) VALUES (70, 'RESEARCH', '서대문');
INSERT INTO DEPT01 (LOC,DEPTNO, DNAME) VALUES ('마포', 80, 'IT');
INSERT INTO DEPT01 (DEPTNO, DNAME) VALUES (90, 'OPERATION'); --묵시적으로 NULL 추가

-- 서브쿼리를 이용한 INSERT
    -- ex. dept 테이블에서 10~30번 부서를 dept01 테이블로
INSERT INTO DEPT01 SELECT *
    FROM DEPT 
    WHERE DEPTNO<40;
SELECT *
    FROM DEPT01;    
-- EX. BOOK (BID는 11, BNAME은 '스포츠의학', 출판사는 '한솔출판', 출판일은 오늘, 가격 90000)
DESC BOOK;
INSERT INTO BOOK VALUES (11, '스포츠의학', '한솔출판', SYSDATE, 90000);

-- 트랜젝션 명령어 (DML 명령어에서만 적용)
    -- 트랜젝션은 데이터 처리의 한 단위. DML 명령어들이 실행됨과 동시에 트랜젝션이 진행.
COMMIT; -- 현 트랜젝션의 작업을 DB에 반영
INSERT INTO BOOK VALUES (12, '스포츠의학', '한솔출판', SYSDATE, 90000);  

SELECT * FROM BOOK;
ROLLBACK; -- 현 트랜젝션의 작업을 취소

-- (1) 연습문제 SAM01 테이블 생성
CREATE TABLE SAM01 (
    EMPNO NUMBER(4) PRIMARY KEY,
    ENAME VARCHAR2(10),
    JOB   VARCHAR2(9),
    SAL   NUMBER(7,2)
    );
INSERT INTO SAM01 (EMPNO,ENAME,JOB,SAL) VALUES(1000, 'APPLE', 'POLICE', 10000);
INSERT INTO SAM01 (EMPNO,ENAME,JOB,SAL) VALUES(1010, 'BANANA', 'NURSE', 15000);
INSERT INTO SAM01 (EMPNO,ENAME,JOB,SAL) VALUES(1020, 'ORANGE', 'DOCTOR', 25000);
INSERT INTO SAM01 (EMPNO,ENAME,SAL) VALUES (1030, 'VERY', 25000);
INSERT INTO SAM01 (EMPNO,ENAME,SAL) VALUES (1040, 'CAT', 2000);
INSERT INTO SAM01
    SELECT EMPNO, ENAME, JOB, SAL
    FROM EMP
    WHERE DEPTNO = 10;
SELECT *
    FROM SAM01
ORDER BY EMPNO;
COMMIT; -- 트랜젝션에 만들어 놓은 데이터들을 DB에 저장

-- 2. UPDATE 테이블명 SET 필드명1 = 값1 [, 필드명2=값2, 필드명N=값N...] [WHERE 조건];
SELECT * FROM EMP01;
CREATE TABLE EMP01 AS SELECT * FROM EMP;
    -- ex. 부서번호를 30으로 수정
-- commit;
UPDATE EMP01 
    SET DEPTNO = 30;
SELECT * FROM EMP01; -- 30번으로 바뀌었는지 확인
ROLLBACK; -- 트랜젝션에 있는 데이터 작업한거 취소
SELECT * FROM EMP01; -- 취소 됐는지 확인
    
    -- ex. 모든 직원(EMP01)의 급여(SAL)을 10% 인상
UPDATE EMP01 
    SET SAL = SAL*1.1;
SELECT * FROM EMP01; -- 급여 인상 됐는지 확인    
 
    -- ex. EMP01 테이블 10번 부서 직원의 입사일을 오늘로 , 부서번호 30으로 수정   
UPDATE EMP01
    SET HIREDATE=SYSDATE, DEPTNO=30
    WHERE DEPTNO =10;
    SELECT * FROM EMP01;
    
    -- ex. SAL이 3000이상인 사원만 급여를 10% 인상
UPDATE EMP01
    SET SAL = SAL*1.1
    WHERE SAL >= 3000;
    SELECT * FROM EMP01;
    ROLLBACK;
    
    -- ex. DALLAS에 근무하는 직원의 급여를 1000$ 인상
UPDATE EMP01 
    SET SAL=SAL+1000
    WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE LOC = 'DALLAS');
SELECT * FROM EMP01;    

    -- ex. SCOTT의 부서번호를 20으로, JOB은 MANAGER로, SAL과 COMM은 500$ 인상,
    -- 상사는 KING
UPDATE EMP01 
    SET DEPTNO = 20, JOB = 'MANAGER', SAL = SAL + 500,
        COMM = NVL(COMM,0) + 500,
        MGR = (SELECT EMPNO FROM EMP WHERE ENAME = 'KING')
    WHERE ENAME = 'SCOTT';
    
    -- ex. DEPT01에서 60번 부서의 지역명을 20번 부서의 지역으로 수정
UPDATE DEPT01
    SET LOC = (SELECT LOC FROM DEPT01 WHERE DEPTNO = 20)
    WHERE DEPTNO=60;
SELECT * FROM DEPT01;

    -- EMP01에서 모든 사원의 급여와 입사일을 'KING'의 급여와 입사일로 수정
SELECT SAL, HIREDATE
    FROM EMP01
    WHERE ENAME = 'KING'; -- UPDATE에 들어갈 서브쿼리
    
SELECT HIREDATE
    FROM EMP01
    WHERE ENAME = 'KING'; -- UPDATE에 들어갈 서브쿼리    

UPDATE EMP01
    SET SAL = (SELECT SAL FROM EMP WHERE ENAME = 'KING'),
    HIREDATE = (SELECT HIREDATE FROM EMP WHERE ENAME = 'KING');
SELECT * FROM EMP01;

-- 3. DELETE FROM 테이블명 [WHERE 조건];
SELECT * FROM EMP01;
DELETE FROM EMP01;
ROLLBACK; -- DML 취소 가능
SELECT * FROM EMP01;

    -- ex. EMP01에서 30번부서 직원만 삭제
DELETE 
    FROM EMP01
    WHERE DEPTNO = 30;
SELECT * FROM EMP01;
    
    -- ex. 'FORD' 사원 퇴사
DELETE
    FROM EMP01
    WHERE ENAME = 'FORD';
SELECT * FROM EMP01;

    -- ex. SAM01 테이블에서 JOB이 정해지지 않은 사원을 삭제
SELECT * FROM SAM01;
DELETE
    FROM SAM01
    WHERE JOB IS NULL;
    
    -- EMP01 : 부서명이 SALES인 사원을 삭제(서브쿼리 이용)
DELETE 
    FROM EMP01
    WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE DNAME = 'SALES');
    
    -- EMP01 : 부서명이 RESEARCH 부서에 근무하는 사원을 삭제
DELETE
    FROM EMP01
    WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE DNAME = 'RESEARCH');
    SELECT * FROM SAM01;
COMMIT;    

-- SQL 활용 포트폴리오
CREATE TABLE MY_DATE (
    ID NUMBER(4) PRIMARY KEY,
    NAME VARCHAR2(10),
    USERID VARCHAR2 (30),
    SALARY NUMBER (10,2)
);
INSERT INTO MY_DATE (ID, NAME, USERID, SALARY) VALUES (1, 'Scott', 'sscott',10000000);
INSERT INTO MY_DATE (ID, NAME, USERID, SALARY) VALUES (2, 'Ford', 'fford',13000000);
INSERT INTO MY_DATE (ID, NAME, USERID, SALARY) VALUES (3, 'Patel', 'ppatel',33000000);
INSERT INTO MY_DATE (ID, NAME, USERID, SALARY) VALUES (4, 'Report', 'rreport',23500000);
INSERT INTO MY_DATE (ID, NAME, USERID, SALARY) VALUES (5, 'Good', 'ggood',44450000);
COMMIT;

UPDATE MY_DATE
    SET SALARY = 65000000
    WHERE ID = 3;
COMMIT;

DELETE
    FROM MY_DATE
    WHERE NAME = 'Ford';
COMMIT;    
    
UPDATE MY_DATE
    SET SALARY = 15000000
    WHERE SALARY = 10000000;

DROP TABLE MY_DATE;

-- ★ ★ 연습문제 (PDF 2~3페이지)

-- EMP 테이블과 같은 구조와 같은 내용의 테이블 EMP01을 생성(테이블이 있을시 제거한 후)하고, 모든 사원의 부서번호를 30번으로 수정합니다.
DROP TABLE EMP01;

CREATE TABLE EMP01
    AS SELECT * FROM EMP;

UPDATE EMP01
    SET DEPTNO=30;
    
-- EMP01테이블의 모든 사원의 급여를 10% 인상시키는 UPDATE문을 작성
UPDATE EMP01
    SET SAL = SAL*1.1;

-- 급여가 3000이상인 사원만 급여를 10%인상
UPDATE EMP01
    SET SAL = SAL*1.1
    WHERE SAL >= 3000;
    
-- EMP01테이블에서 ‘DALLAS’에서 근무하는 직원들의 연봉을 1000인상
UPDATE EMP01
    SET SAL = SAL + 1000
        WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE LOC = 'DALLAS');

-- SCOTT사원의 부서번호는 20번으로, 직급은 MANAGER로 한꺼번에 수정
UPDATE EMP01
    SET DEPTNO = 20, JOB = 'MANAGER'
    WHERE ENAME = 'SCOTT';
    
-- 부서명이 SALES인 사원을 모두 삭제하는 SQL작성
DELETE
    FROM EMP01
    WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE DNAME = 'SALES');
    
-- 사원명이 ‘FORD’인 사원을 삭제하는 SQL 작성
DELETE
    FROM EMP01
    WHERE ENAME = 'FORD';

-- SAM01 테이블에서 JOB이 NULL인 사원을 삭제하시오
DELETE 
    FROM SAM01
    WHERE JOB IS NULL;
    
-- SAM01테이블에서 ENAME이 ORANGE인 사원을 삭제하시오
DELETE 
    FROM SAM01
    WHERE ENAME = 'ORANGE';
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    