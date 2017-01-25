package com.example.ravi.materialspinner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ravi on 25-01-2017.
 */
public class CustomAdapter extends BaseAdapter
{
    List<Model>  stringArrayList=new ArrayList<>();
    LayoutInflater layoutInflater;

    public CustomAdapter(List<Model> stringArrayList, Context mContext) {
        this.stringArrayList = stringArrayList;
        this.mContext = mContext;
    }

    Context mContext;

    @Override
    public int getCount() {
        return stringArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return stringArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

           if (layoutInflater==null){
               layoutInflater= (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
           }
           if (view==null){
               view=layoutInflater.inflate(R.layout.spinner_layout,null);
           }
        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.init(ImageLoaderConfiguration.createDefault(mContext));


        ViewHolder holder = new ViewHolder();

        holder.textView = (TextView) view.findViewById(R.id.textView);
        holder.imageView = (ImageView) view.findViewById(R.id.imageView);
        Model model = stringArrayList.get(i);
        holder.textView.setText(model.getName());
        imageLoader.displayImage(model.getImage(),holder.imageView);
        return view;
    }


      public class ViewHolder{

           ImageView imageView;
           TextView textView;

      }


}




