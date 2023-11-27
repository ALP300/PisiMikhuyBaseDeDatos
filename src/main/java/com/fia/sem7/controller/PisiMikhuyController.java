package com.fia.sem7.controller;



import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fia.sem7.models.entity.Admin;
import com.fia.sem7.models.entity.Carrito;
import com.fia.sem7.models.entity.Cliente;
import com.fia.sem7.models.entity.Comprobante;
import com.fia.sem7.models.entity.Detalle_Carrito;
import com.fia.sem7.models.entity.Historial_Compras;
import com.fia.sem7.models.entity.Historial_Regalos;
import com.fia.sem7.models.entity.Ingredientes;
import com.fia.sem7.models.entity.ItemCarrito;
import com.fia.sem7.models.entity.Plato;
import com.fia.sem7.models.entity.Producto;
import com.fia.sem7.models.entity.Regalo;
import com.fia.sem7.models.entity.Tipo_Comprobante;
import com.fia.sem7.models.service.IAdminService;
import com.fia.sem7.models.service.ICarritoService;
import com.fia.sem7.models.service.IClienteService;
import com.fia.sem7.models.service.IHistorial_ComprasService;
import com.fia.sem7.models.service.IHistorial_RegalosService;
import com.fia.sem7.models.service.IIngredientesService;
import com.fia.sem7.models.service.IItemCarritoService;
import com.fia.sem7.models.service.IPlatoService;
import com.fia.sem7.models.service.IProductoService;
import com.fia.sem7.models.service.IRegaloService;
import com.fia.sem7.models.service.ITipo_ComprobanteService;
import com.fia.sem7.models.service.IngredienteServiceImpl;

import jakarta.validation.Valid;



@Controller
@SessionAttributes("cliente")
public class PisiMikhuyController {
	
	
	@Autowired
	private IClienteService clienteService;
	@Autowired
	private IIngredientesService ingredienteService;
	@Autowired
	private IProductoService productoService;
	@Autowired
	private IAdminService adminService;
	@Autowired
	private IPlatoService platoService;
	@Autowired
	private IHistorial_ComprasService histCompService;
	@Autowired
	private IHistorial_RegalosService histRegalService;
	@Autowired
	private IRegaloService regaloService;
	@Autowired
	private ITipo_ComprobanteService tipCompService;
	@Autowired
	private ICarritoService carritoService;
	@Autowired
	private IItemCarritoService itemCarritoService;


	Cliente clienteIniciado;
	Admin adminIniciado;
	Integer contadorIniciado=0;
	Integer contaCarrito=1;
	Integer idComprobante= contaCarrito;
	Comprobante comprobanteGlobal=new Comprobante();
	Regalo regaloGlobal=null;
	List<Detalle_Carrito> listaDetGlobal = new ArrayList<Detalle_Carrito>();
	
	
	Double totalCarrito=0.0;
	Integer totCant=0;
	Double premioG=0.0;
	
	@RequestMapping(value={"/index","/","/inicio"})
	public String index(Model model, Cliente cliente, Admin admin) {
		
		if(clienteIniciado!=null) {
			model.addAttribute("clienteI", clienteIniciado);
			
			model.addAttribute("nom",clienteIniciado.getNom());
			Historial_Compras hisComIni=histCompService.findOne(clienteIniciado.getIden());
			contadorIniciado=hisComIni.getaReg();
			
			
		}else if(adminIniciado!=null){
			model.addAttribute("adminI", adminIniciado);
			model.addAttribute("nomA",adminIniciado.getNom());
		}
		model.addAttribute("clienteI", clienteIniciado);
		model.addAttribute("adminI", adminIniciado);
		model.addAttribute("contaI", contadorIniciado);

		return "inicio";
	}
	
