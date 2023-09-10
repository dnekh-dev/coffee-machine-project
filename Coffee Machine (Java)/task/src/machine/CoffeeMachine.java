package machine;

import java.util.Scanner;

public class CoffeeMachine {

    protected static int partOfWater = 400;
    protected static int partOfMilk = 540;
    protected static int partOfCoffeeBeans = 120;
    protected static int disposableCups = 9;
    protected static int moneyAmount = 550;
    protected static String choiceOfOptions;
    protected static int choiceOfCoffee;
    protected static final int[] ESPRESSO_MIX = {250, 0, 16, 4};
    protected static final int[] LATTE_MIX = {350, 75, 20, 7};
    protected static final int[] CAPPUCCINO_MIX = {200, 100, 12, 6};
    protected static final String[] INPUT_OPTIONS = {"buy", "fill", "take", "remaining", "exit"};
    protected static final String ML_SUFFICES = "ml";
    protected static final String G_SUFFICES = "g";
    protected static final String $_SUFFICES = "$";
    protected static boolean isSwitchOff = false;


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (!isSwitchOff) {

            System.out.println("Write action (buy, fill, take, remaining, exit):");
            choiceOfOptions = sc.nextLine();
            for (String str : INPUT_OPTIONS) {
                if (choiceOfOptions.toLowerCase().equals(str)) {
                    switch (choiceOfOptions) {
                        case "remaining":
                            System.out.println("\n" + coffeeMachineHas(partOfWater, partOfMilk, partOfCoffeeBeans, disposableCups, moneyAmount));
                            break;
                        case "buy":
                            System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
                            try {
                                choiceOfCoffee = Integer.parseInt(sc.nextLine());
                                if (choiceOfCoffee > 0) {
                                    if (checkPossibilityOfCoffeeMaking(choiceOfCoffee, partOfWater, partOfMilk, partOfCoffeeBeans, disposableCups)) {

                                        switch (choiceOfCoffee) {
                                            case 1:
                                                partOfWater -= ESPRESSO_MIX[0];
                                                partOfMilk -= ESPRESSO_MIX[1];
                                                partOfCoffeeBeans -= ESPRESSO_MIX[2];
                                                disposableCups -= 1;
                                                moneyAmount += ESPRESSO_MIX[3];
                                                System.out.println("I have enough resources, making you a coffee!\n");
                                                break;
                                            case 2:
                                                partOfWater -= LATTE_MIX[0];
                                                partOfMilk -= LATTE_MIX[1];
                                                partOfCoffeeBeans -= LATTE_MIX[2];
                                                disposableCups -= 1;
                                                moneyAmount += LATTE_MIX[3];
                                                System.out.println("I have enough resources, making you a coffee!\n");
                                                break;
                                            case 3:
                                                partOfWater -= CAPPUCCINO_MIX[0];
                                                partOfMilk -= CAPPUCCINO_MIX[1];
                                                partOfCoffeeBeans -= CAPPUCCINO_MIX[2];
                                                disposableCups -= 1;
                                                moneyAmount += CAPPUCCINO_MIX[3];
                                                System.out.println("I have enough resources, making you a coffee!\n");
                                                break;
                                            default:
                                                System.out.println("Wrong input. Check options ones again.");
                                                break;
                                        }
                                    } else {
                                        System.out.printf("\nSorry, not enough %s!\n\n", resourcesThatNotEnough());
                                        break;
                                    }

                                } else {
                                    System.out.println("Number entered could not be negative.");
                                }
                            } catch (NumberFormatException ex) {
                                System.out.println("We don't have this kind of coffee on our menu.");
                            }
                            break;
                        case "fill":
                            System.out.println("\nWrite how many ml of water you want to add:");
                            try {
                                int quantity = Integer.parseInt(sc.nextLine());
                                if (quantity >= 0) {
                                    partOfWater += quantity;
                                } else {
                                    System.out.println("Quantity could not be negative");
                                }
                            } catch (NumberFormatException ex) {
                                System.out.println("Invalid water quantity entered");
                            }
                            System.out.println("Write how many ml of milk you want to add:");
                            try {
                                int quantity = Integer.parseInt(sc.nextLine());
                                if (quantity >= 0) {
                                    partOfMilk += quantity;
                                } else {
                                    System.out.println("Quantity could not be negative");
                                }
                            } catch (NumberFormatException ex) {
                                System.out.println("Invalid milk quantity entered.");
                            }
                            System.out.println("Write how many grams of coffee beans you want to add:");
                            try {
                                int quantity = Integer.parseInt(sc.nextLine());
                                if (quantity >= 0) {
                                    partOfCoffeeBeans += quantity;
                                } else {
                                    System.out.println("Quantity could not be negative");
                                }
                            } catch (NumberFormatException ex) {
                                System.out.println("Invalid coffee beans quantity entered.");
                            }
                            System.out.println("Write how many disposable cups you want to add:");
                            try {
                                int quantity = Integer.parseInt(sc.nextLine());
                                if (quantity >= 0) {
                                    disposableCups += quantity;
                                } else {
                                    System.out.println("Quantity could not be negative");
                                }
                            } catch (NumberFormatException ex) {
                                System.out.println("Invalid disposable cups quantity entered.");
                            }
                            System.out.println();
                            break;
                        case "take":
                            System.out.printf("\nI gave you $%d\n\n", moneyAmount);
                            moneyAmount -= moneyAmount;
                            break;
                        case "exit":
                            isSwitchOff = true;
                            break;
                        default:
                            System.out.println("Wrong input. Check possible options: \"buy\", \"fill\", \"take\".");
                            break;
                    }
                }
            }
        }
    }


    public static boolean checkPossibilityOfCoffeeMaking(int choiceOfCoffee, int partOfWater, int partOfMilk, int partOfCoffeeBeans, int disposableCups) {
        if (choiceOfCoffee == 1 && partOfWater >= ESPRESSO_MIX[0] && partOfMilk >= ESPRESSO_MIX[1] && partOfCoffeeBeans >= ESPRESSO_MIX[2] && disposableCups > 0) {
            return true;
        } else if (choiceOfCoffee == 2 && partOfWater >= LATTE_MIX[0] && partOfMilk >= LATTE_MIX[1] && partOfCoffeeBeans >= LATTE_MIX[2] && disposableCups > 0) {
            return true;
        } else if (choiceOfCoffee == 3 && partOfWater >= CAPPUCCINO_MIX[0] && partOfMilk >= CAPPUCCINO_MIX[1] && partOfCoffeeBeans >= CAPPUCCINO_MIX[2] && disposableCups > 0) {
            return true;
        }

        return false;
    }

    public static String resourcesThatNotEnough() {
        if (partOfCoffeeBeans - ESPRESSO_MIX[2] < 0 || partOfCoffeeBeans - LATTE_MIX[2] < 0 || partOfCoffeeBeans - CAPPUCCINO_MIX[2] < 0) return "coffee beans";
        if (partOfWater - ESPRESSO_MIX[0] < 0 || partOfWater - LATTE_MIX[0] < 0 || partOfWater - CAPPUCCINO_MIX[0] < 0) return "water";
        if (partOfMilk - LATTE_MIX[1] < 0 || partOfCoffeeBeans - CAPPUCCINO_MIX[1] < 0) return "milk";
        if (disposableCups <= 0) return "disposable cups";
        return " ";
    }

    public static String coffeeMachineHas(int partOfWater, int partOfMilk, int partOfCoffeeBeans, int disposableCups, int moneyAmount) {
        return String.format("""
                The coffee machine has:
                %d %s of water
                %d %s of milk
                %d %s of coffee beans
                %d disposable cups
                %s%d of money
                """, partOfWater, ML_SUFFICES, partOfMilk, ML_SUFFICES, partOfCoffeeBeans, G_SUFFICES, disposableCups, $_SUFFICES, moneyAmount);
    }
}
