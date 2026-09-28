package utilities;

import com.google.gson.Gson;
import io.qameta.allure.Allure;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class helper_Functions
{

    /**
     * Captures a screenshot of the current browser/application state
     * and attaches it to the Allure report.
     *
     * @param test_case The name of the test case used to organize screenshots.
     * @param fileName The name of the screenshot file that will appear in the Allure report.
     * @throws IOException If an error occurs while reading the screenshot file.
     */
    public static void saveScreenshot(String test_case,String fileName) throws IOException {
        Allure.addAttachment(fileName, Files.newInputStream(Path.of(Framework.takeScreenshot(test_case,fileName).getPath())));
    }

    /**
     * Reads a JSON file from the Test_data directory and converts its content
     * into an object of the specified class using the Gson library.
     *
     * This method is useful for loading test data such as user accounts,
     * payment information, or product details into POJO classes.
     *
     * @param fileName The name of the JSON file (without the .json extension).
     * @param clazz The target POJO class to deserialize the JSON into.
     * @param <T> The type of object to be returned.
     * @return An object populated with data from the JSON file.
     * @throws RuntimeException If the JSON file cannot be found or read.
     */
    public static <T> T read_from_json(String fileName, Class<T> clazz)
    {
        final Gson gson=new Gson();
        final String test_data_path="src\\main\\resources\\Test_data\\";

        try( FileReader reader = new FileReader(test_data_path + fileName + ".json") )
        {
            return gson.fromJson(reader,clazz);
        }
        catch (IOException e)
        {
            throw new RuntimeException("failed to read Json file: " + fileName,e);
        }
    }
}
