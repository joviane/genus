package br.com.caelum.genus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.filter.OAuth2ClientContextFilter;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;

@EnableOAuth2Sso
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private OAuth2ClientContextFilter oauth2ClientContextFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
	http.addFilterAfter(oauth2ClientContextFilter, SecurityContextPersistenceFilter.class)
		.antMatcher("/**").authorizeRequests().antMatchers("/", "/assets/**").permitAll()
		.anyRequest().authenticated();
    }

}
