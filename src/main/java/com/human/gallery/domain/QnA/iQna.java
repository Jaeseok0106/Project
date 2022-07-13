package com.human.gallery.domain.QnA;

import java.util.ArrayList;

public interface iQna {
	ArrayList<qnaDTO> qnalist(); //qna 테이블 리스트
	int addqna(String title, String content, int writer); //qna게시판 add
	int upqna(String title, String content, int writer, int id); //게시판테이블 update
	int delqna(int id); //delete
	qnaDTO selqna(int id);
}