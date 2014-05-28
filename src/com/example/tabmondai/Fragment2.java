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
	//�t�@�C����
		private static final String FILE_NAME = "TabMondai";
		//onCreate���\�b�h
		@Override
		public View onCreateView(LayoutInflater inflater,
				ViewGroup container,
				Bundle savedInstanceState){
					return inflater.inflate(R.layout.fragment2, container,false);
		}
		//onStart���\�b�h�i�t���O�����g�\���O�C�x���g�n���h���j
		@Override
		public void onStart() {
			//�X�[�p�[�N���X��onCreate���\�b�h�Ăяo��
			super.onStart();

			//�e�[�u�����C�A�E�g�I�u�W�F�N�g�擾
			TableLayout tablelayout
				= (TableLayout)getActivity().findViewById(R.id.tl_tab2);

			//�e�[�u�����C�A�E�g�̃N���A
			//�Ȃ�ŃN���A����񂾂낤�H
			tablelayout.removeAllViews();

			//�e�[�u�����C�A�E�g�̕\���͈͂�ݒ�
			tablelayout.setStretchAllColumns(true);

			//�e�[�u���ꗗ�̃w�b�_���ݒ�
			TextView headtxt1 = new TextView(getActivity());
			headtxt1.setText("���i��");
			headtxt1.setGravity(Gravity.CENTER_HORIZONTAL);
			headtxt1.setWidth(100);
			TextView headtxt2 = new TextView(getActivity());
			headtxt2.setText("���i");
			headtxt2.setGravity(Gravity.CENTER_HORIZONTAL);
			headtxt2.setWidth(60);

			TableRow headrow = new TableRow(getActivity());
			headrow.addView(headtxt1);
			headrow.addView(headtxt2);
			tablelayout.addView(headrow);

			//�t�@�C������f�[�^�擾
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
