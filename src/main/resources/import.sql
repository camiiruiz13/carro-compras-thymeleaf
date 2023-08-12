SET IDENTITY_INSERT carrito.dbo.cliente ON 
INSERT INTO carrito.dbo.cliente (id,nombre,apellido,email,fechacreacion,foto) values 
(1,N'Andres', N'Guzman', N'profesor@bolsadeideas.com', '2017-08-01', N''),
(2,N'John', N'Doe', N'john.doe@gmail.com', '2017-08-02', N''),
(3,N'Linus', N'Torvalds', N'linus.torvalds@gmail.com', '2017-08-03', N'');
INSERT INTO carrito.dbo.cliente (id,nombre,apellido,email,fechacreacion,foto) values
    (4,N'Jane', N'Doe', N'jane.doe@gmail.com', '2017-08-04', N'');
INSERT INTO carrito.dbo.cliente (id,nombre,apellido,email,fechacreacion,foto) values
    (5,N'Rasmus', N'Lerdorf', N'rasmus.lerdorf@gmail.com', '2017-08-05', N'');
INSERT INTO carrito.dbo.cliente (id,nombre,apellido,email,fechacreacion,foto) values
    (6,N'Erich', N'Gamma', N'erich.gamma@gmail.com', '2017-08-06', N'');
INSERT INTO carrito.dbo.cliente (id,nombre,apellido,email,fechacreacion,foto) values
    (7,N'Richard', N'Helm', N'richard.helm@gmail.com', '2017-08-07', N'');
INSERT INTO carrito.dbo.cliente (id,nombre,apellido,email,fechacreacion,foto) values
    (8,N'Ralph', N'Johnson', N'ralph.johnson@gmail.com', '2017-08-08', N'');
INSERT INTO carrito.dbo.cliente (id,nombre,apellido,email,fechacreacion,foto) values
    (9,N'John', N'Vlissides', N'john.vlissides@gmail.com', '2017-08-09', N'');
INSERT INTO carrito.dbo.cliente (id,nombre,apellido,email,fechacreacion,foto) values
    (10,N'James', N'Gosling', N'james.gosling@gmail.com', '2017-08-10', N'');
INSERT INTO carrito.dbo.cliente (id,nombre,apellido,email,fechacreacion,foto) values
    (11,N'Bruce', N'Lee', N'bruce.lee@gmail.com', '2017-08-11', N''),
    (12,N'Johnny', N'Doe', N'johnny.doe@gmail.com', '2017-08-12', N''),
    (13,N'John', N'Roe', N'john.roe@gmail.com', '2017-08-13', N''),
    (14,N'Jane', N'Roe', N'jane.roe@gmail.com', '2017-08-14', N''),
    (15,N'Richard', N'Doe', N'richard.doe@gmail.com', '2017-08-15', N''),
    (16,N'Janie', N'Doe', N'janie.doe@gmail.com', '2017-08-16', N'');
INSERT INTO carrito.dbo.cliente (id,nombre,apellido,email,fechacreacion,foto) values
    (17,N'Phillip', N'Webb', N'phillip.webb@gmail.com', '2017-08-17', N''),
    (18,N'Stephane', N'Nicoll', N'stephane.nicoll@gmail.com', '2017-08-18', N''),
    (19,N'Sam', N'Brannen', N'sam.brannen@gmail.com', '2017-08-19', N''),
    (20,N'Juergen', N'Hoeller', N'juergen.Hoeller@gmail.com', '2017-08-20', N''),
    (21,N'Janie', N'Roe', N'janie.roe@gmail.com', '2017-08-21', N'');
INSERT INTO carrito.dbo.cliente (id,nombre,apellido,email,fechacreacion,foto) values
    (22,N'John', N'Smith', N'john.smith@gmail.com', '2017-08-22', N''),
    (23,N'Joe', N'Bloggs', N'joe.bloggs@gmail.com', '2017-08-23', N''),
    (24,N'John', N'Stiles', N'john.stiles@gmail.com', '2017-08-24', N''),
    (25,N'Richard', N'Roe', N'stiles.roe@gmail.com', '2017-08-25', N'');
SET IDENTITY_INSERT carrito.dbo.cliente OFF

GO

SET IDENTITY_INSERT carrito.dbo.producto ON
INSERT INTO carrito.dbo.producto(id, nombre, precio, fechacreacion) VALUES
           (1 ,N'Panasonic Pantalla LCD',259990,GETDATE()),
		   (2,N'Sony Camara digital DSC-W320B', 123490, GETDATE()),
		   (3,N'Apple iPod shuffle', 1499990, GETDATE()),
		   (4,N'Sony Notebook Z110', 37990, GETDATE()),
		   (5,N'Hewlett Packard Multifuncional F2280', 69990, GETDATE()),
           (6,'NBianchi Bicicleta Aro 26', 69990, GETDATE()),
		   (7,'Mica Comoda 5 Cajones', 299990, GETDATE());
SET IDENTITY_INSERT carrito.dbo.producto OFF
GO

SET IDENTITY_INSERT carrito.dbo.factura ON
INSERT  carrito.dbo.factura(id,descripcion,observacion, cliente_id ,fechacreacion) values
(1,N'Factura equipos de oficina', null, 1, GETDATE()),
(2,N'Factura Bicicleta', N'Alguna nota importante!', 1, GETDATE());
SET IDENTITY_INSERT carrito.dbo.factura OFF
GO

SET IDENTITY_INSERT carrito.dbo.itemfactura ON
insert into carrito.dbo.itemfactura(id,cantidad, idfactura,idproducto) VALUES(1,1, 1, 1),
(2,2, 1, 4),
(3,1, 1, 5),
(4,1, 1, 7),
(5,3, 2, 6);
SET IDENTITY_INSERT carrito.dbo.itemfactura OFF
GO
