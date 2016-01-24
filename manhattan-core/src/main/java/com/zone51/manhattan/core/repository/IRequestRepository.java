/**
 * 
 */
package com.zone51.manhattan.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zone51.manhattan.core.domain.Request;

/**
 * @author piot
 *
 */
public interface IRequestRepository extends JpaRepository<Request, Long> {

	@Query("select r from Request r where r.user.id = :userId")
	List<Request> findAllByUser(@Param("userId") Long userId);

}
