CREATE DATABASE IF NOT EXISTS doctor_management;

USE doctor_management;

CREATE TABLE IF NOT EXISTS doctor (
	id INT NOT NULL AUTO_INCREMENT,
    doctor_code VARCHAR(20) UNIQUE NOT NULL,
    name NVARCHAR(50) NOT NULL,
    gender NVARCHAR(20),
    nationality NVARCHAR(50) NOT NULL,
    image_profile NVARCHAR(100),
    about TEXT,
    address NVARCHAR(100),
    phone NVARCHAR(20),
    education NVARCHAR(20) NOT NULL,
    roles NVARCHAR(100) NOT NULL,
	specialities NVARCHAR(100) NOT NULL,
    workplace NVARCHAR(100) NOT NULL,
    created_at DATE,
    updated_at DATE,
    end_at DATE,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS award (
	id int NOT NULL AUTO_INCREMENT,
    doctor_code VARCHAR(20) NOT NULL,
    year_at INT,
    name NVARCHAR(50),
    PRIMARY KEY (id),
    FOREIGN KEY (doctor_code) REFERENCES doctor(doctor_code)
);

CREATE TABLE IF NOT EXISTS experience (
	id INT NOT NULL AUTO_INCREMENT,
    doctor_code VARCHAR(20) NOT NULL,
    year_start INT,
    year_end INT,
    content NVARCHAR(1000) NOT NULL,
    in_country NVARCHAR(50),
    PRIMARY KEY (id),
    FOREIGN KEY (doctor_code) REFERENCES doctor(doctor_code)
);

INSERT INTO `doctor_management`.`doctor` (`id`, `doctor_code`, `name`, `gender`, `nationality`, `image_profile`, `about`, `address`, `phone`, `education`, `roles`, `specialities`, `workplace`) VALUES ('1', '51188', 'Philippe Macaire', 'Nam', 'Anh', 'https://vinmec-prod.s3.amazonaws.com/images/15_08_2019_03_13_38_444466.jpeg', 'Giáo sư Philippe Macaire đã có hơn 30 năm kinh nghiệm làm việc trong lĩnh vực gây mê và giảm đau tại Pháp, Dubai, Anh Quốc, Thái Lan và Việt Nam. Ông đóng góp tích cực xây dựng những tổ chức về gây mê và đặc biệt là gây tê vùng. Giáo sư Macaire cũng là diễn giả tại hơn 150 hội thảo, hội nghị thế giới và là tác giả của nhiều sách, bài viết về gây mê giảm đau.. Hiện tại đang là Trưởng khoa Gây mê giảm đau bệnh viện Đa khoa Quốc tế Vinmec Times City', 'xxx', '+84xxx', 'Giáo sư', 'Trưởng khoa Gây mê giảm đau.', 'Gây mê - điều trị đau', 'Khoa Gây mê giảm đau - Bệnh viện Đa khoa Quốc tế Vinmec Times City');
INSERT INTO `doctor_management`.`doctor` (`doctor_code`, `name`, `gender`, `nationality`, `image_profile`, `about`, `address`, `phone`, `education`, `roles`, `specialities`, `workplace`) VALUES ('50974', 'Yi Hyeon Gyu', 'Nam', 'Hàn Quốc', 'https://vinmec-prod.s3.amazonaws.com/images/08_10_2019_02_31_47_662505.jpeg', 'Phó Giáo sư, Tiến sĩ, Bác sĩ Yi Hyeon Gyu là giảng viên khoa Huyết học và Ung bướu - Trường Đại học Y Inha, miền Nam Hàn Quốc. Bác sĩ đã có nhiều năm kinh nghiệm trong lĩnh vực Huyết học, truyền Tế bào gốc tạo máu và điều trị Ung bướu. Hiện bác sĩ là Trưởng đơn nguyên Huyết học và Trị liệu tế bào, nguyên là Trưởng đơn nguyên Nội trú Ung bướu của Bệnh viện Đa khoa Quốc tế Vinmec Times City. ', 'xxx', '+84xxx', 'Phó Giáo Sư', 'Trưởng Đơn nguyên Huyết học và Trị liệu tế bào', 'Ung bướu-Xạ trị;Nhi Huyết học - Truyền máu;Huyết học', 'Trung tâm Y học tái tạo và trị liệu tế bào;Đơn nguyên Huyết học và Trị liệu tế bào');
INSERT INTO `doctor_management`.`doctor` (`doctor_code`, `name`, `gender`, `nationality`, `image_profile`, `about`, `address`, `phone`, `education`, `roles`, `specialities`, `workplace`) VALUES ('51173', 'Martina Pellegrino', 'Nữ', 'Mỹ', 'https://vinmec-prod.s3.amazonaws.com/images/05_10_2019_03_32_24_659800.jpeg', 'Bác sĩ Martina Pellegrino có kinh nghiệm 03 năm làm việc tại Khoa Sản Phụ - Bệnh viện Đại Học Geneva và Bệnh viện Sion – Thụy Sỹ; 03 năm kinh nghiệm làm việc tại Bệnh viện Đại học King – London – Anh Quốc. Sau đó bác sĩ có thời gian làm việc tại bệnh viện Từ Dũ, TP.HCM với 2500 ca chọc ối, 250 ca sinh thiết gai rau, 30 ca giảm ối/ truyền ối, 20 ca lấy máu thai nhi xét nghiệm/ truyền máu thai nhi)\n\nHiện đang là bác sĩ Y học bào thai tại Trung tâm Sức khỏe Phụ nữ - Bệnh viện Đa khoa Quốc tế Times City', 'xxx', '+84xxx', 'Bác sĩ', 'Bác sĩ Y học bào thai', 'Sản khoa', 'Khoa Y học Bào thai;Trung tâm Sức khỏe Phụ nữ - Bệnh viện Đa khoa Quốc tế Vinmec Times City');

INSERT INTO `doctor_management`.`award` (`id`, `doctor_code`, `year_at`, `name`) VALUES ('1', '50974', '2018', 'Travel award, ICBMT 2018');
INSERT INTO `doctor_management`.`award` (`doctor_code`, `year_at`, `name`) VALUES ('50974', '2019', 'Travel award, ASBMT 2019');

INSERT INTO `doctor_management`.`experience` (`id`, `doctor_code`, `year_start`, `year_end`, `content`) VALUES ('1', '50974', '2003 ', '2006', '2003 - 2006: Bác sĩ Nội trú, khoa Nội tổng hợp, Bệnh viện đại học Inha, Incheon, Hàn Quốc');
INSERT INTO `doctor_management`.`experience` (`doctor_code`, `year_start`, `year_end`, `content`) VALUES ('50974', '2007', '2008', '2007 - 2008: Giảng viên lâm sàng, đơn vị Huyết học và Ung bướu, khoa Nội tổng hợp, Bệnh viện đại học quốc gia Seoul, Hàn Quốc');
INSERT INTO `doctor_management`.`experience` (`doctor_code`, `content`, `in_country`) VALUES ('51188', 'Trưởng khoa Gây mê giảm đau bệnh viện Đa khoa Quốc tế Vinmec Times City', 'Hà Nội');
INSERT INTO `doctor_management`.`experience` (`doctor_code`, `content`, `in_country`) VALUES ('51188', 'Giáo sư Dự án Đại học Y VinUni – Khối Khoa học sức khỏe', 'Hà Nội');
INSERT INTO `doctor_management`.`experience` (`doctor_code`, `content`, `in_country`) VALUES ('51188', 'Cố vấn Gây mê và điều trị đau can thiệp tại Bệnh viện Chính phủ Rashid', 'Dubai');
INSERT INTO `doctor_management`.`experience` (`doctor_code`, `content`, `in_country`) VALUES ('51188', 'Giám đốc Chuyên môn, Trung tâm Cấp cứu và Khoa Ngoại Bệnh viện Dubai London', 'Dubai');
INSERT INTO `doctor_management`.`experience` (`doctor_code`, `content`, `in_country`) VALUES ('51188', 'Giám đốc Chuyên môn, Trung tâm Cấp cứu và Khoa Ngoại Tập đoàn chăm sóc sức khỏe Dubai Healthcare City Tatweer Group.', 'Dubai');
INSERT INTO `doctor_management`.`experience` (`doctor_code`, `content`, `in_country`) VALUES ('51188', 'Cố vấn cấp cao Khoa Gây mê tại Trung tâm chăm sóc y tế Care UK Afrox Healthcare Ltd.', 'Anh');
INSERT INTO `doctor_management`.`experience` (`doctor_code`, `content`, `in_country`) VALUES ('51188', 'Bác sĩ Gây mê, cố vấn cấp cao tại Trung tâm Clinical Angouleme - Trung tâm kỹ thuật cao về Gây tê giảm đau vùng và Chăm sóc giảm nhẹ', 'Pháp');
INSERT INTO `doctor_management`.`experience` (`doctor_code`, `content`, `in_country`) VALUES ('51188', 'Bác sĩ Gây Mê trong nhóm Phẫu thuật Chấn thương Chỉnh hình và điều trị đau mãn tính của Bệnh viện Hospital du Parc1; Trung Tâm Kỹ Thuật Cao về Gây tê giảm đau vùng và Chăm sóc giảm nhẹ, Bệnh viện Đại học Lyon', 'Pháp');
INSERT INTO `doctor_management`.`experience` (`doctor_code`, `content`, `in_country`) VALUES ('51188', 'Bác sĩ Gây mê tại Phòng khám Polyclinic Jean-Villar2 kiêm Trưởng phòng quản lý thông tin Y tế', 'Pháp');
INSERT INTO `doctor_management`.`experience` (`doctor_code`, `content`, `in_country`) VALUES ('51188', 'Cố vấn sản khoa với các trường hợp nguy cơ rủi ro cao, cộng sự của Giáo sư. JM GONNET', 'Pháp');
INSERT INTO `doctor_management`.`experience` (`doctor_code`, `content`, `in_country`) VALUES ('51188', 'Bác sĩ Gây mê Hồi sức Tim mạch của nhóm Giáo sư. Charles Dubost, Gs. Alain Carpentier và Alain Deloche tại Bệnh viện Đại học Nantes.', 'Pháp');
INSERT INTO `doctor_management`.`experience` (`doctor_code`, `content`, `in_country`) VALUES ('51188', 'Thành viên chuyên viên y tế nhà nước cơ động, phục vụ lính cứu hỏa tại Paris - Bác sĩ cơ động cho các Công ty bảo hiểm tại Pháp', 'Pháp');
INSERT INTO `doctor_management`.`experience` (`doctor_code`, `year_start`, `year_end`, `content`) VALUES ('50974', '2002', '2003', '2002 - 2003: Thực tập tại bệnh viện đại học Inha, Incheon, Hàn Quốc');
INSERT INTO `doctor_management`.`experience` (`doctor_code`, `year_start`, `year_end`, `content`) VALUES ('50974', '2008', '2011', '2008 - 2011: Giảng viên toàn thời gian, đơn vị Huyết học và Ung bướu, khoa Nội tổng hợp, Đại học Y Inha, Incheon, Hàn Quốc');
INSERT INTO `doctor_management`.`experience` (`doctor_code`, `year_start`, `year_end`, `content`) VALUES ('50974', '2011 ', '2014', '2011 - 2014: Phó giáo sư, đơn vị Huyết học và Ung bướu, khoa Nội tổng hợp, Đại học Y Inha, Incheon, Hàn Quốc');
INSERT INTO `doctor_management`.`experience` (`doctor_code`, `year_start`, `year_end`, `content`) VALUES ('50974', '2014', '2017', '2014 - 2017: Phó giáo sư, đơn vị Huyết học và Ung bướu, khoa Nội tổng hợp, Đại học Y Inha, Incheon, Hàn Quốc');
INSERT INTO `doctor_management`.`experience` (`doctor_code`, `year_start`, `year_end`, `content`) VALUES ('50974', '2017', '2019', '2017 - 2019: Khoa Nội Ung bướu, bệnh viện Đa khoa Quốc tế Vinmec Times City');
INSERT INTO `doctor_management`.`experience` (`doctor_code`, `year_start`, `content`) VALUES ('50974', '2019', '2019 - Đến nay: Trưởng đơn nguyên Huyết học và trị liệu tế bào, bệnh viện Đa khoa Quốc tế Vinmec Times City');
INSERT INTO `doctor_management`.`experience` (`doctor_code`, `content`) VALUES ('51173', 'Kinh nghiệm 3 năm làm việc tại Khoa Sản Phụ - Bệnh viện Đại Học Geneva và Bệnh viện Sion – Thụy Sỹ');
INSERT INTO `doctor_management`.`experience` (`doctor_code`, `content`) VALUES ('51173', '3 năm kinh nghiệm làm việc tại Bệnh viện Đại học King – London – Anh Quốc. Được đào tạo về Y học Bào thai và siêu âm chẩn đoán trước sinh (bao gồm siêu âm bất thường  tim thai), kỹ thuật sàng lọc và can thiệp trước sinh (Sinh thiết gai rau, chọc ối, lấy máu thai nhi xét nghiệm), can thiệp trước sinh (truyền máu thai nhi, phẫu thuật laser đốt mạch máu nối thông hai thai, đặt shunt dẫn lưu, đặt bóng nội khí quản thai nhi)');
INSERT INTO `doctor_management`.`experience` (`doctor_code`, `content`) VALUES ('51173', '1 năm kinh nghiệm làm việc tại Bệnh viện Từ Dũ – TP HCM, với 2500 ca chọc ối, 250 ca sinh thiết gai rau, 30 ca giảm ối/ truyền ối, 20 ca lấy máu thai nhi xét nghiệm/ truyền máu thai nhi)');
