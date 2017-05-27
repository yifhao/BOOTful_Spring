package com.july.repository;

import com.july.domain.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

/**
 * Created by haoyifen on 2017/5/26 11:14.
 */
@RepositoryRestResource
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {
    @RestResource(path = "/byLastName")
    List<Customer> findByLastName(String lastname);

    @Query(value = "select u from Customer u where u.id=:id")
    Customer findCustomer(@Param("id") Long id);
}
