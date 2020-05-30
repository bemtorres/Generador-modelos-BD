create or replace package crud_tipo_usuario
is
-- insert 
function ins( 
p_nombre_tipo_usuario in tipo_usuario.nombre_tipo_usuario%type
) return number;
-- update 
procedure upd (
p_id_tipo_usuario in tipo_usuario.id_tipo_usuario%type,
p_nombre_tipo_usuario in tipo_usuario.nombre_tipo_usuario%type
);
-- delete 
procedure del (
p_id_tipo_usuario in tipo_usuario.id_tipo_usuario%type
);
-- read 
function read (
p_id_tipo_usuario in tipo_usuario.id_tipo_usuario%type
) return sys_refcursor;
-- all 
function read_all return sys_refcursor;

end crud_tipo_usuario;
/
create or replace package body crud_tipo_usuario
is
-- insert 
function ins( 
p_nombre_tipo_usuario in tipo_usuario.nombre_tipo_usuario%type
) return number
as 
new_id number := 0;
begin
new_id := tipo_usuario_seq.nextval;
insert into tipo_usuario(id_tipo_usuario,nombre_tipo_usuario)
values (new_id,p_nombre_tipo_usuario);
return new_id;
end;

-- update 
procedure upd (
p_id_tipo_usuario in tipo_usuario.id_tipo_usuario%type,
p_nombre_tipo_usuario in tipo_usuario.nombre_tipo_usuario%type
)
as
begin
update tipo_usuario set
nombre_tipo_usuario = p_nombre_tipo_usuario;
end;

-- delete 
procedure del (
p_id_tipo_usuario in tipo_usuario.id_tipo_usuario%type
)
as
begin
delete from tipo_usuario where id_tipo_usuario = p_id_tipo_usuario;
end;

-- read 
function read (
p_id_tipo_usuario in tipo_usuario.id_tipo_usuario%type
) return sys_refcursor
as 
my_cursor sys_refcursor;
begin
open my_cursor for
select * from tipo_usuario where id_tipo_usuario = p_id_tipo_usuario;
return my_cursor;
end;

-- all 
function read_all return sys_refcursor
as 
my_cursor sys_refcursor;
begin
open my_cursor for
select * from tipo_usuario;
return my_cursor;
end;


end crud_tipo_usuario;