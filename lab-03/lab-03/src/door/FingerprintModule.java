package door;

public class FingerprintModule {
  private String fingerprintSerialNumber;
  private String fingerprint;

  public FingerprintModule(String fingerprintSerialNumber) {
    this.fingerprintSerialNumber = fingerprintSerialNumber;
  }

  public String getFingerprintSerialNumber() {
    return fingerprintSerialNumber;
  }

  public void registerFingerprint(String fingerprint) {
    this.fingerprint = fingerprint;
    // System.out.println("Fingerprint " + this.fingerprint + " registered.");
  }

  public boolean checkFingerprint(String fingerprint) {
    // System.out.println(fingerprint + " vs " + this.fingerprint);
    return fingerprint.equals(this.fingerprint);
  }

}
