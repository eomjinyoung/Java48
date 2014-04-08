<<<<<<< HEAD
-- 주문정보 
ALTER TABLE ODERS
  DROP FOREIGN KEY FK_CUSTOMERS_TO_ODERS; -- 고객정보 -> 주문정보

-- 주문정보
ALTER TABLE ODERS
  DROP FOREIGN KEY FK_PRODUCTS_TO_ODERS; -- 제품정보 -> 주문정보

-- 고객정보
ALTER TABLE CUSTOMERS
  DROP FOREIGN KEY FK_ADDRS_TO_CUSTOMERS; -- 주소정보 -> 고객정보

-- 제품사진정보
ALTER TABLE PHOTOS
  DROP FOREIGN KEY FK_PRODUCTS_TO_PHOTOS; -- 제품정보 -> 제품사진정보

-- 제품정보
ALTER TABLE PRODUCTS
  DROP FOREIGN KEY FK_MAKERS_TO_PRODUCTS; -- 제조사정보 -> 제품정보

-- 직원정보
ALTER TABLE EMPLOYEES
  DROP FOREIGN KEY FK_CUSTOMERS_TO_EMPLOYEES; -- 고객정보 -> 직원정보

-- 강사
ALTER TABLE SE_TEACHS
  DROP FOREIGN KEY FK_SE_USERS_TO_SE_TEACHS; -- 사용자 -> 강사

-- 교육생
ALTER TABLE SE_STUDS
  DROP FOREIGN KEY FK_SE_USERS_TO_SE_STUDS; -- 사용자 -> 교육생

-- 관리자
ALTER TABLE SE_MGRS
  DROP FOREIGN KEY FK_SE_USERS_TO_SE_MGRS; -- 사용자 -> 관리자

-- 커리큘럼
ALTER TABLE SE_COUR_SUBJS
  DROP FOREIGN KEY FK_SE_COURS_TO_SE_COUR_SUBJS; -- 교육과정 -> 커리큘럼

-- 커리큘럼
ALTER TABLE SE_COUR_SUBJS
  DROP FOREIGN KEY FK_SE_SUBJS_TO_SE_COUR_SUBJS; -- 과목 -> 커리큘럼

-- 개설강의
ALTER TABLE SE_OPEN_LECTS
  DROP FOREIGN KEY FK_SE_COURS_TO_SE_OPEN_LECTS; -- 교육과정 -> 개설강의

-- 개설강의
ALTER TABLE SE_OPEN_LECTS
  DROP FOREIGN KEY FK_SE_MGRS_TO_SE_OPEN_LECTS; -- 관리자 -> 개설강의

-- 개설강의과목
ALTER TABLE SE_OPEN_LECT_SUBJS
  DROP FOREIGN KEY FK_SE_COUR_SUBJS_TO_SE_OPEN_LECT_SUBJS; -- 커리큘럼 -> 개설강의과목

-- 개설강의과목
ALTER TABLE SE_OPEN_LECT_SUBJS
  DROP FOREIGN KEY FK_SE_TEACHS_TO_SE_OPEN_LECT_SUBJS; -- 강사 -> 개설강의과목

-- 개설강의과목
ALTER TABLE SE_OPEN_LECT_SUBJS
  DROP FOREIGN KEY FK_SE_OPEN_LECTS_TO_SE_OPEN_LECT_SUBJS; -- 개설강의 -> 개설강의과목

-- 수강생
ALTER TABLE SE_LECT_STUDS
  DROP FOREIGN KEY FK_SE_OPEN_LECTS_TO_SE_LECT_STUDS; -- 개설강의 -> 수강생

-- 수강생
ALTER TABLE SE_LECT_STUDS
  DROP FOREIGN KEY FK_SE_STUDS_TO_SE_LECT_STUDS; -- 교육생 -> 수강생

-- 수강생
ALTER TABLE SE_LECT_STUDS
  DROP FOREIGN KEY FK_SE_SUPPS_TO_SE_LECT_STUDS; -- 교육지원 -> 수강생

-- 수강생
ALTER TABLE SE_LECT_STUDS
  DROP FOREIGN KEY FK_SE_LECT_STATS_TO_SE_LECT_STUDS; -- 수강상태 -> 수강생

-- 과제
ALTER TABLE SE_TESTS
  DROP FOREIGN KEY FK_SE_OPEN_LECTS_TO_SE_TESTS; -- 개설강의 -> 과제

-- 과제
ALTER TABLE SE_TESTS
  DROP FOREIGN KEY FK_SE_TEST_TYPES_TO_SE_TESTS; -- 과제유형 -> 과제

-- 과제평가
ALTER TABLE SE_TEST_RESUS
  DROP FOREIGN KEY FK_SE_LECT_STUDS_TO_SE_TEST_RESUS; -- 수강생 -> 과제평가

-- 과제평가
ALTER TABLE SE_TEST_RESUS
  DROP FOREIGN KEY FK_SE_TESTS_TO_SE_TEST_RESUS; -- 과제 -> 과제평가

-- 과제평가
ALTER TABLE SE_TEST_RESUS
  DROP FOREIGN KEY FK_SE_TEST_RESU_TYPES_TO_SE_TEST_RESUS; -- 과제상태 -> 과제평가

-- 교육자료
ALTER TABLE SE_LECT_FILES
  DROP FOREIGN KEY FK_SE_OPEN_LECTS_TO_SE_LECT_FILES; -- 개설강의 -> 교육자료

-- 교육자료
ALTER TABLE SE_LECT_FILES
  DROP FOREIGN KEY FK_SE_USERS_TO_SE_LECT_FILES; -- 사용자 -> 교육자료

-- 강사과목
ALTER TABLE SE_TEACH_SUBJS
  DROP FOREIGN KEY FK_SE_TEACHS_TO_SE_TEACH_SUBJS; -- 강사 -> 강사과목

-- 강사과목
ALTER TABLE SE_TEACH_SUBJS
  DROP FOREIGN KEY FK_SE_SUBJS_TO_SE_TEACH_SUBJS; -- 과목 -> 강사과목

-- 주문정보
ALTER TABLE ODERS
  DROP PRIMARY KEY; -- 주문정보 기본키

-- 고객정보
ALTER TABLE CUSTOMERS
  DROP PRIMARY KEY; -- 고객정보 기본키

-- 제품사진정보
ALTER TABLE PHOTOS
  DROP PRIMARY KEY; -- 제품사진정보 기본키

-- 주소정보
ALTER TABLE ADDRS
  DROP PRIMARY KEY; -- 주소정보 기본키

-- 제조사정보
ALTER TABLE MAKERS
  DROP PRIMARY KEY; -- 제조사정보 기본키

-- 제품정보
ALTER TABLE PRODUCTS
  DROP PRIMARY KEY; -- 제품정보 기본키

-- 직원정보
ALTER TABLE EMPLOYEES
  DROP PRIMARY KEY; -- 직원정보 기본키

-- 강사
ALTER TABLE SE_TEACHS
  DROP PRIMARY KEY; -- 강사 기본키

-- 교육생
ALTER TABLE SE_STUDS
  DROP PRIMARY KEY; -- 교육생 기본키

-- 관리자
ALTER TABLE SE_MGRS
  DROP PRIMARY KEY; -- 관리자 기본키

-- 사용자
ALTER TABLE SE_USERS
  DROP PRIMARY KEY; -- 사용자 기본키

-- 교육과정
ALTER TABLE SE_COURS
  DROP PRIMARY KEY; -- 교육과정 기본키

-- 과목
ALTER TABLE SE_SUBJS
  DROP PRIMARY KEY; -- 과목 기본키

-- 커리큘럼
ALTER TABLE SE_COUR_SUBJS
  DROP PRIMARY KEY; -- 커리큘럼 기본키

-- 개설강의
ALTER TABLE SE_OPEN_LECTS
  DROP PRIMARY KEY; -- 개설강의 기본키

-- 개설강의과목
ALTER TABLE SE_OPEN_LECT_SUBJS
  DROP PRIMARY KEY; -- 개설강의과목 기본키

-- 수강생
ALTER TABLE SE_LECT_STUDS
  DROP PRIMARY KEY; -- 수강생 기본키

-- 과제
ALTER TABLE SE_TESTS
  DROP PRIMARY KEY; -- 과제 기본키

-- 과제평가
ALTER TABLE SE_TEST_RESUS
  DROP PRIMARY KEY; -- 과제평가 기본키

-- 교육자료
ALTER TABLE SE_LECT_FILES
  DROP PRIMARY KEY; -- 교육자료 기본키

-- 강사과목
ALTER TABLE SE_TEACH_SUBJS
  DROP PRIMARY KEY; -- 강사과목 기본키

-- 과제유형
ALTER TABLE SE_TEST_TYPES
  DROP PRIMARY KEY; -- 과제유형 기본키

-- 과제상태
ALTER TABLE SE_TEST_RESU_TYPES
  DROP PRIMARY KEY; -- 과제상태 기본키

-- 교육지원
ALTER TABLE SE_SUPPS
  DROP PRIMARY KEY; -- 교육지원 기본키

