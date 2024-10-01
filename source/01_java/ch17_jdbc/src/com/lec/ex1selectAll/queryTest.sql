--com.lec.ex1selectAll
SELECT *FROM EMP;

--package com.lec.ex2selectWhere;
-- EX1. 부서번호를 받아 부서 정보를 출력
SELECT *FROM DEPT WHERE DEPTNO=10;
INSERT INTO DEPT VALUES (50,'IT', '서울');
SELECT *FROM DEPT;
COMMIT;
 
 --EX2. 부서번호입력 받아 부서정보와 사원정도 출력
SELECT * FROM DEPT WHERE DEPTNO=10;
SELECT W.EMPNO, W.ENAME, W.SAL, M.ENAME "MANAGER"
    FROM EMP W, EMP M
        WHERE W.MGR=M.EMPNO AND W.DEPTNO = 10;
        
--EX3. 부서이름으로 부서정보 출력
SELECT* FROM DEPT WHERE DNAME =UPPER('SALES');

---com.lec.ex3insert
    insert into dept values (60,upper('cs'),upper('busan'));        
select count(*) cnt from dept where deptno=60;

select * from dept;

-- com.lec.ex4update

update dept set dname=upper('marketing'),
    loc=upper('seoul')
    where deptno = 80;
    commit;

select*from dept where deptno= 70;
rollback;

-- com.lec.ex5delete
delete from dept where deptno=99; 

-- com.lec.ex6prepaerstatement

--com.lec.ex6prepareStatement
SELECT* FROM DEPT WHERE DNAME =UPPER('SALES');
select EMPNO, ENAME, SAL 
FROM EMP e, dept d
where e.deptno= d.deptno 
and dname=upper('sales')
ORDER BY SAL;
