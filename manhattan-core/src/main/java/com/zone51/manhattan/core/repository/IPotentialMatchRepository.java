/**
 * 
 */
package com.zone51.manhattan.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zone51.manhattan.core.domain.PotentialMatch;

/**
 * @author piot
 *
 */
public interface IPotentialMatchRepository extends JpaRepository<PotentialMatch, Long> {

}
