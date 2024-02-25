package web_4.security;

import org.springframework.context.annotation.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SpringSecurityConfig {

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().
                disable().authorizeHttpRequests(
                        (authorize) -> {
                            authorize.requestMatchers("/css/**", "/js/**").permitAll();
                            authorize.requestMatchers("/sign-up").permitAll();
                            authorize.requestMatchers("/sign-in*").permitAll();
                            authorize.anyRequest().authenticated();
                        }
                )
                .formLogin(
                        form -> form
                                .loginPage("/sign-in")
                                .loginProcessingUrl("/sign-in")
                                .defaultSuccessUrl("/task", true)
                                .permitAll()
                ).logout(
                        logout -> logout.logoutRequestMatcher(new AntPathRequestMatcher("/logout")
                        ).permitAll());
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }

}

