package io.egen.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import io.egen.entity.Comments;


@Repository
public class CommentsRepositoryImpl implements CommentsRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	public CommentsRepositoryImpl(){
		
	}

	@Override
	@Transactional
	public List<Comments> findAllMovieComment() {
		
		Query findQuery = em.createQuery("select c from Comments c");		
		
    	@SuppressWarnings("unchecked")
		List<Comments> comment = findQuery.getResultList();
    	return comment;
	}

	@Override
	@Transactional
	public Comments findMovieCommentById(String id) {
		
		return em.find(Comments.class, id);
	}

	@Override
	@Transactional
	public Comments createMovieComment(Comments Comment) {
		
		em.persist(Comment);
		return Comment;
	}

	@Override
	@Transactional
	public Comments updateMovieComment(String id, Comments Movie) {
		
		em.merge(Movie);
		return Movie;
	}

	@Override
	@Transactional
	public void deleteMovieComment(Comments comment) {

		comment=em.find(Comments.class, comment.getId());
		em.remove(comment);
		
	}

	@Override
	@Transactional
	public List<Comments> findAllCommentsOfAMovie(String title_id) {
		
		TypedQuery<Comments> findQuery = em.createQuery("select c from Comments c where c.title.title_id=:title_id", Comments.class);
		findQuery.setParameter("title_id", title_id);
    	List<Comments> comment = findQuery.getResultList();
    	return comment;
	}

	



}
