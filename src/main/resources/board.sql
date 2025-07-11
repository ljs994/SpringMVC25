-- 시퀀스 객체 생성
create sequence seq_board;
-- 시퀀스 삭제(차후에 활용)
drop sequence seq_board;

create table tbl_board(
	bno number(10,0),					-- 게시물 번호 (시퀀스)
	title varchar2(200) not null,		-- 제목
	content varchar2(2000) not null,	-- 내용
	writer varchar2(50) not null,		-- 작성자(차후에 member랑 연동)
	regdate date default sysdate,		-- 작성일(자동으로 DB날짜가 입력)
	updatedate date default sysdate		-- 수정일(자동으로 DB날짜가 입력)
); -- board 테이블 생성

alter table tbl_board add constraint pk_board primary key (bno);
-- tbl_board 구조변경(수정) 기본기를 bno로 지정함.



-- 더미데이터 입력
insert into TBL_BOARD (bno, title, content, writer)
values (seq_board.nextval, '테스트제목1', '테스트 내용1', 'user00');

insert into TBL_BOARD (bno, title, content, writer)
values (seq_board.nextval, '테스트제목2', '테스트 내용2', 'user01');

insert into TBL_BOARD (bno, title, content, writer)
values (seq_board.nextval, '테스트제목3', '테스트 내용3', 'user02');

insert into TBL_BOARD (bno, title, content, writer)
values (seq_board.nextval, '테스트제목4', '테스트 내용4', 'user03');

insert into TBL_BOARD (bno, title, content, writer)
values (seq_board.nextval, '테스트제목5', '테스트 내용5', 'user04');

insert into TBL_BOARD (bno, title, content, writer)
values (seq_board.nextval, '테스트제목6', '테스트 내용6', 'user05');

insert into TBL_BOARD (bno, title, content, writer)
values (seq_board.nextval, '테스트제목7', '테스트 내용7', 'user06');

insert into TBL_BOARD (bno, title, content, writer)
values (seq_board.nextval, '테스트제목8', '테스트 내용8', 'user07');

select * from TBL_BOARD;