package sn.ucad.master2soir.NdiayeMamadou.web;




import java.util.List;
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
import sn.ucad.master2soir.NdiayeMamadou.bo.Navire;
import sn.ucad.master2soir.NdiayeMamadou.dao.NavireRepository;

@Controller
public class NavireControler {
	@Autowired
	private NavireRepository navireRepository;
	@RequestMapping(value="/user/index")
	public String index(Model model,
			@RequestParam(name="page",defaultValue="0")int p,
			@RequestParam(name="size",defaultValue="5")int s,
			@RequestParam(name="mc",defaultValue="")String mc) {
		Page<Navire> pageNavires=
				navireRepository.chercher("%"+mc+"%",new PageRequest(p, s));
		model.addAttribute("listNavires", pageNavires.getContent());
		int[] pages=new int[pageNavires.getTotalPages()];
		model.addAttribute("pages",pages);
		model.addAttribute("size", s);
		model.addAttribute("pageCourante", p);
		model.addAttribute("mc", mc);
		return "navires";
	}
	@RequestMapping(value="/admin/delete",method=RequestMethod.GET)
	//pour rester sur la meme page
	public String delete(String numeroNavire,String mc,int page,int size) {
		navireRepository.delete(numeroNavire);
		return "redirect:/user/index?page="+page+"&size="+size+"&mc="+mc;  //faire une redirection
		
	}
	@RequestMapping(value="/admin/form",method=RequestMethod.GET)
	public String ajoutNavire(Model model) {
		model.addAttribute("navire", new Navire());
		return "ajoutNavire";
	}
	
	@RequestMapping(value="/admin/edit",method=RequestMethod.GET)
	public String edit(Model model,String numeroNavire) {
		Navire nav=navireRepository.findOne(numeroNavire);
		model.addAttribute("navire", nav);
		return "EditNavire";
	}
	/*@RequestMapping(value="/save",method=RequestMethod.POST)
	public String save(Model model,@Valid Navire navire, BindingResult bindingResult) {
		if(bindingResult.hasErrors())
			return "ajoutNavire";
		navireRepository.save(navire);
		return "Confirmation";
	}
	*/
	@RequestMapping(value="/admin/save", method = RequestMethod.POST)
	public String save(@ModelAttribute  @Valid Navire navire,
			BindingResult bindingResult) {
		if(bindingResult.hasErrors())
			return "ajoutNavire";
		navireRepository.save(navire);
		//addEmployee(employee);

		return "Confirmation";
	}
	
	public List<Navire> Listenavire(){
		return navireRepository.findAll();
		
	}
        
        @RequestMapping(value="/")
        public String home(){
            return "redirect:/user/index";
        }
        @RequestMapping(value="/403")
        public String accessDneied(){
            return "403";
        }


}
