CREATE DATABASE java4
use java4 

CREATE TABLE san_pham (
        id INT IDENTITY(1,1) PRIMARY KEY,
        ma_san_pham VARCHAR(255) ,
        ten_san_pham VARCHAR(255) ,
        trang_thai VARCHAR(50), -- or INT, depending on how you represent status
        ngay_tao DATETIME ,
        ngay_sua DATETIME
        );
        CREATE TABLE mau_sac (
        id INT IDENTITY(1,1) PRIMARY KEY,
        ma_mau VARCHAR(255),
        ten_mau VARCHAR(255),
        trang_thai VARCHAR(50), -- or INT, based on your status representation
        ngay_sua DATETIME,
        ngay_tao DATETIME
        );
        CREATE TABLE size (
        id INT IDENTITY(1,1) PRIMARY KEY,
        ma_size VARCHAR(255),
        ten_size VARCHAR(255),
        trang_thai VARCHAR(50), -- or INT, based on your status representation
        ngay_sua DATETIME,
        ngay_tao DATETIME
        );
        CREATE TABLE danh_muc (
        id INT IDENTITY(1,1) PRIMARY KEY,
        ma_danh_muc VARCHAR(255),
        ten_danh_muc VARCHAR(255),
        trang_thai VARCHAR(50), -- Adjust based on how you plan to represent the status
        ngay_tao DATETIME,
        ngay_sua DATETIME
        );
        CREATE TABLE khach_hang (
        id INT IDENTITY(1,1) PRIMARY KEY,
        ho_ten NVARCHAR(255),
        dia_chi NVARCHAR(255),
        sdt VARCHAR(20),
        trang_thai VARCHAR(50), -- Adjust based on how you plan to represent the status
        ngay_tao DATETIME,
        ngay_sua DATETIME
        );
        CREATE TABLE ctsp (
        id INT IDENTITY(1,1) PRIMARY KEY,
        id_sp INT NULL,
        id_mau_sac INT NULL,
        id_size INT NULL,
        gia_ban DECIMAL(18, 2),
        so_luong_ton INT,
        trang_thai VARCHAR(50), -- Adjust based on your representation of status
        ngay_tao DATETIME,
        ngay_sua DATETIME,
        CONSTRAINT fk_sp FOREIGN KEY (id_sp) REFERENCES san_pham(id) ON UPDATE CASCADE ON DELETE CASCADE,
        CONSTRAINT fk_mau_sac FOREIGN KEY (id_mau_sac) REFERENCES mau_sac(id) ON UPDATE CASCADE ON DELETE CASCADE,
        CONSTRAINT fk_size FOREIGN KEY (id_size) REFERENCES size(id) ON UPDATE CASCADE ON DELETE CASCADE,
        );
        CREATE TABLE hoa_don (
        id INT IDENTITY(1,1) PRIMARY KEY,
        id_khach_hang INT NULL,
        trang_thai VARCHAR(50), -- Adjust based on how you represent the status
        ngay_tao DATETIME,
        ngay_sua DATETIME,
        dia_chi NVARCHAR(255),
        so_dien_thoai VARCHAR(20),
        CONSTRAINT fk_khach_hang FOREIGN KEY (id_khach_hang) REFERENCES khach_hang(id) ON UPDATE CASCADE ON DELETE CASCADE,
        );

        CREATE TABLE hdct (
        id INT IDENTITY(1,1) PRIMARY KEY,
        id_hoa_don INT NULL,
        id_ctsp INT NULL,
        so_luong_mua INT,
        gia_ban DECIMAL(18, 2),
        tong_tien DECIMAL(18, 2),
        trang_thai VARCHAR(50), -- Adjust based on how you represent the status
        ngay_tao DATETIME,
        ngay_sua DATETIME,
        CONSTRAINT fk_hoa_don FOREIGN KEY (id_hoa_don) REFERENCES hoa_don(id) ON UPDATE CASCADE ON DELETE CASCADE,
        CONSTRAINT fk_ctsp FOREIGN KEY (id_ctsp) REFERENCES ctsp(id) ON UPDATE CASCADE ON DELETE CASCADE,
        );
        ALTER TABLE san_pham
        ADD id_danh_muc INT NULL;

        ALTER TABLE san_pham
        ADD CONSTRAINT fk_san_pham_danh_muc
        FOREIGN KEY (id_danh_muc) REFERENCES danh_muc(id) ON UPDATE CASCADE ON DELETE CASCADE;



