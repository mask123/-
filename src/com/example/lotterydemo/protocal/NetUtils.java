package com.example.lotterydemo.protocal;

import com.example.lotterydemo.GlobalParams;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.provider.Settings.Global;

public class NetUtils {

	/**
	 * �������
	 * 
	 * @return
	 */
	public static boolean checkNet(Context context) {

		// �ж��Ƿ�WiFI����
		boolean isWIFI = isWIFIConnection(context);
		// �ж��Ƿ�ΪMoblie����
		boolean isMOBLIE = isMOBLIEConnection(context);

		// ���moblie�����ӣ��ж����ĸ�APN��ѡ����
		if (isMOBLIE) {
			// APN��ѡ�У��Ĵ�����Ϣ�Ƿ������ݣ������wap����
			readAPN(context);
		}
		if (!isWIFI && !isMOBLIE) {
			return false;
		}

		return true;
	}

	/**
	 * // ���moblie�����ӣ��ж����ĸ�APN��ѡ����
	 */
	private static void readAPN(Context context) {
		Uri PREFERRED_APN_URI = Uri
				.parse("content://telephony/carriers/preferapn");//4.0���ε���Ȩ��
		// ������ϵ��
		ContentResolver resolver = context.getContentResolver();
		// �ж����ĸ�APN��ѡ����
		Cursor cursor = resolver.query(PREFERRED_APN_URI, null, null, null, null);
		if(cursor!=null&&cursor.moveToFirst()){
			GlobalParams.PROXY = cursor.getString(cursor.getColumnIndex("proxy"));
			GlobalParams.PORT=cursor.getInt(cursor.getColumnIndex("port"));
		}

	}

	/**
	 * �ж��Ƿ�ΪMoblie����
	 * 
	 * @param context
	 * @return
	 */
	private static boolean isMOBLIEConnection(Context context) {

		ConnectivityManager manager = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkInfo = manager
				.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
		if (networkInfo != null) {
			return networkInfo.isConnected();
		}
		return false;
	}

	/**
	 * �ж��Ƿ�WiFI����
	 * 
	 * @param context
	 * @return
	 */
	private static boolean isWIFIConnection(Context context) {
		ConnectivityManager manager = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkInfo = manager
				.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
		if (networkInfo != null) {
			return networkInfo.isConnected();
		}
		return false;
	}
}
