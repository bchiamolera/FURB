INSERT INTO acessorio
VALUES (1, "Aerofolio"),
		 (2, "Volante esporte"),
		 (3, "Farol LED"),
		 (4, "Central multimidia"),
		 (5, "Filtro de ar"),
		 (6, "Capa de freio"),
		 (7, "Calha de chuva"),
		 (8, "Alarme"),
		 (9, "Suporte para bike"),
		 (10, "Body kit");

INSERT INTO combustivel
VALUES (1, "Gasolina"),
		 (2, "Diesel"),
		 (3, "Elétrico"),
		 (4, "Etanol"),
		 (5, "GNV");

INSERT INTO localidade
VALUES (1, "Blumenau"),
		 (2, "Taió"),
		 (3, "São Paulo"),
		 (4, "Rio de Janeiro"),
		 (5, "Brasília"),
		 (6, "Florianópolis"),
		 (7, "Jaraguá do Sul"),
		 (8, "Curitiba"),
		 (9, "Porto Alegre"),
		 (10, "Rio do Sul");

INSERT INTO proprietario
VALUES (1, 1, "Bernardo Chiamolera", "R. Heinrich Hosang", "N.605, Apt.608", "Victor Konder", "+55047988189030", "bernardo.ch.be@gmail.com", 'SC'),
		 (2, 2, "João Paulo", "R. Coronel Feddersen", "N. 1050", "Centro", "+55047993350487", "jp@outlook.com", 'SC'),
		 (3, 3, "Maria Rosa", "R. Thomaz Gonzaga", "N. 61", "Liberdade", "+55011912345678", "rosamaria@yahoo.com", 'SP'),
		 (4, 4, "Geraldo Grande", "Av. Atlântica", "N. 2302", "Copacabana", "+55021987654321", "geraldao@gmail.com", 'RJ'),
		 (5, 5, "Renata Ingrata", "Guará I", "QE 7", "Guará", "+55061921344634", "renata@ingrata.com.br", 'DF'),
		 (6, 6, "Jorge Silva", "R. Francisco Tolentino", "N. 307", "Centro", "+55048912334245", "jorginhosilva@outlook.com", 'SC'),
		 (7, 7, "Débora Seco", "R. João Januaio Ayoroso", "N. 469", "Jaraguá Esquerdo", "+55047954232562", "seco@debora.com", 'SC'),
		 (8, 8, "Monica Souza", "Av. Silva Jardim", "N. 465", "Rebouças", "+55041976684532", "monica@monica.com.br", 'PR'),
		 (9, 9, "Roberto Carlos", "Av. Alcídes Maia", "N. 519", "Sarandi", "+55051997845043", "roberto@congelado.com.br", 'RS'),
		 (10, 10, "Nicole de Jesus", "R. São João", "N. 180", "Centro", "+55047992342534", "nicjesus@gmail.com", 'SC');

INSERT INTO marca
VALUES (1, "Toyota"),
		 (2, "Fiat"),
		 (3, "Volkswagen"),
		 (4, "Ferrari"),
		 (5, "Tesla"),
		 (6, "BYD"),
		 (7, "Kia"),
		 (8, "Mercedes-benz"),
		 (9, "BMW"),
		 (10, "Porsche");

INSERT INTO modelo
VALUES (1, 1, "AE86"),
		 (2, 2, "Strada"),
		 (3, 3, "Fusca"),
		 (4, 4, "458 Spider"),
		 (5, 5, "Model S"),
		 (6, 6, "Seal"),
		 (7, 7, "Sorento"),
		 (8, 8, "300SL"),
		 (9, 9, "X5"),
		 (10, 10, "911 GT3 RS");
		 
INSERT INTO cor
VALUES (1, "Preto"),
		 (2, "Vermelho"),
		 (3, "Azul"),
		 (4, "Branco"),
		 (5, "Prata"),
		 (6, "Verde"),
		 (7, "Amarelo"),
		 (8, "Rosa"),
		 (9, "Cinza"),
		 (10, "Marrom");

INSERT INTO veiculo
VALUES ('BRA2E19', 1, 1, 1, 1983, 1983, 150, 2, "Usado"),
		 ('CUS3T45', 2, 2, 2, 2011, 2010, 423, 2, "Usado"),
		 ('ABC1D23', 3, 3, 3, 1950, 2006, 650, 6, "Usado"),
		 ('FEI6A90', 4, 4, 4, 2012, 2013, 25, 2, "Semi-novo"),
		 ('XYZ9W87', 5, 5, 5, 2022, 2023, 0, 4, "Novo"),
		 ('GFD2X34', 6, 6, 6, 2023, 2023, 0, 4, "Novo"),
		 ('HEY2K23', 7, 7, 7, 2010, 2012, 55, 4, "Semi-novo"),
		 ('LOL1S40', 8, 8, 8, 1954, 1958, 32, 2, "Semi-novo"),
		 ('MAN4F34', 9, 9, 9, 1999, 2023, 0, 4, "Novo"),
		 ('ASD4G59', 10, 10, 10, 2022, 2023, 0, 2, "Novo");

INSERT INTO veiculo_acessorio
VALUES ('BRA2E19', 1),
		 ('CUS3T45', 2),
		 ('ABC1D23', 3),
		 ('FEI6A90', 4),
		 ('XYZ9W87', 5),
		 ('GFD2X34', 6),
		 ('HEY2K23', 7),
		 ('LOL1S40', 8),
		 ('MAN4F34', 9),
		 ('ASD4G59', 10);

INSERT INTO veiculo_combustivel
VALUES (1, 'BRA2E19'),
		 (1, 'CUS3T45'),
		 (1, 'ABC1D23'),
		 (1, 'FEI6A90'),
		 (2, 'FEI6A90'),
		 (3, 'XYZ9W87'),
		 (3, 'GFD2X34'),
		 (1, 'HEY2K23'),
		 (2, 'HEY2K23'),
		 (4, 'HEY2K23'),
		 (5, 'LOL1S40'),
		 (1, 'MAN4F34'),
		 (1, 'ASD4G59');