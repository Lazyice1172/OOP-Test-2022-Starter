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
			if (mode > 0) {
				mode = mode - 1;
			}

		}
		if (keyCode == RIGHT)

		{
			if (mode < 12) {
				mode = mode + 1;
			}

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

	public void drawNematodes(int x) {
		float halfW = width / 2;
		float halfH = height / 2;
		String name = Nematodes.get(x).getName();
		int Length = Nematodes.get(x).getLength();
		String limbs = Nematodes.get(x).getLimbs();
		String gender = Nematodes.get(x).getGender();
		// System.out.println(limbs.indexOf("1"));

		noFill();
		textSize(20);
		textAlign(CENTER);
		text(name, halfW, 200);

		for (int i = 0; i < Length; i++) {
			circle(halfW, halfH + ((Length - 3) * 50) - i * 50, 50);
		}
		// Check Limbs
		if (limbs.indexOf("1") == 0) {
			for (int i = 0; i < Length; i++) {
				line(halfW + 25, halfH + ((Length - 3) * 50) - i * 50, halfW + 50,
						halfH + ((Length - 3) * 50) - i * 50);
				line(halfW - 25, halfH + ((Length - 3) * 50) - i * 50, halfW - 50,
						halfH + ((Length - 3) * 50) - i * 50);
			}
		}
		if (gender.indexOf("f") == 0) {
			circle(halfW, halfH + ((Length - 3) * 50), 25);
		}

	}

	public void draw() {

		strokeWeight(5);
		stroke(144, 86, 97);

		background(0);
		arrow();
		drawNematodes(mode);

	}
}
