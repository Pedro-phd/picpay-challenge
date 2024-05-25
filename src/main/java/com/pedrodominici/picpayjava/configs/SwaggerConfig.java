package com.pedrodominici.picpayjava.configs;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(
        title = "Mini PicPay",
        description = "Projeto para o teste da empresa PicPay",
        contact = @Contact(
                name = "Pedro Dominici",
                email = "pedro_dominici@outlook.com",
                url = "https://www.linkedin.com/in/pedro-dominici/")))
public class SwaggerConfig {
}
