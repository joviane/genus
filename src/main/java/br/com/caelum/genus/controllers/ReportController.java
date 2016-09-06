package br.com.caelum.genus.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.caelum.genus.daos.TraineeDao;
import br.com.caelum.genus.dtos.InfoHorasDetalhado;
import br.com.caelum.genus.dtos.InfoHorasGastas;
import br.com.caelum.genus.models.Trainee;

@RequestMapping("/report")
@Controller
public class ReportController {
	
	@Autowired
	private TraineeDao traineeDao;

	@RequestMapping(value="/relatorioTrainees")
	public ModelAndView horasGastas(){
		ModelAndView modelAndView = new ModelAndView("/report/instrutor");
		List<InfoHorasGastas> timeSpent = traineeDao.findTimeSpent();
		return modelAndView.addObject("listaHoras",timeSpent);
	}
	
	@RequestMapping(value="/treinos	/{traineeNome}")
	public ModelAndView horasGastasDetalhadoDoTrainee(@PathVariable String traineeNome){
		ModelAndView modelAndView = new ModelAndView("/report/traineeDetails/detalhes");
		List<InfoHorasDetalhado> timeSpentFromTrainee = traineeDao.findTimeSpentFromTrainee(traineeNome);
		return modelAndView.addObject("listaHorasDetalhadas",timeSpentFromTrainee);
	}
	
	@RequestMapping(value="/faltas/{traineeId}")
	public ModelAndView faltasInstrutor(@PathVariable Integer traineeId){
		ModelAndView modelAndView = new ModelAndView("report/faltas");
		Trainee trainee = traineeDao.findOne(traineeId);
		modelAndView.addObject("traineeNome", trainee.getName());
		modelAndView.addObject("faltas", trainee.getFaltas());
		return modelAndView;
	}
	
}
