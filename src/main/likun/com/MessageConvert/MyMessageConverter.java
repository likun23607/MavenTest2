package com.MessageConvert;

import com.SpringMVC.DemoObj;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * Created by Administrator on 2016/12/7.
 */
public class MyMessageConverter extends AbstractHttpMessageConverter<DemoObj>{

    public MyMessageConverter(){
        super(new MediaType("application","x-wisely", Charset.forName("UTF-8")));
    }

    protected DemoObj readInternal(Class<? extends DemoObj> aClass, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        String temp= StreamUtils.copyToString(inputMessage.getBody(),Charset.forName("UTF-8"));
        String[] tempArr=temp.split("-");
        return new DemoObj(new Long(tempArr[0]),tempArr[1]);
    }

    protected boolean supports(Class<?> aClass) {
        return DemoObj.class.isAssignableFrom(aClass);
    }


    protected void writeInternal(DemoObj obj, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        String out="hello:"+obj.getId()+"-"+obj.getName();
        outputMessage.getBody().write(out.getBytes());

    }

}
