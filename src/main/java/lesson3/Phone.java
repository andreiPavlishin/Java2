package lesson3;

public class Phone {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.addPhoneNumber("Иванович", "+7-(950)-729-15-87");
        phoneBook.addPhoneNumber("Билл", "+66-(564)-01-01-01-111");
        phoneBook.addPhoneNumber("Серёга", "+7-(565)-145-65-77");
        phoneBook.addPhoneNumber("Пупкин", "+7-(455)-365-33-44");

        System.out.println(phoneBook.get("Пупкин"));
    }
}
