-- 친구 데이터 저장할 tables 생성
DROP TABLE FRIEND;
DROP SEQUENCE FRIEND_NO_SQ;
CREATE TABLE FRIEND(
    NO NUMBER(4) PRIMARY KEY,
    NAME VARCHAR2(20) NOT NULL,
    TEL VARCHAR2(30) UNIQUE
);
CREATE SEQUENCE FRIEND_NO_SQ MAXVALUE 9999 NOCACHE NOCYCLE;



-- 더미 데이터 insert
INSERT INTO FRIEND (NO,NAME,TEL) VALUES(FRIEND_NO_SQ.NEXTVAL,'홍길동','010-1234-1234');
INSERT INTO FRIEND (NO,NAME,TEL) VALUES(FRIEND_NO_SQ.NEXTVAL,'김길동','');
INSERT INTO FRIEND (NO,NAME,TEL) VALUES(FRIEND_NO_SQ.NEXTVAL,'갈길동',NULL);



-- DAO에 들어갈 query

INSERT INTO FRIEND (NO,NAME,TEL) VALUES(FRIEND_NO_SQ.NEXTVAL,'홍길동','010-1234-1234');
SELECT *FROM FRIEND;
COMMIT;