package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import tn.esprit.spring.entity.TableMortalité;
import tn.esprit.spring.service.Implementation.TableMortaliteServiceImpl;

@Scope(value = "session")

@Controller(value = "TableMortaliteController") // Name of the bean in Spring IoC
public class TableMortalitéController {
		@Autowired
		TableMortaliteServiceImpl tri;
		////////////////prime unique : capital differé ////////////
		@GetMapping("/Capital_vieC/{capital}/{age}/{an}/{inte}/{sexe}")
		@ResponseBody
		public ResponseEntity<TableMortalité> dataCapitalControllerCapital(@PathVariable("capital") float capital,
			@PathVariable("age") int age,
			@PathVariable("an") int an,
			@PathVariable("inte") float inte,
			@PathVariable("sexe") String sexe){
		tri.calculePUCapital_vieCapital(capital, age, an, inte,sexe);
		return new ResponseEntity<TableMortalité>(HttpStatus.OK);
		}
		@GetMapping("/Capital_vieP/{p}/{age}/{an}/{inte}/{sexe}")
		@ResponseBody
		public ResponseEntity<TableMortalité> dataCapitalControllerPrime(@PathVariable("p") float p,
				@PathVariable("age") int age,
				@PathVariable("an") int an,
				@PathVariable("inte") double inte,
				@PathVariable("sexe") String sexe){
					
			tri.calculePUCapital_viePrime(p, age, an, inte,sexe);
			return new ResponseEntity<TableMortalité>(HttpStatus.OK);
		}
		@GetMapping("/calcRenteC/{r}/{age}/{inte}/{sexe}")
		@ResponseBody
		public ResponseEntity<TableMortalité> calculePURenteillimteRenteController(@PathVariable("r") float r,
				@PathVariable("age") int age,	
				@PathVariable("inte") double inte,
				@PathVariable("sexe") String sexe){
					
			tri.calculePURenteillimteRente(r, age,  inte,sexe);
			return new ResponseEntity<TableMortalité>(HttpStatus.OK);
		}
		///////////////  prime unique : vie enitere /////////////////
		
		@GetMapping("/calcvieEntiereC/{c}/{age}/{inte}/{sexe}")
		@ResponseBody
		public ResponseEntity<TableMortalité> calculePUVieEntiereCapital(@PathVariable("c") float c, 
				@PathVariable("age") int age,	
				@PathVariable("inte") double inte,
				@PathVariable("sexe") String sexe){
					
			tri.calculePUVieEntiereCapital(c, age,  inte , sexe);
			return new ResponseEntity<TableMortalité>(HttpStatus.OK);
		}
		@GetMapping("/calcvieEntiereP/{p}/{age}/{inte}/{sexe}")
		@ResponseBody
		public ResponseEntity<TableMortalité> calculePUVieEntierePrime(@PathVariable("p") float p, 
				@PathVariable("age") int age,	
				@PathVariable("inte") double inte,
				@PathVariable("sexe") String sexe){
					
			tri.calculePUVieEntierePrime(p, age,  inte , sexe);
			return new ResponseEntity<TableMortalité>(HttpStatus.OK);
		}	
		

}
