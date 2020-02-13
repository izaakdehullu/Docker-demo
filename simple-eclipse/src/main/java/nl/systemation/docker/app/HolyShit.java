package nl.systemation.docker.app;

import java.util.List;
import java.util.Arrays;

public class HolyShit {

	public static void main(String[] args) {
		List<String> woorden = Arrays.asList("This"," ","is"," ","f*ckin"," ","amazing");
		for (String woord : woorden) {
			System.out.print(woord);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// Do Nothing
			}
		}
		System.out.println("!!!");
	}

}
