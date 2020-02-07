package com.ranyell.couseSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ranyell.couseSpring.domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
