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
        String response = "A";
        System.out.println("If you want to convert from arabic to roman type A, otherwise type R");  
        if (sc.hasNextLine()){
            response = sc.nextLine().trim().toUpperCase();
        }
            if ( "A".equals(response)) {
                return Selection.A;
            }
            if( "R".equals(response)) {
                return Selection.R;
            }
            System.out.println("The response \"" + response + "\" is not valid, please type A or R");
            return getConversionSelection();
        
    }

    public static int getArabicNumberToConvert() {
        int response = 0;
        try {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please introduce the arabic number you want to convert");
        if(sc.hasNext()){
        response = sc.nextInt();
        }
        }
        catch(Exception e) {
            System.err.println("Input incorrect: " + e);
        }
            if(!checkArabicNumberErrors(response)) {
                return getArabicNumberToConvert();
            }
            System.out.println("Arabic number introduced: "+ response);
        return response;
    }

    public static String getRomanNumberToConvert() {
        Scanner sc = new Scanner(System.in);
        String response = "";
        System.out.println("Please introduce the roman number you want to convert");        
        if(sc.hasNextLine()){
        response = sc.nextLine().trim();
        if(!allCharactersAreValid(response)) {
            System.out.println(Errors.unknownCharacterError);
        }
    }
    System.out.println("Roman number introduced: "+ response);
        return response;
    }

    private static boolean checkArabicNumberErrors(int arabic) {
        if (arabic < 1) {
            System.err.println(Errors.smallerThanOneNotAllowed);
            return false;
        }
        if (arabic >= 10000000) {
            System.err.println(Errors.tenMillionOrBigger);
            return false;
        }
        return true;
    }

    
    private static boolean allCharactersAreValid(String roman) {
        return IntStream.range(0, roman.length()).mapToObj(roman::charAt).allMatch(r -> Arrays.asList(romanLetters).contains(r.toString()));
    }
}
