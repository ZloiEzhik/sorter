package ru.ezhik;

import java.util.List;
import java.util.stream.Collectors;

public class Sorter {

    public static void main() {
        List<String> arStrings = Files.readFile("list.txt");


        List<User> collect = arStrings.stream()
                .map(vStr -> new User(vStr)
                ).collect(Collectors.toList());

        List<User> colCorrect = collect
                .stream()
                .filter(user -> !user.isError)
                .sorted(((o1, o2) -> o1.compareTo(o2)))
                .collect(Collectors.toList());

        List<User> colNotCorrect = collect
                .stream()
                .filter(user -> user.isError)
                .sorted()
                .collect(Collectors.toList());

        colCorrect.stream().forEach(user -> System.out.println(user.surname + " " + user.name));

        List<String> arSortStrings = sortList(arStrings);
        checkList();
        Files.writeFile("sort.txt", arSortStrings);
    }

    public static List<String> sortList(List<String> arStrings) {
        return arStrings.stream().sorted().collect(Collectors.toList());
    }

    public static void checkList() {

        try {
            Files.writeErrfile("errors.txt","Error message");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        main();
    }
}