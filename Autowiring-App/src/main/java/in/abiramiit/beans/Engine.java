package in.abiramiit.beans;

import org.springframework.stereotype.Component;

@Component
public class Engine {

	public Engine() {
		System.out.println("Engine :: Constructor");
	}

	public int start() {
		//logic to start engine
		return 1;
	}

}
