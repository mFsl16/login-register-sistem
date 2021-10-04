package com.faisal.loginsistem.registration;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/registration")
@AllArgsConstructor
public class RegistrationController {

    RegistrationServices registrationServices;

    @PostMapping
    public String register(@RequestBody RegistrationRequest request){
        return registrationServices.register(request);
    }

    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationServices.confirmToken(token);
    }
}
