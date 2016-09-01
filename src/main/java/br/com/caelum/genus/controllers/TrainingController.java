package br.com.caelum.genus.controllers;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.caelum.genus.daos.TraineeDao;
import br.com.caelum.genus.daos.TrainingDao;
import br.com.caelum.genus.dtos.InfoTraining;
import br.com.caelum.genus.models.Trainee;
import br.com.caelum.genus.models.Training;

@RequestMapping("/training")
@Controller
public class TrainingController {
	@Autowired
	private TrainingDao trainingDao;
	@Autowired
	private TraineeDao traineeDao;

	@RequestMapping(value = "/trainee/{traineeId}", method = RequestMethod.GET)
	public ModelAndView form(InfoTraining info, @PathVariable Integer traineeId) {
		ModelAndView modelAndView = new ModelAndView("/training/form");
		Trainee trainee = traineeDao.findOne(traineeId);
		modelAndView.addObject("trainee", trainee);
		Training training = trainingDao.save(new Training(trainee));
		modelAndView.addObject("trainingId", training.getId());
		return modelAndView;
	}

	@Transactional
	@RequestMapping(value = "/trainee/{traineeId}", method = RequestMethod.POST)
	public ModelAndView create(@Valid InfoTraining info, BindingResult result, @PathVariable Integer traineeId) {
		if (result.hasErrors()) {
			return form(info, traineeId);
		}
		Training training = trainingDao.findOne(info.getTrainingId());
		info.updateTrainingDataFromForm(training);
		
		Trainee trainee = traineeDao.findOne(traineeId);
		if(trainee.firstTraining()) {
			trainee.hasBegan();
		}
		
		return new ModelAndView("/success");
	}
}
