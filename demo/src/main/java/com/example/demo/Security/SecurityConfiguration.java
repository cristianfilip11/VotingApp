package com.example.demo.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableMethodSecurity
public class SecurityConfiguration {

    /*@Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder){
        UserDetails admin = User
                .withUsername("admin")
                .authorities("BASIC", "SPECIAL")
                .roles("superuser")
                .password(encoder.encode("1"))
                .build();

        UserDetails user = User
                .withUsername("user")
                .authorities("BASIC")
                .roles("basicuser")
                .password(encoder.encode("2"))
                .build();
        return new InMemoryUserDetailsManager(admin, user);
    }*/

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.getSharedObject(AuthenticationManagerBuilder.class).build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }




    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeRequests(authorize ->{
                    authorize.requestMatchers(HttpMethod.POST,"/createnewuser").permitAll();
                    authorize.requestMatchers("/login").permitAll();
                    authorize.requestMatchers("/static").permitAll();
                    authorize.requestMatchers("/register").permitAll();
                    authorize.requestMatchers("/homepage").permitAll();


                    //must be at the bottom
                    authorize.anyRequest().authenticated();
//                    authorize.requestMatchers("/open").permitAll();
//                    authorize.requestMatchers("/closed").authenticated();
//                    authorize.requestMatchers(HttpMethod.PUT, "/product").authenticated();
//
//                    authorize.requestMatchers(HttpMethod.GET, "/special").hasAuthority("SPECIAL");
//                    authorize.requestMatchers(HttpMethod.GET, "/basic").hasAnyAuthority("SPECIAL", "BASIC");
                })


                //.httpBasic(Customizer.withDefaults()) //for basic authentication
                .formLogin(form -> form
                        .loginPage("/login") // Custom login page
                        .defaultSuccessUrl("/homepage", true)
                        .failureUrl("/login?error=true") // Redirect to login with error paramete
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout")
                        .permitAll()
                )
                .addFilterBefore(
                        new BasicAuthenticationFilter(authenticationManager(httpSecurity)),
                        UsernamePasswordAuthenticationFilter.class
                )
                .httpBasic(Customizer.withDefaults())
                .build();
    }
}



