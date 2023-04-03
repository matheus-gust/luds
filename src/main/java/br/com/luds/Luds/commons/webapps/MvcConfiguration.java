package br.com.luds.Luds.commons.webapps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
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
            String prop = fetchFront().getPath();
            String pathAlterado = prop.substring(prop.length() - 1).equals(File.separator) ? prop
                    : prop + File.separator;
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

        public File fetchFront(){
            File file = null;
            try {
                file = resourceLoader.getResource("classpath:webapp/luds-front").getFile();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            return file;
        }
    }
