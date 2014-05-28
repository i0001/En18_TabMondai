package com.example.tabmondai;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		//アクションバーにタブ常時モード設定
		getActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		//tab1の設定
		ActionBar.Tab tab1 = getActionBar().newTab();
		tab1.setText("設定");
		tab1.setIcon(android.R.drawable.ic_menu_info_details);
		tab1.setTabListener(new TabMondaiListener(new Fragment1()));

		ActionBar.Tab tab2 = getActionBar().newTab();
		tab2.setText("設定");
		tab2.setIcon(android.R.drawable.ic_menu_info_details);
		tab2.setTabListener(new TabMondaiListener(new Fragment2()));

		//各タブをアクションバーに設定
		getActionBar().addTab(tab1);
		getActionBar().addTab(tab2);
		}

	private class TabMondaiListener implements TabListener{

		private Fragment fragment;

		public TabMondaiListener(Fragment fragment) {
			this.fragment = fragment;
		}

		@Override
		public void onTabReselected(Tab tab, FragmentTransaction ft) {
			// TODO 自動生成されたメソッド・スタブ

		}

		@Override
		public void onTabSelected(Tab tab, FragmentTransaction ft) {
			//対象フラグメント追加
			ft.add(R.id.ll_tab, fragment);
		}

		@Override
		public void onTabUnselected(Tab tab, FragmentTransaction ft) {
			//対象フラグメント除去
			ft.remove(fragment);
		}
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
