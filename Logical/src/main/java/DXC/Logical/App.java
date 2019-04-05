package DXC.Logical;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class App {

	public static void repeatedCharsCount(String str) {
		Map<Character, Integer> dupMap = new HashMap<Character, Integer>();
		char[] chrs = str.toCharArray();
		for (Character ch : chrs) {
			if (dupMap.containsKey(ch)) {
				dupMap.put(ch, dupMap.get(ch) + 1);
			}
			dupMap.put(ch, 1);
		}
		System.out.println(dupMap);
	}

	public static void repeatedCharsCountSolution(String str) {
		@SuppressWarnings("unused")
		Integer s = null;
		Map<Character, Integer> dupMap = new HashMap<Character, Integer>();
		char[] chrs = str.toCharArray();
		for (Character ch : chrs) {
			s = dupMap.containsKey(ch) ? dupMap.put(ch, dupMap.get(ch) + 1) : dupMap.put(ch, 1);
		}
		System.out.println(dupMap);
	}

	public static void rCC(String str) {
		String[] stringarray = str.split("");
		Map<Object, Long> map = Arrays.stream(stringarray)
				.collect(Collectors.groupingBy(c -> c, Collectors.counting()));
		map.forEach((k, v) -> System.out.println(k + " -> " + v));
	}

	public static void repeatedChars(String str) {
		List<String> list = Arrays.asList(str.split(""));
		Set<String> uniqueWords = new HashSet<String>(list);
		for (String word : uniqueWords) {
			System.out.println(word + ": " + Collections.frequency(list, word));
		}
	}

	public static <T extends Comparable<T>> void getDuplicates(T[] array) {
		Set<T> dupes = new HashSet<T>();
		for (T i : array) {
			if (!dupes.add(i)) {
				System.out.println("Duplicate element in array is : " + i);
			}
		}
	}

	static void printDuplicateNumber(int arr[]) {
		int constant = arr.length, value = 0;
		int len = arr.length;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < len) {
				value = arr[i];
			} else {
				value = arr[i] - constant;
			}
			if (arr[value] < len) {
				arr[value] = arr[value] + constant;
			} else {
				System.out.println(arr[i] > len ? arr[i] - constant : arr[i]);
			}
		}
	}

	// flaw code
	public static void repeatedCharactersCount(String s) {
		int distinct = 0;
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < s.length(); j++) {
				if (s.charAt(i) == s.charAt(j))
					distinct++;
			}
			System.out.println(s.charAt(i) + "--" + distinct);
			String d = String.valueOf(s.charAt(i)).trim();
			s = s.replaceAll(d, "");
			distinct = 0;
		}

	}

	public static void repeatedChar(String str) {
		while (str.length() > 0) {
			char ch = str.charAt(0);
			System.out.println(ch + "->" + countChar(str, ch));
			str = str.replace("" + ch, "");
		}
	}

	private static int countChar(String str, char ch) {
		int count = 0;
		while (str.indexOf(ch) != -1) {
			count++;
			str = str.substring(str.indexOf(ch) + 1);
		}
		return count;
	}

	// only alphabets
	public static void repeatedCarsCnt(String a) {
		char Char;
		int count;
		a = a.toLowerCase();
		for (Char = 'a'; Char <= 'z'; Char++) {
			count = 0;
			for (int i = 0; i < a.length(); i++) {
				if (a.charAt(i) == Char) {
					count++;
				}
			}
			System.out.println("Number of occurences of " + Char + " is " + count);
		}
	}

	public static void repeatedChrsCount(String str) {
		for (int i = 0; i < str.length(); i++) {
			int count = 0;
			if (str.contains(str.charAt(i) + "")) {
				str = str.replace("" + str.charAt(i), "");
				count++;
			}
			System.out.println(str.charAt(i) + "---->" + count);
		}

	}

	/*
	 * public static void printRepeating(int arr[], int size) { int i;
	 * System.out.println("The repeating elements are : "); for (i = 0; i < size;
	 * i++) { if (arr[Math.abs(arr[i])] >= 0) arr[Math.abs(arr[i])] =
	 * -arr[Math.abs(arr[i])]; else System.out.print(Math.abs(arr[i]) + " "); } }
	 */

	public static void main(String[] args) {
		Instant start = Instant.now();
		repeatedCharsCount("099000088889899097765");
//		repeatedCharsCountSolution("099000088889899097765");
//		rCC("099000088889899097765");
//		repeatedChars("099000088889899097765");
//		repeatedChar("099000088889899097765");
//		repeatedCharactersCount("099000088889899097765");
//		repeatedCarsCnt("aaasdsssfddeddd");
//		repeatedChrsCount("aaasdsssfddeddd");
		Instant finish = Instant.now();
		System.out.println(Duration.between(start, finish).toMillis());
	}
}
