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

		// Testing
		// printNematodes();
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

	public void arrow() {
		int halfH = height / 2;
		stroke(144);
		// Left
		line(100, halfH, 250, halfH);
		line(100, halfH, 150, halfH + 50);
		line(100, halfH, 150, halfH - 50);
		// Right
		line(width - 100, halfH, width - 250, halfH);
		line(width - 100, halfH, width - 150, halfH + 50);
		line(width - 100, halfH, width - 150, halfH - 50);
	}

	public void draw() {

		arrow();
		strokeWeight(5);
		switch (mode)
		{
			case 0: {

				break;
			}
			case 1: {

				break;
			}
			case 2: {

				break;
			}
			case 3: {

				break;
			}
			case 4: {

				break;
			}
			case 5: {

				break;
			}
			case 6: {

				break;
			}
			case 7: {

				break;
			}
			case 8: {

				break;
			}
			case 9: {

				break;
			}
			case 10: {

				break;
			}
			case 11: {

				break;
			}
			case 12: {

				break;
			}
			case 13: {

				break;
			}

			default:
				break;
		}

	}
}
