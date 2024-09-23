
public class Main {
    public static void main(String[] args) {

        String text = "someone cat organisation";

        System.out.println("Result: " + text.replaceAll("\\B\\w", "").replaceAll("\\s+", "").toUpperCase());
    }
}