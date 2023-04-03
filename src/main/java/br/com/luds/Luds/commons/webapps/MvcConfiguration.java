package br.com.luds.Luds.commons.webapps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileUrlResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

import java.io.*;
import java.util.Properties;

@Configuration
public class MvcConfiguration implements WebMvcConfigurer {

    @Autowired
    private ResourceLoader resourceLoader;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String webapps = "/templates/luds-front/";
        registry.addResourceHandler("/front/**", "/front", "/front/")
                .addResourceLocations("classpath:" + webapps)
                .resourceChain(true)
                .addResolver(new PathResourceResolver() {
                    @Override
                    protected Resource getResource(String resourcePath, Resource location) throws IOException {
                        Resource requestedResource = location.createRelative(resourcePath);

                        return requestedResource.exists() && requestedResource.isReadable() ? requestedResource
                                : new ClassPathResource(webapps + "index.html");
                    }
                });
    }

}
