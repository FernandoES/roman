package roman;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class UserInteractor {

    public enum Selection {
        A,R
    }

    public static String[] romanLetters = {"I", "V", "X", "L", "C", "D", "M", "i", "v", "x", "l", "c", "d", "m"};

    public static Selection getConversionSelection() {
        Scanner sc = new Scanner(System.in);
        System.out.print("If you want to convert from arabic to roman type A, otherwise type R");  
        String response = sc.nextLine().trim().toUpperCase();
        if ( "A".equals(response)) {
            return Selection.A;
        }
        if( "R".equals(response)) {
            return Selection.R;
        }
        System.out.println("The response is not valid, please type A or R");
        return getConversionSelection();
    }

    public static int getArabicNumberToConvert() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please introduce the arabic number you want to convert");
        int response = sc.nextInt();
        if(checkARabicNumberErrors(response)) {
            return getArabicNumberToConvert();
        }
        return response;
    }

    public static String getRomanNumberToConvert() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please introduce the roman number you want to convert");
        String response = sc.nextLine().trim();
        if(!allCharactersAreValid(response)) {
            System.out.println(Errors.unknownCharacterError);
        }
        return response;
    }

    private static boolean checkARabicNumberErrors(int arabic) {
        if (arabic < 1) {
            System.err.println(Errors.smallerThanOneNotAllowed);
            return false;
        }
        if (arabic >= 10000000) {
            System.err.print(Errors.tenMillionOrBigger);
            return false;
        }
        return true;
    }

    
    private static boolean allCharactersAreValid(String roman) {
        return IntStream.range(0, roman.length()).mapToObj(roman::charAt).allMatch(r -> Arrays.asList(romanLetters).contains(r.toString()));
    }
}
