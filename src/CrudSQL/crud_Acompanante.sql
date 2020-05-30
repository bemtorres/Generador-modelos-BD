create or replace package crud_acompanante
is
-- insert 
function ins( 
p_id_reserva in acompanante.id_reserva%type,
p_id_persona in acompanante.id_persona%type
) return number;
-- update 
procedure upd (
p_id_acompanante in acompanante.id_acompanante%type,
p_id_reserva in acompanante.id_reserva%type,
p_id_persona in acompanante.id_persona%type
);
-- delete 
procedure del (
p_id_acompanante in acompanante.id_acompanante%type
);
-- read 
function read (
p_id_acompanante in acompanante.id_acompanante%type
) return sys_refcursor;
-- all 
function read_all return sys_refcursor;

end crud_acompanante;
/
create or replace package body crud_acompanante
is
-- insert 
function ins( 
p_id_reserva in acompanante.id_reserva%type,
p_id_persona in acompanante.id_persona%type
) return number
as 
new_id number := 0;
begin
new_id := acompanante_seq.nextval;
insert into acompanante(id_acompanante,id_reserva,id_persona)
values (new_id,p_id_reserva,p_id_persona);
return new_id;
end;

-- update 
procedure upd (
p_id_acompanante in acompanante.id_acompanante%type,
p_id_reserva in acompanante.id_reserva%type,
p_id_persona in acompanante.id_persona%type
)
as
begin
update acompanante set
id_reserva = p_id_reserva,id_persona = p_id_persona;
end;

-- delete 
procedure del (
p_id_acompanante in acompanante.id_acompanante%type
)
as
begin
delete from acompanante where id_acompanante = p_id_acompanante;
end;

-- read 
function read (
p_id_acompanante in acompanante.id_acompanante%type
) return sys_refcursor
as 
my_cursor sys_refcursor;
begin
open my_cursor for
select * from acompanante where id_acompanante = p_id_acompanante;
return my_cursor;
end;

-- all 
function read_all return sys_refcursor
as 
my_cursor sys_refcursor;
begin
open my_cursor for
select * from acompanante;
return my_cursor;
end;


end crud_acompanante;