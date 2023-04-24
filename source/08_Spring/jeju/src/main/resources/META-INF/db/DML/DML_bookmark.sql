------------------------------------------------------
--           BOOKMARK query            
------------------------------------------------------
-- (1) 북마크 (호텔) - hotelmark
INSERT INTO BOOKMARK (BOOKMARK_NO, MID, HNAME, RNAME, SNAME)
    VALUES (bookmarkNo_seq.NEXTVAL, 'kim', '호텔더원', null, null);
    
-- (2) 북마크 (식당) - reslmark
INSERT INTO BOOKMARK (BOOKMARK_NO, MID, HNAME, RNAME, SNAME)
    VALUES (bookmarkNo_seq.NEXTVAL, 'pham', null, '돈사돈', null);
    
-- (3) 북마크 (관광지) - spotmark
INSERT INTO BOOKMARK (BOOKMARK_NO, MID, HNAME, RNAME, SNAME)
    VALUES (bookmarkNo_seq.NEXTVAL, 'kim', null, null, '협재해수욕장');

-- (4) 북마크 해제 (호텔)
DELETE FROM BOOKMARK
    WHERE MID = 'aaa' AND HNAME = '호텔더원';

-- (5) 북마크 해제 (식당)
DELETE FROM BOOKMARK
    WHERE MID = 'pham' AND RNAME = '돈사돈';
    
-- (6) 북마크 해제 (관광지)
DELETE FROM BOOKMARK
    WHERE MID = 'kim' AND SNAME = '협재해수욕장';
    
-- (7) 북마크한 리스트 중 관광지만 보기 - bookmarkSpot
SELECT *
    FROM (SELECT ROWNUM RN, S.* FROM SPOT S, BOOKMARK B 
    WHERE S.SNAME = B.SNAME AND B.MID = 'kim' ORDER BY S.LOCATIONNO DESC) A;

-- (8) 북마크한 리스트 중 식당만 보기 - bookmarkRes
SELECT *
    FROM (SELECT ROWNUM RN, R.* FROM RESTAURANT R, BOOKMARK B 
    WHERE R.RNAME = B.RNAME AND B.MID = 'pham' ORDER BY R.LOCATIONNO DESC) A;
  
-- (9) 북마크한 리스트 중 호텔만 보기 - bookmarkHotel
SELECT *
    FROM (SELECT ROWNUM RN, H.* FROM HOTEL H, BOOKMARK B 
    WHERE H.HNAME = B.HNAME AND B.MID = 'aaa' ORDER BY H.LOCATIONNO DESC) A;
 
    
SELECT * FROM HOTEL;    
SELECT * FROM restaurant;
SELECT * FROM SPOT;
SELECT * FROM BOOKMARK;
COMMIT;