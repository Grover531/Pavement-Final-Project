package com.pavement.dao.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pavement.dao.RenterDAO;
import com.pavement.model.Renter;

@Controller
public class MainController {

	@Autowired
	private RenterDAO renterDAO;

	@RequestMapping(value = "/")
	public ModelAndView listRenter(ModelAndView model) {
		List<Renter> listRenter = renterDAO.list();
		model.addObject("listRenter", listRenter);
		model.setViewName("index");

		return model;
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public ModelAndView newRenter(ModelAndView model) {
		Renter newRenter = new Renter();
		model.addObject("renter", newRenter);
		model.setViewName("renter_form");

		return model;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveRenter(@ModelAttribute Renter renter) {
		if (renter.getId() == null) {
			renterDAO.save(renter);
		} else {
			renterDAO.update(renter);
		}

		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView editRenter(HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Renter renter = renterDAO.get(id);

		ModelAndView model = new ModelAndView("renter_form");

		model.addObject("renter", renter);

		return model;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView deleteRenter(@RequestParam Integer id) {
		renterDAO.delete(id);

		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView visitAdmin() {
		ModelAndView model = new ModelAndView("admin");
		model.addObject("title", "Administrator Control Panel");
		model.addObject("message", "This page demonstrates how to use Spring security.");

		return model;
	}

}