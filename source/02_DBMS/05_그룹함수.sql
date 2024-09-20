--[V] 그룹함수: SUM, AVG, MIN, MAX, COUNT, STDDEV(표준편차), VARIANCE(분산)
SELECT MAX(SAL) FROM EMP;
SELECT ENAME, SAL FROM EMP WHERE SAL=(SELECT MAX(SAL) FROM EMP);-- 서브쿼리


-- 1. 그룹함수들 실습
SELECT ROUND(AVG(SAL)) FROM EMP;
SELECT AVG(SAL), SUM(SAL)/COUNT(SAL) FROM EMP;
SELECT COMM FROM EMP;
-- 모든 그룹함수는 NULL값을 제외하고 계산됨
SELECT AVG(COMM), SUM(COMM),COUNT(COMM) FROM EMP;
SELECT COUNT(*) FROM EMP; -- 테이블의 행수
    --EX. SAL의 평균, 합, 최소값, 최대값, 분산, 표준편차, 갯수
    SELECT ROUND(AVG(SAL)),ROUND(STDDEV(SAL)),
            ROUND(VARIANCE(SAL)),SUM(SAL),MIN(SAL),MAX(SAL),COUNT(SAL) 
        FROM EMP;
        
    --EX. 그룹함수 MIN, MAX, COUNT는 숫자형, 문자형, 날짜형 모두 가능
    SELECT MIN(HIREDATE)"최초 입사일", MAX(HIREDATE) "최근 입사일",
    MIN(ENAME), COUNT(JOB)
    FROM EMP;
    
    -- EX1. 입사한지 가장 오래된 사원의 입사일과 가장 최근에 입사일을 출력
    SELECT MIN(HIREDATE) FIRST, MAX(HIREDATE) LAST FROM EMP;
    
    -- EX2. 결과:FIRST              LAST
    --          80/12/17:18,123일째 83/01/12:16,123일째
    SELECT  
        MIN(HIREDATE)||':'||TRIM(TO_CHAR(TRUNC(SYSDATE-MIN(HIREDATE)),'99,999'))||'일째' FIRST, 
        MAX(HIREDATE)||':'||TRIM(TO_CHAR(TRUNC(SYSDATE-MAX(HIREDATE)),'99,999'))||'일째' LAST 
      FROM EMP;
      
    -- EX3. 결과) 80년 12월 17일 최초 입사: 18,123일째 
    --            83년 01월 12일 최근입사:16,123일째
    SELECT  
        TO_CHAR(MIN(HIREDATE),'RR"년"MM"월"DD"일최초입사"')||':'||TRIM(TO_CHAR(TRUNC(SYSDATE-MIN(HIREDATE)),'99,999'))||'일째' FIRST, 
        TO_CHAR(MAX(HIREDATE),'RR"년"MM"월"DD"일최근입사"')||':'||TRIM(TO_CHAR(TRUNC(SYSDATE-MAX(HIREDATE)),'99,999'))||'일째' LAST 
      FROM EMP;
      
    -- EX4. 10번부서 소속의 사원 중에 COMM을 받는 사원의 수(COUNT함수 사용)
    SELECT COUNT(*) FROM EMP WHERE DEPTNO=10 AND COMM>0;--답
    SELECT COUNT(COMM) FROM EMP WHERE DEPTNO=10; --COMM이 0인 행을 포함
    
