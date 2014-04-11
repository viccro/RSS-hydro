package VisualServo;

import java.util.concurrent.ArrayBlockingQueue;

import org.ros.message.MessageListener;
import rss_msgs.MotionMsg;
import rss_msgs.BlobMsg;
import org.ros.namespace.GraphName;
import org.ros.node.AbstractNodeMain;
import org.ros.node.ConnectedNode;
import org.ros.node.Node;
import org.ros.node.topic.Publisher;
import org.ros.node.topic.Subscriber;

/**
 * 
 * @author previous TA's, prentice, vona
 *
 */
public class VisualServo extends AbstractNodeMain implements Runnable {

	private static final int width = 160;

	private static final int height = 120;

	Publisher<MotionMsg> motionPub;	//Initialize a publisher of type MotionMsg
	private float transVel;		
	private float rotVel;
	private float KpFwd = 2.0f;	//Gains for proportional velocity controllers
	private float KpRot = 0.01f;
	
	Publisher<BlobMsg> blobPub;

	/**
	 * <p>The blob tracker.</p>
-	 **/
	private BlobTracking blobTrack = null;

	private VisionGUI gui;
	private ArrayBlockingQueue<byte[]> visionImage = new ArrayBlockingQueue<byte[]>(
			1);

	protected boolean firstUpdate = true;

	public Subscriber<sensor_msgs.Image> vidSub;
	public Subscriber<rss_msgs.OdometryMsg> odoSub;


	/**
	 * <p>Create a new VisualServo object.</p>
	 */
	public VisualServo() {

		setInitialParams();

		gui = new VisionGUI();
	}

	protected void setInitialParams() {

	}

	/**
	 * <p>Handle a CameraMessage. Perform blob tracking and
	 * servo robot towards target.</p>
	 * 
	 * @param rawImage a received camera message
	 */
	public void handle(byte[] rawImage) {

		visionImage.offer(rawImage);
	}

	@Override
	public void run() {
		while (true) {
			Image src = null;
			try {
				src = new Image(visionImage.take(), width, height);
			} catch (InterruptedException e) {
				e.printStackTrace();
				continue;
			}

			Image dest = new Image(src);

			blobTrack.apply(src, dest);

			// update newly formed vision message
			gui.setVisionImage(dest.toArray(), width, height);

			blobTrack.blobFix();
			//Publish known information about blob
			BlobMsg msgBlob= new blobPub.newMessage();
			
			msgBlob.setCentroidX ((float) blobTrack.centroidX);
			msgBlob.setCentroidY ((float) blobTrack.centroidY);
			msgBlob.setTargetArea ((float) blobTrack.targetArea);
			msgBlob.setTargetRange ((float) blobTrack.targetRange);
			msgBlob.setTargetBearing ((float) blobTrack.targetBearing);

			blobPub.publish(msgBlob);
			System.out.printf("Blob message was published.\n");

			//Proportional controllers
    			if (blobTrack.targetDetected == true)
			{
				if (blobTrack.targetRange > 3){ //cut out noise
					transVel = (float)0;
					rotVel = (float)0;
				}
				else{
					transVel = (float)(-1*KpFwd * (.5 - blobTrack.targetRange));    //Half meter from ball
					rotVel = (float)(KpRot * (0 - blobTrack.targetBearing));        //Ball centered on img
				}
				// publish velocity messages to move the robot towards the target
//				System.out.printf("Chasing the blob.\tSetting velocity: %f %f\n", transVel, rotVel); 

				MotionMsg msgVS= new motionPub.newMessage();
				msgVS.setTranslationalVelocity(transVel);
				msgVS.setRotationalVelocity(rotVel);	
				motionPub.publish(msgVS);
			}
		}
	}

	/**
	 * <p>
	 * Run the VisualServo process
	 * </p>
	 * 
	 * @param node optional command-line argument containing hostname
	 */
	@Override
	public void onStart(ConnectedNode node) {
		blobTrack = new BlobTracking(width, height);

		// set parameters on blobTrack as you desire
		// initialize the ROS publication to command/Motors
		motionPub = node.newPublisher("command/Motors", "rss_msgs/MotionMsg"); //Set publisher configurations
		blobPub   = node.newPublisher("info/blob", "rss_msgs/BlobMsg");

		final boolean reverseRGB = node.getParameterTree().getBoolean("reverse_rgb", false);

		vidSub = node.newSubscriber("/rss/video", "sensor_msgs/Image");
		vidSub.addMessageListener(new MessageListener<sensor_msgs.Image>() {
			@Override
			public void onNewMessage(sensor_msgs.Image message) {
				byte[] rgbData;
				if (reverseRGB) {
					rgbData = Image.RGB2BGR(message.getData(),
							(int) message.getWidth(), (int) message.getHeight());
				}
				else {
					rgbData = message.getData();
				}
				assert ((int) message.getWidth() == width);
				assert ((int) message.getHeight() == height);
				handle(rgbData);
			}
		});

		odoSub = node.newSubscriber("/rss/odometry", "rss_msgs/OdometryMsg");
		odoSub
		.addMessageListener(new MessageListener<rss_msgs.OdometryMsg>() {
			@Override
			public void onNewMessage(
					rss_msgs.OdometryMsg message) {
				if (firstUpdate) {
					firstUpdate = false;
					gui.resetWorldToView(message.getX(), message.getY());
				}
				gui.setRobotPose(message.getX(), message.getY(), message.getTheta());
			}
		});
		Thread runningStuff = new Thread(this);
		runningStuff.start();
	}

// 	@Override
//	public void onShutdown(ConnectedNode node) {
//		if (node != null) {
//			node.shutdown();
//		}
//	}

//	@Override
//	public void onShutdownComplete(ConnectedNode node) {
//	}

	@Override
	public GraphName getDefaultNodeName() {
		return GraphName.of("rss/visualservo");
	}

}
