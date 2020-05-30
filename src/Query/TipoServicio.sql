

-- Tablas de TipoServicio

SELECT * FROM TIPO_SERVICIO WHERE ID_TIPO_SERVICIO=ID_TIPO_SERVICIO;
SELECT * FROM TIPO_SERVICIO;
INSERT INTO TIPO_SERVICIO (ID_TIPO_SERVICIO,DESCRIPCION,VALOR) VALUES (ID_TIPO_SERVICIO,"DESCRIPCION",VALOR);
UPDATE TIPO_SERVICIO SET ID_TIPO_SERVICIO=ID_TIPO_SERVICIO,DESCRIPCION="DESCRIPCION",VALOR=VALOR WHERE ID_TIPO_SERVICIO=ID_TIPO_SERVICIO;
DELETE * FROM TIPO_SERVICIO WHERE ID_TIPO_SERVICIO=ID_TIPO_SERVICIO;



-- PROCEDIMIENTOS --

CREATE OR REPLACE PROCEDURE proc_insert_tipo_servicio(v_id_tipo_servicio NUMBER,v_descripcion VARCHAR2,v_valor NUMBER)
AS 
BEGIN 
INSERT INTO TipoServicio (ID_TIPO_SERVICIO,DESCRIPCION,VALOR) VALUES (v_id_tipo_servicio,v_descripcion,v_valor);    
END;

