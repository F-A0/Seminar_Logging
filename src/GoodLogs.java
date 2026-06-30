    import java.nio.file.*;
    import java.util.*;

    private static final Logger logger =
        LoggerFactory.getLogger(Main.class);

    public class GoodLogs {
        public static void main(String[] args) throws Exception {
            String env = Files.readString(Path.of("env.txt"));

            Map<String, String> configs = Map.of(
                "dev", "dev-db.local",
                "prod", "prod-db.company.com"
            );

            System.out.println("Requested environment: '" + env + "'");
            System.out.println("Environment length: " + env.length());
            System.out.println("Available configs: " + configs.keySet());
            if (!configs.containsKey(env)) {
                System.out.println("No config found for requested environment.");
                throw new RuntimeException("Database config not found");
            }
            
            System.out.println(configs.get(env));
        }
    }