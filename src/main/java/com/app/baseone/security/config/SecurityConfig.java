package com.app.baseone.security.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.app.baseone.security.business.service.implementation.UserDetailsServiceImpl;

// import com.institute.one.users.business.service.implementation.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

        // TODO anterior securityfilterchain
    // @Bean
    // public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity)
    // throws Exception {

    // return httpSecurity
    // .csrf(csrf -> csrf.disable())
    // .httpBasic(Customizer.withDefaults())
    // .sessionManagement(session ->
    // session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
    // .authorizeHttpRequests(http -> {
    // http.requestMatchers(HttpMethod.GET,"/inicio/funciona").permitAll();
    // http.requestMatchers(HttpMethod.GET,"/inicio/seguridad").hasAuthority("READ");
    // http.anyRequest().denyAll();

    // })
    // .build();
    // }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        return httpSecurity
                .csrf(csrf -> csrf.disable())
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                // .authorizeHttpRequests(http -> {

                // //TODO allow authorization
                // http.requestMatchers(HttpMethod.GET, "/usuario/funciona").permitAll();
                // http.requestMatchers(HttpMethod.GET, "/usuario/get").permitAll();

                // // allow authorization

                // http.requestMatchers(HttpMethod.GET,
                // "/usuario/seguridad").hasAuthority("CREATE");

                // // others
                // http.requestMatchers(HttpMethod.GET, "/usuario/get").hasAuthority("READ");
                // http.requestMatchers(HttpMethod.POST,
                // "/usuario/post").hasAuthority("CREATE");
                // http.requestMatchers(HttpMethod.PUT, "/usuario/put").hasAuthority("UPDATE");

                // // other methods

                // http.requestMatchers(HttpMethod.DELETE,
                // "/usuario/delete").hasAnyAuthority("UPDATE","DELETE");

                // // other methods
                // http.requestMatchers(HttpMethod.PATCH, "/usuario/patch").hasAnyRole("ADMIN",
                // "USER");

                // // Materias
                // http.requestMatchers(HttpMethod.GET, "/materia/find/{id}").permitAll();
                // http.requestMatchers(HttpMethod.GET, "/materia/find").permitAll();
                // http.requestMatchers(HttpMethod.POST,
                // "/materia/create").hasAuthority("CREATE");
                // http.requestMatchers(HttpMethod.PUT,
                // "/materia/update").hasAuthority("UPDATE");
                // http.requestMatchers(HttpMethod.PUT,
                // "/materia/update/{id}").hasAuthority("UPDATE");

                // http.anyRequest().denyAll();
                // })
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {

        return authenticationConfiguration.getAuthenticationManager();

    }

    @Bean
    public AuthenticationProvider authenticationProvider(UserDetailsServiceImpl userDetailsServiceImpl) {

        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(userDetailsServiceImpl);
        return provider;

    }

    // @Bean
    // public UserDetailsService userDetailsService() {
    // List<UserDetails> userDetailsList = new ArrayList<>();

    // userDetailsList.add(
    // User.withUsername("manuel")
    // .password("1234")
    // .roles("ADMIN")
    // .authorities("READ", "CREATE")
    // .build());
    // userDetailsList.add(
    // User.withUsername("fernando")
    // .password("1234")
    // .roles("USER")
    // .authorities("READ")
    // .build());

    // return new InMemoryUserDetailsManager(userDetailsList);
    // }

    @Bean
    public PasswordEncoder passwordEncoder() {

        return NoOpPasswordEncoder.getInstance();

    }

}
