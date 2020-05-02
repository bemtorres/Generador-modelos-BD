

-- Tablas de Countries

SELECT * FROM COUNTRIES WHERE COUNTRY_ID=COUNTRY_ID;
SELECT * FROM COUNTRIES;
INSERT INTO COUNTRIES (COUNTRY_ID,COUNTRY_NAME,REGION_ID) VALUES ("COUNTRY_ID","COUNTRY_NAME",REGION_ID);
UPDATE COUNTRIES SET COUNTRY_ID="COUNTRY_ID",COUNTRY_NAME="COUNTRY_NAME",REGION_ID=REGION_ID WHERE COUNTRY_ID="COUNTRY_ID";
DELETE * FROM COUNTRIES WHERE COUNTRY_ID=COUNTRY_ID;



-- PROCEDIMIENTOS --

CREATE OR REPLACE PROCEDURE proc_insert_countries(v_country_id CHAR,v_country_name VARCHAR2,v_region_id NUMBER)
AS 
BEGIN 
INSERT INTO Countries (COUNTRY_ID,COUNTRY_NAME,REGION_ID) VALUES (v_country_id,v_country_name,v_region_id);    
END;

