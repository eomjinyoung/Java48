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