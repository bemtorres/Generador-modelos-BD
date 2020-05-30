create or replace package crud_persona
is
-- insert 
function ins( 
p_run in persona.run%type,
p_pasaporte in persona.pasaporte%type,
p_extranjero in persona.extranjero%type,
p_nombre in persona.nombre%type,
p_apellido in persona.apellido%type
) return number;
-- update 
procedure upd (
p_id_persona in persona.id_persona%type,
p_run in persona.run%type,
p_pasaporte in persona.pasaporte%type,
p_extranjero in persona.extranjero%type,
p_nombre in persona.nombre%type,
p_apellido in persona.apellido%type
);
-- delete 
procedure del (
p_id_persona in persona.id_persona%type
);
-- read 
function read (
p_id_persona in persona.id_persona%type
) return sys_refcursor;
-- all 
function read_all return sys_refcursor;

end crud_persona;
/
create or replace package body crud_persona
is
-- insert 
function ins( 
p_run in persona.run%type,
p_pasaporte in persona.pasaporte%type,
p_extranjero in persona.extranjero%type,
p_nombre in persona.nombre%type,
p_apellido in persona.apellido%type
) return number
as 
new_id number := 0;
begin
new_id := persona_seq.nextval;
insert into persona(id_persona,run,pasaporte,extranjero,nombre,apellido)
values (new_id,p_run,p_pasaporte,p_extranjero,p_nombre,p_apellido);
return new_id;
end;

-- update 
procedure upd (
p_id_persona in persona.id_persona%type,
p_run in persona.run%type,
p_pasaporte in persona.pasaporte%type,
p_extranjero in persona.extranjero%type,
p_nombre in persona.nombre%type,
p_apellido in persona.apellido%type
)
as
begin
update persona set
run = p_run,pasaporte = p_pasaporte,extranjero = p_extranjero,nombre = p_nombre,apellido = p_apellido;
end;

-- delete 
procedure del (
p_id_persona in persona.id_persona%type
)
as
begin
delete from persona where id_persona = p_id_persona;
end;

-- read 
function read (
p_id_persona in persona.id_persona%type
) return sys_refcursor
as 
my_cursor sys_refcursor;
begin
open my_cursor for
select * from persona where id_persona = p_id_persona;
return my_cursor;
end;

-- all 
function read_all return sys_refcursor
as 
my_cursor sys_refcursor;
begin
open my_cursor for
select * from persona;
return my_cursor;
end;


end crud_persona;