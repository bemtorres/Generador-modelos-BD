

-- Tablas de Region

SELECT * FROM REGION WHERE ID_REGION=ID_REGION;
SELECT * FROM REGION;
INSERT INTO REGION (ID_REGION,NOMBRE_REGION) VALUES (ID_REGION,"NOMBRE_REGION");
UPDATE REGION SET ID_REGION=ID_REGION,NOMBRE_REGION="NOMBRE_REGION" WHERE ID_REGION=ID_REGION;
DELETE * FROM REGION WHERE ID_REGION=ID_REGION;



-- PROCEDIMIENTOS --

CREATE OR REPLACE PROCEDURE proc_insert_region(v_id_region NUMBER,v_nombre_region VARCHAR2)
AS 
BEGIN 
INSERT INTO Region (ID_REGION,NOMBRE_REGION) VALUES (v_id_region,v_nombre_region);    
END;
