230110001 -- [ IV ] �������Լ�
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

-- 3. SUBSTR(STR, ������ġ, ���ڰ���):STR�� ������ġ���� ���ڰ�����ŭ ���� ���� (������ġ 1)
                            -- (������ġ�� 1����, ������ġ�� ������ ������ �ڸ����� ��)
    -- SUBSTRB (STR, ���۹���Ʈ ��ġ, ���ڹ���Ʈ��)
    
SELECT SUBSTR ('ORACLE', 3, 2) -- 3��° ���ں� 2���� ����
    FROM DUAL; -- DUAL < ��� FROM���� �� �ʼ��� ����ؾ��ϴ� ������ �ӽ����̺���
    
SELECT SUBSTRB ('ORACLE', 3, 2) -- 3��° ����Ʈ���� 2����Ʈ ����
    FROM DUAL;

SELECT SUBSTR ('�����ͺ��̽�', 4, 3) -- 4��°���� ���ں��� 3���� ����
    FROM DUAL;

SELECT SUBSTRB ('�����ͺ��̽�', 4,3) -- 4��° ����Ʈ���� 3����Ʈ ����
    FROM DUAL; -- �ѱ��� ���� 3byte 
    
    -- O R A C L E
    -- 1 2 3 4 5 6 (��ġ)
    -- -6 -5 -4 -3 -2 -1 (��ġ)

SELECT SUBSTR ('WELCOME TO ORACLE', -1, 1) -- -1��° ���ں��� �ѱ��� ����
    FROM DUAL;
    
SELECT SUBSTR ('ORACLE', -2, 2) -- ������ ���� 2���� ����
    FROM DUAL;

SELECT SUBSTR (123, 2, 1) -- ���� ���� (���ڸ� ���ڷ� �ٲ� 2��°���� 1���� ����)
    FROM DUAL;

    --ex. 9���� �Ի��� ����� ��� �ʵ� 'RR/MM/DD'
SELECT *
    FROM EMP
    WHERE SUBSTR (TO_CHAR (HIREDATE, 'RR/MM/DD'), 4, 2) = '09';
    
SELECT *
    FROM EMP
    WHERE SUBSTR (HIREDATE, 4, 2) = '09'; -- DATE���� ����
    
    --ex. 9�Ͽ� �Ի��� ����� ��� �ʵ� 'RR/MM/DD'
SELECT *
    FROM EMP
    WHERE SUBSTR (HIREDATE, -2, 2) = '09';

SELECT *
    FROM EMP
    WHERE SUBSTR (TO_CHAR(HIREDATE, 'RR/MM/DD'), -2, 2) = '09';
    
-- 4. LENGTH (STR) : STR�� ���ڼ�
 --   LENGTHB(STR) : STR�� ����Ʈ��
 
SELECT LENGTH ('ABCD') -- ���ڼ�
    FROM DUAL;

SELECT LENGTHB ('ABCD') -- ����Ʈ��
    FROM DUAL;
    
SELECT LENGTH ('����Ŭ') -- ��� : 3
    FROM DUAL;
    
SELECT LENGTHB ('����Ŭ') -- ��� : 9
    FROM DUAL;

-- 5. INSTR (STR, ã������) : STR���� ù��° ���ں��� ã�� ���ڰ� ������ ��ġ
    -- INSTR (STR, ã������, ������ġ) : STR���� ������ġ ���ں��� ã�����ڰ� ������ ��ġ
    
SELECT INSTR ('ABCABC', 'B') -- ó������ ã�Ƽ� ������ B�� ��ġ : 2 
    FROM DUAL;
    
SELECT INSTR ('ABCABC', 'B', 3) -- 3��° ���ں��� ã�Ƽ� ó�� ������ B�� ��ġ : 5
    FROM DUAL;

SELECT INSTR ('ABCABC', 'B', -3) -- �� 3��°���� �ڷ� ã�� ó�� ������ B�� ��ġ : 2
    FROM DUAL;

