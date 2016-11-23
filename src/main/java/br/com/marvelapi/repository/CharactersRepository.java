package br.com.marvelapi.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.marvelapi.model.Characters;

@Repository
public interface CharactersRepository extends PagingAndSortingRepository<Characters, Integer> {

	public Characters findById(@Param("id") Integer id);
}
