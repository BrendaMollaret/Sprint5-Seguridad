package desarrollo.sprint5.apiresttest.Config;

import desarrollo.sprint5.apiresttest.Jwt.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationProvider authProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
    {
        return http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(authRequest ->
                                authRequest
                                        //Rutas publicas:
                                        .requestMatchers(new AntPathRequestMatcher("/auth/register")).permitAll() //Registro Cliente
                                        .requestMatchers(new AntPathRequestMatcher("/auth/login")).permitAll() //Login general
                                        .requestMatchers(new AntPathRequestMatcher("/api/v1/articuloInsumo/paged")).permitAll() //de articuloInsumo
                                        .requestMatchers(new AntPathRequestMatcher("api/v1/articuloInsumo/searchByNombre")).permitAll()
                                        .requestMatchers(new AntPathRequestMatcher("api/v1/articuloInsumo/searchByRubroNombre")).permitAll()
                                        .requestMatchers(new AntPathRequestMatcher("/api/v1/articuloManufacturado/paged")).permitAll() //de articuloManufactura
                                        .requestMatchers(new AntPathRequestMatcher("api/v1/articuloManufacturado/searchByNombre")).permitAll()
                                        .requestMatchers(new AntPathRequestMatcher("api/v1/articuloManufacturado/searchByPrecioVentaRange")).permitAll()
                                        .requestMatchers(new AntPathRequestMatcher("api/v1/articuloManufacturado/searchByCategoriaNombre")).permitAll()
                                        .requestMatchers(new AntPathRequestMatcher("/api/v1/rubro/paged")).permitAll() //de rubro
                                        .requestMatchers(new AntPathRequestMatcher("/api/v1/rubro/searchByNombre")).permitAll()
                                        .requestMatchers(new AntPathRequestMatcher("/api/v1/CategoriaArticuloManufacturado/paged")).permitAll() //de categoriaArticuloManufacturado
                                        .requestMatchers(new AntPathRequestMatcher("/api/v1/Localidad/paged")).permitAll() //de Localidad
                                        .requestMatchers(new AntPathRequestMatcher("/api/v1/UnidadMedida/paged")).permitAll() //de UnidadMedida

                                        //Consola H2:
                                        .requestMatchers(PathRequest.toH2Console()).permitAll()

                                        //Segun el rol
                                        .requestMatchers(new AntPathRequestMatcher("/api/v1/cliente/showProfile")).hasAnyAuthority( "CLIENTE", "CAJERO", "COCINERO","DELIVERY")
                                        .requestMatchers(new AntPathRequestMatcher("/api/v1/cliente/updateCliente")).hasAnyAuthority("CLIENTE", "CAJERO", "COCINERO","DELIVERY")

                                        .requestMatchers(new AntPathRequestMatcher("/auth/registerEmployee")).hasAuthority("ADMIN") //Autenticacion


                )
                .headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable)) //H2
                .sessionManagement(sessionManager->
                        sessionManager
                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .authenticationProvider(authProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();


    }

}
