select * from emp9 order by empno asc;

select * from emp9 where empno=7788;

select count(*) from emp9;

--insert into emp9(empno, ename, job) values(4000,'Tom', 'Developer');

--update emp9 set ename='Iann', job='Designer' where empno=4000;

--delete emp9 where empno=4000;

select * from (
	select rownum as rnum, e.* from (
		select * from emp9 order by empno asc
	) e
) where rnum >= 13 and rnum <= 15;

--select * from emp9 limit 12, 3;
