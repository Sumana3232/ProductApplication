package com.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {
   @RequestMapping("/")
	public String productForm()
	{
		return "product";
	}
   @RequestMapping("/req1")
   public String appForm(@RequestParam int cid,@RequestParam String cname,@RequestParam Long mobilenumber,@RequestParam String pname,@RequestParam double price,@RequestParam int quantity,ModelMap model)
   {
	   model.put("cid", cid);
	   model.put("cname", cname);
	   model.put("pname",pname);
	   model.put("mobilenumber",mobilenumber);
	   model.put("price", price);
	   model.put("quantity", quantity);
	   
	   double total=0.0;
	   double discount=0.0;
	   double gst=0.0;
	   double bill=0;
	   total=price*quantity;
	   gst=(total*18)/100;
	   bill=(total-discount)+gst;
	   model.put("total", total);
	   
	   model.put("gst", gst);
	   model.put("bill", bill);
	   if(total<2500)
	   {
		   discount=(total*15)/100;
	   }
	   else if(total>2500 && total<10000)
	   {
		   discount=(total*25)/100;
	   }
	   else if(total>10000)
	   {
		   discount=(total*30)/100;
	   }
	   
	   model.put("discount", discount);
	   return "result";
   } 
	
}
