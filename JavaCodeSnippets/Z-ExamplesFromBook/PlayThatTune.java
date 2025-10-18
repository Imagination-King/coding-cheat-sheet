import ExternalLibs.StdAudio;
import ExternalLibs.StdIn;

public class PlayThatTune {
  public static void main(String[] args) {
    int SAMPLING_RATE = 44100; // samples per second
    while (!StdIn.isEmpty()) { // goes until there's nothing else to read
      int pitch = StdIn.readInt(); // grabs next int from file, sets pitch
      double duration = StdIn.readDouble(); // grabs next double from file, sets note length
      double hz = 440 * Math.pow(2, pitch / 12.0); // frequency
      int n = (int) (SAMPLING_RATE * duration); // number of samples
      double[] a = new double[n + 1]; // array to hold samples
      for (int i = 0; i <= n; i++) {
        a[i] = Math.sin(2 * Math.PI * i * hz / SAMPLING_RATE); // sampling sin wave
      }
      StdAudio.play(a); // play sampled wave
    }
  }
}

/*
 * Accepts txt files composed of pairs of ints and double representing pitch
 * (distance from A) and note length. To play said file, simply filter it via
 * command "java PlayThatTune < fileName.txt"
 * Some of this would make a lot more sense if I understood audio/music
 * terminology better...
 */