import java.io.IOException;
import java.util.Scanner;

public class testovoe {

    public static void main(String[] args) throws Exception { //  МЕЙН МЕЙН МЕЙН МЕЙН МЕЙН МЕЙН МЕЙН МЕЙН МЕЙН МЕЙН МЕЙН МЕЙН МЕЙН МЕЙН МЕЙН МЕЙН МЕЙН МЕЙН
        Scanner scan = new Scanner(System.in);
        String inpppppput = scan.nextLine();
        System.out.println(calc(inpppppput));
    }

    static void romeToArabic(String[] romeInput, int z) throws Exception { //  МЕТОДЫ МЕТОДЫ МЕТОДЫ МЕТОДЫ МЕТОДЫ МЕТОДЫ МЕТОДЫ МЕТОДЫ МЕТОДЫ МЕТОДЫ МЕТОДЫ
        switch (romeInput[z]) {
            case "I" -> romeInput[z] = "1";
            case "II" -> romeInput[z] = "2";
            case "III" -> romeInput[z] = "3";
            case "IV" -> romeInput[z] = "4";
            case "V" -> romeInput[z] = "5";
            case "VI" -> romeInput[z] = "6";
            case "VII" -> romeInput[z] = "7";
            case "VIII" -> romeInput[z] = "8";
            case "IX" -> romeInput[z] = "9";
            case "X" -> romeInput[z] = "10";
            default -> throw new Exception();
        }
    }

    static String ArabicToRome(String romeOutput) {
        if (romeOutput.length() == 1) {
            switch (romeOutput) {
                case "0" -> { return "";
                }
                case "1" -> { return "I";
                }
                case "2" -> { return "II";
                }
                case "3" -> { return "III";
                }
                case "4" -> { return "IV";
                }
                case "5" -> { return "V";
                }
                case "6" -> { return "VI";
                }
                case "7" -> { return "VII";
                }
                case "8" -> { return "VIII";
                }
                case "9" -> { return "IX";
                }
                default -> { return "Такого else не существует";
                }
            }
        }
        else if (romeOutput.length() == 2) {
            String firstSymbol = romeOutput.split("")[0];
            String secondSymbol = romeOutput.split("")[1];
            switch (firstSymbol) {
                case "1" -> firstSymbol = "X";
                case "2" -> firstSymbol = "XX";
                case "3" -> firstSymbol = "XXX";
                case "4" -> firstSymbol = "XL";
                case "5" -> firstSymbol = "L";
                case "6" -> firstSymbol = "LX";
                case "7" -> firstSymbol = "LXX";
                case "8" -> firstSymbol = "LXXX";
                case "9" -> firstSymbol = "XXC";
            }
            switch (secondSymbol) {
                case "0" -> secondSymbol = "";
                case "1" -> secondSymbol = "I";
                case "2" -> secondSymbol = "II";
                case "3" -> secondSymbol = "III";
                case "4" -> secondSymbol = "IV";
                case "5" -> secondSymbol = "V";
                case "6" -> secondSymbol = "VI";
                case "7" -> secondSymbol = "VII";
                case "8" -> secondSymbol = "VIII";
                case "9" -> secondSymbol = "IX";
            }
            return firstSymbol + secondSymbol;
        } else if (romeOutput.length() == 3) {
            return "C";
        } else {
            return "Такого else не существует";
        }

    }

