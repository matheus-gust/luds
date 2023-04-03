package br.com.luds.Luds.commons.webapps;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileUrlResource;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

import java.io.File;
import java.io.IOException;

    @Configuration
    public class MvcConfiguration implements WebMvcConfigurer {

        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            String resource = getClass().getClassLoader().getResource("webapp/luds-front").getPath();
            String pathAlterado = resource.substring(resource.length() - 1).equals(File.separator) ? resource
                    : resource + File.separator;
            System.out.println(pathAlterado);
            registry.addResourceHandler("/front/**", "/front", "/front/")
                    .addResourceLocations("file:" + pathAlterado)
                    .resourceChain(true)
                    .addResolver(new PathResourceResolver() {
                        @Override
                        protected Resource getResource(String resourcePath, Resource location) throws IOException {
                            Resource requestedResource = location.createRelative(resourcePath);

                            return requestedResource.exists() && requestedResource.isReadable() ? requestedResource
                                    : new FileUrlResource(pathAlterado + "index.html");
                        }
                    });
        }
    }
