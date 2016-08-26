package br.com.caelum.genus;

import java.security.Principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableOAuth2Sso
@RestController
@EntityScan(basePackageClasses = { Boot.class, Jsr310JpaConverters.class })
public class Boot  extends WebSecurityConfigurerAdapter{
    
	@RequestMapping("/user")
	public Principal user(Principal principal) {
		return principal;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.antMatcher("/**").authorizeRequests().antMatchers("/", "/login**", "/webjars/**").permitAll().anyRequest()
				.authenticated()
				.and().logout().logoutSuccessUrl("/").permitAll()
				.and().csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
	}

    public static void main(String[] args) {
	SpringApplication.run(Boot.class, args);
    }
}