INSERT INTO danh_muc (ma_danh_muc, ten_danh_muc, trang_thai, ngay_tao, ngay_sua) 
VALUES 
('S001', 'Category 1', 'Active', '2024-03-22 08:00:00', '2024-03-22 08:00:00'),
('S002', 'Category 2', 'Inactive', '2024-03-21 09:30:00', '2024-03-21 09:30:00'),
('S003', 'Category 3', 'Active', '2024-03-20 10:45:00', '2024-03-20 10:45:00'),
('S004', 'Category 4', 'Active', '2024-03-19 11:20:00', '2024-03-19 11:20:00'),
('S005', 'Category 5', 'Inactive', '2024-03-18 12:15:00', '2024-03-18 12:15:00'),
('S006', 'Category 6', 'Active', '2024-03-17 13:00:00', '2024-03-17 13:00:00'),
('S007', 'Category 7', 'Active', '2024-03-16 14:30:00', '2024-03-16 14:30:00'),
('S008', 'Category 8', 'Inactive', '2024-03-15 15:45:00', '2024-03-15 15:45:00'),
('S009', 'Category 9', 'Active', '2024-03-14 16:10:00', '2024-03-14 16:10:00'),
('S010', 'Category 10', 'Active', '2024-03-13 17:20:00', '2024-03-13 17:20:00');
SELECT * FROM danh_muc

insert into size(ma_size, ten_size, trang_thai,ngay_tao, ngay_sua)
			values('SZ01','S','Active','2024-03-22 08:00:00', '2024-03-22 08:00:00'),
			('SZ02','M','Inactive','2024-03-21 09:30:00', '2024-03-21 09:30:00'),
			('SZ03','L','Active','2024-03-22 08:00:00', '2024-03-22 08:00:00'),
			('SZ04','XL','Inactive','2024-03-20 10:45:00', '2024-03-20 10:45:00'),
			('SZ05','XXL','Inactive','2024-03-20 10:45:00', '2024-03-20 10:45:00')
select * from size

insert into mau_sac(ma_mau,ten_mau,ngay_tao,ngay_sua,trang_thai)
			values('MS01','Do', GETDATE(),GETDATE()+3,'Active'),
			('MS02','Xanh', GETDATE(),GETDATE()+3,'Active'),
			('MS03','Vang', GETDATE(),GETDATE()+3,'Inactive'),
			('MS04','Tim', GETDATE(),GETDATE()+3,'Active'),
			('MS05','Den', GETDATE(),GETDATE()+3,'Inactive')
select * from mau_sac
insert into khach_hang(ho_ten,dia_chi,sdt,trang_thai,ngay_tao,ngay_sua)
			values('Nguyen Xuan Hoang', 'Thanh Xuan','0334921271','Active', GETDATE(),GETDATE()+3),
			('Nguyen Manh Tuan', 'Hoang Mai','0333631271','Active', GETDATE(),GETDATE()+3),
			('Pham Duc Duy', 'Cau Giay','0334853271','Inactive', GETDATE(),GETDATE()+3),
			('Le Phuong Anh', 'Ba Dinh','0462421271','Active', GETDATE(),GETDATE()+3),
			('Nguyen Bao Anh', 'Hoan Kiem','0334537271','Inactive', GETDATE(),GETDATE()+3)
select * from khach_hang

INSERT INTO san_pham (ma_san_pham, ten_san_pham, trang_thai, ngay_tao, ngay_sua, id_danh_muc)
VALUES
('Prod001', 'Product 1', 'Active', '2024-01-01', '2024-01-02', 1),
('Prod002', 'Product 2', 'Inactive', '2024-01-03', '2024-01-04', 2),
('Prod003', 'Product 3', 'Active', '2024-01-05', '2024-01-06', 3),
('Prod004', 'Product 4', 'Active', '2024-01-07', '2024-01-08', 1),
('Prod005', 'Product 5', 'Inactive', '2024-01-09', '2024-01-10', 2),
('Prod006', 'Product 6', 'Active', '2024-01-11', '2024-01-12', 3),
('Prod007', 'Product 7', 'Inactive', '2024-01-13', '2024-01-14', 1),
('Prod008', 'Product 8', 'Active', '2024-01-15', '2024-01-16', 2),
('Prod009', 'Product 9', 'Active', '2024-01-17', '2024-01-18', 3),
('Prod010', 'Product 10', 'Inactive', '2024-01-19', '2024-01-20', 1);
select * from san_pham

INSERT INTO ctsp (id_sp, id_mau_sac, id_size, gia_ban, so_luong_ton, trang_thai, ngay_tao, ngay_sua)
VALUES 
    (1, 1, 1, 100.00, 50, 'Active', GETDATE(), GETDATE() +3),
    (2, 2, 2, 150.00, 20, 'Inactive', GETDATE(), GETDATE() +3),
    (3, 3, 3, 200.00, 10, 'Active', GETDATE(), GETDATE() +3),
    (4, 4, 4, 120.00, 30, 'Active', GETDATE(), GETDATE() +3),
    (5, 5, 5, 180.00, 15, 'Inactive', GETDATE(), GETDATE() +3),
	(6, 1, 1, 100.00, 50, 'Active', GETDATE(), GETDATE() +3),
    (7, 2, 2, 150.00, 20, 'Inactive', GETDATE(), GETDATE() +3),
    (8, 3, 3, 200.00, 10, 'Active', GETDATE(), GETDATE() +3),
    (9, 4, 4, 120.00, 30, 'Active', GETDATE(), GETDATE() +3),
    (10,5, 5, 180.00, 15, 'Inactive', GETDATE(), GETDATE() +3);
select * from ctsp
select * from hoa_don
select * from hdct

