# Recursos Humanos
Projeto desevolvido em aula no gerador de devs,
sendo uma API com responsabilidade de fazer a gestão de cargos
,departamentos,tipo de documentos ,colaboradores,atestados e usuarios de recusos humanos.
Para segurança as rotas utilizam validação de token JWT.

### Pré-requisistos
O que você precisa instalar pra rodar o projeto?

* [Gradle](https://gradle.org/)
* [JDK-17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
* [MySQL](https://www.mysql.com/)
* [Docker Compose](https://docs.docker.com/compose/)

### Como podemos abaixar a aplicação?
#### SSH
```
git@gitlab.com:Mateusferian/gd-recursos-humanos.git
```
#### HTTPs
```
https://gitlab.com/Mateusferian/gd-recursos-humanos.git
```

### Boas praticas do versionamento do código
* Utilização de Gitflow
* Utilização de commit semantico
* É necessario aprovação de um Maintainer para aprovação de MR

### Como rodar a aplicação?
abra o terminal e execute o comando abaixo:

```
sh docker-compose-dev.sh
```

### Como rodar os testes unitario?
abra o terminal e execute o comando abaixo:

```
./gradlew test
```

### Para acessar a documentação da API
abra o browser e acesse o seguinte link:
```
http://localhost:8080/swagger-ui.html#/
```
### Tecnologias utilizadas

* [Gradle](https://gradle.org/) - De aplicativos móveis a microsserviços, de pequenas empresas a grandes empresas, a Gradle ajuda as equipes a construir, automatizar e fornecer software melhor, mais rapidamente.
####
* [Spring Boot Web Starter](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-test) - Starter para construção de web, incluindo aplicativos RESTful, usando o Spring MVC. Usa o Tomcat como o contêiner incorporado padrão
####
* [Model Mapper](http://modelmapper.org/) - Os aplicativos geralmente consistem em modelos de objetos semelhantes, mas diferentes, em que os dados em dois modelos podem ser semelhantes, mas a estrutura e as preocupações dos modelos são diferentes. O mapeamento de objetos facilita a conversão de um modelo em outro, permitindo que modelos separados permaneçam segregados.
####
* [Swagger](https://swagger.io/) - Simplifique o desenvolvimento de API para usuários, equipes e empresas com o conjunto de ferramentas open source e profissional Swagger.
####
* [Power Mock](https://powermock.github.io/) - O PowerMock é uma estrutura que estende outras bibliotecas simuladas, como o EasyMock, com recursos mais poderosos. O PowerMock usa um carregador de classes personalizado e manipulação de bytecode para permitir a simulação de métodos estáticos, construtores, classes e métodos finais, métodos particulares, remoção de inicializadores estáticos e muito mais.