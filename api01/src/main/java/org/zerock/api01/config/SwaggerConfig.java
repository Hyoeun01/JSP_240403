package org.zerock.api01.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("레스트Api테스트")
                        .description("Boot API01 project Swagger")
                        .version("1.0.0"));
    }

//    @Bean
//    public Docket api(){
//        return new Docket(DocumentationType.OAS_30)
//    }
}
