package cli;

/**
 * This is a demo for Java executable jar
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Env: NAME=" + System.getenv("NAME"));
        System.out.println("Property: cli.name=" + System.getProperty("cli.name"));
    }
}
