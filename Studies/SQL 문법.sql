-- 데이터베이스 조회
-- nvl (column, null인 경우 대체값)
-- nvl2 (column, null이 아닌 경우 대체값, null인 경우 대체값)
-- coalesce(column1, column2, column3) : 맨 처음 null이 아닌 값 선택
SELECT distinct employee_id, first_name, salary "직원의 급여", commission_pct, 100, '문자', SALARY + SALARY*nvl(commission_pct, 0)
FROM employees
WHERE salary > 10000
AND COMMISSION_PCT IS NOT NULL
ORDER BY "직원의 급여" desc;

-- 2005년 1월 1일 이후에 입사한 사원을 출력(이후 = 포함)
SELECT *
FROM EMPLOYEES
WHERE TO_CHAR(HIRE_DATE, 'rr-mm-dd') >= '05-01-01'
ORDER BY HIRE_DATE ASC;

-- 부서가 60 이고 급여가 5000 이상인 사원을 출력
SELECT *
FROM EMPLOYEES
WHERE DEPARTMENT_ID = 60
AND SALARY >= 5000;

-- 부서가 60 이거나 급여가 5000 이상인 사원을 출력
SELECT *
FROM EMPLOYEES
WHERE DEPARTMENT_ID = 60
OR SALARY >= 5000;

-- 부서가 60 이 아닌 사원을 출력
SELECT *
FROM EMPLOYEES
WHERE DEPARTMENT_ID <> 60;
-- WHERE DEPARTMENT_ID != 60;
-- WHERE NOT DEPARTMENT_ID = 60;

-- 급여가 5000 이상 10000 이하인 사원을 출력
SELECT *
FROM EMPLOYEES
WHERE SALARY BETWEEN 5000 AND 10000;
-- WHERE SALARY >= 5000 AND SALARY <= 10000;

-- 부서가 60 이거나 80 인 사원을 출력
SELECT *
FROM EMPLOYEES
WHERE DEPARTMENT_ID IN (60, 80);
-- WHERE DEPARTMENT_ID = 60 OR DEPARTMENT_ID = 80;

-- 이름이 S 로 시작하는 사원을 출력
SELECT *
FROM EMPLOYEES
WHERE FIRST_NAME LIKE 'S%';

-- 이름이 r 로 끝나는 사원을 출력
SELECT *
FROM EMPLOYEES
WHERE FIRST_NAME LIKE '%r';

-- 이름 중간에 tt가 있는 사원을 출력
SELECT *
FROM EMPLOYEES
WHERE FIRST_NAME LIKE '%tt%';

-- 이름 3번째 문자가 a인 사원을 출력
SELECT *
FROM EMPLOYEES
WHERE FIRST_NAME LIKE '__a%';

-- 2000년대에 입사해서 30, 50, 80 번 부서에 속해있으면서, 급여를 5000 이상 17000 이하를 받는 직원을 출력
-- 단, 커미션을 받지 않는 직원들은 검색 대상에서 제외시키며 먼저 입사한 직원이 먼저 출력되어야 하고 입사일이 같은 경우 급여가 많은 직원이 먼저 출력
SELECT *
FROM EMPLOYEES
WHERE TO_CHAR(HIRE_DATE, 'rr-mm-dd') BETWEEN '00-01-01' AND '09-12-31'
AND DEPARTMENT_ID IN (30, 50, 80)
AND SALARY BETWEEN 5000 AND 17000
AND COMMISSION_PCT IS NOT NULL
ORDER BY HIRE_DATE, SALARY DESC;
