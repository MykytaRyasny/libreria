create table libros
(
    ID_L         int auto_increment
        primary key,
    Titulo       varchar(45) null,
    Autor        varchar(45) null,
    Editorial    varchar(45) null,
    Anyo_edicion int         null,
    Image        longblob    null
);

create table login
(
    usuario     varchar(45)          not null
        primary key,
    contrasenya varchar(45)          null,
    privilegios tinyint(1) default 0 null
);

create table usuarios
(
    DNI           int         not null
        primary key,
    Nombre        varchar(45) null,
    Apellido      varchar(45) null,
    Telefono      int         null,
    login_usuario varchar(45) not null,
    constraint fk_Usuarios_login1
        foreign key (login_usuario) references login (usuario)
);

create table compras
(
    ID_C         int auto_increment
        primary key,
    Usuarios_DNI int not null,
    ID_L_FK      int not null,
    constraint UK_m7mychoaha9vcb5ylsykb12m4
        unique (ID_L_FK),
    constraint IDL
        foreign key (ID_L_FK) references libros (ID_L),
    constraint Usuarios_DNI
        foreign key (Usuarios_DNI) references usuarios (DNI)
);

create index fk_Usuarios_login1_idx
    on usuarios (login_usuario);


-- -----------------------------------------------------
-- Data for table `libreria`.`login`
-- -----------------------------------------------------
START TRANSACTION;
USE `libreria`;
INSERT INTO `libreria`.`login` (`usuario`, `contrasenya`, `privilegios`) VALUES ('admin', 'admin', true);
INSERT INTO `libreria`.`login` (`usuario`, `contrasenya`, `privilegios`) VALUES ('user', 'user', false);

COMMIT;


-- -----------------------------------------------------
-- Data for table `libreria`.`Usuarios`
-- -----------------------------------------------------
START TRANSACTION;
USE `libreria`;
INSERT INTO `libreria`.`Usuarios` (`DNI`, `Nombre`, `Apellido`, `Telefono`, `login_usuario`) VALUES (123456789, 'NombreAdmin', 'ApellidoAdmin', 123123123, 'admin');
INSERT INTO `libreria`.`Usuarios` (`DNI`, `Nombre`, `Apellido`, `Telefono`, `login_usuario`) VALUES (987654321, 'NombreUser', 'ApellidoUser', 321321321, 'user');

COMMIT;


-- INSERTS DE LIBROS
-- Insertar registro 1 en la tabla Libros
INSERT INTO Libros (Titulo, Autor, Editorial, Anyo_Edicion)
VALUES ('El Quijote de la Mancha', 'Miguel de Cervantes', 'Editorial Planeta', 1605);

-- Insertar registro 2 en la tabla Libros
INSERT INTO Libros (Titulo, Autor, Editorial, Anyo_Edicion)
VALUES ('Cien Años de Soledad', 'Gabriel García Márquez', 'Editorial Sudamericana', 1967);

-- Insertar registro 3 en la tabla Libros
INSERT INTO Libros (Titulo, Autor, Editorial, Anyo_Edicion)
VALUES ('Don Quijote de la Mancha', 'Miguel de Cervantes', 'Editorial Alianza', 1615);

-- Insertar registro 4 en la tabla Libros
INSERT INTO Libros (Titulo, Autor, Editorial, Anyo_Edicion)
VALUES ('El Gran Gatsby', 'F. Scott Fitzgerald', 'Editorial Vintage', 1925);

-- Insertar registro 5 en la tabla Libros
INSERT INTO Libros (Titulo, Autor, Editorial, Anyo_Edicion)
VALUES ('Matar a un ruiseñor', 'Harper Lee', 'Editorial J.B. Lippincott', 1960);

-- Insertar registro 6 en la tabla Libros
INSERT INTO Libros (Titulo, Autor, Editorial, Anyo_Edicion)
VALUES ('1984', 'George Orwell', 'Editorial Seix Barral', 1949);

-- Insertar registro 7 en la tabla Libros
INSERT INTO Libros (Titulo, Autor, Editorial, Anyo_Edicion)
VALUES ('El gran Gatsby', 'F. Scott Fitzgerald', 'Editorial Alianza', 1925);

-- Insertar registro 8 en la tabla Libros
INSERT INTO Libros (Titulo, Autor, Editorial, Anyo_Edicion)
VALUES ('El hombre en busca de sentido', 'Viktor Frankl', 'Editorial Herder', 1946);

-- Insertar registro 9 en la tabla Libros
INSERT INTO Libros (Titulo, Autor, Editorial, Anyo_Edicion)
VALUES ('El alquimista', 'Paulo Coelho', 'Editorial Planeta', 1988);

-- Insertar registro 10 en la tabla Libros
INSERT INTO Libros (Titulo, Autor, Editorial, Anyo_Edicion)
VALUES ('El diario de Ana Frank', 'Ana Frank', 'Editorial Bruguera', 1947);