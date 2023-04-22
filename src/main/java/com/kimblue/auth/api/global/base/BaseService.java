package com.kimblue.auth.api.global.base;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
public interface BaseService<T> {

    /**
     * Returns the List
     * @return List<T></T>
     */
    @Transactional(readOnly = true)
    List<T> findAll();

    /**
     * Returns the Row
     * @param id
     * @return Optional Row
     */
    @Transactional(readOnly = true)
    T findById(String id);

    /**
     * Returns the Row
     * @param t (excluded id)
     * @return Optional Row to result of insert
     */
    @Transactional
    T insert(T t);

    /**
     * Returns the Row
     * @param t (included id)
     * @return Optional Row to result of update
     */
    @Transactional
    T update(T t);

    /**
     * Returns the Boolean
     * @param id
     * @return Boolean to result of delete (after findById)
     */
    @Transactional
    boolean delete(String id);
}
