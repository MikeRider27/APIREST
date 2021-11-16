CREATE TABLE public.ciudad (
                id_ciudad SERIAL,
                descripcion VARCHAR(50) NULL,
                CONSTRAINT ciudad_pk PRIMARY KEY (id_ciudad)
);


CREATE TABLE public.roles (
                id_rol SERIAL,
                descripcion VARCHAR(50) NULL,
                CONSTRAINT roles_pk PRIMARY KEY (id_rol)
);


CREATE TABLE public.color (
                id_color SERIAL,
                descripcion VARCHAR(50) NULL,
                CONSTRAINT color_pk PRIMARY KEY (id_color)
);



CREATE TABLE public.marca (
                id_marca SERIAL,
                descripcion VARCHAR(50) NULL,
                CONSTRAINT marca_pk PRIMARY KEY (id_marca)
);



CREATE TABLE public.modelo (
                id_modelo SERIAL,
                id_marca INTEGER NULL,
                descripcion VARCHAR(50) NULL,
                CONSTRAINT modelo_pk PRIMARY KEY (id_modelo, id_marca)
);


CREATE TABLE public.tipo_vehiculo (
                id_tipo SERIAL,
                descripcion VARCHAR(50) NULL,
                CONSTRAINT tipo_vehiculo_pk PRIMARY KEY (id_tipo)
);


CREATE TABLE public.usuarios (
                id_usuario SERIAL,
                nombre VARCHAR(200) NULL,
                nick VARCHAR(50) NULL,
                password VARCHAR(250) NULL,
                id_rol INTEGER NULL,
                estado BOOLEAN NULL,
                CONSTRAINT usuarios_pk PRIMARY KEY (id_usuario)
);


CREATE TABLE public.usuario_token (
                id_usuario INTEGER NULL,
                token VARCHAR NULL,
                creacion_token TIMESTAMP NULL,
                validez_token TIMESTAMP NULL,
                CONSTRAINT usuario_token_pk PRIMARY KEY (id_usuario)
);


CREATE TABLE public.cliente (
                id_cliente SERIAL,
                cedula VARCHAR(18) NULL,
                nombres VARCHAR(10) NULL,
                apellidos VARCHAR(100) NULL,
                telefono VARCHAR(10) NULL,
                email VARCHAR(100) NULL,
                id_ciudad INTEGER NULL,
                CONSTRAINT cliente_pk PRIMARY KEY (id_cliente)
);


CREATE TABLE public.vehiculos (
                id_vehiculo SERIAL,
                id_cliente INTEGER NULL,
                chapa VARCHAR(8) NULL,
                id_modelo INTEGER NULL,
                id_marca INTEGER NULL,
                id_tipo INTEGER NULL,
                id_color INTEGER NULL,
                CONSTRAINT vehiculos_pk PRIMARY KEY (id_vehiculo)
);



CREATE TABLE public.entrada_salida (
                id_entrada_salida SERIAL,
                id_vehiculo INTEGER NULL,
                chapa VARCHAR(8) NULL,
                fecha_llegada DATE NULL,
                hora_llegada TIME NULL,
                fecha_salida DATE NULL,
                hora_salida TIME NULL,
                transcurrido TIME NULL,
                valor_cobro INTEGER NULL,
                tipo_cobro VARCHAR(20) NULL,
                id_usuario INTEGER NULL,
                estado VARCHAR(1) NULL,
                id_cliente INTEGER NULL,
                CONSTRAINT entrada_salida_pk PRIMARY KEY (id_entrada_salida)
);




CREATE TABLE public.pagos (
                id_pago SERIAL,
                fecha_pago DATE NULL,
                fecha_vencimiento DATE NULL,
                hora_pago TIME NULL,
                id_entrada_salida INTEGER NULL,
                tiempo VARCHAR(8) NULL,
                id_usuario INTEGER NULL,
                id_cliente INTEGER NULL,
                CONSTRAINT pagos_pk PRIMARY KEY (id_pago)
);





CREATE TABLE public.tarifas (
                id_tarifa SERIAL,
                tipo VARCHAR(8) NULL,
                tiempo VARCHAR(8) NULL,
                valor_tarifa INTEGER NULL,
                descuento INTEGER NULL,
                aplica_descuento INTEGER NULL,
                id_usuario INTEGER NULL,
                id_pago INTEGER NULL,
                CONSTRAINT tarifas_pk PRIMARY KEY (id_tarifa)
);



