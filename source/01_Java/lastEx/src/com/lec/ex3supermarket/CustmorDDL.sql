-- 프로그램에 필요한 QUERY
-- 1. 회원가입 (PHONE, CNAME 입력 받아 INSERT)
INSERT INTO CUSTOMER VALUES (CUS_NO_SQ.NEXTVAL, '홍길동', '010-9999-9999',1000,0,1);
INSERT INTO CUSTOMER (CNO,PHONE,CNAME) VALUES (CUS_NO_SQ.NEXTVAL, '010-5555-5555', '김길동');
ROLLBACK;
-- 2. 폰뒤4자리(FULL) 검색 (PHONE 입력 받고, cno,phone,cname,POINT,amount,levelname,forlevelup)
-- public ArrayList<CustomerDto> phoneGetCustomers(String searchTel)
SELECT CNO, PHONE, CNAME, POINT, AMOUNT, LEVELNAME, 
       MONEY2+1-AMOUNT forlevelup
    FROM CUSTOMER C, CUS_LEVEL L
    WHERE C.LEVELNO=L.LEVELNO; -- 최고 레벨 경우에 잘못 나옴

SELECT CNAME, AMOUNT, MONEY2+1-AMOUNT,
    (SELECT MONEY2+1-AMOUNT FROM CUSTOMER WHERE LEVELNO!=5 AND CNO=C.CNO)"DD"
    FROM CUSTOMER C, CUS_LEVEL L
    WHERE C.LEVELNO=L.LEVELNO; -- 이용할 서브쿼리 만들기

SELECT CNO, PHONE, CNAME, POINT, AMOUNT, LEVELNAME, 
    (SELECT MONEY2+1-AMOUNT FROM CUSTOMER WHERE LEVELNO!=5 AND CNO=C.CNO) NextLevelUp
    FROM CUSTOMER C, CUS_LEVEL L
    WHERE C.LEVELNO=L.LEVELNO AND PHONE LIKE '%'||'5555'; -- DAO에 들어갈 QUERY
    
-- 3. 물품구입 (cno, price 입력받아 update: point,amount, levelno update)
    -- public int buy(int cno, int price)
    -- 1단계 POINT, AMOUNT 수정
UPDATE CUSTOMER 
    SET POINT = POINT + (1000000*0.05),
    AMOUNT = AMOUNT + 1000000
    WHERE CNO = 7; -- CNO가 1번인 데이터가 100만원어치 물건 구입
    
    -- 2단계 : 수정된 AMOUNT에 따라 LEVELNO 조정
SELECT CNAME, AMOUNT, C.LEVELNO 현레벨, L.LEVELNO 바뀔레벨, MONEY, MONEY2
    FROM CUSTOMER C, CUS_LEVEL L
    WHERE AMOUNT BETWEEN MONEY AND MONEY2;
    
SELECT L.LEVELNO
    FROM CUSTOMER C, CUS_LEVEL L
    WHERE AMOUNT BETWEEN MONEY AND MONEY2 AND CNO=7; -- CNO가 1인 데이터의 바뀔레벨만 가져오기 1단계
    
 UPDATE CUSTOMER
    SET LEVELNO = (SELECT L.LEVELNO 
                    FROM CUSTOMER C, CUS_LEVEL L
                    WHERE AMOUNT BETWEEN MONEY AND MONEY2 AND CNO=7)
    WHERE CNO =7; -- LEVELNO 수정 2단계
    
    
    -- DAO에 들어갈 QUERY 완성 (1단계 + 2단계)
UPDATE CUSTOMER 
    SET POINT = POINT + (1000000*0.05),
    AMOUNT = AMOUNT + 1000000,
    LEVELNO = (SELECT L.LEVELNO 
                    FROM CUSTOMER C, CUS_LEVEL L
                    WHERE AMOUNT+1000000 BETWEEN MONEY AND MONEY2 
                          AND CNO=7)
    WHERE CNO = 7; -- 최종단계
   COMMIT;
SELECT * FROM CUSTOMER WHERE CNO = 7;

-- 3번 후 바뀐 고객 정보를 출력 (cno, phone, cname, POINT, amount, levelname,forlevelup)
    -- public CustomerDto getCustomer(int cid)
SELECT CNO, PHONE, CNAME, POINT, AMOUNT, LEVELNAME, 
    (SELECT MONEY2+1-AMOUNT FROM CUSTOMER WHERE LEVELNO!=5 AND CNO=C.CNO) NextLevelUp
    FROM CUSTOMER C, CUS_LEVEL L
    WHERE C.LEVELNO=L.LEVELNO AND CNO=7;
    
-- 4번 전 고객등급명들 추출
    -- public ArrayList<String> getLevelNames()
SELECT LEVELNAME FROM CUS_LEVEL;

-- 4. 고객 등급별 출력 (levelname을 입력 받아 cno,phone,cname,POINT,amount,levelname,forlevelup 출력)
    -- public ArrayList<CustomerDto> levelNameGetCustomers (String levelName)
SELECT CNO, PHONE, CNAME, POINT, AMOUNT, LEVELNAME, 
    (SELECT MONEY2+1-AMOUNT FROM CUSTOMER WHERE LEVELNO!=5 AND CNO=C.CNO) NextLevelUp
    FROM CUSTOMER C, CUS_LEVEL L
    WHERE C.LEVELNO=L.LEVELNO AND LEVELNAME = 'VVIP'
    ORDER BY AMOUNT DESC;
    
-- 5. 고객 전체 출력
    -- (cno,phone,cname,POINT,amount,levelname,forlevelup 출력)
    -- pulbic ArrayList<CustomerDto> getCustomers();
SELECT CNO, PHONE, CNAME, POINT, AMOUNT, LEVELNAME, 
    (SELECT MONEY2+1-AMOUNT FROM CUSTOMER WHERE LEVELNO!=5 AND CNO=C.CNO) NextLevelUp
    FROM CUSTOMER C, CUS_LEVEL L
    WHERE C.LEVELNO=L.LEVELNO 
    ORDER BY AMOUNT DESC;
    
-- 6. 회원탈퇴 (phone을 입력 받아 delete)
    -- pulbic int deleteCustomer (String phone)
DELETE FROM CUSTOMER WHERE PHONE = '010-2222-2222';
COMMIT;

select * from customer;



























