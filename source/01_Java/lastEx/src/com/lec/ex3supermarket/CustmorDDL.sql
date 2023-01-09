-- ���α׷��� �ʿ��� QUERY
-- 1. ȸ������ (PHONE, CNAME �Է� �޾� INSERT)
INSERT INTO CUSTOMER VALUES (CUS_NO_SQ.NEXTVAL, 'ȫ�浿', '010-9999-9999',1000,0,1);
INSERT INTO CUSTOMER (CNO,PHONE,CNAME) VALUES (CUS_NO_SQ.NEXTVAL, '010-5555-5555', '��浿');
ROLLBACK;
-- 2. ����4�ڸ�(FULL) �˻� (PHONE �Է� �ް�, cno,phone,cname,POINT,amount,levelname,forlevelup)
-- public ArrayList<CustomerDto> phoneGetCustomers(String searchTel)
SELECT CNO, PHONE, CNAME, POINT, AMOUNT, LEVELNAME, 
       MONEY2+1-AMOUNT forlevelup
    FROM CUSTOMER C, CUS_LEVEL L
    WHERE C.LEVELNO=L.LEVELNO; -- �ְ� ���� ��쿡 �߸� ����

SELECT CNAME, AMOUNT, MONEY2+1-AMOUNT,
    (SELECT MONEY2+1-AMOUNT FROM CUSTOMER WHERE LEVELNO!=5 AND CNO=C.CNO)"DD"
    FROM CUSTOMER C, CUS_LEVEL L
    WHERE C.LEVELNO=L.LEVELNO; -- �̿��� �������� �����

SELECT CNO, PHONE, CNAME, POINT, AMOUNT, LEVELNAME, 
    (SELECT MONEY2+1-AMOUNT FROM CUSTOMER WHERE LEVELNO!=5 AND CNO=C.CNO) NextLevelUp
    FROM CUSTOMER C, CUS_LEVEL L
    WHERE C.LEVELNO=L.LEVELNO AND PHONE LIKE '%'||'5555'; -- DAO�� �� QUERY
    
-- 3. ��ǰ���� (cno, price �Է¹޾� update: point,amount, levelno update)
    -- public int buy(int cno, int price)
    -- 1�ܰ� POINT, AMOUNT ����
UPDATE CUSTOMER 
    SET POINT = POINT + (1000000*0.05),
    AMOUNT = AMOUNT + 1000000
    WHERE CNO = 7; -- CNO�� 1���� �����Ͱ� 100������ġ ���� ����
    
    -- 2�ܰ� : ������ AMOUNT�� ���� LEVELNO ����
SELECT CNAME, AMOUNT, C.LEVELNO ������, L.LEVELNO �ٲ𷹺�, MONEY, MONEY2
    FROM CUSTOMER C, CUS_LEVEL L
    WHERE AMOUNT BETWEEN MONEY AND MONEY2;
    
SELECT L.LEVELNO
    FROM CUSTOMER C, CUS_LEVEL L
    WHERE AMOUNT BETWEEN MONEY AND MONEY2 AND CNO=7; -- CNO�� 1�� �������� �ٲ𷹺��� �������� 1�ܰ�
    
 UPDATE CUSTOMER
    SET LEVELNO = (SELECT L.LEVELNO 
                    FROM CUSTOMER C, CUS_LEVEL L
                    WHERE AMOUNT BETWEEN MONEY AND MONEY2 AND CNO=7)
    WHERE CNO =7; -- LEVELNO ���� 2�ܰ�
    
    
    -- DAO�� �� QUERY �ϼ� (1�ܰ� + 2�ܰ�)
UPDATE CUSTOMER 
    SET POINT = POINT + (1000000*0.05),
    AMOUNT = AMOUNT + 1000000,
    LEVELNO = (SELECT L.LEVELNO 
                    FROM CUSTOMER C, CUS_LEVEL L
                    WHERE AMOUNT+1000000 BETWEEN MONEY AND MONEY2 
                          AND CNO=7)
    WHERE CNO = 7; -- �����ܰ�
   COMMIT;
SELECT * FROM CUSTOMER WHERE CNO = 7;

-- 3�� �� �ٲ� �� ������ ��� (cno, phone, cname, POINT, amount, levelname,forlevelup)
    -- public CustomerDto getCustomer(int cid)
SELECT CNO, PHONE, CNAME, POINT, AMOUNT, LEVELNAME, 
    (SELECT MONEY2+1-AMOUNT FROM CUSTOMER WHERE LEVELNO!=5 AND CNO=C.CNO) NextLevelUp
    FROM CUSTOMER C, CUS_LEVEL L
    WHERE C.LEVELNO=L.LEVELNO AND CNO=7;
    
-- 4�� �� ����޸�� ����
    -- public ArrayList<String> getLevelNames()
SELECT LEVELNAME FROM CUS_LEVEL;

-- 4. �� ��޺� ��� (levelname�� �Է� �޾� cno,phone,cname,POINT,amount,levelname,forlevelup ���)
    -- public ArrayList<CustomerDto> levelNameGetCustomers (String levelName)
SELECT CNO, PHONE, CNAME, POINT, AMOUNT, LEVELNAME, 
    (SELECT MONEY2+1-AMOUNT FROM CUSTOMER WHERE LEVELNO!=5 AND CNO=C.CNO) NextLevelUp
    FROM CUSTOMER C, CUS_LEVEL L
    WHERE C.LEVELNO=L.LEVELNO AND LEVELNAME = 'VVIP'
    ORDER BY AMOUNT DESC;
    
-- 5. �� ��ü ���
    -- (cno,phone,cname,POINT,amount,levelname,forlevelup ���)
    -- pulbic ArrayList<CustomerDto> getCustomers();
SELECT CNO, PHONE, CNAME, POINT, AMOUNT, LEVELNAME, 
    (SELECT MONEY2+1-AMOUNT FROM CUSTOMER WHERE LEVELNO!=5 AND CNO=C.CNO) NextLevelUp
    FROM CUSTOMER C, CUS_LEVEL L
    WHERE C.LEVELNO=L.LEVELNO 
    ORDER BY AMOUNT DESC;
    
-- 6. ȸ��Ż�� (phone�� �Է� �޾� delete)
    -- pulbic int deleteCustomer (String phone)
DELETE FROM CUSTOMER WHERE PHONE = '010-2222-2222';
COMMIT;

select * from customer;



























