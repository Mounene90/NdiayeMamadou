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
import sn.ucad.master2soir.NdiayeMamadou.bo.Escale;
import sn.ucad.master2soir.NdiayeMamadou.dao.ConsignataireRepository;
import sn.ucad.master2soir.NdiayeMamadou.dao.EscaleRepository;
import sn.ucad.master2soir.NdiayeMamadou.dao.NavireRepository;

@Controller
public class EscaleControler {

	@Autowired
	private EscaleRepository escaleRepository;
	@Autowired
	private NavireRepository navireRepository;
	@Autowired
	private ConsignataireRepository consignataireRepository;
	@RequestMapping(value="/user/index2")
	public String index2(Model model,
			@RequestParam(name="page",defaultValue="0")int p,
			@RequestParam(name="size",defaultValue="5")int s,
			@RequestParam(name="mc",defaultValue="")String mc) {
		Page<Escale> pageEscales=
				escaleRepository.cherchers("%"+mc+"%",new PageRequest(p, s));
		model.addAttribute("listEscales", pageEscales.getContent());
		int[] pages=new int[pageEscales.getTotalPages()];
		model.addAttribute("pages",pages);
		model.addAttribute("size", s);
		model.addAttribute("pageCourantesc", p);
		model.addAttribute("mc", mc);
		return "escales";
	}
	@RequestMapping(value="/admin/deletes",method=RequestMethod.GET)
	//pour rester sur la meme page
	public String deletes(String numEscale,String mc,int page,int size) {
		escaleRepository.delete(numEscale);
		return "redirect:/user/index2?page="+page+"&size="+size+"&mc="+mc;  //faire une redirection
		
	}
	@RequestMapping(value="/admin/forms",method=RequestMethod.GET)
	public String ajoutEscale(Model model) {
		model.addAttribute("escale", new Escale());
		model.addAttribute("navire", navireRepository.findAll());
		model.addAttribute("consignataire", consignataireRepository.findAll());
		/*model.addAttribute("evenements", evenementService.findAllEvenement());*/
		return "ajoutEscale";
	}
	
	@RequestMapping(value="/admin/edits",method=RequestMethod.GET)
	public String edits(Model model,String numEscale) {
		Escale escale= escaleRepository.findOne(numEscale);
		model.addAttribute("escale", escale);
                model.addAttribute("navire", navireRepository.findAll());
		model.addAttribute("consignataire", consignataireRepository.findAll());
                
                
		return "EditEscale";
	}
	/*@RequestMapping(value="/save",method=RequestMethod.POST)
	public String save(Model model,@Valid Navire navire, BindingResult bindingResult) {
		if(bindingResult.hasErrors())
			return "ajoutNavire";
		navireRepository.save(navire);
		return "Confirmation";
	}
	*/
	@RequestMapping(value = "/admin/saves", method = RequestMethod.POST)
	public String saves(@ModelAttribute  @Valid Escale escale,
			BindingResult bindingResult) {
		if(bindingResult.hasErrors())
			return "ajoutEscale";
		escaleRepository.save(escale);
		//addEmployee(employee);
		return "ConfirmationEscale";
	}
        
//        @RequestMapping(value="/")
//        public String home(){
//            return "redirect:/user/index2";
//        }
//        @RequestMapping(value="/403")
//        public String accessDneied(){
//            return "403";
        



}
