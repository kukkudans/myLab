package com.harilal;

import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatches {
	private static final String SECTION_ID_REGEX = "(.*)(\\s*)(section)(\\s)([\\da-zA-z]*)(\\s*)(.*)";

	public static void main(String args[]) {

		// String to be scanned to find the pattern.
		String line = "sadfasdfasdf INSERT asdflkjasdf";
		String updateId = "UE20316873";
		String updateId1 = "ue20316873";
		String pattern = "(.*)(\\bINSERT\\b)(.*)";
		String pattern1 = "(UE)(.*)";
		String pattern2 = "(rl)(\\d*)";

		String AMENDMENT_NOTE_PATTERN_TEXT = "(<AMENDNOTE>)(.*)(</AMENDNOTE>)";

		// Create a Pattern object
		Pattern r = Pattern.compile(pattern);

		Pattern r1 = Pattern.compile(AMENDMENT_NOTE_PATTERN_TEXT, Pattern.CASE_INSENSITIVE);
		Predicate<String> predicate1 = r1.asPredicate();
		// Now create matcher object.
		Matcher m = r.matcher(line);
		if (m.find()) {
			System.out.println("MATCH");
		} else {
			System.out.println("NO MATCH");
		}

		r = Pattern.compile(pattern1);
		Predicate<String> predicate = r.asPredicate();
		Matcher m1 = r.matcher(updateId);

		System.out.println("-------Predicate-------");
		System.out.println(predicate.test(updateId));
		System.out.println(predicate.test(updateId1));
		System.out.println(predicate.test(line));

		System.out.println("-------Matcher-------");
		System.out.println(m1.find());
		System.out.println(m1.groupCount());
		System.out.println(m1.group());
		System.out.println(m1.group(1));
		System.out.println(m1.group(2));

		System.out.println("<AMENDNOTE>sdf</AMENDNOTE>------------" + predicate1
				.test("<AMENDNOTE>The followingnregulations have been made under <citation id=\"ci00017\" locsrc=\"a2000c14\" implied-locsrc=\"docelem\"><reference-locator id=\"rl00029\" role=\"individual\" href=\"PartII:sg007:s42:(1)\">section 42(1)</reference-locator></citation>: <citation id=\"ci00018\" locsrc=\"s2004no1756\" implied-locsrc=\"docelem\"><reference-locator id=\"rl00030\" role=\"individual\" href=\"ROOT\">S.I.2004/1756</reference-locator></citation> (W.188), <citation id=\"ci00019\" locsrc=\"s2006no3251\" implied-locsrc=\"docelem\"><reference-locator id=\"rl00031\" role=\"individual\" href=\"ROOT\">S.I. 2006/3251</reference-locator></citation>(W.295), <citation id=\"ci00020\" locsrc=\"s2008no1976\" implied-locsrc=\"docelem\"><reference-locator id=\"rl00032\" role=\"individual\" href=\"ROOT\">S.I. 2008/1976</reference-locator></citation> (W.185), <citation id=\"ci00021\" locsrc=\"s2010no2585\" implied-locsrc=\"docelem\"><reference-locator id=\"rl00033\" role=\"individual\" href=\"ROOT\">S.I. 2010/2585</reference-locator></citation> (W.217), <citation id=\"ci00022\" locsrc=\"s2011no2686\" implied-locsrc=\"docelem\"><reference-locator id=\"rl00034\" role=\"individual\" href=\"ROOT\">S.I. 2011/2686</reference-locator></citation> (W.288),"
						+ "and <citation id=\"ci00023\" locsrc=\"s2013no253\" implied-locsrc=\"docelem\"><reference-locator id=\"rl00035\" role=\"individual\" href=\"ROOT\">S.I. 2013/253</reference-locator></citation>.</AMENDNOTE>"));

		System.out.println("<amendnote>sdf</amendnote>------------" + predicate1.test("<amendnote>sdf</amendnote>"));

		String substituteTmpl = new StringBuilder().append("<upd id=\"UE47843629\"><del><chapter-number>CHAPTER 33990</chapter-number></del>")
				.append("<ins><effect-loading-placeholder/></ins><superscript href=\"VERSION__VIEWER__URLa1999c33__@ACT-BEGIN__0#UE47843629\">1</superscript></upd>").toString();
		String SUBSTITUTE_TEXT = "(.*)(<upd)(.*)(<del)(.*)(<ins)(.*)(</upd>)(.*)";
		Pattern subPattern = Pattern.compile(SUBSTITUTE_TEXT);
		Predicate<String> subsstitutePredicate = subPattern.asPredicate();
		System.out.println(substituteTmpl);

		System.out.println(subsstitutePredicate.test(substituteTmpl));

		System.out.println("RL id");

		r = Pattern.compile("(rl)([0-9]+)");
		predicate = r.asPredicate();
		isMatching(r, "123");
		isMatching(r, "rl123");
		isMatching(r, "rlue123");

		sectionValuePattern("hello section 81a done");
		sectionValuePattern("hello hello hello hello  section 81a done");
		sectionValuePattern("section 81 hi hi hi hi");
		
		applyRegex("(.*)(\\s)(.*)", "SP Bill 5A");
		applyRegex("(.*)(\\s)(.*)", "SP Bill 55A");
		applyRegex("([\\d\\D]+)", "46");
		applyRegex("([\\d\\D]+)", "7");
	}

	private static void sectionValuePattern(String text) {
		applyRegex(SECTION_ID_REGEX, text);
	}

	private static void applyRegex(String regex, String text) {
		Pattern r = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Predicate<String> predicate3 = r.asPredicate();

		System.out.println(text + "\n-------Predicate-------");
		System.out.println(predicate3.test(text));

		System.out.println("-------Matcher-------");
		Matcher m3 = r.matcher(text);
		System.out.println(m3.find());
		for (int i = 1; i <= m3.groupCount(); i++) {

			System.out.println(text+" : -> group(" + i + ") -> " + m3.group(i));
		}
	}

	private static void isMatching(Pattern r, String text) {
		Matcher m1 = r.matcher(text);

		if (m1.find()) {
			System.out.println(text + " MATCH");
		} else {
			System.out.println(text + " NO MATCH");
		}
	}
}