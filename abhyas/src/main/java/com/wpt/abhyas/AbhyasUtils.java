package com.wpt.abhyas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

import com.wpt.abhyas.connection.AbhyasConnection;
import com.wpt.abhyas.model.Questions;
import com.wpt.abhyas.model.Response;

public class AbhyasUtils {

	private static Set<String> userList = new LinkedHashSet<>();
	private static Set<String> questionList = new LinkedHashSet<>();
	private static Set<String> ansList = new LinkedHashSet<>();
	private static TreeMap<String, List<String>> uAmap = new TreeMap<>();
	static {
		try {
			Class.forName("com.wpt.abhyas.connection.FileConnections");
			Thread.sleep(10000);
			Scanner sc = new Scanner(new AbhyasConnection().getUserConnection());
			Scanner sc2 = new Scanner(new AbhyasConnection().getQuestionsConnection());
			Scanner sc3 = new Scanner(new AbhyasConnection().getAnsConnection());
			while (sc.hasNext()) {
				String name = sc.nextLine().trim();
				System.out.println(name);
				userList.add(name);
			}

			while (sc2.hasNext()) {
				String question = sc2.nextLine().trim();
				System.out.println(question);
				questionList.add(question);
			}

			while (sc3.hasNext()) {
				String anser = sc3.nextLine().trim();
				System.out.println(anser);
				ansList.add(anser);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean validUser(String user) {
		return userList.contains(user);
	}

	public Response getErrorResponse(String msg) {
		Response response = new Response();
		response.setApiResponseMessaege(msg);
		return response;
	}

	public Response getQuestion(String question) {
		String data = questionList.stream().filter(q -> q.startsWith(question)).collect(Collectors.toList()).get(0);
		String[] datas = data.split("#");
		Questions question1 = new Questions();
		question1.setQuestion(datas[0].split("=")[1]);
		List<String> optionList = Arrays.asList(datas[1].split(","));
		question1.setOptions(optionList);
		Response response = new Response();
		response.setApiResponseMessaege(question);
		response.setApiResponseData(question1);
		return response;
	}

	public boolean validAnswe(String ans) {
		return ansList.contains(ans);
	}

	public void prasistUserForCorrectAns(String question, String userId) {
		boolean result = uAmap.entrySet().stream().anyMatch(e -> e.getKey().equals(question));
		List<String> list = null;
		if (result) {
			list = uAmap.get(question);
			list.add(userId);
			uAmap.put(question, list);
		} else {
			list = new ArrayList<>();
			list.add(userId);
			uAmap.put(question, list);
		}
	}

	public boolean checkEligiblUser(String question, String userId) {
		List<Object> keyList = Arrays.asList(uAmap.keySet().toArray());
		String key = (String) keyList.get(keyList.indexOf(question)!=-1?keyList.indexOf(question)-1:0);
		return uAmap.get(key).contains(userId);
	}
}