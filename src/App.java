import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class App {
    static String filename = "TAK22_Persons.csv";
    static List<Person> persons = new ArrayList<>();
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    public static void main(String[] args) {
        readFileContents();
        show();
        // System.out.println(persons.size());  // Shows list result

    }
    private static int calculateAge(LocalDate birth) {
        LocalDate today = LocalDate.now();
        return Period.between(birth, today).getYears();
    }
    private static void show() {
        for (Person p : persons) {
            // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            String dateStr = p.getBirth().format(formatter);
            int age = calculateAge(p.getBirth());
            System.out.println(String.join(";", p.getFirstname(), p.getLastname(), dateStr, p.getGender(), p.getPersonalCode(), Integer.toString(age)));
        }
    }
    private static void readFileContents() {
        try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
            int lineCounter = 0;
            for(String line; (line = br.readLine()) != null;) {
                if (lineCounter > 0) {
                    // System.out.println(line);  // Testing
                    String[] parts = line.split(";");
                    // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                    LocalDate date = LocalDate.parse(parts[2], formatter);
                    persons.add(new Person(parts[0], parts[1], date, parts[3], parts[4]));
                }
                lineCounter++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
