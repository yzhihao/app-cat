package com.nome.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nome.po.Answer;
import com.nome.po.Comment;
import com.nome.service.AnswerService;
import com.nome.util.ErrorUtil;
import com.nome.vo.result.Result;

/**
 * @author yzh
 *
 */
@RequestMapping("/answer")
@Controller
public class AnswerController {
	@Autowired
	private AnswerService AnswerServiceImpl;

	/**
	 * 查询单个用户的所有回答
	 * 
	 * @param request
	 * @param user_id
	 * @return result
	 */
	@RequestMapping("/querylist")
	@ResponseBody
	public Result querylistanswer(HttpServletRequest request, @RequestParam("user_id") int user_id) {
		List<Answer> answerlist=AnswerServiceImpl.queryListPram(user_id);
		return new Result(true, answerlist, "");
	}

	/**
	 * 查询单个问题的所有回答
	 * 
	 * @param request
	 * @param user_id
	 * @return result
	 */
	@RequestMapping("/queryOnelist")
	@ResponseBody
	public Result queryAlistanswer(HttpServletRequest request, @RequestParam("question_id") int question_id) {
		List<Answer> answerlist=AnswerServiceImpl.queryListPram1(question_id);
		return new Result(true, answerlist, "");
	}

	
	
	/**
	 * 插入回答问题
	 * 
	 * @param request
	 * @param answer
	 * @return result
	 */
	@RequestMapping("/add")
	@ResponseBody
	public Result insertAnswer(HttpServletRequest request, @ModelAttribute("answer") Answer answer) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String data=df.format(new Date());
		answer.setTime(data);
		Answer answer1=AnswerServiceImpl.queryOne(answer);
		if(answer1!=null)
			return new Result(false, null, "您已经回答过这个问题了");
		if (!ErrorUtil.dbError(AnswerServiceImpl.insert(answer)).equals("")) {
			return new Result(false, null, ErrorUtil.dbError(AnswerServiceImpl.insert(answer)));
		}
		return new Result(true, null, null);
	}

	/**
	 * 修改回答
	 * 
	 * @param request
	 * @param answer
	 * @return result
	 */
	@RequestMapping("/update")
	@ResponseBody
	public Result updateAnswer(HttpServletRequest request, @ModelAttribute("answer") Answer answer) {
		if (!ErrorUtil.dbError(AnswerServiceImpl.update(answer)).equals("")) {
			return new Result(false, null, ErrorUtil.dbError(AnswerServiceImpl.update(answer)));
		}
		return new Result(true, null, null);
	}

	/**
	 * 删除回答
	 * 
	 * @param request
	 * @param answer_id
	 * @return result
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public Result updateAnswer(HttpServletRequest request, @RequestParam("answer_id") int answer_id) {
		if (!ErrorUtil.dbError(AnswerServiceImpl.delete(answer_id)).equals("")) {
			return new Result(false, null, ErrorUtil.dbError(AnswerServiceImpl.delete(answer_id)));
		}
		return new Result(true, null, null);
	}
}
