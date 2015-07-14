package ar.edu.desapp.groupa.services;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ar.edu.desapp.groupa.entity.Entity;
import ar.edu.desapp.groupa.model.symptom.Symptom;
import ar.edu.desapp.groupa.repositories.GenericRepository;

public class GenericService<T> implements Serializable {

    private static final long serialVersionUID = -6540963495078524186L;

    private GenericRepository<T> repository;

    public GenericRepository<T> getRepository() {
        return this.repository;
    }

    public void setRepository(final GenericRepository<T> repository) {
        this.repository = repository;
    }

    @Transactional
    public void delete(final T object) {
        this.getRepository().delete(object);
    }

    @Transactional(readOnly = true)
    public List<T> retriveAll() {
        return this.getRepository().findAll();
    }

    @Transactional
    public void save(final T object) {
        this.getRepository().save(object);
    }

    @Transactional
    public void update(final T object) {
        this.getRepository().update(object);
    }
    
    @Transactional(readOnly = true)
    public T findById(final Integer id) {
    	return this.getRepository().findById(id);
    }
    
    @Transactional
    public List<T> retriveAllById(List<Integer> ids) {
    	List<T> list = new ArrayList<T>();
    	for(T entity : this.retriveAll()) {
    		if(ids.contains(((Entity) entity).getId())) {
    			list.add(entity);
    		}
    	}
		return list;
	}

}
