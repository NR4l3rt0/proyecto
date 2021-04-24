-- Nota, considerar crear tabla fechaTransacción(pedido, entrega)


-- ######################  DDL #####################################

CREATE DATABASE proyecto;
--USE proyecto;


-------------------------------------------------------
-- Creación de tipos ENUM:
-------------------------------------------------------
CREATE TYPE estado_civil AS ENUM ('casado/-a', 'soltero/-a', 'N/A');
CREATE TYPE jornada_trabajo AS ENUM ('completa', 'parcial', 'flexible');
CREATE TYPE tipo_pedido AS ENUM ('Personal', 'Online');
CREATE TYPE tipo_empleado AS ENUM ('Comercial', 'Almacén', 'Analista', 'Manager', 'Administrativo', 'Sop. Técnico', 'Coordinador', 'Transportista');
CREATE TYPE estado_pedido AS ENUM ('solicitado', 'entregado', 'en camino', 'cancelado', 'devuelto'); 
CREATE TYPE opcion_pago AS ENUM ('personal', 'online');



--------------------------------------------------------------------------------
-- Creación tablas

--------------------------------------------------------------------------------

-------------------------------------------------------
-- persona (clase base)
-------------------------------------------------------

CREATE TABLE IF NOT EXISTS persona(
    id INT GENERATED ALWAYS AS IDENTITY,
    nombre VARCHAR(15),
    apellidos VARCHAR(25),
    tfno VARCHAR(15),
    email VARCHAR(25),
    edad SMALLINT,
    sexo VARCHAR(10),
    localidad VARCHAR(20),
    estado_civ estado_civil,
    estudio VARCHAR(20),
    ocupacion VARCHAR(15),
    hobby VARCHAR(15),
    familia_numerosa BOOLEAN
);

-------------------------------------------------------
-- clienteCRM hereda de persona
-------------------------------------------------------

CREATE TABLE IF NOT EXISTS clienteCRM(
    nro_socio INT GENERATED ALWAYS AS IDENTITY,
    fecha_alta TIMESTAMPTZ DEFAULT Now(),
    fecha_baja TIMESTAMPTZ,
    encuesta_hecha BOOLEAN,

    PRIMARY KEY (nro_socio) 
) INHERITS (persona);

ALTER TABLE clienteCRM 
    ALTER COLUMN encuesta_hecha SET DEFAULT FALSE,
    ALTER COLUMN edad SET NOT NULL,
    ALTER COLUMN tfno SET NOT NULL,
    ALTER COLUMN nombre SET NOT NULL,
    ALTER COLUMN apellidos SET NOT NULL,
    ALTER COLUMN localidad SET NOT NULL;

ALTER TABLE clienteCRM  
    ALTER COLUMN  sexo SET NOT NULL;
ALTER TABLE clienteCRM 
    ADD COLUMN comentario text;


ALTER TABLE clienteCRM 
    RENAME CONSTRAINT clientecrm_pkey TO pk_nro_socio;


-------------------------------------------------------
-- empleadoRRHH hereda de persona
-------------------------------------------------------

CREATE TABLE IF NOT EXISTS empleadoRRHH(
    nro_empleado INT GENERATED ALWAYS AS IDENTITY,
    dni_empl VARCHAR(15) NOT NULL,
    tipo_empl tipo_empleado NOT NULL,           -- uso ENUMS
    jornada_trab jornada_trabajo NOT NULL,
    salario money NOT NULL,

    CONSTRAINT pk_nro_empleado 
        PRIMARY KEY (nro_empleado)

) INHERITS (persona);


ALTER TABLE empleadoRRHH             -- por la herencia se considera hacerlo aquí
    ALTER COLUMN edad SET NOT NULL,
    ALTER COLUMN tfno SET NOT NULL,
    ALTER COLUMN nombre SET NOT NULL,
    ALTER COLUMN apellidos SET NOT NULL,
    ALTER COLUMN localidad SET NOT NULL;

ALTER TABLE empleadoRRHH
    ALTER COLUMN email SET NOT NULL; 
