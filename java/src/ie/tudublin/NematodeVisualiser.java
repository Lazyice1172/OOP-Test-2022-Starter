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

		// Left
		line(100, halfH, 250, halfH);
		line(100, halfH, 150, halfH + 50);
		line(100, halfH, 150, halfH - 50);
		// Right
		line(width - 100, halfH, width - 250, halfH);
		line(width - 100, halfH, width - 150, halfH + 50);
		line(width - 100, halfH, width - 150, halfH - 50);
	}

	public void drawNematodes() {
		float halfW = width / 2;
		float halfH = height / 2;
		String name = Nematodes.get(mode).getName();
		int Length = Nematodes.get(mode).getLength();
		String limbs = Nematodes.get(mode).getLimbs();
		String gender = Nematodes.get(mode).getGender();
		String eyes = Nematodes.get(mode).getEyes();
		// System.out.println(limbs.indexOf("1"));

		noFill();

		// Name
		textSize(32);
		textAlign(CENTER);
		text(name, halfW, 200);

		// Length
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

		// Check Eyes
		if (eyes.indexOf("1") == 0) {
			float radius = 20;
			float x;
			float y;
			float ex;
			float ey;
			x = halfW + sin(30) * radius;
			y = halfH + ((Length - 2) * 50) - Length * 50 + sin(30) * radius;
			;
			ex = x + sin(30) * 30;
			ey = y + sin(30) * 30;
			line(x, y, ex, ey);
			circle(ex - 5, ey - 5, 15);

			x = halfW + sin(-30) * radius;
			y = halfH + ((Length - 2) * 50) - Length * 50 + sin(30) * radius;
			;
			ex = x + sin(-30) * 30;
			ey = y + sin(30) * 30;
			line(x, y, ex, ey);
			circle(ex + 5, ey - 5, 15);

		}

		// Check Gender
		if (gender.indexOf("m") == 0) {
			line(halfW, halfH + ((Length - 3) * 50) + 25, halfW, halfH + ((Length - 3) * 50) + 50);
			circle(halfW, halfH + ((Length - 3) * 50) + 55, 10);
		} else if (gender.indexOf("f") == 0) {
			circle(halfW, halfH + ((Length - 3) * 50), 25);
		} else if (gender.indexOf("h") == 0) {
			circle(halfW, halfH + ((Length - 3) * 50), 25);
			line(halfW, halfH + ((Length - 3) * 50) + 25, halfW, halfH + ((Length - 3) * 50) + 50);
			circle(halfW, halfH + ((Length - 3) * 50) + 55, 10);
		}

	}

	public void draw() {

		strokeWeight(5);
		float c = map(mode, 0, 13, 0, 255);
		color(c, 255, 255);
		stroke(c, 255, 255);
		fill(c, 255, 255);

		background(0);
		arrow();
		drawNematodes();

	}
}
