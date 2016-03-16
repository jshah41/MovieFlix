package io.egen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.entity.Rating;
import io.egen.exception.MovieNotFound;
import io.egen.exception.UserBadAuthentication;
import io.egen.exception.UserNotFoundException;
import io.egen.service.RatingService;

@RestController
@RequestMapping("/rating")
public class RatingController {

	@Autowired
	private RatingService ratingservice;
	
	@RequestMapping(value = "/user/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Rating> getRatingForUser(@PathVariable("userId") int userId)
			throws UserBadAuthentication, UserNotFoundException {
		return this.ratingservice.getRatingByUser(userId);
	}

	@RequestMapping(value = "/title/{titleId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Rating> getRatingForTitle(@PathVariable("titleId") int titleId)
			throws MovieNotFound {
		return this.ratingservice.getRatingByTitle(titleId);
	}

	@RequestMapping(value = "{titleId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Double getAvgRatingForTitle(@PathVariable("titleId") int titleId)
			throws MovieNotFound {
		return this.ratingservice.getAverageRatingForTitle(titleId);
	}

	
	
}
