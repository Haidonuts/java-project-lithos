public class TextUtil {
    private static final int TYPING_DELAY = 30;
    private static final int DOT_PAUSE = 500;
    private static final int CRACK_PAUSE = 1000;

    public static void type(String text) {
        for (char c : text.toCharArray()) {
            System.out.print(c);
            safeSleep(TYPING_DELAY);
        }
        System.out.println();
    }

    public static void typeDotCrack() {
        for (int i = 0; i < 4; i++) {
            System.out.print("Dot... ");
            safeSleep(DOT_PAUSE);
        }

        System.out.println();
        type("CRACK");
        safeSleep(CRACK_PAUSE);
    }

    private static void safeSleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
