package com.castudy.repository;

import com.castudy.model.customer.Customer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;




public interface ICustomerRepository extends JpaRepository<Customer,Integer> {
   @Query(value="select * from furama.customer  where names like %:names% and email like %:email% and customer_type_id like %:customer_type% order by names ", nativeQuery=true)
    Page<Customer> searchPage(Pageable pageable, @Param("names") String names, @Param("email") String email, @Param("customer_type") String customer_type);
    @Query(value="update customer set delete_status = 0 where id=:idCustomer", nativeQuery=true)
    void deleteSql(@Param("idCustomer") Integer idCustomer);
}
