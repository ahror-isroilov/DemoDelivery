package demo.delivery_project.common.configuration;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.conf.RenderQuotedNames;
import org.jooq.conf.Settings;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


@Configuration
public class JooqConfig {

    @Autowired
    DataSource dataSource;

    @Bean
    public DSLContext dsl() {
        Settings settings = new Settings().withRenderQuotedNames(RenderQuotedNames.NEVER);
        return DSL.using(dataSource, SQLDialect.POSTGRES, settings);
    }
}
