-- ���α׷� �䱸���׿� �ʿ��� DML
-- ��ɺ� query �ۼ� (1, 2, 3)

-- 1�� : �̸�, ������, ����,����,���������� �Է� �޾� �����ͺ��̽��� ��ȣ�� �����Ͽ� �Է�
INSERT INTO Person VALUES (PERSON_NO_SQ.NEXTVAL, 'ȫ�浿',
    (SELECT JNO FROM JOB WHERE JNAME ='���'), 81,83,85);

-- 2�� : �������� �Է� �޾�, ������ ��ȸ �� ������ �߰�, ������ ���� ������ �̸�(��ȣ)�� ���
SELECT PNAME || '('||PNO||'��)' PNAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM
    FROM Person P, JOB J
    WHERE P.JNO=J.JNO AND JNAME = '���'
    ORDER BY SUM DESC;

SELECT ROWNUM RANK, A.*
    FROM (SELECT PNAME || '('||PNO||'��)' PNAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM
         FROM Person P, JOB J WHERE P.JNO=J.JNO AND JNAME = '���' ORDER BY SUM DESC) A;

SELECT ROWNUM RANK, A.*
    FROM (SELECT PNAME || '('||PNO||')' PNAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM
         FROM Person P, JOB J WHERE P.JNO=J.JNO AND JNAME = '���' ORDER BY SUM DESC) A;

-- 3�� : ��� ���� ���, �̸�(pNO),������,����(kor),����(eng),����(mat),������ ���(������������ �������� ����)

SELECT ROWNUM RANK, A.*
    FROM (SELECT PNAME || '('||PNO||'��)' PNAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM
        FROM Person P, JOB J WHERE P.JNO=J.JNO ORDER BY SUM DESC)A;

-- 1���� 2�� ��ɿ��� ���� ������ ������ list
SELECT JNAME FROM JOB;
SELECT * FROM JOB;
