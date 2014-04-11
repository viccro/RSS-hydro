package rss_msgs;

public interface ArmMsg extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "rss_msgs/ArmMsg";
  static final java.lang.String _DEFINITION = "int32[8] pwms\n";
  int[] getPwms();
  void setPwms(int[] value);
}
