import java.io.*;
import java.text.*;
import java.util.*;

public class Board {
    private Map<String, String> users;
    private Map<String, String> adverts;

    public Board(String filename) throws FileNotFoundException {
        users = new HashMap<String, String>();
        adverts = new HashMap<String, String>();
        try (Scanner sc = new Scanner(new FileInputStream(filename))) {
            while (sc.hasNextLine()) {
                String lines = sc.nextLine();
                String[] data = lines.split(" ");
                String username = data[0], password = data[1];
                users.put(username, password);
            }
        }
    }

    public synchronized Map<String, String> getAdverts() {
        return adverts;
    }

    public synchronized Map<String, String> getUsers() {
        return users;
    }

    public synchronized void addAdvert(String head, String advert) throws IOException {
        Format f = new SimpleDateFormat("HH:mm:ss");
        adverts.put(head + "~" + f.format(new Date()), advert);
    }

    public synchronized void deleteAdvert(String head) throws IOException {
        adverts.remove(head);
    }
}