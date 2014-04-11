package rss_msgs;

public interface StateMsg extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "rss_msgs/StateMsg";
  static final java.lang.String _DEFINITION = "string state\n";
  java.lang.String getState();
  void setState(java.lang.String value);
}
