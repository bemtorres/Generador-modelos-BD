create or replace package crud_departamento
is
-- insert 
function ins( 
p_direccion in departamento.direccion%type,
p_id_comuna in departamento.id_comuna%type,
p_habitaciones in departamento.habitaciones%type,
p_capacidad in departamento.capacidad%type,
p_precio in departamento.precio%type,
p_amueblado in departamento.amueblado%type,
p_cable in departamento.cable%type,
p_internet in departamento.internet%type,
p_calefaccion in departamento.calefaccion%type,
p_descripcion in departamento.descripcion%type
) return number;
-- update 
procedure upd (
p_id_departamento in departamento.id_departamento%type,
p_direccion in departamento.direccion%type,
p_id_comuna in departamento.id_comuna%type,
p_habitaciones in departamento.habitaciones%type,
p_capacidad in departamento.capacidad%type,
p_precio in departamento.precio%type,
p_amueblado in departamento.amueblado%type,
p_cable in departamento.cable%type,
p_internet in departamento.internet%type,
p_calefaccion in departamento.calefaccion%type,
p_descripcion in departamento.descripcion%type
);
-- delete 
procedure del (
p_id_departamento in departamento.id_departamento%type
);
-- read 
function read (
p_id_departamento in departamento.id_departamento%type
) return sys_refcursor;
-- all 
function read_all return sys_refcursor;

end crud_departamento;
/
create or replace package body crud_departamento
is
-- insert 
function ins( 
p_direccion in departamento.direccion%type,
p_id_comuna in departamento.id_comuna%type,
p_habitaciones in departamento.habitaciones%type,
p_capacidad in departamento.capacidad%type,
p_precio in departamento.precio%type,
p_amueblado in departamento.amueblado%type,
p_cable in departamento.cable%type,
p_internet in departamento.internet%type,
p_calefaccion in departamento.calefaccion%type,
p_descripcion in departamento.descripcion%type
) return number
as 
new_id number := 0;
begin
new_id := departamento_seq.nextval;
insert into departamento(id_departamento,direccion,id_comuna,habitaciones,capacidad,precio,amueblado,cable,internet,calefaccion,descripcion)
values (new_id,p_direccion,p_id_comuna,p_habitaciones,p_capacidad,p_precio,p_amueblado,p_cable,p_internet,p_calefaccion,p_descripcion);
return new_id;
end;

-- update 
procedure upd (
p_id_departamento in departamento.id_departamento%type,
p_direccion in departamento.direccion%type,
p_id_comuna in departamento.id_comuna%type,
p_habitaciones in departamento.habitaciones%type,
p_capacidad in departamento.capacidad%type,
p_precio in departamento.precio%type,
p_amueblado in departamento.amueblado%type,
p_cable in departamento.cable%type,
p_internet in departamento.internet%type,
p_calefaccion in departamento.calefaccion%type,
p_descripcion in departamento.descripcion%type
)
as
begin
update departamento set
direccion = p_direccion,id_comuna = p_id_comuna,habitaciones = p_habitaciones,capacidad = p_capacidad,precio = p_precio,amueblado = p_amueblado,cable = p_cable,internet = p_internet,calefaccion = p_calefaccion,descripcion = p_descripcion;
end;

-- delete 
procedure del (
p_id_departamento in departamento.id_departamento%type
)
as
begin
delete from departamento where id_departamento = p_id_departamento;
end;

-- read 
function read (
p_id_departamento in departamento.id_departamento%type
) return sys_refcursor
as 
my_cursor sys_refcursor;
begin
open my_cursor for
select * from departamento where id_departamento = p_id_departamento;
return my_cursor;
end;

-- all 
function read_all return sys_refcursor
as 
my_cursor sys_refcursor;
begin
open my_cursor for
select * from departamento;
return my_cursor;
end;


end crud_departamento;