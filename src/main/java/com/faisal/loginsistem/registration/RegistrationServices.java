package com.faisal.loginsistem.registration;

import com.faisal.loginsistem.appuser.AppUser;
import com.faisal.loginsistem.appuser.AppUserRole;
import com.faisal.loginsistem.appuser.AppUserServices;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationServices {

    private final AppUserServices appUserServices;
    private EmailValidator emailValidator;

    public String register(RegistrationRequest request) {
        boolean emailIsValid = emailValidator.test(request.getEmail());
        if (!emailIsValid) throw new IllegalStateException("email not valid");
        return appUserServices.signUpUser(
                new AppUser(
                        request.getFirstName(),
                        request.getLastName(),
                        request.getEmail(),
                        request.getPassword(),
                        AppUserRole.USER
                )
        );
    }
}
