create or replace package crud_reserva
is
-- insert 
function ins( 
p_id_cliente in reserva.id_cliente%type,
p_id_departamento in reserva.id_departamento%type,
p_fecha_inicio in reserva.fecha_inicio%type,
p_fecha_termino in reserva.fecha_termino%type,
p_costo_total in reserva.costo_total%type,
p_check_in in reserva.check_in%type,
p_check_out in reserva.check_out%type
) return number;
-- update 
procedure upd (
p_id_reserva in reserva.id_reserva%type,
p_id_cliente in reserva.id_cliente%type,
p_id_departamento in reserva.id_departamento%type,
p_fecha_inicio in reserva.fecha_inicio%type,
p_fecha_termino in reserva.fecha_termino%type,
p_costo_total in reserva.costo_total%type,
p_check_in in reserva.check_in%type,
p_check_out in reserva.check_out%type
);
-- delete 
procedure del (
p_id_reserva in reserva.id_reserva%type
);
-- read 
function read (
p_id_reserva in reserva.id_reserva%type
) return sys_refcursor;
-- all 
function read_all return sys_refcursor;

end crud_reserva;
/
create or replace package body crud_reserva
is
-- insert 
function ins( 
p_id_cliente in reserva.id_cliente%type,
p_id_departamento in reserva.id_departamento%type,
p_fecha_inicio in reserva.fecha_inicio%type,
p_fecha_termino in reserva.fecha_termino%type,
p_costo_total in reserva.costo_total%type,
p_check_in in reserva.check_in%type,
p_check_out in reserva.check_out%type
) return number
as 
new_id number := 0;
begin
new_id := reserva_seq.nextval;
insert into reserva(id_reserva,id_cliente,id_departamento,fecha_inicio,fecha_termino,costo_total,check_in,check_out)
values (new_id,p_id_cliente,p_id_departamento,p_fecha_inicio,p_fecha_termino,p_costo_total,p_check_in,p_check_out);
return new_id;
end;

-- update 
procedure upd (
p_id_reserva in reserva.id_reserva%type,
p_id_cliente in reserva.id_cliente%type,
p_id_departamento in reserva.id_departamento%type,
p_fecha_inicio in reserva.fecha_inicio%type,
p_fecha_termino in reserva.fecha_termino%type,
p_costo_total in reserva.costo_total%type,
p_check_in in reserva.check_in%type,
p_check_out in reserva.check_out%type
)
as
begin
update reserva set
id_cliente = p_id_cliente,id_departamento = p_id_departamento,fecha_inicio = p_fecha_inicio,fecha_termino = p_fecha_termino,costo_total = p_costo_total,check_in = p_check_in,check_out = p_check_out;
end;

-- delete 
procedure del (
p_id_reserva in reserva.id_reserva%type
)
as
begin
delete from reserva where id_reserva = p_id_reserva;
end;

-- read 
function read (
p_id_reserva in reserva.id_reserva%type
) return sys_refcursor
as 
my_cursor sys_refcursor;
begin
open my_cursor for
select * from reserva where id_reserva = p_id_reserva;
return my_cursor;
end;

-- all 
function read_all return sys_refcursor
as 
my_cursor sys_refcursor;
begin
open my_cursor for
select * from reserva;
return my_cursor;
end;


end crud_reserva;