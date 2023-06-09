//package com.fullstackproject.restaurant.customer_service.configuration;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.thymeleaf.templateresolver.FileTemplateResolver;
//import org.thymeleaf.templateresolver.ITemplateResolver;
//
//
//@Configuration
//public class ThymeleafConfiguration {
//
//    @Autowired
//    private ThymeleafProperties properties;
//
//    @Value("${spring.thymeleaf.templates_root:}")
//    private String templatesRoot;
//
//    @Bean
//    public ITemplateResolver defaultTemplateResolver() {
//        FileTemplateResolver resolver = new FileTemplateResolver();
//        resolver.setSuffix(properties.getSuffix());
//        resolver.setPrefix(templatesRoot);
//        resolver.setTemplateMode(properties.getMode());
//        //resolver.setCharacterEncoding(properties.getEncoding().toString());
//        resolver.setCacheable(properties.isCache());
//        return resolver;
//    }
//}