	@RequestMapping(value="/preguntas")
	public String pregunta(Model model) {
		model.addAttribute("clienteI", clienteIniciado);
		model.addAttribute("adminI", adminIniciado);
		model.addAttribute("contaI", contadorIniciado);
			return "preguntas";

	}
	@RequestMapping(value="/premio")
	public String premio(Model model) {
		model.addAttribute("clienteI", clienteIniciado);
		model.addAttribute("adminI", adminIniciado);
		model.addAttribute("contaI", contadorIniciado);
		model.addAttribute("totalPlatos", totCant);
			return "premio";

	}
	@RequestMapping(value="/premioR", method=RequestMethod.POST)
	public String recibirPremio(@RequestBody String premio, Model model) {
		String descuento=premio.substring(1,13);
		
		Double preGan=0.0;
		if(descuento.equals("Descuento 2%")) {
			preGan=0.02;
		}else if(descuento.equals("Descuento 4%")) {
			preGan=0.04;
		}else if(descuento.equals("Descuento 6%")) {
			preGan=0.06;
		}else if(descuento.equals("Descuento 8%")) {
			preGan=0.08;
		}else{
			preGan=0.10;
		}
		
		Regalo reg=new Regalo(descuento,preGan,"Activo",clienteIniciado.getIden());
		regaloService.save(reg);
		
		Historial_Compras histCompReg=histCompService.findOne(clienteIniciado.getIden());
		contadorIniciado=histCompReg.getaReg()-1;
		Integer num=histCompReg.getaReg()-1;
		histCompReg.setaReg(num);
		histCompService.update(histCompReg);
	
		/*
		Integer num=hisComIni.getaReg()-1;
		hisComIni.setaReg(num);
		histCompService.save(hisComIni);
		*/
		model.addAttribute("clienteI", clienteIniciado);
		model.addAttribute("adminI", adminIniciado);
		model.addAttribute("contaI", contadorIniciado);
		model.addAttribute("premio", descuento);
		
		
		
		return "redirect:/";

	}

	
	@GetMapping("/cerrarSesion")
	public String cerrarSesion(Model model) {
		clienteIniciado = null;
		adminIniciado = null;
		
		comprobanteGlobal=new Comprobante();
		listaDetGlobal=new ArrayList<Detalle_Carrito>();
		regaloGlobal=null;
		return "redirect:/";
	}
	
	@RequestMapping(value="/listar",method = RequestMethod.GET)
	public String lista(Model model) {
		model.addAttribute("adminI", adminIniciado);
		model.addAttribute("titulo", "Listado de Clientes");
		model.addAttribute("clientes", clienteService.findAll());
		return "lista";
	}
	
	@RequestMapping(value="/listaIngre",method = RequestMethod.GET)
	public String listaIngre(Model model) {
		model.addAttribute("adminI", adminIniciado);
		model.addAttribute("titulo", "Listado de Clientes");
		model.addAttribute("ingredientes", ingredienteService.findAll());
		return "listaIngre";
	}
	
