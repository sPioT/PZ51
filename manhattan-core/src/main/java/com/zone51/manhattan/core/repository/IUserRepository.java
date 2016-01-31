/**
 * 
 */
package com.zone51.manhattan.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zone51.manhattan.core.domain.User;

/**
 * @author piot
 *
 */
@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

}
