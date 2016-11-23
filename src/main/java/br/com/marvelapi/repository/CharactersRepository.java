package br.com.marvelapi.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import br.com.marvelapi.model.Characters;

@Repository
@RepositoryRestResource(collectionResourceRel = "characters", path = "personagens")
public interface CharactersRepository extends PagingAndSortingRepository<Characters, Integer> {

	Characters findById(@Param("id") Integer id);

	List<Characters> findByName(@Param("name") String name);
}
