SELECT * FROM EMP;
SELECT DEPTNO, DNAME FROM DEPT;
SELECT E.*,DNAME
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND E.DEPTNO LIKE '%'||'10';
    
--QUIZ : 사원명(일부 알파벳)으로 직원 검색
SELECT E.*,DNAME
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND ENAME LIKE '%'||TRIM(UPPER('  s'))||'%'; -- '%S%'