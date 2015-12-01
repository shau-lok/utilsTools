public class MainActivity extends Activity {

 ViewAnimator viewAnimator;

 Animation slide_in_left, slide_out_right;

 @Override
 protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.activity_main);

  viewAnimator = (ViewAnimator)findViewById(R.id.viewanimator);

  slide_in_left = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
  slide_out_right = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);

   viewAnimator.setInAnimation(slide_in_left);
  viewAnimator.setOutAnimation(slide_out_right);


onclick(){
	
	// viewAnimator.showPrevious();   
	// viewAnimator.showNext();
}


}