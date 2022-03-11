package com.gsearch.api;

import java.util.*;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class LocationController {

	private static final String[] LOCATIONS = new String[]{"Chennai", "Brussels", "New York"};

	@GetMapping(value = "/location")
	public ResponseEntity<?> getLocation() {
		int idx = new Random().nextInt(LOCATIONS.length);
		return ResponseEntity.ok().body(LOCATIONS[idx]);
	}
}
