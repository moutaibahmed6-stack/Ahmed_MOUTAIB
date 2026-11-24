
package ma.projet.gestioncomptes.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Configuration de la documentation de notre API
@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI gestionComptesAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Gestion des Comptes Bancaires")
                        .version("1.0.0")
                        .description(
                                "Micro-service Spring Boot permettant " +
                                        "de créer, consulter, modifier et supprimer " +
                                        "des comptes bancaires."
                        ));
    }
}
