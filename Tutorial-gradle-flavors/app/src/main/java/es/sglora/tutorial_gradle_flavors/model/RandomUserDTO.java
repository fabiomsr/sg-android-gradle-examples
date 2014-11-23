package es.sglora.tutorial_gradle_flavors.model;

/**
 * Created by fabiomsr on 22/11/14.
 */

public class RandomUserDTO {

  public ResultDTO[] results;

  public static  class ResultDTO {
    public UserDTO user;
  }

  public static class UserDTO {
    public NameDTO name;
  }

  public static class NameDTO {
    public String title;
    public String first;
    public String last;
  }
}
