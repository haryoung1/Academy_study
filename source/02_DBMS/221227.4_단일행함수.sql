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

-- 3. SUBSTR(STR, 시작위치, 문자갯수):STR을 시작위치부터 문자갯수만큼 문자 추출 (시작위치 1)
                            -- (시작위치가 1부터, 시작위치가 음수면 끝부터 자리수를 셈)
    -- SUBSTRB (STR, 시작바이트 위치, 문자바이트수)
    
SELECT SUBSTR ('ORACLE', 3, 2) -- 3번째 글자부 2글자 추출
    FROM DUAL; -- DUAL < 얘는 FROM절을 꼭 필수로 사용해야하니 가상의 임시테이블임
    
SELECT SUBSTRB ('ORACLE', 3, 2) -- 3번째 바이트부터 2바이트 추출
    FROM DUAL;

SELECT SUBSTR ('데이터베이스', 4, 3) -- 4번째부터 글자부터 3글자 추출
    FROM DUAL;

SELECT SUBSTRB ('데이터베이스', 4,3) -- 4번째 바이트부터 3바이트 추출
    FROM DUAL; -- 한글은 개당 3byte 
    
    -- O R A C L E
    -- 1 2 3 4 5 6 (위치)
    -- -6 -5 -4 -3 -2 -1 (위치)

SELECT SUBSTR ('WELCOME TO ORACLE', -1, 1) -- -1번째 글자부터 한글자 추출
    FROM DUAL;
    
SELECT SUBSTR ('ORACLE', -2, 2) -- 마지막 글자 2글자 추출
    FROM DUAL;

SELECT SUBSTR (123, 2, 1) -- 숫자 가능 (숫자를 문자로 바꿔 2번째부터 1글자 추출)
    FROM DUAL;

    --ex. 9월에 입사한 사원의 모든 필드 'RR/MM/DD'
SELECT *
    FROM EMP
    WHERE SUBSTR (TO_CHAR (HIREDATE, 'RR/MM/DD'), 4, 2) = '09';
    
SELECT *
    FROM EMP
    WHERE SUBSTR (HIREDATE, 4, 2) = '09'; -- DATE형도 가능
    
    --ex. 9일에 입사한 사원의 모든 필드 'RR/MM/DD'
SELECT *
    FROM EMP
    WHERE SUBSTR (HIREDATE, -2, 2) = '09';

SELECT *
    FROM EMP
    WHERE SUBSTR (TO_CHAR(HIREDATE, 'RR/MM/DD'), -2, 2) = '09';
    
-- 4. LENGTH (STR) : STR의 글자수
 --   LENGTHB(STR) : STR의 바이트수
 
SELECT LENGTH ('ABCD') -- 글자수
    FROM DUAL;

SELECT LENGTHB ('ABCD') -- 바이트수
    FROM DUAL;
    
SELECT LENGTH ('오라클') -- 결과 : 3
    FROM DUAL;
    
SELECT LENGTHB ('오라클') -- 결과 : 9
    FROM DUAL;

-- 5. INSTR (STR, 찾을문자) : STR에서 첫번째 문자부터 찾을 문자가 나오는 위치
    -- INSTR (STR, 찾을문자, 시작위치) : STR에서 시작위치 문자부터 찾을문자가 나오는 위치
    
SELECT INSTR ('ABCABC', 'B') -- 처음부터 찾아서 나오는 B의 위치 : 2 
    FROM DUAL;
    
SELECT INSTR ('ABCABC', 'B', 3) -- 3번째 문자부터 찾아서 처음 나오는 B의 위치 : 5
    FROM DUAL;

SELECT INSTR ('ABCABC', 'B', -3) -- 뒤 3번째부터 뒤로 찾아 처음 나오는 B의 위치 : 2
    FROM DUAL;

