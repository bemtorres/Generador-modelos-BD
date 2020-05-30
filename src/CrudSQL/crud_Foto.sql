create or replace package crud_foto
is
-- insert 
function ins( 
p_id_departamento in foto.id_departamento%type,
p_ruta in foto.ruta%type
) return number;
-- update 
procedure upd (
p_id_foto in foto.id_foto%type,
p_id_departamento in foto.id_departamento%type,
p_ruta in foto.ruta%type
);
-- delete 
procedure del (
p_id_foto in foto.id_foto%type
);
-- read 
function read (
p_id_foto in foto.id_foto%type
) return sys_refcursor;
-- all 
function read_all return sys_refcursor;

end crud_foto;
/
create or replace package body crud_foto
is
-- insert 
function ins( 
p_id_departamento in foto.id_departamento%type,
p_ruta in foto.ruta%type
) return number
as 
new_id number := 0;
begin
new_id := foto_seq.nextval;
insert into foto(id_foto,id_departamento,ruta)
values (new_id,p_id_departamento,p_ruta);
return new_id;
end;

-- update 
procedure upd (
p_id_foto in foto.id_foto%type,
p_id_departamento in foto.id_departamento%type,
p_ruta in foto.ruta%type
)
as
begin
update foto set
id_departamento = p_id_departamento,ruta = p_ruta;
end;

-- delete 
procedure del (
p_id_foto in foto.id_foto%type
)
as
begin
delete from foto where id_foto = p_id_foto;
end;

-- read 
function read (
p_id_foto in foto.id_foto%type
) return sys_refcursor
as 
my_cursor sys_refcursor;
begin
open my_cursor for
select * from foto where id_foto = p_id_foto;
return my_cursor;
end;

-- all 
function read_all return sys_refcursor
as 
my_cursor sys_refcursor;
begin
open my_cursor for
select * from foto;
return my_cursor;
end;


end crud_foto;