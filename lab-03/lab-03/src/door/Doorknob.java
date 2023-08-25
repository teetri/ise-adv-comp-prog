package door;

public class Doorknob {
  private String doorknobID;

  public Doorknob(String doorknobID) {
    this.doorknobID = doorknobID;
  }

  public String getDoorknobID() {
    return doorknobID;
  }

  public boolean canUnlock(Key key) {
    return key.getKeyID().equals(this.doorknobID);
  }
}
