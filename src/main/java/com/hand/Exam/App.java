package com.hand.Exam;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		((AbstractApplicationContext) context).start();

		FilmJDBCTemplate filmJDBCTemplate = (FilmJDBCTemplate) context.getBean("filmJDBCTemplate");

		CustomEventPublisher cvp = (CustomEventPublisher) context.getBean("customEventPublisher");
		Scanner sc = new Scanner(System.in);
		String title;
		String description;
		int language_id;
		// 输出内容
		System.out.println("请输入电影名称：");
		title = sc.nextLine();
		System.out.println("请输入电影描述：");
		description = sc.nextLine();
		System.out.println("请输入语言ID：");
		language_id = sc.nextInt();
		sc.close();
		
		//插入数据前的事件处理
		cvp.beforeInsert();

		filmJDBCTemplate.create(title, description, language_id);
		
		//插入数据后的事件处理
		cvp.afterInsert();

		Film film = filmJDBCTemplate.getFilm(title, description, language_id);

		System.out.println("您插入的数据是：");
		System.out.print("Title:" + film.getTitle());
		System.out.println(", Description:" + film.getDescription());
		System.out.println(", language_id:" + film.getLanguage_id());

		/*
		 * List<Film> film = filmJDBCTemplate.listFilms(); for (Film record :
		 * film) { System.out.print("Title : " + record.getTitle() );
		 * System.out.print(", Description : " + record.getDescription() );
		 * System.out.println(", Language_id : " + record.getLanguage_id()); }
		 */

		((AbstractApplicationContext) context).stop();
	}
}
