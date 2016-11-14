package com.nome.Controller;

import java.io.UnsupportedEncodingException;
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

import com.nome.po.Comment;
import com.nome.service.CommentService;
import com.nome.util.ErrorUtil;
import com.nome.vo.result.Result;

/**
 * @author yzh
 *
 */
@RequestMapping("/Comment")
@Controller
public class CommentController {
	@Autowired
	private CommentService CommentServiceImpl;

	/**
	 * 查询单个用户的所有评论
	 * 
	 * @param request
	 * @param user_id
	 * @return result
	 */
	@RequestMapping("/queryUserlist")
	@ResponseBody
	public Result queryUserlistComment(HttpServletRequest request, @RequestParam("user_id") int user_id) {
		List<Comment> commentlist=CommentServiceImpl.queryListPram(user_id);
		return new Result(true, commentlist, "");
	}

	/**
	 * 查询单个app的所有评论
	 * 
	 * @param request
	 * @param user_id
	 * @return result
	 */
	@RequestMapping("/queryApplist")
	@ResponseBody
	public Result queryApplistComment(HttpServletRequest request, @RequestParam("app_id") int app_id) {
		List<Comment> commentlist=CommentServiceImpl.queryListPram1(app_id);
		return new Result(true, commentlist, "");
	}

	
	
	/**
	 * 插入评论
	 * 
	 * @param request
	 * @param comment
	 * @return result
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping("/add")
	@ResponseBody
	public Result insertComment(HttpServletRequest request, @ModelAttribute("comment")Comment comment) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String data=df.format(new Date());
		comment.setTime(data);
		Comment comment1=CommentServiceImpl.queryOne(comment);
		System.out.println(comment1);
		if(comment1!=null)
			return new Result(false, null, "不能重复评论同一个app");
		if (!ErrorUtil.dbError(CommentServiceImpl.insert(comment)).equals("")) {
			return new Result(false, null, ErrorUtil.dbError(CommentServiceImpl.insert(comment)));
		}
		return new Result(true, null, null);
	}

	/**
	 * 修改评论
	 * 
	 * @param request
	 * @param comment
	 * @return result
	 */
	@RequestMapping("/update")
	@ResponseBody
	public Result updateComment(HttpServletRequest request, @ModelAttribute("comment") Comment comment) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String data=df.format(new Date());
		comment.setTime(data);
		if (!ErrorUtil.dbError(CommentServiceImpl.update(comment)).equals("")) {
			return new Result(false, null, ErrorUtil.dbError(CommentServiceImpl.update(comment)));
		}
		return new Result(true, null, null);
	}

	/**
	 * 删除评论
	 * 
	 * @param request
	 * @param command_id
	 * @return result
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public Result updateComment(HttpServletRequest request, @RequestParam("command_id") int command_id) {
		if (!ErrorUtil.dbError(CommentServiceImpl.delete(command_id)).equals("")) {
			return new Result(false, null, ErrorUtil.dbError(CommentServiceImpl.delete(command_id)));
		}
		return new Result(true, null, null);
	}
}
