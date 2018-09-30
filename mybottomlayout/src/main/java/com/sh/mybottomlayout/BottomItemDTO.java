package com.sh.mybottomlayout;

/**
 * author： TongGuHermit
 * created on： 2018/9/30 11:02
 */

public class BottomItemDTO {
	private String itemText;
	private int NomalImage;
	private int SelectImage;

	public Boolean isSelect = false;

	public BottomItemDTO(String itemNomalText, int NomalImage, int SelectImage){
		setItemText(itemNomalText);
		setNomalImage(NomalImage);
		setSelectImage(SelectImage);
	}

	public int getNomalImage() {
		return NomalImage;
	}

	public int getSelectImage() {
		return SelectImage;
	}

	public void setNomalImage(int nomalImage) {
		NomalImage = nomalImage;
	}

	public void setSelectImage(int selectImage) {
		SelectImage = selectImage;
	}

	public String getItemText() {
		return itemText;
	}
	public void setItemText(String itemText) {
		this.itemText = itemText;
	}

}
