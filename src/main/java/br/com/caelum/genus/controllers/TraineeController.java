package br.com.caelum.genus.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.caelum.genus.daos.TraineeDao;
import br.com.caelum.genus.dtos.InfoStatus;
import br.com.caelum.genus.models.Status;
import br.com.caelum.genus.models.Trainee;

@RequestMapping("/trainee")
@Controller
public class TraineeController {

	@Autowired
	private TraineeDao traineeDao;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView form(Trainee trainee) {
		return new ModelAndView("trainee/form").addObject("trainees", traineeDao.findAll());
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView create(@Valid Trainee trainee, BindingResult result) {
		if (result.hasErrors()) {
			return form(trainee);
		}
		traineeDao.save(trainee);
		return new ModelAndView("redirect:/trainee");
	}
	
	@RequestMapping(value="/changeStatus", method = RequestMethod.PATCH)
	public void changeStatus(@RequestBody InfoStatus status) {
		System.out.println(status.getTraineeId() + " " + status.getStatus());
	}
	
}
