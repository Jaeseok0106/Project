package com.human.gallery.domain.QnA;

import java.util.ArrayList;

public interface iQna {
	ArrayList<qnaDTO> qnalist(); //qna ���̺� ����Ʈ
	int addqna(String title, String content, int writer); //qna�Խ��� add
	int upqna(String title, String content, int writer, int id); //�Խ������̺� update
	int delqna(int id); //delete
	qnaDTO selqna(int id);
}