package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
//@EnableMethodSecurity(
//        securedEnabled = true,
//        jsr250Enabled = true,
//        prePostEnabled = true
//       )
@EnableWebSecurity
public class SecurityConfig {
    @Bean
   public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        //set session management to stateless
       // http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        //Enable and disable cors
       http.csrf().disable()
               .authorizeHttpRequests(
                       (authorize) ->
                               authorize.requestMatchers(HttpMethod.POST, "/api/addRole").permitAll()
//                                       .requestMatchers(HttpMethod.POST, "/api/addRole").permitAll()
                                       .requestMatchers("/api/auth/**").permitAll()
                                       .anyRequest().authenticated()
               );
       // http.oauth2ResourceServer().jwt();
       return http.build();
   }

    @Bean
   public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
   }
    @Bean
   public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception{
        return configuration.getAuthenticationManager();
   }
}
