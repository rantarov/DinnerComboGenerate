package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.Random;

public class DinnerConstructor {
    HashMap<String, ArrayList<String>> dinners = new HashMap<>();
    Random random = new Random();

    void addDinner(String dinnerType, String dinnerName) {
        if (!dinners.containsKey(dinnerType)) {
            dinners.put(dinnerType, new ArrayList<>());
        }
        dinners.get(dinnerType).add(dinnerName);
    }

    boolean checkType(String dinnerType) {
        return dinners.containsKey(dinnerType);
    }

    void choseDishesType(ArrayList<String> dishes, String dinnerType) {
        if (!dishes.contains(dinnerType) && dinners.containsKey(dinnerType) || dinnerType.isEmpty()) {
            dishes.add(dinnerType);
            if (dinnerType.isEmpty()) {
                dishes.remove(dinnerType);
            }
        } else {
            System.out.println("Вы уже ввели этот тип или его не существует :(\n" + "Попробуйте еще раз!");
        }
    }

    void printDinners() {
        for (String dinnerType : dinners.keySet()) {
            for (String dinnerName : dinners.get(dinnerType)) {
                System.out.println(dinnerType + " " + dinnerName);
            }
        }
    }

    ArrayList<String> generateCombo(ArrayList<String> dishes) {
        ArrayList<String> combo = new ArrayList<>();
        ArrayList<String> randomCombo= new ArrayList<>();


//        for (String dishesElement : dishes) {
//            for (String comboElement : dinners.get(dishesElement)) {
//                for (int i = 0; i < dishes.size(); i++) {
//                    combo.add(dinners.get(random.nextInt(dishes.size())) + comboElement);
//                }
//            }
//        }
//        return combo;

        for (String dishesElement : dishes) {
            for (String elementCombo : dinners.get(dishesElement)) {
                combo.add(elementCombo);
            }
        }
        return combo;
    }
}