	@RequestMapping(value="/catalogo",method = RequestMethod.GET)
	public String listaPlatos(Model model) {
		model.addAttribute("clienteI", clienteIniciado);
		model.addAttribute("contaI", contadorIniciado);
		model.addAttribute("titulo", "Listado de Platos");
		model.addAttribute("platos", productoService.findAll());
		return "catalogo";
	}
	@RequestMapping(value="/catalogo/{idC}/{idP}")
	public String catalogoPlato(@PathVariable(value="idC") String idC, @PathVariable(value="idP") String idP, Map<String, Object> model) {
		model.put("clienteI", clienteIniciado);
		model.put("adminI", adminIniciado);
		model.put("contaI", contadorIniciado);
		Cliente cliente=null;
		Producto plato=null;

		if(!idC.equals("")) {
			cliente=clienteService.findOne(idC);
			plato=productoService.findOne(idP);
		}else {
			return "redirect:/";
		}
		Detalle_Carrito detCar=new Detalle_Carrito();
		
		
		comprobanteGlobal.setIdCar(idComprobante);
		/*
		Carrito carrito = new Carrito();
		carrito.setCliente(cliente);
		carrito.setId(cCar);
		carritoService.save(carrito);
		ItemCarrito itemC= new ItemCarrito();
		*/
		
		model.put("detCar",detCar);
		model.put("carrito",comprobanteGlobal);
		model.put("cliente", cliente);
		model.put("plato", plato);
		model.put("titulo", "Compra de Plato");
		return "compra";
	}
	@RequestMapping(value="/catalogo/{idC}/{idP}", method=RequestMethod.POST)
	public String compraPlato(@PathVariable(value="idC") String idC, @PathVariable(value="idP") String idP,@Valid Detalle_Carrito detCar, Map<String, Object> model,SessionStatus status) {
		model.put("clienteI", clienteIniciado);
		model.put("adminI", adminIniciado);
		model.put("contaI", contadorIniciado);
		
		Cliente cliente=null;
		Producto plato=null;

		if(!idC.equals("")) {
			cliente=clienteService.findOne(idC);
			plato=productoService.findOne(idP);
			
		}else {
			return "redirect:/";
		}
		
		Double pagoPlato=detCar.getCantPla().doubleValue()*plato.getPrecio();
		
		
		Integer totPlaCar;
		
		if(comprobanteGlobal.getTotPlaCom()!=null) {
			totPlaCar=comprobanteGlobal.getTotPlaCom();
		}else {
			totPlaCar=0;
		}
		

		Double totPagoCar=comprobanteGlobal.getPagCar();
		if(comprobanteGlobal.getPagCar()!=null) {
			totPagoCar=comprobanteGlobal.getPagCar();
		}else {
			totPagoCar=0.0;
		}
		
		totPlaCar=totPlaCar+detCar.getCantPla();
		
		totPagoCar=totPagoCar+pagoPlato;
		
		detCar.setTotPagPla(pagoPlato);
		detCar.setProducto(idP);

		detCar.setComprobante(comprobanteGlobal.getIdCar());
		
		listaDetGlobal.add(detCar);
		
		comprobanteGlobal.setPagCar(totPagoCar);
		comprobanteGlobal.setTotPlaCom(totPlaCar);
		
		
		status.setComplete();
		
		model.put("carrito",comprobanteGlobal);
		
		model.put("cliente", cliente);
		model.put("plato", plato);
		model.put("titulo", "Compra de Plato");
		model.put("detCar",detCar);
		return "compra";
	}
	@RequestMapping(value="/carrito/{idC}/{idCar}", method = RequestMethod.GET)
	public String verCarrito(@PathVariable(value="idC") String idC,  
			@PathVariable(value="idCar") Integer idCar,Map<String,Object> model,
						RedirectAttributes flash) {
		
		Cliente cliente= clienteService.findOne(idC);
		if(cliente==null) {
			flash.addFlashAttribute("error", "El cliente no existe en la base de datos");
			return "redirect:/";
		}
		
		List<Regalo> lstReg=new ArrayList<Regalo>();
		lstReg=regaloService.findAll();
		List<Regalo> lstRegFinal=new ArrayList<Regalo>();
		
		for(Regalo reg:lstReg) {
			if(reg.getHisReg().equals(cliente.getIden())) {
				lstRegFinal.add(reg);
			}
		}
		Integer idMenor=9999;
		for(Regalo regF:lstRegFinal) {
			
			if(regF.getIdReg()<idMenor && regF.getEstado().equals("Activo")) {
				idMenor=regF.getIdReg();
			}
			
		}
		
		Regalo regalEleg=regaloService.findOne(idMenor.longValue());
		
		
		
		Historial_Compras hisComp=histCompService.findOne(cliente.getIden());
		
		comprobanteGlobal.setHisComp(hisComp.getIdHisCom());
		Double pagoFinal=0.0;
		if(regalEleg==null){
			pagoFinal=comprobanteGlobal.getPagCar();
			model.put("regalo", "No hay regalo");
			regaloGlobal=regalEleg;
		}else {
			pagoFinal=comprobanteGlobal.getPagCar()-comprobanteGlobal.getPagCar()*regalEleg.getDescuento();
			model.put("regalo", regalEleg.getDetReg());
			regaloGlobal=regalEleg;
			
		}
		
		comprobanteGlobal.setTotPagFin(pagoFinal);

		String comprobanteTipo="";
		
		model.put("cliente", cliente);
		model.put("tCompro",comprobanteTipo);
		
		//model.put("iC",carrito.);
		
		model.put("carrito",comprobanteGlobal);
		model.put("items", listaDetGlobal);
		model.put("titulo", "Detalle del Cliente: "+ cliente.getNom());
		return "carrito";
	}
	@RequestMapping(value="/carrito/{idC}/{idCar}", method = RequestMethod.POST)
	public String pagarCarrito(@PathVariable(value="idC") String idC,@RequestParam(value="tCompro") String tCompro,  
			@PathVariable(value="idCar") Integer idCar,Map<String,Object> model,
						RedirectAttributes flash) {
		
		Cliente cliente= clienteService.findOne(idC);
		model.put("tCompro", tCompro);

		Historial_Compras hisComp=histCompService.findOne(cliente.getIden());
		
		

		Comprobante carritoF=new Comprobante(comprobanteGlobal.getPagCar(),comprobanteGlobal.getTotPlaCom(),
				comprobanteGlobal.getTotPagFin(),tCompro,hisComp.getIdHisCom(),regaloGlobal.getIdReg());
		
		carritoService.save(carritoF);
		
		List<Comprobante> lstComprobante=carritoService.findAll();
		List<Comprobante> listaComprobar=new ArrayList<Comprobante>();
		
		for(Comprobante comp:lstComprobante) {
			if(comp.getHisComp().equals(cliente.getIden())) {
				listaComprobar.add(comp);
			}
		}
		Integer idMayor=0;
		for(Comprobante com:listaComprobar) {
			if(com.getIdCar()>idMayor) {
				idMayor=com.getIdCar();
			}
		}
		Comprobante comprobanteReg=carritoService.findOne(idMayor.longValue());
		//HACER UPDATE DEL REGALO A ESTADO USADO
		if(regaloGlobal!=null) {
			regaloGlobal.setEstado("Usado");
			regaloGlobal.setComprobante(comprobanteReg.getIdCar());
			regaloService.update(regaloGlobal);
		}
		//listaDetGlobal
		for (Detalle_Carrito iDet:listaDetGlobal) {	
			
			itemCarritoService.save(new Detalle_Carrito(iDet.getCantPla(),iDet.getTotPagPla(),carritoF.getIdCar(),
					iDet.getProducto()));					
		}
		List<Detalle_Carrito> listaCarrito=itemCarritoService.findAll();
		List<Detalle_Carrito> lstCar=new ArrayList<Detalle_Carrito>();
		
		for(Detalle_Carrito iDet:listaCarrito) {
			if(iDet.getComprobante().equals(carritoF.getIdCar())) {
				lstCar.add(iDet);
			}
		}
		comprobanteGlobal=new Comprobante();
		listaDetGlobal=new ArrayList<Detalle_Carrito>();
		regaloGlobal=null;
		
		model.put("cliente", cliente);
		
		//model.put("iC",carrito.);
		model.put("carrito",carritoF);
		model.put("items", lstCar);
		model.put("titulo", "Detalle del Cliente: "+ cliente.getNom());
		return "redirect:/";
	}
	@RequestMapping(value="/registro")
	public String crear(Map<String,Object>model) {
		
		
		Cliente cliente=new Cliente();
		model.put("cliente", cliente);
		model.put("titulo", "Bienvenido al Registro");
		return "registro";
	}
	
