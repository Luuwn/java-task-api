package bs.fatec.ToDo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {
   @Bean
   public OpenAPI tasksOpenApi() {
      return new OpenAPI().info(new Info()
         .title("API do Projeto da FATEC")
         .description("Esta API é utilizada na disciplina Desenvolvimento para Servidores-II\n\n" +
         "Contatos:\n\n" +
         "Luan da Silva Costa - luan.costa4@fatec.sp.gov.br\n\n" +
         "Lucas Germano Maia - lucas.maia4@fatec.sp.gov.br\n")
         .version("v0.0.1")
         .license(new License()
           .name("Apache 2.0").url("http://springdoc.org")));
   }
}