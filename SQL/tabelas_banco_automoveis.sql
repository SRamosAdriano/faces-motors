CREATE TABLE automovel (
	id bigint(20) NOT NULL AUTO_INCREMENT,
	anoFabricacao int(11) DEFAULT NULL,
	anoModelo int(11) DEFAULT NULL,
	marca varchar(255) DEFAULT NULL,
	modelo varchar(255) DEFAULT NULL,
	observacoes varchar(255) DEFAULT NULL,
	PRIMARY KEY (id)
);
