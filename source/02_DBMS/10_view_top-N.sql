-- [X] VIEW, IN-LINE VIEW, ★TOP-N★
-- 1. VIEW : 가상의 테이블 (1)단순뷰 (2) 복합뷰
--(1) : 하나의 테이블을 이용해서 만든 뷰 (가상의 테이블은 물리공간과 데이터가 따로 없음)
CREATE OR REPLACE VIEW EMPv0 --EMP 테이블에서 특정필드만 VIEW로 생성
    AS SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, DEPTNO FROM EMP;

SELECT *FROM EMP;
SELECT * FROM EMPv0;
SELECT * FROM TAB; -- 내 계정이 갖고 있는 테이블들(가상의 테이블 포함)
SELECT * FROM USER_TABLES; -- 내 계정이 갖고 있는 테이블(가상의 테이블 미포함)
SELECT * FROM USER_VIEWS;

INSERT INTO EMPV0 VALUES (1111, 'HONG','MANAGER',NULL, NULL, 40);--뷰에 INSERT
SELECT * FROM EMPv0;
SELECT * FROM EMP;
ROLLBACK;

CREATE OR REPLACE VIEW EMPv0 -- EMP테이블에서 특정 행(ROW)만 VIEW로 생성
    AS SELECT * FROM EMP WHERE DEPTNO=30;
SELECT *FROM EMPv0;
INSERT INTO EMPv0 VALUES(1111, '홍', 'MANAGER', NULL,NULL, 9000, NULL, 40); -- 가능
SELECT * FROM EMPv0; --1111사원 안보임
SELECT * FROM EMP; -- 1111 사원 보임

--단순뷰에서 INSERT가 불가한 경우 : 뷰 생성시 NOT NULL 필드를 미포함 경우
CREATE OR REPLACE VIEW EMPV0
    AS SELECT ENAME, JOB FROM EMP;
SELECT * FROM EMPv0;
INSERT INTO EMPv0 VALUES ('홍','MANAGER');
DELETE FROM EMP WHERE EMPNO=1111;

--VEIW의 제한 조건
-- WITH CHECK OPTION 추가 : 뷰의 조건에 해당되는 데이터만 삽입, 수정, 삭제가 가능
-- WITH READ ONLY 추가 : 읽기 전용 뷰
CREATE OR REPLACE VIEW EMPv0
    AS SELECT * FROM EMP WHERE DEPTNO=30
    WITH CHECK OPTION;
SELECT * FROM EMPV0;
INSERT INTO EMPv0 (EMPNO, ENAME, DEPTNO )VALUES(1111,'홍',30);--가능
INSERT INTO EMPv0 (EMPNO, ENAME, DEPTNO )VALUES(1112,'박',40);--VIEW 제한조건으로 에러
SELECT * FROM EMP WHERE ENAME='SMITH';
DELETE FROM EMPV0 WHERE ENAME='SMITH';-- VIEW 제한 조건에 맞지 않은 데이터는 DELETE  안 됨
SELECT * FROM EMP WHERE ENAME='홍';
DELETE FROM EMPV0 WHERE ENAME='홍';
COMMIT;

--읽기 전용 단순뷰(WITH READ ONLY 추가)
CREATE OR REPLACE VIEW EMPV0
    AS SELECT * FROM EMP WHERE DEPTNO=20 WITH READ ONLY;

INSERT INTO EMPV0 (EMPNO, ENAME,DEPTNO) VALUES(1111,'홍', 20); -- READ ONLY ERROR

-- (2) 복합뷰 : 2개 이상의 테이블로 구성한 뷰, 가상의 필드를 이용한 뷰. DML문을 제한적으로만 이용(SELECT)
-- 2개 이상의 테이블로 구성한 복합뷰
CREATE OR REPLACE VIEW EMPV0
    AS SELECT EMPNO, ENAME, JOB, DNAME FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO;
SELECT* FROM EMPV0;
INSERT INTO EMPv0 VALUES(1111, '홍', 'MANAGER', 'SALES');

-- 가상의 필드를 이용한 복합뷰(컬럼에 별칭을 사용)
CREATE OR REPLACE VIEW EMPV0
    AS SELECT EMPNO, ENAME, SAL* 12 YEARSAL FROM EMP WHERE DEPTNO=10;
    
