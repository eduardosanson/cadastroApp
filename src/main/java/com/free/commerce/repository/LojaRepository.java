package com.free.commerce.repository;

import com.free.commerce.entity.Loja;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

/**
 * Created by eduardosanson on 05/03/16.
 */
public interface LojaRepository extends CrudRepository<Loja,Long> {

    @Override
    Loja findOne(Long aLong);

    @Override
    boolean exists(Long aLong);

    @Override
    Iterable<Loja> findAll();

    @Override
    Iterable<Loja> findAll(Iterable<Long> iterable);

    @Override
    long count();

    @Override
    void delete(Long aLong);

    @Override
    void delete(Loja loja);

    @Override
    void delete(Iterable<? extends Loja> iterable);

    @Override
    void deleteAll();
}
