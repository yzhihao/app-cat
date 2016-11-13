package com.nome.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nome.po.Question;
import com.nome.service.QuestionService;
import com.nome.util.ErrorUtil;
import com.nome.vo.result.Result;

/**
 * @author yzh
 *
 */
@RequestMapping("/question")
@Controller
public class QuestionController {
	@Autowired
	private QuestionService QuestionServiceImpl;

	/**
	 * 查询单个用户的所有问题
	 * 
	 * @param request
	 * @param user_id
	 * @return result
	 */
	@RequestMapping("/queryuser_list")
	@ResponseBody
	public Result querylistQuestion(HttpServletRequest request, @RequestParam("user_id") int user_id) {
		List<Question> questionlist=QuestionServiceImpl.queryListPram(user_id);
		return new Result(true, questionlist, "");
	}

	/**
	 * 查询所有问题
	 * 
	 * @param request
	 * @param user_id
	 * @return result
	 */
	@RequestMapping("/queryAll")
	@ResponseBody
	public Result queryAllQuestion(HttpServletRequest request) {
		List<Question> questionlist=QuestionServiceImpl.queryList();
		return new Result(true, questionlist, "");
	}
	
	
	
	/**
	 * 增加问题
	 * 
	 * @param request
	 * @param Question
	 * @return result
	 */
	@RequestMapping("/add")
	@ResponseBody
	public Result insertQuestion(HttpServletRequest request, @ModelAttribute("Question") Question question) {

		if (!ErrorUtil.dbError(QuestionServiceImpl.insert(question)).equals("")) {
			return new Result(false, null, ErrorUtil.dbError(QuestionServiceImpl.insert(question)));
		}
		return new Result(true, null, null);
	}

	/**
	 * 修改问题
	 * 
	 * @param request
	 * @param Question
	 * @return result
	 */
	@RequestMapping("/update")
	@ResponseBody
	public Result updateQuestion(HttpServletRequest request, @ModelAttribute("Question") Question question) {
		if (!ErrorUtil.dbError(QuestionServiceImpl.update(question)).equals("")) {
			return new Result(false, null, ErrorUtil.dbError(QuestionServiceImpl.update(question)));
		}
		return new Result(true, null, null);
	}

	/**
	 * 删除问题
	 * 
	 * @param request
	 * @param command_id
	 * @return result
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public Result updateQuestion(HttpServletRequest request, @RequestParam("question_id") int question_id) {
		if (!ErrorUtil.dbError(QuestionServiceImpl.delete(question_id)).equals("")) {
			return new Result(false, null, ErrorUtil.dbError(QuestionServiceImpl.delete(question_id)));
		}
		return new Result(true, null, null);
	}
}
