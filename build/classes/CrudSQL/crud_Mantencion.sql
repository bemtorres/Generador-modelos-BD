create or replace package crud_mantencion
is
-- insert 
function ins( 
p_id_departamento in mantencion.id_departamento%type,
p_fecha_inicio in mantencion.fecha_inicio%type,
p_fecha_termino in mantencion.fecha_termino%type,
p_finalizado in mantencion.finalizado%type
) return number;
-- update 
procedure upd (
p_id_mantencion in mantencion.id_mantencion%type,
p_id_departamento in mantencion.id_departamento%type,
p_fecha_inicio in mantencion.fecha_inicio%type,
p_fecha_termino in mantencion.fecha_termino%type,
p_finalizado in mantencion.finalizado%type
);
-- delete 
procedure del (
p_id_mantencion in mantencion.id_mantencion%type
);
-- read 
function read (
p_id_mantencion in mantencion.id_mantencion%type
) return sys_refcursor;
-- all 
function read_all return sys_refcursor;

end crud_mantencion;
/
create or replace package body crud_mantencion
is
-- insert 
function ins( 
p_id_departamento in mantencion.id_departamento%type,
p_fecha_inicio in mantencion.fecha_inicio%type,
p_fecha_termino in mantencion.fecha_termino%type,
p_finalizado in mantencion.finalizado%type
) return number
as 
new_id number := 0;
begin
new_id := mantencion_seq.nextval;
insert into mantencion(id_mantencion,id_departamento,fecha_inicio,fecha_termino,finalizado)
values (new_id,p_id_departamento,p_fecha_inicio,p_fecha_termino,p_finalizado);
return new_id;
end;

-- update 
procedure upd (
p_id_mantencion in mantencion.id_mantencion%type,
p_id_departamento in mantencion.id_departamento%type,
p_fecha_inicio in mantencion.fecha_inicio%type,
p_fecha_termino in mantencion.fecha_termino%type,
p_finalizado in mantencion.finalizado%type
)
as
begin
update mantencion set
id_departamento = p_id_departamento,fecha_inicio = p_fecha_inicio,fecha_termino = p_fecha_termino,finalizado = p_finalizado;
end;

-- delete 
procedure del (
p_id_mantencion in mantencion.id_mantencion%type
)
as
begin
delete from mantencion where id_mantencion = p_id_mantencion;
end;

-- read 
function read (
p_id_mantencion in mantencion.id_mantencion%type
) return sys_refcursor
as 
my_cursor sys_refcursor;
begin
open my_cursor for
select * from mantencion where id_mantencion = p_id_mantencion;
return my_cursor;
end;

-- all 
function read_all return sys_refcursor
as 
my_cursor sys_refcursor;
begin
open my_cursor for
select * from mantencion;
return my_cursor;
end;


end crud_mantencion;