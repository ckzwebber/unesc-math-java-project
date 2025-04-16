package utils;

public class MathUtilsTest {
    public static void main(String[] args) {
        double initialValue = 100.0;
        double discountPercentage = 20.0;
        double discountedValue = mathUtils.applyDiscount(initialValue, discountPercentage);
        System.out.println("Teste applyDiscount: Valor inicial = " + initialValue + 
                           ", Desconto = " + discountPercentage + "%, Resultado = " + discountedValue);
        // Esperado: 80.0


        double increasePercentage = 10.0;
        double increasedValue = mathUtils.applyIncrease(initialValue, increasePercentage);
        System.out.println("Teste applyIncrease: Valor inicial = " + initialValue + 
                           ", Aumento = " + increasePercentage + "%, Resultado = " + increasedValue);
        // Esperado: 110.0


        double total = 200.0;
        double percentage = 25.0;
        double part = mathUtils.calculatePercentageOfTotal(total, percentage);
        System.out.println("Teste calculatePercentageOfTotal: Total = " + total + 
                           ", Percentual = " + percentage + "%, Resultado = " + part);
        // Esperado: 50.0


        double partValue = 50.0;
        double percentageRep = mathUtils.calculatePercentageRepresentation(total, partValue);
        System.out.println("Teste calculatePercentageRepresentation: Total = " + total + 
                           ", Parte = " + partValue + ", Resultado = " + percentageRep + "%");
        // Esperado: 25.0


        double originalValue = 100.0;
        double finalValue = 80.0;
        double calcDiscount = mathUtils.calculateDiscountPercentage(originalValue, finalValue);
        System.out.println("Teste calculateDiscountPercentage: Valor original = " + originalValue + 
                           ", Valor com desconto = " + finalValue + ", Resultado = " + calcDiscount + "%");
        // Esperado: 20.0


        double initial = 100.0;
        double finalVal = 120.0;
        double difference = mathUtils.calculatePercentageDifference(initial, finalVal);
        System.out.println("Teste calculatePercentageDifference: Valor inicial = " + initial + 
                           ", Valor final = " + finalVal + ", Resultado = " + difference + "%");
        // Esperado: 20.0


        double discounted = 80.0;
        double discount = 20.0;
        double original = mathUtils.calculateOriginalValue(discounted, discount);
        System.out.println("Teste calculateOriginalValue: Valor com desconto = " + discounted + 
                           ", Desconto = " + discount + "%, Resultado = " + original);
        // Esperado: 100.0


        double a = 5.0;
        double b = 10.0;
        double r1 = 15.0;
        double resultRule = mathUtils.ruleOfThree(a, b, r1);
        System.out.println("Teste ruleOfThree: a = " + a + ", b = " + b + 
                           ", r1 = " + r1 + ", Resultado = " + resultRule);
        // Esperado: 30.0


        try {
            String password = mathUtils.generatePassword(true, true, true, true, 12);
            System.out.println("Teste generatePassword: Senha gerada = " + password);
            // Esperado: Uma senha de 12 caracteres com pelo menos 1 maiúscula, 1 minúscula, 1 número e 1 especial
        } catch (IllegalArgumentException e) {
            System.out.println("Erro em generatePassword: " + e.getMessage());
        }


        try {
            String password = mathUtils.generatePassword(false, true, false, false, 8);
            System.out.println("Teste generatePassword (só minúsculas): Senha gerada = " + password);
            // Esperado: Uma senha de 8 caracteres com apenas letras minúsculas
        } catch (IllegalArgumentException e) {
            System.out.println("Erro em generatePassword: " + e.getMessage());
        }


        try {
            String password = mathUtils.generatePassword(false, false, false, false, 8);
            System.out.println("Teste generatePassword (nenhum tipo): Senha gerada = " + password);
        } catch (IllegalArgumentException e) {
            System.out.println("Teste generatePassword (nenhum tipo): Erro esperado = " + e.getMessage());
            // Esperado: "Pelo menos um tipo de caractere deve ser selecionado."
        }


        try {
            String password = mathUtils.generatePassword(true, true, true, true, 3);
            System.out.println("Teste generatePassword (tamanho inválido): Senha gerada = " + password);
        } catch (IllegalArgumentException e) {
            System.out.println("Teste generatePassword (tamanho inválido): Erro esperado = " + e.getMessage());
            // Esperado: "O comprimento da senha deve ser pelo menos 4"
        }
    }
}