# Monitor de Emissão de Notas Fiscais

## Sobre o Projeto

Este projeto foi desenvolvido como projeto final do curso de Engenharia de Software, 3º semestre, na disciplina de Programação Orientada a Objetos I (POO I).

O objetivo do trabalho é aplicar conceitos fundamentais da Programação Orientada a Objetos utilizando Java, incluindo encapsulamento, classes, objetos, enumerações, organização em camadas e implementação de regras de negócio.

## Conceitos Aplicados

Durante o desenvolvimento deste projeto foram utilizados os seguintes conceitos:

- Classes e Objetos;
- Encapsulamento;
- Métodos;
- Enumerações (Enums);
- Regras de Negócio;
- Organização em Camadas;
- Manipulação de Datas com `LocalDate`;
- Estruturas Condicionais;
- Programação Orientada a Objetos.

## Descrição do Sistema

O Monitor de Emissão de Notas Fiscais é um sistema via terminal em que é possível acompanhar e gerenciar notas fiscais eletrônicas. Ao acessar o módulo, o usuário poderá realizar as seguintes operações:

### Consultar Nota Fiscal

Permite visualizar as principais informações da nota fiscal:

- Número da nota;
- Data de emissão;
- Série;
- Chave de autenticação da SEFAZ;
- Natureza ou finalidade da operação;
- Quantidade de itens;
- Valor total da nota;
- Status atual.

### Autorizar Nota Fiscal

Permite autorizar uma nota fiscal somente quando seu status atual for:

- `PENDENTE_AUTORIZACAO`

Após a autorização, o status da nota é alterado para:

- `AUTORIZADA`

### Inutilizar Nota Fiscal

Permite inutilizar uma nota fiscal somente quando seu status atual for:

- `REJEICAO_SEFAZ`

Após a inutilização, o status da nota é alterado para:

- `INUTILIZADA`

### Cancelar Nota Fiscal

Permite cancelar uma nota fiscal somente quando:

- O status atual for `AUTORIZADA`;
- O pedido de cancelamento ocorrer dentro do prazo máximo de 30 dias após a emissão.

Após o cancelamento, o status da nota é alterado para:

- `CANCELADA`

## Regras de Negócio

O sistema valida as condições necessárias antes de realizar qualquer alteração de status.

Quando uma operação for concluída com sucesso, o sistema:

1. Informa que a alteração foi realizada com sucesso;
2. Exibe o novo status da nota fiscal.

Caso a operação não possa ser executada, o sistema informa o motivo da rejeição.

## Estrutura do Projeto

```text
src
├── Main.java
├── model
│   ├── NotaFiscal.java
│   └── StatusNota.java
└── service
    └── NotaFiscalService.java
... em desenvolvimento
```

### model

Contém as classes responsáveis por representar os dados do sistema.

#### NotaFiscal.java

Classe que representa uma nota fiscal e seus atributos.

Responsabilidades:

- Armazenar os dados da nota fiscal;
- Disponibilizar métodos de acesso aos atributos;
- Representar o estado atual da nota.

#### StatusNota.java

Enumeração que define os possíveis estados de uma nota fiscal:

- `PENDENTE_AUTORIZACAO`
- `AUTORIZADA`
- `REJEICAO_SEFAZ`
- `INUTILIZADA`
- `CANCELADA`

### service

Contém as regras de negócio da aplicação.

#### NotaFiscalService.java

Classe responsável por validar e executar alterações de status das notas fiscais.

Funcionalidades implementadas:

- Inutilização de nota fiscal;
- Cancelamento de nota fiscal;
- Validação das regras de negócio;
- Controle de transição de estados.

### Main.java

Classe principal da aplicação.

Responsável por iniciar a execução do sistema através do método:

```java
public static void main(String[] args)
```

## Tecnologias Utilizadas

- Java
- Programação Orientada a Objetos
- VS Code
- Git
- GitHub

## Integrantes

| Integrante | Responsabilidade |
|------------|------------------|
| Maria Luiza Hames | Modelagem inicial e implementação das funcionalidades de inutilização e cancelamento de nota fiscal |
| Emilli | Implementação da funcionalidade de autorização de nota fiscal |
...


