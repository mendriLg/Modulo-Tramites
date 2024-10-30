-- Puedo crear un archivo schema.sql o schema.sql para que jpa lo inicialice en conjunto con la aplicación

INSERT IGNORE INTO tramites (id, nombre) VALUES
       (1, "esterilizacion"),
       (2, "desparasitacion");

INSERT IGNORE INTO usuarios (nombre) VALUES
       ("hola");
INSERT IGNORE INTO servicios (id) VALUES
       (1);

INSERT IGNORE INTO vecinos (id) VALUES
       (1),
       (2);

INSERT IGNORE INTO solicitudes (id,estado, tramite_id, vecino_id) VALUES
       (1,"PAGADO", 1, 1),
       (2,"FINALIZADO", 2, 1),
       (3,"EVALUADO", 2, 2),
       (4,"PENDIENTE", 1, 2),
       (5,"PAGADO", 1, 2),
       (6,"EVALUADO", 2, 1);
