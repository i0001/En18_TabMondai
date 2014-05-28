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

		//�A�N�V�����o�[�Ƀ^�u�펞���[�h�ݒ�
		getActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		//tab1�̐ݒ�
		ActionBar.Tab tab1 = getActionBar().newTab();
		tab1.setText("�ݒ�");
		tab1.setIcon(android.R.drawable.ic_menu_info_details);
		tab1.setTabListener(new TabMondaiListener(new Fragment1()));

		ActionBar.Tab tab2 = getActionBar().newTab();
		tab2.setText("�ݒ�");
		tab2.setIcon(android.R.drawable.ic_menu_info_details);
		tab2.setTabListener(new TabMondaiListener(new Fragment2()));

		//�e�^�u���A�N�V�����o�[�ɐݒ�
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
			// TODO �����������ꂽ���\�b�h�E�X�^�u

		}

		@Override
		public void onTabSelected(Tab tab, FragmentTransaction ft) {
			//�Ώۃt���O�����g�ǉ�
			ft.add(R.id.ll_tab, fragment);
		}

		@Override
		public void onTabUnselected(Tab tab, FragmentTransaction ft) {
			//�Ώۃt���O�����g����
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
