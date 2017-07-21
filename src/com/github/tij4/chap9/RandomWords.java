package com.github.tij4.chap9;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Random;
import java.util.Scanner;

public class RandomWords implements Readable {

	private static Random rand = new Random(47);
	private static final char[] capitals = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
	private static final char[] lowers = "abcdefghijklmnopqrstuvwxyz".toCharArray();
	private static final char[] vowels = "aeiou".toCharArray();
	private int count;

	public RandomWords(int count) {
		this.count = count;
	}

	@Override
	public int read(CharBuffer charBuffer) throws IOException {
		if (count-- == 0)
			return -1;
		charBuffer.append(capitals[rand.nextInt(capitals.length)]);
		for (int i = 0; i < 4; i++) {
			charBuffer.append(vowels[rand.nextInt(vowels.length)]);
			charBuffer.append(lowers[rand.nextInt(lowers.length)]);
		}
		charBuffer.append(" ");
		return 10;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(new RandomWords(10));
		while (s.hasNext()) {
			System.out.println(s.next());
		}
	}

}
/*Output:
Fowenucor
Goeazimom
Raeuuacio
Nuoadesiw
Hageaikux
Ruqicibui
Numasetih
Kuuuuozog
Waqizeyoy
 */
