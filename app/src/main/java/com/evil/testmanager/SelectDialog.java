package com.evil.testmanager;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;

/**
 * @name： TestManager
 * @package： com.evil.testmanager
 * @author: Noah.冯 QQ:1066537317
 * @time: 14:01
 * @version: 1.1
 * @desc： TODO
 */

public class SelectDialog extends Dialog
        implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    private ListView         mLv;
    private OnSelectListener mOnSelectListener;
    private ArrayList<PName> mNames;

    public SelectDialog(@NonNull Context context){
        super(context);
        init();
    }

    public SelectDialog(@NonNull Context context,int themeResId){
        super(context,themeResId);
        init();
    }

    protected SelectDialog(@NonNull Context context,boolean cancelable,
                           @Nullable OnCancelListener cancelListener){
        super(context,cancelable,cancelListener);
        init();
    }

    private void init(){
        View view = View.inflate(getContext(),R.layout.dialog_select,null);
        mLv = (ListView) view.findViewById(R.id.lv);
        mLv.setAdapter(mAdapter);
        mLv.setOnItemClickListener(this);
        mLv.setOnItemLongClickListener(this);
        setContentView(view);
        //设置window背景，默认的背景会有Padding值，不能全屏。当然不一定要是透明，你可以设置其他背景，替换默认的背景即可。
//        Window window = getWindow();
//        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//
//        WindowManager wm = window.getWindowManager();
//        int width = wm.getDefaultDisplay().getWidth();
//        int height = wm.getDefaultDisplay().getHeight();
//        //一定要在setContentView之后调用，否则无效
//        window.setLayout((int) (width - width * 0.15),(int) (height * 0.5));
//        window.setGravity(Gravity.CENTER);
    }

    public ArrayList<PName> getNames(){
        return mNames;
    }

    public void setNames(ArrayList<PName> names){
        mNames = names;
        mAdapter.notifyDataSetChanged();
    }

    public void setOnSelectListener(OnSelectListener onSelectListener){
        mOnSelectListener = onSelectListener;
    }

    private BaseAdapter mAdapter = new BaseAdapter(){
        @Override
        public int getCount(){
            return mNames == null ? 0 : mNames.size();
        }

        @Override
        public Object getItem(int position){
            return null;
        }

        @Override
        public long getItemId(int position){
            return 0;
        }

        @Override
        public View getView(int position,View convertView,ViewGroup parent){
            ViewHolder holder;
            if(convertView == null){
                convertView = View
                        .inflate(getContext(),R.layout.item_dialog,null);
                holder = new ViewHolder(convertView);
                convertView.setTag(holder);
            }else{
                holder = (ViewHolder) convertView.getTag();
            }
            PName pName = mNames.get(position);
            holder.mTvName.setText(pName.getAppName());
            holder.mTvPack.setText(pName.getPackageName());
            return convertView;
        }
    };

    @Override
    public void onItemClick(AdapterView<?> parent,View view,int position,
                            long id){
        PName pName = mNames.get(position);
        mOnSelectListener.select(pName);
        dismiss();
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        mNames.remove(position);
        File file = new File(getContext().getFilesDir(),"save.ini");
        SaveUtils.save(file,mNames);
        return true;
    }

    public interface OnSelectListener{

        void select(PName pName);
    }

    public static class ViewHolder{

        public View     rootView;
        public TextView mTvName;
        public TextView mTvPack;

        public ViewHolder(View rootView){
            this.rootView = rootView;
            this.mTvName = (TextView) rootView.findViewById(R.id.tv_name);
            this.mTvPack = (TextView) rootView.findViewById(R.id.tv_pack);
        }

    }
}
