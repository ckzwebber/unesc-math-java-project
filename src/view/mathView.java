package view;
import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import utils.mathUtils;

public class mathView extends JFrame {

    private JPanel pnlDiscount;
    private JLabel lblDiscountStart, lblDiscount, lblDiscountResult;
    private JTextField txfDiscountStart, txfDiscount, txfDiscountResult;

    private JPanel pnlIncrease;
    private JLabel lblIncreaseStart, lblIncrease, lblIncreaseResult;
    private JTextField txfIncreaseStart, txfIncrease, txfIncreaseResult;

    private JPanel pnlSampling;
    private JLabel lblSamplingStart, lblSampling, lblSamplingResult;
    private JTextField txfSamplingStart, txfSampling, txfSamplingResult;

    private JPanel pnlSampling2;
    private JLabel lblSamplingStart2, lblSampling2, lblSamplingResult2;
    private JTextField txfSamplingStart2, txfSampling2, txfSamplingResult2;

    private JPanel pnlWhichDiscount;
    private JLabel lblWhichDiscountStart, lblWhichDiscount, lblWhichDiscountResult;
    private JTextField txfWhichDiscountStart, txfWhichDiscount, txfWhichDiscountResult;

    private JPanel pnlDeltaVariation;
    private JLabel lblDeltaVariationStart, lblDeltaVariation, lblDeltaVariationResult;
    private JTextField txfDeltaVariationStart, txfDeltaVariation, txfDeltaVariationResult;

    private JPanel pnlOriginalValue;
    private JLabel lblOriginalValueStart, lblOriginalValue, lblOriginalValueResult;
    private JTextField txfOriginalValueStart, txfOriginalValue, txfOriginalValueResult;

    private JPanel pnlRuleOfThree;
    private JLabel lblRuleOfThreeA, lblRuleOfThreeB, lblRuleOfThreeR1, lblRuleOfThreeR2;
    private JTextField txfRuleOfThreeA, txfRuleOfThreeB, txfRuleOfThreeR1, txfRuleOfThreeR2;

    private JPanel pnlPasswordGenerator;
    private JCheckBox chkPasswordUppercase, chkPasswordLowercase, chkPasswordNumbers, chkPasswordSpecialChars;
    private JLabel lblPasswordLength;
    private JButton btnGeneratePassword;
    private JTextField txfPasswordResult;
    private JSpinner spnPasswordLength;

