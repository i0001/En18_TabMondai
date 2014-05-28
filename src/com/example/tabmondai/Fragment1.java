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
	//�t�@�C����
	private static final String FILE_NAME = "TabMondai";

	//onCreate���\�b�h
	@Override
	public View onCreateView(LayoutInflater inflater,
			ViewGroup container,
			Bundle savedInstanceState){
				return inflater.inflate(R.layout.fragment1, container,false);
	}

	//onStart���\�b�h�i�t���O�����g�\���O�C�x���g�n���h���j
	@Override
	public void onStart() {
		//�X�[�p�[�N���X��onCreate���\�b�h�Ăяo��
		super.onStart();

		//�{�^���I�u�W�F�N�g�擾
		Button button1 = (Button)getActivity().findViewById(R.id.bt_add);
		//�{�^���I�u�W�F�N�g�ɃN���b�N���X�i�[�ݒ�
		button1.setOnClickListener(new ButtonClicListener());
	}

	public class ButtonClicListener implements OnClickListener {

		//onClick���\�b�h�i�{�^���N���b�N���C�x���g�n���h���j
		@Override
		public void onClick(View v) {
			//���̓f�[�^�擾
			String name =((EditText)getActivity().findViewById(R.id.et_name)).getText().toString();
			String price =((EditText)getActivity().findViewById(R.id.et_price)).getText().toString();

			//�t�@�C���ɕۑ�
			try {
				FileOutputStream stream
					= getActivity().openFileOutput(FILE_NAME, Context.MODE_APPEND);
				BufferedWriter out
					= new BufferedWriter(new OutputStreamWriter(stream));

				out.write(name+","+price);
				out.newLine();
				out.close();
			} catch (Exception e) {
				Log.e("FILE_ERROR", "�t�@�C���̏������݂Ɏ��s���܂���");
			}
		}

	}

}
