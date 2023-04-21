package com.kimblue.auth.global.base;

import java.util.List;
import java.util.Optional;

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
    Optional<T> insert(T t);

    /**
     * Returns the Row
     * @param t (included id)
     * @return Optional Row to result of update
     */
    Optional<T> update(T t);

    /**
     * Returns the Boolean
     * @param id
     * @return Boolean to result of delete (after findById)
     */
    boolean delete(String id);
}
