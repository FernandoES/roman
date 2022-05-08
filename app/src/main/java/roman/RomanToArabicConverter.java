package roman;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RomanToArabicConverter {

    public RomanToArabicConverter(){
        initRomanToArabicDigitRelation();
    }

    private final Map<Character, Integer> romanToArabicDigitRelation = new HashMap<>();

    public int convertRomanNumberToArabic(String roman) {
        
        List<Integer> digits = roman.chars().mapToObj(r -> romanToArabicDigitRelation.get((char)r)).collect(Collectors.toList());
        return IntStream.range(0, digits.size()).mapToObj(index -> digits.get(index) * addOrSubstractDigit(digits, index)).reduce(0, (a,b) -> a + b);        
    }

    private int addOrSubstractDigit(List<Integer> digits, int index) {
        if (digits.size() == index + 1) {
            return 1;
        }
        return  digits.get(index) >= digits.get(index + 1) ?  1 : -1;
    }

    private void initRomanToArabicDigitRelation() {
            romanToArabicDigitRelation.put( 'I', 1);
            romanToArabicDigitRelation.put('V', 5);
            romanToArabicDigitRelation.put('X', 10);
            romanToArabicDigitRelation.put('L', 50);
            romanToArabicDigitRelation.put('C', 100);
            romanToArabicDigitRelation.put('D', 500);
            romanToArabicDigitRelation.put('M', 1000);
            romanToArabicDigitRelation.put('i', 1000);
            romanToArabicDigitRelation.put('v', 5000);
            romanToArabicDigitRelation.put('x', 10000);
            romanToArabicDigitRelation.put('l', 50000);
            romanToArabicDigitRelation.put('c', 100000);
            romanToArabicDigitRelation.put('d', 500000);
            romanToArabicDigitRelation.put('m', 1000000);
    }
}