-- 2. GROUP BY 절 : 그룹함수를 쓰되, 어떤 컬럼 기준으로 그룹함수를 적용
    -- EX. 부서번호별 최대급여, 급여평균, 급여표준편차 (부서번호순으로 정렬)
    SELECT DEPTNO NO, MAX(SAL),TRUNC(AVG(SAL)), TRUNC(STDDEV(SAL)) 
        FROM EMP 
        GROUP BY DEPTNO -- GROUP BY 절은 필드의 별칭 사용 불가
        ORDER BY NO;    -- ORDER BY 절은 필드의 별칭 사용 가능
    
    -- 부서명별 최대급여, 평균급여 (평균급여순 정렬)
    SELECT DNAME, MAX(SAL), AVG(SAL) AVGSAL
        FROM EMP E, DEPT D
        WHERE E.DEPTNO=D.DEPTNO 
        GROUP BY DNAME
        ORDER BY AVG(SAL);
        --ORDER BY AVGSAL
    
    -- SAL이 5000미만인 사원에 대해서만 부서번호별 사원수, 최대급여, 최소급여, 평균급여
        --(부서번호 순 정렬)
    SELECT DEPTNO, COUNT(*), MAX(SAL), MIN(SAL), AVG(SAL)
        FROM EMP
        WHERE SAL<5000
        GROUP BY DEPTNO
        ORDER BY DEPTNO;
-- 3. HAVING절 : 그룹함수의 결과를 제한할 때
    -- (필드의 조건을 사용해서 제한할 때는 WHERE절)
    -- SAL이 5000미만인 사원에 대해서만 부서번호별 사원수, 최대급여, 최소급여, 평균급여
        --(급여 평균이 1800이상만 출력하되 평균 급여순 정렬)
    SELECT DEPTNO, COUNT(*), MAX(SAL), MIN(SAL), AVG(SAL) AVGSAL
        FROM EMP
        WHERE SAL<5000
        GROUP BY DEPTNO -- GROUP BY 절에 필드 별칭 사용 불가
        HAVING AVG(SAL)>=1800 -- HAVING절에 필드 별칭 사용 불가
        ORDER BY AVGSAL;
    
    --EX. SAL이 5000 미만인 사원에 대해 부서이름별 급여평균과 표준편차를 소수점 2자리까지 출력
        -- (단, 평균급여가 1800이상인 부서에 대해 부서명순으로 정렬)
    SELECT DNAME, ROUND(AVG(SAL),2), ROUND(STDDEV(SAL),2)
        FROM EMP E , DEPT D
        WHERE E.DEPTNO=D.DEPTNO AND SAL<5000
        GROUP BY DNAME
        HAVING AVG(SAL)>=1800;
        ORDER BY DNAME;
     
-- 4. 결과 집합을 낸 집계값 생성 (ROLLUP)
SELECT DEPTNO, SUM(SAL) FROM EMP GROUP BY DEPTNO;
SELECT DEPTNO, SUM(SAL) FROM EMP GROUP BY ROLLUP(DEPTNO);
SELECT DEPTNO, JOB, SUM(SAL)
    FROM EMP 
    GROUP BY DEPTNO, JOB 
    ORDER BY DEPTNO;
    
SELECT DEPTNO, JOB, SUM(SAL)
    FROM EMP 
    GROUP BY ROLLUP( DEPTNO, JOB);
--연습문제
--1. 인원수,최대 급여,최소 급여,급여의 합을 출력
SELECT COUNT(*), MAX(SAL), MIN(SAL),SUM(SAL)
       FROM EMP;
    
--2. 업무별 인원수를 구하여 출력
SELECT COUNT(*),JOB
    FROM EMP
    GROUP BY JOB;
    
--3. 최고 급여와 최소 급여의 차이는 얼마인가 출력
SELECT MAX(SAL)-MIN(SAL) "급여차이" 
    FROM EMP;
    
--4. 각 부서별로 인원수, 급여 평균, 최저 급여, 최고 급여, 급여의 합을 출력(급여의 합이 많은 순으로)
SELECT DEPTNO, COUNT(*), TRUNC(AVG(SAL)), MAX(SAL), MIN(SAL),SUM(SAL)
    FROM EMP
    GROUP BY DEPTNO
    ORDER BY SUM(SAL) DESC;
    
--5. 부서별, 업무별 그룹하여 결과를 부서번호, 업무, 인원수, 급여의 평균, 급여의 합을 출력(부서번호, 업
--무순으로 오름차순 정렬)
SELECT DEPTNO, JOB, COUNT(ENAME), AVG(SAL), SUM(SAL)
    FROM EMP
    GROUP BY DEPTNO, JOB
    ORDER BY DEPTNO, JOB;