SELECT INSTR ('ABCABCABC', 'B', -3) -- �� 3��°���� �ڷ� ã�� ó�� ������ B��ġ : 5
    FROM DUAL;
    
    -- 9���� �Ի��� ��� (INSTR �̿�) 'RR/MM/DD'
SELECT *
    FROM EMP
    WHERE INSTR (HIREDATE, '09', 4) = 4;
  
SELECT *
    FROM EMP
    WHERE INSTR (TO_CHAR(HIREDATE, 'RR/MM/DD'), '09', 4) = 4;  
  
    -- 9�Ͽ� �Ի��� ��� (INSTR �̿�)
    -- 9�� �ƴ� �ٸ����� �Ի��� ����� ��� �ʵ� (INSTR �̿�)
  
SELECT *
    FROM EMP
    WHERE INSTR (HIREDATE, '09', 7) = 7;

SELECT *
    FROM EMP
    WHERE INSTR (HIREDATE, '09', 7) = 0;
  
-- 6. LPAD (STR, �ڸ���, ä�﹮��) : STR�� �ڸ�����ŭ Ȯ���ϰ� ���� ���ڸ��� ä�﹮�ڷ� ���
   -- LAPD (STR, �ڸ���) : STR�� �ڸ�����ŭ Ȯ���ϰ� ���� ���ڸ��� ' ' �� ���
   -- RPAD (STR, �ڸ���, ä�﹮��) : STR�� �ڸ�����ŭ Ȯ���ϰ� ������ ���ڸ��� ä�﹮�ڷ� ���
   -- RPAD (STR, �ڸ���) : STR�� �ڸ�����ŭ Ȯ���ϰ� ������ ���ڸ��� ' '�� ���
  
SELECT LPAD ('ORACLE', 10, '#')
    FROM DUAL;

SELECT RPAD ('ORACLE', 10, '*')
    FROM DUAL;
    
SELECT ENAME, SAL
    FROM EMP;
    
SELECT RPAD (ENAME, 11, '-'), LPAD (SAL, 6, '*')
    FROM EMP;
DESC EMP; -- �̸��� 10���ڱ��� SAL�� 5�ڸ����� �Է°���

    -- ex. ���, �̸�(7369 S**** / 7654 M***** / 7521 W*** ..)
    -- SUBSTR, LENGTH, RPAD 

