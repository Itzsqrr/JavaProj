import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserDatabase {
    private static final String FILE_NAME = "usersDB.txt";
    private List<User> users;

    public UserDatabase() {
        users = new ArrayList<>();
        loadUsers();
    }

    private void loadUsers() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length == 3) {
                    int id = Integer.parseInt(parts[0]);
                    String login = parts[1];
                    String password = parts[2];
                    users.add(new User(id, login, password));
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка загрузки данных: " + e.getMessage());
        }
    }

    private void saveUsers() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (User  user : users) {
                bw.write(user.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Ошибка сохранения данных: " + e.getMessage());
        }
    }

    public void insertUser (String login, String password) {
        int id = users.size() > 0 ? users.get(users.size() - 1).getId() + 1 : 0;
        users.add(new User(id, login, password));
        saveUsers();
    }

    public void deleteUser(int id) {
        users.removeIf(user -> user.getId() == id);
        saveUsers();
    }

    public void updateUser(int id, String newLogin, String newPassword) {
        for (User  user : users) {
            if (user.getId() == id) {
                user.setLogin(newLogin);
                user.setPassword(newPassword);
                break;
            }
        }
        saveUsers();
    }

    public void selectUsers() {
        for (User  user : users) {
            System.out.println(user);
        }
    }
}