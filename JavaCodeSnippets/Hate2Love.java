import javax.swing.JOptionPane;

public class Hate2Love {

  public static void main(String[] args) {
    // Display a message box with text and an entry field.
    String message = JOptionPane.showInputDialog(null, "Let your hate flow!");

    // Replace the first instance of the word "hate" with "love"
    message = message.replaceFirst("hate", "love");

    // Display a message box with the updated String
    JOptionPane.showMessageDialog(null, "Hate is not the Jedi way. Instead, say:\n" + message);
  }
}
