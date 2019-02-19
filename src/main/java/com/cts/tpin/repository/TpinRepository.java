package com.cts.tpin.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cts.tpin.dbo.TpinDbo;
import com.cts.tpin.transport.Tpin;

@Repository
public interface TpinRepository extends CrudRepository<TpinDbo ,Long>{

}
