package io.egen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.egen.entity.Comments;


import io.egen.exception.MovieNotFound;
import io.egen.repository.CommentsRepository;



@Service
public class CommentServiceImpl implements CommentService {
	


@Autowired
private CommentsRepository commentsdao;

@Override
public List<Comments> findAllMovieComment() {
	
	return commentsdao.findAllMovieComment();
}

@Override
public Comments findMovieCommentById(String id) throws MovieNotFound {

	
	return commentsdao.findMovieCommentById(id);
}

@Override
public Comments createMovieComment(Comments Comment) {
	
	return commentsdao.createMovieComment(Comment);
}

@Override
public Comments updateMovieComment(String id, Comments Movie) throws MovieNotFound {
	
	return commentsdao.updateMovieComment(id, Movie);
}

@Override
public void deleteMovieComment(Comments comment) throws MovieNotFound {
	
	 commentsdao.deleteMovieComment(comment);
	
}

@Override
public List<Comments> findAllCommentsOfAMovie(String title_id) {
	
	return commentsdao.findAllCommentsOfAMovie(title_id);
}


	

	


	

	
	
}
