CREATE TABLE KHOHANG(
	ID int IDENTITY(1,1) PRIMARY KEY,
	TENHANGHOA nvarchar(300),
	CHUSOHUU nvarchar(50),
	NGAYNHAPKHO DATETIME,
	NGUOINHAP nvarchar(50),
	DAXUAT bit NOT NULL DEFAULT (0), 
)

INSERT INTO KHOHANG (TENHANGHOA, CHUSOHUU, NGAYNHAPKHO, NGUOINHAP, DAXUAT )
VALUES ('Iphone', 'FPT', GETDATE(), N'Nguyễn Văn A',0),
(N'Máy giặt', 'LG', GETDATE(), N'Nguyễn Văn A',0),
(N'Máy tính', 'FPT', GETDATE(), N'Nguyễn Văn A',0),
('Tivi', 'Samsung', GETDATE(), N'Nguyễn Văn A',0),
('Loa', N'Điện máy xanh', GETDATE(), N'Nguyễn Văn A',0),
(N'Giày dép', 'Nike', GETDATE(), N'Nguyễn Văn A',0),
(N'Túi', 'Gucci', GETDATE(), N'Nguyễn Văn A',0)