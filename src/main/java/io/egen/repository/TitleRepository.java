package io.egen.repository;



import java.util.List;

import org.springframework.stereotype.Repository;

import io.egen.entity.Title;

@Repository
public interface TitleRepository {

	public Title addTitle(Title title);
	public Title updateTitle( Title title);
	public Title removeTitle(String id);
	public List<Title> listTitle();
	public Title getTitleById(String id);
	public List<Title> getTitleBySearch(String title);
	public List<Title> getTitleByType(String type);
	public List<Title> getTitleByGenre(String genre);
	public List<Title> getTitleByYear(int year);
	
	 
	
}
