create or replace package crud_serv_transporte
is
-- insert 
function ins( 
p_id_reserva in serv_transporte.id_reserva%type,
p_desde in serv_transporte.desde%type,
p_hacia in serv_transporte.hacia%type,
p_salida in serv_transporte.salida%type,
p_llegada in serv_transporte.llegada%type,
p_id_vehiculo in serv_transporte.id_vehiculo%type,
p_id_conductor in serv_transporte.id_conductor%type
) return number;
-- update 
procedure upd (
p_id_serv_transporte in serv_transporte.id_serv_transporte%type,
p_id_reserva in serv_transporte.id_reserva%type,
p_desde in serv_transporte.desde%type,
p_hacia in serv_transporte.hacia%type,
p_salida in serv_transporte.salida%type,
p_llegada in serv_transporte.llegada%type,
p_id_vehiculo in serv_transporte.id_vehiculo%type,
p_id_conductor in serv_transporte.id_conductor%type
);
-- delete 
procedure del (
p_id_serv_transporte in serv_transporte.id_serv_transporte%type
);
-- read 
function read (
p_id_serv_transporte in serv_transporte.id_serv_transporte%type
) return sys_refcursor;
-- all 
function read_all return sys_refcursor;

end crud_serv_transporte;
/
create or replace package body crud_serv_transporte
is
-- insert 
function ins( 
p_id_reserva in serv_transporte.id_reserva%type,
p_desde in serv_transporte.desde%type,
p_hacia in serv_transporte.hacia%type,
p_salida in serv_transporte.salida%type,
p_llegada in serv_transporte.llegada%type,
p_id_vehiculo in serv_transporte.id_vehiculo%type,
p_id_conductor in serv_transporte.id_conductor%type
) return number
as 
new_id number := 0;
begin
new_id := serv_transporte_seq.nextval;
insert into serv_transporte(id_serv_transporte,id_reserva,desde,hacia,salida,llegada,id_vehiculo,id_conductor)
values (new_id,p_id_reserva,p_desde,p_hacia,p_salida,p_llegada,p_id_vehiculo,p_id_conductor);
return new_id;
end;

-- update 
procedure upd (
p_id_serv_transporte in serv_transporte.id_serv_transporte%type,
p_id_reserva in serv_transporte.id_reserva%type,
p_desde in serv_transporte.desde%type,
p_hacia in serv_transporte.hacia%type,
p_salida in serv_transporte.salida%type,
p_llegada in serv_transporte.llegada%type,
p_id_vehiculo in serv_transporte.id_vehiculo%type,
p_id_conductor in serv_transporte.id_conductor%type
)
as
begin
update serv_transporte set
id_reserva = p_id_reserva,desde = p_desde,hacia = p_hacia,salida = p_salida,llegada = p_llegada,id_vehiculo = p_id_vehiculo,id_conductor = p_id_conductor;
end;

-- delete 
procedure del (
p_id_serv_transporte in serv_transporte.id_serv_transporte%type
)
as
begin
delete from serv_transporte where id_serv_transporte = p_id_serv_transporte;
end;

-- read 
function read (
p_id_serv_transporte in serv_transporte.id_serv_transporte%type
) return sys_refcursor
as 
my_cursor sys_refcursor;
begin
open my_cursor for
select * from serv_transporte where id_serv_transporte = p_id_serv_transporte;
return my_cursor;
end;

-- all 
function read_all return sys_refcursor
as 
my_cursor sys_refcursor;
begin
open my_cursor for
select * from serv_transporte;
return my_cursor;
end;


end crud_serv_transporte;