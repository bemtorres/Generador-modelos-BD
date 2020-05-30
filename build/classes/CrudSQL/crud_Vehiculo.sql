create or replace package crud_vehiculo
is
-- insert 
function ins( 
p_descripcion in vehiculo.descripcion%type,
p_patente in vehiculo.patente%type
) return number;
-- update 
procedure upd (
p_id_vehiculo in vehiculo.id_vehiculo%type,
p_descripcion in vehiculo.descripcion%type,
p_patente in vehiculo.patente%type
);
-- delete 
procedure del (
p_id_vehiculo in vehiculo.id_vehiculo%type
);
-- read 
function read (
p_id_vehiculo in vehiculo.id_vehiculo%type
) return sys_refcursor;
-- all 
function read_all return sys_refcursor;

end crud_vehiculo;
/
create or replace package body crud_vehiculo
is
-- insert 
function ins( 
p_descripcion in vehiculo.descripcion%type,
p_patente in vehiculo.patente%type
) return number
as 
new_id number := 0;
begin
new_id := vehiculo_seq.nextval;
insert into vehiculo(id_vehiculo,descripcion,patente)
values (new_id,p_descripcion,p_patente);
return new_id;
end;

-- update 
procedure upd (
p_id_vehiculo in vehiculo.id_vehiculo%type,
p_descripcion in vehiculo.descripcion%type,
p_patente in vehiculo.patente%type
)
as
begin
update vehiculo set
descripcion = p_descripcion,patente = p_patente;
end;

-- delete 
procedure del (
p_id_vehiculo in vehiculo.id_vehiculo%type
)
as
begin
delete from vehiculo where id_vehiculo = p_id_vehiculo;
end;

-- read 
function read (
p_id_vehiculo in vehiculo.id_vehiculo%type
) return sys_refcursor
as 
my_cursor sys_refcursor;
begin
open my_cursor for
select * from vehiculo where id_vehiculo = p_id_vehiculo;
return my_cursor;
end;

-- all 
function read_all return sys_refcursor
as 
my_cursor sys_refcursor;
begin
open my_cursor for
select * from vehiculo;
return my_cursor;
end;


end crud_vehiculo;