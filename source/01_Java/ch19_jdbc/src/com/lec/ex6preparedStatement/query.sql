-- (���, �̸�, ����̸�, �޿�, �޿����, ��� ���»���� CEO)
SELECT W.EMPNO, W.ENAME, NVL(M.ENAME, 'CEO')MANAGER, W.SAL, GRADE
    FROM EMP W, EMP M, DEPT D, SALGRADE
    WHERE W.MGR=M.EMPNO AND W.DEPTNO=D.DEPTNO 
    AND W.SAL BETWEEN LOSAL AND HISAL
    AND DNAME=UPPER ('sales');
    
    select * from dept;
    
    update dept set dname = 'loc', loc = 'seoul' where deptno = 40;
    
    
    UPDATE DEPT SET DNAME = 'MARKETING', LOC = 'INCHON' WHERE DEPTNO= 50;
 commit;
 rollback;