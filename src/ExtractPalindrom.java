

import java.util.*;

class ExtractPalindrom {


    public static void main(String[] args) {
        startGame();
    }


    public static void startGame() {
        List<String> inputStrings = new ArrayList<>(Arrays.asList("Gimli", "Fili", "Ilif", "Ilmig", "Mark"));
        Set<String> output = getPalindroms(inputStrings);
        printResults(output);
    }

    public static Set<String> getPalindroms(final List<String> originalString) {
        final Set<String> returnVal;

        if (originalString != null && originalString.size() > 0) {

            returnVal = getMatchingCombinations("", originalString);

        } else {
            returnVal = new HashSet<>();
        }
        return returnVal;
    }

    private static Set<String> getMatchingCombinations(final String prefix,
                                                       final List<String> initialString) {
        final String prefixToUse = (prefix == null) ? "" : prefix;

        Set<String> valToReturn = new HashSet<>();
        if (initialString != null) {
            //System.out.println("initialString : " + initialString);
            for (int i = 0; i < initialString.size(); i++) {
                String suffix = initialString.get(i);
                if (suffix != null && suffix.length() > 0) {
                    //System.out.println("suffix : " + suffix);
                    String newCombination = prefixToUse + suffix;
                    // System.out.println("newCombination : " + newCombination);

                    if (palindromeCheck(newCombination)) {
                        valToReturn.add(newCombination);
                        //System.out.println("plindrom match " + valToReturn);
                    }

                    if (initialString.size() > 1) {
                        List<String> newList = new ArrayList<>(initialString);
                        newList.remove(i);
                        valToReturn.addAll(getMatchingCombinations(newCombination, newList));
                        //System.out.println("valToReturn " + valToReturn);
                    }
                }
            }

        }
        return valToReturn;
    }

    private static boolean palindromeCheck(String incomingCombination) {
        boolean valToReturn = false;
        if (incomingCombination != null && incomingCombination.length() > 0) {
            StringBuilder compare = new StringBuilder(incomingCombination.toLowerCase());

            if(compare.toString().equals(compare.reverse().toString()))
                valToReturn = true;
        }
        return valToReturn;
    }

    private static void printResults(Set<String> finalPalindroms) {

        if (finalPalindroms == null || finalPalindroms.size() == 0) {
            System.out.println(" No palindromes Found");
        } else {

            System.out.println(" Total Number of Palindrom is: " + finalPalindroms.size() + " and are given below");
            for (String palindrom : finalPalindroms) {
                System.out.println(palindrom);
            }
        }
    }

}