CREATE OR REPLACE VIEW EMPV0 (EMPNO, ENAME, YEAR_SAL)
    AS SELECT EMPNO, ENAME, SAL* 12 FROM EMP WHERE DEPTNO=10;

INSERT INTO EMPV0 VALUES(1111,'LEE', 1200); -- 복합뷰는 INSERT 불가

    -- EX1. 사번, 이름, 10의 자리에서 반올림한 급여를 뷰로 생성(EMPV0)
    CREATE OR REPLACE VIEW EMPV0
        AS SELECT EMPNO, ENAME, ROUND(SAL,-2) SAL FROM EMP;
    INSERT INTO EMPV0 VALUES (1111, '홍', 1300); -- 복합뷰는 INSERT 불가
    
    --EX2. 중복이 제거된 JOB, DEPTNO를 뷰로 생성 (EMPV1)
    CREATE OR REPLACE VIEW EMPV1
        AS SELECT DISTINCT JOB, DEPTNO FROM EMP;
    
    --EX3. 부서번호 최소급여, 최대급여, 부서평균(소수점 한자리에서 반올림)을 포함한 뷰
    CREATE OR REPLACE VIEW EMP22 (DEPTNO, MINSAL, MAXSAL, AVGSAL)
        AS SELECT DEPTNO, MIN(SAL), MAX(SAL), ROUND(AVG(SAL),1) FROM EMP GROUP BY DEPTNO;
    
    SELECT * FROM EMP22;
    
    --EX4. 부서명 최소급여, 최대급여, 부서평균(소수점 한자리에서 반올림)을 포함한 뷰
    CREATE OR REPLACE VIEW EMP33 (DNAME,MINSAL,MAXSAL,AVGSAL)
        AS SELECT DNAME, MIN(SAL), MAX(SAL),ROUND(AVG(SAL),1) 
                  FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO GROUP BY DNAME;
    
    SELECT * FROM EMP33;

-- (2) INLINE-VIEW : FROM 절의 서브 쿼리를 INLINE-VIEW라 하며, FROM 절에 오는 서브쿼리는 VIEW작용
    -- EX. 급여가 2000을 초과하는 사원의 평균 급여
    SELECT AVG(SAL) FROM EMP WHERE SAL>2000;
    SELECT AVG(SAL) FROM (SELECT SAL FROM EMP WHERE SAL>2000) E;

-- SELECT 필드1, 필드2
-- FROM (서브쿼리) 별칭, 테이블N...
-- WHERE 조건
    --EX. 부서평균의 월급보다 높은 월급을 받는 사원의 사번, 이름, 급여, 부서번호, 해당부서의 평균급여(반올림)
    SELECT EMPNO, ENAME, SAL, E.DEPTNO, ROUND(AVGSAL,1) 
        FROM EMP E,
            (SELECT DEPTNO, AVG(SAL) AVGSAL FROM EMP GROUP BY DEPTNO) G
        WHERE E.DEPTNO=G.DEPTNO AND SAL>AVGSAL;

-- 3. TOP-N 구문 (TOP 1~10등, 11~20등...)
    -- ROWNUM : 테이블로부터 가져온 데이터 순서
SELECT ROWNUM, ENAME, SAL FROM EMP WHERE DEPTNO=20;
SELECT ROWNUM, ENAME, SAL FROM EMP;
SELECT ROWNUM, ENAME, SAL 급여 --2
    FROM EMP --1
    ORDER BY SAL; --3

SELECT ROWNUM, ENAME, SAL
    FROM (SELECT * FROM EMP ORDER BY SAL DESC  ); -- 1등 ~ 꼴찌

--SAL을 기준으로 1~5등
SELECT ROWNUM, ENAME, SAL
    FROM (SELECT * FROM EMP ORDER BY SAL)
    WHERE ROWNUM < 6;
--SAL 을 기준으로 6~10등
SELECT ROWNUM, ENAME, SAL
    FROM (SELECT * FROM EMP ORDER BY SAL)
    WHERE ROWNUM BETWEEN 6 AND 10;