-- 수강상태
ALTER TABLE SE_LECT_STATS
  DROP PRIMARY KEY; -- 수강상태 기본키

-- 고객정보 유니크 인덱스
DROP INDEX UIX_CUSTOMERS ON CUSTOMERS;

-- 사용자 유니크 인덱스
DROP INDEX UIX_SE_USERS ON SE_USERS;

-- 교육과정 유니크 인덱스
DROP INDEX UIX_SE_COURS ON SE_COURS;

-- 과목 유니크 인덱스
DROP INDEX UIX_SE_SUBJS ON SE_SUBJS;

-- 수강생 유니크 인덱스
DROP INDEX UIX_SE_LECT_STUDS ON SE_LECT_STUDS;

-- 과제유형 유니크 인덱스
DROP INDEX UIX_SE_TEST_TYPES ON SE_TEST_TYPES;

-- 과제상태 유니크 인덱스
DROP INDEX UIX_SE_TEST_RESU_TYPES ON SE_TEST_RESU_TYPES;

-- 교육지원 유니크 인덱스
DROP INDEX UIX_SE_SUPPS ON SE_SUPPS;

-- 수강상태 유니크 인덱스
DROP INDEX UIX_SE_LECT_STATS ON SE_LECT_STATS;

-- 주문정보
DROP TABLE IF EXISTS ODERS RESTRICT;

-- 고객정보
DROP TABLE IF EXISTS CUSTOMERS RESTRICT;

-- 제품사진정보
DROP TABLE IF EXISTS PHOTOS RESTRICT;

-- 주소정보
DROP TABLE IF EXISTS ADDRS RESTRICT;

-- 제조사정보
DROP TABLE IF EXISTS MAKERS RESTRICT;

-- 제품정보
DROP TABLE IF EXISTS PRODUCTS RESTRICT;

-- 직원정보
DROP TABLE IF EXISTS EMPLOYEES RESTRICT;

-- 강사
DROP TABLE IF EXISTS SE_TEACHS RESTRICT;

-- 교육생
DROP TABLE IF EXISTS SE_STUDS RESTRICT;

-- 관리자
DROP TABLE IF EXISTS SE_MGRS RESTRICT;

-- 사용자
DROP TABLE IF EXISTS SE_USERS RESTRICT;

-- 교육과정
DROP TABLE IF EXISTS SE_COURS RESTRICT;

-- 과목
DROP TABLE IF EXISTS SE_SUBJS RESTRICT;

-- 커리큘럼
DROP TABLE IF EXISTS SE_COUR_SUBJS RESTRICT;

-- 개설강의
DROP TABLE IF EXISTS SE_OPEN_LECTS RESTRICT;

-- 개설강의과목
DROP TABLE IF EXISTS SE_OPEN_LECT_SUBJS RESTRICT;

-- 수강생
DROP TABLE IF EXISTS SE_LECT_STUDS RESTRICT;

-- 새 테이블
DROP TABLE IF EXISTS TABLE11 RESTRICT;

-- 과제
DROP TABLE IF EXISTS SE_TESTS RESTRICT;

-- 과제평가
DROP TABLE IF EXISTS SE_TEST_RESUS RESTRICT;

-- 교육자료
DROP TABLE IF EXISTS SE_LECT_FILES RESTRICT;

-- 강사과목
DROP TABLE IF EXISTS SE_TEACH_SUBJS RESTRICT;

-- 과제유형
DROP TABLE IF EXISTS SE_TEST_TYPES RESTRICT;

-- 과제상태
DROP TABLE IF EXISTS SE_TEST_RESU_TYPES RESTRICT;

-- 교육지원
DROP TABLE IF EXISTS SE_SUPPS RESTRICT;

-- 수강상태
DROP TABLE IF EXISTS SE_LECT_STATS RESTRICT;

-- 주문정보
CREATE TABLE ODERS (
  ONO      INTEGER  NOT NULL COMMENT '주문번호', -- 주문번호
  QTY      INTEGER  NULL     DEFAULT 1 COMMENT '주문수량', -- 주문수량
  ORD_DATE DATETIME NOT NULL COMMENT '주문일', -- 주문일
  CNO      INTEGER  NOT NULL COMMENT '고객번호', -- 고객번호
  PNO      INTEGER  NOT NULL COMMENT '제품번호' -- 제품번호
)
COMMENT '주문정보';

-- 주문정보
ALTER TABLE ODERS
  ADD CONSTRAINT PK_ODERS -- 주문정보 기본키
    PRIMARY KEY (
      ONO -- 주문번호
    );

-- 고객정보
CREATE TABLE CUSTOMERS (
  CNO      INTEGER      NOT NULL COMMENT '고객번호', -- 고객번호
  NAME     VARCHAR(50)  NOT NULL COMMENT '이름', -- 이름
  TEL      VARCHAR(30)  NULL     COMMENT '전화', -- 전화
  DET_ADDR VARCHAR(255) NULL     COMMENT '상세주소', -- 상세주소
  EMAIL    VARCHAR(40)  NOT NULL COMMENT '이메일', -- 이메일
  ANO      INTEGER      NULL     COMMENT '주소번호' -- 주소번호
)
COMMENT '고객정보';

-- 고객정보
ALTER TABLE CUSTOMERS
  ADD CONSTRAINT PK_CUSTOMERS -- 고객정보 기본키
    PRIMARY KEY (
      CNO -- 고객번호
    );

-- 고객정보 유니크 인덱스
CREATE UNIQUE INDEX UIX_CUSTOMERS
  ON CUSTOMERS ( -- 고객정보
    EMAIL ASC -- 이메일
  );

-- 고객정보 인덱스
CREATE INDEX IX_CUSTOMERS
  ON CUSTOMERS( -- 고객정보
    NAME ASC -- 이름
  );

-- 제품사진정보
CREATE TABLE PHOTOS (
  PHNO INTEGER      NOT NULL COMMENT '사진번호', -- 사진번호
  PATH VARCHAR(255) NOT NULL COMMENT '사진', -- 사진
  PNO  INTEGER      NOT NULL COMMENT '제품번호' -- 제품번호
)
COMMENT '제품사진정보';

-- 제품사진정보
ALTER TABLE PHOTOS
  ADD CONSTRAINT PK_PHOTOS -- 제품사진정보 기본키
    PRIMARY KEY (
      PHNO -- 사진번호
    );

-- 주소정보
CREATE TABLE ADDRS (
  ANO      INTEGER      NOT NULL COMMENT '주소번호', -- 주소번호
  POSTNO   VARCHAR(10)  NOT NULL COMMENT '우편번호', -- 우편번호
  BAS_ADDR VARCHAR(255) NOT NULL COMMENT '기본주소' -- 기본주소
)
COMMENT '주소정보';

-- 주소정보
ALTER TABLE ADDRS
  ADD CONSTRAINT PK_ADDRS -- 주소정보 기본키
    PRIMARY KEY (
      ANO -- 주소번호
    );

-- 주소정보 인덱스
CREATE INDEX IX_ADDRS
  ON ADDRS( -- 주소정보
    BAS_ADDR ASC -- 기본주소
  );

-- 제조사정보
CREATE TABLE MAKERS (
  COMP_CODE VARCHAR(20)  NOT NULL COMMENT '사업자번호', -- 사업자번호
  NAME      VARCHAR(50)  NOT NULL COMMENT '제조사', -- 제조사
  HOMEPAGE  VARCHAR(255) NOT NULL COMMENT '제조사홈페이지', -- 제조사홈페이지
  TEL       VARCHAR(30)  NULL     COMMENT '제조사전화' -- 제조사전화
)
COMMENT '제조사정보';

-- 제조사정보
ALTER TABLE MAKERS
  ADD CONSTRAINT PK_MAKERS -- 제조사정보 기본키
    PRIMARY KEY (
      COMP_CODE -- 사업자번호
    );

-- 제조사정보 인덱스
CREATE INDEX IX_MAKERS
  ON MAKERS( -- 제조사정보
    NAME ASC -- 제조사
  );

-- 제품정보
CREATE TABLE PRODUCTS (
  PNO       INTEGER      NOT NULL COMMENT '제품번호', -- 제품번호
  TITLE     VARCHAR(255) NOT NULL COMMENT '제품명', -- 제품명
  QTY       INTEGER      NOT NULL COMMENT '잔여수량', -- 잔여수량
  COMP_CODE VARCHAR(20)  NOT NULL COMMENT '사업자번호' -- 사업자번호
)
COMMENT '제품정보';

-- 제품정보
ALTER TABLE PRODUCTS
  ADD CONSTRAINT PK_PRODUCTS -- 제품정보 기본키
    PRIMARY KEY (
      PNO -- 제품번호
    );

-- 제품정보 인덱스
CREATE INDEX IX_PRODUCTS
  ON PRODUCTS( -- 제품정보
    TITLE ASC -- 제품명
  );

