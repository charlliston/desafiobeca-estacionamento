INSERT INTO TB_VEICUlO(id_Veiculo, placa) VALUES(null, 'QNI9824');
INSERT INTO TB_VEICUlO(id_Veiculo, placa) VALUES(null, 'IMP2412');
INSERT INTO TB_VEICUlO(id_Veiculo, placa) VALUES(null, 'TUQ9021');
INSERT INTO TB_VEICUlO(id_Veiculo, placa) VALUES(null, 'PYU1021');
INSERT INTO TB_VEICUlO(id_Veiculo, placa) VALUES(null, 'ONX1590');



INSERT INTO TB_CLIENTE(id_Cliente, nome, telefone, email) VALUES(null, 'Jose', '48988089999', 'jose@email.com');
INSERT INTO TB_CLIENTE(id_Cliente, nome, telefone, email) VALUES(null, 'Bruno', '48988080000', 'bruno@email.com');
INSERT INTO TB_CLIENTE(id_Cliente, nome, telefone, email) VALUES(null, 'Joao', '48988081111', 'joao@email.com');
INSERT INTO TB_CLIENTE(id_Cliente, nome, telefone, email) VALUES(null, 'Ana', '48988082222', 'ana@email.com');
INSERT INTO TB_CLIENTE(id_Cliente, nome, telefone, email) VALUES(null, 'Sandra', '48988087777', 'sandra@email.com');



INSERT INTO TB_FUNCIONARIO(id_Funcionario, nome, cargo) VALUES(null, 'Charlliston', 'Gerente');
INSERT INTO TB_FUNCIONARIO(id_Funcionario, nome, cargo) VALUES(null, 'Sergio', 'Caixa');



INSERT INTO TB_TICKET(id_Ticket, hora_Entrada, hora_Saida, preco) VALUES(null, '20:11:6 12:10', '20:11:6 14:40', '5.0');
INSERT INTO TB_TICKET(id_Ticket, hora_Entrada, hora_Saida, preco) VALUES(null, '20:11:6 12:10', '20:11:6 14:40', '20.0');
INSERT INTO TB_TICKET(id_Ticket, hora_Entrada, hora_Saida, preco) VALUES(null, '20:11:6 12:10', '20:11:6 14:40', '10.0');
INSERT INTO TB_TICKET(id_Ticket, hora_Entrada, hora_Saida, preco) VALUES(null, '20:11:6 12:10', '20:11:6 14:40', '15.0');
INSERT INTO TB_TICKET(id_Ticket, hora_Entrada, hora_Saida, preco) VALUES(null, '20:11:6 12:10', '20:11:6 14:40', '5.0');



INSERT INTO TB_VAGA(id_Vaga, numero_vaga, livre) VALUES(null, '1', true);
INSERT INTO TB_VAGA(id_Vaga, numero_vaga, livre) VALUES(null, '2', true);
INSERT INTO TB_VAGA(id_Vaga, numero_vaga, livre) VALUES(null, '3', true);
INSERT INTO TB_VAGA(id_Vaga, numero_vaga, livre) VALUES(null, '4', true);
INSERT INTO TB_VAGA(id_Vaga, numero_vaga, livre) VALUES(null, '5', true);



ALTER TABLE TB_TICKET ADD CONSTRAINT FKmf29jfguur284fhdni284 FOREIGN KEY (vaga_id_vaga) REFERENCES TB_VAGA (id_Vaga);
ALTER TABLE TB_TICKET ADD CONSTRAINT FK28fjsjnfasuhdalkr2842 FOREIGN KEY (veiculo_id_veiculo) REFERENCES TB_VEICULO (id_Veiculo);
ALTER TABLE TB_VEICULO ADD CONSTRAINT FKdfji2048dhs888a9a48gu FOREIGN KEY (cliente_id_Cliente) REFERENCES TB_CLIENTE(id_Cliente);


