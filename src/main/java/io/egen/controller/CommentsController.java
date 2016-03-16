package io.egen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.entity.Comments;

import io.egen.exception.MovieNotFound;

import io.egen.service.CommentService;

@RestController
@RequestMapping("/comments")
public class CommentsController {



	
		
		@Autowired
		private CommentService service;
		
		@RequestMapping(method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		
		public List<Comments> findAll()
		{		
			return service.findAllMovieComment();		
		}
		
	@RequestMapping(value="movie/{id}",
				method=RequestMethod.GET,
				produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Comments> findAllCommentsOfAMovie(@PathVariable("id") String movie_id)
	{
			return service.findAllCommentsOfAMovie(movie_id);
	}

		
		@RequestMapping(value="{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
		public Comments findOne(@PathVariable("id") String id) throws MovieNotFound{
			return service.findMovieCommentById(id);
		}

		@RequestMapping(method=RequestMethod.POST, 
				consumes=MediaType.APPLICATION_JSON_VALUE,
				produces=MediaType.APPLICATION_JSON_VALUE)
		
		public Comments create(@RequestBody Comments comment){
			return service.createMovieComment(comment);
		}
		
		@RequestMapping(value="{id}", 
				method=RequestMethod.PUT,
				consumes=MediaType.APPLICATION_JSON_VALUE,
				produces=MediaType.APPLICATION_JSON_VALUE)

		public Comments  update (@PathVariable("id") String id, @RequestBody Comments Comment) throws MovieNotFound{
			return service.updateMovieComment(id, Comment);
		}
		
		@RequestMapping(value="{id}", 
				method=RequestMethod.DELETE,
				consumes=MediaType.APPLICATION_JSON_VALUE,
				produces=MediaType.APPLICATION_JSON_VALUE)
		public void delete(@PathVariable("id") String id) throws MovieNotFound {		
			Comments m = findOne(id);
			service.deleteMovieComment(m);
		}	
	
}
