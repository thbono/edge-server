package br.com.unicoob.edge.infrastructure;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.filter.CorsFilter;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class UnicoobCorsFilter extends CorsFilter {

    private static final long MAX_AGE = 1800L;

    public UnicoobCorsFilter() {
        super(httpServletRequest -> {
                final CorsConfiguration corsConfiguration = new CorsConfiguration();

                corsConfiguration.addAllowedOrigin(httpServletRequest.getHeader("origin"));

                corsConfiguration.addAllowedMethod(HttpMethod.POST);
                corsConfiguration.addAllowedMethod(HttpMethod.PUT);
                corsConfiguration.addAllowedMethod(HttpMethod.GET);
                corsConfiguration.addAllowedMethod(HttpMethod.OPTIONS);
                corsConfiguration.addAllowedMethod(HttpMethod.DELETE);
                corsConfiguration.addAllowedMethod(HttpMethod.PATCH);

                corsConfiguration.addAllowedHeader("x-requested-with");
                corsConfiguration.addAllowedHeader("authorization");
                corsConfiguration.addAllowedHeader("content-type");
                corsConfiguration.addAllowedHeader("x-auth-token");

                corsConfiguration.setMaxAge(MAX_AGE);
                corsConfiguration.setAllowCredentials(Boolean.TRUE);

                return corsConfiguration;
            }
        );
    }

}