--6. 업무별, 부서별 그룹하여 결과를 업무, 부서번호, 인원수, 급여의 평균, 급여의 합을 출력(출력결과는
---업무순, 부서번호 순 오름차순 정렬)
SELECT JOB, DEPTNO, COUNT(ENAME), AVG(SAL), SUM(SAL)
    FROM EMP
    GROUP BY JOB, DEPTNO
    ORDER BY JOB, DEPTNO;

--7. 사원수가 5명이상 넘는 부서번호와 사원수를 출력
SELECT DEPTNO, COUNT(*)
    FROM EMP
    GROUP BY DEPTNO
    HAVING COUNT(*)>=5;

--8. 사원수가 5명이상 넘는 부서명과 사원수를 출력
SELECT DNAME, COUNT(*)
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO
    GROUP BY DNAME
    HAVING COUNT(*)>=5;

--9. 업무별 급여의 평균이 3000이상인 업무에 대해서 업무명, 평균 급여, 급여의 합을 출력
SELECT JOB, AVG(SAL), SUM(SAL)
    FROM EMP
    GROUP BY JOB
    HAVING AVG(SAL)>=3000;

--10. 급여 합이 5000을 초과하는 각 업무에 대해서 업무와 급여합을 출력(급여 합계순 내림차순 정렬)
SELECT JOB, SUM(SAL)
    FROM EMP
    GROUP BY JOB
    HAVING SUM(SAL)>5000
    ORDER BY SUM(SAL) DESC;

--11. 부서별 급여평균, 부서별 급여합계, 부서별 최소급여를 출력
SELECT DEPTNO, TRUNC(AVG(SAL)), SUM(SAL), MIN(SAL)
    FROM EMP
    GROUP BY DEPTNO;

--12. 위의 11번에서 나온, 부서별 급여평균들 최대치, 부서별 급여합들의 최대치, 부서별 최소급여들의 최대치를
--출력
SELECT MAX(TRUNC(AVG(SAL))), MAX(SUM(SAL)), MAX(MIN(SAL))
    FROM EMP
    GROUP BY DEPTNO;

--13. 사원 테이블에서 아래의 결과를 출력.
--YEAR COUNT(*) MIN(SAL) MAX(SAL) AVG(SAL) SUM(SAL)
--80 1 800 800 800 800
--81 10 950 5000 2282.5 2282.5
--82 2 1300 3000 2150 4300
--83 1 1100 1100 1100 1100
SELECT TO_CHAR(HIREDATE,'RR') YEAR , COUNT(*), MIN(SAL), MAX(SAL), AVG(SAL), SUM(SAL)
    FROM EMP
    GROUP BY TO_CHAR(HIREDATE,'RR')
    ORDER BY YEAR;

--14. 아래의 결과를 출력(입사년도별 사원수)
--1980 사원수
--1981 10
--1982 2
--1983 1
--TOTAL 14
--NVL내에서 타입이 다르기 때문에 EXTRACT를 TO_CHAR를 사용하여 타입 일치
SELECT  NVL(TO_CHAR(EXTRACT(YEAR FROM HIREDATE)) ,'TOTAL') YEAR, COUNT(*)
    FROM EMP
    GROUP BY ROLLUP(EXTRACT(YEAR FROM HIREDATE))
    ORDER BY YEAR;

--15. 최대급여, 최소급여, 전체급여합, 평균을 출력
SELECT MAX(SAL), MIN(SAL), SUM(SAL), TRUNC(AVG(SAL))
    FROM EMP;

--16. 부서별 인원수 출력
SELECT DNAME, COUNT(*)
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO
    GROUP BY DNAME;

--17. 부서별 인원수가 6명이상인 부서번호 출력
SELECT DEPTNO
    FROM EMP
    GROUP BY DEPTNO
    HAVING COUNT(DEPTNO)>=6;

SELECT * FROM EMP;