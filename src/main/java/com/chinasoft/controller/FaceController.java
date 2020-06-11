package com.chinasoft.controller;


import com.baidu.aip.face.AipFace;
import com.chinasoft.config.FaceApiConfig;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import sun.misc.BASE64Encoder;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;


@Controller
public class FaceController {

    //人脸识别client
    private static AipFace client = FaceApiConfig.getClient();

    /*
    * 人脸注册
    * */
    @RequestMapping("/registerFace")
    public void registerByFace(MultipartFile face) throws IOException {

        HashMap<String, String> options = new HashMap<String, String>();
        options.put("max_face_num", "1");
        options.put("match_threshold", "80");
        options.put("quality_control", "NORMAL");
        options.put("liveness_control", "LOW");
        options.put("max_user_num", "1");

        //图像准成base64
        BASE64Encoder base64Encoder = new BASE64Encoder();
        String encode = null;
        InputStream in = null;
        byte[] data = null;
        try{
            in = face.getInputStream();
            data = new byte[in.available()];
            in.read(data);
            encode = base64Encoder.encode(data);
            in.close();
        }catch (IOException e){
            e.printStackTrace();
        }

        String image = encode;
        String imageType = "BASE64";
        String groupIdList = "group1";

        //人脸比对
        JSONObject res = client.search(image, imageType, groupIdList, options);
        String error = res.getString("error_msg");
        //解析json
        if(error.equals("SUCCESS")){
            JSONObject result =  res.getJSONObject("result");
            JSONArray user_list = result.getJSONArray("user_list");
            JSONObject list = user_list.getJSONObject(0);
            Double score = list.getDouble("score");
            System.out.println(score);
        }else{
            System.out.println("无");
        }


    }

    /*
    * 人脸比对登录
    * */
    @RequestMapping("/loginByFace")
    public void loginByFace(MultipartFile face){
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("max_face_num", "1");
        options.put("match_threshold", "80");
        options.put("quality_control", "NORMAL");
        options.put("liveness_control", "LOW");
        options.put("max_user_num", "1");

        BASE64Encoder base64Encoder = new BASE64Encoder();
        String encode = null;
        InputStream in = null;
        byte[] data = null;
        try{
            in = face.getInputStream();
            data = new byte[in.available()];
            in.read(data);
            encode = base64Encoder.encode(data);
            in.close();
        }catch (IOException e){
            e.printStackTrace();
        }

        String image = encode;
        String imageType = "BASE64";
        String groupIdList = "group1";

        JSONObject res = client.search(image, imageType, groupIdList, options);
        System.out.println(res.toString(2));
    }

}
