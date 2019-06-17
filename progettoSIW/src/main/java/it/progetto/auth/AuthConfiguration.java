package it.progetto.auth;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class AuthConfiguration extends WebSecurityConfigurerAdapter {
	
	    @Autowired
	    private Environment environment;
	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http
	                // authorization paragraph: we are going to define here WHO can access WHAT pages
	                .authorizeRequests()

	                    // everyone (authenticated or not) can access the home page
	                    .antMatchers(HttpMethod.GET, "/", "/index").permitAll()

	                    // only admin can access the admin page
	                    .antMatchers(HttpMethod.GET, "/paginaAdmin").hasAnyAuthority("ADMIN")

	                    // all authenticated users can access all the other pages (that is, welcome)
	                    .anyRequest().permitAll()

	                // login paragraph: we are going to define here how to login
	                // use formlogin protocol to perform login
	                .and().formLogin()
	                    // after login is successful, redirect to /welcome page
	                    .defaultSuccessUrl("/admin")
	                //NOTE: we are using the default configuration for login,
	                // meaning that the /login url is automatically mapped to auto-generated page.
	                // for our own page, we would need to use loginPage()
	                // and write a method for accessing it with GET method (but Spring would still handle the POST automatically)

	                // logout paragraph: we are going to define here how to logout
	                .and().logout()
	                    // logout is performed when sending a GET to "/logout"
	                    .logoutUrl("/logout")
	                    // after logout is successful, redirect to / page (home)
	                    .logoutSuccessUrl("/");
	    }
	    @Bean
	    DataSource buildDatasource() {
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName(environment.getProperty("spring.datasource.driver-class-name"));
	        dataSource.setUrl(environment.getProperty("spring.datasource.url"));
	        dataSource.setUsername(environment.getProperty("spring.datasource.username"));
	        dataSource.setPassword(environment.getProperty("spring.datasource.password"));
	        return dataSource;
	    }
	    @Autowired
	    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	        auth.jdbcAuthentication().dataSource(this.buildDatasource())
	                .authoritiesByUsernameQuery("SELECT username, role FROM users WHERE username=?")
	                .usersByUsernameQuery("SELECT username, password, 1 as enabled FROM users WHERE username=?");
	    }

}
