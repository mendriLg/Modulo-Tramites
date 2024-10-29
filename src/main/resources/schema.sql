-- Puedo crear un archivo schema.sql o schema.sql para que jpa lo inicialice en conjunto con la aplicación

INSERT IGNORE INTO tramites (nombre) VALUES
       ("esterilizacion"),
       ("desparasitacion");

INSERT IGNORE INTO usuarios (nombre) VALUES
       ("hola");
INSERT IGNORE INTO servicios (id) VALUES
       (1);

INSERT IGNORE INTO solicitudes (id,estado, tramite_id) VALUES
       (1,"PAGADO", 1),
       (2,"FINALIZADO",2),
       (3,"EVALUADO", 14),
       (26,"PENDIENTE", 7),
       (34,"PAGADO", 6),
       (40,"EVALUADO", 4);
