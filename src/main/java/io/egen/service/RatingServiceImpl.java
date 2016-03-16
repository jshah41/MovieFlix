package io.egen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.egen.entity.Rating;
import io.egen.repository.RatingRepository;

@Service
public class RatingServiceImpl implements RatingService{
	
	@Autowired
	private RatingRepository ratingdao;

	@Override
	public List<Rating> getRatingByUser(int userId) {
		
		return ratingdao.getRatingByUser(userId);
	}

	@Override
	public List<Rating> getRatingByTitle(int titleId) {
		
		return ratingdao.getRatingByTitle(titleId);
	}

	@Override
	public Double getAverageRatingForTitle(int titleId) {
		
		return ratingdao.getAverageRatingForTitle(titleId);
	}
	
	

}
