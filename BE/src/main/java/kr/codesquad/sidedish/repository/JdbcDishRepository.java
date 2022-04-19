package kr.codesquad.sidedish.repository;

import kr.codesquad.sidedish.domain.Dish;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JdbcDishRepository extends CrudRepository<Dish, Long> {

    @Modifying
    @Query("update dish set is_deleted = true where id = :id")
    public boolean softDelete(Long id);


}
