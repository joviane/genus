package br.com.caelum.genus.daos;

import java.util.List;

import org.springframework.data.repository.Repository;

import br.com.caelum.genus.models.Trainee;

public interface TraineeDao extends Repository<Trainee, Integer> {
    
    public Trainee save(Trainee trainee);
    
    public List<Trainee> findAll();
    
    public Trainee findOne(Integer id);

}
