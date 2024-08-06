/**
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Baidu company (the "License");
 * you may not use this file except in compliance with the License.
 *
 */
package com.muggle.bjf.remoting.protobuf.enumeration;

import com.muggle.bjf.remoting.protobuf.FieldType;
import com.muggle.bjf.remoting.protobuf.annotation.Protobuf;

/**
 * Simple pojo enumeration class
 * 
 * @author xiemalin
 * @since 1.4.0
 */
public class EnumPOJOClass {

    @Protobuf(fieldType = FieldType.ENUM)
    public EnumAttrPOJO enumAttr;
}
