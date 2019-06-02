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
import sn.ucad.master2soir.NdiayeMamadou.bo.TypeMouvement;
import sn.ucad.master2soir.NdiayeMamadou.dao.TypeMouvementRepository;

/**
 *
 * @author MAMADOU NDIAYE
 */
@Controller
public class TypeMouvementControler {
    @Autowired
	private TypeMouvementRepository typemouvementRepository;
	@RequestMapping(value="/user/index3")
	public String index3(Model model,
			@RequestParam(name="page",defaultValue="0")int p,
			@RequestParam(name="size",defaultValue="5")int s,
			@RequestParam(name="mc",defaultValue="")String mc) {
		Page<TypeMouvement> pageTypeMouvement=
				typemouvementRepository.cherchert("%"+mc+"%",new PageRequest(p, s));
		model.addAttribute("listType", pageTypeMouvement.getContent());
		int[] pagest=new int[pageTypeMouvement.getTotalPages()];
		model.addAttribute("pagest",pagest);
		model.addAttribute("size", s);
		model.addAttribute("pageCourantt", p);
		model.addAttribute("mc", mc);
		return "typemouvements";
	}
	@RequestMapping(value="/admin/deletemouvement",method=RequestMethod.GET)
	//pour rester sur la meme page
	public String deletemouvement(String codeTypeMvt,String mc,int page,int size) {
		typemouvementRepository.delete(codeTypeMvt);
		return "redirect:/user/index3?page="+page+"&size="+size+"&mc="+mc;  //faire une redirection
		
	}
	@RequestMapping(value="/admin/formmouvement",method=RequestMethod.GET)
	public String ajoutTypemouvement(Model model) {
		model.addAttribute("typemouvement", new TypeMouvement());
		return "ajoutMouvement";
	}
	
	@RequestMapping(value="/admin/editmouvement",method=RequestMethod.GET)
	public String editmouvement(Model model,String codeTypeMvt) {
		TypeMouvement type=typemouvementRepository.findOne(codeTypeMvt);
		model.addAttribute("typemouvement", type);
		return "EditMouvement";
	}
	
	@RequestMapping(value="/admin/savemouvement", method = RequestMethod.POST)
	public String savemouvement(@ModelAttribute  @Valid TypeMouvement typemouvement,
			BindingResult bindingResult) {
		if(bindingResult.hasErrors())
			return "ajoutMouvement";
		typemouvementRepository.save(typemouvement);
		//addEmployee(employee);

//		return "ConfirmationMouvement";
                return "typemouvements";
	}
	
	
}
