package br.com.marvelapi.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.marvelapi.model.Characters;

@Repository
public interface CharactersRepository extends PagingAndSortingRepository<Characters, Integer> {

	public Characters findById(@Param("id") String id);

	@Query("select c from characters c left join fetch c.thumbnail where c.id = ?1")
	public Characters findByFetchThumbnail(Integer id);
}
