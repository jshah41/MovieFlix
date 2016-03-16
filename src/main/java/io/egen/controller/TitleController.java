package io.egen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.egen.entity.Title;
import io.egen.exception.MovieBadRequest;
import io.egen.exception.MovieNotFound;
import io.egen.service.MovieService;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/title")
@Api(tags="title")
public class TitleController {

	@Autowired
	private MovieService titleservice;
	
	@RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	
	public List<Title> findAll(){
		
		return titleservice.listTitle();
		
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	
	public Title findTitle(@PathVariable("id") String id) throws MovieNotFound{
		
		return titleservice.getTitleById(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, 
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	
	public Title addTitle(@RequestBody Title title) throws MovieBadRequest{
		
		return titleservice.addTitle(title);
	}
	
	@RequestMapping(value="{id}", 
			method=RequestMethod.PUT,
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	
	public Title updateTitle( @PathVariable("id") String id,@RequestBody Title title) throws MovieNotFound{
		
		return titleservice.updateTitle(id, title);
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_VALUE)
	
	public Title removeTitle(@PathVariable("id") String id) throws MovieNotFound
	{
		
		return titleservice.removeTitle(id);
	}

	
	@RequestMapping(value="/titlesearch",method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	
	public List<Title> getTitleByTerm(@RequestParam(required=true,value="title") String title){

	return titleservice.getTitlebySearch(title);
}
	
	@RequestMapping(value="/yearsearch",method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Title> getTitleByYear(@RequestParam(required=true,value="year") Integer year) {
		return this.titleservice.getTitlebyYear(year);
	}
	
	@RequestMapping(value="/genresearch",method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Title> getTitleByGenre(@RequestParam(required=true,value="genre") String genre) {
		return this.titleservice.getTitlebyGenre(genre);
	}
	
	@RequestMapping(value="/typesearch",method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Title> getTitleByType(@RequestParam(required=true,value="type") String type) {
		return this.titleservice.getTitlebyType(type);
	}

}
