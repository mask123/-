package com.example.lotterydemo;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		DigestUtils.md5("");//����-MD5
		
		//�ַ������߷ǿ��ж� null "" "  "
		StringUtils.isBlank("");//�ǿ��ж�true
		
		StringUtils.isNotBlank("");//false
		
		//�ַ����滻
		String info = "pppNUMDDppppp";
		info = StringUtils.replaceEach(info, new String[]{"NUMDD"}, new String[]{"1"});
		
		//�ַ����Ľ�ȡ
		info="<body>----</body>";
		StringUtils.substringBetween(info, "<body>", "</body>");
	}

}
