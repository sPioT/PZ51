/**
 * 
 */
package com.zone51.manhattan.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zone51.manhattan.core.domain.PotentialMatch;

/**
 * @author piot
 *
 */
@Repository
public interface IPotentialMatchRepository extends JpaRepository<PotentialMatch, Long> {

}
