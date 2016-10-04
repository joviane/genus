package br.com.caelum.genus.daos;

import org.springframework.data.repository.Repository;

import br.com.caelum.genus.models.Falta;

public interface FaltaDao extends Repository<Falta, Integer> {

    public Falta save(Falta falta);

}
