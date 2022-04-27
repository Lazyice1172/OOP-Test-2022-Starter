package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class NematodeVisualiser extends PApplet {

	ArrayList<Nematode> Nematodes = new ArrayList<Nematode>();
	int mode = 0;

	public void keyPressed() {
		if (keyCode == LEFT) {
			mode = mode + 1;
		}
	}

	public void settings() {
		size(800, 800);
	}

	public void setup() {
		colorMode(HSB);
		background(0);
		smooth();

		loadNematodes();

		//Testing
		printNematodes();
	}

	
	public void loadNematodes() {
		Table table = loadTable("nematodes.csv", "header");
        for (TableRow row : table.rows()) {
            Nematode t = new Nematode(row);
			Nematodes.add(t);
        }
	}

	public void printNematodes() {
		for (Nematode t : Nematodes) {
			System.out.println(t);
		}
	}
	

	public void draw() {
		switch (mode)

		{
			case 0: {

				break;
			}

			default:
				break;
		}

	}
}
