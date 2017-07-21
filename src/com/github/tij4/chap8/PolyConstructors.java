package com.github.tij4.chap8;

class Glyph {
	void draw() {
		System.out.println("Glyph.draw()");
	}

	Glyph() {
		System.out.println("Glyph() before draw()");
		draw(); // polymorphism
		System.out.println("Glyph() after draw()");
	}
}

class RoundGlyph extends Glyph {
	private int radius = 1;

	RoundGlyph(int r) {
		radius = r;
		System.out.println("RoundGlyph.RoundGlyph.radius= " + radius);
	}

	void draw() {
		System.out.println("RoundGlyph.draw().radius= " + radius);
	}
}

public class PolyConstructors {

	public static void main(String[] args) {
		new RoundGlyph(7);
	}
}

/*Output:
Glyph() before draw()
RoundGlyph.draw().radius= 0
Glyph() after draw()
RoundGlyph.RoundGlyph.radius= 7 
 */