    private void addInputListeners() {
        DocumentListener discountListener = new DocumentListener() {
            public void insertUpdate(DocumentEvent e) { applyDiscount(); }
            public void removeUpdate(DocumentEvent e) { applyDiscount(); }
            public void changedUpdate(DocumentEvent e) { applyDiscount(); }
        };
        txfDiscountStart.getDocument().addDocumentListener(discountListener);
        txfDiscount.getDocument().addDocumentListener(discountListener);

        DocumentListener increaseListener = new DocumentListener() {
            public void insertUpdate(DocumentEvent e) { applyIncrease(); }
            public void removeUpdate(DocumentEvent e) { applyIncrease(); }
            public void changedUpdate(DocumentEvent e) { applyIncrease(); }
        };
        txfIncreaseStart.getDocument().addDocumentListener(increaseListener);
        txfIncrease.getDocument().addDocumentListener(increaseListener);
        
        DocumentListener samplingListener = new DocumentListener() {
            public void insertUpdate(DocumentEvent e) { applySampling(); }
            public void removeUpdate(DocumentEvent e) { applySampling(); }
            public void changedUpdate(DocumentEvent e) { applySampling(); }
        };
        txfSamplingStart.getDocument().addDocumentListener(samplingListener);
        txfSampling.getDocument().addDocumentListener(samplingListener);

        DocumentListener sampling2Listener = new DocumentListener() {
            public void insertUpdate(DocumentEvent e) { applySampling2(); }
            public void removeUpdate(DocumentEvent e) { applySampling2(); }
            public void changedUpdate(DocumentEvent e) { applySampling2(); }
        };
        txfSamplingStart2.getDocument().addDocumentListener(sampling2Listener);
        txfSampling2.getDocument().addDocumentListener(sampling2Listener);
        
        DocumentListener whichDiscountListener = new DocumentListener() {
            public void insertUpdate(DocumentEvent e) { applyWhichDiscount(); }
            public void removeUpdate(DocumentEvent e) { applyWhichDiscount(); }
            public void changedUpdate(DocumentEvent e) { applyWhichDiscount(); }
        };
        txfWhichDiscountStart.getDocument().addDocumentListener(whichDiscountListener);
        txfWhichDiscount.getDocument().addDocumentListener(whichDiscountListener);

        DocumentListener deltaVariationListener = new DocumentListener() {
            public void insertUpdate(DocumentEvent e) { applyDeltaVariation(); }
            public void removeUpdate(DocumentEvent e) { applyDeltaVariation(); }
            public void changedUpdate(DocumentEvent e) { applyDeltaVariation(); }
        };
        txfDeltaVariationStart.getDocument().addDocumentListener(deltaVariationListener);
        txfDeltaVariation.getDocument().addDocumentListener(deltaVariationListener);

        DocumentListener originalValueListener = new DocumentListener() {
            public void insertUpdate(DocumentEvent e) { applyOriginalValue(); }
            public void removeUpdate(DocumentEvent e) { applyOriginalValue(); }
            public void changedUpdate(DocumentEvent e) { applyOriginalValue(); }
        };
        txfOriginalValueStart.getDocument().addDocumentListener(originalValueListener);
        txfOriginalValue.getDocument().addDocumentListener(originalValueListener);

        DocumentListener ruleOfThreeListener = new DocumentListener() {
            public void insertUpdate(DocumentEvent e) { applyRuleOfThree(); }
            public void removeUpdate(DocumentEvent e) { applyRuleOfThree(); }
            public void changedUpdate(DocumentEvent e) { applyRuleOfThree(); }
        };
        txfRuleOfThreeA.getDocument().addDocumentListener(ruleOfThreeListener);
        txfRuleOfThreeB.getDocument().addDocumentListener(ruleOfThreeListener);
        txfRuleOfThreeR1.getDocument().addDocumentListener(ruleOfThreeListener);
    }

    private void applyDiscount() {
        String strValue = txfDiscountStart.getText().replace(",", ".");
        String strDiscount = txfDiscount.getText().replace(",", ".");
        try {
            double value = Double.parseDouble(strValue);
            double discount = Double.parseDouble(strDiscount);

           if(value > 999999999 || discount > 999999999) {
                txfDiscountResult.setText("Valor muito alto!");
                return;
            }

            double result = mathUtils.applyDiscount(value, discount);
            txfDiscountResult.setText(String.format("%.2f", result));
        } catch (NumberFormatException ex) {
            txfDiscountResult.setText("Entrada inválida!");
        }
    }

    private void applyIncrease() {
        String strValue = txfIncreaseStart.getText().replace(",", ".");
        String increaseStr = txfIncrease.getText().replace(",", ".");
        try {
            double value = Double.parseDouble(strValue);
            double increase = Double.parseDouble(increaseStr);

            if(value > 999999999 || increase > 999999999) {
                txfIncreaseResult.setText("Valor muito alto!");
                return;
            }

            double result = mathUtils.applyIncrease(value, increase);
            txfIncreaseResult.setText(String.format("%.2f", result));
        } catch (NumberFormatException ex) {
            txfIncreaseResult.setText("Entrada inválida!");
        }
    }

