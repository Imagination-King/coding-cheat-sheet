import ExternalLibs.StdAudio;

public class ConcertA {
  public static void main(String[] args) {
    int SAMPLING_RATE = 44100; // samples per second
    int hz = 440; // concert A note
    double duration = 3.0; // time in seconds
    int n = (int) (SAMPLING_RATE * duration); //number of total samples for given time
    double[] a = new double[n + 1]; // array to hold sampled values
    for (int i = 0; i <= n; i++) {
      a[i] = Math.sin(2 * Math.PI * i * hz / SAMPLING_RATE); // samples the sin wave
    }
    StdAudio.play(a); // play the array
  }
}
