select * from tab;
select * from MEMBER;
select * from news;
select * from tip;
select * from tip_re;
select * from member;

create sequence news_seq;
create sequence live_seq;
create sequence qa_seq;
create sequence tip_seq;
create sequence free_seq;
create sequence share_seq;
select * from seq;

insert into member values ('youngsik@gmail' , '테스트1' , '1234' , sysdate , '테스트파일');
insert into member values ('replyman@naver.com' , '댓글맨' , '1234', sysdate , '테스트맨');
insert into news values(news_seq.nextval , '개발동향' , '테스트1' , '페이징확인용' , '페이징확인용' , sysdate , 0 , 0 , 0);
insert into news values(news_seq.nextval , '개발동향' , '테스트1' , '페이징확인용' , '페이징확인용' , sysdate , 0 , 0 , 0);
insert into news values(news_seq.nextval , '개발동향' , '테스트1' , '페이징확인용' , '페이징확인용' , sysdate , 0 , 0 , 0);
insert into news values(news_seq.nextval , '개발동향' , '테스트1' , '페이징확인용' , '페이징확인용' , sysdate , 0 , 0 , 0);

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