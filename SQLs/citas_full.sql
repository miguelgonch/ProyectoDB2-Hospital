--------------------------------------------------------
--  File created - Sunday-April-21-2019   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for View CITAS_FULL
--------------------------------------------------------

  CREATE OR REPLACE FORCE EDITIONABLE VIEW "C##HOSPITAL2"."CITAS_FULL" ("CITA_ID", "DIAGNOSTICO", "RESULTADOS", "MEDICINAS", "PASOSASEGUIR", "OBSERVACIONES", "FECHA", "PACIENTE_ID", "NOMBRE", "APELLIDO", "DPI", "DOC_ID", "NOMBRE_DOC", "APELLIDO_DOC", "ID_SUBCAT", "SUBCAT", "ID_CAT", "CATEGORIA", "COSTO") AS 
  select c.cita_id ,c.diagnostico,c.resultados,c.medicinas,c.pasosaseguir,c.observaciones,c.fecha,c.paciente_id,pa.nombre,pa.apellido,pa.DPI,doc_id,u.nombre nombre_doc,u.apellido apellido_doc,c.id_subcat,subcat,cat.id_cat,categoria, s.costo from citas c join usuario u on u.usuario_id = c.doc_id join pacientes pa on c.paciente_id = pa.paciente_id join subcategoria s on c.id_subcat = s.id_subcat join categoria cat on cat.id_cat = s.id_cat order by fecha
;
