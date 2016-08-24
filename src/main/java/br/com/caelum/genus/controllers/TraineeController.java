package br.com.caelum.genus.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.caelum.genus.daos.TraineeDao;
import br.com.caelum.genus.models.Trainee;

@RequestMapping("/trainee")
@Controller
public class TraineeController {
    
    @Autowired
    private TraineeDao traineeDao;

    @RequestMapping(method=RequestMethod.GET)
    public String form(Trainee trainee) {
	return "trainee/form";
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public String create(@Valid Trainee trainee, BindingResult result) {
	if(result.hasErrors()){	    
	    return form(trainee);
	}
	traineeDao.save(trainee);
	return "success";
    }
}
