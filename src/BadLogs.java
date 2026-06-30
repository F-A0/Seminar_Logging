import java.nio.file.*;
import java.util.*;

public class BadLogs {
    public static void main(String[] args) throws Exception {
        String env = Files.readString(Path.of("env.txt"));

        Map<String, String> configs = Map.of(
            "dev", "dev-db.local",
            "prod", "prod-db.company.com"
        );

        System.out.println("Loading database config...");

        if (!configs.containsKey(env)) {
            System.out.println("Database config missing.");
            throw new RuntimeException("Database config not found");
        }

        System.out.println("Database config loaded.");
        System.out.println(configs.get(env));
    }
}