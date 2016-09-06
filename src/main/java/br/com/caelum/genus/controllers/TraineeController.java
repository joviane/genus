package br.com.caelum.genus.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.caelum.genus.daos.FaltaDao;
import br.com.caelum.genus.daos.TraineeDao;
import br.com.caelum.genus.dtos.InfoDataTrainee;
import br.com.caelum.genus.dtos.InfoHorasDetalhado;
import br.com.caelum.genus.dtos.InfoHorasGastas;
import br.com.caelum.genus.dtos.InfoStatus;
import br.com.caelum.genus.models.Falta;
import br.com.caelum.genus.models.Status;
import br.com.caelum.genus.models.Trainee;

@RequestMapping("/trainee")
@Controller
public class TraineeController {

	@Autowired
	private TraineeDao traineeDao;
	
	@Autowired
	private FaltaDao faltaDao;

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
	
	@Transactional
	@RequestMapping(value="/changeStatus", method = RequestMethod.PATCH)
	public void changeStatus(@RequestBody InfoStatus status) {
		Trainee trainee = traineeDao.findOne(status.getTraineeId());
		trainee.setStatus(status.getStatus());
	}
	
	@Transactional
	@RequestMapping(value="/faltas/{traineeId}", method = RequestMethod.GET)
	public ModelAndView faltaForm(@Valid Falta falta, BindingResult result, @PathVariable Integer traineeId) {
		return new ModelAndView("trainee/faltas").addObject("traineeId", traineeId);
	}

	@Transactional
	@RequestMapping(value="/faltas/{traineeId}", method = RequestMethod.POST)
	public ModelAndView faltaCreate(@Valid Falta falta, BindingResult result, @PathVariable Integer traineeId) {
		if(result.hasErrors()){
			ModelAndView modelAndView = new ModelAndView("trainee/faltas");
			return modelAndView.addObject("traineeId", traineeId);
		}
		Trainee trainee = traineeDao.findOne(traineeId);
		faltaDao.save(falta);
		trainee.changeStatus(falta);
		ModelAndView modelAndView = new ModelAndView("redirect:/trainee");
		return modelAndView.addObject("traineeId", traineeId);
	}
	
	@RequestMapping(value="/buscaPorStatus", method = RequestMethod.POST)
	public ModelAndView filtraPorStatus(Trainee trainee, Status status){
		return new ModelAndView("/trainee/form").addObject("trainees", traineeDao.findByProgressStatus(status));
	}
	
	@RequestMapping(value="/buscaPorPeriodo", method = RequestMethod.POST)
	public ModelAndView filtraPorStatus(Trainee trainee, InfoDataTrainee info){
		return new ModelAndView("/trainee/form")
				.addObject("trainees",traineeDao.findByPeriodo(info.getInicio().atStartOfDay(), info.getFim().atStartOfDay()));
	}
	
	@RequestMapping(value="/relatorio")
	public ModelAndView horasGastas(){
		ModelAndView modelAndView = new ModelAndView("/trainee/horasGastas");
		List<InfoHorasGastas> timeSpent = traineeDao.findTimeSpent();
		return modelAndView.addObject("listaHoras",timeSpent);
	}

	@RequestMapping(value="/horasGastas/{traineeNome}")
	public ModelAndView horasGastasDetalhadoDoTrainee(@PathVariable String traineeNome){
		ModelAndView modelAndView = new ModelAndView("/trainee/horasGastas/detalhes");
		List<InfoHorasDetalhado> timeSpentFromTrainee = traineeDao.findTimeSpentFromTrainee(traineeNome);
		return modelAndView.addObject("listaHorasDetalhadas",timeSpentFromTrainee);
	}
	
}
