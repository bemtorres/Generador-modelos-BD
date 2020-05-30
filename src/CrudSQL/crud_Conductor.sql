create or replace package crud_conductor
is
-- insert 
function ins( 
p_id_persona in conductor.id_persona%type
) return number;
-- update 
procedure upd (
p_id_conductor in conductor.id_conductor%type,
p_id_persona in conductor.id_persona%type
);
-- delete 
procedure del (
p_id_conductor in conductor.id_conductor%type
);
-- read 
function read (
p_id_conductor in conductor.id_conductor%type
) return sys_refcursor;
-- all 
function read_all return sys_refcursor;

end crud_conductor;
/
create or replace package body crud_conductor
is
-- insert 
function ins( 
p_id_persona in conductor.id_persona%type
) return number
as 
new_id number := 0;
begin
new_id := conductor_seq.nextval;
insert into conductor(id_conductor,id_persona)
values (new_id,p_id_persona);
return new_id;
end;

-- update 
procedure upd (
p_id_conductor in conductor.id_conductor%type,
p_id_persona in conductor.id_persona%type
)
as
begin
update conductor set
id_persona = p_id_persona;
end;

-- delete 
procedure del (
p_id_conductor in conductor.id_conductor%type
)
as
begin
delete from conductor where id_conductor = p_id_conductor;
end;

-- read 
function read (
p_id_conductor in conductor.id_conductor%type
) return sys_refcursor
as 
my_cursor sys_refcursor;
begin
open my_cursor for
select * from conductor where id_conductor = p_id_conductor;
return my_cursor;
end;

-- all 
function read_all return sys_refcursor
as 
my_cursor sys_refcursor;
begin
open my_cursor for
select * from conductor;
return my_cursor;
end;


end crud_conductor;