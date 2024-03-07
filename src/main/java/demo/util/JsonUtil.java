package demo.util;

import java.io.BufferedReader;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletOutputStream;

public class JsonUtil {

    String value;

    public JsonUtil(String value) {
        this.value = value;
    }

    public static JsonUtil of(BufferedReader reader) {
        StringBuilder sb = new StringBuilder();
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return new JsonUtil(sb.toString());
    }

    public static void toJson(ServletOutputStream reader, Object value) {

        try {
            new ObjectMapper().writeValue(reader, value);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public <T> T toModel(Class<T> tClass) {
        try {
            return new ObjectMapper().readValue(value, tClass);
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
