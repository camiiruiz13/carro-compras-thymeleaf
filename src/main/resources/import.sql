USE [carrito]
GO
SET IDENTITY_INSERT [dbo].[cliente] ON

INSERT [dbo].[cliente] ([id], [apellido], [email], [fechacreacion], [foto], [nombre]) VALUES (1, N'Guzman', N'profesor@bolsadeideas.com', CAST(N'2017-08-01' AS Date), N'', N'Andres')
INSERT [dbo].[cliente] ([id], [apellido], [email], [fechacreacion], [foto], [nombre]) VALUES (2, N'Doe', N'john.doe@gmail.com', CAST(N'2017-08-02' AS Date), N'', N'John')
INSERT [dbo].[cliente] ([id], [apellido], [email], [fechacreacion], [foto], [nombre]) VALUES (3, N'Torvalds', N'linus.torvalds@gmail.com', CAST(N'2017-08-03' AS Date), N'', N'Linus')
INSERT [dbo].[cliente] ([id], [apellido], [email], [fechacreacion], [foto], [nombre]) VALUES (4, N'Doe', N'jane.doe@gmail.com', CAST(N'2017-08-04' AS Date), N'', N'Jane')
INSERT [dbo].[cliente] ([id], [apellido], [email], [fechacreacion], [foto], [nombre]) VALUES (5, N'Lerdorf', N'rasmus.lerdorf@gmail.com', CAST(N'2017-08-05' AS Date), N'', N'Rasmus')
INSERT [dbo].[cliente] ([id], [apellido], [email], [fechacreacion], [foto], [nombre]) VALUES (6, N'Gamma', N'erich.gamma@gmail.com', CAST(N'2017-08-06' AS Date), N'', N'Erich')
INSERT [dbo].[cliente] ([id], [apellido], [email], [fechacreacion], [foto], [nombre]) VALUES (7, N'Helm', N'richard.helm@gmail.com', CAST(N'2017-08-07' AS Date), N'', N'Richard')
INSERT [dbo].[cliente] ([id], [apellido], [email], [fechacreacion], [foto], [nombre]) VALUES (8, N'Johnson', N'ralph.johnson@gmail.com', CAST(N'2017-08-08' AS Date), N'', N'Ralph')
INSERT [dbo].[cliente] ([id], [apellido], [email], [fechacreacion], [foto], [nombre]) VALUES (9, N'Vlissides', N'john.vlissides@gmail.com', CAST(N'2017-08-09' AS Date), N'', N'John')
INSERT [dbo].[cliente] ([id], [apellido], [email], [fechacreacion], [foto], [nombre]) VALUES (10, N'Gosling', N'james.gosling@gmail.com', CAST(N'2017-08-10' AS Date), N'', N'James')
INSERT [dbo].[cliente] ([id], [apellido], [email], [fechacreacion], [foto], [nombre]) VALUES (11, N'Lee', N'bruce.lee@gmail.com', CAST(N'2017-08-11' AS Date), N'', N'Bruce')
INSERT [dbo].[cliente] ([id], [apellido], [email], [fechacreacion], [foto], [nombre]) VALUES (12, N'Doe', N'johnny.doe@gmail.com', CAST(N'2017-08-12' AS Date), N'', N'Johnny')
INSERT [dbo].[cliente] ([id], [apellido], [email], [fechacreacion], [foto], [nombre]) VALUES (13, N'Roe', N'john.roe@gmail.com', CAST(N'2017-08-13' AS Date), N'', N'John')
INSERT [dbo].[cliente] ([id], [apellido], [email], [fechacreacion], [foto], [nombre]) VALUES (14, N'Roe', N'jane.roe@gmail.com', CAST(N'2017-08-14' AS Date), N'', N'Jane')
INSERT [dbo].[cliente] ([id], [apellido], [email], [fechacreacion], [foto], [nombre]) VALUES (15, N'Doe', N'richard.doe@gmail.com', CAST(N'2017-08-15' AS Date), N'', N'Richard')
INSERT [dbo].[cliente] ([id], [apellido], [email], [fechacreacion], [foto], [nombre]) VALUES (16, N'Doe', N'janie.doe@gmail.com', CAST(N'2017-08-16' AS Date), N'', N'Janie')
INSERT [dbo].[cliente] ([id], [apellido], [email], [fechacreacion], [foto], [nombre]) VALUES (17, N'Webb', N'phillip.webb@gmail.com', CAST(N'2017-08-17' AS Date), N'', N'Phillip')
INSERT [dbo].[cliente] ([id], [apellido], [email], [fechacreacion], [foto], [nombre]) VALUES (18, N'Nicoll', N'stephane.nicoll@gmail.com', CAST(N'2017-08-18' AS Date), N'', N'Stephane')
INSERT [dbo].[cliente] ([id], [apellido], [email], [fechacreacion], [foto], [nombre]) VALUES (19, N'Brannen', N'sam.brannen@gmail.com', CAST(N'2017-08-19' AS Date), N'', N'Sam')
INSERT [dbo].[cliente] ([id], [apellido], [email], [fechacreacion], [foto], [nombre]) VALUES (20, N'Hoeller', N'juergen.Hoeller@gmail.com', CAST(N'2017-08-20' AS Date), N'', N'Juergen')
INSERT [dbo].[cliente] ([id], [apellido], [email], [fechacreacion], [foto], [nombre]) VALUES (21, N'Roe', N'janie.roe@gmail.com', CAST(N'2017-08-21' AS Date), N'', N'Janie')
INSERT [dbo].[cliente] ([id], [apellido], [email], [fechacreacion], [foto], [nombre]) VALUES (22, N'Smith', N'john.smith@gmail.com', CAST(N'2017-08-22' AS Date), N'', N'John')
INSERT [dbo].[cliente] ([id], [apellido], [email], [fechacreacion], [foto], [nombre]) VALUES (23, N'Bloggs', N'joe.bloggs@gmail.com', CAST(N'2017-08-23' AS Date), N'', N'Joe')
INSERT [dbo].[cliente] ([id], [apellido], [email], [fechacreacion], [foto], [nombre]) VALUES (24, N'Stiles', N'john.stiles@gmail.com', CAST(N'2017-08-24' AS Date), N'', N'John')
INSERT [dbo].[cliente] ([id], [apellido], [email], [fechacreacion], [foto], [nombre]) VALUES (25, N'Roe', N'stiles.roe@gmail.com', CAST(N'2017-08-25' AS Date), N'', N'Richard')
SET IDENTITY_INSERT [dbo].[cliente] OFF
GO
SET IDENTITY_INSERT [dbo].[factura] ON

