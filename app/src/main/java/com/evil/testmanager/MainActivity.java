package com.evil.testmanager;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener, SelectDialog.OnSelectListener{

    private Button   mBt;
    private EditText mEtInput;
    private EditText mEtAppName;
    private EditText mEtOutput;
    private Button   mBtDe;
    private Button   mBtEn;
    private Button   mBtShow;
    private String privateKey =
            "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAPyvJtdmtHQ9e" +
                    "+10dOpxx7pQw5Z//m0d3vyzEkTWZ+jfSOyq6By66kxxSjvF0thb" +
                    "/tgCPdwYxnb8KrH7mcuDkZ+JpenWhANvG32gXGI+VcdPRcCamjYUfDbt" +
                    "" + "" + "" + "" + "" + "" + "" + "" + "" + "" +
                    "+rvLP0AXcnYkotjb5/yPjKOfMozvKf76ZVxCncIV" +
                    "/XxyntraKxA5AgMBAAECgYAPsDxEIW9QzER2gMWFjNzut3b9UCMW2UTwAZo/xeQbtElN0Gqq5fwIFPyb63Nk1YlkFfeLQ8qGtq9b75gj555R3t/UwwEFXUIqYYyPXnADOziwqfzhhDBGDlZq62yvtAFx8S/GSf0s919tw+KLOmKH1QiHiaPgWZq2DRQ8cSkc9QJBAP75kNx72Q+MyPgT48c8oh//FvM+OVp4m5c5txvgc6RAh0ZU0XDmL78WjE29vjYRBsnWZt1/txo56Upf9lOSejsCQQD9szppFw2aicITflqquioz/+QPEkhIZz+SHZzSoJlyDaJzPeST/4m2c+FhaswFrhBQPqS6RyB4VM2+d8w3OcQbAkAMLmogTn5pQsWbLIAWVaw9MResmU1uKBLu36AC4e9EapzL3GOBLE4dp/sd/7GlrZyQagDSFjbuNtQRbJI9HeNfAkEA5aEvMmW6W3FrJ+fLOxLMFkr8aqPapyZFBQUmqALTQMeUjYis90RpqqpSirF2v4FgpLE+upicjC3+F/Mo9aeklwJBAKbZblFkS2ktCQUpxq3fZm/LB2TB0d+oySKQDQRv2CiZlUz4z4oxDgPBs9KntJE5S35E9JDhXeyTRV5M2sgkvOU=";
    private String publicKey  =
            "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQD8rybXZrR0PXvtdHTqcce6UMOWf/5tHd78sxJE1mfo30jsqugcuupMcUo7xdLYW/7YAj3cGMZ2/Cqx+5nLg5GfiaXp1oQDbxt9oFxiPlXHT0XAmpo2FHw27fq7yz9AF3J2JKLY2+f8j4yjnzKM7yn++mVcQp3CFf18cp7a2isQOQIDAQAB";


    private EditText mEtTime;
    private Button   mBtCreate1;
    private Button   mBtCreate2;

    private ArrayList<PName> mNames;
    private SelectDialog     mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        File file = new File(getFilesDir(),"save.ini");
        mNames = SaveUtils.get(file);
    }

    private void initView(){
        mBt = (Button) findViewById(R.id.bt);
        mEtInput = (EditText) findViewById(R.id.et_input);
        mEtAppName = (EditText) findViewById(R.id.et_appname);
        mEtOutput = (EditText) findViewById(R.id.et_output);
        mBtDe = (Button) findViewById(R.id.bt_de);
        mBtEn = (Button) findViewById(R.id.bt_en);
        mBtShow = (Button) findViewById(R.id.bt_show);
        mBt.setOnClickListener(this);
        mBtDe.setOnClickListener(this);
        mBtEn.setOnClickListener(this);
        mBtShow.setOnClickListener(this);
        mEtTime = (EditText) findViewById(R.id.et_time);
        mEtTime.setOnClickListener(this);
        mBtCreate1 = (Button) findViewById(R.id.bt_create1);
        mBtCreate1.setOnClickListener(this);
        mBtCreate2 = (Button) findViewById(R.id.bt_create2);
        mBtCreate2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.bt:
                try{
                    Map<String,Object> map = KeyStoreUtils.initRSAKey(1024);
                    String publicKey = KeyStoreUtils.getPublicKey(map);
                    String privateKey = KeyStoreUtils.getPrivateKey(map);
                    StringBuffer buffer = new StringBuffer("------公钥------\n");
                    buffer.append(publicKey);
                    buffer.append("------公钥------\n");
                    buffer.append("\n");
                    buffer.append("------私钥------\n");
                    buffer.append(privateKey);
                    buffer.append("------私钥------");
                    String text = buffer.toString();
                    mEtOutput.setText(text);
                    copy(text);
                    toast("已复制到粘贴板");
                }catch(Exception e){
                    e.printStackTrace();
                }
                break;
            case R.id.bt_de:
                //加密
                String s = mEtOutput.getText().toString();
                try{
                    String key = KeyStoreUtils
                            .encryptByPrivateKey(s,privateKey);
                    mEtOutput.setText(key);
                }catch(Exception e){
                    e.printStackTrace();
                }
                break;
            case R.id.bt_en:
                //解密
                String s1 = mEtOutput.getText().toString();
                try{
                    String key = KeyStoreUtils.decryptByPublicKey(s1,publicKey);
                    mEtOutput.setText(key);
                }catch(Exception e){
                    e.printStackTrace();
                }
                break;
            case R.id.bt_create1:
                create(true);
                break;
            case R.id.bt_create2:
                create(false);
                break;
            case R.id.bt_show:
                if(mNames != null && mNames.size() > 0){
                    if(mDialog == null){
                        mDialog = new SelectDialog(this);
                        mDialog.setOnSelectListener(this);
                    }
                    mDialog.setNames(mNames);
                    mDialog.show();
                }else{
                    Toast.makeText(this,"暂无历史记录",Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    private void create(boolean isS){
        if(checkPackage()){
            if(checkTime()){
                //格式为:包名&$&生成的时间戳&$&校验过期时间&$&最终的过期时间&$&校验码
                //校验码为生成的时间戳%100+校验过期时间%20
                //1.包名
                StringBuffer buffer = new StringBuffer(getP());
                buffer.append("&%&");
                long lng = System.currentTimeMillis();
                //2.生成时间戳
                buffer.append(lng);
                buffer.append("&%&");
                //3.校验过期时间
                long time = getT(isS);
                buffer.append(time);
                buffer.append("&%&");
                //4.最终的过期时间
                long millis = lng + time;
                buffer.append(millis);
                buffer.append("&%&");
                //5.校验码
                long code = lng % 100 + time % 20;
                buffer.append(code);

                try{
                    String key = KeyStoreUtils
                            .encryptByPrivateKey(buffer.toString(),privateKey);
                    mEtOutput.setText(key);
                    copy(key);
                    toast("已复制到粘贴板");
                    addPname();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }else{
                toast("请输入时间");
            }
        }else{
            toast("请输入包名");
        }
    }

    private void copy(String text){
        ClipboardManager clipboard = (ClipboardManager) getSystemService(
                Context.CLIPBOARD_SERVICE);
        clipboard.setPrimaryClip(ClipData.newPlainText("text",text));
    }

    private void toast(String s){
        Toast.makeText(this,s,Toast.LENGTH_SHORT).show();
    }

    private boolean checkPackage(){
        String s = mEtInput.getText().toString();
        if(s == null || "".equals(s)){
            return false;
        }
        return true;
    }

    private boolean checkTime(){
        String s = mEtTime.getText().toString();
        if(s == null || "".equals(s)){
            return false;
        }
        return true;
    }

    private String getP(){
        return mEtInput.getText().toString();
    }

    private long getT(boolean isS){
        String s = mEtTime.getText().toString();
        long time;
        if(isS){
            //以秒为单位
            time = Long.valueOf(s);
            time = time * 1000;
        }else{
            time = Long.valueOf(s);
            time = time * 1000 * 60 * 60 * 24;
        }
        return time;
    }

    private void addPname(){
        String p = getP();
        PName pName = null;
        String appName = mEtAppName.getText().toString();
        if(mNames == null){
            mNames = new ArrayList<>();
        }
        if(mNames != null){
            for(PName name : mNames){
                if(p.equals(name.getPackageName())){
                    name.setAppName(appName);
                    pName = name;
                }
            }
        }
        if(pName == null){
            pName = new PName(appName,p);
            mNames.add(pName);
        }

        File file = new File(getFilesDir(),"save.ini");
        SaveUtils.save(file,mNames);
    }

    @Override
    public void select(PName pName){
        mEtAppName.setText(pName.getAppName());
        mEtInput.setText(pName.getPackageName());
    }
}
