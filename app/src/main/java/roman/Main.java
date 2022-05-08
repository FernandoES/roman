/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package roman;

public class Main {

    public static void main(String[] args) {
        ArabicToRomanConverter converter = new ArabicToRomanConverter();
        String romanNumber = converter.convertArabicToRoman(12);
        System.out.println(romanNumber);

        RomanToArabicConverter romanConverter = new RomanToArabicConverter();
        int arabicNumber = romanConverter.convertRomanNumberToArabic("ciCXXIII");
        System.out.println(arabicNumber);
    }
}
