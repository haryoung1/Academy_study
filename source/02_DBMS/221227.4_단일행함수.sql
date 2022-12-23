-- [ IV ] 단일행함수
-- 함수 = 단일행함수 + 그룹함수 (집계함수)

SELECT HIREDATE, TO_CHAR (HIREDATE, 'YYYY-MM-DD')
    FROM EMP; -- 한행
    
SELECT ENAME, INITCAP (ENAME)
    FROM EMP; -- 단일행함수 (INPUT 1행 -> OUTPUT 1행)
    
SELECT SUM(SAL), AVG(SAL)
    FROM EMP; -- 그룹함수 (INPUT n행 -> OUTPUT 1행)

 SELECT DEPTNO, AVG(SAL)
    FROM EMP GROUP BY DEPTNO;


-- ★ 단일행 함수의 종류 : [숫자]함수, [문자]함수 [날짜]함수 [형변환]함수, NVL(), ETC...
-- 1. 숫자관련함수
    -- DUAL 테이블 : 오라클에서 제공한 1행 1열짜리 DUMMY TABLE

SELECT *
    FROM DUAL;
    DESC DUAL;
    
SELECT *
    FROM DUMMY;
    DESC DUMMY;
    
SELECT ABS (-1)
    FROM DUMMY; -- 절대값

SELECT FLOOR(34.5678)
    FROM DUAL; -- 소수점을 버림 (5678)
    
SELECT FLOOR(34.5678*100)/100
    FROM DUAL;  -- 소수점 두번째에서 버림
    
SELECT TRUNC(34.5678,2)
    FROM DUAL; -- 소수점 두번째에서 버림

SELECT TRUNC(34.5678)
    FROM DUAL; -- 소수점에서 버림

SELECT TRUNC(34.5678, -1)
    FROM DUAL; -- 일의 자리에서 버림
    
    --. ex EMP 테이블에서 이름, 급여 (십의 자리에서 내림)
SELECT ENAME, SAL,TRUNC(SAL, -2)
    FROM EMP;

SELECT CEIL (34.5678)
    FROM DUAL; -- 소수점에서 올림
    
SELECT ROUND (34.5678)
    FROM DUAL; -- 소수점에서 반올림
    
SELECT ROUND (34.5678, 2)
    FROM DUAL; -- 소수점 두번째 자리에서 반올림

SELECT ROUND (34.5678/10)*10
    FROM DUAL; -- 일의 자리에서 반올림
    
    
SELECT MOD (9,2) 
    FROM DUAL; -- 나머지 연산자
        
        --ex. 홀수년도에 입사한 사원의 모든 정보 출력
        
SELECT * 
    FROM EMP
    WHERE MOD (TO_CHAR (HIREDATE, 'RR'), 2) = 1;
    
-- 2. 문자 관련 함수
-- ① 대소문자 관련

SELECT INITCAP ('WELCOME TO ORACLE') -- 첫 문자만 대문자로
    FROM DUAL;

SELECT INITCAP ('welcome to oracle') -- 대소문자 변환 알트 + ' 
    FROM DUAL;

SELECT UPPER ('ABCabc') -- 전부 대문자로 
    FROM DUAL;
    
SELECT LOWER ('ABCabc') -- 전부 소문자로
    FROM DUAL;
    
    -- ex. 이름이 Scott인 직원의 모든 필드
SELECT *
    FROM EMP
    WHERE UPPER (ENAME) = 'SCOTT';

SELECT *
    FROM EMP
    WHERE INITCAP (ENAME) = 'SCOTT';
    
    -- ex. job이 MANAGER인 직원의 모든 필드
SELECT *
    FROM EMP
    WHERE UPPER (JOB) = 'MANAGER';

SELECT *
    FROM EMP
    WHERE INITCAP (JOB) = 'Manager';

SELECT *
    FROM EMP
    WHERE LOWER (JOB) = 'manager';
    
-- ② 문자연결 (concat 함수, || 연산자)
SELECT 'AB'||'CD'||'EF'||'GH'
    FROM DUAL;
    
SELECT CONCAT (CONCAT('AB', 'CD'), CONCAT ('EF', 'GH'))
    FROM DUAL;
    
    -- EX. SMITH는 manager 다
SELECT CONCAT (CONCAT(ENAME, '는'), CONCAT (JOB, '다'))
    FROM EMP;

SELECT ENAME || '는' || JOB || '다'
    FROM EMP;




