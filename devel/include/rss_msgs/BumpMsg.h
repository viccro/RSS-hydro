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
 * Auto-generated by genmsg_cpp from file /home/team5/RSS-hydro/src/rss_msgs/msg/BumpMsg.msg
 *
 */


#ifndef RSS_MSGS_MESSAGE_BUMPMSG_H
#define RSS_MSGS_MESSAGE_BUMPMSG_H


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
struct BumpMsg_
{
  typedef BumpMsg_<ContainerAllocator> Type;

  BumpMsg_()
    : left(false)
    , right(false)  {
    }
  BumpMsg_(const ContainerAllocator& _alloc)
    : left(false)
    , right(false)  {
    }



   typedef uint8_t _left_type;
  _left_type left;

   typedef uint8_t _right_type;
  _right_type right;




  typedef boost::shared_ptr< ::rss_msgs::BumpMsg_<ContainerAllocator> > Ptr;
  typedef boost::shared_ptr< ::rss_msgs::BumpMsg_<ContainerAllocator> const> ConstPtr;
  boost::shared_ptr<std::map<std::string, std::string> > __connection_header;

}; // struct BumpMsg_

typedef ::rss_msgs::BumpMsg_<std::allocator<void> > BumpMsg;

typedef boost::shared_ptr< ::rss_msgs::BumpMsg > BumpMsgPtr;
typedef boost::shared_ptr< ::rss_msgs::BumpMsg const> BumpMsgConstPtr;

// constants requiring out of line definition



template<typename ContainerAllocator>
std::ostream& operator<<(std::ostream& s, const ::rss_msgs::BumpMsg_<ContainerAllocator> & v)
{
ros::message_operations::Printer< ::rss_msgs::BumpMsg_<ContainerAllocator> >::stream(s, "", v);
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
struct IsFixedSize< ::rss_msgs::BumpMsg_<ContainerAllocator> >
  : TrueType
  { };

template <class ContainerAllocator>
struct IsFixedSize< ::rss_msgs::BumpMsg_<ContainerAllocator> const>
  : TrueType
  { };

template <class ContainerAllocator>
struct IsMessage< ::rss_msgs::BumpMsg_<ContainerAllocator> >
  : TrueType
  { };

template <class ContainerAllocator>
struct IsMessage< ::rss_msgs::BumpMsg_<ContainerAllocator> const>
  : TrueType
  { };

template <class ContainerAllocator>
struct HasHeader< ::rss_msgs::BumpMsg_<ContainerAllocator> >
  : FalseType
  { };

template <class ContainerAllocator>
struct HasHeader< ::rss_msgs::BumpMsg_<ContainerAllocator> const>
  : FalseType
  { };


template<class ContainerAllocator>
struct MD5Sum< ::rss_msgs::BumpMsg_<ContainerAllocator> >
{
  static const char* value()
  {
    return "0544cac0b98e92509d14f758d50cf24b";
  }

  static const char* value(const ::rss_msgs::BumpMsg_<ContainerAllocator>&) { return value(); }
  static const uint64_t static_value1 = 0x0544cac0b98e9250ULL;
  static const uint64_t static_value2 = 0x9d14f758d50cf24bULL;
};

template<class ContainerAllocator>
struct DataType< ::rss_msgs::BumpMsg_<ContainerAllocator> >
{
  static const char* value()
  {
    return "rss_msgs/BumpMsg";
  }

  static const char* value(const ::rss_msgs::BumpMsg_<ContainerAllocator>&) { return value(); }
};

template<class ContainerAllocator>
struct Definition< ::rss_msgs::BumpMsg_<ContainerAllocator> >
{
  static const char* value()
  {
    return "bool left\n\
bool right\n\
";
  }

  static const char* value(const ::rss_msgs::BumpMsg_<ContainerAllocator>&) { return value(); }
};

} // namespace message_traits
} // namespace ros

namespace ros
{
namespace serialization
{

  template<class ContainerAllocator> struct Serializer< ::rss_msgs::BumpMsg_<ContainerAllocator> >
  {
    template<typename Stream, typename T> inline static void allInOne(Stream& stream, T m)
    {
      stream.next(m.left);
      stream.next(m.right);
    }

    ROS_DECLARE_ALLINONE_SERIALIZER;
  }; // struct BumpMsg_

} // namespace serialization
} // namespace ros

namespace ros
{
namespace message_operations
{

template<class ContainerAllocator>
struct Printer< ::rss_msgs::BumpMsg_<ContainerAllocator> >
{
  template<typename Stream> static void stream(Stream& s, const std::string& indent, const ::rss_msgs::BumpMsg_<ContainerAllocator>& v)
  {
    s << indent << "left: ";
    Printer<uint8_t>::stream(s, indent + "  ", v.left);
    s << indent << "right: ";
    Printer<uint8_t>::stream(s, indent + "  ", v.right);
  }
};

} // namespace message_operations
} // namespace ros

#endif // RSS_MSGS_MESSAGE_BUMPMSG_H
