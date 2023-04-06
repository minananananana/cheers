package kr.co.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.service.SearchService;
import kr.co.vo.StoreVO;

@RequestMapping("search")
@Controller
public class SearchController {

   @Inject
   SearchService service;

   @RequestMapping("search")
   public String matchingHome() {
      return ".main.search.search";
   }//matchingHome()-end

   @RequestMapping(value="map",method=RequestMethod.POST)
   public String map(Model model, String keyword) throws Exception{

      StoreVO storeVO=new StoreVO();
      List list=service.search(keyword);
      //List<Object> list2 = new ArrayList<Object>();
      Map<Integer,String> map=new HashMap<Integer,String>();
      JSONArray req_array=new JSONArray();
      //JSONObject jsonObject = new JSONObject();
      
      Iterator<StoreVO> iterator=list.iterator();
      while(iterator.hasNext()) {
         storeVO=iterator.next();
         String s_addr=storeVO.getS_addr()+storeVO.getS_detail_addr();//리스트에서 주소,상세주소 꺼내서 묶어서 다시 리스트2에 담기
         
         int s_num=storeVO.getS_num();//키워드에 해당하는 번호가져와서 store_detail에서 정보 가져오기
         String s_name=storeVO.getS_name();
         
         JSONObject data=new JSONObject();
         data.put("s_num", s_num);
         data.put("s_addr", s_addr);
         data.put("s_name", s_name);
         
         req_array.add(data);
         
        // jsonObject.put("store", req_array);
         
         //map.put(s_num, addr);
         
         
         
         //         list2.add(addr);
         //         list2.add(s_num);//jsp에서 ajax로 정보다시 꺼내옴
      }//while-end
      System.out.println(req_array);
      //String json = new Gson().toJson(map);
      
      //model.addAttribute("json", json);
      
      model.addAttribute("list",req_array);
      model.addAttribute("size", list.size());

      return ".main.search.map";
   }

}//MatchingController()-end