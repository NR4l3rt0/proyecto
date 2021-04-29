-- Nota, considerar crear tabla fechaTransacción(pedido, entrega)


-- ######################  DDL #####################################

--CREATE DATABASE proyecto;

-- Creando 'por defectos' -> 
-- docker run --name postgresDB -e POSTGRES_PASSWORD=postgres -e POSTGRES_USER=postgres -e POSTGRES_DB=proyecto -d postgres





/*

-----------------------------------------------------------------------------------
                        MODIFICACIONES EN IMPLEMENTACIÓN
-----------------------------------------------------------------------------------

1.-
    -------------------------------------------------------
    -- Creación de tipos ENUM:
    --------------------------------------------------------------------------------------
    * Se obvian finalmente para tratar de evitar problemas en el mapeo, 
    * se creará con VARCHAR y se pretende eliminar/controlar errores desde la interfaz gráfica
    * o desde programa backend.
    --------------------------------------------------------------------------------------

    CREATE TYPE estado_civil AS ENUM ('casado/-a', 'soltero/-a', 'N/A');
    CREATE TYPE jornada_trabajo AS ENUM ('completa', 'parcial', 'flexible');
    CREATE TYPE tipo_pedido AS ENUM ('personal', 'online');
    CREATE TYPE tipo_empleado AS ENUM ('comercial', 'almacén', 'analista', 'manager', 'administrativo', 'sop. técnico', 'coordinador', 'transportista');
    CREATE TYPE estado_pedido AS ENUM ('solicitado', 'entregado', 'en camino', 'cancelado', 'devuelto'); 

        -- Es igual a tipo pedido porque se considera la opción de que sea mediante terceros
    CREATE TYPE opcion_pago AS ENUM ('personal', 'online');
    


 2.-   
    ---------------------------------------------------------------------------
    -- CAMBIO EN TODAS LAS FECHAS QUE USEN HORA Y VENGAN DESDE APPS DE TERCEROS
    --------------------------------------------------------------------------------------
    * Ej: los campos como el tipo fecha_baja TIMESTAMPTZ, se sustituye por VARCHAR(40);
    * así, al traerla de la aplicación se pueden evitar problemas de compatibilidad de tipos 
    * y eso ayudará también a nivel de seguridad pues se usará parecido a ZonedDateTime.now()
    * ---------------------------------------------------------------------------------------
    * Nota: por tanto los tipo DATE no serán afectados.
    *

3.- 
    ---------------------------------------------------------------------------
    -- CAMBIO EN TODAS LOS PRECIOS A NUMERIC
    ------------------------------------------------------------------------------------------

    * Según la documentación se recomienda usar el tipo numeric(precisión, escala) para 
    * tratar el dinero, pues evita errores al tratar monedas internacionales y es más preciso
    * que money. 
    * Además se usará una escala de 4 según se recomienda.
    * ----------------------------------------------------------------------------------------

*/



--------------------------------------------------------------------------------
-- Creación tablas

--------------------------------------------------------------------------------

-------------------------------------------------------
-- persona (clase base)
-------------------------------------------------------
DROP TABLE IF EXISTS persona;

CREATE TABLE IF NOT EXISTS persona(
    nombre VARCHAR(25),
    apellidos VARCHAR(25),
    tfno VARCHAR(25),
    email VARCHAR(40),
    edad SMALLINT,
    sexo VARCHAR(10),
    localidad VARCHAR(20),
    estado_civ VARCHAR(15),
    estudio VARCHAR(20),
    ocupacion VARCHAR(25),
    hobby VARCHAR(25),
    familia_numerosa BOOLEAN
);


-------------------------------------------------------
-- clienteCRM hereda de persona
-------------------------------------------------------
DROP TABLE IF EXISTS clienteCRM CASCADE;

CREATE TABLE clienteCRM(

    id_nro_socio INT GENERATED ALWAYS AS IDENTITY,
    fecha_alta TIMESTAMPTZ DEFAULT Now(),
    fecha_baja VARCHAR(40),    
    encuesta_hecha BOOLEAN,

    PRIMARY KEY (id_nro_socio) 
) INHERITS (persona);

ALTER TABLE clienteCRM 
    ALTER COLUMN encuesta_hecha SET DEFAULT FALSE,
    ALTER COLUMN edad,
    ALTER COLUMN tfno,
    ALTER COLUMN nombre SET NOT NULL,
    ALTER COLUMN apellidos,
    ALTER COLUMN localidad,
    ALTER COLUMN sexo;


--  Aunque se añade, no se usa en un principio 
--  (opciones a tener en cuenta al mapear @Clob o @Column(columnDefinition=”TEXT”))
ALTER TABLE clienteCRM 
    ADD COLUMN comentario text; 

ALTER TABLE clienteCRM 
    ADD CONSTRAINT uniq_email_cli 
        UNIQUE (email),
    ADD CONSTRAINT uniq_tfno_cli 
        UNIQUE (tfno);


