package com.professorangoti.condominio.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebConfigSecurity {

  @Bean
  public UserDetailsService userDetailsService() {
    return new CondominioUserDetailsService();
  }

  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public DaoAuthenticationProvider authenticationProvider() {
    DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
    authProvider.setUserDetailsService(userDetailsService());
    authProvider.setPasswordEncoder(passwordEncoder());
    return authProvider;
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.authorizeRequests(authorize -> authorize
        .antMatchers("/fotos_apto","/rel_apto","/rel_prop").hasAnyAuthority("ADMIN", "USUARIO") // permissão para visualizar
        .antMatchers("/cad_apto","/cad_prop","/upload").hasAnyAuthority("ADMIN", "CRIADOR")     // permissão para criar
        .antMatchers("/excluir_prop","/excluir_foto").hasAnyAuthority("ADMIN", "EDITOR")        // permissão para editar/excluir
        .antMatchers("/", "/home").permitAll()
        .anyRequest().authenticated())
        
        .formLogin(form -> form.loginPage("/login").permitAll())
        .logout().logoutSuccessUrl("/");
    return http.build();
  }
}