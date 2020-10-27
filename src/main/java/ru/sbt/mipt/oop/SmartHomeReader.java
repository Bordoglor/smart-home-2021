package ru.sbt.mipt.oop;

import com.google.gson.Gson;
<<<<<<< Updated upstream
=======
import org.springframework.stereotype.Component;
>>>>>>> Stashed changes

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

<<<<<<< Updated upstream
=======
@Component
>>>>>>> Stashed changes
public class SmartHomeReader implements SmartHomeReadable{

    public SmartHome getSmartHome() {
        Gson gson = new Gson();
        String json = null;
        try {
            json = new String(Files.readAllBytes(Paths.get("smart-home-1.js")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return gson.fromJson(json, SmartHome.class);
    }
}
