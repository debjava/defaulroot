package com.ddlab.rnd.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import com.ddlab.rnd.model.InfoModel;

import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
// @RestController
public class DefaultController {
    
	// @GetMapping(path = "/")
	// public ResponseEntity<String> getValue() {
	// 	return ResponseEntity.ok("Hello World");
	// }

    @GetMapping(path = "/hati")
	public ResponseEntity<String> getHatiValue() {
		return ResponseEntity.ok("Hati Information");
	}

    // @GetMapping(path = "/info")
	// public ResponseEntity<String> getInfoValue() {
	// 	return ResponseEntity.ok("Some Information");
	// }

    @GetMapping(value = "/")
    public void redirectToServices(HttpServletResponse httpServletResponse){
        // httpServletResponse.setHeader("Location", "/services");
        httpServletResponse.setHeader("Location", "/my-service/info");
        httpServletResponse.setStatus(302);
    }

	@GetMapping("/info")
	public String viewHomePage(@ModelAttribute("infoModel") InfoModel infoModel) {
		infoModel.setAppName("Some Service");
		// String[] profiles = env.getActiveProfiles();
		// String activeProfile = (profiles.length == 0) ? "default"
		// 		: Arrays.asList(profiles).stream().collect(Collectors.joining(","));
		// log.debug("Active profile Name: " + activeProfile);
		infoModel.setProfileName("Development");
		infoModel.setJavaVersion("JDK 17");
		infoModel.setSpringVersion("Spring Framework 6.0.9");
		infoModel.setDateStr(new Date().toString());
		infoModel.setAppVersion("1.0.0");
		return "index.html";
	}
}
