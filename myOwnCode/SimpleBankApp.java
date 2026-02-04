package myOwnCode;
import java.util.ArrayList;
import java.util.List;

// 1. Класс, описывающий банковский счет
class bankCode {
    private String owner;
    private double balance;

    public bankCode(String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
    }

    // Метод: Положить деньги
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(owner + " пополнил счет на " + amount);
        }
    }

    // Метод: Снять деньги
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println(owner + " снял " + amount);
        } else {
            System.out.println("ОШИБКА: У " + owner + " недостаточно средств для снятия " + amount);
        }
    }

    // Метод: Перевод другому человеку
    public void transfer(bankCode receiver, double amount) {
        if (this.balance >= amount) {
            this.withdraw(amount); // Снимаем у себя
            receiver.deposit(amount); // Кладем другому
            System.out.println(">> Перевод выполнен успешно!");
        } else {
            System.out.println(">> Ошибка перевода: нехватка денег.");
        }
    }


    @Override
    public String toString() {
        return "Владелец: " + owner + " | Баланс: $" + balance;
    }
}

// 2. Главный класс с методом main
public class SimpleBankApp {
    public static void main(String[] args) {
        // Создаем список счетов
        List<bankCode> accounts = new ArrayList<>();

        // Создаем конкретные счета
        bankCode user1 = new bankCode("Алиса", 1000.0);
        bankCode user2 = new bankCode("Боб", 500.0);

        accounts.add(user1);
        accounts.add(user2);

        // --- Демонстрация работы ---
        System.out.println("=== Начальное состояние ===");
        printAll(accounts);

        System.out.println("\n--- Алиса переводит Бобу 300$ ---");
        user1.transfer(user2, 300.0);

        System.out.println("\n--- Боб пытается снять слишком много (1000$) ---");
        user2.withdraw(1000.0);

        System.out.println("\n=== Конечное состояние ===");
        printAll(accounts);
    }


    public static void printAll(List<bankCode> accounts) {
        for (bankCode acc : accounts) {
            System.out.println(acc);
        }
    }
}