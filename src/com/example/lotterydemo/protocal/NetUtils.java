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
	 * 检查网络
	 * 
	 * @return
	 */
	public static boolean checkNet(Context context) {

		// 判断是否WiFI网络
		boolean isWIFI = isWIFIConnection(context);
		// 判断是否为Moblie网络
		boolean isMOBLIE = isMOBLIEConnection(context);

		// 如果moblie在链接，判断是哪个APN被选中了
		if (isMOBLIE) {
			// APN被选中，的代理信息是否有内容，如果有wap方法
			readAPN(context);
		}
		if (!isWIFI && !isMOBLIE) {
			return false;
		}

		return true;
	}

	/**
	 * // 如果moblie在链接，判断是哪个APN被选中了
	 */
	private static void readAPN(Context context) {
		Uri PREFERRED_APN_URI = Uri
				.parse("content://telephony/carriers/preferapn");//4.0屏蔽掉该权限
		// 操作联系人
		ContentResolver resolver = context.getContentResolver();
		// 判断是哪个APN被选中了
		Cursor cursor = resolver.query(PREFERRED_APN_URI, null, null, null, null);
		if(cursor!=null&&cursor.moveToFirst()){
			GlobalParams.PROXY = cursor.getString(cursor.getColumnIndex("proxy"));
			GlobalParams.PORT=cursor.getInt(cursor.getColumnIndex("port"));
		}

	}

	/**
	 * 判断是否为Moblie网络
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
	 * 判断是否WiFI网络
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
