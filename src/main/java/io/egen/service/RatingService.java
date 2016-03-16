package io.egen.service;

import java.util.List;

import org.springframework.stereotype.Service;

import io.egen.entity.Rating;

@Service
public interface RatingService {
	
	public List<Rating> getRatingByUser(int userId) ;
	public List<Rating> getRatingByTitle(int titleId);

	public Double getAverageRatingForTitle(int titleId);

	
}
