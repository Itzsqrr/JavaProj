import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserDatabase db = new UserDatabase();
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("1 – Посмотреть данные пользователей");
            System.out.println("2 – Добавить пользователя");
            System.out.println("3 – Удалить пользователя");
            System.out.println("4 – Обновить данные пользователя");
            System.out.println("5 – Завершить работу");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Данные пользователей:");
                    db.selectUsers();
                    break;
                case 2:
                    System.out.print("Введите логин: ");
                    String login = scanner.next();
                    System.out.print("Введите пароль: ");
                    String password = scanner.next();
                    db.insertUser (login, password);
                    break;
                case 3:
                    System.out.print("Введите ID пользователя для удаления: ");
                    int deleteId = scanner.nextInt();
                    db.deleteUser (deleteId);
                    break;
                case 4:
                    System.out.print("Введите ID пользователя для обновления: ");
                    int updateId = scanner.nextInt();
                    System.out.print("Введите новый логин: ");
                    String newLogin = scanner.next();
                    System.out.print("Введите новый пароль: ");
                    String newPassword = scanner.next();
                    db.updateUser (updateId, newLogin, newPassword);
                    break;
                case 5:
                    System.out.println("Завершение работы программы.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Неверный выбор. Пожалуйста, попробуйте еще раз.");
            }
        }
    }
}