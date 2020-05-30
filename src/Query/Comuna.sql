

-- Tablas de Comuna

SELECT * FROM COMUNA WHERE ID_COMUNA=ID_COMUNA;
SELECT * FROM COMUNA;
INSERT INTO COMUNA (ID_COMUNA,NOMBRE,ID_REGION) VALUES (ID_COMUNA,"NOMBRE",ID_REGION);
UPDATE COMUNA SET ID_COMUNA=ID_COMUNA,NOMBRE="NOMBRE",ID_REGION=ID_REGION WHERE ID_COMUNA=ID_COMUNA;
DELETE * FROM COMUNA WHERE ID_COMUNA=ID_COMUNA;



-- PROCEDIMIENTOS --

CREATE OR REPLACE PROCEDURE proc_insert_comuna(v_id_comuna NUMBER,v_nombre VARCHAR2,v_id_region NUMBER)
AS 
BEGIN 
INSERT INTO Comuna (ID_COMUNA,NOMBRE,ID_REGION) VALUES (v_id_comuna,v_nombre,v_id_region);    
END;

