package com.wpt.abhyas.connection;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.CompletableFuture;

public class FileConnections {

	private static final Stack<FileInputStream> ufConnections = new Stack<>();
	private static final Stack<FileInputStream> qAConnections = new Stack<>();
	private static final Stack<FileInputStream> ansConnections = new Stack<>();
	static {

		try {
			FileInputStream initialStreamUf = new FileInputStream("/home/rita/Desktop/username.txt");
			FileInputStream[] initialStreamUfs = new FileInputStream[] { initialStreamUf, initialStreamUf,
					initialStreamUf, initialStreamUf, initialStreamUf, initialStreamUf, initialStreamUf };
			FileInputStream initialStreamQa = new FileInputStream("/home/rita/Desktop/questions1.txt");
			FileInputStream[] initialStreamQas = new FileInputStream[] { initialStreamQa, initialStreamQa,
					initialStreamQa, initialStreamQa, initialStreamQa, initialStreamQa, initialStreamQa,
					initialStreamQa, initialStreamQa, initialStreamQa };
			FileInputStream initialStreamAns = new FileInputStream("/home/rita/Desktop/ans.txt");
			FileInputStream[] initialStreamAnsw = new FileInputStream[] { initialStreamAns,initialStreamAns,initialStreamAns};
			
			List<FileInputStream> list1 = Arrays.asList(initialStreamUfs);
			List<FileInputStream> list2 = Arrays.asList(initialStreamQas);
			List<FileInputStream> list3 = Arrays.asList(initialStreamAnsw);
			threadForUser(list1);
			threadForQuestions(list2);
			threadForAnswers(list3);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void threadForUser(List<FileInputStream> list1) {
		CompletableFuture<Void> ufThreadConnection = CompletableFuture.runAsync(() -> {
			while(true) {
			if (ufConnections.isEmpty()) {
				ufConnections.addAll(list1);
			}
			}
		});
	}

	private static void threadForQuestions(List<FileInputStream> list1) {
		CompletableFuture<Void> ufThreadConnection = CompletableFuture.runAsync(() -> {
			while(true) {
			if (qAConnections.isEmpty()) {
				qAConnections.addAll(list1);
			}
			}
		});
	}

	private static void threadForAnswers(List<FileInputStream> list1) {
		CompletableFuture<Void> ufThreadConnection = CompletableFuture.runAsync(() -> {
			while(true) {
			if (ansConnections.isEmpty()) {
				ansConnections.addAll(list1);
			}
			}
		});
	}
	
	
	protected FileInputStream getUserConnection() {
		return ufConnections.pop();
	}
	
	protected FileInputStream getQuestionsConnection() {
		return qAConnections.pop();
	}
	
	protected FileInputStream getAnswer() {
		return ansConnections.pop();
	}
}
