-- ★★ CustomerDao(아이디중복체크, 회원가입, 로그인, 상세보기, 정보수정, top-N 리스트, 회원수)

-- 1. 아이디 중복체크
SELECT * FROM CUSTOMER WHERE CID = 'aaaa';

-- 2. 회원가입
INSERT INTO CUSTOMER (CID, CPW, CNAME, CTEL, CEMAIL, CADDRESS, CGENDER, CBIRTH)
    VALUES ('aaaa', '111', '홍길동', '010-9999-9999', 'hong1@n.com', '서울시 종로구 17길', 'm',
            '1995-12-12');
-- 3. 로그인 
SELECT * FROM CUSTOMER WHERE CID = 'aaaa' AND CPW = '111';

-- 4. 상세보기 (CID로 DTO 가져오기, 로그인 성공시 session에 추가할 값)
SELECT * FROM CUSTOMER WHERE CID = 'bbb';

-- 5. 정보수정
UPDATE CUSTOMER SET CPW = '111',
                    CNAME = '강강강',
                    CTEL = '010-555-5555',
                    CEMAIL = 'Kang1@naver.com',
                    CADDRESS = '서울시 강서구',
                    CGENDER = 'f',
                    CBIRTH = '1994-08-25'
                WHERE CID = 'aaa';

-- 6. 회원리스트 보기
SELECT *
    FROM (SELECT ROWNUM RN, CID, CPW, CNAME, CEMAIL, CADDRESS
        FROM (SELECT * FROM CUSTOMER ORDER BY CID))
    WHERE RN BETWEEN 1 AND 2;

-- 7. 등록된 회원수
SELECT COUNT(*) TOTCNT FROM CUSTOMER;
SELECT * FROM CUSTOMER;

-- FileboardDao (top-N 리스트, 글갯수, 글쓰기(원글1, 답변글2), HIT올리기, 글상세보기, 글수정, 글삭제)
-- 1. 글목록 (top-N 리스트 : startRow, endRow)
    SELECT F.*, CNAME, CEMAIL
        FROM FILEBOARD F, CUSTOMER C
        WHERE F.CID = C.CID
        ORDER BY FREF DESC, FRE_STEP;

SELECT *
    FROM (SELECT ROWNUM RN, A.*
        FROM (SELECT F.*, CNAME, CEMAIL
                FROM FILEBOARD F, CUSTOMER C
                WHERE F.CID = C.CID
                ORDER BY FREF DESC, FRE_STEP) A)
    WHERE RN BETWEEN 1 AND 3;

-- 2. 글 갯수
SELECT COUNT(*) FROM FILEBOARD;
SELECT * FROM FILEBOARD;

-- 3. 원글쓰기 (원글1, 답변글2)
INSERT INTO FILEBOARD (fNUM, cID, fSUBJECT, fCONTENT, fFILENAME, fPW, fREF, fRE_STEP, fRE_LEVEL, fIP)
    VALUES (FILEBOARD_SEQ.NEXTVAL, 'aaa', '글3', '본문3', null, '111', 
            FILEBOARD_SEQ.CURRVAL, 0, 0, '192.168.0.1');
            
SELECT * FROM FILEBOARD WHERE FNUM = '4';

-- 4. 답변글 쓰기전 step A -- 4번글에 대한 답변글 쓰기 전작업
UPDATE FILEBOARD SET fRE_STEP = fRE_STEP + 1 WHERE fREF=4 AND fRE_STEP>0;

-- 5. 답변글 쓰기 -- 4번글의 답변
INSERT INTO FILEBOARD (fNUM, CID, fSUBJECT, fCONTENT, fFILENAME, fPW, fREF, fRE_STEP, fRE_LEVEL, fIP)
    VALUES (FILEBOARD_SEQ.NEXTVAL, 'bbb', '글1-답1', null,null, '1', 4, 1, 1, '192.1.1.1');

SELECT * FROM FILEBOARD WHERE fREF = 4 ORDER BY FRE_STEP; -- 4번 그룹 확인

-- 6. 글 상세보기(fnum으로 dto가져오기)
SELECT F.*, CNAME, CEMAIL 
    FROM FILEBOARD F, CUSTOMER C 
    WHERE F.CID=C.CID AND fNUM=4;

-- 7. 조회수 올리기
UPDATE FILEBOARD SET fHIT = fHIT+1 WHERE fNUM=4;

-- 8. 글 수정하기
UPDATE FILEBOARD SET fSUBJECT = '수정된 제목',
                    fCONTENT = '수정된 본문',
                    fFILENAME = NULL,
                    fPW = '111',
                    fIP = '192.168.10.30'
                WHERE fNUM=4;

-- 9. 글 삭제하기
COMMIT;
DELETE FROM FILEBOARD WHERE fNUM=1 AND fPW='1';
ROLLBACK;

-- BookDao (top-N 리스트, 책갯수, 책등록, 상세보기)
-- 1. 책목록
SELECT * FROM BOOK ORDER BY BRDATE DESC;
SELECT *
    FROM (SELECT ROWNUM RN, A.* FROM (SELECT * FROM BOOK ORDER BY BRDATE DESC) A)
    WHERE RN BETWEEN 2 AND 3;
    
-- 2. 책갯수
SELECT COUNT(*) CNT FROM BOOK;

-- 3. 책 등록
INSERT INTO BOOK (BID, BTITLE, BPRICE, BIMAGE1, BIMAGE2, BCONTENT, BDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '자바', '35000', 'noImg.png', 'NOTHING.JPG', '본문', '30');

-- 4. 상세보기
SELECT * FROM BOOK WHERE BID = 1;
SELECT * FROM BOOK;

--------------------
COMMIT;
SELECT * FROM CUSTOMER;
SELECT * FROM FILEBOARD;
SELECT * FROM BOOK;