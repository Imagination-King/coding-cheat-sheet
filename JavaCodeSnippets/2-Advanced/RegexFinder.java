import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexFinder {
  /*
   * The main purpose of this program is to demonstrate some regular expressions
   * and how to use them. While it's not intended to be used as a library, it
   * certainly could be. You could also just copy-paste the expressions from here
   * to wherever else you need them if you really wanted to.
   * 
   * Regular expressions are commonly used in combination with the Pattern and
   * Matcher classes (imported above and demonstrated below). However, there are
   * other standard methods that can use them such as:
   * String class' .matches(), .split(), .replace(), and Scanner class'
   * .findInLine(), .skip(), and .useDelimiter().
   * 
   * Below are some sample regular expressions based on real things you may wish
   * to locate in a real world scenario.
   */

  private static String getRegex(String key) {
    switch (key.toLowerCase()) {
      /*
       * The simplest one to start with: binary numbers of any length. (Technically,
       * this will also identify any decimal numbers that only use 0 or 1 like 10, but
       * that can't be helped).
       * -> [0|1] means we're searching for character class 0 or 1
       * -> + means we want at least 1 occurence of the designated character(s)
       */
      case "binary":
        return "[0|1]+";
      /*
       * This one matches dates in the format mm-dd-yyyy or dd-mm-yyyy. Creating a
       * regex to identify more date formats, including formats where the month is
       * spelled out) is possible, but will take a lot more space.
       * -> \\b represents a word boundary, meaning there should be white space in the
       * designated spot (in this case, both before and after the string)
       * -> The rest of this one should be pretty self-explanatory
       */

      case "date":
        return "\\b\\d{2}-\\d{2}-\\d{4}\\b";
      /*
       * Ramping up a little, this one looks for email addresses formatted
       * string@string.string
       * -> [A-Za-z0-9._%+-]+ means we want at least 1 of any alphanumeric characters
       * or one of the accepted symbols (period(.), underscore(_), percent sign(%),
       * plus(+) sign or minus(-) sign)
       * -> @ this just specified the at(@) symbol itself, nothing fancy here
       * -> [A-Za-z0-9.-]+ one of these again for the domain name of the email
       * provider. Notice the lack of underscore, percent, and plus signs.
       * -> \\. this represents the period(.) character. Because the period is a
       * proper regex symbol, and it's not in a character class like before, we have
       * to use an escape character (\) to specify the literal value of period(.). Of
       * course, because backslash is itself a special character, we have to use an
       * escape character on it too, hence the two backslashes. Find more of these
       * escapable characters in the notes below.
       * -> [A-Za-z]{2,} this time we only want characters from the alphabet, and the
       * curly braces specify how many we want, in this case at least 2.
       * ---> Note: {x,y} specify at least x but no more than y. If you only put one
       * number, you're only specifying the upper bound, but if you put one number
       * with a comma, you're only specifying the lower bound.
       */

      case "email":
        return "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}";
      /*
       * Cell phone numbers are pretty similar to emails, but without all the extra
       * characters.
       * -> \\(? escaped open paranthese, and a question mark to mark the symbol as
       * optional
       * -> [1-9]\\d{2} three numbers, the first of which cannot be 0 (\\d == [0,9])
       * -> \\)? same as before, optional escaped closed paranthese
       * -> [-.\\s]? another optional character class representing the symbols
       * dash(-), dot(.), and single space(\\s). Notice that single space is an
       * escaped character.
       * -> We then repeat the two pieces we just had, followed by
       * -> \\d{4} which is just four numerical digits [0,9]
       */

      case "phone":
        return "\\(?[1-9]\\d{2}\\)?[-.\\s]?[1-9]\\d{2}[-.\\s]?\\d{4}";
      /*
       * IPv4 addresses in format xxx.xxx.xxx.xxx within [0.0.0.0, 255.255.255.255]
       * -> ( ( 25[0-5]|2[0-4]\\d|[01]?\\d\\d? )\\. ){3} looks nasty, but let's break
       * it down:
       * ---> 25[0-5] any number between 250 and 255 OR...
       * ---> 2[0-4]\\d ...any number between 200 and 249 (could be written as OR...
       * ---> [01]?\\d\\d? ...optional leading 0 or 1, then a digit, then another
       * optional digit (should cover [0,199])
       * ---> \\.){3} we want three of those numbers, each followed by a period
       * -> (25[0-5]|2[0-4]\\d|[01]?\\d\\d?) we just want one final number [0,255],
       * using the same logic as before
       */

      case "ipv4":
        return "((25[0-5]|2[0-4]\\d|[01]?\\d\\d?)\\.){3}(25[0-5]|2[0-4]\\d|[01]?\\d\\d?)";

      default:
        System.err.println("Unknown pattern: " + key);
        System.err.println("Available patterns: binary, date, email, phone, ipv4");
        System.exit(1);
        return null;
    }
  }

// @formatter:off
/*
    * Escapable characters:
    * Reminder to double escape when inside Strings
    * Character   Normal meaning
    *   .(dot)     any character
    *   *(star)    quantifier (0 or more)
    *   +(plus)    quantifier (1 or more)
    *   ?          quantifier (0 or 1)
    *   ( )        used for grouping
    *   [ ]        used for character classes
    *   { }        used for quantities
    *   |          OR
    *   \          escape character 
    * 
    * Special characters
    * Character  Meaning
    *    \b      word boundary (solitary strings), capital \B represents "NOT \b"
    *    \d      digit [0-9], capital \D represents "NOT \d"
    *    \s      whitespace (space, tab (\t), newline (\n), etc), capital \S represents "NOT \s"
    *    \w      character class [A-Za-z0-9_], captial \W represents "NOT \w"
    */
// @formatter:on

  public static void main(String[] args) throws Exception {
    // Make sure program is run with proper inputs
    if (args.length < 1) {
      System.err.println("Usage: java RegexFind <patternName> < inputfile");
      return;
    }

    String patternName = args[0];
    String regex = getRegex(patternName);
    Pattern pattern = Pattern.compile(regex);

    // This just helps the program read in the whole text file line by line, until
    // it reaches the end.
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String line;

    while ((line = reader.readLine()) != null) {
      Matcher matcher = pattern.matcher(line);
      while (matcher.find()) {
        System.out.println(matcher.group());
      }
    }
  }
}