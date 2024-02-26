INSERT INTO tb_user(name, email, password) VALUES ('Kengi Ortega', 'kortega@hotmail.com', 'password123');
INSERT INTO tb_user(name, email, password) VALUES ('Maria Silva', 'maria.silva@example.com', 'password123');
INSERT INTO tb_user(name, email, password) VALUES ('John Doe', 'john.doe@example.com', 'password123');
INSERT INTO tb_user(name, email, password) VALUES ('Alice Johnson', 'alice.johnson@example.com', 'password123');


INSERT INTO TB_SCHEDULE (name, expiration_date, created_at, updated_at) VALUES ('Reunião de Equipe', '2024-03-01', NOW(), NOW());
INSERT INTO TB_SCHEDULE (name, expiration_date, created_at, updated_at) VALUES ('Apresentação do Projeto', '2024-03-05', NOW(), NOW());
INSERT INTO TB_SCHEDULE (name, expiration_date, created_at, updated_at) VALUES ('Entrevista de Emprego', '2024-03-10', NOW(), NOW());
INSERT INTO TB_SCHEDULE (name, expiration_date, created_at, updated_at) VALUES ('Treinamento de Novos Funcionários', '2024-03-15', NOW(), NOW());
INSERT INTO TB_SCHEDULE (name, expiration_date, created_at, updated_at) VALUES ('Conferência Anual', '2024-03-20', NOW(), NOW());

--Inserção dos contatos
-- Inserção do contato 1 (João Silva)
INSERT INTO tb_contact (name, cep, email, phone, cnpj, cpf, schedule_id) VALUES ('João Silva', '12345678', 'contato1@example.com', '123456789', NULL, '123.456.789-10', 1);

-- Inserção do contato 2 (Maria Souza)
INSERT INTO tb_contact (name, cep, email, phone, cnpj, cpf, schedule_id) VALUES ('Maria Souza', '23456789', 'contato2@example.com', '234567890', NULL, '987.654.321-00', 1);

-- Inserção do contato 3 (Pedro Oliveira)
INSERT INTO tb_contact (name, cep, email, phone, cnpj, cpf, schedule_id) VALUES ('Pedro Oliveira', '34567890', 'contato3@example.com', '345678901', NULL, '111.222.333-44', 2);

-- Inserção do contato 4 (Empresa A)
INSERT INTO tb_contact (name, cep, email, phone, cnpj, cpf, schedule_id) VALUES ('Empresa A', '12345458', 'contato4@example.com', '123476789', '12345678901234', NULL, 3);

-- Inserção do contato 5 (Empresa B)
INSERT INTO tb_contact (name, cep, email, phone, cnpj, cpf, schedule_id) VALUES ('Empresa B', '23456789', 'contato5@example.com', '234567890', '56789012345678', NULL, 3);

-- Inserção do contato 6 (Empresa C)
INSERT INTO tb_contact (name, cep, email, phone, cnpj, cpf, schedule_id) VALUES ('Empresa C', '34567890', 'contato6@example.com', '345678901', '90123456789012', NULL, 4);



---- Inserção dos usuários nas agendas
-- Inserção do usuário 1 (Kengi Ortega) na agenda 1 (Reunião de Equipe)
INSERT INTO USER_SCHEDULE (user_id, schedule_id) VALUES ((SELECT id FROM tb_user WHERE name = 'Kengi Ortega'), 1);

-- Inserção do usuário 1 (Kengi Ortega) na agenda 2 (Apresentação do Projeto)
INSERT INTO USER_SCHEDULE (user_id, schedule_id) VALUES ((SELECT id FROM tb_user WHERE name = 'Kengi Ortega'), 2);

-- Inserção do usuário 1 (Kengi Ortega) na agenda 3 (Entrevista de Emprego)
INSERT INTO USER_SCHEDULE (user_id, schedule_id) VALUES ((SELECT id FROM tb_user WHERE name = 'Kengi Ortega'), 3);

-- Inserção do usuário 2 (Maria Silva) na agenda 2 (Apresentação do Projeto)
INSERT INTO USER_SCHEDULE (user_id, schedule_id) VALUES ((SELECT id FROM tb_user WHERE name = 'Maria Silva'), 2);

-- Inserção do usuário 3 (John Doe) na agenda 3 (Entrevista de Emprego)
INSERT INTO USER_SCHEDULE (user_id, schedule_id) VALUES ((SELECT id FROM tb_user WHERE name = 'John Doe'), 3);

-- Inserção do usuário 3 (John Doe) na agenda 4 (Treinamento de Novos Funcionários)
INSERT INTO USER_SCHEDULE (user_id, schedule_id) VALUES ((SELECT id FROM tb_user WHERE name = 'John Doe'), 4);

-- Inserção do usuário 4 (Alice Johnson) na agenda 4 (Treinamento de Novos Funcionários)
INSERT INTO USER_SCHEDULE (user_id, schedule_id) VALUES ((SELECT id FROM tb_user WHERE name = 'Alice Johnson'), 4);


