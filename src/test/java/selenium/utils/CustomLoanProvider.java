package selenium.utils;

import lombok.SneakyThrows;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.io.FileReader;
import java.util.stream.Stream;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class CustomLoanProvider implements ArgumentsProvider {
    JSONObject loans = (JSONObject) readJson("src/test/java/selenium/testData/loans.json");
    JSONObject approvedLoan = (JSONObject) loans.get("approvedLoan");
    JSONObject deniedLoan = (JSONObject) loans.get("deniedLoan");
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {

        return Stream.of(
                arguments(approvedLoan),
                arguments(deniedLoan)
        );
    }

    @SneakyThrows
    public static Object readJson(String filename) {
        FileReader reader = new FileReader(filename);
        JSONParser jsonParser = new JSONParser();
        return jsonParser.parse(reader);
    }
}
