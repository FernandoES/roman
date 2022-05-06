package roman;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RomanToArabicConverter {
    private final String[] pseudoCodeRoman = {"","s","ss","sss","sf","f","fs","fss","fsss","st"};
    private final List<Map<String, String>> pseudToRomanRelation = new ArrayList<Map<String, String>>();
    
    public RomanToArabicConverter() {
        initPseudoRomanRelation();
    }

    public String convertArabicToRoman(int arabic) {
        List<String> pseudoRoman = convertArabicToPseudoRoman(12);
        return convertPseudoRomanToRoman(pseudoRoman);
    }

    public List<String> convertArabicToPseudoRoman(int arabic) {
        IntStream  digits = Integer.toString(arabic).chars();
        return digits.mapToObj(num -> (pseudoCodeRoman[Character.getNumericValue(num)])).collect(Collectors.toList());
    }

    public String convertPseudoRomanToRoman(List<String> pseudo) {
        return IntStream.range(0, pseudo.size()).mapToObj(index -> (convertPseudoRomanSingleDigit(pseudo.get(index), pseudo.size() - index -1))).collect(Collectors.joining(""));
    }

    private String convertPseudoRomanSingleDigit(String pseudoDigit, int position) {
        return pseudoDigit.chars().mapToObj(letter -> pseudToRomanRelation.get(position).get(Character.toString(letter))).collect(Collectors.joining(""));
    }

    private void initPseudoRomanRelation() {
        pseudToRomanRelation.add( new HashMap<String, String>() {{
            put("s", "I");
            put("f", "V");
            put("t", "X");
        }});
        pseudToRomanRelation.add( new HashMap<String, String>() {{
            put("s", "X");
            put("f", "L");
            put("t", "C");
        }});
        pseudToRomanRelation.add( new HashMap<String, String>() {{
            put("s", "C");
            put("f", "D");
            put("t", "M");
        }});
        pseudToRomanRelation.add( new HashMap<String, String>() {{
            put("s", "|I");
            put("f", "|V");
            put("t", "|X");
        }});
        pseudToRomanRelation.add( new HashMap<String, String>() {{
            put("s", "|X");
            put("f", "|L");
            put("t", "|C");
        }});
        pseudToRomanRelation.add( new HashMap<String, String>() {{
            put("s", "|C");
            put("f", "|D");
            put("t", "|M");
        }});
    }
}