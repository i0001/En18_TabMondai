package com.example.tabmondai;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Fragment1 extends Fragment {
	//ファイル名
	private static final String FILE_NAME = "TabMondai";

	//onCreateメソッド
	@Override
	public View onCreateView(LayoutInflater inflater,
			ViewGroup container,
			Bundle savedInstanceState){
				return inflater.inflate(R.layout.fragment1, container,false);
	}

	//onStartメソッド（フラグメント表示前イベントハンドラ）
	@Override
	public void onStart() {
		//スーパークラスのonCreateメソッド呼び出し
		super.onStart();

		//ボタンオブジェクト取得
		Button button1 = (Button)getActivity().findViewById(R.id.bt_add);
		//ボタンオブジェクトにクリックリスナー設定
		button1.setOnClickListener(new ButtonClicListener());
	}

	public class ButtonClicListener implements OnClickListener {

		//onClickメソッド（ボタンクリック時イベントハンドラ）
		@Override
		public void onClick(View v) {
			//入力データ取得
			String name =((EditText)getActivity().findViewById(R.id.et_name)).getText().toString();
			String price =((EditText)getActivity().findViewById(R.id.et_price)).getText().toString();

			//ファイルに保存
			try {
				FileOutputStream stream
					= getActivity().openFileOutput(FILE_NAME, Context.MODE_APPEND);
				BufferedWriter out
					= new BufferedWriter(new OutputStreamWriter(stream));

				out.write(name+","+price);
				out.newLine();
				out.close();
			} catch (Exception e) {
				Log.e("FILE_ERROR", "ファイルの書き込みに失敗しました");
			}
		}

	}

}
