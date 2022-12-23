-- [ IV ] �������Լ�
-- �Լ� = �������Լ� + �׷��Լ� (�����Լ�)

SELECT HIREDATE, TO_CHAR (HIREDATE, 'YYYY-MM-DD')
    FROM EMP; -- ����
    
SELECT ENAME, INITCAP (ENAME)
    FROM EMP; -- �������Լ� (INPUT 1�� -> OUTPUT 1��)
    
SELECT SUM(SAL), AVG(SAL)
    FROM EMP; -- �׷��Լ� (INPUT n�� -> OUTPUT 1��)

 SELECT DEPTNO, AVG(SAL)
    FROM EMP GROUP BY DEPTNO;


-- �� ������ �Լ��� ���� : [����]�Լ�, [����]�Լ� [��¥]�Լ� [����ȯ]�Լ�, NVL(), ETC...
-- 1. ���ڰ����Լ�
    -- DUAL ���̺� : ����Ŭ���� ������ 1�� 1��¥�� DUMMY TABLE

SELECT *
    FROM DUAL;
    DESC DUAL;
    
SELECT *
    FROM DUMMY;
    DESC DUMMY;
    
SELECT ABS (-1)
    FROM DUMMY; -- ���밪

SELECT FLOOR(34.5678)
    FROM DUAL; -- �Ҽ����� ���� (5678)
    
SELECT FLOOR(34.5678*100)/100
    FROM DUAL;  -- �Ҽ��� �ι�°���� ����
    
SELECT TRUNC(34.5678,2)
    FROM DUAL; -- �Ҽ��� �ι�°���� ����

SELECT TRUNC(34.5678)
    FROM DUAL; -- �Ҽ������� ����

SELECT TRUNC(34.5678, -1)
    FROM DUAL; -- ���� �ڸ����� ����
    
    --. ex EMP ���̺��� �̸�, �޿� (���� �ڸ����� ����)
SELECT ENAME, SAL,TRUNC(SAL, -2)
    FROM EMP;

SELECT CEIL (34.5678)
    FROM DUAL; -- �Ҽ������� �ø�
    
SELECT ROUND (34.5678)
    FROM DUAL; -- �Ҽ������� �ݿø�
    
SELECT ROUND (34.5678, 2)
    FROM DUAL; -- �Ҽ��� �ι�° �ڸ����� �ݿø�

SELECT ROUND (34.5678/10)*10
    FROM DUAL; -- ���� �ڸ����� �ݿø�
    
    
SELECT MOD (9,2) 
    FROM DUAL; -- ������ ������
        
        --ex. Ȧ���⵵�� �Ի��� ����� ��� ���� ���
        
SELECT * 
    FROM EMP
    WHERE MOD (TO_CHAR (HIREDATE, 'RR'), 2) = 1;
    
-- 2. ���� ���� �Լ�
-- �� ��ҹ��� ����

SELECT INITCAP ('WELCOME TO ORACLE') -- ù ���ڸ� �빮�ڷ�
    FROM DUAL;

SELECT INITCAP ('welcome to oracle') -- ��ҹ��� ��ȯ ��Ʈ + ' 
    FROM DUAL;

SELECT UPPER ('ABCabc') -- ���� �빮�ڷ� 
    FROM DUAL;
    
SELECT LOWER ('ABCabc') -- ���� �ҹ��ڷ�
    FROM DUAL;
    
    -- ex. �̸��� Scott�� ������ ��� �ʵ�
SELECT *
    FROM EMP
    WHERE UPPER (ENAME) = 'SCOTT';

SELECT *
    FROM EMP
    WHERE INITCAP (ENAME) = 'SCOTT';
    
    -- ex. job�� MANAGER�� ������ ��� �ʵ�
SELECT *
    FROM EMP
    WHERE UPPER (JOB) = 'MANAGER';

SELECT *
    FROM EMP
    WHERE INITCAP (JOB) = 'Manager';

SELECT *
    FROM EMP
    WHERE LOWER (JOB) = 'manager';
    
-- �� ���ڿ��� (concat �Լ�, || ������)
SELECT 'AB'||'CD'||'EF'||'GH'
    FROM DUAL;
    
SELECT CONCAT (CONCAT('AB', 'CD'), CONCAT ('EF', 'GH'))
    FROM DUAL;
    
    -- EX. SMITH�� manager ��
SELECT CONCAT (CONCAT(ENAME, '��'), CONCAT (JOB, '��'))
    FROM EMP;

SELECT ENAME || '��' || JOB || '��'
    FROM EMP;