ALTER TABLE clienteCRM 
    RENAME CONSTRAINT clientecrm_pkey TO pk_id_nro_socio;



-------------------------------------------------------
-- empleadoRRHH hereda de persona
-------------------------------------------------------

DROP TABLE IF EXISTS empleadoRRHH CASCADE;

CREATE TABLE empleadoRRHH(
    id_nro_empleado INT GENERATED ALWAYS AS IDENTITY,
    dni_empl VARCHAR(15) NOT NULL,
    tipo_empl VARCHAR(15) NOT NULL,           
    jornada_trab VARCHAR(15) NOT NULL,
    salario NUMERIC(15,4) NOT NULL,

    CONSTRAINT pk_id_nro_empleado 
        PRIMARY KEY (id_nro_empleado)

) INHERITS (persona);


ALTER TABLE empleadoRRHH             -- por la herencia se considera hacerlo aquí
    ALTER COLUMN edad SET NOT NULL,
    ALTER COLUMN tfno SET NOT NULL,
    ALTER COLUMN nombre SET NOT NULL,
    ALTER COLUMN apellidos SET NOT NULL,
    ALTER COLUMN localidad SET NOT NULL,
    ALTER COLUMN email SET NOT NULL,
    ALTER COLUMN  sexo SET NOT NULL;

ALTER TABLE empleadoRRHH
    ADD CONSTRAINT uniq_email_emp 
        UNIQUE (email),
    ADD CONSTRAINT uniq_tfno_emp 
        UNIQUE (tfno);



-------------------------------------------------------
-- Tabla pedidoCliente
-------------------------------------------------------

DROP TABLE IF EXISTS pedidoCliente CASCADE;

CREATE TABLE pedidoCliente(
    id_nro_pedido INT GENERATED ALWAYS AS IDENTITY,
    estado_p VARCHAR(15) DEFAULT 'solicitado',
    tipo_p VARCHAR(15) NOT NULL,
    modo_pago VARCHAR(15) NOT NULL,
    coste_pedido NUMERIC(15,4) NOT NULL,
    fecha_pedido TIMESTAMPTZ DEFAULT NOW(),
    fecha_entrega VARCHAR(40),
    fk_id_nro_socio INT,
    fk_id_nro_empleado INT,

    CONSTRAINT pk_id_nro_pedido 
        PRIMARY KEY (id_nro_pedido),
    CONSTRAINT fk_id_nro_socio 
        FOREIGN KEY (fk_id_nro_socio) 
            REFERENCES clienteCRM(id_nro_socio),
    CONSTRAINT fk_id_nro_empleado 
        FOREIGN KEY (fk_id_nro_empleado) 
            REFERENCES empleadoRRHH(id_nro_empleado)
                ON DELETE SET NULL
                -- Se considera la problemática referencial
);

ALTER TABLE pedidocliente
    ALTER COLUMN fk_id_nro_socio 
        SET NOT NULL,
    ALTER COLUMN fk_id_nro_empleado 
        SET NOT NULL;


-------------------------------------------------------
-- Tabla almacenProductos
-------------------------------------------------------

DROP TABLE IF EXISTS almacenProductos CASCADE;

CREATE TABLE almacenProductos(
    id_nro_producto INT GENERATED ALWAYS AS IDENTITY,   -- id interno
    id_producto INT NOT NULL,
    categoria_prod VARCHAR(10),
    cantidad_prod SMALLINT NOT NULL             -- se considera para dar avisos
                    CHECK (cantidad_prod > 0),  -- Check para no pedir más de existencias
    fecha_caducidad DATE NOT NULL,              -- se considera para dar avisos

    CONSTRAINT pk_id_nro_producto 
        PRIMARY KEY (id_nro_producto)
);


-------------------------------------------------------
-- Tabla elementosPedido

-- En este caso, sirve de enlace descriptivo de los productos; pero, es cierto
-- que se abstraen muchos detalles. (Incluso no se menciona el reparto).
-- Nótese que no se hace mención en cuanto a DELETE o UPDATE en las referencias;
-- pues, en ese caso, cambiaría de estado el pedido; es decir, se debe justificar.
-------------------------------------------------------

DROP TABLE IF EXISTS elementosPedido CASCADE;

CREATE TABLE elementosPedido (
    fk_id_nro_producto INT,
    fk_id_nro_pedido INT,
    precio NUMERIC(15,4) NOT NULL,

    CONSTRAINT pk_productos_pedido 
        PRIMARY KEY (fk_id_nro_producto,fk_id_nro_pedido),
    CONSTRAINT fk_id_nro_producto 
        FOREIGN KEY (fk_id_nro_producto) 
            REFERENCES almacenProductos(id_nro_producto),
    CONSTRAINT fk_id_nro_pedido 
        FOREIGN KEY (fk_id_nro_pedido) 
            REFERENCES pedidoCliente(id_nro_pedido)
);


-------------------------------------------------------
-- Tabla proveedor
-------------------------------------------------------

DROP TABLE IF EXISTS proveedor CASCADE;

