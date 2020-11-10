import controller.Controller;
import model.Model;
import view.View;

public class Launcher {

	public static void main(String[] args) {

		View v = new View();
		Model m = new Model();

		Controller c = new Controller(m, v);

	}

}
