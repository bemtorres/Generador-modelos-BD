create or replace package crud_comuna
is
-- insert 
function ins( 
p_nombre in comuna.nombre%type,
p_id_region in comuna.id_region%type
) return number;
-- update 
procedure upd (
p_id_comuna in comuna.id_comuna%type,
p_nombre in comuna.nombre%type,
p_id_region in comuna.id_region%type
);
-- delete 
procedure del (
p_id_comuna in comuna.id_comuna%type
);
-- read 
function read (
p_id_comuna in comuna.id_comuna%type
) return sys_refcursor;
-- all 
function read_all return sys_refcursor;

end crud_comuna;
/
create or replace package body crud_comuna
is
-- insert 
function ins( 
p_nombre in comuna.nombre%type,
p_id_region in comuna.id_region%type
) return number
as 
new_id number := 0;
begin
new_id := comuna_seq.nextval;
insert into comuna(id_comuna,nombre,id_region)
values (new_id,p_nombre,p_id_region);
return new_id;
end;

-- update 
procedure upd (
p_id_comuna in comuna.id_comuna%type,
p_nombre in comuna.nombre%type,
p_id_region in comuna.id_region%type
)
as
begin
update comuna set
nombre = p_nombre,id_region = p_id_region;
end;

-- delete 
procedure del (
p_id_comuna in comuna.id_comuna%type
)
as
begin
delete from comuna where id_comuna = p_id_comuna;
end;

-- read 
function read (
p_id_comuna in comuna.id_comuna%type
) return sys_refcursor
as 
my_cursor sys_refcursor;
begin
open my_cursor for
select * from comuna where id_comuna = p_id_comuna;
return my_cursor;
end;

-- all 
function read_all return sys_refcursor
as 
my_cursor sys_refcursor;
begin
open my_cursor for
select * from comuna;
return my_cursor;
end;


end crud_comuna;