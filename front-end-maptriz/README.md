# Desafio Técnico Front-end

## Introdução

O objetivo deste desafio é avaliar sua abordagem para resolver um problema utilizando recursos comuns dos sistemas da Maptriz. Fornecemos um esqueleto de projeto em Angular como ponto de partida, mas você pode optar por outras tecnologias de front-end, se preferir.

Ao concluir, hospede o projeto no seu GitHub (evite referências diretas à Maptriz). Realizaremos um *Code Review* e uma conversa técnica posteriormente. Se optar por usar a base em Angular, faça um *fork* do projeto no seu GitHub.

Envie o link do seu GitHub para processoseletivo@maptriz.com.br.

## Descrição do Desafio

Desenvolva uma agenda com gerenciamento de contatos, com as seguintes funcionalidades:

* Cadastro de pessoas físicas como contatos.
* Consulta de contatos.
* Edição de contatos.
* Exclusão de contatos.
* Envio de notificações via e-mail para o usuário após alterações na agenda.

Funcionalidades opcionais:

* Cadastro de pessoas jurídicas como contatos.
* Armazenamento de coordenadas de moradia (pessoa física) ou escritório (pessoa jurídica).
* Adição de recursos de acessibilidade (foco em deficiências visuais).
* Tradução da interface para pelo menos um idioma adicional.

Itens não avaliados:

* Design da interface.
* Autenticação do usuário (apontando para https://run.mocky.io/v3/970f7229-1a5e-4905-bac8-81aaa9d51e17).
* Nota: Para a funcionalidade de notificação por e-mail, utilize https://run.mocky.io/v3/c9ec2ca3-a7f5-41d0-8550-b859508f4948.

A aplicação deve ser executável localmente e ter tratamento de erros adequado, incluindo feedback ao usuário e evitando falhas graves. Atente-se às comunicações com APIs e formulários.

## Técnicas Desejadas

Se utilizar Angular, use as seguintes técnicas:

* Angular Reactive Forms (https://angular.io/guide/reactive-forms) em todos os formulários.
* NGXS (https://www.ngxs.io/) para gerenciamento de estados.

Utilize técnicas análogas se escolher outra tecnologia de front-end.

## Como Executar o Projeto Angular

Para rodar o projeto Angular (caso opte por esta tecnologia), instale o NodeJS (recomendamos versão 14, por exemplo, 14.15). Execute:

```
npm install -g angular-cli
```

Depois, na pasta raiz do projeto:

```
npm install
ng serve
```