    private void applySampling() {
        String strValue = txfSamplingStart.getText().replace(",", ".");
        String strPercentage = txfSampling.getText().replace(",", ".");
        try {
            double value = Double.parseDouble(strValue);
            double percentage = Double.parseDouble(strPercentage);

            if(value > 999999999 || percentage > 999999999) {
                txfSamplingResult.setText("Valor muito alto!");
                return;
            }

            double result = mathUtils.calculatePercentageOfTotal(value, percentage);
            txfSamplingResult.setText(String.format("%.2f", result));
        } catch (NumberFormatException ex) {
            txfSamplingResult.setText("Entrada inválida!");
        }
    }

    private void applySampling2() {
        String strValue = txfSamplingStart2.getText().replace(",", ".");
        String strPart = txfSampling2.getText().replace(",", ".");
        try {
            double value = Double.parseDouble(strValue);
            double part = Double.parseDouble(strPart);

            if(value > 999999999 || part > 999999999) {
                txfSamplingResult2.setText("Valor muito alto!");
                return;
            }

            double result = mathUtils.calculatePercentageRepresentation(value, part);
            txfSamplingResult2.setText(String.format("%.2f", result));
        } catch (NumberFormatException ex) {
            txfSamplingResult2.setText("Entrada inválida!");
        }
    }

    private void applyWhichDiscount() {
        String strOriginalValue = txfWhichDiscountStart.getText().replace(",", ".");
        String strDiscountedValue = txfWhichDiscount.getText().replace(",", ".");
        try {
            double originalValue = Double.parseDouble(strOriginalValue);
            double discountedValue = Double.parseDouble(strDiscountedValue);

            if(originalValue > 999999999 || discountedValue > 999999999) {
                txfWhichDiscountResult.setText("Valor muito alto!");
                return;
            }

            double result = mathUtils.calculateDiscountPercentage(originalValue, discountedValue);
            txfWhichDiscountResult.setText(String.format("%.2f", result));
        } catch (NumberFormatException ex) {
            txfWhichDiscountResult.setText("Entrada inválida!");
        }
    }

    private void applyDeltaVariation() {
        String strInitialValue = txfDeltaVariationStart.getText().replace(",", ".");
        String strFinalValue = txfDeltaVariation.getText().replace(",", ".");
        try {
            double initialValue = Double.parseDouble(strInitialValue);
            double finalValue = Double.parseDouble(strFinalValue);

            if(initialValue > 999999999 || finalValue > 999999999) {
                txfDeltaVariationResult.setText("Valor muito alto!");
                return;
            }

            double result = mathUtils.calculatePercentageDifference(initialValue, finalValue);
            txfDeltaVariationResult.setText(String.format("%.2f", result));
        } catch (NumberFormatException ex) {
            txfDeltaVariationResult.setText("Entrada inválida!");
        }
    }

    private void applyOriginalValue() {
        String strFinalValue = txfOriginalValueStart.getText().replace(",", ".");
        String strDiscountPercentage = txfOriginalValue.getText().replace(",", ".");
        try {
            double finalValue = Double.parseDouble(strFinalValue);
            double discountPercentage = Double.parseDouble(strDiscountPercentage);

            if(finalValue > 999999999 || discountPercentage > 999999999) {
                txfOriginalValueResult.setText("Valor muito alto!");
                return;
            }

            double result = mathUtils.calculateOriginalValue(finalValue, discountPercentage);
            txfOriginalValueResult.setText(String.format("%.2f", result));
        } catch (NumberFormatException ex) {
            txfOriginalValueResult.setText("Entrada inválida!");
        }
    }

    private void applyRuleOfThree() {
        String strA = txfRuleOfThreeA.getText().replace(",", ".");
        String strB = txfRuleOfThreeB.getText().replace(",", ".");
        String strR1 = txfRuleOfThreeR1.getText().replace(",", ".");
        try {
            double a = Double.parseDouble(strA);
            double b = Double.parseDouble(strB);
            double r1 = Double.parseDouble(strR1);

            if(a > 999999999 || b > 999999999 || r1 > 999999999) {
                txfRuleOfThreeR2.setText("Valor muito alto!");
                return;
            }

            double result = mathUtils.ruleOfThree(a, b, r1);
            txfRuleOfThreeR2.setText(String.format("%.2f", result));
        } catch (NumberFormatException ex) {
            txfRuleOfThreeR2.setText("Entrada inválida!");
        }
    }

