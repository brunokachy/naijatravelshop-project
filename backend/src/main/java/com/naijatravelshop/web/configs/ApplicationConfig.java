package com.naijatravelshop.web.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

/**
 * Created by jnwanya on
 * Wed, 27 Mar, 2019
 */
@Configuration
public class ApplicationConfig {

    /* FOR INTERNATIONALIZATION */
    @Bean
    public ReloadableResourceBundleMessageSource messageSource() {
        ReloadableResourceBundleMessageSource resourceBundleMessageSource = new ReloadableResourceBundleMessageSource();
        resourceBundleMessageSource.setBasename("classpath:i18n/messages");
        resourceBundleMessageSource.setCacheSeconds(1800);
        return resourceBundleMessageSource;
    }

}
