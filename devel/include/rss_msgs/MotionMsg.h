/* Software License Agreement (BSD License)
 *
 * Copyright (c) 2011, Willow Garage, Inc.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  * Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *  * Redistributions in binary form must reproduce the above
 *    copyright notice, this list of conditions and the following
 *    disclaimer in the documentation and/or other materials provided
 *    with the distribution.
 *  * Neither the name of Willow Garage, Inc. nor the names of its
 *    contributors may be used to endorse or promote products derived
 *    from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS
 * FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE
 * COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
 * BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
 * LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN
 * ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * Auto-generated by genmsg_cpp from file /home/team5/RSS-hydro/src/rss_msgs/msg/MotionMsg.msg
 *
 */


#ifndef RSS_MSGS_MESSAGE_MOTIONMSG_H
#define RSS_MSGS_MESSAGE_MOTIONMSG_H


#include <string>
#include <vector>
#include <map>

#include <ros/types.h>
#include <ros/serialization.h>
#include <ros/builtin_message_traits.h>
#include <ros/message_operations.h>


namespace rss_msgs
{
template <class ContainerAllocator>
struct MotionMsg_
{
  typedef MotionMsg_<ContainerAllocator> Type;

  MotionMsg_()
    : translationalVelocity(0.0)
    , rotationalVelocity(0.0)  {
    }
  MotionMsg_(const ContainerAllocator& _alloc)
    : translationalVelocity(0.0)
    , rotationalVelocity(0.0)  {
    }



   typedef double _translationalVelocity_type;
  _translationalVelocity_type translationalVelocity;

   typedef double _rotationalVelocity_type;
  _rotationalVelocity_type rotationalVelocity;




  typedef boost::shared_ptr< ::rss_msgs::MotionMsg_<ContainerAllocator> > Ptr;
  typedef boost::shared_ptr< ::rss_msgs::MotionMsg_<ContainerAllocator> const> ConstPtr;
  boost::shared_ptr<std::map<std::string, std::string> > __connection_header;

}; // struct MotionMsg_

typedef ::rss_msgs::MotionMsg_<std::allocator<void> > MotionMsg;

typedef boost::shared_ptr< ::rss_msgs::MotionMsg > MotionMsgPtr;
typedef boost::shared_ptr< ::rss_msgs::MotionMsg const> MotionMsgConstPtr;

// constants requiring out of line definition



template<typename ContainerAllocator>
std::ostream& operator<<(std::ostream& s, const ::rss_msgs::MotionMsg_<ContainerAllocator> & v)
{
ros::message_operations::Printer< ::rss_msgs::MotionMsg_<ContainerAllocator> >::stream(s, "", v);
return s;
}

} // namespace rss_msgs

namespace ros
{
namespace message_traits
{



// BOOLTRAITS {'IsFixedSize': True, 'IsMessage': True, 'HasHeader': False}
// {'rss_msgs': ['/home/team5/RSS-hydro/src/rss_msgs/msg']}

// !!!!!!!!!!! ['__class__', '__delattr__', '__dict__', '__doc__', '__eq__', '__format__', '__getattribute__', '__hash__', '__init__', '__module__', '__ne__', '__new__', '__reduce__', '__reduce_ex__', '__repr__', '__setattr__', '__sizeof__', '__str__', '__subclasshook__', '__weakref__', '_parsed_fields', 'constants', 'fields', 'full_name', 'has_header', 'header_present', 'names', 'package', 'parsed_fields', 'short_name', 'text', 'types']




template <class ContainerAllocator>
struct IsFixedSize< ::rss_msgs::MotionMsg_<ContainerAllocator> >
  : TrueType
  { };

template <class ContainerAllocator>
struct IsFixedSize< ::rss_msgs::MotionMsg_<ContainerAllocator> const>
  : TrueType
  { };

template <class ContainerAllocator>
struct IsMessage< ::rss_msgs::MotionMsg_<ContainerAllocator> >
  : TrueType
  { };

template <class ContainerAllocator>
struct IsMessage< ::rss_msgs::MotionMsg_<ContainerAllocator> const>
  : TrueType
  { };

template <class ContainerAllocator>
struct HasHeader< ::rss_msgs::MotionMsg_<ContainerAllocator> >
  : FalseType
  { };

template <class ContainerAllocator>
struct HasHeader< ::rss_msgs::MotionMsg_<ContainerAllocator> const>
  : FalseType
  { };


template<class ContainerAllocator>
struct MD5Sum< ::rss_msgs::MotionMsg_<ContainerAllocator> >
{
  static const char* value()
  {
    return "dcd1efab7b0193f9e7f726b14abbf015";
  }

  static const char* value(const ::rss_msgs::MotionMsg_<ContainerAllocator>&) { return value(); }
  static const uint64_t static_value1 = 0xdcd1efab7b0193f9ULL;
  static const uint64_t static_value2 = 0xe7f726b14abbf015ULL;
};

template<class ContainerAllocator>
struct DataType< ::rss_msgs::MotionMsg_<ContainerAllocator> >
{
  static const char* value()
  {
    return "rss_msgs/MotionMsg";
  }

  static const char* value(const ::rss_msgs::MotionMsg_<ContainerAllocator>&) { return value(); }
};

template<class ContainerAllocator>
struct Definition< ::rss_msgs::MotionMsg_<ContainerAllocator> >
{
  static const char* value()
  {
    return "float64 translationalVelocity\n\
float64 rotationalVelocity\n\
";
  }

  static const char* value(const ::rss_msgs::MotionMsg_<ContainerAllocator>&) { return value(); }
};

} // namespace message_traits
} // namespace ros

namespace ros
{
namespace serialization
{

  template<class ContainerAllocator> struct Serializer< ::rss_msgs::MotionMsg_<ContainerAllocator> >
  {
    template<typename Stream, typename T> inline static void allInOne(Stream& stream, T m)
    {
      stream.next(m.translationalVelocity);
      stream.next(m.rotationalVelocity);
    }

    ROS_DECLARE_ALLINONE_SERIALIZER;
  }; // struct MotionMsg_

} // namespace serialization
} // namespace ros

namespace ros
{
namespace message_operations
{

template<class ContainerAllocator>
struct Printer< ::rss_msgs::MotionMsg_<ContainerAllocator> >
{
  template<typename Stream> static void stream(Stream& s, const std::string& indent, const ::rss_msgs::MotionMsg_<ContainerAllocator>& v)
  {
    s << indent << "translationalVelocity: ";
    Printer<double>::stream(s, indent + "  ", v.translationalVelocity);
    s << indent << "rotationalVelocity: ";
    Printer<double>::stream(s, indent + "  ", v.rotationalVelocity);
  }
};

} // namespace message_operations
} // namespace ros

#endif // RSS_MSGS_MESSAGE_MOTIONMSG_H
