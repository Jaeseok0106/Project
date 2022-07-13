package com.human.gallery.domain.QnA;

import java.util.ArrayList;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.human.gallery.domain.QnA.iQna;
import com.human.gallery.domain.QnA.qnaDTO;
import com.human.gallery.domain.QnA.QnaController;

@Controller
public class QnaController {
	
private static final Logger logger = LoggerFactory.getLogger(QnaController.class);
	
	@Autowired
	private SqlSession sqlSession;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {	
		return "home";
	}
	
	@ResponseBody
	@RequestMapping(value="/qnalist", produces="application/json;charset=utf-8")
	public String doQnalist() {
		iQna qna=sqlSession.getMapper(iQna.class);
		ArrayList<qnaDTO> arlist=qna.qnalist();
		JSONArray ja=new JSONArray();
		for(int i=0; i<arlist.size(); i++) {
			qnaDTO qdto=arlist.get(i);
			JSONObject jo=new JSONObject();
			jo.put("id", qdto.getId());
			jo.put("title", qdto.getTitle());
			jo.put("content", qdto.getContent());
			jo.put("writer", qdto.getWriter());
			jo.put("categoryList", qdto.getCategoryList());
			jo.put("heart", qdto.getHeart());
			jo.put("postdate", qdto.getPostdate());
			jo.put("views", qdto.getViews());
			jo.put("user_id", qdto.getUser_id());
			ja.add(jo);
		}
		return ja.toJSONString();
	}
	
	@RequestMapping("/qna")
	public String doQna() {
		return "qnalist";
	}
	
	@ResponseBody
	@RequestMapping(value="/detail", produces="application/json;charset=utf-8")
	public String doSelqna(@RequestParam int id, Model model) {
		iQna qna=sqlSession.getMapper(iQna.class);
		qnaDTO qdto=qna.selqna(id);
		model.addAttribute("qdto",qdto);
		return "detail";
	}
	
//	@RequestMapping("/upqna")
//	public String doUpdate(HttpServletRequest req, Model model) {
//		String title=req.getParameter("title");
//		String content=req.getParameter("content");
//		int writer=Integer.parseInt(req.getParameter("writer"));
//		int id=Integer.parseInt(req.getParameter("id"));
//		iQna qna=sqlSession.getMapper(iQna.class);
//		qna.upqna(title, content, writer,id);
//		return "redirect:/qna";
//	}
}
