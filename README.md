# crypto-service

## Objetivo

Eu como usuário quero ser capaz de cadastrar, visualizar, editar e remover crypto ativos. Prover um micro serviço para realizar as seguintes operações acima, as informações devem ser persistidas no banco de dados.


### Criar os scripts de migração de banco de dados
Primeiramente criar o banco de dados.
Usar flyway para criar os scripts para criar a estrutura de dados
Criar tabela de crypto ativos com o nome currency com as estrutura:
- Id - UUID - chave primária
- Name - texto - nome do cypto ativo (ex: Bitcoin)
- Code - text - código do crypto ativo (ex: BTC)
- createdAt - datetime - data da criação do registro


### Criar entidades correspondentes a estrutura do banco de dados
Usar JPA para mapear a classe referente a tabela currency

### Criar classe de repositório
Usar o Spring Data para criar uma classe repository responsável pelo acesso aos dados da tabela currency


### Criar classe de negócio
Criar classe de domínio CurrencyModel
- Fazer o mapper da classe entity para a classe model

### Criar classe controller e dtos
Criar classe CurrencyDTO
Fazer o mapper da classe model para a classe DTO
Criar classe @Controller que deverá conter um método expondo um endpoint para cada ação

### O método de busca:
- Recebe como parâmetro os filtros: name e code (ambos opcionais)
- Retorna:
  - uma lista de currency dto
  - Com status de sucesso

### O método de salvar:
- Recebe name e code (ambos obrigatórios)
- Retorna:
  - O objeto DTO salvo
  - Com status criado

### O método de edição:
- Recebe:
  - Parâmetro via path ID
  - Name e code (opcionais)
- Retorna:
  - Com status de sucesso

### O método de remoção:
- Recebe:
  - Parâmetro via path ID
- Retorna
  - Com status sucesso

### Banco de dados

docker-compose up -d

Criar database com nome crypto no pgadmin

- botão direito em cima de databases -> create -> database
colocar o nome crypto e salvar