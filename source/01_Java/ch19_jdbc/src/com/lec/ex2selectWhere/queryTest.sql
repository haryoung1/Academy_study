-- EX1 �μ���ȣ �ް� �μ����� ����ϱ�
SELECT * FROM DEPT WHERE DEPTNO=40;

-- EX2 �μ���ȣ �ް� �μ������� ������� ��� (���,�̸�,�޿�,����)
SELECT * FROM DEPT WHERE DEPTNO=40;
SELECT W.EMPNO, W.ENAME, W.SAL, M.ENAME MANAGER
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO AND W.DEPTNO = 10;
    
-- EX3 �μ��̸��� �Է� �޾� �μ����� ���
SELECT * FROM DEPT WHERE DNAME = UPPER ('sales');

-- EX4