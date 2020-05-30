create or replace package crud_inventario
is
-- insert 
function ins( 
p_id_departamento in inventario.id_departamento%type,
p_nombre in inventario.nombre%type,
p_descripcion in inventario.descripcion%type,
p_cantidad in inventario.cantidad%type,
p_valor in inventario.valor%type
) return number;
-- update 
procedure upd (
p_id_inventario in inventario.id_inventario%type,
p_id_departamento in inventario.id_departamento%type,
p_nombre in inventario.nombre%type,
p_descripcion in inventario.descripcion%type,
p_cantidad in inventario.cantidad%type,
p_valor in inventario.valor%type
);
-- delete 
procedure del (
p_id_inventario in inventario.id_inventario%type
);
-- read 
function read (
p_id_inventario in inventario.id_inventario%type
) return sys_refcursor;
-- all 
function read_all return sys_refcursor;

end crud_inventario;
/
create or replace package body crud_inventario
is
-- insert 
function ins( 
p_id_departamento in inventario.id_departamento%type,
p_nombre in inventario.nombre%type,
p_descripcion in inventario.descripcion%type,
p_cantidad in inventario.cantidad%type,
p_valor in inventario.valor%type
) return number
as 
new_id number := 0;
begin
new_id := inventario_seq.nextval;
insert into inventario(id_inventario,id_departamento,nombre,descripcion,cantidad,valor)
values (new_id,p_id_departamento,p_nombre,p_descripcion,p_cantidad,p_valor);
return new_id;
end;

-- update 
procedure upd (
p_id_inventario in inventario.id_inventario%type,
p_id_departamento in inventario.id_departamento%type,
p_nombre in inventario.nombre%type,
p_descripcion in inventario.descripcion%type,
p_cantidad in inventario.cantidad%type,
p_valor in inventario.valor%type
)
as
begin
update inventario set
id_departamento = p_id_departamento,nombre = p_nombre,descripcion = p_descripcion,cantidad = p_cantidad,valor = p_valor;
end;

-- delete 
procedure del (
p_id_inventario in inventario.id_inventario%type
)
as
begin
delete from inventario where id_inventario = p_id_inventario;
end;

-- read 
function read (
p_id_inventario in inventario.id_inventario%type
) return sys_refcursor
as 
my_cursor sys_refcursor;
begin
open my_cursor for
select * from inventario where id_inventario = p_id_inventario;
return my_cursor;
end;

-- all 
function read_all return sys_refcursor
as 
my_cursor sys_refcursor;
begin
open my_cursor for
select * from inventario;
return my_cursor;
end;


end crud_inventario;