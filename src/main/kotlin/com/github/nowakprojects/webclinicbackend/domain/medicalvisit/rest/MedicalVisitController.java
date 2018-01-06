package com.github.nowakprojects.webclinicbackend.domain.medicalvisit.rest;

import com.github.nowakprojects.webclinicbackend.domain.authentication.persistence.entity.User;
import com.github.nowakprojects.webclinicbackend.global.annotation.CurrentUser;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/medical-visit")
@RestController
public class MedicalVisitController {

    @GetMapping("/day")
    void test(@CurrentUser User user) {
        System.out.println(user.getUsername());
    }
}
