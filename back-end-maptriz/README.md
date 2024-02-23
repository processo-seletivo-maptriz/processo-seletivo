# Desafio Back-end

## Introdução

Este projeto usa Spring Boot 3.1.9 e Java 17. Se optar por utilizar este projeto como base, certifique-se de ter a versão 17 do Java SDK instalada.

O objetivo deste desafio é avaliar sua abordagem na criação de uma API REST e sua comunicação com uma base de dados relacional (SQL). Recomenda-se o PostgreSQL, mas qualquer solução SQL é válida.

Embora esta estrutura utilize Spring Boot e Java, sinta-se à vontade para escolher a tecnologia de back-end mais confortável para você. É crucial atender aos requisitos e evitar o uso de bibliotecas como Lombok, possibilitando a observação e avaliação de todo o código.

Caso decida utilizar este projeto como base, realize um *fork* dele.

## Descrição do Desafio

Desenvolva uma API REST para atender às necessidades de back-end de uma agenda de contatos, com os seguintes requisitos essenciais:

* Criação, edição, consulta e remoção de registros de contatos.
* Os contatos devem representar pessoas físicas.
* Validação de CPFs ou CEPs inválidos.
* Armazenamento dos dados em uma base de dados SQL.
* Tratamento de exceções em caso de erro na base de dados ou recebimento de dados inválidos.
* Envio de e-mail para cada registro realizado como notificação, utilizando o endpoint https://run.mocky.io/v3/c9ec2ca3-a7f5-41d0-8550-b859508f4948 (requisição GET).

Requisitos opcionais:

* Um contato pode, também, ser uma pessoa jurídica (com as devidas validações).
* Associação de todos os contatos a um (ou mais) registro(s) de usuário(s), deixando a relação exata a seu critério.
* Implementação de uma base SQL com georreferenciamento para armazenar coordenadas em um tipo dedicado de coluna.
* Consultas mais complexas, como filtrar todos os registros de pessoa física cujo CPF começa com os caracteres "018".
* Envio de mensagens de resposta traduzidas para pelo menos mais um idioma.
* Restrição de operações da API apenas para usuários autenticados, utilizando o endpoint https://run.mocky.io/v3/970f7229-1a5e-4905-bac8-81aaa9d51e17 (GET) para autenticação/obtenção dos dados do usuário atual, se necessário.