package cl.duoc.sarayaa.myfirstapirest.controller;

import cl.duoc.sarayaa.myfirstapirest.controller.response.GreetingResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greetings")
public class GreetingController {

    @GetMapping("/hello")
    public ResponseEntity<GreetingResponse> hello() {
        var response = new GreetingResponse();
        response.setGreeting("Hola Mundo!!!");
        return ResponseEntity.ok(response);
    }

    // http:localhost:8080/greetings/hello-guest?name=Sergio&lastname=Araya
    @GetMapping("/hello-guest")
    public ResponseEntity<GreetingResponse> helloGuest(@RequestParam(required = false, value = "name") String name,
                                                       @RequestParam(required = false, value = "lastname") String lastName) {
        var response = new GreetingResponse();
        response.setGreeting("Hello " + name + " " + lastName);
        return ResponseEntity.ok(response);
    }
}