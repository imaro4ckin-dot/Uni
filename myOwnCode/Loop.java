package myOwnCode;

public class Loop {
    public static void main(String[] args) {
        String message = "Java Programming is Fun";
        String filteredMessage = "";
        int vowelCount = 0;

        System.out.println("Original: " + message);

        // A loop that runs through every character of the String

        for (int i = 0; i < message.length(); i++) {
            char letter = message.charAt(i);

            // 1. Check if the character is a vowel (case-insensitive)
            char lowerLetter = Character.toLowerCase(letter);
            if (lowerLetter == 'a' || lowerLetter == 'e' || lowerLetter == 'i'
                    || lowerLetter == 'o' || lowerLetter == 'u') {
                vowelCount++;
            }

            // 2. Build a new string: Replace spaces with underscores
            if (letter == ' ') {
                filteredMessage += "_";
            } else {
                filteredMessage += letter;
            }
        }

        System.out.println("Modified: " + filteredMessage);
        System.out.println("Vowel count: " + vowelCount);
    }
}