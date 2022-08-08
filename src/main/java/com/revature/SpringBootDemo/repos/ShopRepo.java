package com.revature.SpringBootDemo.repos;

import com.revature.SpringBootDemo.models.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
/*
The Spring Data module takes this simplification one step further by providing standard implementation for common DAO
methods allowing for the removal of the DAO implementation and only requiring the definition of the DAO interface
methods.

In order to leverage the Spring Data programming model with JPA, a DAO interface should extend the Spring JpaRepository
interface from the org.springframework.data.jpa.repository package.
 */

/*
    Extending the CrudRepository should implement the following CRUD operations for us:
    save()
    saveAll()
    findById()
    existsById()
    findAll()
    findAllById()
    count()
    deleteById()
    delete()
    deleteAll()

    DOES NOT HAVE UPDATE methods

    When we are using the Query annotation, you have to add the wildcard(?) with param numbers that indicates
    the index of the values
    Example of an update using @Query:


     */

@Repository
@Transactional
public interface ShopRepo extends JpaRepository<Shop,Integer>{

    @Modifying
    @Query(value = "UPDATE shops SET s_name=?1, s_inven_count=?2 WHERE s_id=?3", nativeQuery = true)
    public int update(String name, int inventoryCount, int id);

}
