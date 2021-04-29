select * from tab;
select * from MEMBER;
select * from news;

select * from news_re;
select * from NEWS_RE;


select * from tip;
select * from tip_re;
select * from member;

select * from SHARE_LINK;
select count(*) from share_link;

create sequence news_seq;
create sequence live_seq;
create sequence qa_seq;
create sequence tip_seq;
create sequence free_seq;
create sequence share_seq;
select * from seq;
create sequence news_re_seq;

select * from live;
insert into SHARE_LINK values(SHARE_seq.nextval , '댓글맨', 'Okky', '설명테스트', 'https://okky.kr/', 0, sysdate );
insert into SHARE_LINK values(SHARE_seq.nextval , '댓글맨', 'Okky', '설명테스트', 'https://okky.kr/', 0, sysdate );
insert into SHARE_LINK values(SHARE_seq.nextval , '댓글맨', 'Okky', '설명테스트', 'https://okky.kr/', 0, sysdate );
insert into member values ('youngsik@gmail' , '테스트1' , '1234' , sysdate , '테스트파일');

insert into member values ('replyman@naver.com' , '댓글맨' , '1234', sysdate , '테스트맨');

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

insert into news values(news_seq.nextval , '개발동향' , '테스트1' , '페이징확인용' , '페이징확인용' , sysdate , 0 , 0 , 0);

insert into news values(news_seq.nextval , '개발동향' , '테스트1' , '페이징확인용' , '페이징확인용' , sysdate , 0 , 0 , 0);

insert into live values(live_seq.nextval , '개발동향' , '테스트1' , '페이징확인용' , '페이징확인용' , sysdate , 0 , 0 , 0);

create sequence live_re_seq;


insert into tip values(tip_seq.nextval,'Tip1','name1','글작성테스트','테스트하고있습니다.',sysdate,0,0,0);
insert into tip values(tip_seq.nextval,'Tip1','name1','글작성테스트','테스트하고있습니다.',sysdate,0,0,0);
insert into tip values(tip_seq.nextval,'Tip1','name1','글작성테스트','테스트하고있습니다.',sysdate,0,0,0);
insert into tip values(tip_seq.nextval,'Tip1','name1','글작성테스트','테스트하고있습니다.',sysdate,0,0,0);
insert into tip values(tip_seq.nextval,'Tip1','name1','글작성테스트','테스트하고있습니다.',sysdate,0,0,0);


/* TIp_re */
CREATE TABLE Tip_re (
	re_num NUMBER NOT NULL, /* 댓글Num */
	name VARCHAR2(20) NOT NULL, /* 닉네임 */
	re_content VARCHAR2(300) NOT NULL, /* 내용 */
	re_register TIMESTAMP NOT NULL, /* 등록일 */
	re_like NUMBER NOT NULL, /* 좋아요 */
	re_hate NUMBER NOT NULL, /* 싫어요 */
	re_ref NUMBER NOT NULL, /* re_ref */
	re_lev NUMBER NOT NULL, /* re_lev */
	re_seq NUMBER NOT NULL, /* re_seq */
	board_num NUMBER NOT NULL /* 원문번호 */
);

/* TIp */
CREATE TABLE Tip (
	board_num NUMBER NOT NULL, /* 게시물번호 */
	board_category VARCHAR2(30) NOT NULL, /* 카테고리 */
	name VARCHAR2(20) NOT NULL, /* 닉네임 */
	board_subject VARCHAR2(200) NOT NULL, /* 제목 */
	board_content VARCHAR2(2000) NOT NULL, /* 내용 */
	board_register TIMESTAMP NOT NULL, /* 등록일 */
	board_view NUMBER NOT NULL, /* 조회수 */
	board_like NUMBER NOT NULL, /* 좋아요 */
	board_hate NUMBER NOT NULL /* 싫어요 */
);



select * from (select rownum rnum , board.* from
					 (select * from news 
					 where board_register between sysdate-7 and sysdate
					 order by board_view desc) board )
					 where rnum >= 1 and rnum <=5;
					 
 select  board_category , board_subject , name , board_view from news where board_register between sysdate-7 and sysdate order by board_view desc;



