package sn.ucad.master2soir.NdiayeMamadou.web;



import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sn.ucad.master2soir.NdiayeMamadou.bo.Consignataire;
import sn.ucad.master2soir.NdiayeMamadou.dao.ConsignataireRepository;

@Controller
public class ConsignataireControler {

	@Autowired
	private ConsignataireRepository consignataireRepository;
	@RequestMapping(value="/user/index4")
	public String index(Model model,
			@RequestParam(name="page",defaultValue="0")int p,
			@RequestParam(name="size",defaultValue="5")int s,
			@RequestParam(name="mc",defaultValue="")String mc) {
		Page<Consignataire> pageConsignataire=
				consignataireRepository.cherchercon("%"+mc+"%",new PageRequest(p, s));
		model.addAttribute("listConsignataire", pageConsignataire.getContent());
		int[] pagess=new int[pageConsignataire.getTotalPages()];
		model.addAttribute("pagess",pagess);
		model.addAttribute("size", s);
		model.addAttribute("pageCourantes", p);
		model.addAttribute("mc", mc);
		return "consignataires";
	}
	@RequestMapping(value="/admin/deletecons",method=RequestMethod.GET)
	//pour rester sur la meme page
	public String deletecons(String numConsignataire,String mc,int page,int size) {
		consignataireRepository.delete(numConsignataire);
		return "redirect:/user/index4?page="+page+"&size="+size+"&mc="+mc;  //faire une redirection
		
	}
	@RequestMapping(value="/admin/formcons",method=RequestMethod.GET)
	public String ajoutNavire(Model model) {
		model.addAttribute("consignataire", new Consignataire());
		return "ajoutConsignataire";
	}
	
	@RequestMapping(value="/admin/editcons",method=RequestMethod.GET)
	public String editcons(Model model,String numConsignataire) {
		Consignataire cons=consignataireRepository.findOne(numConsignataire);
		model.addAttribute("consignataire", cons);
		return "EditConsignataire";
	}
	
	@RequestMapping(value="/admin/savecons",method=RequestMethod.POST)
	public String savecons(@ModelAttribute  @Valid Consignataire consignataire,
			BindingResult bindingResult) {
		if(bindingResult.hasErrors())
			return "ajoutConsignataire";
		consignataireRepository.save(consignataire);
		//addEmployee(employee);

		return "Confirmationconsignataire";
	}
	
}
