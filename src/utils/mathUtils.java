package utils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class mathUtils {

    public static double applyDiscount(double initialValue, double discountPercentage) {
        return initialValue - (initialValue * (discountPercentage / 100));
    }

    public static double applyIncrease(double initialValue, double increasePercentage) {
        return initialValue * (1 + (increasePercentage / 100));
    }

    public static double calculatePercentageOfTotal(double total, double percentage) {
        return (total * percentage) / 100;
    }

    public static double calculatePercentageRepresentation(double total, double part) {
        return (part / total) * 100;
    }

    public static double calculateDiscountPercentage(double originalValue, double discountedValue) {
        return ((originalValue - discountedValue) / originalValue) * 100;
    }

    public static double calculatePercentageDifference(double initialValue, double finalValue) {
        return ((finalValue - initialValue) / initialValue) * 100;
    }

    public static double calculateOriginalValue(double finalValue, double discountPercentage) {
        return (finalValue * 100 / (100 - discountPercentage));
    }

    public static double ruleOfThree(double a, double b, double r1) {
        return (b * r1) / a;
    }

    public static String generatePassword(boolean includeUppercase, boolean includeLowercase, 
                                          boolean includeNumbers, boolean includeSpecialChars, int length) {
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String special = "!@#$%^&*()-_=+[{]}\\|;:'\",<.>/?";
        
        StringBuilder pool = new StringBuilder();
        if (includeUppercase) pool.append(upper);
        if (includeLowercase) pool.append(lower);
        if (includeNumbers) pool.append(numbers);
        if (includeSpecialChars) pool.append(special);
        
        if (pool.length() == 0) {
            throw new IllegalArgumentException("Pelo menos um tipo de caractere deve ser selecionado.");
        }

        int typesSelected = 0;
        if (includeUppercase) typesSelected++;
        if (includeLowercase) typesSelected++;
        if (includeNumbers) typesSelected++;
        if (includeSpecialChars) typesSelected++;
    
        if (length < typesSelected) {
            throw new IllegalArgumentException("O comprimento da senha deve ser pelo menos " + typesSelected);
        }
        
        Random random = new Random();
        List<Character> passwordList = new ArrayList<>();
    
        if (includeUppercase) {
            passwordList.add(upper.charAt(random.nextInt(upper.length())));
        }
        if (includeLowercase) {
            passwordList.add(lower.charAt(random.nextInt(lower.length())));
        }
        if (includeNumbers) {
            passwordList.add(numbers.charAt(random.nextInt(numbers.length())));
        }
        if (includeSpecialChars) {
            passwordList.add(special.charAt(random.nextInt(special.length())));
        }
    
        for (int i = passwordList.size(); i < length; i++) {
            int index = random.nextInt(pool.length());
            passwordList.add(pool.charAt(index));
        }
    
        Collections.shuffle(passwordList);
    
        StringBuilder password = new StringBuilder();
        for (char c: passwordList) {
            password.append(c);
        }
        
        return password.toString();
    }
}