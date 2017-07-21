package com.github.tij4.chap9.filters;

public class Filter {

	public String name() {
		return getClass().getSimpleName();
	}

	public Waveform process(Waveform input) {
		return input;
	}
}