-- 직원정보
CREATE TABLE EMPLOYEES (
  CNO    INTEGER     NOT NULL COMMENT '고객번호', -- 고객번호
  IN_TEL VARCHAR(30) NOT NULL COMMENT '내선번호', -- 내선번호
  FAX    VARCHAR(30) NULL     COMMENT '팩스', -- 팩스
  POS    VARCHAR(50) NOT NULL COMMENT '직위', -- 직위
  TASK   VARCHAR(50) NULL     COMMENT '직책', -- 직책
  DEPT   VARCHAR(50) NOT NULL COMMENT '부서' -- 부서
)
COMMENT '직원정보';

-- 직원정보
ALTER TABLE EMPLOYEES
  ADD CONSTRAINT PK_EMPLOYEES -- 직원정보 기본키
    PRIMARY KEY (
      CNO -- 고객번호
    );

-- 강사
CREATE TABLE SE_TEACHS (
  UNO INTEGER NOT NULL COMMENT '강사번호', -- 강사번호
  SAL INTEGER NULL     COMMENT '강의료' -- 강의료
)
COMMENT '강사';

-- 강사
ALTER TABLE SE_TEACHS
  ADD CONSTRAINT PK_SE_TEACHS -- 강사 기본키
    PRIMARY KEY (
      UNO -- 강사번호
    );

-- 교육생
CREATE TABLE SE_STUDS (
  UNO      INTEGER      NOT NULL COMMENT '교육생번호', -- 교육생번호
  COMP     VARCHAR(50)  NULL     COMMENT '회사', -- 회사
  POS      VARCHAR(50)  NULL     COMMENT '직위', -- 직위
  STAT     INTEGER      NULL     COMMENT '재직여부', -- 재직여부
  LAST_SCH VARCHAR(255) NULL     COMMENT '최종학력', -- 최종학력
  ACCT     VARCHAR(20)  NULL     COMMENT '통장번호' -- 통장번호
)
COMMENT '교육생';

-- 교육생
ALTER TABLE SE_STUDS
  ADD CONSTRAINT PK_SE_STUDS -- 교육생 기본키
    PRIMARY KEY (
      UNO -- 교육생번호
    );

-- 관리자
CREATE TABLE SE_MGRS (
  UNO INTEGER     NOT NULL COMMENT '관리자번호', -- 관리자번호
  POS VARCHAR(50) NULL     COMMENT '직위' -- 직위
)
COMMENT '관리자';

-- 관리자
ALTER TABLE SE_MGRS
  ADD CONSTRAINT PK_SE_MGRS -- 관리자 기본키
    PRIMARY KEY (
      UNO -- 관리자번호
    );

-- 사용자
CREATE TABLE SE_USERS (
  UNO       INTEGER      NOT NULL COMMENT '사용자번호', -- 사용자번호
  EMAIL     VARCHAR(40)  NOT NULL COMMENT '이메일', -- 이메일
  PWD       VARCHAR(20)  NOT NULL COMMENT '암호', -- 암호
  NAME      VARCHAR(50)  NOT NULL COMMENT '이름', -- 이름
  TEL       VARCHAR(30)  NOT NULL COMMENT '전화', -- 전화
  FAX       VARCHAR(30)  NULL     COMMENT '팩스', -- 팩스
  POSTNO    VARCHAR(10)  NULL     COMMENT '우편번호', -- 우편번호
  ADDR      VARCHAR(255) NULL     COMMENT '주소', -- 주소
  PHOT_PATH VARCHAR(255) NULL     COMMENT '사진경로' -- 사진경로
)
COMMENT '사용자';

-- 사용자
ALTER TABLE SE_USERS
  ADD CONSTRAINT PK_SE_USERS -- 사용자 기본키
    PRIMARY KEY (
      UNO -- 사용자번호
    );

-- 사용자 유니크 인덱스
CREATE UNIQUE INDEX UIX_SE_USERS
  ON SE_USERS ( -- 사용자
    EMAIL ASC -- 이메일
  );

ALTER TABLE SE_USERS
  MODIFY COLUMN UNO INTEGER NOT NULL AUTO_INCREMENT COMMENT '사용자번호';

-- 교육과정
CREATE TABLE SE_COURS (
  CNO   INTEGER      NOT NULL COMMENT '교육과정번호', -- 교육과정번호
  TITLE VARCHAR(255) NOT NULL COMMENT '과정명', -- 과정명
  DEST  TEXT         NOT NULL COMMENT '설명', -- 설명
  HOURS INTEGER      NOT NULL COMMENT '교육시간' -- 교육시간
)
COMMENT '교육과정';

-- 교육과정
ALTER TABLE SE_COURS
  ADD CONSTRAINT PK_SE_COURS -- 교육과정 기본키
    PRIMARY KEY (
      CNO -- 교육과정번호
    );

-- 교육과정 유니크 인덱스
CREATE UNIQUE INDEX UIX_SE_COURS
  ON SE_COURS ( -- 교육과정
    TITLE ASC -- 과정명
  );

ALTER TABLE SE_COURS
  MODIFY COLUMN CNO INTEGER NOT NULL AUTO_INCREMENT COMMENT '교육과정번호';

-- 과목
CREATE TABLE SE_SUBJS (
  SNO   INTEGER      NOT NULL COMMENT '과목번호', -- 과목번호
  TITLE VARCHAR(255) NOT NULL COMMENT '과목명', -- 과목명
  DEST  TEXT         NOT NULL COMMENT '설명' -- 설명
)
COMMENT '과목';

-- 과목
ALTER TABLE SE_SUBJS
  ADD CONSTRAINT PK_SE_SUBJS -- 과목 기본키
    PRIMARY KEY (
      SNO -- 과목번호
    );

-- 과목 유니크 인덱스
CREATE UNIQUE INDEX UIX_SE_SUBJS
  ON SE_SUBJS ( -- 과목
    TITLE ASC -- 과목명
  );

ALTER TABLE SE_SUBJS
  MODIFY COLUMN SNO INTEGER NOT NULL AUTO_INCREMENT COMMENT '과목번호';

-- 커리큘럼
CREATE TABLE SE_COUR_SUBJS (
  CNO   INTEGER NOT NULL COMMENT '교육과정번호', -- 교육과정번호
  SNO   INTEGER NOT NULL COMMENT '과목번호', -- 과목번호
  SEQ   INTEGER NULL     COMMENT '순서', -- 순서
  HOURS INTEGER NULL     COMMENT '교육시간' -- 교육시간
)
COMMENT '커리큘럼';

-- 커리큘럼
ALTER TABLE SE_COUR_SUBJS
  ADD CONSTRAINT PK_SE_COUR_SUBJS -- 커리큘럼 기본키
    PRIMARY KEY (
      CNO, -- 교육과정번호
      SNO  -- 과목번호
    );

-- 개설강의
CREATE TABLE SE_OPEN_LECTS (
  OLNO  INTEGER      NOT NULL COMMENT '강의번호', -- 강의번호
  CNO   INTEGER      NOT NULL COMMENT '교육과정번호', -- 교육과정번호
  TITLE VARCHAR(255) NOT NULL COMMENT '개설강의명', -- 개설강의명
  ST_DT DATETIME     NOT NULL COMMENT '강의시작일', -- 강의시작일
  ED_DT DATETIME     NOT NULL COMMENT '강의종료일', -- 강의종료일
  SIZES INTEGER      NOT NULL COMMENT '모집인원', -- 모집인원
  UNO   INTEGER      NULL     COMMENT '관리자번호' -- 관리자번호
)
COMMENT '개설강의';

-- 개설강의
ALTER TABLE SE_OPEN_LECTS
  ADD CONSTRAINT PK_SE_OPEN_LECTS -- 개설강의 기본키
    PRIMARY KEY (
      OLNO -- 강의번호
    );

ALTER TABLE SE_OPEN_LECTS
  MODIFY COLUMN OLNO INTEGER NOT NULL AUTO_INCREMENT COMMENT '강의번호';

-- 개설강의과목
CREATE TABLE SE_OPEN_LECT_SUBJS (
  LSNO  INTEGER  NOT NULL COMMENT '과목강사번호', -- 과목강사번호
  OLNO  INTEGER  NOT NULL COMMENT '강의번호', -- 강의번호
  CNO   INTEGER  NOT NULL COMMENT '교육과정번호', -- 교육과정번호
  SNO   INTEGER  NOT NULL COMMENT '과목번호', -- 과목번호
  UNO   INTEGER  NOT NULL COMMENT '강사번호', -- 강사번호
  ST_DT DATETIME NULL     COMMENT '강의시작일', -- 강의시작일
  ED_DT DATETIME NULL     COMMENT '강의종료일', -- 강의종료일
  HOURS INTEGER  NULL     COMMENT '강의시간' -- 강의시간
)
COMMENT '개설강의과목';

-- 개설강의과목
ALTER TABLE SE_OPEN_LECT_SUBJS
  ADD CONSTRAINT PK_SE_OPEN_LECT_SUBJS -- 개설강의과목 기본키
    PRIMARY KEY (
      LSNO -- 과목강사번호
    );

ALTER TABLE SE_OPEN_LECT_SUBJS
  MODIFY COLUMN LSNO INTEGER NOT NULL AUTO_INCREMENT COMMENT '과목강사번호';

