import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountServiceTest {

    @Test
    void testRegisterAccountFromCSV() throws IOException {
        AccountService service = new AccountService();

        String inputFile = "src/test/resources/test-data.csv";
        String outputFile = "src/test/resources/UnitTest.csv";

        List<String> lines = Files.readAllLines(Paths.get(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

        // ghi header mới
        writer.write(lines.get(0) + ",actual,result");
        writer.newLine();

        for (int i = 1; i < lines.size(); i++) {
            String[] data = lines.get(i).split(",");

            String username = data[0];
            String password = data[1];
            String email = data[2];
            boolean expected = Boolean.parseBoolean(data[3]);

            service.setUsername(username);
            service.setPassword(password);
            service.setEmail(email);

            boolean actual = service.registerAccount();


            assertEquals(expected, actual);

            // ghi kết quả vào file UnitTest.csv
            writer.write(lines.get(i) + "," + actual + "," +
                    (expected == actual ? "PASS" : "FAIL"));
            writer.newLine();
        }

        writer.close();
    }
}
