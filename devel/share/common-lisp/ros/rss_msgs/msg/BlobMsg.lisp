; Auto-generated. Do not edit!


(cl:in-package rss_msgs-msg)


;//! \htmlinclude BlobMsg.msg.html

(cl:defclass <BlobMsg> (roslisp-msg-protocol:ros-message)
  ((centroidX
    :reader centroidX
    :initarg :centroidX
    :type cl:float
    :initform 0.0)
   (centroidY
    :reader centroidY
    :initarg :centroidY
    :type cl:float
    :initform 0.0)
   (targetArea
    :reader targetArea
    :initarg :targetArea
    :type cl:float
    :initform 0.0)
   (targetRange
    :reader targetRange
    :initarg :targetRange
    :type cl:float
    :initform 0.0)
   (targetBearing
    :reader targetBearing
    :initarg :targetBearing
    :type cl:float
    :initform 0.0))
)

(cl:defclass BlobMsg (<BlobMsg>)
  ())

(cl:defmethod cl:initialize-instance :after ((m <BlobMsg>) cl:&rest args)
  (cl:declare (cl:ignorable args))
  (cl:unless (cl:typep m 'BlobMsg)
    (roslisp-msg-protocol:msg-deprecation-warning "using old message class name rss_msgs-msg:<BlobMsg> is deprecated: use rss_msgs-msg:BlobMsg instead.")))

(cl:ensure-generic-function 'centroidX-val :lambda-list '(m))
(cl:defmethod centroidX-val ((m <BlobMsg>))
  (roslisp-msg-protocol:msg-deprecation-warning "Using old-style slot reader rss_msgs-msg:centroidX-val is deprecated.  Use rss_msgs-msg:centroidX instead.")
  (centroidX m))

(cl:ensure-generic-function 'centroidY-val :lambda-list '(m))
(cl:defmethod centroidY-val ((m <BlobMsg>))
  (roslisp-msg-protocol:msg-deprecation-warning "Using old-style slot reader rss_msgs-msg:centroidY-val is deprecated.  Use rss_msgs-msg:centroidY instead.")
  (centroidY m))

(cl:ensure-generic-function 'targetArea-val :lambda-list '(m))
(cl:defmethod targetArea-val ((m <BlobMsg>))
  (roslisp-msg-protocol:msg-deprecation-warning "Using old-style slot reader rss_msgs-msg:targetArea-val is deprecated.  Use rss_msgs-msg:targetArea instead.")
  (targetArea m))

(cl:ensure-generic-function 'targetRange-val :lambda-list '(m))
(cl:defmethod targetRange-val ((m <BlobMsg>))
  (roslisp-msg-protocol:msg-deprecation-warning "Using old-style slot reader rss_msgs-msg:targetRange-val is deprecated.  Use rss_msgs-msg:targetRange instead.")
  (targetRange m))

(cl:ensure-generic-function 'targetBearing-val :lambda-list '(m))
(cl:defmethod targetBearing-val ((m <BlobMsg>))
  (roslisp-msg-protocol:msg-deprecation-warning "Using old-style slot reader rss_msgs-msg:targetBearing-val is deprecated.  Use rss_msgs-msg:targetBearing instead.")
  (targetBearing m))
(cl:defmethod roslisp-msg-protocol:serialize ((msg <BlobMsg>) ostream)
  "Serializes a message object of type '<BlobMsg>"
  (cl:let ((bits (roslisp-utils:encode-single-float-bits (cl:slot-value msg 'centroidX))))
    (cl:write-byte (cl:ldb (cl:byte 8 0) bits) ostream)
    (cl:write-byte (cl:ldb (cl:byte 8 8) bits) ostream)
    (cl:write-byte (cl:ldb (cl:byte 8 16) bits) ostream)
    (cl:write-byte (cl:ldb (cl:byte 8 24) bits) ostream))
  (cl:let ((bits (roslisp-utils:encode-single-float-bits (cl:slot-value msg 'centroidY))))
    (cl:write-byte (cl:ldb (cl:byte 8 0) bits) ostream)
    (cl:write-byte (cl:ldb (cl:byte 8 8) bits) ostream)
    (cl:write-byte (cl:ldb (cl:byte 8 16) bits) ostream)
    (cl:write-byte (cl:ldb (cl:byte 8 24) bits) ostream))
  (cl:let ((bits (roslisp-utils:encode-single-float-bits (cl:slot-value msg 'targetArea))))
    (cl:write-byte (cl:ldb (cl:byte 8 0) bits) ostream)
    (cl:write-byte (cl:ldb (cl:byte 8 8) bits) ostream)
    (cl:write-byte (cl:ldb (cl:byte 8 16) bits) ostream)
    (cl:write-byte (cl:ldb (cl:byte 8 24) bits) ostream))
  (cl:let ((bits (roslisp-utils:encode-single-float-bits (cl:slot-value msg 'targetRange))))
    (cl:write-byte (cl:ldb (cl:byte 8 0) bits) ostream)
    (cl:write-byte (cl:ldb (cl:byte 8 8) bits) ostream)
    (cl:write-byte (cl:ldb (cl:byte 8 16) bits) ostream)
    (cl:write-byte (cl:ldb (cl:byte 8 24) bits) ostream))
  (cl:let ((bits (roslisp-utils:encode-single-float-bits (cl:slot-value msg 'targetBearing))))
    (cl:write-byte (cl:ldb (cl:byte 8 0) bits) ostream)
    (cl:write-byte (cl:ldb (cl:byte 8 8) bits) ostream)
    (cl:write-byte (cl:ldb (cl:byte 8 16) bits) ostream)
    (cl:write-byte (cl:ldb (cl:byte 8 24) bits) ostream))
)
(cl:defmethod roslisp-msg-protocol:deserialize ((msg <BlobMsg>) istream)
  "Deserializes a message object of type '<BlobMsg>"
    (cl:let ((bits 0))
      (cl:setf (cl:ldb (cl:byte 8 0) bits) (cl:read-byte istream))
      (cl:setf (cl:ldb (cl:byte 8 8) bits) (cl:read-byte istream))
      (cl:setf (cl:ldb (cl:byte 8 16) bits) (cl:read-byte istream))
      (cl:setf (cl:ldb (cl:byte 8 24) bits) (cl:read-byte istream))
    (cl:setf (cl:slot-value msg 'centroidX) (roslisp-utils:decode-single-float-bits bits)))
    (cl:let ((bits 0))
      (cl:setf (cl:ldb (cl:byte 8 0) bits) (cl:read-byte istream))
      (cl:setf (cl:ldb (cl:byte 8 8) bits) (cl:read-byte istream))
      (cl:setf (cl:ldb (cl:byte 8 16) bits) (cl:read-byte istream))
      (cl:setf (cl:ldb (cl:byte 8 24) bits) (cl:read-byte istream))
    (cl:setf (cl:slot-value msg 'centroidY) (roslisp-utils:decode-single-float-bits bits)))
    (cl:let ((bits 0))
      (cl:setf (cl:ldb (cl:byte 8 0) bits) (cl:read-byte istream))
      (cl:setf (cl:ldb (cl:byte 8 8) bits) (cl:read-byte istream))
      (cl:setf (cl:ldb (cl:byte 8 16) bits) (cl:read-byte istream))
      (cl:setf (cl:ldb (cl:byte 8 24) bits) (cl:read-byte istream))
    (cl:setf (cl:slot-value msg 'targetArea) (roslisp-utils:decode-single-float-bits bits)))
    (cl:let ((bits 0))
      (cl:setf (cl:ldb (cl:byte 8 0) bits) (cl:read-byte istream))
      (cl:setf (cl:ldb (cl:byte 8 8) bits) (cl:read-byte istream))
      (cl:setf (cl:ldb (cl:byte 8 16) bits) (cl:read-byte istream))
      (cl:setf (cl:ldb (cl:byte 8 24) bits) (cl:read-byte istream))
    (cl:setf (cl:slot-value msg 'targetRange) (roslisp-utils:decode-single-float-bits bits)))
    (cl:let ((bits 0))
      (cl:setf (cl:ldb (cl:byte 8 0) bits) (cl:read-byte istream))
      (cl:setf (cl:ldb (cl:byte 8 8) bits) (cl:read-byte istream))
      (cl:setf (cl:ldb (cl:byte 8 16) bits) (cl:read-byte istream))
      (cl:setf (cl:ldb (cl:byte 8 24) bits) (cl:read-byte istream))
    (cl:setf (cl:slot-value msg 'targetBearing) (roslisp-utils:decode-single-float-bits bits)))
  msg
)
(cl:defmethod roslisp-msg-protocol:ros-datatype ((msg (cl:eql '<BlobMsg>)))
  "Returns string type for a message object of type '<BlobMsg>"
  "rss_msgs/BlobMsg")
(cl:defmethod roslisp-msg-protocol:ros-datatype ((msg (cl:eql 'BlobMsg)))
  "Returns string type for a message object of type 'BlobMsg"
  "rss_msgs/BlobMsg")
(cl:defmethod roslisp-msg-protocol:md5sum ((type (cl:eql '<BlobMsg>)))
  "Returns md5sum for a message object of type '<BlobMsg>"
  "be4448f231e0d35f6995beab99ac5278")
(cl:defmethod roslisp-msg-protocol:md5sum ((type (cl:eql 'BlobMsg)))
  "Returns md5sum for a message object of type 'BlobMsg"
  "be4448f231e0d35f6995beab99ac5278")
(cl:defmethod roslisp-msg-protocol:message-definition ((type (cl:eql '<BlobMsg>)))
  "Returns full string definition for message of type '<BlobMsg>"
  (cl:format cl:nil "float32 centroidX~%float32 centroidY~%float32 targetArea~%float32 targetRange~%float32 targetBearing~%~%~%"))
(cl:defmethod roslisp-msg-protocol:message-definition ((type (cl:eql 'BlobMsg)))
  "Returns full string definition for message of type 'BlobMsg"
  (cl:format cl:nil "float32 centroidX~%float32 centroidY~%float32 targetArea~%float32 targetRange~%float32 targetBearing~%~%~%"))
(cl:defmethod roslisp-msg-protocol:serialization-length ((msg <BlobMsg>))
  (cl:+ 0
     4
     4
     4
     4
     4
))
(cl:defmethod roslisp-msg-protocol:ros-message-to-list ((msg <BlobMsg>))
  "Converts a ROS message object to a list"
  (cl:list 'BlobMsg
    (cl:cons ':centroidX (centroidX msg))
    (cl:cons ':centroidY (centroidY msg))
    (cl:cons ':targetArea (targetArea msg))
    (cl:cons ':targetRange (targetRange msg))
    (cl:cons ':targetBearing (targetBearing msg))
))
