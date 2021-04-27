select * from tab;
select * from MEMBER;
select * from news;
create sequence news_seq;
create sequence live_seq;
create sequence qa_seq;
create sequence tip_seq;
create sequence free_seq;
create sequence share_seq;
select * from seq;

select * from live;

insert into member values ('youngsik@gmail' , '테스트1' , '1234' , sysdate , '테스트파일');

insert into news values(news_seq.nextval , '개발동향' , '테스트1' , '페이징확인용' , '페이징확인용' , sysdate , 0 , 0 , 0);
insert into news values(news_seq.nextval , '개발동향' , '테스트1' , '페이징확인용' , '페이징확인용' , sysdate , 0 , 0 , 0);
insert into news values(news_seq.nextval , '개발동향' , '테스트1' , '페이징확인용' , '페이징확인용' , sysdate , 0 , 0 , 0);
insert into news values(news_seq.nextval , '개발동향' , '테스트1' , '페이징확인용' , '페이징확인용' , sysdate , 0 , 0 , 0);

insert into live values(live_seq.nextval , '개발동향' , '테스트1' , '페이징확인용' , '페이징확인용' , sysdate , 0 , 0 , 0);

create sequence live_re_seq;