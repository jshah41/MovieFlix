package io.egen.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;



import io.egen.entity.Title;

@Repository

public class TitleRepositoryImpl implements TitleRepository {

	@PersistenceContext
	private EntityManager em;
	
	public TitleRepositoryImpl(){
		
	}

	@Override
	@Transactional
	
	public Title addTitle(Title title) {
	
		em.persist(title);
		return title;
	}
	
	

	@Override
	@Transactional
	public Title updateTitle(Title title) {
		
		return em.merge(title);
	}

	@Override
	@Transactional
	public Title removeTitle(String id) {
		
		Title title=em.find(Title.class, id);
		em.remove(title);
		return title;
	}

	
	@Override
	@Transactional
	public List<Title> listTitle() {
		
		TypedQuery<Title> query=em.createQuery("SELECT u FROM Title u ORDER BY u.year ",Title.class);
		List<Title> title= query.getResultList();
		return title;
	}

	@Override
	@Transactional
	public Title getTitleById(String id) {
		
		Title title=em.find(Title.class, id);
		return title;
	}

	@Override
	@Transactional
	public List<Title> getTitleBySearch(String title) {
		
		Query query= em.createQuery("SELECT t FROM Title t WHERE t.title = :title",Title.class);
		@SuppressWarnings("unchecked")
		List<Title> searchtitle=query.setParameter("title", title).getResultList();
		return searchtitle;
		
		
		
		
	}

	@Override
	@Transactional
	public List<Title> getTitleByType(String type) {
	
		Query query= em.createQuery("SELECT t FROM Title t WHERE t.type=:type",Title.class);
		@SuppressWarnings("unchecked")
		List<Title> title=query.setParameter("type",type).getResultList();
		return title;
		
	}

	@Override
	@Transactional
	public List<Title> getTitleByGenre(String genre) {
		
		Query query= em.createQuery("SELECT t FROM Title t WHERE t.genre=:genre",Title.class);
		@SuppressWarnings("unchecked")
		List<Title> title=query.setParameter("genre",genre).getResultList();
		return title;
	}

	@Override
	public List<Title> getTitleByYear(int year) {
		
		Query query= em.createQuery("SELECT t FROM Title t WHERE t.year=:year",Title.class);
		@SuppressWarnings("unchecked")
		List<Title> title=query.setParameter("year",year).getResultList();
		return title;
	}
	
	
}
