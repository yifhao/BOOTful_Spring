package com.july.repository;

import com.july.domain.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by haoyifen on 2017/5/26 11:14.
 */
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {
    List<Customer> findByLastName(String lastname);

    @Query(value = "select u from Customer u where u.id=:id")
    Customer findCustomer(@Param("id") Long id);
}
