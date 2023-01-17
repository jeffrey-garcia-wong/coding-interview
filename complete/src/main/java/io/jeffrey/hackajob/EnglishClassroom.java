package io.jeffrey.hackajob;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * <h1>English / Morse code translator</h1>
 */
class EnglishClassroom {

    static String execute(boolean translateMorse, String textToTranslate) {
        return solutionV1(translateMorse, textToTranslate);
    }

    static String solutionV1(boolean translateMorse, String textToTranslate) {
        if (translateMorse) {
            return translateMorseToEnglish(textToTranslate.toLowerCase());
        } else {
            return translateEnglishToMorse(textToTranslate.toLowerCase());
        }
    }

    static final String INVALID = "Invalid";

    private static final Map<String, Character> mMap = new HashMap<>();
    private static final Map<Character, String> nMap = new HashMap<>();

    static {
        nMap.put('a', ".-");
        nMap.put('b', "-...");
        nMap.put('c', "-.-.");
        nMap.put('d', "-..");
        nMap.put('e', ".");
        nMap.put('f', "..-.");
        nMap.put('g', "--.");
        nMap.put('h', "....");
        nMap.put('i', "..");
        nMap.put('j', ".---");
        nMap.put('k', "-.-");
        nMap.put('l', ".-..");
        nMap.put('m', "--");
        nMap.put('n', "-.");
        nMap.put('o', "---");
        nMap.put('p', ".--.");
        nMap.put('q', "--.-");
        nMap.put('r', ".-.");
        nMap.put('s', "...");
        nMap.put('t', "-");
        nMap.put('u', "..-");
        nMap.put('v', "...-");
        nMap.put('w', ".--");
        nMap.put('x', "-..-");
        nMap.put('y', "-.--");
        nMap.put('z', "--..");
        nMap.put('.', ".-.-.-");

        Set<Map.Entry<Character, String>> recordSet = nMap.entrySet();
        for (Map.Entry<Character, String> record: recordSet) {
            Character c = record.getKey();
            String s = record.getValue();
            mMap.put(s,c);
        }
    }

    static class DICT {
        private static Map<String, Character> mMap = EnglishClassroom.mMap;
        private static Map<Character, String> nMap = EnglishClassroom.nMap;

        static String mChar(Character eChar) {
            return nMap.get(eChar);
        }

        static Character eChar(String mChar) {
            return mMap.get(mChar);
        }
    }


    static String translateMorseToEnglish(String input) {
        StringBuilder output = new StringBuilder();
        StringBuilder tmp = new StringBuilder();
        int space = 0;

        for (int i=0; i<input.length(); i++) {
            char c = input.charAt(i);
            if (c == ' ') {
                if (tmp.length() > 0) {
                    String m = tmp.toString();
                    Character e = DICT.eChar(m);
                    if (e == null) return INVALID;
                    output.append(e);
                    tmp = new StringBuilder();
                }
                space += 1;

            } else {
                if (space > 0) {
                    if (space == 1) {
                        space = 0;
                    } else if (space % 3 == 0) {
                        for (int j=1; j<=(space/3); j++) {
                            output.append(" ");
                        }
                        space = 0;
                    } else {
                        return INVALID;
                    }
                }
                tmp.append(c);
            }
        }

        if (tmp.length() > 0) {
            String m = tmp.toString();
            Character e = DICT.eChar(m);
            if (e == null) return INVALID;
            output.append(e);
        }
        if (space > 0) {
            if (space % 3 == 0) {
                for (int j=1; j<=(space/3); j++) {
                    output.append(" ");
                }
            } else {
                return INVALID;
            }
        }

        return output.toString();
    }

    static String translateEnglishToMorse(String input) {
        StringBuilder output = new StringBuilder();
        int space = 0;
        for (int i=0; i<input.length(); i++) {
            char c = input.charAt(i);
            if (c == ' ') {
                space += 1;
            } else {
                if (space > 0) {
                    for (int j=1; j<=space; j++) {
                        output.append("   ");
                    }
                    space = 0;
                } else {
                    if (i >= 1) output.append(" ");
                }
                String m = DICT.mChar(c);
                if (m == null) return INVALID;
                output.append(m);
            }
        }

        if (space > 0) {
            for (int j=1; j<=space; j++) {
                output.append("   ");
            }
        }

        return output.toString();
    }
}
