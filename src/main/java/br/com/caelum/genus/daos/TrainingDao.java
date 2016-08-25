package br.com.caelum.genus.daos;

import java.util.List;

import org.springframework.data.repository.Repository;

import br.com.caelum.genus.models.Training;

public interface TrainingDao extends Repository<Training, Integer> {

    public Training save(Training training);
    
    public List<Training> findAll();
    
    public Training findOne(Integer id);
}
