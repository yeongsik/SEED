select * from tab;
select * from MEMBER;
select * from news;
select * from news_re;
select * from NEWS_RE;
create sequence news_seq;
create sequence live_seq;
create sequence qa_seq;
create sequence tip_seq;
create sequence free_seq;
create sequence share_seq;
select * from seq;
create sequence news_re_seq;

insert into member values ('youngsik@gmail' , '테스트1' , '1234' , sysdate , '테스트파일');
insert into news values(news_seq.nextval , '개발동향' , '테스트1' , '페이징확인용' , '페이징확인용' , sysdate , 0 , 0 , 0);


------------------------------------------------------------------------
------------------------------------------------------------------------
select * from qa;
select * from qa_re;

insert into MEMBER values('hama@naver.com','하마','1234',SYSDATE,'프로필사진');

-- QA 게시물번호 seq.

create sequence board_num_seq
	start with 1
	increment by 1
	nocache;

-- qa_re 댓글 번호 seq.
	
create sequence re_num_seq
	start with 1
		increment by 1
		nocache;

insert into news values(news_seq.nextval , '개발동향' , '테스트1' , '페이징확인용' , '페이징확인용' , sysdate , 0 , 0 , 0);
insert into news values(news_seq.nextval , '개발동향' , '테스트1' , '페이징확인용' , '페이징확인용' , sysdate , 0 , 0 , 0);


select * from (select rownum rnum , board.* from
					 (select * from news 
					 where board_register between sysdate-7 and sysdate
					 order by board_view desc) board )
					 where rnum >= 1 and rnum <=5;
					 
 select  board_category , board_subject , name , board_view from news where board_register between sysdate-7 and sysdate order by board_view desc;

