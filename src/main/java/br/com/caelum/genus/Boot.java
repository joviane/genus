package br.com.caelum.genus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

@SpringBootApplication
@EntityScan(basePackageClasses = { Boot.class, Jsr310JpaConverters.class })
public class Boot {

    public static void main(String[] args) {
	SpringApplication.run(Boot.class, args);
    }
}
