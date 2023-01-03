-- [XI] �ε��� : ��ȸ�� ������ �ϴ� �ε���
SELECT * FROM USER_INDEXES;

DROP TABLE EMP01;

CREATE TABLE EMP01 -- EMP ���̺�� ���� ������ TABLE
    AS SELECT *
        FROM EMP;

SELECT * FROM EMP01; -- 14��

INSERT INTO EMP01 SELECT * FROM EMP01; -- �� �����ͻ�Ƣ�� 1�� (28) 2QJS (56��)
INSERT INTO EMP01 SELECT * FROM EMP01; -- �� 11�� ���� (11����)
INSERT INTO EMP01 (EMPNO, ENAME, DEPTNO) VALUES (1111, 'HONG', 40);
INSERT INTO EMP01 SELECT * FROM EMP01; -- 1�� (22��) 2�� (44��) 3�� (90��)

SELECT TO_CHAR (COUNT(*), '9,999,999') 
    FROM EMP01;
    
-- �ε��� ���� �� ��ȸ --
SELECT * FROM EMP01 
    WHERE ENAME = 'HONG'; -- �ε��� ������ ��ȸ �ð�

--�ε��� ����
CREATE INDEX IDX_EMP01_ENAMM -- 0.658��
    ON EMP01 (ENAME);

-- �ε��� ���� �� ��ȸ --
SELECT * FROM EMP01 
    WHERE ENAME = 'HONG'; -- �ε��� ���� �� ��ȸ�ð� 0.001��
COMMIT;

INSERT INTO EMP01 SELECT * FROM EMP01; -- �ε��� ���� �� 91�� -> 182������ INSERT �ð� : 32.016�� 30.52
SELECT TO_CHAR (COUNT(*), '9,999,999') 
    FROM EMP01;
    
ROLLBACK; -- 12.099��

DROP INDEX IDX_EMP01_ENAMM;

INSERT INTO EMP01 SELECT * FROM EMP01; -- �ε��� ������ 91�� -> 182������ INSERT �ð� : 3.077��

SELECT * FROM USER_INDEXES 
    WHERE TABLE_NAME = 'EMP01';
    
DROP TABLE EMP01; -- ���̺��� ����� �ش� ���̺��� �ε����� �ڵ� ����