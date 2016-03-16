package io.egen.service;

import java.util.List;

import org.springframework.stereotype.Service;

import io.egen.entity.Title;
import io.egen.exception.MovieBadRequest;
import io.egen.exception.MovieNotFound;

@Service

public interface MovieService {
	
	public Title addTitle(Title title) throws MovieBadRequest;
	public Title updateTitle(String id,Title title) throws MovieNotFound;
	public Title removeTitle(String id) throws MovieNotFound;
	public List<Title> listTitle();
	public Title getTitleById(String id) throws MovieNotFound;
	public List<Title> getTitlebySearch(String title);
	public List<Title> getTitlebyYear (int year);
	public List<Title> getTitlebyType(String type);
	public List<Title> getTitlebyGenre(String genre);
	
	

}
