/**
 * 
 */
package com.zone51.manhattan.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zone51.manhattan.core.domain.Request;

/**
 * @author piot
 *
 */
public interface IRequestRepository extends JpaRepository<Request, Long> {

}
