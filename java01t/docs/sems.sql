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
    );