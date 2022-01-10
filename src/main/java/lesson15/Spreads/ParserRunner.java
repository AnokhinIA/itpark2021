package lesson15.Spreads;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Опциональное практическое задание: Реализовать приложение, которое принимает на вход некоторый текст (например, из консоли),
 * вычисляет частоту появления слов в этом тексте и после чего выводит слова в убывающем порядке их частоты появления в тексте.
 * <p>
 * •Под словом подразумевается любая непрерывная последовательность символов (до пробела, точки, запятой, двоеточия и других разделителей),
 * состоящая только из букв и цифр, не учитывая регистр букв. Например, в строке "Семь раз отмерь, 1 раз отрежь!" ровно пять слов: "семь",
 * "раз", "отмерь", "1", "отрежь" и вывод должен быть такой: Вывод для данного случая такой:
 * •раз
 * •семь
 * •замерь
 * •1
 * •отрежь
 * Для решения необходимо пользоваться возможностями StreamAPI, избегая использования циклов и условных операторов.
 * Для примера можно взять такой текст:
 * Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sodales consectetur purus at faucibus. Donec mi quam, tempor vel ipsum non,
 * faucibus suscipit massa. Morbi lacinia velit blandit tincidunt efficitur. Vestibulum eget metus imperdiet sapien laoreet faucibus.
 * Nunc eget vehicula mauris, ac auctor lorem. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Integer vel odio nec mi tempor dignissim.
 */

public class ParserRunner {
    public static void main(String[] args) {
        String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sodales consectetur purus at faucibus. Donec mi quam, tempor vel ipsum non,\n" +
                " faucibus suscipit massa. Morbi lacinia velit blandit tincidunt efficitur. Vestibulum eget metus imperdiet sapien laoreet faucibus.\n" +
                " Nunc eget vehicula mauris, ac auctor lorem. Lorem ipsum dolor sit amet, consectetur adipiscing elit.\n" +
                " Integer vel odio nec mi tempor dignissim";

        Stream<String> stream = Arrays.stream(text.split("[^а-яА-Яa-zA-Z0-9]+"));

        Map<String, Long> map = stream.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        map.entrySet().stream().
                sorted(Map.Entry.<String, Long>comparingByValue().reversed()).
                forEach(System.out::println);
    }
}
