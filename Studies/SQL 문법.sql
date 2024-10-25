-- CRUD(Create Read Update Delete) : INSERT, SELECT, UPDATE, DELETE
-- DQL(Data Query Language) : SELECT
-- DML(Data Manipulation Language) : INSERT, UPDATE, DELETE, MERGE

-- 데이터 조회
SELECT
FROM

-- 조건 절
WHERE(BETWEEN AND, IN)

-- 그룹 함수
GROUP BY
-- 그룹 조건 절
HAVING

-- 테이블 병합
JOIN(INNER, OUTER, LEFT, RIGHT, FULL)

-- 정렬(오름차순, 내림차순)
ORDER BY (ASC, DESC)

-- 집합(합집합, 차집합, 교집합)
UNION
MINUS
INTERSECT

-- 데이터 변환
DECODE
-- 데이터 조건 문
CASE WHEN THEN END

-- 데이터 입력
INSERT INTO VALUES
-- 데이터 수정
UPDATE

-- 테이블 생성
CREATE TABLE
-- 테이블 삭제
DROP TABLE

-- 제약 조건
CONSTRAINT(NOT NULL, UNIQUE, PRIMARY KEY, FOREIGN KEY, CHECK)
-- 제약 조건 변경(추가, 비활성화, 활성화)
ALTER(ADD, DISABLE, ENABLE)

-- 뷰 생성(데이터 수정 여부)
CREATE OR REPLACE FORCE VIEW
AS
WITH CHECK OPTION
WITH READ ONLY

-- 상태 저장
COMMIT
-- 상태 복원
ROLLBACK
