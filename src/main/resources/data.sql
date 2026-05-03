-- Inserindo Clientes
INSERT INTO tb_clientes (nome_cliente, cpfcnpj, id_consorciado, telefone, email, endereco, cidade, n_grupo, n_cota, inadimplente)
VALUES ('Maria Silva', '12345678900', 'ABC123', '44999999999', 'maria@email.com', 'Rua X', 'Guaíra', 1, 10, false);

INSERT INTO tb_clientes (nome_cliente, cpfcnpj, id_consorciado, telefone, email, endereco, cidade, n_grupo, n_cota, inadimplente)
VALUES ('Teste Groscon', '00000000000', 'XYZ987', '44888888888', 'teste@groscon.com', 'Av Central', 'Curitiba', 2, 20, true);

-- Inserindo Processos (Lembrando que Processo é a tabela pai devido ao JOINED)
-- Primeiro na tabela pai (processo)
INSERT INTO processo (cliente_id, data_inicio, valor_atual, n_processo, n_vara, cidade, acao, situacao_atual, passivel, tipo_processo)
VALUES (1, '2023-01-10', 1500.50, 98765, 1, 'Guaíra', true, 'Em andamento', true, 'INADIMPLENCIA');

-- Depois na tabela filha (tb_processos_inadimplencia)
-- O ID aqui deve bater com o ID gerado na tabela pai (geralmente 1 se for o primeiro)
INSERT INTO tb_processos_inadimplencia (id) VALUES (1);