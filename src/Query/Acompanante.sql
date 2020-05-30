

-- Tablas de Acompanante

SELECT * FROM ACOMPANANTE WHERE ID_ACOMPANANTE=ID_ACOMPANANTE;
SELECT * FROM ACOMPANANTE;
INSERT INTO ACOMPANANTE (ID_ACOMPANANTE,ID_RESERVA,ID_PERSONA) VALUES (ID_ACOMPANANTE,ID_RESERVA,ID_PERSONA);
UPDATE ACOMPANANTE SET ID_ACOMPANANTE=ID_ACOMPANANTE,ID_RESERVA=ID_RESERVA,ID_PERSONA=ID_PERSONA WHERE ID_ACOMPANANTE=ID_ACOMPANANTE;
DELETE * FROM ACOMPANANTE WHERE ID_ACOMPANANTE=ID_ACOMPANANTE;



-- PROCEDIMIENTOS --

CREATE OR REPLACE PROCEDURE proc_insert_acompanante(v_id_acompanante NUMBER,v_id_reserva NUMBER,v_id_persona NUMBER)
AS 
BEGIN 
INSERT INTO Acompanante (ID_ACOMPANANTE,ID_RESERVA,ID_PERSONA) VALUES (v_id_acompanante,v_id_reserva,v_id_persona);    
END;