SELECT INSTR ('ABCABCABC', 'B', -3) -- 뒤 3번째부터 뒤로 찾아 처음 나오는 B위치 : 5
    FROM DUAL;
    
    -- 9월에 입사한 사원 (INSTR 이용) 'RR/MM/DD'
SELECT *
    FROM EMP
    WHERE INSTR (HIREDATE, '09', 4) = 4;
  
SELECT *
    FROM EMP
    WHERE INSTR (TO_CHAR(HIREDATE, 'RR/MM/DD'), '09', 4) = 4;  
  
    -- 9일에 입사한 사원 (INSTR 이용)
    -- 9일 아닌 다른날에 입사한 사원의 모든 필드 (INSTR 이용)
  
SELECT *
    FROM EMP
    WHERE INSTR (HIREDATE, '09', 7) = 7;

SELECT *
    FROM EMP
    WHERE INSTR (HIREDATE, '09', 7) = 0;
  
-- 6. LPAD (STR, 자리수, 채울문자) : STR을 자리수만큼 확보하고 왼쪽 빈자리에 채울문자로 출력
   -- LAPD (STR, 자리수) : STR을 자리수만큼 확보하고 왼쪽 빈자리에 ' ' 로 출력
   -- RPAD (STR, 자리수, 채울문자) : STR을 자리수만큼 확보하고 오른쪽 빈자리에 채울문자로 출력
   -- RPAD (STR, 자리수) : STR을 자리수만큼 확보하고 오른쪽 빈자리에 ' '로 출력
  
SELECT LPAD ('ORACLE', 10, '#')
    FROM DUAL;

SELECT RPAD ('ORACLE', 10, '*')
    FROM DUAL;
    
SELECT ENAME, SAL
    FROM EMP;
    
SELECT RPAD (ENAME, 11, '-'), LPAD (SAL, 6, '*')
    FROM EMP;
DESC EMP; -- 이름은 10문자까지 SAL은 5자리까지 입력가능

    -- ex. 사번, 이름(7369 S**** / 7654 M***** / 7521 W*** ..)
    -- SUBSTR, LENGTH, RPAD 

