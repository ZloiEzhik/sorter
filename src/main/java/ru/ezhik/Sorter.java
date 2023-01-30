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

        Files.cleanFile("sort.txt");
        Files.cleanFile("error.txt");
        colCorrect.stream().forEach(user -> Files.writeFile("sort.txt",(user.surname + " " + user.name)));
        colNotCorrect.stream().forEach(user -> Files.writeFile("error.txt",(user.surname + " " + user.name)));
    }

    public static void main(String[] args) {
        main();
    }
}