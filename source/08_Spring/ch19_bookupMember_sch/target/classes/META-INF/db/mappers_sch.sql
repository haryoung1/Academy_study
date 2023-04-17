-- ★ ★ ★ ★ ★ book. xml ★ ★ ★ ★ ★
-- id = mainList (신간도서순 bookList)
SELECT * FROM BOOK ORDER BY BRDATE DESC;

-- id = bookList (startRow ~ endRow까지 schItem에 따라 schWord로 검색한 bookList) 출력순서 : bTITLE 기준
    -- (1) schItem이 null 이거나 '' 일때 (전체검색)
SELECT *
    FROM (SELECT ROWNUM RN, A.*
        FROM (SELECT * FROM BOOK ORDER BY BTITLE DESC) A)
    WHERE RN BETWEEN 1 AND 50;

    -- (2) schItem이 'all' 일때 (책이름 + 저자)
SELECT *
    FROM (SELECT ROWNUM RN, A.*
        FROM (SELECT * FROM BOOK WHERE BTITLE LIKE '%'||'J'||'%' OR BWRITER LIKE '%'||'J'||'%' ORDER BY BTITLE DESC) A)
    WHERE RN BETWEEN 1 AND 10;

    -- (3) schItem이 'btitle' 일때 (책이름)
SELECT *
    FROM (SELECT ROWNUM RN, A.*
        FROM (SELECT * FROM BOOK WHERE BTITLE LIKE '%'||'J'||'%' ORDER BY BTITLE DESC) A)
    WHERE RN BETWEEN 1 AND 10;
 
    -- (4) schItem이 'bwriter' 일때 (저자)
SELECT *
    FROM (SELECT ROWNUM RN, A.*
        FROM (SELECT * FROM BOOK WHERE BWRITER LIKE '%'||'강'||'%' ORDER BY BTITLE DESC) A)
    WHERE RN BETWEEN 1 AND 10; 
 
-- id = totCntBook (등록된 책 갯수)
    --(1) schItem이 null이거나 '' 일 때
SELECT COUNT(*) FROM BOOK;

    --(2) schItem이 'all' 일 때
SELECT COUNT(*) FROM BOOK WHERE BTITLE LIKE '%'||'J'||'%' OR BWRITER LIKE '%'||'J'||'%';

    --(3) schItem이 'btitle' 일 때
SELECT COUNT(*) FROM BOOK WHERE BTITLE LIKE '%'||'J'||'%';

    --(4) schItem이 'bwriter' 일 때
SELECT COUNT(*) FROM BOOK WHERE BWRITER LIKE '%'||'강'||'%';


-- id = getDetailBook (책번호로 dto 가져오기)
SELECT * FROM BOOK WHERE BNUM = 1;

-- id = registerBook (책등록)
INSERT INTO BOOK (bNUM, bTITLE, bWRITER, bRDATE, bIMG1, bIMG2, bINFO)
    VALUES (BOOK_SQ.NEXTVAL, '노래의 정석', '강성빈', SYSDATE, 'noImg.png', 'noImg.png', '나는 가수왕');
    
INSERT INTO BOOK (bNUM, bTITLE, bWRITER, bRDATE, bIMG1, bINFO)
    VALUES (BOOK_SQ.NEXTVAL, '발성의 정석', '강성민', SYSDATE, 'noImg.png', '나는 발성왕');
    
INSERT INTO BOOK (bNUM, bTITLE, bWRITER, bRDATE, bIMG2, bINFO)
    VALUES (BOOK_SQ.NEXTVAL, '두성의 정석', '강두왕', SYSDATE, 'noImg.png', '나는 두성왕');

INSERT INTO BOOK (bNUM, bTITLE, bWRITER, bRDATE,  bINFO)
    VALUES (BOOK_SQ.NEXTVAL, '흉성의 정석', '흉성킴', SYSDATE, '흉성이 궁금한가 ?');

-- id = modifyBook (책수정)
UPDATE BOOK
    SET BTITLE = '두성흉성가성',
        BWRITER = '강수정',
        BRDATE = '23/04/14',
        BIMG1 = 'noImg.png',
        BIMG2 = 'noImg.png',
        BINFO = '수정중입니다요'
    WHERE BNUM = '5';

-- ★ ★ ★ ★ ★ member.xml ★ ★ ★ ★ ★

-- id = idConfirm(mid가 id인 데이터 갯수)
SELECT COUNT(*) FROM MEMBER WHERE MID='aaa';    

-- id = joinMember(회원가입)
INSERT INTO MEMBER VALUES ('bbb','1','아이묭','myon@naver.com','67890','일본');

-- id = getDetailMember(mid로 Member dto 가져오기);
SELECT * FROM MEMBER WHERE MID = 'bbb';

-- id = modifyMember(회원정보 수정)
UPDATE MEMBER 
    SET MNAME = '강길동',
        MPW = '123',
        MMAIL = 'kang@naver.com',
        MPOST = '123456',
        MADDR = '서울'
    WHERE MID = 'aaa';
    
COMMIT;
SELECT * FROM MEMBER;
SELECT * FROM BOOK;