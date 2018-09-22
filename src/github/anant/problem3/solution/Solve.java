package github.anant.problem3.solution;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.assertArrayEquals;

public class Solve {

  public static void reverseWords(char[] message) {
    reverseChars(message, 0, message.length - 1);

    int startIndex = 0;

    for (int i = 0; i <= message.length; i++) {
      if (i == message.length || message[i] == ' ')  {
        reverseChars(message, startIndex, i - 1);

        startIndex = i + 1;
      }
    }

  }


  private static void reverseChars(char[] message, Integer startIndex, Integer endIndex) {

    while (startIndex < endIndex) {
      char temp = message[startIndex];
      message[startIndex] = message[endIndex];
      message[endIndex] = temp;

      startIndex++;
      endIndex--;
    }
  }


  // tests

  @Test
  public void oneWordTest() {
    final char[] expected = "vault".toCharArray();
    final char[] actual = "vault".toCharArray();
    reverseWords(actual);
    assertArrayEquals(expected, actual);
  }

  @Test
  public void twoWordsTest() {
    final char[] expected = "cake thief".toCharArray();
    final char[] actual = "thief cake".toCharArray();
    reverseWords(actual);
    assertArrayEquals(expected, actual);
  }

  @Test
  public void threeWordsTest() {
    final char[] expected = "get another one".toCharArray();
    final char[] actual = "one another get".toCharArray();
    reverseWords(actual);
    assertArrayEquals(expected, actual);
  }

  @Test
  public void multipleWordsSameLengthTest() {
    final char[] expected = "the cat ate the rat".toCharArray();
    final char[] actual = "rat the ate cat the".toCharArray();
    reverseWords(actual);
    assertArrayEquals(expected, actual);
  }

  @Test
  public void multipleWordsDifferentLengthsTest() {
    final char[] expected = "chocolate bundt cake is yummy".toCharArray();
    final char[] actual = "yummy is cake bundt chocolate".toCharArray();
    reverseWords(actual);
    assertArrayEquals(expected, actual);
  }

  @Test
  public void emptyStringTest() {
    final char[] expected = "".toCharArray();
    final char[] actual = "".toCharArray();
    reverseWords(actual);
    assertArrayEquals(expected, actual);
  }

  public static void main(String[] args) {
    Result result = JUnitCore.runClasses(Solve.class);
    for (Failure failure : result.getFailures()) {
      System.out.println(failure.toString());
    }
    if (result.wasSuccessful()) {
      System.out.println("All tests passed.");
    }
  }
}