    public mathView () {
        setTitle("Calculos Matemáticos");
        setSize(1470, 700);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        createComponents();
        setVisible(true);
    }

    private void createComponents() {

        pnlDiscount = new JPanel();
        pnlDiscount.setBounds(15, 15, 350, 150);
        pnlDiscount.setLayout(null);
        pnlDiscount.setBorder(BorderFactory.createTitledBorder("Aplicar Desconto % Num Valor"));
        getContentPane().add(pnlDiscount);

        lblDiscountStart = new JLabel("Valor Inicial R$: ");
        lblDiscountStart.setBounds(75, 35, 100, 20);
        lblDiscountStart.setForeground(Color.RED);
        pnlDiscount.add(lblDiscountStart);

        txfDiscountStart = new JTextField();
        txfDiscountStart.setBounds(175, 35, 150, 20);
        txfDiscountStart.setBackground(new Color(254, 220, 220));
        pnlDiscount.add(txfDiscountStart);

        lblDiscount = new JLabel("Desconto %: ");
        lblDiscount.setBounds(95, 75, 100, 20);
        lblDiscount.setForeground(Color.BLUE);
        pnlDiscount.add(lblDiscount);

        txfDiscount = new JTextField();
        txfDiscount.setBounds(175, 75, 150, 20);
        txfDiscount.setBackground(new Color(211, 228, 255));
        pnlDiscount.add(txfDiscount);

        lblDiscountResult = new JLabel("Resultado R$: ");
        lblDiscountResult.setBounds(85, 115, 100, 20);
        lblDiscountResult.setForeground(Color.BLACK);
        pnlDiscount.add(lblDiscountResult);

        txfDiscountResult = new JTextField();
        txfDiscountResult.setBounds(175, 115, 150, 20);
        txfDiscountResult.setBackground(Color.LIGHT_GRAY);
        txfDiscountResult.setEditable(false);
        pnlDiscount.add(txfDiscountResult);

        pnlIncrease = new JPanel();
        pnlIncrease.setBounds(380, 15, 350, 150);
        pnlIncrease.setLayout(null);
        pnlIncrease.setBorder(BorderFactory.createTitledBorder("Incrementar % a um Valor"));
        getContentPane().add(pnlIncrease);

        lblIncreaseStart = new JLabel("Valor Inicial R$: ");
        lblIncreaseStart.setBounds(75, 35, 100, 20);
        lblIncreaseStart.setForeground(Color.RED);
        pnlIncrease.add(lblIncreaseStart);

        txfIncreaseStart = new JTextField();
        txfIncreaseStart.setBounds(175, 35, 150, 20);
        txfIncreaseStart.setBackground(new Color(254, 220, 220));
        pnlIncrease.add(txfIncreaseStart);

        lblIncrease = new JLabel("Acréscimo %: ");
        lblIncrease.setBounds(90, 75, 100, 20);
        lblIncrease.setForeground(Color.BLUE);
        pnlIncrease.add(lblIncrease);

        txfIncrease = new JTextField();
        txfIncrease.setBounds(175, 75, 150, 20);
        txfIncrease.setBackground(new Color(211, 228, 255));
        pnlIncrease.add(txfIncrease);

        lblIncreaseResult = new JLabel("Resultado R$: ");
        lblIncreaseResult.setBounds(85, 115, 100, 20);
        lblIncreaseResult.setForeground(Color.BLACK);
        pnlIncrease.add(lblIncreaseResult);

        txfIncreaseResult = new JTextField();
        txfIncreaseResult.setBounds(175, 115, 150, 20);
        txfIncreaseResult.setBackground(Color.LIGHT_GRAY);
        txfIncreaseResult.setEditable(false);
        pnlIncrease.add(txfIncreaseResult);

        pnlSampling = new JPanel();
        pnlSampling.setBounds(745, 15, 350, 150);
        pnlSampling.setLayout(null);
        pnlSampling.setBorder(BorderFactory.createTitledBorder("Amostragem - Quanto X% representa de Y"));
        getContentPane().add(pnlSampling);
        
        lblSamplingStart = new JLabel("Total: ");
        lblSamplingStart.setBounds(135, 35, 100, 20);
        lblSamplingStart.setForeground(Color.RED);
        pnlSampling.add(lblSamplingStart);

        txfSamplingStart = new JTextField();
        txfSamplingStart.setBounds(175, 35, 150, 20);
        txfSamplingStart.setBackground(new Color(254, 220, 220));
        pnlSampling.add(txfSamplingStart);

        lblSampling = new JLabel("Porcentagem %: ");
        lblSampling.setBounds(70, 75, 100, 20);
        lblSampling.setForeground(Color.BLUE);
        pnlSampling.add(lblSampling);

        txfSampling = new JTextField();
        txfSampling.setBounds(175, 75, 150, 20);
        txfSampling.setBackground(new Color(211, 228, 255));
        pnlSampling.add(txfSampling);
        
        lblSamplingResult = new JLabel("Corresponde a: ");
        lblSamplingResult.setBounds(80, 115, 100, 20);
        lblSamplingResult.setForeground(Color.BLACK);
        pnlSampling.add(lblSamplingResult);

        txfSamplingResult = new JTextField();
        txfSamplingResult.setBounds(175, 115, 150, 20);
        txfSamplingResult.setBackground(Color.LIGHT_GRAY);
        txfSamplingResult.setEditable(false);
        pnlSampling.add(txfSamplingResult);

        pnlSampling2 = new JPanel();
        pnlSampling2.setBounds(1100, 15, 350, 150);
        pnlSampling2.setLayout(null);
        pnlSampling2.setBorder(BorderFactory.createTitledBorder("Amostragem 2 - Quanto X representa de Y"));
        getContentPane().add(pnlSampling2);

        lblSamplingStart2 = new JLabel("Total: ");
        lblSamplingStart2.setBounds(135, 35, 100, 20);
        lblSamplingStart2.setForeground(Color.RED);
        pnlSampling2.add(lblSamplingStart2);

        txfSamplingStart2 = new JTextField();
        txfSamplingStart2.setBounds(175, 35, 150, 20);
        txfSamplingStart2.setBackground(new Color(254, 220, 220));
        pnlSampling2.add(txfSamplingStart2);

        lblSampling2 = new JLabel("Parte: ");
        lblSampling2.setBounds(130, 75, 100, 20);
        lblSampling2.setForeground(Color.BLUE);
        pnlSampling2.add(lblSampling2);

        txfSampling2 = new JTextField();
        txfSampling2.setBounds(175, 75, 150, 20);
        txfSampling2.setBackground(new Color(211, 228, 255));
        pnlSampling2.add(txfSampling2);

        lblSamplingResult2 = new JLabel("Corresponde a %: ");
        lblSamplingResult2.setBounds(65, 115, 125, 20);
        lblSamplingResult2.setForeground(Color.BLACK);
        pnlSampling2.add(lblSamplingResult2);

        txfSamplingResult2 = new JTextField();
        txfSamplingResult2.setBounds(175, 115, 150, 20);
        txfSamplingResult2.setBackground(Color.LIGHT_GRAY);
        txfSamplingResult2.setEditable(false);
        pnlSampling2.add(txfSamplingResult2);
    
        pnlWhichDiscount = new JPanel();
        pnlWhichDiscount.setBounds(15, 180, 350, 150);
        pnlWhichDiscount.setLayout(null);
        pnlWhichDiscount.setBorder(BorderFactory.createTitledBorder("Valor era A e paguei B, qual o desconto %?"));
        getContentPane().add(pnlWhichDiscount);

        lblWhichDiscountStart = new JLabel("Valor original: ");
        lblWhichDiscountStart.setBounds(85, 35, 100, 20);
        lblWhichDiscountStart.setForeground(Color.RED);
        pnlWhichDiscount.add(lblWhichDiscountStart);

        txfWhichDiscountStart = new JTextField();
        txfWhichDiscountStart.setBounds(175, 35, 150, 20);
        txfWhichDiscountStart.setBackground(new Color(254, 220, 220));
        pnlWhichDiscount.add(txfWhichDiscountStart);

        lblWhichDiscount = new JLabel("Valor com desconto: ");
        lblWhichDiscount.setBounds(50, 75, 150, 20);
        lblWhichDiscount.setForeground(Color.BLUE);
        pnlWhichDiscount.add(lblWhichDiscount);
        
        txfWhichDiscount = new JTextField();
        txfWhichDiscount.setBounds(175, 75, 150, 20);
        txfWhichDiscount.setBackground(new Color(211, 228, 255));
        pnlWhichDiscount.add(txfWhichDiscount);
        
        lblWhichDiscountResult = new JLabel("Desconto %: ");
        lblWhichDiscountResult.setBounds(95, 115, 100, 20);
        lblWhichDiscountResult.setForeground(Color.BLACK);
        pnlWhichDiscount.add(lblWhichDiscountResult);

        txfWhichDiscountResult = new JTextField();
        txfWhichDiscountResult.setBounds(175, 115, 150, 20);
        txfWhichDiscountResult.setBackground(Color.LIGHT_GRAY);
        txfWhichDiscountResult.setEditable(false);
        pnlWhichDiscount.add(txfWhichDiscountResult);

        pnlDeltaVariation = new JPanel();
        pnlDeltaVariation.setBounds(380, 180, 350, 150);
        pnlDeltaVariation.setLayout(null);
        pnlDeltaVariation.setBorder(BorderFactory.createTitledBorder("Variação Delta - Diferença % entre valores"));
        getContentPane().add(pnlDeltaVariation);

        lblDeltaVariationStart = new JLabel("Valor inicial: ");
        lblDeltaVariationStart.setBounds(95, 35, 100, 20);
        lblDeltaVariationStart.setForeground(Color.RED);
        pnlDeltaVariation.add(lblDeltaVariationStart);
        
        txfDeltaVariationStart = new JTextField();
        txfDeltaVariationStart.setBounds(175, 35, 150, 20);
        txfDeltaVariationStart.setBackground(new Color(254, 220, 220));
        pnlDeltaVariation.add(txfDeltaVariationStart);

        lblDeltaVariation = new JLabel("Valor final: ");
        lblDeltaVariation.setBounds(105 , 75, 100, 20);
        lblDeltaVariation.setForeground(Color.BLUE);
        pnlDeltaVariation.add(lblDeltaVariation);

        txfDeltaVariation = new JTextField();
        txfDeltaVariation.setBounds(175, 75, 150, 20);
        txfDeltaVariation.setBackground(new Color(211, 228, 255));
        pnlDeltaVariation.add(txfDeltaVariation);

        lblDeltaVariationResult = new JLabel("Diferença %: ");
        lblDeltaVariationResult.setBounds(95, 115, 100, 20);
        lblDeltaVariationResult.setForeground(Color.BLACK);
        pnlDeltaVariation.add(lblDeltaVariationResult);

        txfDeltaVariationResult = new JTextField();
        txfDeltaVariationResult.setBounds(175, 115, 150, 20);
        txfDeltaVariationResult.setBackground(Color.LIGHT_GRAY);
        txfDeltaVariationResult.setEditable(false);
        pnlDeltaVariation.add(txfDeltaVariationResult);

        pnlOriginalValue = new JPanel();
        pnlOriginalValue.setBounds(745, 180, 350, 150);
        pnlOriginalValue.setLayout(null);
        pnlOriginalValue.setBorder(BorderFactory.createTitledBorder("Qual era o valor original?"));
        getContentPane().add(pnlOriginalValue);

        lblOriginalValueStart = new JLabel("Valor final R$: ");
        lblOriginalValueStart.setBounds(85, 35, 100, 20);
        lblOriginalValueStart.setForeground(Color.RED);
        pnlOriginalValue.add(lblOriginalValueStart);

        txfOriginalValueStart = new JTextField();
        txfOriginalValueStart.setBounds(175, 35, 150, 20);
        txfOriginalValueStart.setBackground(new Color(254, 220, 220));
        pnlOriginalValue.add(txfOriginalValueStart);

        lblOriginalValue = new JLabel("Desconto %: ");
        lblOriginalValue.setBounds(95, 75, 100, 20);
        lblOriginalValue.setForeground(Color.BLUE);
        pnlOriginalValue.add(lblOriginalValue);

        txfOriginalValue = new JTextField();
        txfOriginalValue.setBounds(175, 75, 150, 20);
        txfOriginalValue.setBackground(new Color(211, 228, 255));
        pnlOriginalValue.add(txfOriginalValue);

        lblOriginalValueResult = new JLabel("Valor Inicial: ");
        lblOriginalValueResult.setBounds(95, 115, 100, 20);
        lblOriginalValueResult.setForeground(Color.BLACK);
        pnlOriginalValue.add(lblOriginalValueResult);

        txfOriginalValueResult = new JTextField();
        txfOriginalValueResult.setBounds(175, 115, 150, 20);
        txfOriginalValueResult.setBackground(Color.LIGHT_GRAY);
        txfOriginalValueResult.setEditable(false);
        pnlOriginalValue.add(txfOriginalValueResult);

        pnlRuleOfThree = new JPanel();
        pnlRuleOfThree.setBounds(1100, 180, 350, 150);
        pnlRuleOfThree.setLayout(null);
        pnlRuleOfThree.setBorder(BorderFactory.createTitledBorder("Regra de Três"));
        getContentPane().add(pnlRuleOfThree);

        lblRuleOfThreeA = new JLabel("A: ");
        lblRuleOfThreeA.setBounds(25, 35, 100, 20);
        lblRuleOfThreeA.setForeground(Color.RED);
        pnlRuleOfThree.add(lblRuleOfThreeA);

        txfRuleOfThreeA = new JTextField();
        txfRuleOfThreeA.setBounds(40, 35, 125, 20);
        txfRuleOfThreeA.setBackground(new Color(254, 220, 220));
        pnlRuleOfThree.add(txfRuleOfThreeA);

        lblRuleOfThreeB = new JLabel("B: ");
        lblRuleOfThreeB.setBounds(25, 75, 100, 20);
        lblRuleOfThreeB.setForeground(Color.BLUE);
        pnlRuleOfThree.add(lblRuleOfThreeB);

        txfRuleOfThreeB = new JTextField();
        txfRuleOfThreeB.setBounds(40, 75, 125, 20);
        txfRuleOfThreeB.setBackground(new Color(211, 228, 255));
        pnlRuleOfThree.add(txfRuleOfThreeB);

        lblRuleOfThreeR1 = new JLabel("R1: ");
        lblRuleOfThreeR1.setBounds(190, 35, 125, 20);
        lblRuleOfThreeR1.setForeground(Color.GREEN);
        pnlRuleOfThree.add(lblRuleOfThreeR1);

        txfRuleOfThreeR1 = new JTextField();
        txfRuleOfThreeR1.setBounds(215, 35, 125, 20);
        txfRuleOfThreeR1.setBackground(new Color(208, 240, 192));
        pnlRuleOfThree.add(txfRuleOfThreeR1);

        lblRuleOfThreeR2 = new JLabel("R2: ");  
        lblRuleOfThreeR2.setBounds(190, 75, 100, 20);
        lblRuleOfThreeR2.setForeground(Color.GRAY);
        pnlRuleOfThree.add(lblRuleOfThreeR2);

        txfRuleOfThreeR2 = new JTextField();
        txfRuleOfThreeR2.setBounds(215, 75, 125, 20);
        txfRuleOfThreeR2.setBackground(Color.LIGHT_GRAY);
        txfRuleOfThreeR2.setEditable(false);
        pnlRuleOfThree.add(txfRuleOfThreeR2);

        pnlPasswordGenerator = new JPanel();
        pnlPasswordGenerator.setBounds(380, 345, 715, 170);
        pnlPasswordGenerator.setLayout(null);
        pnlPasswordGenerator.setBorder(BorderFactory.createTitledBorder("Gerador de Senha"));
        getContentPane().add(pnlPasswordGenerator);

        chkPasswordUppercase = new JCheckBox("Maiúsculas");
        chkPasswordUppercase.setBounds(50, 35, 150, 20);
        pnlPasswordGenerator.add(chkPasswordUppercase);

        chkPasswordLowercase = new JCheckBox("Minúsculas");
        chkPasswordLowercase.setBounds(200, 35, 150, 20);
        pnlPasswordGenerator.add(chkPasswordLowercase);

        chkPasswordNumbers = new JCheckBox("Números");
        chkPasswordNumbers.setBounds(50, 65, 150, 20);
        pnlPasswordGenerator.add(chkPasswordNumbers);

        chkPasswordSpecialChars = new JCheckBox("Símbolos");
        chkPasswordSpecialChars.setBounds(200, 65, 150, 20);
        pnlPasswordGenerator.add(chkPasswordSpecialChars);

        lblPasswordLength = new JLabel("Tamanho: ");
        lblPasswordLength.setBounds(55, 105, 100, 20);
        lblPasswordLength.setForeground(Color.BLACK);
        pnlPasswordGenerator.add(lblPasswordLength);

        spnPasswordLength = new JSpinner();
        spnPasswordLength.setBounds(120, 105, 75, 20);
        spnPasswordLength.setValue(8);
        spnPasswordLength.setModel(new javax.swing.SpinnerNumberModel(8, 1, 100, 1));
        spnPasswordLength.setEditor(new JSpinner.DefaultEditor(spnPasswordLength));
        pnlPasswordGenerator.add(spnPasswordLength);

        btnGeneratePassword = new JButton("Gerar");
        btnGeneratePassword.setBounds(200, 105, 90, 20);
        btnGeneratePassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                boolean includeUppercase = chkPasswordUppercase.isSelected();
                boolean includeLowercase = chkPasswordLowercase.isSelected();
                boolean includeNumbers = chkPasswordNumbers.isSelected();
                boolean includeSpecialChars = chkPasswordSpecialChars.isSelected();

                int length = (int) spnPasswordLength.getValue();

                try {
                    String password = mathUtils.generatePassword(includeUppercase, includeLowercase, includeNumbers, includeSpecialChars, length);
                    txfPasswordResult.setText(password);
                } catch (IllegalArgumentException ex) {
                    txfPasswordResult.setText(ex.getMessage());
                }
            }
        });
        pnlPasswordGenerator.add(btnGeneratePassword);

        txfPasswordResult = new JTextField();
        txfPasswordResult.setBounds(55, 135, 235, 20);
        txfPasswordResult.setBackground(Color.LIGHT_GRAY);
        txfPasswordResult.setEditable(false);
        pnlPasswordGenerator.add(txfPasswordResult);

        addInputListeners();
    }

}