-- 수강생
CREATE TABLE SE_LECT_STUDS (
  LSNO  INTEGER NOT NULL COMMENT '수강생번호', -- 수강생번호
  OLNO  INTEGER NOT NULL COMMENT '강의번호', -- 강의번호
  UNO   INTEGER NOT NULL COMMENT '교육생번호', -- 교육생번호
  SUNO  INTEGER NOT NULL COMMENT '교육지원번호', -- 교육지원번호
  LSTNO INTEGER NULL     COMMENT '수강상태번호' -- 수강상태번호
)
COMMENT '수강생';

-- 수강생
ALTER TABLE SE_LECT_STUDS
  ADD CONSTRAINT PK_SE_LECT_STUDS -- 수강생 기본키
    PRIMARY KEY (
      LSNO -- 수강생번호
    );

-- 수강생 유니크 인덱스
CREATE UNIQUE INDEX UIX_SE_LECT_STUDS
  ON SE_LECT_STUDS ( -- 수강생
    OLNO ASC, -- 강의번호
    UNO ASC   -- 교육생번호
  );

ALTER TABLE SE_LECT_STUDS
  MODIFY COLUMN LSNO INTEGER NOT NULL AUTO_INCREMENT COMMENT '수강생번호';

-- 새 테이블
CREATE TABLE TABLE11 (
)
COMMENT '새 테이블';

-- 과제
CREATE TABLE SE_TESTS (
  TNO       INTEGER      NOT NULL COMMENT '과제번호', -- 과제번호
  OLNO      INTEGER      NOT NULL COMMENT '강의번호', -- 강의번호
  TTNO      INTEGER      NOT NULL COMMENT '과제유형번호', -- 과제유형번호
  TITLE     VARCHAR(255) NOT NULL COMMENT '과제명', -- 과제명
  DEST      TEXT         NOT NULL COMMENT '내용', -- 내용
  FILE_PATH VARCHAR(255) NULL     COMMENT '파일경로', -- 파일경로
  CR_DT     DATETIME     NOT NULL COMMENT '출제일', -- 출제일
  ED_DT     DATETIME     NOT NULL COMMENT '제출마감일' -- 제출마감일
)
COMMENT '과제';

-- 과제
ALTER TABLE SE_TESTS
  ADD CONSTRAINT PK_SE_TESTS -- 과제 기본키
    PRIMARY KEY (
      TNO -- 과제번호
    );

ALTER TABLE SE_TESTS
  MODIFY COLUMN TNO INTEGER NOT NULL AUTO_INCREMENT COMMENT '과제번호';

-- 과제평가
CREATE TABLE SE_TEST_RESUS (
  TNO       INTEGER      NOT NULL COMMENT '과제번호', -- 과제번호
  LSNO      INTEGER      NOT NULL COMMENT '수강생번호', -- 수강생번호
  CR_DT     DATETIME     NOT NULL COMMENT '제출일', -- 제출일
  FILE_PATH VARCHAR(255) NULL     COMMENT '파일경로', -- 파일경로
  GRAD      INTEGER      NOT NULL COMMENT '평가점수', -- 평가점수
  TRSNO     INTEGER      NOT NULL COMMENT '과제상태번호' -- 과제상태번호
)
COMMENT '과제평가';

-- 과제평가
ALTER TABLE SE_TEST_RESUS
  ADD CONSTRAINT PK_SE_TEST_RESUS -- 과제평가 기본키
    PRIMARY KEY (
      TNO,  -- 과제번호
      LSNO  -- 수강생번호
    );

-- 교육자료
CREATE TABLE SE_LECT_FILES (
  LFNO      INTEGER      NOT NULL COMMENT '교육자료번호', -- 교육자료번호
  OLNO      INTEGER      NOT NULL COMMENT '강의번호', -- 강의번호
  MSG       TEXT         NOT NULL COMMENT '내용', -- 내용
  FILE_PATH VARCHAR(255) NOT NULL COMMENT '파일경로', -- 파일경로
  UNO       INTEGER      NOT NULL COMMENT '사용자번호' -- 사용자번호
)
COMMENT '교육자료';

-- 교육자료
ALTER TABLE SE_LECT_FILES
  ADD CONSTRAINT PK_SE_LECT_FILES -- 교육자료 기본키
    PRIMARY KEY (
      LFNO -- 교육자료번호
    );

ALTER TABLE SE_LECT_FILES
  MODIFY COLUMN LFNO INTEGER NOT NULL AUTO_INCREMENT COMMENT '교육자료번호';

-- 강사과목
CREATE TABLE SE_TEACH_SUBJS (
  UNO  INTEGER NOT NULL COMMENT '강사번호', -- 강사번호
  SNO  INTEGER NOT NULL COMMENT '과목번호', -- 과목번호
  LEVL INTEGER NULL     COMMENT '수준' -- 수준
)
COMMENT '강사과목';

-- 강사과목
ALTER TABLE SE_TEACH_SUBJS
  ADD CONSTRAINT PK_SE_TEACH_SUBJS -- 강사과목 기본키
    PRIMARY KEY (
      UNO, -- 강사번호
      SNO  -- 과목번호
    );

-- 과제유형
CREATE TABLE SE_TEST_TYPES (
  TTNO  INTEGER     NOT NULL COMMENT '과제유형번호', -- 과제유형번호
  TITLE VARCHAR(50) NOT NULL COMMENT '과제유형명' -- 과제유형명
)
COMMENT '과제유형';

-- 과제유형
ALTER TABLE SE_TEST_TYPES
  ADD CONSTRAINT PK_SE_TEST_TYPES -- 과제유형 기본키
    PRIMARY KEY (
      TTNO -- 과제유형번호
    );

-- 과제유형 유니크 인덱스
CREATE UNIQUE INDEX UIX_SE_TEST_TYPES
  ON SE_TEST_TYPES ( -- 과제유형
    TITLE ASC -- 과제유형명
  );

ALTER TABLE SE_TEST_TYPES
  MODIFY COLUMN TTNO INTEGER NOT NULL AUTO_INCREMENT COMMENT '과제유형번호';

-- 과제상태
CREATE TABLE SE_TEST_RESU_TYPES (
  TRSNO INTEGER     NOT NULL COMMENT '과제상태번호', -- 과제상태번호
  TITLE VARCHAR(50) NOT NULL COMMENT '과제상태명' -- 과제상태명
)
COMMENT '과제상태';

-- 과제상태
ALTER TABLE SE_TEST_RESU_TYPES
  ADD CONSTRAINT PK_SE_TEST_RESU_TYPES -- 과제상태 기본키
    PRIMARY KEY (
      TRSNO -- 과제상태번호
    );

-- 과제상태 유니크 인덱스
CREATE UNIQUE INDEX UIX_SE_TEST_RESU_TYPES
  ON SE_TEST_RESU_TYPES ( -- 과제상태
    TITLE ASC -- 과제상태명
  );

ALTER TABLE SE_TEST_RESU_TYPES
  MODIFY COLUMN TRSNO INTEGER NOT NULL AUTO_INCREMENT COMMENT '과제상태번호';

-- 교육지원
CREATE TABLE SE_SUPPS (
  SUNO  INTEGER     NOT NULL COMMENT '교육지원번호', -- 교육지원번호
  TITLE VARCHAR(50) NOT NULL COMMENT '교육지원명' -- 교육지원명
)
COMMENT '교육지원';

-- 교육지원
ALTER TABLE SE_SUPPS
  ADD CONSTRAINT PK_SE_SUPPS -- 교육지원 기본키
    PRIMARY KEY (
      SUNO -- 교육지원번호
    );

-- 교육지원 유니크 인덱스
CREATE UNIQUE INDEX UIX_SE_SUPPS
  ON SE_SUPPS ( -- 교육지원
    TITLE ASC -- 교육지원명
  );

ALTER TABLE SE_SUPPS
  MODIFY COLUMN SUNO INTEGER NOT NULL AUTO_INCREMENT COMMENT '교육지원번호';

-- 수강상태
CREATE TABLE SE_LECT_STATS (
  LSTNO INTEGER     NOT NULL COMMENT '수강상태번호', -- 수강상태번호
  TITLE VARCHAR(50) NULL     COMMENT '수강상태명' -- 수강상태명
)
COMMENT '수강상태';

-- 수강상태
ALTER TABLE SE_LECT_STATS
  ADD CONSTRAINT PK_SE_LECT_STATS -- 수강상태 기본키
    PRIMARY KEY (
      LSTNO -- 수강상태번호
    );

-- 수강상태 유니크 인덱스
CREATE UNIQUE INDEX UIX_SE_LECT_STATS
  ON SE_LECT_STATS ( -- 수강상태
    TITLE ASC -- 수강상태명
  );

ALTER TABLE SE_LECT_STATS
  MODIFY COLUMN LSTNO INTEGER NOT NULL AUTO_INCREMENT COMMENT '수강상태번호';

-- 주문정보
ALTER TABLE ODERS
  ADD CONSTRAINT FK_CUSTOMERS_TO_ODERS -- 고객정보 -> 주문정보
    FOREIGN KEY (
      CNO -- 고객번호
    )
    REFERENCES CUSTOMERS ( -- 고객정보
      CNO -- 고객번호
    );

