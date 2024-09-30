--com.lec.ex1selectAll
SELECT *FROM EMP;

--package com.lec.ex2selectWhere;
-- EX1. 부서번호를 받아 부서 정보를 출력
SELECT *FROM DEPT WHERE DEPTNO=10;
INSERT INTO DEPT VALUES (50,'IT', '서울');
SELECT *FROM DEPT;
COMMIT