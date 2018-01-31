package com.example.tcox.recyclercreation.viewholders;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tcox.recyclercreation.R;
import com.example.tcox.recyclercreation.interfaces.IEngineerClickedListener;
import com.example.tcox.recyclercreation.models.MobileEngineer;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.io.InputStream;

/**
 * Created by tcox on 12/1/17.
 */

public class EmployeeViewHolder extends RecyclerView.ViewHolder {

    private Context mContext;
    private ImageView mEmployeeAvatar;
    private TextView mEmployeeName;
    private TextView mEmployeeTitle;
    private TextView mEmployeeStartDate;
    private TextView mEmployeeProject;
    private TextView mBio;

    public EmployeeViewHolder(View itemView) {
        super(itemView);
        mContext = itemView.getContext();
        mEmployeeAvatar = (ImageView) itemView.findViewById(R.id.EmployeeAvatar);
        mEmployeeName = (TextView) itemView.findViewById(R.id.employeeName);
        mEmployeeTitle = (TextView) itemView.findViewById(R.id.employeeTitle);
        mEmployeeStartDate = (TextView) itemView.findViewById(R.id.employeeStartDate);
        mEmployeeProject = (TextView) itemView.findViewById(R.id.employeeProject);
        mBio = (TextView) itemView.findViewById(R.id.employeeBio);
    }

    public void bind(final MobileEngineer engineer, IEngineerClickedListener listener) {
        mEmployeeTitle.setText(engineer.getPosition());
        mEmployeeName.setText(engineer.getName());
        mEmployeeStartDate.setText(engineer.getStartDate());
        mEmployeeProject.setText(engineer.getProject());
        mBio.setText(engineer.getBio());
        Picasso.with(mContext).load(engineer.getAvatar()).into(mEmployeeAvatar);
        listener.onEngineerClicked(engineer);
    }
}