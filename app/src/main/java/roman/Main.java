/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package roman;

import roman.UserInteractor.Selection;

public class Main {

    public static void main(String[] args) {
        if ( UserInteractor.getConversionSelection() == Selection.A) {
            int arabic =UserInteractor.getArabicNumberToConvert();
            ArabicToRomanConverter converter = new ArabicToRomanConverter();
            String romanNumber = converter.convertArabicToRoman(arabic);
            System.out.println(romanNumber);
        }
        else {
            String roman = UserInteractor.getRomanNumberToConvert();
            RomanToArabicConverter romanConverter = new RomanToArabicConverter();
            int arabicNumber = romanConverter.convertRomanNumberToArabic(roman);
            System.out.println(arabicNumber);
        }
    }
}
