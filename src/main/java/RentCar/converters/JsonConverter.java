package RentCar.converters;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Optional;

public abstract class JsonConverter<T> {

    private final String jsonFileName;
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private final Type type = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    public JsonConverter(String jsonFileName) {
        this.jsonFileName = jsonFileName;
    }

    public void toJson(final T element) {
        try (FileWriter fileWriter = new FileWriter(jsonFileName)) {
            if (element == null) {
                throw new NullPointerException("Element is null");
            }
            gson.toJson(element, fileWriter);
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
    }

    public Optional<T> fromJson() {
        try (FileReader fileReader = new FileReader(jsonFileName)) {
            return Optional.of(gson.fromJson(fileReader, type));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
