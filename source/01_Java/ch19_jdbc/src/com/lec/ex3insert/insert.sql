 --  ex1
 INSERT INTO DEPT VALUES (60, 'IT', 'SEOUL');
 SELECT * FROM DEPT WHERE DEPTNO > 40;
 COMMIT;
 
 -- ex2. (중복체크)
 SELECT COUNT(*) CNT FROM DEPT WHERE DEPTNO= 99;
 INSERT INTO DEPT VALUES (60, 'IT', 'SEOUL');
 
-- ex3. update
UPDATE DEPT SET DNAME = 'MARKETING', LOC = 'INCHON' WHERE DEPTNO= 50;
 commit;
 
-- ex4. update 수정할 부서번호를 받아 존재하는 부서번호 인지 확인후, 부서명, 근무지 입력 받아 update
SELECT * FROM DEPT WHERE DEPTNO = 10;
UPDATE DEPT SET DNAME = 'MARKETING', LOC = 'INCHON' WHERE DEPTNO= 50;
 
select * from dept; 
COMMIT;

-- DELETE
select * from dept; 
DELETE FROM DEPT WHERE DEPTNO = 65;
COMMIT;

-- 부서명을 받아 해당 부서 사원을 출력 (사번, 이름, 상사이름, 급여, 급여등급, 상사 없는사람은 CEO)
SELECT W.EMPNO, W.ENAME, M,ENAME, W.SAL, GRADE
    FROM EMP W, EMP M, SALGRADE
    WHERE W.SAL AND LO
    W.DEPTNO=M.DEPTNO AND W.MGR=M.EMPNO;

WHERE SAL >= LOSAL AND SAL <= HISAL AND ENAME = 'SCOTT';











