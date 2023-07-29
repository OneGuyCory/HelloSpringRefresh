package org.launchcode.hellospringrefresh.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello") // every method now begins with /hello/method
public class HelloController {

    // path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    // handles requests of form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

    //handles requests for form /hello/LaunchCode
    @GetMapping("{name}")
    public String helloAgain(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    @GetMapping("/form")
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action='helloPost' method='post'>" + //submit request to /hello
                "<input type='text' name='name'>" +
                "<select name='language'>" +
                    "<option value=''>--Please choose an option--</option>" +
                    "<option value='english'>English</option>" +
                    "<option value='french'>French</option>" +
                    "<option value='spanish'>Spanish</option>" +
                    "<option value='italian'>Italian</option>" +
                    "<option value='german'>German</option>" +
                "</select>" +
                "<input type='submit' value='Greet Me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

    @RequestMapping(value="helloPost", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String helloPost(@RequestParam String name, @RequestParam String language) {
        if (name == null) {
            name ="World";
        }

        return createMessage(name, language);
    }

    public static String createMessage(String name, String lang) {
        String message ="";
        if (lang.equals("english")) {
            message = "Hello";
        }
        else if (lang.equals("french")) {
            message = "Bonjour";
        }
        else if (lang.equals("spanish")) {
            message = "Hola";
        }
        else if (lang.equals("italian")) {
            message = "Ciao";
        }
        else if (lang.equals("german")) {
            message = "Hallo";
        }

        return message + " " + name;
    }
}
