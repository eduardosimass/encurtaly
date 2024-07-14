## Projeto Java Spring Boot 

- Desenvolver um Encurtador de Links, que redirecione o Link encurtado para a pagina desejada. 



## Requisitos

- O encurtador de URLs recebe uma URL longa como parâmetro inicial.
- O encurtamento será composto por um mínimo de 05 e um máximo de 10 caracteres.
- Apenas letras e números são permitidos no encurtamento.
- A URL encurtada será salva no banco de dados com um prazo de validade (você pode escolher a duração desejada).
- Ao receber uma chamada para a URL encurtada `https://xxx.com/DXB6V`, você deve fazer o redirecionamento para a
  URL original salva no banco de dados. Caso a URL não seja encontrada no banco, retorne o código de
  status `HTTP 404 (Not Found)`.
