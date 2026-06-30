import java.nio.file.*;
import java.util.*;

public class NoLogs {
    public static void main(String[] args) throws Exception {
        String env = Files.readString(Path.of("env.txt"));

        Map<String, String> configs = Map.of(
            "dev", "dev-db.local",
            "prod", "prod-db.company.com"
        );

        if (!configs.containsKey(env)) {
            throw new RuntimeException("Database config not found");
        }

        System.out.println(configs.get(env));
    }
}