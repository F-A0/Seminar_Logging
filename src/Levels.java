import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Levels {

    private static final Logger logger =
        LoggerFactory.getLogger(Levels.class);

    public static void main(String[] args) throws Exception {
        String env = readResource("env.txt");

        Map<String, String> configs = Map.of(
            "dev", "dev-db.local",
            "prod", "prod-db.company.com"
        );

        logger.debug("Raw env value: '{}', length={}", env, env.length());
        logger.info("Environment loaded");
        logger.debug("Available configs: {}", configs.keySet());

        if (!configs.containsKey(env)) {
            logger.error("No config found for requested environment: '{}'", env);
            throw new RuntimeException("Database config not found");
        }

        logger.info("Using database config for environment '{}'", env);
        System.out.println(configs.get(env));
    }

    private static String readResource(String name) throws Exception {
        try (InputStream input =
                 Levels.class.getClassLoader().getResourceAsStream(name)) {

            if (input == null) {
                throw new IllegalArgumentException("Resource not found: " + name);
            }

            return new String(input.readAllBytes(), StandardCharsets.UTF_8);
        }
    }
}