# BottomLayout
底部导航栏控件
## Gradel
 ### Add it in your root build.gradle at the end of repositories:
  ```
  allprojects {
	  repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
	}
   ```
  ### Add the dependency
  ```
  dependencies {
      implementation 'com.github.TongGuHermint:BottomLayout:v1.0.2'
	}
  ```
  ### Example
  ```
	//BottomLayout 设置
	BottomLayout bottomLayout = (BottomLayout)findViewById(R.id.bottomLayout);
	//字体颜色
	bottomLayout.setTextColor(R.color.text_normal,R.color.text_select);
	//底部横条颜色
	bottomLayout.setBottomViewColor(R.color.view_normal,R.color.view_select);

	//设置ItemData
	ArrayList<BottomItemDTO> items = new ArrayList();
	items.add(new BottomItemDTO("首页",R.drawable.bank_s,R.drawable.home_s));
	items.add(new BottomItemDTO("我的",R.drawable.food_n,R.drawable.food_s));
	//将ItemData给BottomLayout
	bottomLayout.initData(items);
  ```
