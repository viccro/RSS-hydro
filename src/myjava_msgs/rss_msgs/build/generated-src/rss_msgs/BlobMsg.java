package rss_msgs;

public interface BlobMsg extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "rss_msgs/BlobMsg";
  static final java.lang.String _DEFINITION = "float32 centroidX\nfloat32 centroidY\nfloat32 targetArea\nfloat32 targetRange\nfloat32 targetBearing\n";
  float getCentroidX();
  void setCentroidX(float value);
  float getCentroidY();
  void setCentroidY(float value);
  float getTargetArea();
  void setTargetArea(float value);
  float getTargetRange();
  void setTargetRange(float value);
  float getTargetBearing();
  void setTargetBearing(float value);
}
