package io.egen.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import io.egen.entity.Comments;

@Repository

public interface CommentsRepository {

	public List<Comments> findAllMovieComment ();
	public Comments findMovieCommentById(String id); 
	public Comments createMovieComment(Comments Comment); 
	public Comments updateMovieComment(String id, Comments Movie); 
	public void deleteMovieComment(Comments comment);
	public List<Comments> findAllCommentsOfAMovie(String title_id);

	
}
