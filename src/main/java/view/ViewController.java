package view;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

@RestController
@RequestMapping(path = "/")
public class ViewController {

    @RequestMapping(path = "", method = RequestMethod.GET)
    public String index() throws IOException {
        List<String> lines = Files.readAllLines(new File("src/main/resources/index.html").toPath());
        StringBuilder builder = new StringBuilder();
        lines.forEach(builder::append);
        return builder.toString();
    }

}
