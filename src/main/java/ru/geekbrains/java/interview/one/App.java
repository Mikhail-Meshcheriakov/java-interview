package ru.geekbrains.java.interview.one;

public class App {
    public static void main(String[] args) {
        Person person = new PersonBuilder().addFirstName("Mikhail").addLastName("M").addAge(31).addPhone("82654123594")
                .addCountry("Russia").addGender("M").build();

        System.out.println(person);
    }
}
