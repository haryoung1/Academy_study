-- ★ ★ ★ ★ ★ book. xml ★ ★ ★ ★ ★
-- id = mainList (신간도서순 bookList)
SELECT * FROM BOOK ORDER BY BRDATE DESC;

-- id = bookList (startRow ~ endRow까지 bookList) 출력순서 : bTITLE 기준
SELECT *
    FROM (SELECT ROWNUM RN, A.*
        FROM (SELECT * FROM BOOK ORDER BY BTITLE DESC) A)
    WHERE RN BETWEEN 1 AND 2;

-- id = totCntBook (등록된 책 갯수)
SELECT COUNT(*) FROM BOOK;

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
SELECT * FROM MEMBER;

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