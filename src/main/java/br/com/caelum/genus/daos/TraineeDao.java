package br.com.caelum.genus.daos;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import br.com.caelum.genus.models.Status;
import br.com.caelum.genus.models.Trainee;

public interface TraineeDao extends Repository<Trainee, Integer> {
    
    public void save(Trainee trainee);
    
    public List<Trainee> findAll();
    
    public Trainee findOne(Integer id);

    public List<Trainee> findByProgressStatus(Status status);

    @Query("select t.trainee from Training t join t.trainee where t.startTime between :inicio and :fim ")
	public List<Trainee> findByPeriodo(@Param("inicio") LocalDateTime localDateTime,@Param("fim") LocalDateTime localDateTime2);
}