CREATE TABLE proveedor (
    id_proveedor INT PRIMARY KEY,      ------  PK
    id_producto_provee INT NOT NULL
);

-------------------------------------------------------
-- Tabla pedidoEmpresa
-------------------------------------------------------

DROP TABLE IF EXISTS pedidoEmpresa CASCADE;

CREATE TABLE pedidoEmpresa(
    fk_id_proveedor INT,
    fk_id_nro_producto_empresa INT,
    fecha_pedido_emp DATE DEFAULT CURRENT_DATE, -- uso otra función
    fecha_entrega DATE,
    id_nro_factura INT,

    CONSTRAINT pk_id_nro_factura 
        PRIMARY KEY(id_nro_factura),
    CONSTRAINT fk_id_proveedor 
        FOREIGN KEY (fk_id_proveedor) 
            REFERENCES proveedor(id_proveedor),
    CONSTRAINT fk_id_nro_producto_emp 
        FOREIGN KEY (fk_id_nro_producto_empresa) 
            REFERENCES almacenProductos(id_nro_producto)
);




--------------------------------------------------------------------------------

-- ######################          DML              #######################

--------------------------------------------------------------------------------
-- Introduce datos según la tabla
--------------------------------------------------------------------------------

INSERT INTO clienteCRM (nombre, apellidos, email, tfno, edad, sexo, localidad,
                        estado_civ, estudio, ocupacion, hobby, familia_numerosa) 
                VALUES ('Juan', 'Vera', 'juan@hotmail.com', '667747474', 35, 'Hombre', 'Madrid',
                        'soltero/-a','química', 'camarero', 'comida', true),
                        ('Juana', 'Vez', 'juana@hotmail.com','637747474',  25, 'Mujer', 'Madrid', 
                        'soltero/-a','filóloga', 'traductora', 'mascotas', false),
                        ('Sebas', 'Toledo', 'sebas@hotmail.com', '627337224', 45, 'Hombre', 'Málaga',
                         'casado/-a','manager', 'director hotel', 'idiomas', true),
                         ('Loli', 'Paz', 'loli@hotmail.com', '611337794',  37, 'Mujer', 'Málaga',
                         'soltero/-a','marketing', 'empresaria', 'cultura', true),
                         ('Pedro', 'Núñez','pedro@hotmail.com', '688886624',  25, 'Hombre', 'Sevilla',
                         'casado/-a','manager', 'director hotel', 'idiomas', true),
                         ('Petra', 'Willis','petra.willis@hotmail.com', '627337004',  45, 'Mujer', 'Alicante',
                         'casado/-a','manager', 'director hotel', 'idiomas', false),
                         ('Miguel', 'Cervantes','cervantes@hotmail.com', '627337211',  45, 'Hombre', 'Bilbao',
                         'casado/-a','derecho', 'bibliotecario', 'dibujar', true);


INSERT INTO empleadoRRHH (nombre, apellidos, tfno, email, edad, sexo, localidad,
                         estado_civ, estudio, ocupacion, hobby, familia_numerosa,
                         dni_empl, tipo_empl, jornada_trab, salario) 
                VALUES ('Lara', 'Pacheco', '664332194', 'lara@hotmail.com', 27, 'Mujer', 'Cádiz',
                         'soltero/-a','INEF', 'entrenadora', 'correr', true,
                         '12345678a', 'transportista', 'completa', 20000),
                         ('Jose', 'Moreno', '611181121', 'jose@hotmail.com', 55, 'Hombre', 'Las Palmas',
                         'casado/-a','FP', 'coordinador', 'aviones', true,
                         '21345678b', 'coordinador', 'flexible', 30000),
                         ('Clara', 'Díaz', '655537004', 'clara.diaz@hotmail.com', 54, 'Mujer', 'A coruña',
                         'soltero/-a','psicología', 'dependiente', 'vino', false,
                         '3124678z', 'administrativo', 'parcial', 21000),
                         ('Paul', 'Lesly', '627330001', 'gibson@hotmail.com', 22, 'Hombre', 'Zaragoza',
                         'casado/-a','ingeniaría', 'estudiante', 'meditar', true,
                         '5123478y', 'sop. técnico', 'parcial', 19500);


INSERT INTO pedidocliente (tipo_p, modo_pago, coste_pedido, fk_id_nro_socio, fk_id_nro_empleado) 
                    VALUES ('online', 'online', 138.50, 6, 3),
                            ('online', 'online', 338.50, 4, 4),
                            ('online', 'online', 38.50, 3, 1),
                            ('personal', 'personal', 58.50, 2, 3),
                            ('online', 'personal', 38.50, 1, 1);


INSERT INTO almacenProductos (id_producto, cantidad_prod, fecha_caducidad) 
                    VALUES (244, 100, '2021-12-4'),
                            (144, 88, '2021-7-30'),
                            (14, 85, '2022-7-2'),
                            (44, 36, '2021-8-14'),
                            (244, 650, '2021-10-4'),
                            (444, 38, '2021-9-24'),
                            (534, 188, '2021-9-14');