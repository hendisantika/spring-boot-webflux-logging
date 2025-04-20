package id.my.hendisantika.webfluxlogging.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.web.server.WebFilter;
import org.zalando.logbook.Logbook;
import org.zalando.logbook.autoconfigure.webflux.LogbookWebFluxAutoConfiguration;
import org.zalando.logbook.spring.webflux.LogbookWebFilter;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-webflux-logging
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 20/04/25
 * Time: 19.52
 * To change this template use File | Settings | File Templates.
 */
@Import(LogbookWebFluxAutoConfiguration.class)
public class LogbookConfiguration {
    @Bean
    public WebFilter logbookFilter(Logbook logbook) {
        return new LogbookWebFilter(logbook);
    }
}
