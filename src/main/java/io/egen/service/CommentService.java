package io.egen.service;

import java.util.List;

import org.springframework.stereotype.Service;

import io.egen.entity.Comments;

import io.egen.exception.MovieNotFound;


@Service
public interface CommentService {

	public List<Comments> findAllMovieComment ();
	public Comments findMovieCommentById(String id)throws MovieNotFound;
	public Comments createMovieComment(Comments Comment); 
	public Comments updateMovieComment(String id, Comments Movie)throws MovieNotFound;
	public void deleteMovieComment(Comments comment)throws MovieNotFound;
	public List<Comments> findAllCommentsOfAMovie(String title_id);
}
