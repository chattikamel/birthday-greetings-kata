package it.xpug.kata.birthday_greetings;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public class BirthdayService {

	private final NotificationService notificationService;

	public BirthdayService(NotificationService notificationService){
		this.notificationService = notificationService;
	}

	public void sendGreetings(String fileName, BirthDate birthDate) throws IOException, ParseException, MessagingException {
		BufferedReader in = new BufferedReader(new FileReader(fileName));
		String str = "";
		str = in.readLine(); // skip header
		while ((str = in.readLine()) != null) {
			String[] employeeData = str.split(", ");
			Employee employee = new Employee(employeeData[1], employeeData[0], employeeData[2], employeeData[3]);
			if (employee.isBirthday(birthDate)) {
				String recipient = employee.getEmail();
				String body = "Happy Birthday, dear %NAME% !".replace("%NAME%", employee.getFirstName());
				String subject = "Happy Birthday!";
				notificationService.sendMessage("sender@here.com", subject, body, recipient);
			}
		}
	}
}
