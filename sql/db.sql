drop table product;
drop sequence product_product_id_seq;

-- 테이블 생성
create table product (
                         product_id          number(10),
                         product_name        varchar2(50),
                         product_quantity    number(10),
                         product_price       number(10)
);

-- 기본키 생성
alter table product add constraint product_pk primary key (product_id);

-- 시퀀스 생성
create sequence product_product_id_seq
    start with 1
    increment by 1
    minvalue 0
    maxvalue 99999999
    nocycle
    nocache;

-- 상품등록
insert into product
values (
           product_product_id_seq.nextval,
           '피카츄빵',
           1 ,
           1000
       );

-- 건별조회
select
    product_id,
    product_name,
    product_quantity,
    product_price
from product
where product_id = 15 ;

-- 전체조회
select
    product_id,
    product_name,
    product_quantity,
    product_price
from product
Order by product_id;

-- 수정
update product
set product_name = '포켓몬빵' ,
    product_quantity = 1 ,
    product_price = 1000
where product_id = 13;

-- 건별삭제
delete from product
where product_id = 14;

select * from product;
commit;