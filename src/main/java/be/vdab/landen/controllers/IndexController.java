package be.vdab.landen.controllers;

import be.vdab.landen.services.LandService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Controller
@RequestMapping("/")
class IndexController {
    private final LandService landService;

    IndexController(LandService landService) throws IOException {
        this.landService = landService;

/*        System.out.println("Besturingssysteem:" + System.getProperty("os.name"));
        System.out.println("Gebruikersnaam:" + System.getProperty("user.name"));
        System.out.println("Home directory van de gebruiker:" + System.getProperty("user.home"));*/

        //verwijst naar de directory waarin je vertoeft in de CLI
        var homeDirectory = Path.of(System.getProperty("user.home"));
        var bestand =  homeDirectory.resolve("organisatie.txt");
        if (!Files.exists(bestand)) {
            Files.writeString(bestand, "VDAB");
            System.out.println(bestand + " gemaakt");
        }
    }

    @GetMapping
    public ModelAndView index() {
        return new ModelAndView("index", "aantalLanden", landService.findAantal());
    }
}