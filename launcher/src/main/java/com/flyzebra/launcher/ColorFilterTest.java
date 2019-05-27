package com.flyzebra.launcher;

/**
 * Author FlyZebra
 * 2019/5/27 9:52
 * Describ:
 **/
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;


public class ColorFilterTest extends Activity implements OnSeekBarChangeListener{
    private ImageView iv;
    private SeekBar redBar,greenBar,blueBar,alphaBar;
    private Canvas canvas;
    private Bitmap copyBitmap;
    private Bitmap baseBitmap;
    private Paint paint;
    private float redValue,greenValue,blueValue,alphaValue;//这些值都是通过SeekBar移动过程中而得到的变化的值
    //定义一个颜色矩阵,主要通过第一种方式改变颜色系数，来达到修改图片的颜色。
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        initView();

    }

    private void initView() {
        iv=(ImageView) findViewById(R.id.iv);
        redBar=(SeekBar) findViewById(R.id.red);
        greenBar=(SeekBar) findViewById(R.id.green);
        blueBar=(SeekBar) findViewById(R.id.blue);
        alphaBar=(SeekBar) findViewById(R.id.alpha);
        redBar.setOnSeekBarChangeListener(this);
        greenBar.setOnSeekBarChangeListener(this);
        blueBar.setOnSeekBarChangeListener(this);
        alphaBar.setOnSeekBarChangeListener(this);
        alphaBar.setProgress(100);
    }
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress,
                                  boolean fromUser) {
        if (fromUser) {
            float count=seekBar.getProgress()/50f;//因为使得拖动条的取值为0f-2f，符合矩阵中每个元素的取值
            switch (seekBar.getId()) {
                case R.id.red:
                    this.redValue=count;
                    break;
                case R.id.green:
                    this.greenValue=count;
                    break;
                case R.id.blue:
                    this.blueValue=count;
                    break;
                case R.id.alpha:
                    this.alphaValue=count;
                    break;
                default:
                    break;
            }
            initBitmap();
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }
    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    private void initBitmap() {
        //先加载出一张原图(baseBitmap)，然后复制出来新的图片(copyBitmap)来，因为andorid不允许对原图进行修改.
        baseBitmap=BitmapFactory.decodeResource(getResources(), R.drawable.test);
        //既然是复制一张与原图一模一样的图片那么这张复制图片的画纸的宽度和高度以及分辨率都要与原图一样,copyBitmap就为一张与原图相同尺寸分辨率的空白画纸
        copyBitmap=Bitmap.createBitmap(baseBitmap.getWidth(), baseBitmap.getHeight(), baseBitmap.getConfig());
        canvas=new Canvas(copyBitmap);//将画纸固定在画布上
        paint=new Paint();//实例画笔对象
        float[] colorArray=new float[]{
                redValue,0,0,0,0,
                0,greenValue,0,0,0,
                0,0,blueValue,0,0,
                0,0,0,alphaValue,0
        };
        ColorMatrix colorMatrix=new ColorMatrix(colorArray);//将保存的颜色矩阵的数组作为参数传入
        ColorMatrixColorFilter colorFilter=new ColorMatrixColorFilter(colorMatrix);//再把该colorMatrix作为参数传入来实例化ColorMatrixColorFilter
        paint.setColorFilter(colorFilter);//并把该过滤器设置给画笔
        canvas.drawBitmap(baseBitmap, new Matrix(), paint);//传如baseBitmap表示按照原图样式开始绘制，将得到是复制后的图片
        iv.setImageBitmap(copyBitmap);
    }
}