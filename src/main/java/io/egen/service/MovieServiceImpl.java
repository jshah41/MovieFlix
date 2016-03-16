package io.egen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.egen.entity.Title;
import io.egen.exception.MovieBadRequest;
import io.egen.exception.MovieNotFound;
import io.egen.repository.TitleRepository;


@Service
public class MovieServiceImpl implements MovieService {
	


	@Autowired
	private TitleRepository titledao;

	@Override
	public Title addTitle(Title title) throws MovieBadRequest {
		
		String existing=title.getTitle();
		if(existing==null)
		{
			throw new MovieBadRequest();
		}
		
		return titledao.addTitle(title);
		
	}

	@Override
	public Title updateTitle(String id, Title title) throws MovieNotFound {
		
		Title exist=titledao.getTitleById(id);
		
		if(exist==null)
		{
			throw new MovieNotFound();
		}
		
		return titledao.updateTitle(title);
	}

	@Override
	public Title removeTitle(String id) throws MovieNotFound {
		
     Title exist=titledao.getTitleById(id);
		
		if(exist==null)
		{
			throw new MovieNotFound();
		}
		
		return titledao.removeTitle(id);
	}

	@Override
	public List<Title> listTitle() {
		
		return titledao.listTitle();
	}

	@Override
	public Title getTitleById(String id) throws MovieNotFound {
		
		Title title=titledao.getTitleById(id);
		if(title==null)
		{
			throw new MovieNotFound();
			
		}
		
		return title;
	}

	@Override
	public List<Title> getTitlebySearch(String title) {
		
		
		return titledao.getTitleBySearch(title);
	}

	@Override
	public List<Title> getTitlebyYear(int year) {
		
		return titledao.getTitleByYear(year);
	}

	@Override
	public List<Title> getTitlebyType(String type) {
		
		return titledao.getTitleByType(type);
	}

	@Override
	public List<Title> getTitlebyGenre(String genre) {
		
		return titledao.getTitleByGenre(genre);
	}

}
