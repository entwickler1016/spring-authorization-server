package com.kimblue.auth.api.global.base;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
public interface BaseService<T> {

    /**
     * Returns the List
     * @return List<T></T>
     */
    List<T> findAll();

    /**
     * Returns the Row
     * @param id
     * @return Optional Row
     */
    Optional<T> findById(String id);

    /**
     * Returns the Row
     * @param t (excluded id)
     * @return Optional Row to result of insert
     */
    @Transactional
    Optional<T> insert(T t);

    /**
     * Returns the Row
     * @param t (included id)
     * @return Optional Row to result of update
     */
    @Transactional
    Optional<T> update(T t);

    /**
     * Returns the Boolean
     * @param id
     * @return Boolean to result of delete (after findById)
     */
    @Transactional
    boolean delete(String id);
}
