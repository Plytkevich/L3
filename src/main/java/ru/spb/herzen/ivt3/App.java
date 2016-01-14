package ru.spb.herzen.ivt3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;


import org.kohsuke.randname.RandomNameGenerator;

public class App {
    //Генерация списка из 10 рандомных чисел

    public static void main(String[] args) {
        List<Integer> Mass = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int number = (int) Math.round((Math.random() * 15));
            Mass.add(number);
        }

        //Вывод массива с помощью потока (лямбды)

        System.out.println("Сгенерированный массив:");
        Mass.forEach(System.out::println);

        //Фильтрация массива и его вывод с помощью потока (лямбды)

        System.out.println("Отфильтровнный массив:");
        Mass.stream().filter((s) -> ((s % 2 == 0) & (s != 0))).forEach(System.out::println);

        //Сортировка массива и его вывод с помощью потока (лямбды)
        System.out.println("Отсортированный массив:");
        Mass.stream().sorted().forEach(System.out::println);

        //Реализация Consumer'a

        System.out.println("Функциональный интерфейс Number Crusher:");
        Consumer<Integer> NumberCrusher = (x) -> System.out.println((x * 2));
        Mass.forEach(NumberCrusher);

        //Генерация списка из 15 "рандомных имён"

        System.out.println("Генерация списка из 15-и имён");
        List<String> rndMass = new ArrayList<>();
        RandomNameGenerator rnd = new RandomNameGenerator(5);
        for (int i = 0; i < 15; i++) {
            String name = rnd.next();
            rndMass.add(name);
        }
        rndMass.forEach((x) -> System.out.println("Hello, " + x));

        //Сортировка списка из 15-ми имён и смена регистра букв

        System.out.println("Отсортированный массив + верхний регистр:");
        rndMass.stream().sorted().forEach((x) -> System.out.println((x.toUpperCase())));

        //Генерация 30-ти рандомных чисел и сложение только чётных + минимальный и максимальный элемент

        List<Integer> massInt = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            int number = (int) Math.round((Math.random() * 15) - 8);
            massInt.add(number);
        }
        System.out.println("Массив из 30-и чисел:");
        massInt.stream().forEach(System.out::println);

        System.out.println("Отфильтрованный массив:");
        massInt.stream().filter((s) -> ((s % 2 == 0) & (s != 0))).forEach(System.out::println);

        int sum = massInt.stream().filter((s) -> ((s % 2 == 0) & (s != 0))).mapToInt((s) -> (s)).sum();
        System.out.println("Сумма:" + sum);

        int max = massInt.stream().max(Integer::compareTo).get();
        System.out.println("Максимальный элемент:" + max);

        int min = massInt.stream().min(Integer::compareTo).get();
        System.out.println("Минимальный элемент:" + min);
    }

}
