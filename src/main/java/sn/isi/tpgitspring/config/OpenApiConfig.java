package sn.isi.tpgitspring.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    //    http://localhost:8080/swagger-ui/index.html

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Tp-Git-Spring API")
                        .description("API de gestion des utilisateurs")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Fatoumata Diouf")
                                .email("fatoumatadioufkm@groupeisi.sn"))
                );
    }
}
