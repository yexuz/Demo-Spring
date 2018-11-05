package spittr.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spittr.Spitter;
import spittr.Spittle;
import spittr.ValidateUtils;
import spittr.data.SpittleRepository;

@Controller
@RequestMapping("/spittles")
public class SpittleController {

	private SpittleRepository spittleRepository;

	private static final String MAX_LONG_AS_STRING = "9223372036854775807";

	@Autowired
	public SpittleController(SpittleRepository repository) {
		this.spittleRepository = repository;
	}
	// 1
	// @RequestMapping(method=RequestMethod.GET)
	// public String spittles(Model model) {
	// model.addAttribute("spittleList",spittleRepository.findSpittles(Long.MAX_VALUE,
	// 20));
	// List<Spittle> spittles = new ArrayList<Spittle>();
	// for (int i = 0; i < 20; i++) {
	// spittles.add(new Spittle("Spittle" + i, new Date()));
	// }
	// model.addAttribute("spittleList",spittles);
	// return "spittles";
	// }

	// 2
	// @RequestMapping(method=RequestMethod.GET)
	// public String spittles(Model model) {
	// model.addAttribute(spittleRepository.findSpittles(Long.MAX_VALUE, 20));
	// return "spittles";
	// }

	// 3
	// @RequestMapping(method=RequestMethod.GET)
	// public String spittles(Map model) {
	// model.put("spittleList", spittleRepository.findSpittles(Long.MAX_VALUE, 20));
	// return "spittles";
	// }
	// 4
	// @RequestMapping(method=RequestMethod.GET)
	// public List<Spittle> spittles() {
	// return spittleRepository.findSpittles(Long.MAX_VALUE, 20);
	// }

	// @RequestMapping(method = RequestMethod.GET)
	// public List<Spittle> spittles(@RequestParam(value = "max", defaultValue =
	// MAX_LONG_AS_STRING) long max,
	// @RequestParam(value = "count", defaultValue = "20") int count) {
	// List<Spittle> createSpittleList = createSpittleList(count);
	// // return spittleRepository.findSpittles(max, count);
	// return createSpittleList;
	//
	// }

	@RequestMapping(value = "/{spittleId}", method = RequestMethod.GET)
	public String showSpittles(@PathVariable("spittleId") long spittleId, String aa,Spitter spitter,Model model) {
		model.addAttribute(spittleRepository.findSpittles(spittleId, 20));
		Spittle spittle = null;
		if (spittle == null) {
			throw new SpittleNotFoundException();
		}
		return "spittle";
	}

	private List<Spittle> createSpittleList(int count) {
		List<Spittle> spittles = new ArrayList<Spittle>();
		for (int i = 0; i < count; i++) {
			spittles.add(new Spittle("Spittle" + i, new Date()));
		}
		return spittles;
	}

	@RequestMapping(value="/save",method = RequestMethod.GET)
	public String saveSpittle(Spittle form, Model model) {
		spittleRepository
				.save(new Spittle(null, form.getMessage(), new Date(), form.getLongitude(), form.getLatitude()));
		return "redirect:/spittles";

	}

	@ExceptionHandler(DuplicateSpittleException.class)
	public String handleDuplicateSpittle() {
		return "error/duplicate";
	}

}
