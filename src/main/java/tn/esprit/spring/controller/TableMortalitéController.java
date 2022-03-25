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
		@GetMapping("/Capital_vieC/{c}/{age}/{an}/{inte}/{sexe}")
		@ResponseBody
		public ResponseEntity<TableMortalité> dataCapitalControllerCapital(@PathVariable("c") float c,
			@PathVariable("age") int age,
			@PathVariable("an") int an,
			@PathVariable("inte") float inte,
			@PathVariable("sexe") String sexe){
		tri.calculePUCapital_vieCapital(c, age, an, inte,sexe);
		return new ResponseEntity<TableMortalité>(HttpStatus.OK);
		}
}
