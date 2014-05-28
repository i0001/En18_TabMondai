package com.example.tabmondai;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class Fragment2 extends Fragment {
	//ファイル名
		private static final String FILE_NAME = "TabMondai";
		//onCreateメソッド
		@Override
		public View onCreateView(LayoutInflater inflater,
				ViewGroup container,
				Bundle savedInstanceState){
					return inflater.inflate(R.layout.fragment2, container,false);
		}
		//onStartメソッド（フラグメント表示前イベントハンドラ）
		@Override
		public void onStart() {
			//スーパークラスのonCreateメソッド呼び出し
			super.onStart();

			//テーブルレイアウトオブジェクト取得
			TableLayout tablelayout
				= (TableLayout)getActivity().findViewById(R.id.tl_tab2);

			//テーブルレイアウトのクリア
			//なんでクリアするんだろう？
			tablelayout.removeAllViews();

			//テーブルレイアウトの表示範囲を設定
			tablelayout.setStretchAllColumns(true);

			//テーブル一覧のヘッダ部設定
			TextView headtxt1 = new TextView(getActivity());
			headtxt1.setText("商品名");
			headtxt1.setGravity(Gravity.CENTER_HORIZONTAL);
			headtxt1.setWidth(100);
			TextView headtxt2 = new TextView(getActivity());
			headtxt2.setText("価格");
			headtxt2.setGravity(Gravity.CENTER_HORIZONTAL);
			headtxt2.setWidth(60);

			TableRow headrow = new TableRow(getActivity());
			headrow.addView(headtxt1);
			headrow.addView(headtxt2);
			tablelayout.addView(headrow);

			//ファイルからデータ取得
			try {
				FileInputStream stream = getActivity().openFileInput(FILE_NAME);
				BufferedReader in
					= new BufferedReader(new InputStreamReader(stream));

				String line ="";
				while((line = in.readLine())!=null){
					String lineSplit[] = line.split(",");

					TextView nametxt = new TextView(getActivity());
					nametxt.setGravity(Gravity.CENTER_HORIZONTAL);
					nametxt.setText(lineSplit[0]);

					TextView pricetxt = new TextView(getActivity());
					nametxt.setGravity(Gravity.CENTER_HORIZONTAL);
					nametxt.setText(lineSplit[1]);

					TableRow row = new TableRow(getActivity());
					row.addView(nametxt);
					row.addView(pricetxt);
					tablelayout.addView(row);
				}
				in.close();
			} catch (Exception e) {
				Log.e("ERROR", "file access error");
			}

		}

}
