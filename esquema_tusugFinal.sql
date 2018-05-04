create schema sistemaTusug authorization postgres;
set search_path to sistemaTusug;--Configura la ruta hacia donde se ejecutaran las instrucciones
--drop schema sistemaTusug cascade;

create table refaccion
(
	--NO acepta valores nulos, ya que debe exister un producto y con código del producto. 
	codigo_producto      int primary key not null,
	descripción_producto varchar(100)  not null,
	cantidad_producto    int ,
	--1) EL identificador de refacciones irá del número 1 hacia adelante,
	--debido a que debe existir por lo menos una refaccion
	--La cantidad de productos que pueda almacenar la refaccionaria es de 800 productos 
	check(codigo_producto>=1 and codigo_producto <=800)
);
create table autobus
( 
	--Un autobús debe registrar con un código en la empresa, para poder operar, y
	--este debe tener marca, numero economico y matricula del autobús. 
      codigo_autobus  int primary key not null,
      marca              varchar(50) not null,
      numerico_economico varchar(80) not null,--Numero de Permiso para trabajar en la compañía
      matricula_autobus  varchar (80)not null,--Numero para poder Transistar
      check(codigo_autobus>=1000 and codigo_autobus <=1049)--Son 50 unidades y comenzara del 1000 al 1049
);

create table poliza(
	codigo_poliza int primary key not null,
	codigo_autobus int references autobus(codigo_autobus)not null,
	descripcion varchar (100) not null,-- puede variar en función del de seguro, y puede ser de tipo material
	fecha_comienzo date not null, --cobertura del Seguro
	fecha_terminacion date not null,
	prima_pagar numeric (8,2)not null,--Las primas que debe pagar el asegurado
	limite_indemnizacion numeric (8,2) not null, -- El límite máximo de la indemnización en caso de accidente
	check(codigo_autobus>=2000 and codigo_autobus <=2049)--Son 50 polizas y comenzara del 2000 al 2049
);
create table ruta(
	-- No se puede ingresar valores nulos, ya que existe rutas en el estado(Oaxaca).
	codigo_ruta  int primary key not null,
        nombre_ruta  varchar(100) not null,
        color_ruta   varchar (40) not null
);
create table ruta_autobus 
(	
	id_posesion int primary key not null,
	codigo_ruta int references ruta(codigo_ruta)not null,
	codigo_autobus int references autobus(codigo_autobus) not null
);
create table trabajador 
(
	--No se aceptan valores nulos, al registrar un trabajador. 
	--Podría ser demandada la empresa al incorporar un trabajadores ficticio
	rfc varchar (13) primary key not null,
	nss varchar (50) not null,
	nombre varchar(80) not null,
	apellido varchar(100) not null,
	domicilio varchar (100) not null,
	curp   varchar (18) not null,
	fecha_nacimiento date not null,
	fecha_contratacion date not null,
	fecha_terminacion date not null,
	estado varchar (6)not null, -- (Activo, Pasivo, Baja)
	url_img varchar (100),
	-- La Fecha de Terminación debe ser mayor que a la contratacion 
	check (fecha_terminacion>fecha_contratacion),
	--En estado, solo habra 3 opciones.
	check(estado = 'Activo'or estado = 'Pasivo'or estado = 'Baja'),
	--La fecha de nacimiento no puede ser mayor a la fecha actual
	check(fecha_nacimiento<current_date)
);

create table chofer_autobus
(	
	rfc varchar references trabajador(rfc) not null,
	codigo_autobus int references autobus(codigo_autobus) not null
);

create table chofer
(
	--No se aceptan valores nulos en chofer, este debe ser registrado
	--como trabajador dentro de la empresa, para poder operar una unidad de la empresa.
	rfc varchar references trabajador(rfc) not null,
	no_licencia int not null,
	horas_trabajadas int,
	experiencia int	
);

create table control_asistencia
(
	--No se aceptan valores nulos en la fecha, ya que si esta estuviera vacía no se podría
	--registrar el trabajador al control de asistencia.
	fecha date not null,
	rfc varchar references trabajador(rfc) not null,
	hora_entrada varchar(8) not null,
	hora_salida varchar(8)not null,
	observacion varchar (100)not null
);
create table expediente_permanente
(
	--No se aceptan valores nulos en expediente permanente, debe existir el trabajador
	--dentro de la empresa para poder ser registrado .
	rfc varchar references trabajador(rfc)not null,
	n_faltas int ,
	n_actasadministrativas int
);

create table accidente(
	-- Accidente no acepta valores nulos. Debido a que la empresa toma de
	--suma importancia esta información. Y debe exitir un accidente para poder
	--ser registrados en el sistema. 
	codigo_accidente int primary key not null,
	id_posesion int references ruta_autobus(id_posesion)not null,
	fecha date not null,
	descripcion varchar (80) not null,
	lugar varchar(100)not null,
	velocidad varchar (6)
	-- El codigo de accidente ira a partir del 4000
	check(codigo_accidente>=4000)
);
create table mantenimiento
(
	--No se aceptan valores nulos en mantenimiento.
	codigo_m int primary key not null,
	codigo_autobus int references autobus(codigo_autobus)not null,
	fecha_ingreso date not null,
	fecha_salida date not null,
	costo_reparacion numeric(8,2) not null,
	--EL codigo de mantenimiento ira de 3000, hacia adelante.
	check(codigo_m>=3000),
	-- La Fecha de ingreso al taller debe ser mayor que a la salida 
	check (fecha_ingreso>fecha_salida)
);
create table servicio
(
	--No se aceptan valores nulos en servicio.Ya quebe existir productos para poder
	--ser un mantenimiento y este pueda ser un servicio a la unidad(autobús) de la empresa.
	id_servicio int primary key not null,
	codigo_m int references mantenimiento(codigo_m)not null,
	codigo_producto int references refaccion(codigo_producto) not null,
	cantidad_producto int
);
--Estas tablas no estaran en el modelo-relacional, pero si en el sistema
create table usuario
(
	rfc varchar references trabajador(rfc),
	id_rol int primary key,
	contrasenia varchar (64),
	url_image varchar(100),
	uti_vez date
);
create table rol 
(
	id_rol int references usuario(id_rol),
	descripcion varchar(100),
	nivel varchar (30)
);
create table reporte
(
	fecha date,
	folio int primary key,
	url_formato varchar (100),
	tipo_reporte varchar(50)
);
create table control_nomina
(
	fecha date,
	url_nomina varchar(100)
);
