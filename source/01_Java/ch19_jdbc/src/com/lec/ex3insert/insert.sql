 --  ex1
 INSERT INTO DEPT VALUES (60, 'IT', 'SEOUL');
 SELECT * FROM DEPT WHERE DEPTNO > 40;
 COMMIT;
 
 -- ex2. (�ߺ�üũ)
 SELECT COUNT(*) CNT FROM DEPT WHERE DEPTNO= 99;
 INSERT INTO DEPT VALUES (60, 'IT', 'SEOUL');
 
-- ex3. update
UPDATE DEPT SET DNAME = 'MARKETING', LOC = 'INCHON' WHERE DEPTNO= 50;
 commit;
 
-- ex4. update ������ �μ���ȣ�� �޾� �����ϴ� �μ���ȣ ���� Ȯ����, �μ���, �ٹ��� �Է� �޾� update
SELECT * FROM DEPT WHERE DEPTNO = 10;
UPDATE DEPT SET DNAME = 'MARKETING', LOC = 'INCHON' WHERE DEPTNO= 50;
 
select * from dept; 
COMMIT;

-- DELETE
select * from dept; 
DELETE FROM DEPT WHERE DEPTNO = 65;
COMMIT;

-- �μ����� �޾� �ش� �μ� ����� ��� (���, �̸�, ����̸�, �޿�, �޿����, ��� ���»���� CEO)
SELECT W.EMPNO, W.ENAME, M,ENAME, W.SAL, GRADE
    FROM EMP W, EMP M, SALGRADE
    WHERE W.SAL AND LO
    W.DEPTNO=M.DEPTNO AND W.MGR=M.EMPNO;

WHERE SAL >= LOSAL AND SAL <= HISAL AND ENAME = 'SCOTT';











