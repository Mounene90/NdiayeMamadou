/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import sn.ucad.master2soir.NdiayeMamadou.bo.BonPilotage;
import sn.ucad.master2soir.NdiayeMamadou.dao.BonPilotageRepository;
import sn.ucad.master2soir.NdiayeMamadou.dao.EscaleRepository;
import sn.ucad.master2soir.NdiayeMamadou.dao.TypeMouvementRepository;
/**
 *
 * @author MAMADOU NDIAYE
 */
@Controller
public class BonPilotageControler {
    @Autowired
    private BonPilotageRepository bonPilotageRepository;
    @Autowired
    private EscaleRepository escaleRepository;
    @Autowired
    private TypeMouvementRepository typemouvementRepository;
        
	
	@RequestMapping(value="/user/index1")
	public String index1(Model model,
			@RequestParam(name="page",defaultValue="0")int p,
			@RequestParam(name="size",defaultValue="5")int s,
			@RequestParam(name="mc",defaultValue="")String mc) {
		Page<BonPilotage> pagebon=
				bonPilotageRepository.chercherbon("%"+mc+"%",new PageRequest(p, s));
		model.addAttribute("listbon", pagebon.getContent());
		int[] pageb=new int[pagebon.getTotalPages()];
		model.addAttribute("pageb",pageb);
		model.addAttribute("size", s);
		model.addAttribute("pageCouranteb", p);
		model.addAttribute("mc", mc);
		return "bonpilotages";
	}
	@RequestMapping(value="/admin/deletebon",method=RequestMethod.GET)
	//pour rester sur la meme page
	public String deletebon(String codebon,String mc,int page,int size) {
		bonPilotageRepository.delete(codebon);
		return "redirect:/user/index1?page="+page+"&size="+size+"&mc="+mc;  //faire une redirection
		
	}
	@RequestMapping(value="/admin/formbon",method=RequestMethod.GET)
	public String ajoutbon(Model model) {
		model.addAttribute("bonpilotage", new BonPilotage());
		model.addAttribute("escale", escaleRepository.findAll());
		model.addAttribute("typemouvement", typemouvementRepository.findAll());
		/*model.addAttribute("evenements", evenementService.findAllEvenement());*/
		return "ajoutbon";
	}
	
	@RequestMapping(value="/admin/editbon",method=RequestMethod.GET)
	public String editbon(Model model,String codebon) {
		BonPilotage bon= bonPilotageRepository.findOne(codebon);
		model.addAttribute("bonpilotage", bon);
                model.addAttribute("escale", escaleRepository.findAll());
		model.addAttribute("typemouvement", typemouvementRepository.findAll());
                
                
		return "Editbon";
	}
	
	@RequestMapping(value="/admin/savebon", method = RequestMethod.POST)
	public String savebon(@ModelAttribute  @Valid BonPilotage bonpilotage,
			BindingResult bindingResult) {
		if(bindingResult.hasErrors())
			return "ajoutbon";
		bonPilotageRepository.save(bonpilotage);
		//addEmployee(employee);
//		return "Confirmationbon";
                return "bonpilotages";
	}


    
}