-- 주문정보
ALTER TABLE ODERS
  ADD CONSTRAINT FK_PRODUCTS_TO_ODERS -- 제품정보 -> 주문정보
    FOREIGN KEY (
      PNO -- 제품번호
    )
    REFERENCES PRODUCTS ( -- 제품정보
      PNO -- 제품번호
    );

-- 고객정보
ALTER TABLE CUSTOMERS
  ADD CONSTRAINT FK_ADDRS_TO_CUSTOMERS -- 주소정보 -> 고객정보
    FOREIGN KEY (
      ANO -- 주소번호
    )
    REFERENCES ADDRS ( -- 주소정보
      ANO -- 주소번호
    );

-- 제품사진정보
ALTER TABLE PHOTOS
  ADD CONSTRAINT FK_PRODUCTS_TO_PHOTOS -- 제품정보 -> 제품사진정보
    FOREIGN KEY (
      PNO -- 제품번호
    )
    REFERENCES PRODUCTS ( -- 제품정보
      PNO -- 제품번호
    );

-- 제품정보
ALTER TABLE PRODUCTS
  ADD CONSTRAINT FK_MAKERS_TO_PRODUCTS -- 제조사정보 -> 제품정보
    FOREIGN KEY (
      COMP_CODE -- 사업자번호
    )
    REFERENCES MAKERS ( -- 제조사정보
      COMP_CODE -- 사업자번호
    );

-- 직원정보
ALTER TABLE EMPLOYEES
  ADD CONSTRAINT FK_CUSTOMERS_TO_EMPLOYEES -- 고객정보 -> 직원정보
    FOREIGN KEY (
      CNO -- 고객번호
    )
    REFERENCES CUSTOMERS ( -- 고객정보
      CNO -- 고객번호
    );

-- 강사
ALTER TABLE SE_TEACHS
  ADD CONSTRAINT FK_SE_USERS_TO_SE_TEACHS -- 사용자 -> 강사
    FOREIGN KEY (
      UNO -- 강사번호
    )
    REFERENCES SE_USERS ( -- 사용자
      UNO -- 사용자번호
    );

-- 교육생
ALTER TABLE SE_STUDS
  ADD CONSTRAINT FK_SE_USERS_TO_SE_STUDS -- 사용자 -> 교육생
    FOREIGN KEY (
      UNO -- 교육생번호
    )
    REFERENCES SE_USERS ( -- 사용자
      UNO -- 사용자번호
    );

-- 관리자
ALTER TABLE SE_MGRS
  ADD CONSTRAINT FK_SE_USERS_TO_SE_MGRS -- 사용자 -> 관리자
    FOREIGN KEY (
      UNO -- 관리자번호
    )
    REFERENCES SE_USERS ( -- 사용자
      UNO -- 사용자번호
    );

-- 커리큘럼
ALTER TABLE SE_COUR_SUBJS
  ADD CONSTRAINT FK_SE_COURS_TO_SE_COUR_SUBJS -- 교육과정 -> 커리큘럼
    FOREIGN KEY (
      CNO -- 교육과정번호
    )
    REFERENCES SE_COURS ( -- 교육과정
      CNO -- 교육과정번호
    );

-- 커리큘럼
ALTER TABLE SE_COUR_SUBJS
  ADD CONSTRAINT FK_SE_SUBJS_TO_SE_COUR_SUBJS -- 과목 -> 커리큘럼
    FOREIGN KEY (
      SNO -- 과목번호
    )
    REFERENCES SE_SUBJS ( -- 과목
      SNO -- 과목번호
    );

-- 개설강의
ALTER TABLE SE_OPEN_LECTS
  ADD CONSTRAINT FK_SE_COURS_TO_SE_OPEN_LECTS -- 교육과정 -> 개설강의
    FOREIGN KEY (
      CNO -- 교육과정번호
    )
    REFERENCES SE_COURS ( -- 교육과정
      CNO -- 교육과정번호
    );

-- 개설강의
ALTER TABLE SE_OPEN_LECTS
  ADD CONSTRAINT FK_SE_MGRS_TO_SE_OPEN_LECTS -- 관리자 -> 개설강의
    FOREIGN KEY (
      UNO -- 관리자번호
    )
    REFERENCES SE_MGRS ( -- 관리자
      UNO -- 관리자번호
    );

-- 개설강의과목
ALTER TABLE SE_OPEN_LECT_SUBJS
  ADD CONSTRAINT FK_SE_COUR_SUBJS_TO_SE_OPEN_LECT_SUBJS -- 커리큘럼 -> 개설강의과목
    FOREIGN KEY (
      CNO, -- 교육과정번호
      SNO  -- 과목번호
    )
    REFERENCES SE_COUR_SUBJS ( -- 커리큘럼
      CNO, -- 교육과정번호
      SNO  -- 과목번호
    );

-- 개설강의과목
ALTER TABLE SE_OPEN_LECT_SUBJS
  ADD CONSTRAINT FK_SE_TEACHS_TO_SE_OPEN_LECT_SUBJS -- 강사 -> 개설강의과목
    FOREIGN KEY (
      UNO -- 강사번호
    )
    REFERENCES SE_TEACHS ( -- 강사
      UNO -- 강사번호
    );

-- 개설강의과목
ALTER TABLE SE_OPEN_LECT_SUBJS
  ADD CONSTRAINT FK_SE_OPEN_LECTS_TO_SE_OPEN_LECT_SUBJS -- 개설강의 -> 개설강의과목
    FOREIGN KEY (
      OLNO -- 강의번호
    )
    REFERENCES SE_OPEN_LECTS ( -- 개설강의
      OLNO -- 강의번호
    );

-- 수강생
ALTER TABLE SE_LECT_STUDS
  ADD CONSTRAINT FK_SE_OPEN_LECTS_TO_SE_LECT_STUDS -- 개설강의 -> 수강생
    FOREIGN KEY (
      OLNO -- 강의번호
    )
    REFERENCES SE_OPEN_LECTS ( -- 개설강의
      OLNO -- 강의번호
    );

-- 수강생
ALTER TABLE SE_LECT_STUDS
  ADD CONSTRAINT FK_SE_STUDS_TO_SE_LECT_STUDS -- 교육생 -> 수강생
    FOREIGN KEY (
      UNO -- 교육생번호
    )
    REFERENCES SE_STUDS ( -- 교육생
      UNO -- 교육생번호
    );

-- 수강생
ALTER TABLE SE_LECT_STUDS
  ADD CONSTRAINT FK_SE_SUPPS_TO_SE_LECT_STUDS -- 교육지원 -> 수강생
    FOREIGN KEY (
      SUNO -- 교육지원번호
    )
    REFERENCES SE_SUPPS ( -- 교육지원
      SUNO -- 교육지원번호
    );

-- 수강생
ALTER TABLE SE_LECT_STUDS
  ADD CONSTRAINT FK_SE_LECT_STATS_TO_SE_LECT_STUDS -- 수강상태 -> 수강생
    FOREIGN KEY (
      LSTNO -- 수강상태번호
    )
    REFERENCES SE_LECT_STATS ( -- 수강상태
      LSTNO -- 수강상태번호
    );

-- 과제
ALTER TABLE SE_TESTS
  ADD CONSTRAINT FK_SE_OPEN_LECTS_TO_SE_TESTS -- 개설강의 -> 과제
    FOREIGN KEY (
      OLNO -- 강의번호
    )
    REFERENCES SE_OPEN_LECTS ( -- 개설강의
      OLNO -- 강의번호
    );

-- 과제
ALTER TABLE SE_TESTS
  ADD CONSTRAINT FK_SE_TEST_TYPES_TO_SE_TESTS -- 과제유형 -> 과제
    FOREIGN KEY (
      TTNO -- 과제유형번호
    )
    REFERENCES SE_TEST_TYPES ( -- 과제유형
      TTNO -- 과제유형번호
    );

-- 과제평가
ALTER TABLE SE_TEST_RESUS
  ADD CONSTRAINT FK_SE_LECT_STUDS_TO_SE_TEST_RESUS -- 수강생 -> 과제평가
    FOREIGN KEY (
      LSNO -- 수강생번호
    )
    REFERENCES SE_LECT_STUDS ( -- 수강생
      LSNO -- 수강생번호
    );

-- 과제평가
ALTER TABLE SE_TEST_RESUS
  ADD CONSTRAINT FK_SE_TESTS_TO_SE_TEST_RESUS -- 과제 -> 과제평가
    FOREIGN KEY (
      TNO -- 과제번호
    )
    REFERENCES SE_TESTS ( -- 과제
      TNO -- 과제번호
    );

-- 과제평가
ALTER TABLE SE_TEST_RESUS
  ADD CONSTRAINT FK_SE_TEST_RESU_TYPES_TO_SE_TEST_RESUS -- 과제상태 -> 과제평가
    FOREIGN KEY (
      TRSNO -- 과제상태번호
    )
    REFERENCES SE_TEST_RESU_TYPES ( -- 과제상태
      TRSNO -- 과제상태번호
    );

