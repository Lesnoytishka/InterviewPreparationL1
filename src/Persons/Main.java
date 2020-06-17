/*
 * Dmitry Ozhigin
 *  Lesnoytishka@gmail.com
 *  2020 - 6 - 17
 */

package Persons;/*
 * Dmitry Ozhigin
 *  Lesnoytishka@gmail.com
 *  2020 - 6 - 17
 */

public class Main {
    public static void main(String[] args) {
        Person person = new Person.Builder()
                .addFirstName("Jhon")
                .addPhone("123")
                .build();

        Person person2 = new Person.Builder()
                .addFirstName("Second")
                .addLastName("Persons.Person")
                .addMiddleName("mmm")
                .addCountry("Country")
                .addAddress("Street")
                .addAge(3)
                .addPhone("123")
                .build();

        System.out.println(person);
        System.out.println(person2);
    }
}