SELECT EMPNO, RPAD (SUBSTR (ENAME, 1, 1), LENGTH(ENAME), '*') "NAME"
    FROM EMP;

    -- ex. 사번, 이름, 직책(9자리), 입사일 -- LPAD, SUBSTR, LENGTH, || CONCAT, ...
    -- (7369 SMITH _____****K 80/12/**)
    
SELECT EMPNO, ENAME, LPAD (LPAD(SUBSTR(JOB, -1, 1), LENGTH(JOB), '*'), 9) JOB,
    SUBSTR (HIREDATE, 1,6) || '**'
    FROM EMP;

SELECT EMPNO, ENAME, LPAD (LPAD(SUBSTR(JOB, -1, 1), LENGTH(JOB), '*'), 9) JOB,
    TO_CHAR (HIREDATE, 'RR/MM/') || '**'
    FROM EMP;
    
    -- ex. 이름의 세번째 자리 글자가 R인 사원의 모든 필드 출력 (LIKE, INSTR, SUBSTR 이용)

SELECT *
    FROM EMP
    WHERE ENAME LIKE '__R%';
    
SELECT *
    FROM EMP
    WHERE INSTR (ENAME, 'R', 3) = 3; -- RARA까지 출력되기 위해 3번째 글자부터 검색

SELECT *
    FROM EMP
    WHERE SUBSTR (ENAME, 3, 1) = 'R'; -- RARA 출력 가능 3번째에 R이 있기때문에
    
-- 7. 여백제거 : TRIM(STR), LTRIM(STR), RTRIM(STR)

SELECT '    ORACLE    ' MSG 
    FROM DUAL;

SELECT TRIM ('     ORACLE    ') MSG
    FROM DUAL;

SELECT LTRIM ('    ORACLE    ') MSG
    FROM DUAL;
    
SELECT RTRIM ('    ORACLE    ') MSG
    FROM DUAL;


-- 8. REPLACE (STR, 바꿔야할문자, 바꿀문자) : STR에서 바꿔야할 문자를 바꿀 문자로 교체

SELECT REPLACE (ENAME, 'A', 'XX') NAME
    FROM EMP;

SELECT REPLACE (SAL, 0, 'X') SAL
    FROM EMP;
        
SELECT REPLACE (HIREDATE, '0', 'X')
    FROM EMP;

-- 3. 날짜 관련함수 및 예약어
-- (1) SYSDATE : 지금 / SYSTIMESTAMP

SELECT SYSDATE NOW
    FROM DUAL;

SELECT SYSTIMESTAMP
    FROM DUAL;
    
ALTER SESSION SET NLS_DATE_FORMAT = 'RR/MM/DD HH24:MI:SS';
ALTER SESSION SET NLS_DATE_FORMAT = 'RR/MM/DD'; -- DATE 포멧 원상복귀

    -- 오라클 타입 : 문자, 숫자, 날짜, 그 중 숫자, 날짜도 연산 가능

ALTER SESSION SET NLS_DATE_FORMAT = 'RR/MM/DD HH24:MI:SS';

SELECT SYSDATE -1 "어제 이 시간", SYSDATE, SYSDATE +1 "내일 이 시간"
    FROM DUAL;
    
ALTER SESSION SET NLS_DATE_FORMAT = 'RR/MM/DD'; -- 원상복귀

    -- ex. 반납 예정일
SELECT SYSDATE +14
    FROM DUAL;
    
    -- ex. 개강일 ~ 현재까지
SELECT TRUNC (SYSDATE - TO_DATE ('22/11/28 09:30 ', 'RR/MM/DD HH24:MI')) DAY
    FROM DUAL;

    -- ex. 현재 ~ 수료일까지 몇일 남았는지?
SELECT TRUNC (TO_DATE ('230512 12:20', 'RRMMDD HH24:MI') - SYSDATE) DAY
    FROM DUAL;
    
    -- ex. EMP에서 이름, 입사일, 근무일수
SELECT ENAME, HIREDATE, TRUNC (SYSDATE - HIREDATE) DAY
    FROM EMP;

    -- ex. EMP에서 이름, 입사일, 근무일수, 근무주수(나누기7), 근무년수
SELECT ENAME, HIREDATE, TRUNC (SYSDATE - HIREDATE) DAY,
    TRUNC ((SYSDATE - HIREDATE) /7) WEEK, TRUNC ((SYSDATE-HIREDATE) /365) YEAR
    FROM EMP;

-- (2) MONTHS_BETWEEN (시점1, 시점2) : 두 시점간의 개월수 (시점1을 큰 시점)
    -- ex. 이름, 입사일, 근무월수
SELECT ENAME, HIREDATE, TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)) MONTH
    FROM EMP;

    -- ex. 이름, 입사한 이후 회사에서 받은 돈 (SAL은 1년에 12번, COMM은 2번)을 출력
SELECT ENAME, SAL* TRUNC (MONTHS_BETWEEN (SYSDATE, HIREDATE))+
    NVL(COMM,0)*2*TRUNC ((SYSDATE-HIREDATE) /365) MONTHS
    FROM EMP;

-- 4. ADD_MONTHS (특정 시점, 개월수) : 특정시점부터 몇개월 후
    -- ex. 이름, 입사일, 수습종료 시점 (수습기간 6개월)
SELECT ENAME, HIREDATE, ADD_MONTHS(HIREDATE, 6) 수습
    FROM EMP;

    -- 입사일이 81/08/30 이면 수습 종료시점 81/02/28
INSERT INTO EMP VALUES (9999, 'KANG', 'KING2', NULL, '81/08/30', NULL, NULL, 40);
ROLLBACK;

-- 5. NEXT_DAY (특정시점, '수') : 특정시점부터 처음 도래하는 수요일
SELECT NEXT_DAY (SYSDATE, '토') DAY
    FROM DUAL;

-- 6. LAST_DAY (특정시점) : 특정시점의 일 (28,29,30,31)
SELECT LAST_DAY(SYSDATE)
 FROM DUAL;
 
    -- ex. 이름, 입사일, 첫월급날 (월급날은 말일)
SELECT ENAME, HIREDATE, LAST_DAY (HIREDATE)
    FROM EMP;
    
-- 7. ROUND (날짜, XX) : 날짜 반올림 (xx: YEAR, MONTH, DAY)
  --  TRUNC (날짜, XX) : 날짜 버림
SELECT ROUND (34.5678, 2)
    FROM DUAL;
    
SELECT ROUND (SYSDATE, 'YEAR') -- 반올림을 했을때 더 가까운곳으로 감. 작년 OR 내년
    FROM DUAL;

SELECT ROUND (SYSDATE, 'MONTH') -- 결과 : 가까운 1일 (1~15일까지는 이번달 1일)
    FROM DUAL;                  -- 결과 : 16일 부터는 다음달 1일
    
SELECT ROUND (SYSDATE, 'DAY')   -- 결과 : 가까운 일요일.
    FROM DUAL;

SELECT ROUND (SYSDATE) -- 결과 : 가까운 0시0분
    FROM DUAL;

SELECT TRUNC (SYSDATE, 'YEAR') -- 같은해 1월 1일
    FROM DUAL;

SELECT TRUNC (SYSDATE, 'MONTH') -- 같은달 1일
    FROM DUAL;

SELECT TRUNC (SYSDATE, 'DAY') -- 지난 일요일
    FROM DUAL;
    
SELECT TO_CHAR (TRUNC (SYSDATE), 'RR/MM/DD HH24:MI')
    FROM DUAL;
    
    -- ex. 이름, 입사일 ,첫월급날 (11일) : 10일 이전 : 이번달 11 / 11일 이후면 다음달 11일
        -- ROUND의 기준은 15,16을 => 10,11로
        -- 결과 : 가까운 1일 (1~15일까지는 이번달 1일)
SELECT ENAME, HIREDATE, ROUND(HIREDATE+5, 'MONTH') + 10 -- 월급날 11일
    FROM EMP;
    -- ex. 월급날 10일 : 9일까지는 이번달, 10일부터는 다음달
SELECT ENAME, HIREDATE, ROUND(HIREDATE+6, 'MONTH') + 9 -- 월급날 25일
    FROM EMP;
    -- ex. 월급날 10일 : 24일까지는 이번달, 25일부터는 다음달
SELECT ENAME, HIREDATE, ROUND(HIREDATE-9, 'MONTH') + 24 -- 월급날 25일
    FROM EMP;


-- 4. 형변환 함수 (TO_CHAR : 문자로 변환하는 함수, TO_DATE: 날짜형으로 변환하는 함수)
    -- (1) TO_CHAR (날짜형, '출력형식')
    -- YYYY 년도 4자리 / RR 년도 2자리 / MM 월 / DD 일 / DY 요일
    -- HH24 / HH12 / AM이나 PM / MI 분 / SS 초
    -- 출력형식에 문자를 포함 할 경우 ""
    
SELECT ENAME, TO_CHAR (HIREDATE, 'YYYY-MM-DD HH24:MI:SS')
    FROM EMP;

SELECT TO_CHAR (SYSDATE, 'YYYY"년" MM"월" DD "일" DY"요일" AM HH12"시" MI"분" SS"초"') "현재 시간"
    FROM DUAL;
    
SELECT TO_CHAR (SYSTIMESTAMP, 'RR-MM-DD AM HH12:MI:SS:FF') "현재 시간2"
    FROM DUAL;
    
-- (2) TO_CHAR (숫자, '출력형식')
    -- 0 : 자릿수, 출력형식의 자릿수가 많으면 0으로 채움
    -- 9 : 자릿수, 출력형식의 자릿수가 많아도 숫자만큼만 출력
    -- , : 세자리마다 , 가능
    -- . : 소수점
    -- $ : 통화단위 $ 추가
    -- L : 지역통화단위를 추가
    
SELECT TO_CHAR (12345678, '0,000,000,000.00') -- 012,345,678
    FROM DUAL;
    
SELECT TO_CHAR (12345678, '9,999,999,999.99') -- 12,345,678
    FROM DUAL;

SELECT TO_CHAR (100.76, '999.9') -- 소수점 자리수가 부족할 경우 반올림
    FROM DUAL;
    
SELECT TO_CHAR (1200, 'L9,999') 
    FROM DUAL;
    
DESC EMP; -- SAL NUMBER (7,2) 전체 자리수는 7자리

SELECT ENAME, SAL, TO_CHAR (SAL, '$99,999')
    FROM EMP;
    
-- (3) TO_DATE (문자, '패턴')
SELECT TO_DATE ('20221227 14:53', 'YYYYMMDD HH24:MI')
    FROM DUAL;
    
    -- 81/5/1 ~ 83/5/1 사이에 입사한 직원의 모든 필드
SELECT *
    FROM EMP
    WHERE HIREDATE BETWEEN TO_DATE('81/05/01', 'RR/MM/DD')
    AND TO_DATE('83/05/01', 'RR/MM/DD');
    
-- (4) TO_NUMBER (문자, "패턴")
SELECT '3456' +1 "NUMBER"
    FROM DUAL;
    
SELECT TO_NUMBER ('3,456', '9,999')+ 1 "NUMBER"
    FROM DUAL;

-- 5. NVL (NULL 일 수도 있는 데이터, NULL이면 대신 할 값) - 매개변수 2개의 타입 일치
    -- ex. 사원이름, 직속상사 이름 (직속상사가 없으면 CEO로 출력)
SELECT W.ENAME, NVL (M.ENAME, 'CEO') "MGR"
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO(+);

    -- ex. 사원이름, 직속상사의 사번 (직속상사가 없으면 'CEO'로 출력)
SELECT ENAME, NVL(TO_CHAR (MGR), 'CEO') "MGR"
    FROM EMP;
DESC EMP;


-- 6. ETC 
 -- (1) EXTRACT : 년도, 월, 일만 추출 하고자 할 때
SELECT HIREDATE, EXTRACT (YEAR FROM HIREDATE) -- 년도만 숫자로 추출
    FROM EMP;

SELECT HIREDATE, TO_CHAR (HIREDATE, 'YYYY') -- 년도 4자리를 문자로 추출함
    FROM EMP;
 
SELECT SYSDATE, EXTRACT (MONTH FROM SYSDATE) -- 월만 숫자로 추출
    FROM DUAL;
    
SELECT SYSDATE, TO_CHAR (SYSDATE, 'MM') -- 월 2자리를 문자로 추출
    FROM DUAL;
    
SELECT SYSDATE, EXTRACT (DAY FROM SYSDATE) -- 일만 숫자로 추출 
    FROM DUAL;
    
SELECT SYSDATE, TO_CHAR (SYSDATE, 'DD') -- 일 두자리를  문자로 추출 
    FROM DUAL;
    
 -- (2) 레벨별 출력 
SELECT LPAD('ㄴ', LEVEL*2) || ENAME
    FROM EMP
    START WITH MGR IS NULL
    CONNECT BY PRIOR EMPNO = MGR;

-- <총 연습문제>
-- 1. 현재 날짜를 출력하고 TITLE에 “Current Date”로 출력하는 SELECT 문장을 기술하시오.
SELECT SYSDATE "Current Date"
    FROM DUAL;
    
-- 2. EMP 테이블에서 현재 급여에 15%가 증가된 급여를 계산하여,
-- 사원번호,이름,업무,급여,증가된 급여(New Salary),증가액(Increase)를 출력하는 SELECT 문장
SELECT EMPNO, ENAME, JOB, SAL, SAL*1.15 "New Salary", SAL*0.15  Increase
    FROM EMP;

--3. 이름, 입사일, 입사일로부터 6개월 후 돌아오는 월요일 구하여 출력하는 SELECT 문장을 기술하시오.
SELECT ENAME, HIREDATE, NEXT_DAY (ADD_MONTHS (HIREDATE, 6), '월') 
    FROM EMP;
    
--4. 이름, 입사일, 입사일로부터 현재까지의 개월수, 급여, 입사일부터 현재까지의 받은 급여의 총계를 출력
SELECT ENAME, HIREDATE, TRUNC(MONTHS_BETWEEN (SYSDATE, HIREDATE)) MONTH,
    SAL* TRUNC (MONTHS_BETWEEN (SYSDATE, HIREDATE)) "ALL SAL"
    FROM EMP;

--5. 모든 사원의 이름과 급여(15자리로 출력 좌측의 빈 곳은 “*”로 대치)를 출력
SELECT LPAD (ENAME, 15, '*')NAME, LPAD (SAL, 15, '*') SAL
    FROM EMP;
    
--6. 모든 사원의 정보를 이름,업무,입사일,입사한 요일을 출력하는 SELECT 문장을 기술하시오.
SELECT ENAME, JOB, HIREDATE, TO_CHAR (HIREDATE, 'DY') "입사요일"
    FROM EMP;

--7. 이름의 길이가 6자 이상인 사원의 정보를 이름,이름의 글자수,업무를 출력
SELECT LENGTH(ENAME), ENAME, JOB
    FROM EMP
    WHERE LENGTH (ENAME) >= 6;
    
--8. 모든 사원의 정보를 이름, 업무, 급여, 보너스, 급여+보너스를 출력
SELECT ENAME, JOB, SAL, COMM, SAL+NVL(COMM,0) "SAL+BONUS"
    FROM EMP;
    
-- 9.사원 테이블의 사원명에서 2번째 문자부터 3개의 문자를 추출하시오. 
SELECT ENAME, SUBSTR (ENAME, 2, 3)
    FROM EMP;

--10. 사원 테이블에서 입사일이 12월인 사원의 사번, 사원명, 입사일을 검색하시오. 
--  시스템에 따라 DATEFORMAT 다를 수 있으므로 아래의 방법도 알아보자
SELECT EMPNO, ENAME, HIREDATE
    FROM EMP
    WHERE INSTR (HIREDATE, '12', 4) = 4;


--11. 다음과 같은 결과를 검색할 수 있는 SQL 문장을 작성하시오
--EMPNO		ENAME		급여
--7369		       SMITH		*******800
--7499		       ALLEN		******1600
--7521		       WARD		    ******1250
--……. 
SELECT LPAD (EMPNO, 6, '-') "--EMPNO", ENAME, LPAD (SAL, 10, '*') "급여"
    FROM EMP;


-- 12. 다음과 같은 결과를 검색할 수 있는 SQL 문장을 작성하시오
-- EMPNO	 ENAME 	입사일
-- 7369	  SMITH		1980-12-17
-- ….
SELECT LPAD (EMPNO, 6, '-') "--EMPNO", ENAME, TO_CHAR(HIREDATE, 'YYYY/MM/DD') "입사일"
    FROM EMP;
    
--13. 사원 테이블에서 부서 번호가 20인 사원의 사번, 이름, 직무, 급여를 출력하시오.
    --(급여는 앞에 $를 삽입하고3자리마다 ,를 출력한다)
SELECT DEPTNO, EMPNO, ENAME, JOB, TO_CHAR (SAL, '$99,999') SAL
    FROM EMP
    WHERE DEPTNO = 20;