	@RequestMapping(value="/registro", method=RequestMethod.POST)
	public String guardar(@Valid Cliente cliente, BindingResult result,Model model,SessionStatus status) {
		
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Fallo de Registro");
			return "registro";
		}
		Historial_Compras histComp=new Historial_Compras();
		Historial_Regalos histReg=new Historial_Regalos();
		histComp.setIdHisCom(cliente.getIden());
		histReg.setIdHisReg(cliente.getIden());
		histReg.setRegUsa(0);
		histReg.setRegDis(0);
		histComp.setaReg(1);
		histComp.setTotCom(0);
		histComp.setCliente(cliente.getIden());
		histReg.setCliente(cliente.getIden());
		cliente.setRol("Cliente");
		clienteService.save(cliente);
		
		histCompService.save(histComp);
		histRegalService.save(histReg);
		
		
		status.setComplete();
		return "redirect:/iniSesion";
	}
	
	
	@RequestMapping(value = "/registroIngrediente", method = RequestMethod.POST)
	public String guardarIngrediente(@Valid Ingredientes ingrediente, BindingResult result, Model model, SessionStatus status) {
	    if (result.hasErrors()) {
	        model.addAttribute("titulo", "Fallo de Registro");
	        return "registroIngrediente";
	    }

	    if (ingrediente.getId_Ingrediente() != null && !ingrediente.getId_Ingrediente().equals("")) {
	        // El ID existe, por lo tanto, actualiza el ingrediente existente
	        ingredienteService.save(ingrediente);
	    } else {
	        // El ID no existe, crea un nuevo ingrediente
	        ingredienteService.save(ingrediente); // Asegúrate de tener un método "saveNuevo" en tu servicio.
	    }

	    status.setComplete();
	    return "redirect:/listaIngre";
	}

	
	
	@RequestMapping(value="/iniSesion")
	public String mostrarIniciarSesion(Map<String,Object>model) {

		model.put("cliente", new Cliente());
		model.put("titulo", "Bienvenido al Inicio Sesión");
		return "inicioSesion";
	}
	
	
	@RequestMapping(value="/iniSesion", method=RequestMethod.POST)
	public String comparaSesion(Map<String, Object> model, Cliente cliente) {

		model.put("cliente", cliente);
		if (clienteService.buscarCuenta(cliente)) {
			clienteIniciado = clienteService.buscarXIdentidad(cliente);
			Historial_Compras hisComIni=histCompService.findOne(cliente.getIden());
			contadorIniciado=hisComIni.getaReg();
			/*
			Integer num=hisComIni.getaReg()-1;
			hisComIni.setaReg(num);
			histCompService.save(hisComIni);
			*/
				return "redirect:/";
		}
			
		return "inicioSesion";
		
	}
	
	@RequestMapping(value="/iniSesionAdm")
	public String iniciarSesionAdm(Map<String,Object>model) {
		
		model.put("admin",new Admin());
		model.put("titulo", "Bienvenido al Inicio Sesión Admin");
		return "inicioSesionAdmin";
	}
	@RequestMapping(value="/iniSesionAdm", method=RequestMethod.POST)
	public String comparaSesionAdm(Map<String, Object> model, Admin admin) {
		
		
		model.put("admin", admin);
		if (adminService.buscarCuenta(admin)) {
			adminIniciado = adminService.buscarXIdentidad(admin);
				return "redirect:/";
		}
		
		return "inicioSesionAdmin";
		
	}
	
	@RequestMapping(value="/registro/{id}")
	public String editar(@PathVariable(value="id") String id, Map<String, Object> model) {
		
		Cliente cliente=null;
		
		if(!id.equals("")) {
			cliente=clienteService.findOne(id);
		}else {
			return "redirect:/listar";
		}
		
		model.put("cliente", cliente);
		model.put("titulo", "Editar Cliente");
		return "registro";
	}
	
	@GetMapping("/registroIngrediente/{id}")
	public String editarIngrediente(@PathVariable(value = "id") String id, Model model) {
	    Ingredientes ingrediente = null;

	    if (id != null && !id.equals("")) {
	        ingrediente = ingredienteService.findOne(id);

	        if (ingrediente != null) {
	            // Aquí cargamos el ingrediente para su edición
	            model.addAttribute("ingrediente", ingrediente);
	            model.addAttribute("titulo", "Editar Ingrediente");
	            return "registroIngrediente";
	        } else {
	            // Ingrediente no encontrado, puedes manejar esto adecuadamente, por ejemplo, redirigiendo a la lista de ingredientes.
	            return "redirect:/listaIngre";
	        }
	    } else {
	        // ID no válido, puedes manejar esto adecuadamente, por ejemplo, redirigiendo a la lista de ingredientes.
	        return "redirect:/listaIngre";
	    }
	}



	@RequestMapping(value="/eliminar/{id}")
	public String eliminar(@PathVariable(value="id") String id) {
		
		if(!id.equals("")) {
			clienteService.delete(id);
		}
		
		return "redirect:/listar";
	}
	
	
	@RequestMapping(value="/eliminarIngrediente/{id}")
	public String eliminarIngrediente(@PathVariable(value="id") String id) {
		
		if(!id.equals("")) {
			ingredienteService.delete(id);
		}
		
		return "redirect:/listaIngre";
	}
	
	@GetMapping(value="/ver/{id}")
	public String ver(@PathVariable(value="id") String id,Map<String,Object> model,
						RedirectAttributes flash) {
		
		Cliente cliente= clienteService.findOne(id);
		
		if(cliente==null) {
			flash.addFlashAttribute("error", "El cliente no existe en la base de datos");
			return "redirect:/lista";
		}
		
		model.put("cliente", cliente);
		model.put("titulo", "Detalle del Cliente: "+ cliente.getNom());
		return "ver";
	}
	
	
	@GetMapping("/verClienteInfo")
	public String verInformacionCliente(Model model) {
		
			Historial_Compras histialC=histCompService.findOne(clienteIniciado.getIden());
			List<Comprobante> lstComp=new ArrayList<Comprobante>();
			List<Comprobante> lstComF=new ArrayList<Comprobante>();
			
			for(Comprobante com:lstComp) {
				if(com.getHisComp().equals(histialC.getIdHisCom())) {
					lstComF.add(com);
				}
			}
			
			Integer totPla=0;
			for(Comprobante co:lstComF) {
				totPla=totPla+co.getTotPlaCom();//12
			}
			
			List<Regalo> lstReg=regaloService.findAll();
			List<Regalo> listaReg=new ArrayList<Regalo>();
			

			for(Regalo reg:lstReg) {
				if(reg.getHisReg().equals(clienteIniciado.getIden())) {
					listaReg.add(reg);
				}
			}
			
			Integer regA=0;
			Integer regU=0;
			
			for(Regalo reg:listaReg) {
				if(reg.getEstado().equals("Usado")) {
					regU++;
				}else {
					regA++;
				}
			}
			Historial_Regalos histReg=histRegalService.findOne(clienteIniciado.getIden());
			
			histReg.setRegDis(regA);
			histReg.setRegUsa(regU);
			
			histRegalService.update(histReg);
			
			histialC.setTotCom(totPla);
			histCompService.update(histialC);
			
			model.addAttribute("hsReg", histReg);
			model.addAttribute("hsCom", histialC);
			model.addAttribute("lstCom", lstComF);
			model.addAttribute("lstReg", listaReg);
	        model.addAttribute("clienteI", clienteIniciado);
	        model.addAttribute("contaI", contadorIniciado);
	        
	        
	        
	        return "verClienteInfo"; // Esto corresponde al nombre de la vista "verClienteInfo.html"
	    
	}
	
	
	@PostMapping("/verClienteR")
	public String verInformacionR(Model model) {
			
			Historial_Compras histialC=histCompService.findOne(clienteIniciado.getIden());
			List<Comprobante> lstComp=new ArrayList<Comprobante>();
			List<Comprobante> lstComF=new ArrayList<Comprobante>();
			
			for(Comprobante com:lstComp) {
				if(com.getHisComp().equals(histialC.getIdHisCom())) {
					lstComF.add(com);
				}
			}
			
			
			Integer totPla=0;
			for(Comprobante co:lstComF) {
				totPla=totPla+co.getTotPlaCom();//12
			}
			
			if(totPla<15) {
				histialC.setTotCom(totPla);
				histCompService.update(histialC);
			}else {
				List<Regalo> lstReg=regaloService.findAll();
				Integer cReg=0;
				for(Regalo reg:lstReg) {
					if(reg.getHisReg().equals(clienteIniciado.getIden())) {
						cReg++;
					}
				}
				Integer regGanados=cReg;//1
				Integer regHis=histialC.getaReg()-1; //2
				Integer sumReg=regGanados+regHis;
				
				Integer platosReg=totPla-sumReg*15;
				
				if(platosReg>14) {
					Integer regalosGanados=platosReg/15;
					Integer posReg=histialC.getaReg();
					histialC.setaReg(regalosGanados+posReg);
				}
				
				histialC.setTotCom(totPla);
				histCompService.update(histialC);
				
			}
			
	
			
			contadorIniciado=histialC.getaReg();
			
		
	        model.addAttribute("clienteI", clienteIniciado);
	        model.addAttribute("contaI", contadorIniciado);
	        return "verClienteInfo"; // Esto corresponde al nombre de la vista "verClienteInfo.html"
	    
	}
	
	@Controller
	public class DescripcionController {
	    private final IngredienteServiceImpl ingredienteService;

	    @Autowired
	    public DescripcionController(IngredienteServiceImpl ingredienteService) {
	        this.ingredienteService = ingredienteService;
	    }

	    @GetMapping("/descrip")
	    public String mostrarDescrip(Model model) {
	        List<Ingredientes> ingredientes = ingredienteService.findAll();
	        
	        model.addAttribute("ingredientes", ingredientes);

	        return "descrip";
	    }
	}

	
	//PARTE DE HISTORIAL
	
}