ALTER TABLE empleadoRRHH
    ALTER COLUMN  sexo SET NOT NULL;


-------------------------------------------------------
-- Tabla pedidoCliente
-------------------------------------------------------

CREATE TABLE IF NOT EXISTS pedidoCliente(
    nro_pedido INT GENERATED ALWAYS AS IDENTITY,
    estado_p estado_pedido DEFAULT 'solicitado',
    tipo_p tipo_pedido NOT NULL,
    modo_pago opcion_pago NOT NULL,
    coste_pedido money NOT NULL,
    fecha_pedido TIMESTAMPTZ DEFAULT NOW(),
    fecha_entrega TIMESTAMPTZ,
    fk_nro_socio INT,
    fk_nro_empleado INT,

    CONSTRAINT pk_nro_pedido 
        PRIMARY KEY (nro_pedido),
    CONSTRAINT fk_nro_socio 
        FOREIGN KEY (fk_nro_socio) 
            REFERENCES clienteCRM(nro_socio),
    CONSTRAINT fk_nro_empleado 
        FOREIGN KEY (fk_nro_empleado) 
            REFERENCES empleadoRRHH(nro_empleado)
                ON DELETE SET NULL
                -- Se considera la problemática referencial
);


-------------------------------------------------------
-- Tabla almacenProductos
-------------------------------------------------------

CREATE TABLE IF NOT EXISTS almacenProductos(
    nro_producto INT GENERATED ALWAYS AS IDENTITY,
    id_producto INT NOT NULL,
    categoria_prod VARCHAR(10),
    cantidad_prod SMALLINT NOT NULL             -- se considera para dar avisos
                    CHECK (cantidad_prod > 0),  -- Check para no pedir más de existencias
    fecha_caducidad DATE NOT NULL,              -- se considera para dar avisos

    CONSTRAINT pk_nro_producto 
        PRIMARY KEY (nro_producto)
);


-------------------------------------------------------
-- Tabla elementosPedido

-- En este caso, sirve de enlace descriptivo de los productos; pero, es cierto
-- que se abstraen muchos detalles. (Incluso no se menciona el reparto).
-- Nótese que no se hace mención en cuanto a DELETE o UPDATE en las referencias;
-- pues, en ese caso, cambiaría de estado el pedido; es decir, se debe justificar.
-------------------------------------------------------

CREATE TABLE IF NOT EXISTS elementosPedido (
    fk_nro_producto INT,
    fk_nro_pedido INT,
    precio money NOT NULL,

    CONSTRAINT pk_productos_pedido 
        PRIMARY KEY (fk_nro_producto,fk_nro_pedido),
    CONSTRAINT fk_nro_producto 
        FOREIGN KEY (fk_nro_producto) 
            REFERENCES almacenProductos(nro_producto),
    CONSTRAINT fk_nro_pedido 
        FOREIGN KEY (fk_nro_pedido) 
            REFERENCES pedidoCliente(nro_pedido)
);


-------------------------------------------------------
-- Tabla proveedor
-------------------------------------------------------

CREATE TABLE proveedor (
    id_proveedor INT PRIMARY KEY,      ------  PK
    id_producto_provee INT NOT NULL
);

-------------------------------------------------------
-- Tabla pedidoEmpresa
-------------------------------------------------------

CREATE TABLE IF NOT EXISTS pedidoEmpresa(
    fk_id_proveedor INT,
    fk_nro_producto_empresa INT,
    fecha_pedido_emp DATE DEFAULT CURRENT_DATE, -- uso otra función
    fecha_entrega DATE,
    nro_factura INT,

    CONSTRAINT pk_nro_factura 
        PRIMARY KEY(nro_factura),
    CONSTRAINT fk_id_proveedor 
        FOREIGN KEY (fk_id_proveedor) 
            REFERENCES proveedor(id_proveedor),
    CONSTRAINT fk_nro_producto_emp 
        FOREIGN KEY (fk_nro_producto_empresa) 
            REFERENCES almacenProductos(nro_producto)
);




--------------------------------------------------------------------------------

-- ######################          DML              #######################

--------------------------------------------------------------------------------
