package io.egen.repository;



import java.util.List;

import org.springframework.stereotype.Repository;

import io.egen.entity.Rating;

@Repository
public interface RatingRepository {

	public Double getAverageRatingForTitle(int titleId);

	public void removeRatingForUser(int userId);

	public void removeRatingForTitle(int titleId);
	
	public Rating addRating(Rating r);
	
	public List<Rating> getRatingByUser(int userId);

	public List<Rating> getRatingByTitle(int titleId);
	

}
