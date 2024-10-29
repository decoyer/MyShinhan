create table res_class (
   "식별번호" NUMBER CONSTRAINT res_class_id_PK PRIMARY KEY,
   "분류" VARCHAR2(50) CONSTRAINT res_class_class_CK CHECK("분류" IN ('한식', '일식', '중식', '양식', '기타'))
);

create table res_info (
   "식별번호" NUMBER CONSTRAINT res_info_id_PK PRIMARY KEY,
   "식당 이름" VARCHAR2(50) NOT NULL,
   "분류" NUMBER CONSTRAINT res_info_class_FK REFERENCES res_class("식별번호"),
   "도보시간 (분)" NUMBER NOT NULL
);

create table res_menu (
   "식별번호" NUMBER CONSTRAINT res_menu_id_FK REFERENCES res_info("식별번호"),
   "메뉴" VARCHAR2(50) NOT NULL,
   "가격" NUMBER NOT NULL
);

drop table res_menu;
drop table res_info;
drop table res_class;

create sequence id_seq
increment by 1
start with 1;

drop SEQUENCE id_seq;

commit;