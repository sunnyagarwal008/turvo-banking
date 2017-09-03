package com.turvo.banking.dao;

import com.turvo.banking.model.Counter;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * A DAO for the entity User is simply created by extending the CrudRepository
 * interface provided by spring. The following methods are some of the ones
 * available from such interface: save, delete, deleteAll, findOne and findAll.
 *
 * @author Sunny
 */
@Transactional
public interface CounterDao extends CrudRepository<Counter, Long> {

}