-- TOP-N
SELECT * FROM EMP ORDER BY SAL;--  1단계 SAL기준으로 정렬
SELECT ROWNUM RN, A.* FROM (SELECT *FROM EMP ORDER BY SAL) A; --2단계 (RANK포함)
SELECT *
    FROM (SELECT ROWNUM RN, ENAME, SAL FROM (SELECT * FROM EMP ORDER BY SAL))
    WHERE RN BETWEEN 6 AND 10; -- 3단계 (TOP-N구문)

SELECT *
    FROM (SELECT ROWNUM RN, A.* FROM (SELECT * FROM EMP ORDER BY SAL)A)
    WHERE RN BETWEEN 6 AND 10; -- 3단계 (TOP-N구문)

SELECT ENAME, SAL
    FROM (SELECT ROWNUM RN, ENAME, SAL FROM (SELECT * FROM EMP ORDER BY SAL))
    WHERE RN BETWEEN 6 AND 10; -- 3단계 (TOP-N구문)

-- EX. 이름 알파벳순으로 6번째~10번째 사원의 출력(순서, 이름, 사번, JOB, MGR, HIREDATE)
SELECT *
    FROM (SELECT ROWNUM RN, ENAME, EMPNO, JOB, MGR, HIREDATE 
            FROM (SELECT * FROM EMP ORDER BY ENAME))
    WHERE RN BETWEEN 6 AND 10;

-- EX. 입사순으로 11번째~ 15번째인 사원의 모든 필드 출력(순서는 출력 안함)
SELECT ENAME, EMPNO, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO
    FROM (SELECT ROWNUM RN, A.* 
            FROM (SELECT *FROM EMP ORDER BY HIREDATE) A)
    WHERE RN BETWEEN 11 AND 15;

-- ★ ★ ★ <총 연습문제> ★ ★ ★
-- 1. 부서명과 사원명을 출력하는 용도의 뷰, DNAME_ENAME_VU 를 작성하시오
 CREATE OR REPLACE VIEW DNAME_ENAME_VU (DNAME,ENAME)
    AS SELECT DNAME, ENAME FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO;
    SELECT * FROM DNAME_ENAME_VU;

-- 2. 사원명과 직속상관명을 출력하는 용도의 뷰,  WORKER_MANAGER_VU를 작성하시오
 CREATE OR REPLACE VIEW WORKER_MANAGER_VU (WORKER, MANAGER)
    AS SELECT W.ENAME, M.ENAME FROM EMP W, EMP M WHERE W.MGR=M.EMPNO ;
    SELECT * FROM WORKER_MANAGER_VU;

-- 3. 부서별 급여합계 등수를 출력하시오(부서번호, 급여합계, 등수). -- 학생 질문
 SELECT ROWNUM RANK, DEPTNO, SUMSAL
    FROM (SELECT DEPTNO, SUM(SAL) SUMSAL FROM EMP GROUP BY DEPTNO ORDER BY SUM(SAL)DESC);

-- 3-1. 부서별 급여합계 등수가 2~3등인 부서번호, 급여합계, 등수를 출력하시오.
 SELECT *
    FROM (SELECT ROWNUM RN, A.* FROM
        (SELECT DEPTNO, SUM(SAL) SUMSAL FROM EMP GROUP BY DEPTNO ORDER BY SUM(SAL) DESC) A)
    WHERE RN BETWEEN 2 AND 3;
    

-- 4. 사원테이블에서 사번, 사원명, 입사일을 입사일이 최신에서 오래된 사원 순으로 정렬하시오
    SELECT EMPNO, ENAME, HIREDATE
        FROM EMP ORDER BY HIREDATE DESC;

-- 5. 사원테이블에서 사번, 사원명, 입사일을 입사일이 최신에서 오래된 사원 5명을 출력하시오
     SELECT EMPNO, ENAME, HIREDATE
        FROM (SELECT ROWNUM RN, A.* 
            FROM (SELECT * FROM EMP ORDER BY HIREDATE DESC) A)
        WHERE RN BETWEEN 1 AND 5;
    
-- 6. 사원 테이블에서 사번, 사원명, 입사일을 최신부터 오래된 순으로 6번째로 늦은 사원부터 10번째 사원까지 출력
     SELECT EMPNO, ENAME, HIREDATE
        FROM (SELECT ROWNUM RN, A.* 
         FROM (SELECT * FROM EMP ORDER BY HIREDATE DESC) A)
        WHERE RN BETWEEN 6 AND 10;