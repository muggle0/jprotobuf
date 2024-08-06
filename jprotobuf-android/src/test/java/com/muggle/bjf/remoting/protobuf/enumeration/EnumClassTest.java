/**
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Baidu company (the "License");
 * you may not use this file except in compliance with the License.
 *
 */
package com.muggle.bjf.remoting.protobuf.enumeration;

import java.io.IOException;

import com.muggle.bjf.remoting.protobuf.Codec;
import com.muggle.bjf.remoting.protobuf.ProtobufProxy;
import org.junit.Assert;
import org.junit.Test;

import com.muggle.bjf.remoting.protobuf.enumeration.EnumClass.EnumClassInternal;


/**
 * Test class for enum type
 *
 * @author xiemalin
 * @since 1.4.0
 */
public class EnumClassTest {

    @Test
    public void testEnum() throws IOException {
        
        
        Codec codec = ProtobufProxy.create(EnumPOJOClass.class);
        EnumPOJOClass ec = new EnumPOJOClass();
        ec.enumAttr = EnumAttrPOJO.INT;
        
        byte[] bytes = codec.encode(ec);
        
        EnumPOJOClass decode = (EnumPOJOClass) codec.decode(bytes);
        Assert.assertEquals(EnumAttrPOJO.INT, decode.enumAttr);
        
        byte[] byteArray = EnumClassInternal.newBuilder().setStatus(
                EnumClass.EnumAttr.INT).build().toByteArray();
        Assert.assertArrayEquals(bytes, byteArray);
        
        EnumClassInternal enumClass = EnumClass.EnumClassInternal.parseFrom(bytes);
 
        Assert.assertEquals(EnumClass.EnumAttr.INT, enumClass.getStatus());
    }
    
    @Test
    public void testEnum2() throws IOException {
        
        
        Codec codec = ProtobufProxy.create(EnumPOJOClass2.class);
        EnumPOJOClass2 ec = new EnumPOJOClass2();
        ec.setEnumAttr(EnumAttrPOJO.INT);
        
        byte[] bytes = codec.encode(ec);
        EnumPOJOClass2 decode = (EnumPOJOClass2) codec.decode(bytes);
        Assert.assertEquals(EnumAttrPOJO.INT, decode.getEnumAttr());
        
        byte[] byteArray = EnumClassInternal.newBuilder().setStatus(
                EnumClass.EnumAttr.INT).build().toByteArray();
        Assert.assertArrayEquals(bytes, byteArray);
        EnumClassInternal enumClass = EnumClass.EnumClassInternal.parseFrom(bytes);
 
        Assert.assertEquals(EnumClass.EnumAttr.INT, enumClass.getStatus());
    }
}
