CREATE TABLE pessoa (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(200) NOT NULL,
    ativo BOOLEAN NOT NULL,
    logradouro VARCHAR(250),
    numero VARCHAR(15),
    complemento VARCHAR(30),
    bairro VARCHAR(150),
    cep VARCHAR(10),
    cidade VARCHAR(100),
    estado VARCHAR(2)
)ENGINE=innoDB DEFAULT CHARSET=utf8;

INSERT INTO pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) values ('Reginaldo Lauri', true, "Rua Nove de Julho", 597, "Sobreloja", "Centro", "1332005", "Salto", "SP");
INSERT INTO pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) values ('Ayako Kubo', true, "Rua Bento Maciel Parente", 454, null, "Santa Marta III", "1332480", "Salto", "SP");
INSERT INTO pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) values ('Rodolfo Lauri', true, "Rua Evangelista Pinto", 321, "Do lado do bar", "Potiguara", "1330028", "Itu", "SP");
INSERT INTO pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) values ('Roberto Carlos', true, "Rua Bento Castro", 300, null, "Jd. Paulista", "1332005", "Salto", "SP");
INSERT INTO pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) values ('Cristiane Cristina', true, "Av. dos Anjos", 450, null, "Vila Romana", "1212015", "Salto", "SP");
INSERT INTO pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) values ('Izaac Newton', true, "Pc. Castro Alvez", 250, null, "Centro", "1213010", "São Paulo", "SP");
INSERT INTO pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) values ('Fátima Farias', true, "Av. Portugal", 227, "", "Vila Roma", "1222335", "Itu", "SP");
INSERT INTO pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) values ('Angeli Souza', true, "Rua inventada", 864, null, "Pc. da Árvore", "236549875", "São Paulo", "SP");
INSERT INTO pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) values ('Tiago Strume', true, "Rua Piranjuba", 1520, null, "Centro", "1001010", "Ibiuna", "SP");
INSERT INTO pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) values ('Juarez 3Rocks', true, "Rua Sei lá", 152, null, "Cond. Ilha das Águas", "1332105", "Salto", "SP");