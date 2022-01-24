public class Other {

	// (anyway, it is already split by \n before)
	// 1] split to \t
	// 2] split after \n

	String splitNachNr1TAB(String input) {
		String output = "";
		String[] tempTextTeilArr = input.split("\t");
		for (int i = 0; i < tempTextTeilArr.length; i++) {
			output = output + "|" + splitNachNr2NEWLINE(tempTextTeilArr[i]);
		}
		return output;
	}

	String splitNachNr2NEWLINE(String input) {
		String output = "";
		String[] tempTextTeilArr = input.split("\n");
		for (int i = 0; i < tempTextTeilArr.length; i++) {
			output = output + "=" + tempTextTeilArr[i];
		}
		return output;
	}

	String testMethod(String input) {
		String output = "";

		if (input.startsWith("⌑")) {
			String[] tempTextTeilArr = input.split("\n");
			output = "";

			for (int i = 0; i < tempTextTeilArr.length; i++) {
				output = output + "#" + tempTextTeilArr[i];
			}
		}

		return output;
	}

	// How many spaces can there maximal between words? (Normally one & never more)
	static String reduceTxtOneSpaceMax(String txtin) {
		int spacesCheckMax = 10;
		String txtout = txtin;
		// System.out.println("START " + txtout);

		String tempSpaces = "";
		for (int i = spacesCheckMax; i > 0; i--) {

//test l8r buffered reader here if necessary (as described in Tut)
			// & then check with timer, which one is really faster

			tempSpaces = createSpacesAnz(i);
			if (txtout.contains(tempSpaces)) {
				txtout = txtout.replaceAll(tempSpaces, " ");
			}
		}

		// actually double, but maybe useful again here at the end
		txtout = txtout.trim();

		return txtout;

	}

	private static String createSpacesAnz(int max) {
		String outp = "";

		for (int i = 0; i < max; i++) {
			outp = outp + " ";
		}

		return outp;

	}

}
