package roman;

import java.util.Scanner;

public class UserInteractor {

    public enum Selection {
        A,R
    }

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
        return response;
    }

    public static String getRomanNumberToConvert() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please introduce the roman number you want to convert");
        String response = sc.nextLine().trim();
        return response;
    }
}
