package com.gsearch.api;

import java.util.*;
import java.util.stream.*;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.core.*;
import com.gsearch.dto.*;

@RestController
public class SearchController {

	/**
	 *
	 * @param searchTerm
	 * @return
	 * @throws JsonProcessingException
	 */
	@GetMapping(value = "/search")
	public ResponseEntity<?> search(@RequestParam String searchTerm) {
		List<Data> searchResponse = testData();
		List<Data> contentList = searchResponse.stream().filter(p -> p.getTitle().equals(searchTerm))
				.collect(Collectors.toList());
		if (!contentList.isEmpty()) {
			return ResponseEntity.ok().body(contentList);
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	public List<Data> testData() {
		List<Data> searchResponse = new ArrayList<>();
		searchResponse.add(new Data("google",
				"Search the world's information, including webpages, images, videos and more. Google has many special features to help you find exactly what you're looking",
				"www.google.com"));

		searchResponse.add(new Data("google",
				"Discover all the latest about our products, technology, and Google culture on our official blog.",
				"https://about.google.com"));

		searchResponse.add(new Data("facebook",
				"Create an account or log into Facebook. Connect with friends, family and other people you know. Share photos and videos, send messages and get updates.",
				"https://www.facebook.com/"));

		searchResponse.add(new Data("whatsapp web",
				"Quickly send and receive WhatsApp messages right from your computer", "https://web.whatsapp.com/"));

		searchResponse.add(new Data("youtube",
				"Enjoy the videos and music you love, upload original content, and share it all with friends, family, and the world on YouTube.",
				"https://www.youtube.com/"));

		searchResponse.add(new Data("amazon",
				"Enjoy exclusive Amazon Originals as well as popular movies and TV shows. Watch anytime, anywhere. Start your free trial.",
				"https://www.primevideo.com/"));

		searchResponse.add(new Data("amazon", "News announcements, original stories, and facts about Amazon",
				"https://www.aboutamazon.com"));

		return searchResponse;
	}

}