SELECT EMPNO, RPAD (SUBSTR (ENAME, 1, 1), LENGTH(ENAME), '*') "NAME"
    FROM EMP;

    -- ex. ���, �̸�, ��å(9�ڸ�), �Ի��� -- LPAD, SUBSTR, LENGTH, || CONCAT, ...
    -- (7369 SMITH _____****K 80/12/**)
    
SELECT EMPNO, ENAME, LPAD (LPAD(SUBSTR(JOB, -1, 1), LENGTH(JOB), '*'), 9) JOB,
    SUBSTR (HIREDATE, 1,6) || '**'
    FROM EMP;

SELECT EMPNO, ENAME, LPAD (LPAD(SUBSTR(JOB, -1, 1), LENGTH(JOB), '*'), 9) JOB,
    TO_CHAR (HIREDATE, 'RR/MM/') || '**'
    FROM EMP;
    
    -- ex. �̸��� ����° �ڸ� ���ڰ� R�� ����� ��� �ʵ� ��� (LIKE, INSTR, SUBSTR �̿�)

SELECT *
    FROM EMP
    WHERE ENAME LIKE '__R%';
    
SELECT *
    FROM EMP
    WHERE INSTR (ENAME, 'R', 3) = 3; -- RARA���� ��µǱ� ���� 3��° ���ں��� �˻�

SELECT *
    FROM EMP
    WHERE SUBSTR (ENAME, 3, 1) = 'R'; -- RARA ��� ���� 3��°�� R�� �ֱ⶧����
    
-- 7. �������� : TRIM(STR), LTRIM(STR), RTRIM(STR)

SELECT '    ORACLE    ' MSG 
    FROM DUAL;

SELECT TRIM ('     ORACLE    ') MSG
    FROM DUAL;

SELECT LTRIM ('    ORACLE    ') MSG
    FROM DUAL;
    
SELECT RTRIM ('    ORACLE    ') MSG
    FROM DUAL;


-- 8. REPLACE (STR, �ٲ���ҹ���, �ٲܹ���) : STR���� �ٲ���� ���ڸ� �ٲ� ���ڷ� ��ü

SELECT REPLACE (ENAME, 'A', 'XX') NAME
    FROM EMP;

SELECT REPLACE (SAL, 0, 'X') SAL
    FROM EMP;
        
SELECT REPLACE (HIREDATE, '0', 'X')
    FROM EMP;

-- 3. ��¥ �����Լ� �� �����
-- (1) SYSDATE : ���� / SYSTIMESTAMP

SELECT SYSDATE NOW
    FROM DUAL;

SELECT SYSTIMESTAMP
    FROM DUAL;
    
ALTER SESSION SET NLS_DATE_FORMAT = 'RR/MM/DD HH24:MI:SS';
ALTER SESSION SET NLS_DATE_FORMAT = 'RR/MM/DD'; -- DATE ���� ���󺹱�

    -- ����Ŭ Ÿ�� : ����, ����, ��¥, �� �� ����, ��¥�� ���� ����

ALTER SESSION SET NLS_DATE_FORMAT = 'RR/MM/DD HH24:MI:SS';

SELECT SYSDATE -1 "���� �� �ð�", SYSDATE, SYSDATE +1 "���� �� �ð�"
    FROM DUAL;
    
ALTER SESSION SET NLS_DATE_FORMAT = 'RR/MM/DD'; -- ���󺹱�

    -- ex. �ݳ� ������
SELECT SYSDATE +14
    FROM DUAL;
    
    -- ex. ������ ~ �������
SELECT TRUNC (SYSDATE - TO_DATE ('22/11/28 09:30 ', 'RR/MM/DD HH24:MI')) DAY
    FROM DUAL;

    -- ex. ���� ~ �����ϱ��� ���� ���Ҵ���?
SELECT TRUNC (TO_DATE ('230512 12:20', 'RRMMDD HH24:MI') - SYSDATE) DAY
    FROM DUAL;
    
    -- ex. EMP���� �̸�, �Ի���, �ٹ��ϼ�
SELECT ENAME, HIREDATE, TRUNC (SYSDATE - HIREDATE) DAY
    FROM EMP;

    -- ex. EMP���� �̸�, �Ի���, �ٹ��ϼ�, �ٹ��ּ�(������7), �ٹ����
SELECT ENAME, HIREDATE, TRUNC (SYSDATE - HIREDATE) DAY,
    TRUNC ((SYSDATE - HIREDATE) /7) WEEK, TRUNC ((SYSDATE-HIREDATE) /365) YEAR
    FROM EMP;

-- (2) MONTHS_BETWEEN (����1, ����2) : �� �������� ������ (����1�� ū ����)
    -- ex. �̸�, �Ի���, �ٹ�����
SELECT ENAME, HIREDATE, TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)) MONTH
    FROM EMP;

    -- ex. �̸�, �Ի��� ���� ȸ�翡�� ���� �� (SAL�� 1�⿡ 12��, COMM�� 2��)�� ���
SELECT ENAME, SAL* TRUNC (MONTHS_BETWEEN (SYSDATE, HIREDATE))+
    NVL(COMM,0)*2*TRUNC ((SYSDATE-HIREDATE) /365) MONTHS
    FROM EMP;

-- 4. ADD_MONTHS (Ư�� ����, ������) : Ư���������� ��� ��
    -- ex. �̸�, �Ի���, �������� ���� (�����Ⱓ 6����)
SELECT ENAME, HIREDATE, ADD_MONTHS(HIREDATE, 6) ����
    FROM EMP;

    -- �Ի����� 81/08/30 �̸� ���� ������� 81/02/28
INSERT INTO EMP VALUES (9999, 'KANG', 'KING2', NULL, '81/08/30', NULL, NULL, 40);
ROLLBACK;

-- 5. NEXT_DAY (Ư������, '��') : Ư���������� ó�� �����ϴ� ������
SELECT NEXT_DAY (SYSDATE, '��') DAY
    FROM DUAL;

-- 6. LAST_DAY (Ư������) : Ư�������� �� (28,29,30,31)
SELECT LAST_DAY(SYSDATE)
 FROM DUAL;
 
    -- ex. �̸�, �Ի���, ù���޳� (���޳��� ����)
SELECT ENAME, HIREDATE, LAST_DAY (HIREDATE)
    FROM EMP;
    
-- 7. ROUND (��¥, XX) : ��¥ �ݿø� (xx: YEAR, MONTH, DAY)
  --  TRUNC (��¥, XX) : ��¥ ����
SELECT ROUND (34.5678, 2)
    FROM DUAL;
    
SELECT ROUND (SYSDATE, 'YEAR') -- �ݿø��� ������ �� ���������� ��. �۳� OR ����
    FROM DUAL;

SELECT ROUND (SYSDATE, 'MONTH') -- ��� : ����� 1�� (1~15�ϱ����� �̹��� 1��)
    FROM DUAL;                  -- ��� : 16�� ���ʹ� ������ 1��
    
SELECT ROUND (SYSDATE, 'DAY')   -- ��� : ����� �Ͽ���.
    FROM DUAL;

SELECT ROUND (SYSDATE) -- ��� : ����� 0��0��
    FROM DUAL;

SELECT TRUNC (SYSDATE, 'YEAR') -- ������ 1�� 1��
    FROM DUAL;

SELECT TRUNC (SYSDATE, 'MONTH') -- ������ 1��
    FROM DUAL;

SELECT TRUNC (SYSDATE, 'DAY') -- ���� �Ͽ���
    FROM DUAL;
    
SELECT TO_CHAR (TRUNC (SYSDATE), 'RR/MM/DD HH24:MI')
    FROM DUAL;
    
    -- ex. �̸�, �Ի��� ,ù���޳� (11��) : 10�� ���� : �̹��� 11 / 11�� ���ĸ� ������ 11��
        -- ROUND�� ������ 15,16�� => 10,11��
        -- ��� : ����� 1�� (1~15�ϱ����� �̹��� 1��)
SELECT ENAME, HIREDATE, ROUND(HIREDATE+5, 'MONTH') + 10 -- ���޳� 11��
    FROM EMP;
    -- ex. ���޳� 10�� : 9�ϱ����� �̹���, 10�Ϻ��ʹ� ������
SELECT ENAME, HIREDATE, ROUND(HIREDATE+6, 'MONTH') + 9 -- ���޳� 25��
    FROM EMP;
    -- ex. ���޳� 10�� : 24�ϱ����� �̹���, 25�Ϻ��ʹ� ������
SELECT ENAME, HIREDATE, ROUND(HIREDATE-9, 'MONTH') + 24 -- ���޳� 25��
    FROM EMP;


-- 4. ����ȯ �Լ� (TO_CHAR : ���ڷ� ��ȯ�ϴ� �Լ�, TO_DATE: ��¥������ ��ȯ�ϴ� �Լ�)
    -- (1) TO_CHAR (��¥��, '�������')
    -- YYYY �⵵ 4�ڸ� / RR �⵵ 2�ڸ� / MM �� / DD �� / DY ����
    -- HH24 / HH12 / AM�̳� PM / MI �� / SS ��
    -- ������Ŀ� ���ڸ� ���� �� ��� ""
    
SELECT ENAME, TO_CHAR (HIREDATE, 'YYYY-MM-DD HH24:MI:SS')
    FROM EMP;

SELECT TO_CHAR (SYSDATE, 'YYYY"��" MM"��" DD "��" DY"����" AM HH12"��" MI"��" SS"��"') "���� �ð�"
    FROM DUAL;
    
SELECT TO_CHAR (SYSTIMESTAMP, 'RR-MM-DD AM HH12:MI:SS:FF') "���� �ð�2"
    FROM DUAL;
    
-- (2) TO_CHAR (����, '�������')
    -- 0 : �ڸ���, ��������� �ڸ����� ������ 0���� ä��
    -- 9 : �ڸ���, ��������� �ڸ����� ���Ƶ� ���ڸ�ŭ�� ���
    -- , : ���ڸ����� , ����
    -- . : �Ҽ���
    -- $ : ��ȭ���� $ �߰�
    -- L : ������ȭ������ �߰�
    
SELECT TO_CHAR (12345678, '0,000,000,000.00') -- 012,345,678
    FROM DUAL;
    
SELECT TO_CHAR (12345678, '9,999,999,999.99') -- 12,345,678
    FROM DUAL;

SELECT TO_CHAR (100.76, '999.9') -- �Ҽ��� �ڸ����� ������ ��� �ݿø�
    FROM DUAL;
    
SELECT TO_CHAR (1200, 'L9,999') 
    FROM DUAL;
    
DESC EMP; -- SAL NUMBER (7,2) ��ü �ڸ����� 7�ڸ�

SELECT ENAME, SAL, TO_CHAR (SAL, '$99,999')
    FROM EMP;
    
-- (3) TO_DATE (����, '����')
SELECT TO_DATE ('20221227 14:53', 'YYYYMMDD HH24:MI')
    FROM DUAL;
    
    -- 81/5/1 ~ 83/5/1 ���̿� �Ի��� ������ ��� �ʵ�
SELECT *
    FROM EMP
    WHERE HIREDATE BETWEEN TO_DATE('81/05/01', 'RR/MM/DD')
    AND TO_DATE('83/05/01', 'RR/MM/DD');
    
-- (4) TO_NUMBER (����, "����")
SELECT '3456' +1 "NUMBER"
    FROM DUAL;
    
SELECT TO_NUMBER ('3,456', '9,999')+ 1 "NUMBER"
    FROM DUAL;

-- 5. NVL (NULL �� ���� �ִ� ������, NULL�̸� ��� �� ��) - �Ű����� 2���� Ÿ�� ��ġ
    -- ex. ����̸�, ���ӻ�� �̸� (���ӻ�簡 ������ CEO�� ���)
SELECT W.ENAME, NVL (M.ENAME, 'CEO') "MGR"
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO(+);

    -- ex. ����̸�, ���ӻ���� ��� (���ӻ�簡 ������ 'CEO'�� ���)
SELECT ENAME, NVL(TO_CHAR (MGR), 'CEO') "MGR"
    FROM EMP;
DESC EMP;


-- 6. ETC 
 -- (1) EXTRACT : �⵵, ��, �ϸ� ���� �ϰ��� �� ��
SELECT HIREDATE, EXTRACT (YEAR FROM HIREDATE) -- �⵵�� ���ڷ� ����
    FROM EMP;

SELECT HIREDATE, TO_CHAR (HIREDATE, 'YYYY') -- �⵵ 4�ڸ��� ���ڷ� ������
    FROM EMP;
 
SELECT SYSDATE, EXTRACT (MONTH FROM SYSDATE) -- ���� ���ڷ� ����
    FROM DUAL;
    
SELECT SYSDATE, TO_CHAR (SYSDATE, 'MM') -- �� 2�ڸ��� ���ڷ� ����
    FROM DUAL;
    
SELECT SYSDATE, EXTRACT (DAY FROM SYSDATE) -- �ϸ� ���ڷ� ���� 
    FROM DUAL;
    
SELECT SYSDATE, TO_CHAR (SYSDATE, 'DD') -- �� ���ڸ���  ���ڷ� ���� 
    FROM DUAL;
    
 -- (2) ������ ��� 
SELECT LPAD('��', LEVEL*2) || ENAME
    FROM EMP
    START WITH MGR IS NULL
    CONNECT BY PRIOR EMPNO = MGR;

-- <�� ��������>
-- 1. ���� ��¥�� ����ϰ� TITLE�� ��Current Date���� ����ϴ� SELECT ������ ����Ͻÿ�.
SELECT SYSDATE "Current Date"
    FROM DUAL;
    
-- 2. EMP ���̺��� ���� �޿��� 15%�� ������ �޿��� ����Ͽ�,
-- �����ȣ,�̸�,����,�޿�,������ �޿�(New Salary),������(Increase)�� ����ϴ� SELECT ����
SELECT EMPNO, ENAME, JOB, SAL, SAL*1.15 "New Salary", SAL*0.15  Increase
    FROM EMP;

--3. �̸�, �Ի���, �Ի��Ϸκ��� 6���� �� ���ƿ��� ������ ���Ͽ� ����ϴ� SELECT ������ ����Ͻÿ�.
SELECT ENAME, HIREDATE, NEXT_DAY (ADD_MONTHS (HIREDATE, 6), '��') 
    FROM EMP;
    
--4. �̸�, �Ի���, �Ի��Ϸκ��� ��������� ������, �޿�, �Ի��Ϻ��� ��������� ���� �޿��� �Ѱ踦 ���
SELECT ENAME, HIREDATE, TRUNC(MONTHS_BETWEEN (SYSDATE, HIREDATE)) MONTH,
    SAL* TRUNC (MONTHS_BETWEEN (SYSDATE, HIREDATE)) "ALL SAL"
    FROM EMP;

--5. ��� ����� �̸��� �޿�(15�ڸ��� ��� ������ �� ���� ��*���� ��ġ)�� ���
SELECT LPAD (ENAME, 15, '*')NAME, LPAD (SAL, 15, '*') SAL
    FROM EMP;
    
--6. ��� ����� ������ �̸�,����,�Ի���,�Ի��� ������ ����ϴ� SELECT ������ ����Ͻÿ�.
SELECT ENAME, JOB, HIREDATE, TO_CHAR (HIREDATE, 'DY') "�Ի����"
    FROM EMP;

--7. �̸��� ���̰� 6�� �̻��� ����� ������ �̸�,�̸��� ���ڼ�,������ ���
SELECT LENGTH(ENAME), ENAME, JOB
    FROM EMP
    WHERE LENGTH (ENAME) >= 6;
    
--8. ��� ����� ������ �̸�, ����, �޿�, ���ʽ�, �޿�+���ʽ��� ���
SELECT ENAME, JOB, SAL, COMM, SAL+NVL(COMM,0) "SAL+BONUS"
    FROM EMP;
    
-- 9.��� ���̺��� ������� 2��° ���ں��� 3���� ���ڸ� �����Ͻÿ�. 
SELECT ENAME, SUBSTR (ENAME, 2, 3)
    FROM EMP;

--10. ��� ���̺��� �Ի����� 12���� ����� ���, �����, �Ի����� �˻��Ͻÿ�. 
--  �ý��ۿ� ���� DATEFORMAT �ٸ� �� �����Ƿ� �Ʒ��� ����� �˾ƺ���
SELECT EMPNO, ENAME, HIREDATE
    FROM EMP
    WHERE INSTR (HIREDATE, '12', 4) = 4;


--11. ������ ���� ����� �˻��� �� �ִ� SQL ������ �ۼ��Ͻÿ�
--EMPNO		ENAME		�޿�
--7369		       SMITH		*******800
--7499		       ALLEN		******1600
--7521		       WARD		    ******1250
--����. 
SELECT LPAD (EMPNO, 6, '-') "--EMPNO", ENAME, LPAD (SAL, 10, '*') "�޿�"
    FROM EMP;


-- 12. ������ ���� ����� �˻��� �� �ִ� SQL ������ �ۼ��Ͻÿ�
-- EMPNO	 ENAME 	�Ի���
-- 7369	  SMITH		1980-12-17
-- ��.
SELECT LPAD (EMPNO, 6, '-') "--EMPNO", ENAME, TO_CHAR(HIREDATE, 'YYYY/MM/DD') "�Ի���"
    FROM EMP;
    
--13. ��� ���̺��� �μ� ��ȣ�� 20�� ����� ���, �̸�, ����, �޿��� ����Ͻÿ�.
    --(�޿��� �տ� $�� �����ϰ�3�ڸ����� ,�� ����Ѵ�)
SELECT DEPTNO, EMPNO, ENAME, JOB, TO_CHAR (SAL, '$99,999') SAL
    FROM EMP
    WHERE DEPTNO = 20;
    
    
SELECT * FROM EMP;