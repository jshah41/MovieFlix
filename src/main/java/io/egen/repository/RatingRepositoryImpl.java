package io.egen.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import io.egen.entity.Rating;

@Repository
public class RatingRepositoryImpl implements RatingRepository {
	
	@PersistenceContext
	private EntityManager em;

	public RatingRepositoryImpl(){
		
	}

	@Override
	@Transactional
	public Double getAverageRatingForTitle(int titleId) {
		
		Double average=0.0;
		Query query = em.createQuery("select AVG(rating) c from Rating c where c.title_id = :titleId group by title_id");
		@SuppressWarnings("rawtypes")
		List avgRating = query.setParameter("titleId",titleId).getResultList();
		average = (Double) avgRating.get(0);
		return average;
	}

	@Override
	@Transactional
	public void removeRatingForUser(int userId) {
		
		Query query = em.createQuery("SELECT c from Rating c where c.user_id = :userId");
		@SuppressWarnings("unchecked")
		List<Rating> ratingsListByTitle = query.setParameter("userId",userId).getResultList();
		for(Rating r : ratingsListByTitle)
		{
			r.setTitle(null);
			r.setUser(null);
			em.remove(r);
		}
		
	}

	@Override
	@Transactional
	public void removeRatingForTitle(int titleId) {
		
		Query query = em.createQuery("SELECT c from Rating c where c.title_id = :titleId");
		@SuppressWarnings("unchecked")
		List<Rating> ratingsListByTitle = query.setParameter("titleId",titleId).getResultList();
		for(Rating r : ratingsListByTitle)
		{
			r.setTitle(null);
			r.setUser(null);
			em.remove(r);
		}
		
	}

	@Override
	@Transactional
	public Rating addRating(Rating r) {
		
		em.persist(r);
		return r;
	}

	@Override
	@Transactional
	public List<Rating> getRatingByUser(int userId) {
		
		Query query = em.createQuery("SELECT c from Rating c where c.user_Id = :userId");
		@SuppressWarnings("unchecked")
		List<Rating> ratingsListByUser = query.setParameter("userId",userId).getResultList();
		return ratingsListByUser;
	}

	@Override
	@Transactional
	public List<Rating> getRatingByTitle(int titleId) {
		
		Query query = em.createQuery("SELECT c from Rating c WHERE c.title_id=:titleId");
		@SuppressWarnings("unchecked")
		List<Rating> ratingListByTitle = query.setParameter("titleId",titleId).getResultList();
		return ratingListByTitle;
	}


	
	
}
