package br.com.caelum.genus;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableOAuth2Sso
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
	http.authorizeRequests()
		.anyRequest().authenticated()
		.and().formLogin()
			.loginProcessingUrl("/login").permitAll()
			.loginPage("/").permitAll()
			.defaultSuccessUrl("/trainee")
		.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.logoutSuccessUrl("/").permitAll()
		.and().csrf().disable();
    }
}
