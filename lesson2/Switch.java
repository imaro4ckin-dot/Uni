package lesson2;

public class Switch {
    public static void main(String[] args) {
        System.out.println(getGrade(85));
    }

    public static String getGrade(int score) {
        return switch (score / 10) {
            case 10, 9 -> "A";
            case 8     -> "B";
            case 7     -> "C";
            case 6     -> "D";
            default    -> "F";
        };
    }
}