    static String calc(String input) throws Exception { // КАЛК КАЛК КАЛК КАЛК КАЛК КАЛК КАЛК КАЛК КАЛК КАЛК КАЛК КАЛК КАЛК КАЛК КАЛК КАЛК КАЛК КАЛК КАЛК КАЛК

        int output = 0; // ПЕРЕМЕННЫЕ ПЕРЕМЕННЫЕ ПЕРЕМЕННЫЕ ПЕРЕМЕННЫЕ ПЕРЕМЕННЫЕ ПЕРЕМЕННЫЕ ПЕРЕМЕННЫЕ ПЕРЕМЕННЫЕ ПЕРЕМЕННЫЕ ПЕРЕМЕННЫЕ ПЕРЕМЕННЫЕ ПЕРЕМЕННЫЕ
        int counter = 0;
        String[] numbersMassive;
        String v;

        input = input.replaceAll(" ", "");

        numbersMassive = input.split("");

        for (String x : numbersMassive) { // ТОЛЬКО 1 АРИФМЕТИЧЕСКИЙ ЗНАК ТОЛЬКО 1 АРИФМЕТИЧЕСКИЙ ЗНАК ТОЛЬКО 1 АРИФМЕТИЧЕСКИЙ ЗНАК ТОЛЬКО 1 АРИФМЕТИЧЕСКИЙ ЗНАК
            if (x.equals("+") || x.equals("-") || x.equals("*") || x.equals("/")) {
                counter = counter + 1;
            }
        }
        if (counter != 1) {
            throw new IOException();
        }

        if (input.contains("+")) { // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            numbersMassive = input.split("\\+");
            if ((numbersMassive[0].contains("I") || numbersMassive[0].contains("V") || numbersMassive[0].contains("X")) && // IVXIVXIVXIVXIVXIVXIVXIVXIVXIVXIVXIVX
                    (numbersMassive[1].contains("I") || numbersMassive[1].contains("V") || numbersMassive[1].contains("X"))) {

                romeToArabic(numbersMassive, 0);
                romeToArabic(numbersMassive, 1);

                if (0 >= Integer.parseInt(numbersMassive[0]) + Integer.parseInt(numbersMassive[1])) {
                    throw new Exception();
                }

                output = Integer.parseInt(numbersMassive[0]) + Integer.parseInt(numbersMassive[1]);
                v = ArabicToRome(String.valueOf(output));
                System.out.println(v);
                return v;

            } else if ((!numbersMassive[0].contains("I") && !numbersMassive[0].contains("V") && !numbersMassive[0].contains("X")) && // 1234567891012345678910
                    (!numbersMassive[1].contains("I") && !numbersMassive[1].contains("V") && !numbersMassive[1].contains("X"))) {

                int a;
                int b;

                try {
                    a = Integer.parseInt(numbersMassive[0]);
                    b = Integer.parseInt(numbersMassive[1]);

                    if ((a==1 || a==2 || a==3 || a==4 || a==5 || a==6 || a==7 || a==8 || a==9 || a==10 ) &&
                            (b==1 || b==2 || b==3 || b==4 || b==5 || b==6 || b==7 || b==8 || b==9 || b==10 ) ) {
                        output = a + b;
                    } else throw new Exception();

                } catch (Exception e) { throw new Exception();
                }
                return String.valueOf(output);

            } else {
                throw new Exception();
            }
        }

        else if (input.contains("-")) { // ---------------------------------------------------------------------------------------------------------------------------
            numbersMassive = input.split("-");
            if ((numbersMassive[0].contains("I") || numbersMassive[0].contains("V") || numbersMassive[0].contains("X")) && // IVXIVXIVXIVXIVXIVXIVXIVXIVXIVXIVXIVX
                    (numbersMassive[1].contains("I") || numbersMassive[1].contains("V") || numbersMassive[1].contains("X"))) {

                romeToArabic(numbersMassive, 0);
                romeToArabic(numbersMassive, 1);

                if (0 >= Integer.parseInt(numbersMassive[0]) - Integer.parseInt(numbersMassive[1])) {
                    throw new Exception();
                }

                output = Integer.parseInt(numbersMassive[0]) - Integer.parseInt(numbersMassive[1]);
                v = ArabicToRome(String.valueOf(output));
                return v;

            } else if ((!numbersMassive[0].contains("I") && !numbersMassive[0].contains("V") && !numbersMassive[0].contains("X")) && // 1234567891012345678910
                    (!numbersMassive[1].contains("I") && !numbersMassive[1].contains("V") && !numbersMassive[1].contains("X"))) {

                int a;
                int b;

                try {
                    a = Integer.parseInt(numbersMassive[0]);
                    b = Integer.parseInt(numbersMassive[1]);

                    if ((a==1 || a==2 || a==3 || a==4 || a==5 || a==6 || a==7 || a==8 || a==9 || a==10 ) &&
                            (b==1 || b==2 || b==3 || b==4 || b==5 || b==6 || b==7 || b==8 || b==9 || b==10 ) ) {
                        output = a - b;
                    } else throw new Exception();

                } catch (Exception e) { throw new Exception();
                }
                return String.valueOf(output);
            } else {
                throw new Exception();
            }
        }

        else if (input.contains("*")) { // ***********************************************************************************************************************
            numbersMassive = input.split("\\*");
            if ((numbersMassive[0].contains("I") || numbersMassive[0].contains("V") || numbersMassive[0].contains("X")) && // IVXIVXIVXIVXIVXIVXIVXIVXIVXIVXIVXIVX
                    (numbersMassive[1].contains("I") || numbersMassive[1].contains("V") || numbersMassive[1].contains("X"))) {

                romeToArabic(numbersMassive, 0);
                romeToArabic(numbersMassive, 1);

                if (0 >= Integer.parseInt(numbersMassive[0]) * Integer.parseInt(numbersMassive[1])) {
                    throw new Exception();
                }

                output = Integer.parseInt(numbersMassive[0]) * Integer.parseInt(numbersMassive[1]);
                v = ArabicToRome(String.valueOf(output));
                return v;

            } else if ((!numbersMassive[0].contains("I") && !numbersMassive[0].contains("V") && !numbersMassive[0].contains("X")) && // 1234567891012345678910
                    (!numbersMassive[1].contains("I") && !numbersMassive[1].contains("V") && !numbersMassive[1].contains("X"))) {

                int a;
                int b;

                try {
                    a = Integer.parseInt(numbersMassive[0]);
                    b = Integer.parseInt(numbersMassive[1]);

                    if ((a==1 || a==2 || a==3 || a==4 || a==5 || a==6 || a==7 || a==8 || a==9 || a==10 ) &&
                            (b==1 || b==2 || b==3 || b==4 || b==5 || b==6 || b==7 || b==8 || b==9 || b==10 ) ) {
                        output = a * b;
                    } else throw new Exception();

                } catch (Exception e) { throw new Exception();
                }
                return String.valueOf(output);
            } else {
                throw new Exception();

            }
        }

        else if (input.contains("/")) { // ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            numbersMassive = input.split("/");
            if ((numbersMassive[0].contains("I") || numbersMassive[0].contains("V") || numbersMassive[0].contains("X")) && // IVXIVXIVXIVXIVXIVXIVXIVXIVXIVXIVXIVX
                    (numbersMassive[1].contains("I") || numbersMassive[1].contains("V") || numbersMassive[1].contains("X"))) {

                romeToArabic(numbersMassive, 0);
                romeToArabic(numbersMassive, 1);

                if (0 >= Integer.parseInt(numbersMassive[0]) / Integer.parseInt(numbersMassive[1])) {
                    throw new Exception();
                }

                output = Integer.parseInt(numbersMassive[0]) / Integer.parseInt(numbersMassive[1]);
                v = ArabicToRome(String.valueOf(output));
                return v;

            } else if ((!numbersMassive[0].contains("I") && !numbersMassive[0].contains("V") && !numbersMassive[0].contains("X")) && // 1234567891012345678910
                    (!numbersMassive[1].contains("I") && !numbersMassive[1].contains("V") && !numbersMassive[1].contains("X"))) {

                int a;
                int b;

                try {
                    a = Integer.parseInt(numbersMassive[0]);
                    b = Integer.parseInt(numbersMassive[1]);

                    if ((a==1 || a==2 || a==3 || a==4 || a==5 || a==6 || a==7 || a==8 || a==9 || a==10 ) &&
                            (b==1 || b==2 || b==3 || b==4 || b==5 || b==6 || b==7 || b==8 || b==9 || b==10 ) ) {
                        output = a / b;
                    } else throw new Exception();

                } catch (Exception e) { throw new Exception();
                }
                return String.valueOf(output);
            } else {
                throw new Exception();
            }
        }
        return String.valueOf(output);

    }




}