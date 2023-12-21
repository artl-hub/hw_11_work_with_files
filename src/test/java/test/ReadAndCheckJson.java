package test;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;

public class ReadAndCheckJson {

    ClassLoader cl = ReadAndCheckJson.class.getClassLoader();
    ObjectMapper objectMapper = new ObjectMapper();


    @Test
    void jsonCheckTest() throws Exception {

        try (
                InputStream resource = cl.getResourceAsStream("laptop.json")
        ) {
            assert resource != null;
            try (InputStreamReader reader = new InputStreamReader(resource)
            ) {
                LaptopObject laptopObject = objectMapper.readValue(reader, LaptopObject.class);
                assertThat(laptopObject.brand).isEqualTo("ACEMAGIC");
                assertThat(laptopObject.model).isEqualTo("AX15");
                assertThat(laptopObject.screen).isEqualTo(15.6);
                assertThat(laptopObject.ram).contains(16, 32, 64);

            }
        }
    }

}
