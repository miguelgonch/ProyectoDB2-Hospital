--------------------------------------------------------
--  File created - Sunday-April-21-2019   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for View FACTURA_FULL
--------------------------------------------------------

  CREATE OR REPLACE FORCE EDITIONABLE VIEW "C##HOSPITAL2"."FACTURA_FULL" ("ID_FACTURA", "AUTORIZACION", "COBRO_CLIENTE", "CITA_ID", "FECHA", "NOMBRE", "APELLIDO", "SUBCAT", "CATEGORIA", "COSTO") AS 
  SELECT 

    f.ID_FACTURA, 
    f.AUTORIZACION, 
    f.COBRO_CLIENTE, 
    c.CITA_ID, 
    c.FECHA, 
    c.NOMBRE, 
    c.APELLIDO, 
    c.SUBCAT, 
    c.CATEGORIA, 
    c.Costo 
FROM 
    facturas f join citas_full c on f.CITA_ID = c.CITA_ID
;
