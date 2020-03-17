package com.wpt.abhyas;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.wpt.abhyas.model.Answer;
import com.wpt.abhyas.model.Questions;
import com.wpt.abhyas.model.Response;

@RestController
public class AbhyasApis {

	@RequestMapping(value = "/question1", method = RequestMethod.GET)
	public @ResponseBody Response getQuestion(@RequestParam Integer userId, @RequestParam String question,
			@RequestParam String userName) {

		AbhyasUtils abhyasUtils = new AbhyasUtils();

		if (!abhyasUtils.validUser(userName + userId)) {

			return abhyasUtils.getErrorResponse("not a valid user");
		}

		if (!question.equals("question1") && !abhyasUtils.checkEligiblUser(question, userName + userId)) {
			return abhyasUtils.getErrorResponse("userNotEligible");
		}
		System.out.println("Question: " + question);
		return abhyasUtils.getQuestion(question);
	}

	@RequestMapping(value = "/answer", method = RequestMethod.POST)
	public @ResponseBody Response answer(@RequestBody Answer ans) {

		AbhyasUtils abhyasUtils = new AbhyasUtils();

		if (!abhyasUtils.validUser(ans.getUserName() + ans.getUserId())) {

			return abhyasUtils.getErrorResponse("not a valid user");
		}

		Response response = new Response();

		if (abhyasUtils.validAnswe(ans.getQuestion() + "#" + ans.getAnswer())) {
			abhyasUtils.prasistUserForCorrectAns(ans.getQuestion(), ans.getUserName() + ans.getUserId());
			response.setApiResponseMessaege("correct answer!!");
		}

		return response;
	}

}
