create or replace package crud_region
is
-- insert 
function ins( 
p_nombre_region in region.nombre_region%type
) return number;
-- update 
procedure upd (
p_id_region in region.id_region%type,
p_nombre_region in region.nombre_region%type
);
-- delete 
procedure del (
p_id_region in region.id_region%type
);
-- read 
function read (
p_id_region in region.id_region%type
) return sys_refcursor;
-- all 
function read_all return sys_refcursor;

end crud_region;
/
create or replace package body crud_region
is
-- insert 
function ins( 
p_nombre_region in region.nombre_region%type
) return number
as 
new_id number := 0;
begin
new_id := region_seq.nextval;
insert into region(id_region,nombre_region)
values (new_id,p_nombre_region);
return new_id;
end;

-- update 
procedure upd (
p_id_region in region.id_region%type,
p_nombre_region in region.nombre_region%type
)
as
begin
update region set
nombre_region = p_nombre_region;
end;

-- delete 
procedure del (
p_id_region in region.id_region%type
)
as
begin
delete from region where id_region = p_id_region;
end;

-- read 
function read (
p_id_region in region.id_region%type
) return sys_refcursor
as 
my_cursor sys_refcursor;
begin
open my_cursor for
select * from region where id_region = p_id_region;
return my_cursor;
end;

-- all 
function read_all return sys_refcursor
as 
my_cursor sys_refcursor;
begin
open my_cursor for
select * from region;
return my_cursor;
end;


end crud_region;