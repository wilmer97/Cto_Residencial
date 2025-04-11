Consultas Cto_Residencial:
1.  Mostrar la reserva de la zona social que ha hecho un propietario.

SELECT 
    p.nombre AS propietario,
    z.nombre AS zona_social,
    rz.fecha,
    rz.hora_inicio
FROM 
    reserva_zona rz
JOIN 
    propietario p ON rz.id_propietario = p.id_propietario
JOIN 
    zona_social z ON rz.id_zona = z.id_zona
WHERE 
    p.id_propietario = :id_propietario;

2.  Listar el propietario con los visitantes que han tenido.

SELECT 
    p.nombre AS propietario,
    p.cedula AS cedula_propietario,
    v.nombre AS visitante,
    v.cedula AS cedula_visitante,
    v.telefono,
    v.correo
FROM 
    propietario p
LEFT JOIN 
    visitante v ON p.id_propietario = v.id_propietario
ORDER BY 
    p.nombre, v.nombre;

3.  Listar Cuales son los parqueaderos que tienen asignado un propietario.

SELECT 
    p.nombre AS propietario,
    p.cedula,
    rp.fecha AS fecha_reserva,
    rp.hora_inicio AS hora_reserva
FROM 
    reserva_parqueadero rp
JOIN 
    propietario p ON rp.id_propietario = p.id_propietario
WHERE 
    rp.id_propietario = :id_propietario;

4.  buscar las reserva de la zona por fecha.

SELECT 
    z.nombre AS zona_social,
    p.nombre AS propietario,
    rz.fecha,
    rz.hora_inicio
FROM 
    reserva_zona rz
JOIN 
    zona_social z ON rz.id_zona = z.id_zona
JOIN 
    propietario p ON rz.id_propietario = p.id_propietario
WHERE 
    rz.fecha = :fecha_busqueda
ORDER BY 
    rz.hora_inicio;

PETICIONES REALIZADAS EN POSTMAN.
1.  Mostrar la reserva de la zona social que ha hecho un propietario.

{
  "query": "SELECT p.nombre AS propietario, z.nombre AS zona_social, rz.fecha, rz.hora_inicio FROM reserva_zona rz JOIN propietario p ON rz.id_propietario = p.id_propietario JOIN zona_social z ON rz.id_zona = z.id_zona WHERE p.id_propietario = $1",
  "params": [1]
}

2.  Listar el propietario con los visitantes que han tenido.

{
  "query": "SELECT p.nombre AS propietario, p.cedula AS cedula_propietario, v.nombre AS visitante, v.cedula AS cedula_visitante, v.telefono, v.correo FROM propietario p LEFT JOIN visitante v ON p.id_propietario = v.id_propietario ORDER BY p.nombre, v.nombre"
}

3.  Listar Cuales son los parqueaderos que tienen asignado un propietario.

{
  "query": "SELECT p.nombre AS propietario, p.cedula, rp.fecha AS fecha_reserva, rp.hora_inicio AS hora_reserva FROM reserva_parqueadero rp JOIN propietario p ON rp.id_propietario = p.id_propietario WHERE rp.id_propietario = $1",
  "params": [5]
}

4. Buscar las reserva de la zona por fecha.

{
  "query": "SELECT z.nombre AS zona_social, p.nombre AS propietario, rz.fecha, rz.hora_inicio FROM reserva_zona rz JOIN zona_social z ON rz.id_zona = z.id_zona JOIN propietario p ON rz.id_propietario = p.id_propietario WHERE rz.fecha = $1 ORDER BY rz.hora_inicio",
  "params": ["2023-06-15"]
}