INSERT [dbo].[factura] ([id], [descripcion], [fechacreacion], [observacion], [idcliente]) VALUES (1, N'Factura equipos de oficina', CAST(N'2023-08-26' AS Date), NULL, 1)
INSERT [dbo].[factura] ([id], [descripcion], [fechacreacion], [observacion], [idcliente]) VALUES (2, N'Factura Bicicleta', CAST(N'2023-08-26' AS Date), N'Alguna nota importante!', 1)
SET IDENTITY_INSERT [dbo].[factura] OFF
GO
SET IDENTITY_INSERT [dbo].[producto] ON

INSERT [dbo].[producto] ([id], [fechacreacion], [nombre], [precio]) VALUES (1, CAST(N'2023-08-26' AS Date), N'Panasonic Pantalla LCD', 259990)
INSERT [dbo].[producto] ([id], [fechacreacion], [nombre], [precio]) VALUES (2, CAST(N'2023-08-26' AS Date), N'Sony Camara digital DSC-W320B', 123490)
INSERT [dbo].[producto] ([id], [fechacreacion], [nombre], [precio]) VALUES (3, CAST(N'2023-08-26' AS Date), N'Apple iPod shuffle', 1499990)
INSERT [dbo].[producto] ([id], [fechacreacion], [nombre], [precio]) VALUES (4, CAST(N'2023-08-26' AS Date), N'Sony Notebook Z110', 37990)
INSERT [dbo].[producto] ([id], [fechacreacion], [nombre], [precio]) VALUES (5, CAST(N'2023-08-26' AS Date), N'Hewlett Packard Multifuncional F2280', 69990)
INSERT [dbo].[producto] ([id], [fechacreacion], [nombre], [precio]) VALUES (6, CAST(N'2023-08-26' AS Date), N'NBianchi Bicicleta Aro 26', 69990)
INSERT [dbo].[producto] ([id], [fechacreacion], [nombre], [precio]) VALUES (7, CAST(N'2023-08-26' AS Date), N'Mica Comoda 5 Cajones', 299990)
SET IDENTITY_INSERT [dbo].[producto] OFF
GO
SET IDENTITY_INSERT [dbo].[itemfactura] ON

INSERT [dbo].[itemfactura] ([id], [cantidad], [idproducto], [idfactura]) VALUES (1, 1, 1, 1)
INSERT [dbo].[itemfactura] ([id], [cantidad], [idproducto], [idfactura]) VALUES (2, 2, 4, 1)
INSERT [dbo].[itemfactura] ([id], [cantidad], [idproducto], [idfactura]) VALUES (3, 1, 5, 1)
INSERT [dbo].[itemfactura] ([id], [cantidad], [idproducto], [idfactura]) VALUES (4, 1, 7, 1)
INSERT [dbo].[itemfactura] ([id], [cantidad], [idproducto], [idfactura]) VALUES (5, 3, 6, 2)
SET IDENTITY_INSERT [dbo].[itemfactura] OFF
GO
SET IDENTITY_INSERT [dbo].[usuario] ON

INSERT [dbo].[usuario] ([id], [usuario], [clave], [activo]) VALUES (1, N'andres', N'$2a$10$DwUREzMZSASK2vE8IR.05OunfODEqXw6f0bx6fTWx3Z4iJOx6cHa2', 1)
INSERT [dbo].[usuario] ([id], [usuario], [clave], [activo]) VALUES (2, N'admin', N'$2a$10$YMQBVYvbwF9RYS961T7ykOhrytMuEAZKffSN1cHFCwiju9nR.tgdi', 1)
SET IDENTITY_INSERT [dbo].[usuario] OFF
GO
SET IDENTITY_INSERT [dbo].[autorizaciones] ON

INSERT [dbo].[autorizaciones] ([id], [idusuario], [autorizado]) VALUES (1, 1, N'ROLE_USER')
INSERT [dbo].[autorizaciones] ([id], [idusuario], [autorizado]) VALUES (2, 2, N'ROLE_ADMIN')
INSERT [dbo].[autorizaciones] ([id], [idusuario], [autorizado]) VALUES (3, 2, N'ROLE_USER')
SET IDENTITY_INSERT [dbo].[autorizaciones] OFF
GO