-- 교육자료
ALTER TABLE SE_LECT_FILES
  ADD CONSTRAINT FK_SE_OPEN_LECTS_TO_SE_LECT_FILES -- 개설강의 -> 교육자료
    FOREIGN KEY (
      OLNO -- 강의번호
    )
    REFERENCES SE_OPEN_LECTS ( -- 개설강의
      OLNO -- 강의번호
    );

-- 교육자료
ALTER TABLE SE_LECT_FILES
  ADD CONSTRAINT FK_SE_USERS_TO_SE_LECT_FILES -- 사용자 -> 교육자료
    FOREIGN KEY (
      UNO -- 사용자번호
    )
    REFERENCES SE_USERS ( -- 사용자
      UNO -- 사용자번호
    );

-- 강사과목
ALTER TABLE SE_TEACH_SUBJS
  ADD CONSTRAINT FK_SE_TEACHS_TO_SE_TEACH_SUBJS -- 강사 -> 강사과목
    FOREIGN KEY (
      UNO -- 강사번호
    )
    REFERENCES SE_TEACHS ( -- 강사
      UNO -- 강사번호
    );

-- 강사과목
ALTER TABLE SE_TEACH_SUBJS
  ADD CONSTRAINT FK_SE_SUBJS_TO_SE_TEACH_SUBJS -- 과목 -> 강사과목
    FOREIGN KEY (
      SNO -- 과목번호
    )
    REFERENCES SE_SUBJS ( -- 과목
      SNO -- 과목번호
=======
-- 과제평가
DROP TABLE IF EXISTS SE_TEST_RESUS RESTRICT;

-- 과제상태
DROP TABLE IF EXISTS SE_TEST_RESU_TYPES RESTRICT;

-- 수강생
DROP TABLE IF EXISTS SE_LECT_STUDS RESTRICT;

-- 교육지원
DROP TABLE IF EXISTS SE_SUPPS RESTRICT;

-- 수강상태
DROP TABLE IF EXISTS SE_LECT_STATS RESTRICT;

-- 교육자료
DROP TABLE IF EXISTS SE_LECT_FILES RESTRICT;

-- 과제
DROP TABLE IF EXISTS SE_TESTS RESTRICT;

-- 과제유형
DROP TABLE IF EXISTS SE_TEST_TYPES RESTRICT;

-- 개설강의과목
DROP TABLE IF EXISTS SE_OPEN_LECT_SUBJS RESTRICT;

-- 개설강의
DROP TABLE IF EXISTS SE_OPEN_LECTS RESTRICT;

-- 커리큘럼
DROP TABLE IF EXISTS SE_COUR_SUBJS RESTRICT;

-- 커리큘럼
DROP TABLE IF EXISTS SE_COURS RESTRICT;

-- 강사과목
DROP TABLE IF EXISTS SE_TEACH_SUBJS RESTRICT;

-- 과목
DROP TABLE IF EXISTS SE_SUBJS RESTRICT;

-- 관리자
DROP TABLE IF EXISTS SE_MGRS RESTRICT;

-- 강사
DROP TABLE IF EXISTS SE_TEACHS RESTRICT;

-- 교육생
DROP TABLE IF EXISTS SE_STUDS RESTRICT;

-- 사용자
DROP TABLE IF EXISTS SE_USERS RESTRICT;


-- 강사
CREATE TABLE SE_TEACHS (
  UNO INTEGER NOT NULL COMMENT '강사번호', -- 강사번호
  SAL INTEGER NULL     COMMENT '강의료' -- 강의료
)
COMMENT '강사';

-- 강사
ALTER TABLE SE_TEACHS
  ADD CONSTRAINT PK_SE_TEACHS -- 강사 기본키
    PRIMARY KEY (
      UNO -- 강사번호
    );

-- 교육생
CREATE TABLE SE_STUDS (
  UNO      INTEGER      NOT NULL COMMENT '교육생번호', -- 교육생번호
  COMP     VARCHAR(50)  NULL     COMMENT '회사', -- 회사
  POS      VARCHAR(50)  NULL     COMMENT '직위', -- 직위
  STAT     INTEGER      NULL     COMMENT '재직여부', -- 재직여부
  LAST_SCH VARCHAR(255) NULL     COMMENT '최종학력', -- 최종학력
  ACCT     VARCHAR(20)  NULL     COMMENT '통장번호' -- 통장번호
)
COMMENT '교육생';

-- 교육생
ALTER TABLE SE_STUDS
  ADD CONSTRAINT PK_SE_STUDS -- 교육생 기본키
    PRIMARY KEY (
      UNO -- 교육생번호
    );

-- 관리자
CREATE TABLE SE_MGRS (
  UNO INTEGER     NOT NULL COMMENT '관리자번호', -- 관리자번호
  POS VARCHAR(50) NULL     COMMENT '직위' -- 직위
)
COMMENT '관리자';

-- 관리자
ALTER TABLE SE_MGRS
  ADD CONSTRAINT PK_SE_MGRS -- 관리자 기본키
    PRIMARY KEY (
      UNO -- 관리자번호
    );

-- 사용자
CREATE TABLE SE_USERS (
  UNO       INTEGER      NOT NULL COMMENT '사용자번호', -- 사용자번호
  EMAIL     VARCHAR(40)  NOT NULL COMMENT '이메일', -- 이메일
  PWD       VARCHAR(20)  NOT NULL COMMENT '암호', -- 암호
  NAME      VARCHAR(50)  NOT NULL COMMENT '이름', -- 이름
  TEL       VARCHAR(30)  NOT NULL COMMENT '전화', -- 전화
  FAX       VARCHAR(30)  NULL     COMMENT '팩스', -- 팩스
  POSTNO    VARCHAR(10)  NULL     COMMENT '우편번호', -- 우편번호
  ADDR      VARCHAR(255) NULL     COMMENT '주소', -- 주소
  PHOT_PATH VARCHAR(255) NULL     COMMENT '사진경로' -- 사진경로
)
COMMENT '사용자';

-- 사용자
ALTER TABLE SE_USERS
  ADD CONSTRAINT PK_SE_USERS -- 사용자 기본키
    PRIMARY KEY (
      UNO -- 사용자번호
    );

-- 사용자 유니크 인덱스
CREATE UNIQUE INDEX UIX_SE_USERS
  ON SE_USERS ( -- 사용자
    EMAIL ASC -- 이메일
  );

-- 교육과정
CREATE TABLE SE_COURS (
  CNO   INTEGER      NOT NULL COMMENT '교육과정번호', -- 교육과정번호
  TITLE VARCHAR(255) NOT NULL COMMENT '과정명', -- 과정명
  DEST  TEXT         NOT NULL COMMENT '설명', -- 설명
  HOURS INTEGER      NOT NULL COMMENT '교육시간' -- 교육시간
)
COMMENT '교육과정';

-- 교육과정
ALTER TABLE SE_COURS
  ADD CONSTRAINT PK_SE_COURS -- 교육과정 기본키
    PRIMARY KEY (
      CNO -- 교육과정번호
    );

-- 교육과정 유니크 인덱스
CREATE UNIQUE INDEX UIX_SE_COURS
  ON SE_COURS ( -- 교육과정
    TITLE ASC -- 과정명
  );

-- 과목
CREATE TABLE SE_SUBJS (
  SNO   INTEGER      NOT NULL COMMENT '과목번호', -- 과목번호
  TITLE VARCHAR(255) NOT NULL COMMENT '과목명', -- 과목명
  DEST  TEXT         NOT NULL COMMENT '설명' -- 설명
)
COMMENT '과목';

-- 과목
ALTER TABLE SE_SUBJS
  ADD CONSTRAINT PK_SE_SUBJS -- 과목 기본키
    PRIMARY KEY (
      SNO -- 과목번호
    );

-- 과목 유니크 인덱스
CREATE UNIQUE INDEX UIX_SE_SUBJS
  ON SE_SUBJS ( -- 과목
    TITLE ASC -- 과목명
  );

-- 커리큘럼
CREATE TABLE SE_COUR_SUBJS (
  CNO   INTEGER NOT NULL COMMENT '교육과정번호', -- 교육과정번호
  SNO   INTEGER NOT NULL COMMENT '과목번호', -- 과목번호
  SEQ   INTEGER NULL     COMMENT '순서', -- 순서
  HOURS INTEGER NULL     COMMENT '교육시간' -- 교육시간
)
COMMENT '커리큘럼';

-- 커리큘럼
ALTER TABLE SE_COUR_SUBJS
  ADD CONSTRAINT PK_SE_COUR_SUBJS -- 커리큘럼 기본키
    PRIMARY KEY (
      CNO, -- 교육과정번호
      SNO  -- 과목번호
    );

-- 개설강의
CREATE TABLE SE_OPEN_LECTS (
  OLNO  INTEGER      NOT NULL COMMENT '강의번호', -- 강의번호
  CNO   INTEGER      NOT NULL COMMENT '교육과정번호', -- 교육과정번호
  TITLE VARCHAR(255) NOT NULL COMMENT '개설강의명', -- 개설강의명
  ST_DT DATETIME     NOT NULL COMMENT '강의시작일', -- 강의시작일
  ED_DT DATETIME     NOT NULL COMMENT '강의종료일', -- 강의종료일
  SIZES INTEGER      NOT NULL COMMENT '모집인원', -- 모집인원
  UNO   INTEGER      NULL     COMMENT '관리자번호' -- 관리자번호
)
COMMENT '개설강의';

-- 개설강의
ALTER TABLE SE_OPEN_LECTS
  ADD CONSTRAINT PK_SE_OPEN_LECTS -- 개설강의 기본키
    PRIMARY KEY (
      OLNO -- 강의번호
    );

-- 개설강의과목
CREATE TABLE SE_OPEN_LECT_SUBJS (
  LSNO  INTEGER  NOT NULL COMMENT '과목강사번호', -- 과목강사번호
  OLNO  INTEGER  NOT NULL COMMENT '강의번호', -- 강의번호
  CNO   INTEGER  NOT NULL COMMENT '교육과정번호', -- 교육과정번호
  SNO   INTEGER  NOT NULL COMMENT '과목번호', -- 과목번호
  UNO   INTEGER  NOT NULL COMMENT '강사번호', -- 강사번호
  ST_DT DATETIME NULL     COMMENT '강의시작일', -- 강의시작일
  ED_DT DATETIME NULL     COMMENT '강의종료일', -- 강의종료일
  HOURS INTEGER  NULL     COMMENT '강의시간' -- 강의시간
)
COMMENT '개설강의과목';

-- 개설강의과목
ALTER TABLE SE_OPEN_LECT_SUBJS
  ADD CONSTRAINT PK_SE_OPEN_LECT_SUBJS -- 개설강의과목 기본키
    PRIMARY KEY (
      LSNO -- 과목강사번호
    );

-- 수강생
CREATE TABLE SE_LECT_STUDS (
  LSNO  INTEGER NOT NULL COMMENT '수강생번호', -- 수강생번호
  OLNO  INTEGER NOT NULL COMMENT '강의번호', -- 강의번호
  UNO   INTEGER NOT NULL COMMENT '교육생번호', -- 교육생번호
  SUNO  INTEGER NOT NULL COMMENT '교육지원번호', -- 교육지원번호
  LSTNO INTEGER NULL     COMMENT '수강상태번호' -- 수강상태번호
)
COMMENT '수강생';

-- 수강생
ALTER TABLE SE_LECT_STUDS
  ADD CONSTRAINT PK_SE_LECT_STUDS -- 수강생 기본키
    PRIMARY KEY (
      LSNO -- 수강생번호
    );

-- 수강생 유니크 인덱스
CREATE UNIQUE INDEX UIX_SE_LECT_STUDS
  ON SE_LECT_STUDS ( -- 수강생
    OLNO ASC, -- 강의번호
    UNO ASC   -- 교육생번호
  );

-- 과제
CREATE TABLE SE_TESTS (
  TNO       INTEGER      NOT NULL COMMENT '과제번호', -- 과제번호
  OLNO      INTEGER      NOT NULL COMMENT '강의번호', -- 강의번호
  TTNO      INTEGER      NOT NULL COMMENT '과제유형번호', -- 과제유형번호
  TITLE     VARCHAR(255) NOT NULL COMMENT '과제명', -- 과제명
  DEST      TEXT         NOT NULL COMMENT '내용', -- 내용
  FILE_PATH VARCHAR(255) NULL     COMMENT '파일경로', -- 파일경로
  CR_DT     DATETIME     NOT NULL COMMENT '출제일', -- 출제일
  ED_DT     DATETIME     NOT NULL COMMENT '제출마감일' -- 제출마감일
)
COMMENT '과제';

-- 과제
ALTER TABLE SE_TESTS
  ADD CONSTRAINT PK_SE_TESTS -- 과제 기본키
    PRIMARY KEY (
      TNO -- 과제번호
    );

-- 과제평가
CREATE TABLE SE_TEST_RESUS (
  TNO       INTEGER      NOT NULL COMMENT '과제번호', -- 과제번호
  LSNO      INTEGER      NOT NULL COMMENT '수강생번호', -- 수강생번호
  CR_DT     DATETIME     NOT NULL COMMENT '제출일', -- 제출일
  FILE_PATH VARCHAR(255) NULL     COMMENT '파일경로', -- 파일경로
  GRAD      INTEGER      NOT NULL COMMENT '평가점수', -- 평가점수
  TRSNO     INTEGER      NOT NULL COMMENT '과제상태번호' -- 과제상태번호
)
COMMENT '과제평가';

-- 과제평가
ALTER TABLE SE_TEST_RESUS
  ADD CONSTRAINT PK_SE_TEST_RESUS -- 과제평가 기본키
    PRIMARY KEY (
      TNO,  -- 과제번호
      LSNO  -- 수강생번호
    );

-- 교육자료
CREATE TABLE SE_LECT_FILES (
  LFNO      INTEGER      NOT NULL COMMENT '교육자료번호', -- 교육자료번호
  OLNO      INTEGER      NOT NULL COMMENT '강의번호', -- 강의번호
  MSG       TEXT         NOT NULL COMMENT '내용', -- 내용
  FILE_PATH VARCHAR(255) NOT NULL COMMENT '파일경로', -- 파일경로
  UNO       INTEGER      NOT NULL COMMENT '사용자번호' -- 사용자번호
)
COMMENT '교육자료';

-- 교육자료
ALTER TABLE SE_LECT_FILES
  ADD CONSTRAINT PK_SE_LECT_FILES -- 교육자료 기본키
    PRIMARY KEY (
      LFNO -- 교육자료번호
    );

-- 강사과목
CREATE TABLE SE_TEACH_SUBJS (
  UNO  INTEGER NOT NULL COMMENT '강사번호', -- 강사번호
  SNO  INTEGER NOT NULL COMMENT '과목번호', -- 과목번호
  LEVL INTEGER NULL     COMMENT '수준' -- 수준
)
COMMENT '강사과목';

-- 강사과목
ALTER TABLE SE_TEACH_SUBJS
  ADD CONSTRAINT PK_SE_TEACH_SUBJS -- 강사과목 기본키
    PRIMARY KEY (
      UNO, -- 강사번호
      SNO  -- 과목번호
    );

-- 과제유형
CREATE TABLE SE_TEST_TYPES (
  TTNO  INTEGER     NOT NULL COMMENT '과제유형번호', -- 과제유형번호
  TITLE VARCHAR(50) NOT NULL COMMENT '과제유형명' -- 과제유형명
)
COMMENT '과제유형';

-- 과제유형
ALTER TABLE SE_TEST_TYPES
  ADD CONSTRAINT PK_SE_TEST_TYPES -- 과제유형 기본키
    PRIMARY KEY (
      TTNO -- 과제유형번호
    );

-- 과제유형 유니크 인덱스
CREATE UNIQUE INDEX UIX_SE_TEST_TYPES
  ON SE_TEST_TYPES ( -- 과제유형
    TITLE ASC -- 과제유형명
  );

-- 과제상태
CREATE TABLE SE_TEST_RESU_TYPES (
  TRSNO INTEGER     NOT NULL COMMENT '과제상태번호', -- 과제상태번호
  TITLE VARCHAR(50) NOT NULL COMMENT '과제상태명' -- 과제상태명
)
COMMENT '과제상태';

-- 과제상태
ALTER TABLE SE_TEST_RESU_TYPES
  ADD CONSTRAINT PK_SE_TEST_RESU_TYPES -- 과제상태 기본키
    PRIMARY KEY (
      TRSNO -- 과제상태번호
    );

-- 과제상태 유니크 인덱스
CREATE UNIQUE INDEX UIX_SE_TEST_RESU_TYPES
  ON SE_TEST_RESU_TYPES ( -- 과제상태
    TITLE ASC -- 과제상태명
  );

-- 교육지원
CREATE TABLE SE_SUPPS (
  SUNO  INTEGER     NOT NULL COMMENT '교육지원번호', -- 교육지원번호
  TITLE VARCHAR(50) NOT NULL COMMENT '교육지원명' -- 교육지원명
)
COMMENT '교육지원';

-- 교육지원
ALTER TABLE SE_SUPPS
  ADD CONSTRAINT PK_SE_SUPPS -- 교육지원 기본키
    PRIMARY KEY (
      SUNO -- 교육지원번호
    );

-- 교육지원 유니크 인덱스
CREATE UNIQUE INDEX UIX_SE_SUPPS
  ON SE_SUPPS ( -- 교육지원
    TITLE ASC -- 교육지원명
  );

-- 수강상태
CREATE TABLE SE_LECT_STATS (
  LSTNO INTEGER     NOT NULL COMMENT '수강상태번호', -- 수강상태번호
  TITLE VARCHAR(50) NULL     COMMENT '수강상태명' -- 수강상태명
)
COMMENT '수강상태';

-- 수강상태
ALTER TABLE SE_LECT_STATS
  ADD CONSTRAINT PK_SE_LECT_STATS -- 수강상태 기본키
    PRIMARY KEY (
      LSTNO -- 수강상태번호
    );

-- 수강상태 유니크 인덱스
CREATE UNIQUE INDEX UIX_SE_LECT_STATS
  ON SE_LECT_STATS ( -- 수강상태
    TITLE ASC -- 수강상태명
  );

-- 강사
ALTER TABLE SE_TEACHS
  ADD CONSTRAINT FK_SE_USERS_TO_SE_TEACHS -- 사용자 -> 강사
    FOREIGN KEY (
      UNO -- 강사번호
    )
    REFERENCES SE_USERS ( -- 사용자
      UNO -- 사용자번호
    );

-- 교육생
ALTER TABLE SE_STUDS
  ADD CONSTRAINT FK_SE_USERS_TO_SE_STUDS -- 사용자 -> 교육생
    FOREIGN KEY (
      UNO -- 교육생번호
    )
    REFERENCES SE_USERS ( -- 사용자
      UNO -- 사용자번호
    );

-- 관리자
ALTER TABLE SE_MGRS
  ADD CONSTRAINT FK_SE_USERS_TO_SE_MGRS -- 사용자 -> 관리자
    FOREIGN KEY (
      UNO -- 관리자번호
    )
    REFERENCES SE_USERS ( -- 사용자
      UNO -- 사용자번호
    );

-- 커리큘럼
ALTER TABLE SE_COUR_SUBJS
  ADD CONSTRAINT FK_SE_COURS_TO_SE_COUR_SUBJS -- 교육과정 -> 커리큘럼
    FOREIGN KEY (
      CNO -- 교육과정번호
    )
    REFERENCES SE_COURS ( -- 교육과정
      CNO -- 교육과정번호
    );

-- 커리큘럼
ALTER TABLE SE_COUR_SUBJS
  ADD CONSTRAINT FK_SE_SUBJS_TO_SE_COUR_SUBJS -- 과목 -> 커리큘럼
    FOREIGN KEY (
      SNO -- 과목번호
    )
    REFERENCES SE_SUBJS ( -- 과목
      SNO -- 과목번호
    );

-- 개설강의
ALTER TABLE SE_OPEN_LECTS
  ADD CONSTRAINT FK_SE_COURS_TO_SE_OPEN_LECTS -- 교육과정 -> 개설강의
    FOREIGN KEY (
      CNO -- 교육과정번호
    )
    REFERENCES SE_COURS ( -- 교육과정
      CNO -- 교육과정번호
    );

-- 개설강의
ALTER TABLE SE_OPEN_LECTS
  ADD CONSTRAINT FK_SE_MGRS_TO_SE_OPEN_LECTS -- 관리자 -> 개설강의
    FOREIGN KEY (
      UNO -- 관리자번호
    )
    REFERENCES SE_MGRS ( -- 관리자
      UNO -- 관리자번호
    );

-- 개설강의과목
ALTER TABLE SE_OPEN_LECT_SUBJS
  ADD CONSTRAINT FK_SE_COUR_SUBJS_TO_SE_OPEN_LECT_SUBJS -- 커리큘럼 -> 개설강의과목
    FOREIGN KEY (
      CNO, -- 교육과정번호
      SNO  -- 과목번호
    )
    REFERENCES SE_COUR_SUBJS ( -- 커리큘럼
      CNO, -- 교육과정번호
      SNO  -- 과목번호
    );

-- 개설강의과목
ALTER TABLE SE_OPEN_LECT_SUBJS
  ADD CONSTRAINT FK_SE_TEACHS_TO_SE_OPEN_LECT_SUBJS -- 강사 -> 개설강의과목
    FOREIGN KEY (
      UNO -- 강사번호
    )
    REFERENCES SE_TEACHS ( -- 강사
      UNO -- 강사번호
    );

-- 개설강의과목
ALTER TABLE SE_OPEN_LECT_SUBJS
  ADD CONSTRAINT FK_SE_OPEN_LECTS_TO_SE_OPEN_LECT_SUBJS -- 개설강의 -> 개설강의과목
    FOREIGN KEY (
      OLNO -- 강의번호
    )
    REFERENCES SE_OPEN_LECTS ( -- 개설강의
      OLNO -- 강의번호
    );

-- 수강생
ALTER TABLE SE_LECT_STUDS
  ADD CONSTRAINT FK_SE_OPEN_LECTS_TO_SE_LECT_STUDS -- 개설강의 -> 수강생
    FOREIGN KEY (
      OLNO -- 강의번호
    )
    REFERENCES SE_OPEN_LECTS ( -- 개설강의
      OLNO -- 강의번호
    );

-- 수강생
ALTER TABLE SE_LECT_STUDS
  ADD CONSTRAINT FK_SE_STUDS_TO_SE_LECT_STUDS -- 교육생 -> 수강생
    FOREIGN KEY (
      UNO -- 교육생번호
    )
    REFERENCES SE_STUDS ( -- 교육생
      UNO -- 교육생번호
    );

-- 수강생
ALTER TABLE SE_LECT_STUDS
  ADD CONSTRAINT FK_SE_SUPPS_TO_SE_LECT_STUDS -- 교육지원 -> 수강생
    FOREIGN KEY (
      SUNO -- 교육지원번호
    )
    REFERENCES SE_SUPPS ( -- 교육지원
      SUNO -- 교육지원번호
    );

-- 수강생
ALTER TABLE SE_LECT_STUDS
  ADD CONSTRAINT FK_SE_LECT_STATS_TO_SE_LECT_STUDS -- 수강상태 -> 수강생
    FOREIGN KEY (
      LSTNO -- 수강상태번호
    )
    REFERENCES SE_LECT_STATS ( -- 수강상태
      LSTNO -- 수강상태번호
    );

-- 과제
ALTER TABLE SE_TESTS
  ADD CONSTRAINT FK_SE_OPEN_LECTS_TO_SE_TESTS -- 개설강의 -> 과제
    FOREIGN KEY (
      OLNO -- 강의번호
    )
    REFERENCES SE_OPEN_LECTS ( -- 개설강의
      OLNO -- 강의번호
    );

-- 과제
ALTER TABLE SE_TESTS
  ADD CONSTRAINT FK_SE_TEST_TYPES_TO_SE_TESTS -- 과제유형 -> 과제
    FOREIGN KEY (
      TTNO -- 과제유형번호
    )
    REFERENCES SE_TEST_TYPES ( -- 과제유형
      TTNO -- 과제유형번호
    );

-- 과제평가
ALTER TABLE SE_TEST_RESUS
  ADD CONSTRAINT FK_SE_LECT_STUDS_TO_SE_TEST_RESUS -- 수강생 -> 과제평가
    FOREIGN KEY (
      LSNO -- 수강생번호
    )
    REFERENCES SE_LECT_STUDS ( -- 수강생
      LSNO -- 수강생번호
    );

-- 과제평가
ALTER TABLE SE_TEST_RESUS
  ADD CONSTRAINT FK_SE_TESTS_TO_SE_TEST_RESUS -- 과제 -> 과제평가
    FOREIGN KEY (
      TNO -- 과제번호
    )
    REFERENCES SE_TESTS ( -- 과제
      TNO -- 과제번호
    );

-- 과제평가
ALTER TABLE SE_TEST_RESUS
  ADD CONSTRAINT FK_SE_TEST_RESU_TYPES_TO_SE_TEST_RESUS -- 과제상태 -> 과제평가
    FOREIGN KEY (
      TRSNO -- 과제상태번호
    )
    REFERENCES SE_TEST_RESU_TYPES ( -- 과제상태
      TRSNO -- 과제상태번호
    );

-- 교육자료
ALTER TABLE SE_LECT_FILES
  ADD CONSTRAINT FK_SE_OPEN_LECTS_TO_SE_LECT_FILES -- 개설강의 -> 교육자료
    FOREIGN KEY (
      OLNO -- 강의번호
    )
    REFERENCES SE_OPEN_LECTS ( -- 개설강의
      OLNO -- 강의번호
    );

-- 교육자료
ALTER TABLE SE_LECT_FILES
  ADD CONSTRAINT FK_SE_USERS_TO_SE_LECT_FILES -- 사용자 -> 교육자료
    FOREIGN KEY (
      UNO -- 사용자번호
    )
    REFERENCES SE_USERS ( -- 사용자
      UNO -- 사용자번호
    );

-- 강사과목
ALTER TABLE SE_TEACH_SUBJS
  ADD CONSTRAINT FK_SE_TEACHS_TO_SE_TEACH_SUBJS -- 강사 -> 강사과목
    FOREIGN KEY (
      UNO -- 강사번호
    )
    REFERENCES SE_TEACHS ( -- 강사
      UNO -- 강사번호
    );

-- 강사과목
ALTER TABLE SE_TEACH_SUBJS
  ADD CONSTRAINT FK_SE_SUBJS_TO_SE_TEACH_SUBJS -- 과목 -> 강사과목
    FOREIGN KEY (
      SNO -- 과목번호
    )
    REFERENCES SE_SUBJS ( -- 과목
      SNO -- 과목번호
>>>>>>> branch 'master' of git@github.com:eomjinyoung/Java48.git
    );
