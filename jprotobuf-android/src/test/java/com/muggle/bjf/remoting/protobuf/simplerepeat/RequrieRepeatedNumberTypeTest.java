/**
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Baidu company (the "License");
 * you may not use this file except in compliance with the License.
 *
 */
package com.muggle.bjf.remoting.protobuf.simplerepeat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import com.muggle.bjf.remoting.protobuf.Codec;
import com.muggle.bjf.remoting.protobuf.ProtobufProxy;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author xiemalin
 *
 */
public class RequrieRepeatedNumberTypeTest {

    @Test
    public void testEncodeDecode() {
        
        RequrieRepeatedNumberType.InterClassName icn = RequrieRepeatedNumberType.InterClassName.newBuilder().addList3("a").addList3("b").build();
        
        byte[] oldbb = icn.toByteArray();
        System.out.println(Arrays.toString(oldbb));
        
        
        RequrieRepeatedNumberTypePOJOClass type = new RequrieRepeatedNumberTypePOJOClass();
        
        type.list3 = new ArrayList<String>();
        type.list3.add("a");
        type.list3.add("b");
        
        
        Codec proxy = ProtobufProxy.create(RequrieRepeatedNumberTypePOJOClass.class);
        try {
            byte[] bb = proxy.encode(type);
            Assert.assertArrayEquals(oldbb, bb);
            System.out.println(Arrays.toString(bb));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
