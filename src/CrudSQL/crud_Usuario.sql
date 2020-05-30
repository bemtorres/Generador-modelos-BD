create or replace package crud_usuario
is
-- insert 
function ins( 
p_id_tipo_usuario in usuario.id_tipo_usuario%type,
p_id_persona in usuario.id_persona%type,
p_username in usuario.username%type,
p_password in usuario.password%type,
p_email in usuario.email%type
) return number;
-- update 
procedure upd (
p_id_usuario in usuario.id_usuario%type,
p_id_tipo_usuario in usuario.id_tipo_usuario%type,
p_id_persona in usuario.id_persona%type,
p_username in usuario.username%type,
p_password in usuario.password%type,
p_email in usuario.email%type
);
-- delete 
procedure del (
p_id_usuario in usuario.id_usuario%type
);
-- read 
function read (
p_id_usuario in usuario.id_usuario%type
) return sys_refcursor;
-- all 
function read_all return sys_refcursor;

end crud_usuario;
/
create or replace package body crud_usuario
is
-- insert 
function ins( 
p_id_tipo_usuario in usuario.id_tipo_usuario%type,
p_id_persona in usuario.id_persona%type,
p_username in usuario.username%type,
p_password in usuario.password%type,
p_email in usuario.email%type
) return number
as 
new_id number := 0;
begin
new_id := usuario_seq.nextval;
insert into usuario(id_usuario,id_tipo_usuario,id_persona,username,password,email)
values (new_id,p_id_tipo_usuario,p_id_persona,p_username,p_password,p_email);
return new_id;
end;

-- update 
procedure upd (
p_id_usuario in usuario.id_usuario%type,
p_id_tipo_usuario in usuario.id_tipo_usuario%type,
p_id_persona in usuario.id_persona%type,
p_username in usuario.username%type,
p_password in usuario.password%type,
p_email in usuario.email%type
)
as
begin
update usuario set
id_tipo_usuario = p_id_tipo_usuario,id_persona = p_id_persona,username = p_username,password = p_password,email = p_email;
end;

-- delete 
procedure del (
p_id_usuario in usuario.id_usuario%type
)
as
begin
delete from usuario where id_usuario = p_id_usuario;
end;

-- read 
function read (
p_id_usuario in usuario.id_usuario%type
) return sys_refcursor
as 
my_cursor sys_refcursor;
begin
open my_cursor for
select * from usuario where id_usuario = p_id_usuario;
return my_cursor;
end;

-- all 
function read_all return sys_refcursor
as 
my_cursor sys_refcursor;
begin
open my_cursor for
select * from usuario;
return my_cursor;
end;


end crud_usuario;