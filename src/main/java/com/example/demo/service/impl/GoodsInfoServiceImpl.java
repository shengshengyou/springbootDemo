package com.example.demo.service.impl;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.service.GoodsInfoService;
import com.example.demo.utils.Const;
import com.example.demo.utils.FileNameCreator;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

@Service
public class GoodsInfoServiceImpl implements GoodsInfoService {
	@Override
	public String doPutToFileServer(MultipartFile file) {
		String fileName = file.getOriginalFilename();
		String url = FileNameCreator.createRandomName(Const.FILE_SERVER_URL, fileName);
		Client client = new Client();
		WebResource resource = client.resource(url);
		try {
			byte[] buf = file.getBytes();
			resource.put(String.class,buf);
			return url;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
