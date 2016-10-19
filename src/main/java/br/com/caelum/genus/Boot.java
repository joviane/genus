package br.com.caelum.genus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@SpringBootApplication
@EntityScan(basePackageClasses = { Boot.class, Jsr310JpaConverters.class })
public class Boot extends SpringBootServletInitializer {

    @Bean
    public InternalResourceViewResolver view() {
	InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
	internalResourceViewResolver.setPrefix("/WEB-INF/views/");
	internalResourceViewResolver.setSuffix(".jsp");
	internalResourceViewResolver.setExposedContextBeanNames("viewHelper");
	return internalResourceViewResolver;
    }

    public static void main(String[] args) {
	SpringApplication.run(Boot.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	return application.sources(Boot.class);
    }
}
