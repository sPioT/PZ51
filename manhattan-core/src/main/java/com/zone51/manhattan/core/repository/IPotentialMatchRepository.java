/**
 * 
 */
package com.zone51.manhattan.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zone51.manhattan.core.domain.Sport;

/**
 * @author piot
 *
 */
public interface IPotentialMatchRepository extends JpaRepository<Sport, Long> {

}
