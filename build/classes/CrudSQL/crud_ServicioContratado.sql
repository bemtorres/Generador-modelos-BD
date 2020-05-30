create or replace package crud_servicio_contratado
is
-- insert 
function ins( 
p_id_reserva in servicio_contratado.id_reserva%type,
p_id_tipo_servicio in servicio_contratado.id_tipo_servicio%type
) return number;
-- update 
procedure upd (
p_id_servicio_contratado in servicio_contratado.id_servicio_contratado%type,
p_id_reserva in servicio_contratado.id_reserva%type,
p_id_tipo_servicio in servicio_contratado.id_tipo_servicio%type
);
-- delete 
procedure del (
p_id_servicio_contratado in servicio_contratado.id_servicio_contratado%type
);
-- read 
function read (
p_id_servicio_contratado in servicio_contratado.id_servicio_contratado%type
) return sys_refcursor;
-- all 
function read_all return sys_refcursor;

end crud_servicio_contratado;
/
create or replace package body crud_servicio_contratado
is
-- insert 
function ins( 
p_id_reserva in servicio_contratado.id_reserva%type,
p_id_tipo_servicio in servicio_contratado.id_tipo_servicio%type
) return number
as 
new_id number := 0;
begin
new_id := servicio_contratado_seq.nextval;
insert into servicio_contratado(id_servicio_contratado,id_reserva,id_tipo_servicio)
values (new_id,p_id_reserva,p_id_tipo_servicio);
return new_id;
end;

-- update 
procedure upd (
p_id_servicio_contratado in servicio_contratado.id_servicio_contratado%type,
p_id_reserva in servicio_contratado.id_reserva%type,
p_id_tipo_servicio in servicio_contratado.id_tipo_servicio%type
)
as
begin
update servicio_contratado set
id_reserva = p_id_reserva,id_tipo_servicio = p_id_tipo_servicio;
end;

-- delete 
procedure del (
p_id_servicio_contratado in servicio_contratado.id_servicio_contratado%type
)
as
begin
delete from servicio_contratado where id_servicio_contratado = p_id_servicio_contratado;
end;

-- read 
function read (
p_id_servicio_contratado in servicio_contratado.id_servicio_contratado%type
) return sys_refcursor
as 
my_cursor sys_refcursor;
begin
open my_cursor for
select * from servicio_contratado where id_servicio_contratado = p_id_servicio_contratado;
return my_cursor;
end;

-- all 
function read_all return sys_refcursor
as 
my_cursor sys_refcursor;
begin
open my_cursor for
select * from servicio_contratado;
return my_cursor;
end;


end crud_servicio_contratado;