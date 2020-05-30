create or replace package crud_tipo_servicio
is
-- insert 
function ins( 
p_descripcion in tipo_servicio.descripcion%type,
p_valor in tipo_servicio.valor%type
) return number;
-- update 
procedure upd (
p_id_tipo_servicio in tipo_servicio.id_tipo_servicio%type,
p_descripcion in tipo_servicio.descripcion%type,
p_valor in tipo_servicio.valor%type
);
-- delete 
procedure del (
p_id_tipo_servicio in tipo_servicio.id_tipo_servicio%type
);
-- read 
function read (
p_id_tipo_servicio in tipo_servicio.id_tipo_servicio%type
) return sys_refcursor;
-- all 
function read_all return sys_refcursor;

end crud_tipo_servicio;
/
create or replace package body crud_tipo_servicio
is
-- insert 
function ins( 
p_descripcion in tipo_servicio.descripcion%type,
p_valor in tipo_servicio.valor%type
) return number
as 
new_id number := 0;
begin
new_id := tipo_servicio_seq.nextval;
insert into tipo_servicio(id_tipo_servicio,descripcion,valor)
values (new_id,p_descripcion,p_valor);
return new_id;
end;

-- update 
procedure upd (
p_id_tipo_servicio in tipo_servicio.id_tipo_servicio%type,
p_descripcion in tipo_servicio.descripcion%type,
p_valor in tipo_servicio.valor%type
)
as
begin
update tipo_servicio set
descripcion = p_descripcion,valor = p_valor;
end;

-- delete 
procedure del (
p_id_tipo_servicio in tipo_servicio.id_tipo_servicio%type
)
as
begin
delete from tipo_servicio where id_tipo_servicio = p_id_tipo_servicio;
end;

-- read 
function read (
p_id_tipo_servicio in tipo_servicio.id_tipo_servicio%type
) return sys_refcursor
as 
my_cursor sys_refcursor;
begin
open my_cursor for
select * from tipo_servicio where id_tipo_servicio = p_id_tipo_servicio;
return my_cursor;
end;

-- all 
function read_all return sys_refcursor
as 
my_cursor sys_refcursor;
begin
open my_cursor for
select * from tipo_servicio;
return my_cursor;
end;


end crud_tipo_servicio;