package lab5_msgs;

public interface ErrorMsg extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "lab5_msgs/ErrorMsg";
  static final java.lang.String _DEFINITION = "float64 translational\nfloat64 rotational\ntime stamp\n";
  double getTranslational();
  void setTranslational(double value);
  double getRotational();
  void setRotational(double value);
  org.ros.message.Time getStamp();
  void setStamp(org.ros.message.Time value);
}
