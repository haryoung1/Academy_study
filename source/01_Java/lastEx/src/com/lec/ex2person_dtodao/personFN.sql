-- 프로그램 요구사항에 필요한 DML
-- 기능별 query 작성 (1, 2, 3)

-- 1번 : 이름, 직업명, 국어,영어,수학점수를 입력 받아 데이터베이스에 번호를 포함하여 입력
INSERT INTO Person VALUES (PERSON_NO_SQ.NEXTVAL, '홍길동',
    (SELECT JNO FROM JOB WHERE JNAME ='배우'), 81,83,85);

-- 2번 : 직업명을 입력 받아, 직업별 조회 후 총점을 추가, 총점이 높은 순으로 이름(번호)로 출력
SELECT PNAME || '('||PNO||'번)' PNAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM
    FROM Person P, JOB J
    WHERE P.JNO=J.JNO AND JNAME = '배우'
    ORDER BY SUM DESC;

SELECT ROWNUM RANK, A.*
    FROM (SELECT PNAME || '('||PNO||'번)' PNAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM
         FROM Person P, JOB J WHERE P.JNO=J.JNO AND JNAME = '배우' ORDER BY SUM DESC) A;

SELECT ROWNUM RANK, A.*
    FROM (SELECT PNAME || '('||PNO||')' PNAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM
         FROM Person P, JOB J WHERE P.JNO=J.JNO AND JNAME = '배우' ORDER BY SUM DESC) A;

-- 3번 : 모든 행의 등수, 이름(pNO),직업명,국어(kor),영어(eng),수학(mat),총점을 출력(총점기준으로 내림차순 정렬)

SELECT ROWNUM RANK, A.*
    FROM (SELECT PNAME || '('||PNO||'번)' PNAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM
        FROM Person P, JOB J WHERE P.JNO=J.JNO ORDER BY SUM DESC)A;

-- 1번과 2번 기능에서 현재 가능한 직업명 list
SELECT JNAME FROM JOB;
SELECT * FROM JOB;

select * from person;
