package christmas;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;

public class PrintTest {
    @BeforeEach
    final protected void resetProgram() {
        Console.close();
    }

    final protected OutputStream out = new ByteArrayOutputStream();

    final protected void run(String... args) {
        handleInput(args);
        Application.main(new String[]{});
        initializeOutput();
    }

    private void handleInput(String... args) {
        String input = String.join("\n", args);
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    final protected void initializeOutput() {
        System.setOut(new PrintStream(out));
    }

    final protected String printedOutput() {
        return out.toString().trim();
    }
}
