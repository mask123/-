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
		
		DigestUtils.md5("");//¼ÓÃÜ-MD5
		
		//×Ö·û´®¹¤¾ß·Ç¿ÕÅÐ¶Ï null "" "  "
		StringUtils.isBlank("");//·Ç¿ÕÅÐ¶Ïtrue
		
		StringUtils.isNotBlank("");//false
		
		//×Ö·û´®Ìæ»»
		String info = "pppNUMDDppppp";
		info = StringUtils.replaceEach(info, new String[]{"NUMDD"}, new String[]{"1"});
		
		//×Ö·û´®µÄ½ØÈ¡
		info="<body>----</body>";
		StringUtils.substringBetween(info, "<body>", "</body>");
	}

}
