package org.demo;

import org.demo.domain.Player;
import org.springframework.boot.autoconfigure.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class Config {

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            EntityManagerFactoryBuilder builder, DataSource dataSource) {

        Map<String, Object> properties = new HashMap<>();

        properties.put("hibernate.search.default.directory_provider", "filesystem");
        properties.put("hibernate.search.default.indexBase", "/Users/rafal/indexes");
        properties.put("javax.persistence.schema-generation.database.action", "create");
        properties.put("javax.persistence.schema-generation.scripts.action", "drop-and-create");
        properties.put("javax.persistence.schema-generation.scripts.create-target", "scripts/createSchema.sql");
        properties.put("javax.persistence.schema-generation.scripts.drop-target", "scripts/dropSchema.sql");

        return builder
                .dataSource(dataSource)
                .packages(Player.class)
                .persistenceUnit("players")
                .properties(properties)
                .build();
    }

}
