package ru.ezhik;

public class User implements Comparable<User> {
    public final String name;

    @Override
    public int compareTo(User o) {
        int i = surname.compareTo(o.surname) + name.compareTo(o.name);
        return i;
    }

    public final String surname;
    public final Boolean isError;

    public User(String s) {
        String[] split = s.split(";");

        this.surname = split.length == 0 ? "" : split[0];
        this.name = split.length == 1 ? "" : split[1];
        this.isError = this.name == null || this.surname == null || split.length != 2; /* TODO проверить длину имени и фамилии */

    }
}
